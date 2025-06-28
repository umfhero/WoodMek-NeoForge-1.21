package net.umf.blockmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.umf.blockmod.BlockMod;
import net.umf.blockmod.block.ModBlocks;
import net.umf.blockmod.item.ModItems;
import net.minecraft.world.item.crafting.*;



import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        List<ItemLike> HARDWOOD_SMELTABLES = List.of(ModItems.WOOD_DUST.get());


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.HARDWOOD_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.HARDWOOD.get())
                .unlockedBy("has_hardwood", has(ModItems.HARDWOOD)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TRANSFORMER_BLOCK.get())
                .pattern("DND")
                .pattern("AEA")
                .pattern("DAD")
                .define('D', Items.DIAMOND)
                .define('N', Items.NETHER_STAR)
                .define('E', Items.ENCHANTING_TABLE)
                .define('A', ModItems.HARDWOOD_ALLOY.get())
                .unlockedBy("has_hardwood_alloy", has(ModItems.HARDWOOD_ALLOY.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CHISEL.get())
                .pattern("   ")
                .pattern(" B ")
                .pattern("A  ")
                .define('A', ModItems.HARDWOOD.get())
                .define('B', Items.IRON_INGOT)
                .unlockedBy("has_hardwood", has(ModItems.HARDWOOD.get()))
                .save(recipeOutput);


        //Block to hardwood
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.HARDWOOD.get(), 9)
                .requires(ModBlocks.HARDWOOD_BLOCK)
                .unlockedBy("has_hardwood_block", has(ModBlocks.HARDWOOD_BLOCK)).save(recipeOutput,
                        "blockmod:hardwood_from_block");

        //Smelt wood dust to hardwood
        oreSmelting(recipeOutput, HARDWOOD_SMELTABLES, RecipeCategory.MISC,
                ModItems.HARDWOOD.get(), 0.25f, 2, "hardwood");


    }
    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, BlockMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
        }
}
