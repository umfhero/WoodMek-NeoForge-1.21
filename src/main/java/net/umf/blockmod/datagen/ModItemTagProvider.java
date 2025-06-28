package net.umf.blockmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.umf.blockmod.BlockMod;
import net.umf.blockmod.block.ModBlocks;
import net.umf.blockmod.item.ModItems;
import net.umf.blockmod.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, BlockMod.MOD_ID, existingFileHelper);
    }



    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.TRANSFORMABLE_ITEMS)
                //Transformer logs
                .add(Items.OAK_LOG)
                .add(Items.SPRUCE_LOG)
                .add(Items.BIRCH_LOG)
                .add(Items.JUNGLE_LOG)
                .add(Items.ACACIA_LOG)
                .add(Items.DARK_OAK_LOG)
                .add(Items.MANGROVE_LOG)
                .add(Items.CHERRY_LOG)
                .add(Items.BAMBOO_BLOCK)
                .add(Items.CRIMSON_STEM)
                .add(Items.WARPED_STEM)

                //Transformer concrete
                .add(Items.WHITE_CONCRETE)
                .add(Items.ORANGE_CONCRETE)
                .add(Items.MAGENTA_CONCRETE)
                .add(Items.LIGHT_BLUE_CONCRETE)
                .add(Items.YELLOW_CONCRETE)
                .add(Items.LIME_CONCRETE)
                .add(Items.PINK_CONCRETE)
                .add(Items.GRAY_CONCRETE)
                .add(Items.LIGHT_GRAY_CONCRETE)
                .add(Items.CYAN_CONCRETE)
                .add(Items.PURPLE_CONCRETE)
                .add(Items.BLUE_CONCRETE)
                .add(Items.BROWN_CONCRETE)
                .add(Items.GREEN_CONCRETE)
                .add(Items.RED_CONCRETE)
                .add(Items.BLACK_CONCRETE)

                //powders
                .add(Items.WHITE_CONCRETE_POWDER)
                .add(Items.ORANGE_CONCRETE_POWDER)
                .add(Items.MAGENTA_CONCRETE_POWDER)
                .add(Items.LIGHT_BLUE_CONCRETE_POWDER)
                .add(Items.YELLOW_CONCRETE_POWDER)
                .add(Items.LIME_CONCRETE_POWDER)
                .add(Items.PINK_CONCRETE_POWDER)
                .add(Items.GRAY_CONCRETE_POWDER)
                .add(Items.LIGHT_GRAY_CONCRETE_POWDER)
                .add(Items.CYAN_CONCRETE_POWDER)
                .add(Items.PURPLE_CONCRETE_POWDER)
                .add(Items.BLUE_CONCRETE_POWDER)
                .add(Items.BROWN_CONCRETE_POWDER)
                .add(Items.GREEN_CONCRETE_POWDER)
                .add(Items.RED_CONCRETE_POWDER)
                .add(Items.BLACK_CONCRETE_POWDER)

                //my woodmek items for the transformer
                .add(ModItems.HARDWOOD.asItem())
                .add(ModItems.WOOD_DUST.asItem())
                .add(ModBlocks.HARDWOOD_BLOCK.asItem());

    }
}
