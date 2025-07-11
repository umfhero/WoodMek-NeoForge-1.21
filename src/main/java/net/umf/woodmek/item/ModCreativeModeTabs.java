package net.umf.woodmek.item;

import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.core.component.DataComponents;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.umf.woodmek.BlockMod;
import net.umf.woodmek.block.ModBlocks;
import net.umf.woodmek.potion.ModPotions;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BlockMod.MOD_ID);

    public static final Supplier<CreativeModeTab> WOOD_ITEMS_TAB = CREATIVE_MODE_TAB.register("aaa_wood_items_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.HARDWOOD_ALLOY.get())).title(Component.translatable("creativetab.woodmek.wood_items"))
            .withTabsBefore(CreativeModeTabs.INVENTORY) // Try positioning before the inventory tab (usually first)
            .displayItems((itemDisplayParameters, output) -> {
                output.accept(ModItems.CHISEL);
                output.accept(ModItems.FLAREGUN);
                output.accept(ModItems.WOOD_DUST);
                output.accept(ModItems.WOODSHEET);
                output.accept(ModItems.HARDWOOD);
                output.accept(ModItems.HARDWOOD_ALLOY);
                output.accept(ModItems.CONGEALED_WOOD_ESSENCE);
                output.accept(ModItems.CONGEALED_ENRICHED_WOOD_ESSENCE);
                output.accept(ModBlocks.TRANSFORMER_BLOCK);

                output.accept(ModBlocks.HARDWOOD_BLOCK);

                output.accept(ModItems.HARDWOOD_SWORD);
                output.accept(ModItems.HARDWOOD_PICKAXE);
                output.accept(ModItems.HARDWOOD_AXE);
                output.accept(ModItems.HARDWOOD_SHOVEL);
                output.accept(ModItems.HARDWOOD_HOE);

                output.accept(ModItems.AZALEA_SWORD);
                output.accept(ModItems.AZALEA_PICKAXE);
                output.accept(ModItems.AZALEA_AXE);
                output.accept(ModItems.AZALEA_SHOVEL);
                output.accept(ModItems.AZALEA_HOE);

                output.accept(ModItems.HARDWOOD_HAMMER);
                output.accept(ModItems.LIQUID_SAP_BUCKET);
                output.accept(new ItemStack(Items.MILK_BUCKET));

                // Add Shield Potions (normal, splash, lingering)
                ItemStack shieldPotion = new ItemStack(Items.POTION);
                shieldPotion.set(DataComponents.POTION_CONTENTS, new PotionContents(ModPotions.SHIELD_POTION));
                output.accept(shieldPotion);

                ItemStack shieldSplashPotion = new ItemStack(Items.SPLASH_POTION);
                shieldSplashPotion.set(DataComponents.POTION_CONTENTS, new PotionContents(ModPotions.SHIELD_POTION));
                output.accept(shieldSplashPotion);

                ItemStack shieldLingeringPotion = new ItemStack(Items.LINGERING_POTION);
                shieldLingeringPotion.set(DataComponents.POTION_CONTENTS, new PotionContents(ModPotions.SHIELD_POTION));
                output.accept(shieldLingeringPotion);

                // Add Spider Potions (normal, splash, lingering)
                ItemStack spiderPotion = new ItemStack(Items.POTION);
                spiderPotion.set(DataComponents.POTION_CONTENTS, new PotionContents(ModPotions.SPIDER_POTION));
                output.accept(spiderPotion);

                ItemStack spiderSplashPotion = new ItemStack(Items.SPLASH_POTION);
                spiderSplashPotion.set(DataComponents.POTION_CONTENTS, new PotionContents(ModPotions.SPIDER_POTION));
                output.accept(spiderSplashPotion);

                ItemStack spiderLingeringPotion = new ItemStack(Items.LINGERING_POTION);
                spiderLingeringPotion.set(DataComponents.POTION_CONTENTS, new PotionContents(ModPotions.SPIDER_POTION));
                output.accept(spiderLingeringPotion);
            }).build());

    public static final Supplier<CreativeModeTab> CUSTOM_ITEMS_TAB = CREATIVE_MODE_TAB.register("custom_items_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModBlocks.HAZARD_BLOCK.get())).title(Component.translatable("creativetab.woodmek.custom_items"))
            .withTabsAfter(ResourceLocation.fromNamespaceAndPath(BlockMod.MOD_ID, "aaa_wood_items_tab")) // Position this tab right after the WoodMek tab
            .displayItems((itemDisplayParameters, output) -> {
                output.accept(ModBlocks.HARDWOOD_BLOCK.get());
                output.accept(ModBlocks.HARDWOOD_BRICK.get());
                output.accept(ModBlocks.IRON_GRATE.get());
                output.accept(ModBlocks.HARDWOOD_BRICK_HOLE.get());
                output.accept(ModBlocks.HARDWOOD_BRICK_NOHOLE.get());
                output.accept(ModBlocks.HAZARD_BLOCK.get());
                output.accept(ModBlocks.HALF_HAZARD_BLOCK.get());
                output.accept(ModBlocks.CENTRE_HAZARD_BLOCK.get());
                output.accept(ModBlocks.MINI_HAZARD_BLOCK.get());
                output.accept(ModBlocks.TRANSFORMER_BLOCK);

                output.accept(ModBlocks.HARDWOOD_STAIRS);
                output.accept(ModBlocks.HARDWOOD_BUTTON);
                output.accept(ModBlocks.HARDWOOD_DOOR);
                output.accept(ModBlocks.HARDWOOD_FENCE);
                output.accept(ModBlocks.HARDWOOD_SLAB);
                output.accept(ModBlocks.HARDWOOD_FENCE_GATE);
                output.accept(ModBlocks.HARDWOOD_WALL);
                output.accept(ModBlocks.HARDWOOD_PRESSURE_PLATE);
                output.accept(ModBlocks.HARDWOOD_TRAPDOOR);

                output.accept(ModBlocks.HARDWOOD_LAMP);



            }).build());



    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}