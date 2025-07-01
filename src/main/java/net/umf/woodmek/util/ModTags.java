package net.umf.woodmek.util;


import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.umf.woodmek.BlockMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_HARDWOOD_TOOL = createTag("needs_hardwood_tool");
        public static final TagKey<Block> INCORRECT_FOR_HARDWOOD_TOOL = createTag("incorrect_for_hardwood_tool");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(BlockMod.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");
        public static final TagKey<Item> TRANSFORMABLE_CONCRETE = createTag("transformable_concrete");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(BlockMod.MOD_ID, name));
        }
    }
}
