package org.pruark.leutelling.entities;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.pruark.leutelling.dialogue.DialogueScreen;
import org.pruark.leutelling.dialogue.SampleDialogue;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class MyEntity extends PathfinderMob implements GeoEntity {
    protected static final RawAnimation NEW_ANIM = RawAnimation.begin().thenLoop("animation.watcher.new");

    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);

    public MyEntity(EntityType<? extends MyEntity> type, Level level) {
        super(type, level);
    }

    @Override
    public void registerControllers(final AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "new", 5, this::newAnimController));
    }

    protected <E extends MyEntity> PlayState newAnimController(final AnimationState<E> event) {
        if (event.isMoving())
            return event.setAndContinue(NEW_ANIM);

        return PlayState.STOP;
    }

    // Определяем атрибуты сущности
    public static AttributeSupplier.Builder createAttributes() {
        return PathfinderMob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.3D)
                .add(Attributes.ATTACK_DAMAGE, 2.0D);
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.geoCache;
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        if (!this.level.isClientSide && hand == InteractionHand.MAIN_HAND) {
            // На сервере: просто успешное взаимодействие
            return InteractionResult.SUCCESS;
        }
        if (this.level.isClientSide && hand == InteractionHand.MAIN_HAND) {
            openDialogueScreen();
            return InteractionResult.SUCCESS;
        }
        return super.mobInteract(player, hand);
    }

    @OnlyIn(Dist.CLIENT)
    private void openDialogueScreen() {
        net.minecraft.client.Minecraft.getInstance().setScreen(
                new DialogueScreen(SampleDialogue.getDialogue())
        );
    }
}