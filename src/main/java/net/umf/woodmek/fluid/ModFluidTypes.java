package net.umf.woodmek.fluid;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.umf.woodmek.BlockMod;
import org.jetbrains.annotations.NotNull;

public class ModFluidTypes {
    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, BlockMod.MOD_ID);

    public static final DeferredHolder<FluidType, FluidType> LIQUID_SAP_FLUID_TYPE = FLUID_TYPES.register("liquid_sap_fluid_type",
            () -> new FluidType(FluidType.Properties.create()));

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
        eventBus.addListener(ModFluidTypes::registerFluidTypeExtensions);
    }

    private static void registerFluidTypeExtensions(RegisterClientExtensionsEvent event) {
        event.registerFluidType(new IClientFluidTypeExtensions() {
            @Override
            public @NotNull ResourceLocation getStillTexture() {
                return ResourceLocation.fromNamespaceAndPath(BlockMod.MOD_ID, "block/liquid_sap_still");
            }

            @Override
            public @NotNull ResourceLocation getFlowingTexture() {
                return ResourceLocation.fromNamespaceAndPath(BlockMod.MOD_ID, "block/liquid_sap_flow");
            }
        }, LIQUID_SAP_FLUID_TYPE.get());
    }
}
