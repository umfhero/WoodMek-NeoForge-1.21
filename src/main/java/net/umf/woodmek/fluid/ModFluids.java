package net.umf.woodmek.fluid;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.umf.woodmek.BlockMod;

public class ModFluids {
    public static final DeferredRegister<FluidType> FLUID_TYPES =
        DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, BlockMod.MOD_ID);

    public static final DeferredRegister<Fluid> FLUIDS =
        DeferredRegister.create(BuiltInRegistries.FLUID, BlockMod.MOD_ID);

    // Fluid Types with proper properties
    public static final DeferredHolder<FluidType, FluidType> WOOD_ESSENCE_FLUID_TYPE = FLUID_TYPES.register("wood_essence_fluid_type",
        () -> new FluidType(FluidType.Properties.create()
            .density(1500)
            .viscosity(1000)
            .temperature(300)));

    public static final DeferredHolder<FluidType, FluidType> ENRICHED_WOOD_ESSENCE_FLUID_TYPE = FLUID_TYPES.register("enriched_wood_essence_fluid_type",
        () -> new FluidType(FluidType.Properties.create()
            .density(1800)
            .viscosity(1200)
            .temperature(350)));

    // Fluids - register first
    public static final DeferredHolder<Fluid, FlowingFluid> WOOD_ESSENCE_FLUID = FLUIDS.register("wood_essence_fluid",
        () -> new BaseFlowingFluid.Source(getWoodEssenceProperties()));

    public static final DeferredHolder<Fluid, FlowingFluid> WOOD_ESSENCE_FLUID_FLOWING = FLUIDS.register("wood_essence_fluid_flowing",
        () -> new BaseFlowingFluid.Flowing(getWoodEssenceProperties()));

    public static final DeferredHolder<Fluid, FlowingFluid> ENRICHED_WOOD_ESSENCE_FLUID = FLUIDS.register("enriched_wood_essence_fluid",
        () -> new BaseFlowingFluid.Source(getEnrichedWoodEssenceProperties()));

    public static final DeferredHolder<Fluid, FlowingFluid> ENRICHED_WOOD_ESSENCE_FLUID_FLOWING = FLUIDS.register("enriched_wood_essence_fluid_flowing",
        () -> new BaseFlowingFluid.Flowing(getEnrichedWoodEssenceProperties()));

    // Helper methods to create properties - called at runtime to avoid forward reference
    private static BaseFlowingFluid.Properties getWoodEssenceProperties() {
        return new BaseFlowingFluid.Properties(
            WOOD_ESSENCE_FLUID_TYPE, WOOD_ESSENCE_FLUID, WOOD_ESSENCE_FLUID_FLOWING)
            .slopeFindDistance(2)
            .levelDecreasePerBlock(2);
    }

    private static BaseFlowingFluid.Properties getEnrichedWoodEssenceProperties() {
        return new BaseFlowingFluid.Properties(
            ENRICHED_WOOD_ESSENCE_FLUID_TYPE, ENRICHED_WOOD_ESSENCE_FLUID, ENRICHED_WOOD_ESSENCE_FLUID_FLOWING)
            .slopeFindDistance(2)
            .levelDecreasePerBlock(2);
    }

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
        FLUIDS.register(eventBus);
    }
}
