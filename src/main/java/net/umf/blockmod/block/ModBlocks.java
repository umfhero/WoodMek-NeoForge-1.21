package net.umf.blockmod.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.umf.blockmod.BlockMod;
import net.umf.blockmod.block.custom.transformer;
import net.umf.blockmod.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(BlockMod.MOD_ID);




    public static final DeferredBlock<Block> HARDWOOD_BLOCK = registerBlock("hardwood_block",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.BAMBOO).strength(3f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> HAZARD_BLOCK = registerBlock("hazard_block",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.LANTERN).strength(3f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> TRANSFORMER_BLOCK = registerBlock("transformer_block",
            () -> new transformer(BlockBehaviour.Properties.of().sound(SoundType.TRIAL_SPAWNER).strength(3f).requiresCorrectToolForDrops()));


    public static final DeferredBlock<StairBlock> HARDWOOD_STAIRS = registerBlock("hardwood_stairs",
            () -> new StairBlock(ModBlocks.HARDWOOD_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<SlabBlock> HARDWOOD_SLAB = registerBlock("hardwood_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<PressurePlateBlock> HARDWOOD_PRESSURE_PLATE = registerBlock("hardwood_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<ButtonBlock> HARDWOOD_BUTTON = registerBlock("hardwood_button",
            () -> new ButtonBlock(BlockSetType.OAK, 20, BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().noCollission()));

    public static final DeferredBlock<FenceBlock> HARDWOOD_FENCE = registerBlock("hardwood_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));


    public static final DeferredBlock<FenceGateBlock> HARDWOOD_FENCE_GATE = registerBlock("hardwood_fence_gate",
            () -> new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));


    public static final DeferredBlock<WallBlock> HARDWOOD_WALL = registerBlock("hardwood_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<DoorBlock> HARDWOOD_DOOR = registerBlock("hardwood_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().noOcclusion()));
    public static final DeferredBlock<TrapDoorBlock> HARDWOOD_TRAPDOOR = registerBlock("hardwood_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().noOcclusion()));








    public static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name,block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }


    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }

}
