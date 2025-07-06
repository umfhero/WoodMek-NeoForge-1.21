package net.umf.woodmek.chemical;

import mekanism.api.chemical.infuse.InfuseType;
import mekanism.api.chemical.infuse.InfuseTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.RegisterEvent;
import net.umf.woodmek.BlockMod;

public class ModChemicals {
    // Try a different approach - register manually during RegisterEvent
    public static InfuseType WOOD_ESSENCE_TYPE = null;

    public static void register(IEventBus eventBus) {
        System.out.println("=== ModChemicals.register() CALLED ===");
        eventBus.register(ModChemicals.class);
        System.out.println("=== Registered for RegisterEvent ===");
    }

    @SuppressWarnings("unchecked")
    @SubscribeEvent
    public static void onRegisterEvent(RegisterEvent event) {
        System.out.println("=== RegisterEvent triggered for: " + event.getRegistryKey().location() + " ===");

        // Look for the Mekanism infuse type registry
        if (event.getRegistryKey().location().toString().equals("mekanism:infuse_type")) {
            System.out.println("=== Found Mekanism InfuseType registry! ===");

            // Cast the registry key to the correct type to fix compilation
            ResourceKey<Registry<InfuseType>> registryKey = (ResourceKey<Registry<InfuseType>>) event.getRegistryKey();
            ResourceLocation woodEssenceId = ResourceLocation.fromNamespaceAndPath(BlockMod.MOD_ID, "wood_essence");

            event.register(registryKey, woodEssenceId, () -> {
                System.out.println("=== Creating wood_essence InfuseType ===");
                InfuseType woodEssence = new InfuseType(InfuseTypeBuilder.builder().tint(0x8B4513));
                WOOD_ESSENCE_TYPE = woodEssence;
                System.out.println("=== InfuseType created: " + woodEssence + " ===");
                return woodEssence;
            });

            System.out.println("=== Registered wood_essence with ID: " + woodEssenceId + " ===");
        }
    }

    // Helper method to get the wood essence chemical ID for use in recipes
    public static ResourceLocation getWoodEssenceId() {
        return ResourceLocation.fromNamespaceAndPath(BlockMod.MOD_ID, "wood_essence");
    }
}
