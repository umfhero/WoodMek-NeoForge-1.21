package net.umf.woodmek.chemical;

import mekanism.api.chemical.infuse.InfuseType;
import mekanism.api.chemical.infuse.InfuseTypeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.umf.woodmek.BlockMod;

public class ModChemicals {
    // Create a DeferredRegister for InfuseTypes using ResourceLocation approach
    public static final DeferredRegister<InfuseType> INFUSE_TYPES = DeferredRegister.create(
            ResourceLocation.fromNamespaceAndPath("mekanism", "infuse_type"), BlockMod.MOD_ID);

    // Wood Essence as an InfuseType - simpler approach
    public static final DeferredHolder<InfuseType, InfuseType> WOOD_ESSENCE = INFUSE_TYPES.register("wood_essence",
            () -> new InfuseType(InfuseTypeBuilder.builder().tint(0x8B4513)));

    public static void register(IEventBus eventBus) {
        // Register the infuse types with the event bus
        INFUSE_TYPES.register(eventBus);
        System.out.println("ModChemicals.register() called - registering wood_essence as InfuseType");
    }

    // Helper method to get the wood essence chemical ID for use in recipes
    public static ResourceLocation getWoodEssenceId() {
        return ResourceLocation.fromNamespaceAndPath(BlockMod.MOD_ID, "wood_essence");
    }
}
