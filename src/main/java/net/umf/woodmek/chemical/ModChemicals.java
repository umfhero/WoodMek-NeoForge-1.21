package net.umf.woodmek.chemical;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.umf.woodmek.BlockMod;

public class ModChemicals {
    // TODO: Re-enable Mekanism integration when dependency is properly resolved
    // For now, we'll comment out the Mekanism-specific code to allow compilation

    /*
    // Wood essence as a gas (for oxidizing recipes)
    public static final DeferredRegister<Gas> GASES = DeferredRegister.create(MekanismAPI.GAS_REGISTRY_NAME, BlockMod.MOD_ID);
    public static final DeferredHolder<Gas, Gas> WOOD_ESSENCE_GAS = GASES.register("wood_essence", () -> new Gas(GasBuilder.builder().tint(0x8B4513)));

    // Enriched wood essence as an infuse type (for metallurgic infusing)
    public static final DeferredRegister<InfuseType> INFUSE_TYPES = DeferredRegister.create(MekanismAPI.INFUSE_TYPE_REGISTRY_NAME, BlockMod.MOD_ID);
    public static final DeferredHolder<InfuseType, InfuseType> ENRICHED_WOOD_ESSENCE_INFUSE_TYPE = INFUSE_TYPES.register("enriched_wood_essence", () -> new InfuseType(InfuseTypeBuilder.builder().tint(0x8A2BE2)));
    */

    public static void register(IEventBus eventBus) {
        System.out.println("=== ModChemicals.register() CALLED ===");
        // TODO: Uncomment when Mekanism dependency is working
        // GASES.register(eventBus);
        // INFUSE_TYPES.register(eventBus);
        System.out.println("=== Mekanism chemicals temporarily disabled ===");
    }

    // Helper methods
    public static ResourceLocation getWoodEssenceGasId() {
        return ResourceLocation.fromNamespaceAndPath(BlockMod.MOD_ID, "wood_essence");
    }

    public static ResourceLocation getEnrichedWoodEssenceInfuseTypeId() {
        return ResourceLocation.fromNamespaceAndPath(BlockMod.MOD_ID, "enriched_wood_essence");
    }
}
