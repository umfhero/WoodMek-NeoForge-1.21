package net.umf.woodmek.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.umf.woodmek.BlockMod;
import net.umf.woodmek.block.ModBlocks;
import net.umf.woodmek.block.custom.HardwoodLampBlock;



public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, BlockMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.HARDWOOD_BLOCK);
        blockWithItem(ModBlocks.HARDWOOD_BRICK);
        blockWithItem(ModBlocks.HARDWOOD_BRICK_HOLE);
        blockWithItem(ModBlocks.HARDWOOD_BRICK_NOHOLE);
        blockWithItem(ModBlocks.HAZARD_BLOCK);
        blockWithItem(ModBlocks.HALF_HAZARD_BLOCK);
        blockWithItem(ModBlocks.HAZARD_BLOCK2);
        blockWithItem(ModBlocks.HALF_HAZARD_BLOCK2);
        blockWithItem(ModBlocks.CENTRE_HAZARD_BLOCK);
        blockWithItem(ModBlocks.MINI_HAZARD_BLOCK);
        blockWithItem(ModBlocks.TRANSFORMER_BLOCK);

        simpleBlockWithItem(ModBlocks.IRON_GRATE.get(),
            models().cubeAll("iron_grate", blockTexture(ModBlocks.IRON_GRATE.get())).renderType("cutout"));


        stairsBlock(ModBlocks.HARDWOOD_STAIRS.get(), blockTexture(ModBlocks.HARDWOOD_BLOCK.get()));

        slabBlock(ModBlocks.HARDWOOD_SLAB.get(), blockTexture(ModBlocks.HARDWOOD_BLOCK.get()), blockTexture(ModBlocks.HARDWOOD_BLOCK.get()));

        buttonBlock(ModBlocks.HARDWOOD_BUTTON.get(), blockTexture(ModBlocks.HARDWOOD_BLOCK.get()));
        pressurePlateBlock(ModBlocks.HARDWOOD_PRESSURE_PLATE.get(), blockTexture(ModBlocks.HARDWOOD_BLOCK.get()));
        fenceBlock(ModBlocks.HARDWOOD_FENCE.get(), blockTexture(ModBlocks.HARDWOOD_BLOCK.get()));
        fenceGateBlock(ModBlocks.HARDWOOD_FENCE_GATE.get(), blockTexture(ModBlocks.HARDWOOD_BLOCK.get()));
        wallBlock(ModBlocks.HARDWOOD_WALL.get(), blockTexture(ModBlocks.HARDWOOD_BLOCK.get()));

        doorBlockWithRenderType(ModBlocks.HARDWOOD_DOOR.get(), modLoc("block/hardwood_door_bottom"), modLoc("block/hardwood_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.HARDWOOD_TRAPDOOR.get(), modLoc("block/hardwood_trapdoor"), true, "cutout");

        blockItem(ModBlocks.HARDWOOD_STAIRS);
        blockItem(ModBlocks.HARDWOOD_SLAB);
        blockItem(ModBlocks.HARDWOOD_PRESSURE_PLATE);
        blockItem(ModBlocks.HARDWOOD_FENCE_GATE);
        blockItem(ModBlocks.HARDWOOD_TRAPDOOR, "_bottom");

        customLamp();
    }

    private void customLamp() {
        getVariantBuilder(ModBlocks.HARDWOOD_LAMP.get()).forAllStates(state -> {
            if(state.getValue(HardwoodLampBlock.CLICKED)) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("hardwood_lamp_on",
                        ResourceLocation.fromNamespaceAndPath(BlockMod.MOD_ID, "block/" + "hardwood_lamp_on")))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("hardwood_lamp_off",
                        ResourceLocation.fromNamespaceAndPath(BlockMod.MOD_ID, "block/" + "hardwood_lamp_off")))};
            }
        });

        simpleBlockItem(ModBlocks.HARDWOOD_LAMP.get(), models().cubeAll("hardwood_lamp_on",
                ResourceLocation.fromNamespaceAndPath(BlockMod.MOD_ID, "block/" + "hardwood_lamp_on")));
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("woodmek:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("woodmek:block/" + deferredBlock.getId().getPath() + appendix));
    }
}