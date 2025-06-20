package net.umf.blockmod.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.umf.blockmod.BlockMod;
import net.umf.blockmod.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(BlockMod.MOD_ID);




    public static final DeferredBlock<Block> HARDWOOD_BLOCK = registerBlock("hardwood_block",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.BAMBOO).strength(4f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> HAZARD_BLOCK = registerBlock("hazard_block",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.LANTERN).strength(1f).requiresCorrectToolForDrops()));




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
