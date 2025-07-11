package net.umf.woodmek.chemical;

import mekanism.api.chemical.gas.Gas;
import mekanism.api.chemical.gas.GasBuilder;
import mekanism.api.chemical.infuse.InfuseType;
import mekanism.api.chemical.infuse.InfuseTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.registries.RegisterEvent;
import net.umf.woodmek.BlockMod;

public class ModChemicals {
    // Wood essence as a gas (for oxidizing recipes)
    public static Gas WOOD_ESSENCE_GAS = null;

    // Enriched wood essence as an infuse type (for metallurgic infusing)
    public static InfuseType ENRICHED_WOOD_ESSENCE_INFUSE_TYPE = null;

    public static void register(IEventBus eventBus) {
        System.out.println("=== ModChemicals.register() CALLED ===");
        eventBus.register(ModChemicals.class);
        System.out.println("=== Registered for RegisterEvent ===");
    }

    @SuppressWarnings("unchecked")
    @SubscribeEvent
    public static void onRegisterEvent(RegisterEvent event) {
        System.out.println("=== RegisterEvent triggered for: " + event.getRegistryKey().location() + " ===");

        // Register wood essence as a gas
        if (event.getRegistryKey().location().toString().equals("mekanism:gas")) {
            System.out.println("=== Found Mekanism Gas registry! ===");

            ResourceKey<Registry<Gas>> registryKey = (ResourceKey<Registry<Gas>>) event.getRegistryKey();
            ResourceLocation woodEssenceId = ResourceLocation.fromNamespaceAndPath(BlockMod.MOD_ID, "wood_essence");

            event.register(registryKey, woodEssenceId, () -> {
                System.out.println("=== Creating wood_essence Gas ===");
                Gas woodEssenceGas = new Gas(GasBuilder.builder().tint(0x8B4513));
                WOOD_ESSENCE_GAS = woodEssenceGas;
                System.out.println("=== Gas created: " + woodEssenceGas + " ===");
                return woodEssenceGas;
            });

            System.out.println("=== Registered wood_essence gas with ID: " + woodEssenceId + " ===");
        }

        // Register enriched wood essence as an infuse type
        if (event.getRegistryKey().location().toString().equals("mekanism:infuse_type")) {
            System.out.println("=== Found Mekanism InfuseType registry! ===");

            ResourceKey<Registry<InfuseType>> registryKey = (ResourceKey<Registry<InfuseType>>) event.getRegistryKey();
            ResourceLocation enrichedWoodEssenceId = ResourceLocation.fromNamespaceAndPath(BlockMod.MOD_ID, "enriched_wood_essence");

            event.register(registryKey, enrichedWoodEssenceId, () -> {
                System.out.println("=== Creating enriched_wood_essence InfuseType ===");
                InfuseType enrichedWoodEssence = new InfuseType(InfuseTypeBuilder.builder().tint(0x6B8E23));
                ENRICHED_WOOD_ESSENCE_INFUSE_TYPE = enrichedWoodEssence;
                System.out.println("=== InfuseType created: " + enrichedWoodEssence + " ===");
                return enrichedWoodEssence;
            });

            System.out.println("=== Registered enriched_wood_essence infuse type with ID: " + enrichedWoodEssenceId + " ===");
        }
    }

    // Helper methods
    public static ResourceLocation getWoodEssenceGasId() {
        return ResourceLocation.fromNamespaceAndPath(BlockMod.MOD_ID, "wood_essence");
    }

    public static ResourceLocation getEnrichedWoodEssenceInfuseTypeId() {
        return ResourceLocation.fromNamespaceAndPath(BlockMod.MOD_ID, "enriched_wood_essence");
    }
}
