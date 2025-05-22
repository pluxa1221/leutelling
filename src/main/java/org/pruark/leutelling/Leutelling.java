package org.pruark.leutelling;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import org.pruark.leutelling.registry.EntityRegistry;
import software.bernie.geckolib.GeckoLib;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Leutelling.MODID)
public class Leutelling {

    // Define mod id in a common place for everything to reference
    public static final String MODID = "leutelling";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public Leutelling() {
        GeckoLib.initialize();

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        EntityRegistry.ENTITIES.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }
    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
//    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
//    public static class ClientModEvents {
//
//        @SubscribeEvent
//        public static void onClientSetup(FMLClientSetupEvent event)
//        {
//            // Some client setup code
//            LOGGER.info("HELLO FROM CLIENT SETUP");
//            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
//
////            EntityRenderers.register(ModEntities.MY.get(), MyEntityRenderer::new);
//            LOGGER.info("Hello");
//        }
//    }
}
