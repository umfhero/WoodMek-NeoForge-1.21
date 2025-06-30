package net.umf.woodmek.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.umf.woodmek.BlockMod;
import net.umf.woodmek.block.ModBlocks;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BlockMod.MOD_ID);

    public static final Supplier<CreativeModeTab> WOOD_ITEMS_TAB = CREATIVE_MODE_TAB.register("wood_items_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.HARDWOOD_ALLOY.get())).title(Component.translatable("creativetab.woodmek.wood_items"))
            .displayItems((itemDisplayParameters, output) -> {
                output.accept(ModItems.CHISEL);
                output.accept(ModItems.WOOD_DUST);
                output.accept(ModItems.WOODSHEET);
                output.accept(ModItems.HARDWOOD);
                output.accept(ModItems.HARDWOOD_ALLOY);
                output.accept(ModBlocks.TRANSFORMER_BLOCK);

                output.accept(ModBlocks.HARDWOOD_BLOCK);





            }).build());

    public static final Supplier<CreativeModeTab> CUSTOM_ITEMS_TAB = CREATIVE_MODE_TAB.register("custom_items_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModBlocks.HAZARD_BLOCK.get())).title(Component.translatable("creativetab.woodmek.custom_items"))
            .withTabsBefore(ResourceLocation.fromNamespaceAndPath(BlockMod.MOD_ID, "wood_items_tab"))
            .displayItems((itemDisplayParameters, output) -> {
                output.accept(ModBlocks.HARDWOOD_BLOCK.get());
                output.accept(ModBlocks.HARDWOOD_BRICK.get());
                output.accept(ModBlocks.HARDWOOD_BRICK_HOLE.get());
                output.accept(ModBlocks.HARDWOOD_BRICK_NOHOLE.get());
                output.accept(ModBlocks.HAZARD_BLOCK.get());
                output.accept(ModBlocks.HALF_HAZARD_BLOCK.get());
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
