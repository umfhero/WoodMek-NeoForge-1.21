package net.umf.woodmek;

import net.minecraft.world.item.CreativeModeTabs;
import net.umf.woodmek.block.ModBlocks;
import net.umf.woodmek.block.component.ModDataComponents;
import net.umf.woodmek.chemical.ModChemicals;
import net.umf.woodmek.effect.ModEffects;
import net.umf.woodmek.fluid.ModFluidTypes;
import net.umf.woodmek.fluid.ModFluids;
import net.umf.woodmek.item.ModCreativeModeTabs;
import net.umf.woodmek.item.ModItems;
import net.umf.woodmek.sound.ModSounds;
import net.umf.woodmek.util.ModItemProperties;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(BlockMod.MOD_ID)
public class BlockMod {
    public static final String MOD_ID = "woodmek";
    private static final Logger LOGGER = LogUtils.getLogger();

    public BlockMod(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);
        ModCreativeModeTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModDataComponents.register(modEventBus);
        ModChemicals.register(modEventBus);
        net.umf.woodmek.entity.ModEntities.register(modEventBus);
        ModSounds.register(modEventBus);
        ModFluidTypes.register(modEventBus);
        ModFluids.register(modEventBus);
        modEventBus.addListener(this::addCreative);
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
        ModEffects.register(modEventBus);
    }

    private void commonSetup(FMLCommonSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            ModItemProperties.addCustomItemProperties();
        }

        @SubscribeEvent
        public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
            event.registerEntityRenderer(net.umf.woodmek.entity.ModEntities.FLARE.get(),
                net.umf.woodmek.entity.client.FlareRenderer::new);
        }
    }
}
