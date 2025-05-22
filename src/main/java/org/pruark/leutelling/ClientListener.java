package org.pruark.leutelling;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import org.pruark.leutelling.entities.MyEntityRenderer;
import org.pruark.leutelling.registry.EntityRegistry;

@EventBusSubscriber(
        modid = Leutelling.MODID,
        bus = Bus.MOD,
        value = {Dist.CLIENT}
)
public final class ClientListener {
    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityRegistry.MYENTITY.get(), MyEntityRenderer::new);

    }

}
