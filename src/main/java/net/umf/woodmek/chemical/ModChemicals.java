package net.umf.woodmek.chemical;

import mekanism.api.chemical.infuse.InfuseType;
import mekanism.api.chemical.infuse.InfuseTypeBuilder;
import mekanism.api.chemical.gas.Gas;
import mekanism.api.chemical.gas.GasBuilder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.registries.RegisterEvent;
import net.umf.woodmek.BlockMod;

public class ModChemicals {
    public static Gas WOOD_ESSENCE_GAS = null;
    public static InfuseType ENRICHED_WOOD_ESSENCE_TYPE = null;

    public static void register(IEventBus eventBus) {
        System.out.println("=== ModChemicals.register() CALLED ===");
        eventBus.register(ModChemicals.class);
        System.out.println("=== Registered for RegisterEvent ===");
    }

    @SuppressWarnings("unchecked")
    @SubscribeEvent
    public static void onRegisterEvent(RegisterEvent event) {
        System.out.println("=== RegisterEvent triggered for: " + event.getRegistryKey().location() + " ===");


        if (event.getRegistryKey().location().toString().equals("mekanism:gas")) {
            System.out.println("=== Found Mekanism Gas registry! ===");

            ResourceKey<Registry<Gas>> gasRegistryKey = (ResourceKey<Registry<Gas>>) event.getRegistryKey();

            ResourceLocation woodEssenceId = ResourceLocation.fromNamespaceAndPath(BlockMod.MOD_ID, "wood_essence");
            event.register(gasRegistryKey, woodEssenceId, () -> {
                //  gas types (wood essence rn only)
                System.out.println("=== Creating wood_essence Gas ===");
                Gas woodEssenceGas = new Gas(GasBuilder.builder().tint(0x8B4513));
                WOOD_ESSENCE_GAS = woodEssenceGas;
                System.out.println("=== Gas created: " + woodEssenceGas + " ===");
                return woodEssenceGas;
            });
            System.out.println("=== Registered wood_essence with ID: " + woodEssenceId + " ===");
        }


        if (event.getRegistryKey().location().toString().equals("mekanism:infuse_type")) {
            System.out.println("=== Found Mekanism InfuseType registry! ===");

            ResourceKey<Registry<InfuseType>> registryKey = (ResourceKey<Registry<InfuseType>>) event.getRegistryKey();


            ResourceLocation enrichedWoodEssenceId = ResourceLocation.fromNamespaceAndPath(BlockMod.MOD_ID, "enriched_wood_essence");
            event.register(registryKey, enrichedWoodEssenceId, () -> {
                System.out.println("=== Creating enriched_wood_essence InfuseType ===");
                InfuseType enrichedWoodEssence = new InfuseType(InfuseTypeBuilder.builder().tint(0x8B4FBF));
                ENRICHED_WOOD_ESSENCE_TYPE = enrichedWoodEssence;
                System.out.println("=== InfuseType created: " + enrichedWoodEssence + " ===");
                return enrichedWoodEssence;
            });
            System.out.println("=== Registered enriched_wood_essence with ID: " + enrichedWoodEssenceId + " ===");
        }
    }

    public static ResourceLocation getWoodEssenceId() {
        return ResourceLocation.fromNamespaceAndPath(BlockMod.MOD_ID, "wood_essence");
    }

    public static ResourceLocation getEnrichedWoodEssenceId() {
        return ResourceLocation.fromNamespaceAndPath(BlockMod.MOD_ID, "enriched_wood_essence");
    }
}
