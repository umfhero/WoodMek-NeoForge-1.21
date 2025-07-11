package net.umf.woodmek.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.umf.woodmek.BlockMod;
import net.umf.woodmek.block.ModBlocks;
import net.umf.woodmek.item.ModItems;
import net.umf.woodmek.util.ModTags;
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
                .add(ModItems.HARDWOOD.asItem())
                .add(ModItems.WOOD_DUST.asItem())
                .add(ModBlocks.HARDWOOD_BLOCK.asItem());

        tag(ItemTags.SWORDS)
                .add(ModItems.HARDWOOD_SWORD.get())
                .add(ModItems.AZALEA_SWORD.get());
        tag(ItemTags.AXES)
                .add(ModItems.HARDWOOD_AXE.get())
                .add(ModItems.AZALEA_AXE.get());
        tag(ItemTags.PICKAXES)
                .add(ModItems.HARDWOOD_PICKAXE.get())
                .add(ModItems.AZALEA_PICKAXE.get());
        tag(ItemTags.SHOVELS)
                .add(ModItems.HARDWOOD_SHOVEL.get())
                .add(ModItems.AZALEA_SHOVEL.get());
        tag(ItemTags.HOES)
                .add(ModItems.HARDWOOD_HOE.get())
                .add(ModItems.AZALEA_HOE.get());
    }
}
