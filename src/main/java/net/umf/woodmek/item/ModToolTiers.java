package net.umf.woodmek.item;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;
import net.umf.woodmek.util.ModTags;

public class ModToolTiers {
    public static final Tier HARDWOOD = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_HARDWOOD_TOOL,
            500, 7.5f, 2.5f, 12, () -> Ingredient.of(ModItems.HARDWOOD));
}
