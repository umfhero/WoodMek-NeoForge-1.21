package net.umf.woodmek.datagen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;

import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.umf.woodmek.block.ModBlocks;


import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.HARDWOOD_BLOCK.get());
        dropSelf(ModBlocks.HARDWOOD_BRICK.get());
        dropSelf(ModBlocks.HARDWOOD_BRICK_HOLE.get());
        dropSelf(ModBlocks.HARDWOOD_BRICK_NOHOLE.get());
        dropSelf(ModBlocks.HAZARD_BLOCK.get());
        dropSelf(ModBlocks.HALF_HAZARD_BLOCK.get());
        dropSelf(ModBlocks.HAZARD_BLOCK2.get());
        dropSelf(ModBlocks.HALF_HAZARD_BLOCK2.get());
        dropSelf(ModBlocks.CENTRE_HAZARD_BLOCK.get());
        dropSelf(ModBlocks.MINI_HAZARD_BLOCK.get());
        dropSelf(ModBlocks.TRANSFORMER_BLOCK.get());



        dropSelf(ModBlocks.HARDWOOD_STAIRS.get());
        add(ModBlocks.HARDWOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.HARDWOOD_SLAB.get()));

        dropSelf(ModBlocks.HARDWOOD_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.HARDWOOD_BUTTON.get());

        dropSelf(ModBlocks.HARDWOOD_FENCE.get());
        dropSelf(ModBlocks.HARDWOOD_FENCE_GATE.get());
        dropSelf(ModBlocks.HARDWOOD_WALL.get());
        dropSelf(ModBlocks.HARDWOOD_TRAPDOOR.get());

        add(ModBlocks.HARDWOOD_DOOR.get(),
                block -> createDoorTable(ModBlocks.HARDWOOD_DOOR.get()));

        dropSelf(ModBlocks.HARDWOOD_LAMP.get());


    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
