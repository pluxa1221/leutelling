package org.pruark.leutelling.registry;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.pruark.leutelling.Leutelling;
import org.pruark.leutelling.entities.MyEntity;
import software.bernie.example.entity.*;

public final class EntityRegistry {
    public static final DeferredRegister<EntityType<?>> ENTITIES;
    public static final RegistryObject<EntityType<MyEntity>> MYENTITY;

    public EntityRegistry() {
    }

    public static <T extends Mob> RegistryObject<EntityType<T>> registerMob(String name, EntityType.EntityFactory<T> entity, float width, float height, int primaryEggColor, int secondaryEggColor) {
        RegistryObject<EntityType<T>> entityType = ENTITIES.register(name, () -> EntityType.Builder.of(entity, MobCategory.CREATURE).sized(width, height).build(name));
        return entityType;
    }

    static {
        ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Leutelling.MODID);
        MYENTITY = registerMob("myentity", MyEntity::new, 0.7F, 1.9F, 2039583, 855309);
    }
}
