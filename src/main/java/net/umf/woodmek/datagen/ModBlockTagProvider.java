package net.umf.woodmek.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.umf.woodmek.BlockMod;
import net.umf.woodmek.block.ModBlocks;
import net.umf.woodmek.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, BlockMod.MOD_ID, existingFileHelper);
    }




    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.HAZARD_BLOCK.get())
                .add(ModBlocks.HALF_HAZARD_BLOCK.get())
                .add(ModBlocks.IRON_GRATE.get())
                .add(ModBlocks.TRANSFORMER_BLOCK.get());
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.HARDWOOD_BLOCK.get())
                .add(ModBlocks.HARDWOOD_STAIRS.get())
                .add(ModBlocks.HARDWOOD_SLAB.get())
                .add(ModBlocks.HARDWOOD_BUTTON.get())
                .add(ModBlocks.HARDWOOD_PRESSURE_PLATE.get())
                .add(ModBlocks.HARDWOOD_FENCE.get())
                .add(ModBlocks.HARDWOOD_FENCE_GATE.get())
                .add(ModBlocks.HARDWOOD_WALL.get())
                .add(ModBlocks.HARDWOOD_DOOR.get())
                .add(ModBlocks.HARDWOOD_TRAPDOOR.get());



        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.HAZARD_BLOCK.get())
                .add(ModBlocks.HALF_HAZARD_BLOCK.get())
                .add(ModBlocks.IRON_GRATE.get())
                .add(ModBlocks.HARDWOOD_BLOCK.get())
                .add(ModBlocks.HARDWOOD_STAIRS.get())
                .add(ModBlocks.HARDWOOD_SLAB.get())
                .add(ModBlocks.HARDWOOD_BUTTON.get())
                .add(ModBlocks.HARDWOOD_PRESSURE_PLATE.get())
                .add(ModBlocks.HARDWOOD_FENCE.get())
                .add(ModBlocks.HARDWOOD_FENCE_GATE.get())
                .add(ModBlocks.HARDWOOD_WALL.get())
                .add(ModBlocks.HARDWOOD_DOOR.get())
                .add(ModBlocks.HARDWOOD_TRAPDOOR.get())
                .add(ModBlocks.HARDWOOD_LAMP.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.TRANSFORMER_BLOCK.get());

        tag(BlockTags.FENCES).add(ModBlocks.HARDWOOD_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(ModBlocks.HARDWOOD_FENCE_GATE.get());
        tag(BlockTags.WALLS).add(ModBlocks.HARDWOOD_WALL.get());

        tag(ModTags.Blocks.NEEDS_HARDWOOD_TOOL)
                .addTag(BlockTags.NEEDS_IRON_TOOL);
        
        tag(ModTags.Blocks.INCORRECT_FOR_HARDWOOD_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .remove(ModTags.Blocks.NEEDS_HARDWOOD_TOOL);

        tag(ModTags.Blocks.NEEDS_AZALEA_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_AZALEA_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
                .remove(ModTags.Blocks.NEEDS_AZALEA_TOOL);
    }
}
