package net.umf.woodmek.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.umf.woodmek.BlockMod;
import net.umf.woodmek.block.ModBlocks;
import net.umf.woodmek.item.ModItems;
import net.minecraft.world.level.block.Block;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, BlockMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.CHISEL.get());
        basicItem(ModItems.WOODSHEET.get());
        basicItem(ModItems.WOOD_DUST.get());
        basicItem(ModItems.HARDWOOD.get());
        basicItem(ModItems.HARDWOOD_ALLOY.get());

        buttonItem(ModBlocks.HARDWOOD_BUTTON, ModBlocks.HARDWOOD_BLOCK);
        fenceItem(ModBlocks.HARDWOOD_FENCE, ModBlocks.HARDWOOD_BLOCK);
        wallItem(ModBlocks.HARDWOOD_WALL, ModBlocks.HARDWOOD_BLOCK);

        basicItem(ModBlocks.HARDWOOD_DOOR.asItem());

        handheldItem(ModItems.HARDWOOD_SWORD);
        handheldItem(ModItems.HARDWOOD_AXE);
        handheldItem(ModItems.HARDWOOD_PICKAXE);
        handheldItem(ModItems.HARDWOOD_SHOVEL);
        handheldItem(ModItems.HARDWOOD_HOE);

    }
    public void buttonItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath("woodmek",
                        "block/" + baseBlock.getId().getPath()));
    }

    public void fenceItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath("woodmek",
                        "block/" + baseBlock.getId().getPath()));
    }

    public void wallItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath("woodmek",
                        "block/" + baseBlock.getId().getPath()));
    }
    private ItemModelBuilder handheldItem(DeferredItem<?> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(BlockMod.MOD_ID,"item/" + item.getId().getPath()));
    }
}
