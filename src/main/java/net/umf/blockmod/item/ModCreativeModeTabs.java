package net.umf.blockmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.umf.blockmod.BlockMod;
import net.umf.blockmod.block.ModBlocks;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BlockMod.MOD_ID);

    public static final Supplier<CreativeModeTab> WOOD_ITEMS_TAB = CREATIVE_MODE_TAB.register("wood_items_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.HARDWOOD_ALLOY.get())).title(Component.translatable("creativetab.blockmod.wood_items"))
            .displayItems((itemDisplayParameters, output) -> {
                output.accept(ModItems.HARDWOOD.get());
                output.accept(ModItems.HARDWOOD_ALLOY.get());
                output.accept(ModItems.WOODSHEET.get());
                output.accept(ModBlocks.HARDWOOD_BLOCK.get());
                output.accept(ModBlocks.HAZARD_BLOCK.get());



            }).build());

    public static final Supplier<CreativeModeTab> CUSTOM_ITEMS_TAB = CREATIVE_MODE_TAB.register("custom_items_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModBlocks.HAZARD_BLOCK.get())).title(Component.translatable("creativetab.blockmod.custom_items"))
            .withTabsBefore(ResourceLocation.fromNamespaceAndPath(BlockMod.MOD_ID, "wood_items_tab"))
            .displayItems((itemDisplayParameters, output) -> {

                output.accept(ModBlocks.HAZARD_BLOCK.get());



            }).build());



    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
