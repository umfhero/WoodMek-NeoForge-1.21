package net.umf.blockmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;
import net.umf.blockmod.block.ModBlocks;
import net.umf.blockmod.item.ModItems;

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
                .add(ModItems.WOODSHEET.getId(), new FurnaceFuel(500), false);
    }
}
