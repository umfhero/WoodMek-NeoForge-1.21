package net.umf.blockmod.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.umf.blockmod.BlockMod;
import net.umf.blockmod.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, BlockMod.MOD_ID, exFileHelper);
    }





    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.HARDWOOD_BLOCK);
        blockWithItem(ModBlocks.HAZARD_BLOCK);
        blockWithItem(ModBlocks.TRANSFORMER_BLOCK);

    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
