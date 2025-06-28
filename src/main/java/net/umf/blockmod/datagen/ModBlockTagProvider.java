package net.umf.blockmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.umf.blockmod.BlockMod;
import net.umf.blockmod.block.ModBlocks;
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
                .add(ModBlocks.TRANSFORMER_BLOCK.get());
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.HARDWOOD_BLOCK.get());


        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.HAZARD_BLOCK.get())
                .add(ModBlocks.HARDWOOD_BLOCK.get());
        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.TRANSFORMER_BLOCK.get());

        tag(BlockTags.FENCES).add(ModBlocks.HARDWOOD_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(ModBlocks.HARDWOOD_FENCE_GATE.get());
        tag(BlockTags.WALLS).add(ModBlocks.HARDWOOD_WALL.get());
    }
}
