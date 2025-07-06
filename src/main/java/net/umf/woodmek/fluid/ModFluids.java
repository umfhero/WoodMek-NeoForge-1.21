package net.umf.woodmek.fluid;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.umf.woodmek.BlockMod;
import net.umf.woodmek.block.ModBlocks;
import net.umf.woodmek.item.ModItems;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(Registries.FLUID, BlockMod.MOD_ID);

    // Liquid Sap Fluid
    public static final DeferredHolder<Fluid, FlowingFluid> SOURCE_LIQUID_SAP_FLUID = FLUIDS.register("liquid_sap_fluid",
            () -> new BaseFlowingFluid.Source(ModFluids.LIQUID_SAP_FLUID_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_LIQUID_SAP_FLUID = FLUIDS.register("flowing_liquid_sap",
            () -> new BaseFlowingFluid.Flowing(ModFluids.LIQUID_SAP_FLUID_PROPERTIES));

    public static final BaseFlowingFluid.Properties LIQUID_SAP_FLUID_PROPERTIES = new BaseFlowingFluid.Properties(
            ModFluidTypes.LIQUID_SAP_FLUID_TYPE, SOURCE_LIQUID_SAP_FLUID, FLOWING_LIQUID_SAP_FLUID)
            .slopeFindDistance(3).levelDecreasePerBlock(2).block(ModBlocks.LIQUID_SAP_BLOCK).bucket(ModItems.LIQUID_SAP_BUCKET).tickRate(25);

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
