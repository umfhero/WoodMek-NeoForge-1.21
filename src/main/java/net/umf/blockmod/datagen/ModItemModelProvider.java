package net.umf.blockmod.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.umf.blockmod.BlockMod;
import net.umf.blockmod.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, BlockMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.CHISEL.get());
        basicItem(ModItems.WOODSHEET.get());
        basicItem(ModItems.WOOD_DUST.get());
        basicItem(ModItems.HARDWOOD.get());
        basicItem(ModItems.HARDWOOD_ALLOY.get());


    }
}
