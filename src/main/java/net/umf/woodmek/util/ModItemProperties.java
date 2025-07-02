package net.umf.woodmek.util;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.umf.woodmek.BlockMod;
import net.umf.woodmek.block.component.ModDataComponents;
import net.umf.woodmek.item.ModItems;




public class ModItemProperties {

    public static void addCustomItemProperties() {
        ItemProperties.register(ModItems.CHISEL.get(), ResourceLocation.fromNamespaceAndPath(BlockMod.MOD_ID, "used"),
                (stack, level, entity, seed) -> stack.get(ModDataComponents.USED) != null && stack.get(ModDataComponents.USED) ? 1f : 0f);

    }
}