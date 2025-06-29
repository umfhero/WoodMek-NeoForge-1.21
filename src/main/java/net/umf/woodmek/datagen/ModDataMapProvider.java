package net.umf.woodmek.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;
import net.umf.woodmek.block.ModBlocks;
import net.umf.woodmek.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModDataMapProvider extends DataMapProvider {
    protected ModDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather() {
        this.builder(NeoForgeDataMaps.FURNACE_FUELS)
                .add(ModItems.WOOD_DUST.getId(), new FurnaceFuel(250), false)
                .add(ModItems.HARDWOOD.getId(), new FurnaceFuel(15000), false)
                .add(ModBlocks.HARDWOOD_BLOCK.getId(), new FurnaceFuel(25000), false)
                .add(ModItems.HARDWOOD_ALLOY.getId(), new FurnaceFuel(18000), false)
                .add(ModItems.WOODSHEET.getId(), new FurnaceFuel(500), false)

                // burn times for all hardwood non-blocks
                .add(ModBlocks.HARDWOOD_STAIRS.getId(), new FurnaceFuel(18750), false)
                .add(ModBlocks.HARDWOOD_SLAB.getId(), new FurnaceFuel(12500), false)
                .add(ModBlocks.HARDWOOD_PRESSURE_PLATE.getId(), new FurnaceFuel(5000), false)
                .add(ModBlocks.HARDWOOD_BUTTON.getId(), new FurnaceFuel(2500), false)
                .add(ModBlocks.HARDWOOD_FENCE.getId(), new FurnaceFuel(10000), false)
                .add(ModBlocks.HARDWOOD_FENCE_GATE.getId(), new FurnaceFuel(15000), false)
                .add(ModBlocks.HARDWOOD_WALL.getId(), new FurnaceFuel(15000), false)
                .add(ModBlocks.HARDWOOD_DOOR.getId(), new FurnaceFuel(20000), false)
                .add(ModBlocks.HARDWOOD_TRAPDOOR.getId(), new FurnaceFuel(15000), false);
    }
}
