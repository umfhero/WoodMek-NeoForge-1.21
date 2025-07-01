package net.umf.woodmek.datagen;

import com.google.gson.JsonObject;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.umf.woodmek.BlockMod;
import net.umf.woodmek.block.ModBlocks;
import net.umf.woodmek.item.ModItems;
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

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.HARDWOOD_BRICK.get())
                .pattern("HH")
                .pattern("HH")
                .define('H', ModItems.HARDWOOD.get())
                .unlockedBy("has_hardwood", has(ModItems.HARDWOOD.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.HARDWOOD_BRICK_HOLE.get())
                .pattern("H H")
                .pattern(" H ")
                .pattern("H H")
                .define('H', ModItems.HARDWOOD.get())
                .unlockedBy("has_hardwood", has(ModItems.HARDWOOD.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.HARDWOOD_BRICK_NOHOLE.get())
                .pattern("HHH")
                .pattern("H H")
                .pattern("HHH")
                .define('H', ModItems.HARDWOOD.get())
                .unlockedBy("has_hardwood", has(ModItems.HARDWOOD.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.HARDWOOD_BRICK_NOHOLE.get(), 4)
                .pattern("HHH")
                .pattern("H H")
                .pattern("HHH")
                .define('H', ModItems.HARDWOOD.get())
                .unlockedBy("has_hardwood", has(ModItems.HARDWOOD.get()))
                .save(recipeOutput, "woodmek:hardwood_brick_nohole_alt");

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

        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModBlocks.HARDWOOD_LAMP.get())
                .pattern(" H ")
                .pattern("HRH")
                .pattern(" H ")
                .define('H', ModItems.HARDWOOD.get())
                .define('R', Items.REDSTONE)
                .unlockedBy("has_redstone", has(Items.REDSTONE))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.HAZARD_BLOCK.get())
                .pattern("S S")
                .pattern(" G ")
                .pattern("S S")
                .define('S', Items.STONE)
                .define('G', Items.YELLOW_DYE)
                .unlockedBy("has_yellowdye", has(Items.YELLOW_DYE))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.HALF_HAZARD_BLOCK.get())
                .pattern(" S ")
                .pattern("SGS")
                .pattern(" S ")
                .define('S', Items.SMOOTH_STONE)
                .define('G', Items.YELLOW_DYE)
                .unlockedBy("has_yellowdye", has(Items.YELLOW_DYE))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CENTRE_HAZARD_BLOCK.get())
                .pattern("S S")
                .pattern(" G ")
                .pattern("S S")
                .define('S', Items.SMOOTH_STONE)
                .define('G', Items.YELLOW_DYE)
                .unlockedBy("has_yellowdye", has(Items.YELLOW_DYE))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MINI_HAZARD_BLOCK.get())
                .pattern(" S ")
                .pattern("SGS")
                .pattern(" S ")
                .define('S', Items.STONE)
                .define('G', Items.YELLOW_DYE)
                .unlockedBy("has_yellowdye", has(Items.YELLOW_DYE))
                .save(recipeOutput);


        //Block to hardwood
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.HARDWOOD.get(), 9)
                .requires(ModBlocks.HARDWOOD_BLOCK)
                .unlockedBy("has_hardwood_block", has(ModBlocks.HARDWOOD_BLOCK)).save(recipeOutput,
                        "woodmek:hardwood_from_block");

        //Smelt wood dust to hardwood
        oreSmelting(recipeOutput, HARDWOOD_SMELTABLES, RecipeCategory.MISC,
                ModItems.HARDWOOD.get(), 0.25f, 2, "hardwood");

        stairBuilder(ModBlocks.HARDWOOD_STAIRS.get(), Ingredient.of(ModItems.HARDWOOD)).group("hardwood")
                .unlockedBy("has_hardwood", has(ModItems.HARDWOOD)).save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.HARDWOOD_SLAB.get(), ModItems.HARDWOOD.get());

        buttonBuilder(ModBlocks.HARDWOOD_BUTTON.get(), Ingredient.of(ModItems.HARDWOOD.get())).group("bismuth")
                .unlockedBy("has_bismuth", has(ModItems.HARDWOOD.get())).save(recipeOutput);
        pressurePlate(recipeOutput, ModBlocks.HARDWOOD_PRESSURE_PLATE.get(), ModItems.HARDWOOD.get());

        fenceBuilder(ModBlocks.HARDWOOD_FENCE.get(), Ingredient.of(ModItems.HARDWOOD.get())).group("bismuth")
                .unlockedBy("has_bismuth", has(ModItems.HARDWOOD.get())).save(recipeOutput);
        fenceGateBuilder(ModBlocks.HARDWOOD_FENCE_GATE.get(), Ingredient.of(ModItems.HARDWOOD.get())).group("bismuth")
                .unlockedBy("has_bismuth", has(ModItems.HARDWOOD.get())).save(recipeOutput);
        wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.HARDWOOD_WALL.get(), ModItems.HARDWOOD.get());

        doorBuilder(ModBlocks.HARDWOOD_DOOR.get(), Ingredient.of(ModItems.HARDWOOD.get())).group("bismuth")
                .unlockedBy("has_bismuth", has(ModItems.HARDWOOD.get())).save(recipeOutput);
        trapdoorBuilder(ModBlocks.HARDWOOD_TRAPDOOR.get(), Ingredient.of(ModItems.HARDWOOD.get())).group("bismuth")
                .unlockedBy("has_bismuth", has(ModItems.HARDWOOD.get())).save(recipeOutput);

        // HW tools
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.HARDWOOD_SWORD.get())
                .pattern(" A ")
                .pattern(" A ")
                .pattern(" S ")
                .define('A', ModItems.HARDWOOD_ALLOY.get())
                .define('S', Items.STICK)
                .unlockedBy("has_hardwood_alloy", has(ModItems.HARDWOOD_ALLOY.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.HARDWOOD_PICKAXE.get())
                .pattern("AAA")
                .pattern(" S ")
                .pattern(" S ")
                .define('A', ModItems.HARDWOOD_ALLOY.get())
                .define('S', Items.STICK)
                .unlockedBy("has_hardwood_alloy", has(ModItems.HARDWOOD_ALLOY.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.HARDWOOD_AXE.get())
                .pattern("AA ")
                .pattern("AS ")
                .pattern(" S ")
                .define('A', ModItems.HARDWOOD_ALLOY.get())
                .define('S', Items.STICK)
                .unlockedBy("has_hardwood_alloy", has(ModItems.HARDWOOD_ALLOY.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.HARDWOOD_SHOVEL.get())
                .pattern(" A ")
                .pattern(" S ")
                .pattern(" S ")
                .define('A', ModItems.HARDWOOD_ALLOY.get())
                .define('S', Items.STICK)
                .unlockedBy("has_hardwood_alloy", has(ModItems.HARDWOOD_ALLOY.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.HARDWOOD_HOE.get())
                .pattern("AA ")
                .pattern(" S ")
                .pattern(" S ")
                .define('A', ModItems.HARDWOOD_ALLOY.get())
                .define('S', Items.STICK)
                .unlockedBy("has_hardwood_alloy", has(ModItems.HARDWOOD_ALLOY.get()))
                .save(recipeOutput);



        // AZ tools
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.AZALEA_SWORD.get())
                .pattern("AAA")
                .pattern("ATA")
                .pattern("AAA")
                .define('A', Items.AZALEA)
                .define('T', ModItems.HARDWOOD_SWORD.get())
                .unlockedBy("has_hardwood_alloy", has(ModItems.HARDWOOD_ALLOY.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.AZALEA_PICKAXE.get())
                .pattern("AAA")
                .pattern("ATA")
                .pattern("AAA")
                .define('A', Items.AZALEA)
                .define('T', ModItems.HARDWOOD_PICKAXE.get())
                .unlockedBy("has_hardwood_alloy", has(ModItems.HARDWOOD_ALLOY.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.AZALEA_AXE.get())
                .pattern("AAA")
                .pattern("ATA")
                .pattern("AAA")
                .define('A', Items.AZALEA)
                .define('T', ModItems.HARDWOOD_AXE.get())
                .unlockedBy("has_hardwood_alloy", has(ModItems.HARDWOOD_ALLOY.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.AZALEA_SHOVEL.get())
                .pattern("AAA")
                .pattern("ATA")
                .pattern("AAA")
                .define('A', Items.AZALEA)
                .define('T', ModItems.HARDWOOD_SHOVEL.get())
                .unlockedBy("has_hardwood_alloy", has(ModItems.HARDWOOD_ALLOY.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.AZALEA_HOE.get())
                .pattern("AAA")
                .pattern("ATA")
                .pattern("AAA")
                .define('A', Items.AZALEA)
                .define('T', ModItems.HARDWOOD_HOE.get())
                .unlockedBy("has_hardwood_alloy", has(ModItems.HARDWOOD_ALLOY.get()))
                .save(recipeOutput);

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
