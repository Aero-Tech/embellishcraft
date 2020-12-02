package tv.mapper.embellishcraft.data.gen.recipe;

import java.util.Arrays;
import java.util.function.Consumer;

import net.minecraft.block.AbstractButtonBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.data.CookingRecipeBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.Tags;
import tv.mapper.embellishcraft.ECConstants;
import tv.mapper.embellishcraft.block.ECBlockRegistry;
import tv.mapper.embellishcraft.item.ECItemRegistry;
import tv.mapper.embellishcraft.util.McWoods;
import tv.mapper.embellishcraft.util.RockType;
import tv.mapper.mapperbase.data.BaseTags;
import tv.mapper.mapperbase.item.BaseItems;

public class ECRecipes extends RecipeProvider
{

    public ECRecipes(DataGenerator generatorIn)
    {
        super(generatorIn);
    }

    private static void CreateBasicRecipes(Consumer<IFinishedRecipe> consumer, Block block, StairsBlock stairs, SlabBlock slab, WallBlock wall, PressurePlateBlock pressure, AbstractButtonBlock button)
    {
        if(block != null)
        {
            String name = block.getRegistryName().toString().replace(ECConstants.MODID + ":", "");

            if(slab != null)
            {
                ShapedRecipeBuilder.shapedRecipe(slab, 6).patternLine("iii").key('i', block).addCriterion("has_" + name, hasItem(block)).build(consumer);
                ShapedRecipeBuilder.shapedRecipe(block).patternLine("i").patternLine("i").key('i', slab).addCriterion("has_" + name + "_slab", hasItem(slab)).build(consumer,
                    ECConstants.MODID + ":" + name + "_from_slabs");
            }
            if(stairs != null)
                ShapedRecipeBuilder.shapedRecipe(stairs, 4).key('#', block).patternLine("#  ").patternLine("## ").patternLine("###").addCriterion("has_" + name, hasItem(block)).build(consumer);
            if(wall != null)
                ShapedRecipeBuilder.shapedRecipe(wall, 6).key('#', block).patternLine("###").patternLine("###").addCriterion("has_" + name, hasItem(block)).build(consumer);
            if(pressure != null)
                ShapedRecipeBuilder.shapedRecipe(pressure).key('#', block).patternLine("##").addCriterion("has_" + name, hasItem(block)).build(consumer);
            if(button != null)
                ShapelessRecipeBuilder.shapelessRecipe(button).addIngredient(block).addCriterion("has_" + name, hasItem(block)).build(consumer);
        }
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer)
    {
        for(int j = 0; j < Arrays.stream(RockType.values()).count(); j++)
        {
            // Rocks
            CookingRecipeBuilder.smeltingRecipe(Ingredient.fromItems(ECItemRegistry.ROCKS_COBBLESTONES_ITEMS.get(RockType.byId(j)).get()), ECItemRegistry.ROCKS_ITEMS.get(RockType.byId(j)).get(), 0.1f,
                200).addCriterion("has_" + RockType.byId(j).getString() + "_cobblestone", hasItem(ECItemRegistry.ROCKS_COBBLESTONES_ITEMS.get(RockType.byId(j)).get())).build(consumer,
                    ECConstants.MODID + ":" + RockType.byId(j).getString() + "_from_cobblestone_smelting");

            CreateBasicRecipes(consumer, ECBlockRegistry.ROCK_BLOCKS.get(RockType.byId(j)).get(), ECBlockRegistry.ROCK_STAIRS.get(RockType.byId(j)).get(), ECBlockRegistry.ROCK_SLABS.get(RockType.byId(j)).get(),
                ECBlockRegistry.ROCK_WALLS.get(RockType.byId(j)).get(), ECBlockRegistry.ROCK_PRESSURE_PLATES.get(RockType.byId(j)).get(), ECBlockRegistry.ROCK_BUTTONS.get(RockType.byId(j)).get());

            // Cobblestones
            CreateBasicRecipes(consumer, ECBlockRegistry.ROCK_COBBLESTONES.get(RockType.byId(j)).get(), ECBlockRegistry.ROCK_COBBLESTONE_STAIRS.get(RockType.byId(j)).get(),
                ECBlockRegistry.ROCK_COBBLESTONE_SLABS.get(RockType.byId(j)).get(), ECBlockRegistry.ROCK_COBBLESTONE_WALLS.get(RockType.byId(j)).get(),
                ECBlockRegistry.ROCK_COBBLESTONE_PRESSURE_PLATES.get(RockType.byId(j)).get(), null);

            // Smooth rocks
            CreateBasicRecipes(consumer, ECBlockRegistry.SMOOTH_ROCK_BLOCKS.get(RockType.byId(j)).get(), ECBlockRegistry.SMOOTH_ROCK_STAIRS.get(RockType.byId(j)).get(),
                ECBlockRegistry.SMOOTH_ROCK_SLABS.get(RockType.byId(j)).get(), ECBlockRegistry.SMOOTH_ROCK_WALLS.get(RockType.byId(j)).get(),
                ECBlockRegistry.SMOOTH_ROCK_PRESSURE_PLATES.get(RockType.byId(j)).get(), null);

            CookingRecipeBuilder.smeltingRecipe(Ingredient.fromItems(ECBlockRegistry.ROCK_BLOCKS.get(RockType.byId(j)).get()), ECBlockRegistry.SMOOTH_ROCK_BLOCKS.get(RockType.byId(j)).get(), 0.1f,
                200).addCriterion("has_" + RockType.byId(j).getString(), hasItem(ECBlockRegistry.ROCK_BLOCKS.get(RockType.byId(j)).get())).build(consumer,
                    ECConstants.MODID + ":smooth_" + RockType.byId(j).getString() + "_from_smelting");
            ShapelessRecipeBuilder.shapelessRecipe(ECBlockRegistry.SMOOTH_ROCK_BLOCKS.get(RockType.byId(j)).get()).addIngredient(ECBlockRegistry.POLISHED_ROCK_BLOCKS.get(RockType.byId(j)).get()).addCriterion(
                "has_polished_" + RockType.byId(j).getString(), hasItem(ECBlockRegistry.POLISHED_ROCK_BLOCKS.get(RockType.byId(j)).get())).build(consumer);

            // Polished rocks
            ShapelessRecipeBuilder.shapelessRecipe(ECBlockRegistry.POLISHED_ROCK_BLOCKS.get(RockType.byId(j)).get()).addIngredient(ECBlockRegistry.SMOOTH_ROCK_BLOCKS.get(RockType.byId(j)).get()).addCriterion(
                "has_smooth_" + RockType.byId(j).getString(), hasItem(ECBlockRegistry.SMOOTH_ROCK_BLOCKS.get(RockType.byId(j)).get())).build(consumer);

            CreateBasicRecipes(consumer, ECBlockRegistry.POLISHED_ROCK_BLOCKS.get(RockType.byId(j)).get(), ECBlockRegistry.POLISHED_ROCK_STAIRS.get(RockType.byId(j)).get(),
                ECBlockRegistry.POLISHED_ROCK_SLABS.get(RockType.byId(j)).get(), ECBlockRegistry.POLISHED_ROCK_WALLS.get(RockType.byId(j)).get(),
                ECBlockRegistry.POLISHED_ROCK_PRESSURE_PLATES.get(RockType.byId(j)).get(), null);

            // Rock pavings
            ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.ROCK_PAVINGS.get(RockType.byId(j)).get(), 4).patternLine("ii").patternLine("ii").key('i',
                ECBlockRegistry.POLISHED_ROCK_BLOCKS.get(RockType.byId(j)).get()).addCriterion("has_polished_" + RockType.byId(j).getString(),
                    hasItem(ECBlockRegistry.POLISHED_ROCK_BLOCKS.get(RockType.byId(j)).get())).build(consumer);

            CreateBasicRecipes(consumer, ECBlockRegistry.ROCK_PAVINGS.get(RockType.byId(j)).get(), ECBlockRegistry.ROCK_PAVING_STAIRS.get(RockType.byId(j)).get(),
                ECBlockRegistry.ROCK_PAVING_SLABS.get(RockType.byId(j)).get(), ECBlockRegistry.ROCK_PAVING_WALLS.get(RockType.byId(j)).get(),
                ECBlockRegistry.ROCK_PAVING_PRESSURE_PLATES.get(RockType.byId(j)).get(), null);

            // Rock tiles
            ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.ROCK_TILES.get(RockType.byId(j)).get(), 4).patternLine("ii").patternLine("ii").key('i',
                ECBlockRegistry.ROCK_PAVINGS.get(RockType.byId(j)).get()).addCriterion("has_" + RockType.byId(j).getString() + "_paving",
                    hasItem(ECBlockRegistry.ROCK_PAVINGS.get(RockType.byId(j)).get())).build(consumer);

            CreateBasicRecipes(consumer, ECBlockRegistry.ROCK_TILES.get(RockType.byId(j)).get(), ECBlockRegistry.ROCK_TILES_STAIRS.get(RockType.byId(j)).get(),
                ECBlockRegistry.ROCK_TILES_SLABS.get(RockType.byId(j)).get(), ECBlockRegistry.ROCK_TILES_WALLS.get(RockType.byId(j)).get(),
                ECBlockRegistry.ROCK_TILES_PRESSURE_PLATES.get(RockType.byId(j)).get(), null);

            // Rock bricks
            ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.ROCK_BRICKS.get(RockType.byId(j)).get(), 4).patternLine("ii").patternLine("ii").key('i',
                ECBlockRegistry.ROCK_BLOCKS.get(RockType.byId(j)).get()).addCriterion("has_" + RockType.byId(j).getString(), hasItem(ECBlockRegistry.ROCK_BLOCKS.get(RockType.byId(j)).get())).build(consumer);

            CreateBasicRecipes(consumer, ECBlockRegistry.ROCK_BRICKS.get(RockType.byId(j)).get(), ECBlockRegistry.ROCK_BRICKS_STAIRS.get(RockType.byId(j)).get(),
                ECBlockRegistry.ROCK_BRICKS_SLABS.get(RockType.byId(j)).get(), ECBlockRegistry.ROCK_BRICKS_WALLS.get(RockType.byId(j)).get(),
                ECBlockRegistry.ROCK_BRICKS_PRESSURE_PLATES.get(RockType.byId(j)).get(), null);

            // Rock large bricks
            ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.ROCK_LARGE_BRICKS.get(RockType.byId(j)).get(), 4).patternLine("ii").patternLine("ii").key('i',
                ECBlockRegistry.ROCK_BRICKS.get(RockType.byId(j)).get()).addCriterion("has_" + RockType.byId(j).getString() + "_bricks", hasItem(ECBlockRegistry.ROCK_BRICKS.get(RockType.byId(j)).get())).build(
                    consumer);

            CreateBasicRecipes(consumer, ECBlockRegistry.ROCK_LARGE_BRICKS.get(RockType.byId(j)).get(), ECBlockRegistry.ROCK_LARGE_BRICKS_STAIRS.get(RockType.byId(j)).get(),
                ECBlockRegistry.ROCK_LARGE_BRICKS_SLABS.get(RockType.byId(j)).get(), ECBlockRegistry.ROCK_LARGE_BRICKS_WALLS.get(RockType.byId(j)).get(),
                ECBlockRegistry.ROCK_LARGE_BRICKS_PRESSURE_PLATES.get(RockType.byId(j)).get(), null);

            // Rock paving stones
            ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.ROCK_PAVING_STONES.get(RockType.byId(j)).get(), 4).patternLine(" i ").patternLine("i i").patternLine(" i ").key('i',
                ECBlockRegistry.ROCK_COBBLESTONES.get(RockType.byId(j)).get()).addCriterion("has_" + RockType.byId(j).getString() + "_cobblestones",
                    hasItem(ECBlockRegistry.ROCK_COBBLESTONES.get(RockType.byId(j)).get())).build(consumer);

            CreateBasicRecipes(consumer, ECBlockRegistry.ROCK_PAVING_STONES.get(RockType.byId(j)).get(), ECBlockRegistry.ROCK_PAVING_STONES_STAIRS.get(RockType.byId(j)).get(),
                ECBlockRegistry.ROCK_PAVING_STONES_SLABS.get(RockType.byId(j)).get(), ECBlockRegistry.ROCK_PAVING_STONES_WALLS.get(RockType.byId(j)).get(),
                ECBlockRegistry.ROCK_PAVING_STONES_PRESSURE_PLATES.get(RockType.byId(j)).get(), null);

            // Rock ornaments
            ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.ROCK_ORNAMENTS.get(RockType.byId(j)).get(), 2).patternLine(" i ").patternLine("i i").patternLine(" i ").key('i',
                ECBlockRegistry.SMOOTH_ROCK_SLABS.get(RockType.byId(j)).get()).addCriterion("has_smooth_" + RockType.byId(j).getString() + "_slab",
                    hasItem(ECBlockRegistry.SMOOTH_ROCK_SLABS.get(RockType.byId(j)).get())).build(consumer, ECConstants.MODID + ":" + RockType.byId(j).getString() + "_ornament_from_smooth_slabs");
            ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.ROCK_ORNAMENTS.get(RockType.byId(j)).get(), 2).patternLine(" i ").patternLine("i i").patternLine(" i ").key('i',
                ECBlockRegistry.POLISHED_ROCK_SLABS.get(RockType.byId(j)).get()).addCriterion("has_polished_" + RockType.byId(j).getString() + "_slab",
                    hasItem(ECBlockRegistry.POLISHED_ROCK_SLABS.get(RockType.byId(j)).get())).build(consumer);

            ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.ROCK_ORNAMENT_PRESSURE_PLATES.get(RockType.byId(j)).get()).key('#', ECBlockRegistry.ROCK_ORNAMENTS.get(RockType.byId(j)).get()).patternLine(
                "##").addCriterion("has_" + RockType.byId(j).getString() + "_ornament", hasItem(ECBlockRegistry.ROCK_ORNAMENTS.get(RockType.byId(j)).get())).build(consumer);

            // Rock rooftiles
            ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.ROCK_ROOFTILES.get(RockType.byId(j)).get(), 4).patternLine(" i ").patternLine("i i").patternLine(" i ").key('i',
                ECBlockRegistry.ROCK_BLOCKS.get(RockType.byId(j)).get()).addCriterion("has_" + RockType.byId(j).getString(), hasItem(ECBlockRegistry.ROCK_BLOCKS.get(RockType.byId(j)).get())).build(consumer,
                    ECConstants.MODID + ":" + RockType.byId(j).getString() + "_rooftiles_from_" + RockType.byId(j).getString());

            CreateBasicRecipes(consumer, ECBlockRegistry.ROCK_ROOFTILES.get(RockType.byId(j)).get(), ECBlockRegistry.ROCK_ROOFTILES_STAIRS.get(RockType.byId(j)).get(),
                ECBlockRegistry.ROCK_ROOFTILES_SLABS.get(RockType.byId(j)).get(), null, null, null);
        }

        // Paving stones
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.PAVING_STONES.get(), 4).patternLine(" i ").patternLine("i i").patternLine(" i ").key('i', Blocks.STONE).addCriterion("has_stone",
            hasItem(Blocks.STONE)).build(consumer);

        CreateBasicRecipes(consumer, ECBlockRegistry.PAVING_STONES.get(), ECBlockRegistry.PAVING_STONES_STAIRS.get(), ECBlockRegistry.PAVING_STONES_SLAB.get(), ECBlockRegistry.PAVING_STONES_WALL.get(),
            ECBlockRegistry.PAVING_STONES_PRESSURE_PLATE.get(), null);

        // Andesite
        ShapelessRecipeBuilder.shapelessRecipe(ECBlockRegistry.ANDESITE_BUTTON.get()).addIngredient(Blocks.ANDESITE).addCriterion("has_andesite", hasItem(Blocks.ANDESITE)).build(consumer);

        CookingRecipeBuilder.smeltingRecipe(Ingredient.fromItems(Items.ANDESITE), ECItemRegistry.SMOOTH_ANDESITE_ITEM.get(), 0.1f, 200).addCriterion("has_andesite", hasItem(Items.ANDESITE)).build(consumer,
            ECConstants.MODID + ":smooth_andesite_from_smelting");

        ShapelessRecipeBuilder.shapelessRecipe(ECBlockRegistry.SMOOTH_ANDESITE.get()).addIngredient(Blocks.POLISHED_ANDESITE).addCriterion("has_polished_andesite", hasItem(Blocks.POLISHED_ANDESITE)).build(
            consumer);
        CreateBasicRecipes(consumer, ECBlockRegistry.SMOOTH_ANDESITE.get(), ECBlockRegistry.SMOOTH_ANDESITE_STAIRS.get(), ECBlockRegistry.SMOOTH_ANDESITE_SLAB.get(), ECBlockRegistry.SMOOTH_ANDESITE_WALL.get(),
            ECBlockRegistry.SMOOTH_ANDESITE_PRESSURE_PLATE.get(), null);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.ANDESITE_PAVING.get(), 4).patternLine("ii").patternLine("ii").key('i', Blocks.POLISHED_ANDESITE).addCriterion("has_polished_andesite",
            hasItem(Blocks.POLISHED_ANDESITE)).build(consumer);
        CreateBasicRecipes(consumer, ECBlockRegistry.ANDESITE_PAVING.get(), ECBlockRegistry.ANDESITE_PAVING_STAIRS.get(), ECBlockRegistry.ANDESITE_PAVING_SLAB.get(), ECBlockRegistry.ANDESITE_PAVING_WALL.get(),
            ECBlockRegistry.ANDESITE_PAVING_PRESSURE_PLATE.get(), null);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.ANDESITE_TILES.get(), 4).patternLine("ii").patternLine("ii").key('i', ECBlockRegistry.ANDESITE_PAVING.get()).addCriterion("has_andesite_paving",
            hasItem(ECBlockRegistry.ANDESITE_PAVING.get())).build(consumer);
        CreateBasicRecipes(consumer, ECBlockRegistry.ANDESITE_TILES.get(), ECBlockRegistry.ANDESITE_TILES_STAIRS.get(), ECBlockRegistry.ANDESITE_TILES_SLAB.get(), ECBlockRegistry.ANDESITE_TILES_WALL.get(),
            ECBlockRegistry.ANDESITE_TILES_PRESSURE_PLATE.get(), null);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.ANDESITE_BRICKS.get(), 4).patternLine("ii").patternLine("ii").key('i', ECBlockRegistry.SMOOTH_ANDESITE.get()).addCriterion("has_smooth_andesite",
            hasItem(ECBlockRegistry.SMOOTH_ANDESITE.get())).build(consumer);
        CreateBasicRecipes(consumer, ECBlockRegistry.ANDESITE_BRICKS.get(), ECBlockRegistry.ANDESITE_BRICKS_STAIRS.get(), ECBlockRegistry.ANDESITE_BRICKS_SLAB.get(), ECBlockRegistry.ANDESITE_BRICKS_WALL.get(),
            ECBlockRegistry.ANDESITE_BRICKS_PRESSURE_PLATE.get(), null);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.ANDESITE_LARGE_BRICKS.get(), 4).patternLine("ii").patternLine("ii").key('i', ECBlockRegistry.ANDESITE_BRICKS.get()).addCriterion("has_andesite_bricks",
            hasItem(ECBlockRegistry.ANDESITE_BRICKS.get())).build(consumer);
        CreateBasicRecipes(consumer, ECBlockRegistry.ANDESITE_LARGE_BRICKS.get(), ECBlockRegistry.ANDESITE_LARGE_BRICKS_STAIRS.get(), ECBlockRegistry.ANDESITE_LARGE_BRICKS_SLAB.get(),
            ECBlockRegistry.ANDESITE_LARGE_BRICKS_WALL.get(), ECBlockRegistry.ANDESITE_LARGE_BRICKS_PRESSURE_PLATE.get(), null);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.ANDESITE_PAVING_STONES.get(), 4).patternLine(" i ").patternLine("i i").patternLine(" i ").key('i', ECBlockRegistry.ANDESITE_BRICKS.get()).addCriterion(
            "has_andesite_bricks", hasItem(ECBlockRegistry.ANDESITE_BRICKS.get())).build(consumer);
        CreateBasicRecipes(consumer, ECBlockRegistry.ANDESITE_PAVING_STONES.get(), ECBlockRegistry.ANDESITE_PAVING_STONES_STAIRS.get(), ECBlockRegistry.ANDESITE_PAVING_STONES_SLAB.get(),
            ECBlockRegistry.ANDESITE_PAVING_STONES_WALL.get(), ECBlockRegistry.ANDESITE_PAVING_STONES_PRESSURE_PLATE.get(), null);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.ANDESITE_ORNAMENT.get()).patternLine(" i ").patternLine("i i").patternLine(" i ").key('i', ECBlockRegistry.SMOOTH_ANDESITE_SLAB.get()).addCriterion(
            "has_smooth_andesite_slab", hasItem(ECBlockRegistry.SMOOTH_ANDESITE_SLAB.get())).build(consumer, ECConstants.MODID + ":andesite_ornament_from_smooth_slabs");
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.ANDESITE_ORNAMENT.get()).patternLine(" i ").patternLine("i i").patternLine(" i ").key('i', Blocks.POLISHED_ANDESITE_SLAB).addCriterion(
            "has_polished_andesite_slab", hasItem(Blocks.POLISHED_ANDESITE_SLAB)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.ANDESITE_ORNAMENT_PRESSURE_PLATE.get()).key('#', ECBlockRegistry.ANDESITE_ORNAMENT.get()).patternLine("##").addCriterion("has_andesite_ornament",
            hasItem(ECBlockRegistry.ANDESITE_ORNAMENT.get())).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.ANDESITE_ROOFTILES.get(), 4).patternLine(" i ").patternLine("i i").patternLine(" i ").key('i', Blocks.ANDESITE).addCriterion("has_andesite",
            hasItem(Blocks.ANDESITE)).build(consumer, ECConstants.MODID + ":andesite_rooftiles_from_andesite");
        CreateBasicRecipes(consumer, ECBlockRegistry.ANDESITE_ROOFTILES.get(), ECBlockRegistry.ANDESITE_ROOFTILES_STAIRS.get(), ECBlockRegistry.ANDESITE_ROOFTILES_SLAB.get(), null, null, null);

        // Diorite
        ShapelessRecipeBuilder.shapelessRecipe(ECBlockRegistry.DIORITE_BUTTON.get()).addIngredient(Blocks.DIORITE).addCriterion("has_diorite", hasItem(Blocks.DIORITE)).build(consumer);

        CookingRecipeBuilder.smeltingRecipe(Ingredient.fromItems(Items.DIORITE), ECItemRegistry.SMOOTH_DIORITE_ITEM.get(), 0.1f, 200).addCriterion("has_diorite", hasItem(Items.DIORITE)).build(consumer,
            ECConstants.MODID + ":smooth_diorite_from_smelting");

        ShapelessRecipeBuilder.shapelessRecipe(ECBlockRegistry.SMOOTH_DIORITE.get()).addIngredient(Blocks.POLISHED_DIORITE).addCriterion("has_polished_diorite", hasItem(Blocks.POLISHED_DIORITE)).build(
            consumer);
        CreateBasicRecipes(consumer, ECBlockRegistry.SMOOTH_DIORITE.get(), ECBlockRegistry.SMOOTH_DIORITE_STAIRS.get(), ECBlockRegistry.SMOOTH_DIORITE_SLAB.get(), ECBlockRegistry.SMOOTH_DIORITE_WALL.get(),
            ECBlockRegistry.SMOOTH_DIORITE_PRESSURE_PLATE.get(), null);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.DIORITE_PAVING.get(), 4).patternLine("ii").patternLine("ii").key('i', Blocks.POLISHED_DIORITE).addCriterion("has_polished_diorite",
            hasItem(Blocks.POLISHED_DIORITE)).build(consumer);
        CreateBasicRecipes(consumer, ECBlockRegistry.DIORITE_PAVING.get(), ECBlockRegistry.DIORITE_PAVING_STAIRS.get(), ECBlockRegistry.DIORITE_PAVING_SLAB.get(), ECBlockRegistry.DIORITE_PAVING_WALL.get(),
            ECBlockRegistry.DIORITE_PAVING_PRESSURE_PLATE.get(), null);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.DIORITE_TILES.get(), 4).patternLine("ii").patternLine("ii").key('i', ECBlockRegistry.DIORITE_PAVING.get()).addCriterion("has_diorite_paving",
            hasItem(ECBlockRegistry.DIORITE_PAVING.get())).build(consumer);
        CreateBasicRecipes(consumer, ECBlockRegistry.DIORITE_TILES.get(), ECBlockRegistry.DIORITE_TILES_STAIRS.get(), ECBlockRegistry.DIORITE_TILES_SLAB.get(), ECBlockRegistry.DIORITE_TILES_WALL.get(),
            ECBlockRegistry.DIORITE_TILES_PRESSURE_PLATE.get(), null);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.DIORITE_BRICKS.get(), 4).patternLine("ii").patternLine("ii").key('i', ECBlockRegistry.SMOOTH_DIORITE.get()).addCriterion("has_smooth_diorite",
            hasItem(ECBlockRegistry.SMOOTH_DIORITE.get())).build(consumer);
        CreateBasicRecipes(consumer, ECBlockRegistry.DIORITE_BRICKS.get(), ECBlockRegistry.DIORITE_BRICKS_STAIRS.get(), ECBlockRegistry.DIORITE_BRICKS_SLAB.get(), ECBlockRegistry.DIORITE_BRICKS_WALL.get(),
            ECBlockRegistry.DIORITE_BRICKS_PRESSURE_PLATE.get(), null);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.DIORITE_LARGE_BRICKS.get(), 4).patternLine("ii").patternLine("ii").key('i', ECBlockRegistry.DIORITE_BRICKS.get()).addCriterion("has_diorite_bricks",
            hasItem(ECBlockRegistry.DIORITE_BRICKS.get())).build(consumer);
        CreateBasicRecipes(consumer, ECBlockRegistry.DIORITE_LARGE_BRICKS.get(), ECBlockRegistry.DIORITE_LARGE_BRICKS_STAIRS.get(), ECBlockRegistry.DIORITE_LARGE_BRICKS_SLAB.get(),
            ECBlockRegistry.DIORITE_LARGE_BRICKS_WALL.get(), ECBlockRegistry.DIORITE_LARGE_BRICKS_PRESSURE_PLATE.get(), null);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.DIORITE_PAVING_STONES.get(), 4).patternLine(" i ").patternLine("i i").patternLine(" i ").key('i', ECBlockRegistry.DIORITE_BRICKS.get()).addCriterion(
            "has_diorite_bricks", hasItem(ECBlockRegistry.DIORITE_BRICKS.get())).build(consumer);
        CreateBasicRecipes(consumer, ECBlockRegistry.DIORITE_PAVING_STONES.get(), ECBlockRegistry.DIORITE_PAVING_STONES_STAIRS.get(), ECBlockRegistry.DIORITE_PAVING_STONES_SLAB.get(),
            ECBlockRegistry.DIORITE_PAVING_STONES_WALL.get(), ECBlockRegistry.DIORITE_PAVING_STONES_PRESSURE_PLATE.get(), null);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.DIORITE_ORNAMENT.get()).patternLine(" i ").patternLine("i i").patternLine(" i ").key('i', ECBlockRegistry.SMOOTH_DIORITE_SLAB.get()).addCriterion(
            "has_smooth_diorite_slab", hasItem(ECBlockRegistry.SMOOTH_DIORITE_SLAB.get())).build(consumer, ECConstants.MODID + ":diorite_ornament_from_smooth_slabs");
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.DIORITE_ORNAMENT.get()).patternLine(" i ").patternLine("i i").patternLine(" i ").key('i', Blocks.POLISHED_DIORITE_SLAB).addCriterion(
            "has_polished_diorite_slab", hasItem(Blocks.POLISHED_DIORITE_SLAB)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.DIORITE_ORNAMENT_PRESSURE_PLATE.get()).key('#', ECBlockRegistry.DIORITE_ORNAMENT.get()).patternLine("##").addCriterion("has_diorite_ornament",
            hasItem(ECBlockRegistry.DIORITE_ORNAMENT.get())).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.DIORITE_ROOFTILES.get(), 4).patternLine(" i ").patternLine("i i").patternLine(" i ").key('i', Blocks.DIORITE).addCriterion("has_diorite",
            hasItem(Blocks.DIORITE)).build(consumer, ECConstants.MODID + ":diorite_rooftiles_from_diorite");
        CreateBasicRecipes(consumer, ECBlockRegistry.DIORITE_ROOFTILES.get(), ECBlockRegistry.DIORITE_ROOFTILES_STAIRS.get(), ECBlockRegistry.DIORITE_ROOFTILES_SLAB.get(), null, null, null);

        // Granite
        ShapelessRecipeBuilder.shapelessRecipe(ECBlockRegistry.GRANITE_BUTTON.get()).addIngredient(Blocks.GRANITE).addCriterion("has_granite", hasItem(Blocks.GRANITE)).build(consumer);

        CookingRecipeBuilder.smeltingRecipe(Ingredient.fromItems(Items.GRANITE), ECItemRegistry.SMOOTH_GRANITE_ITEM.get(), 0.1f, 200).addCriterion("has_granite", hasItem(Items.GRANITE)).build(consumer,
            ECConstants.MODID + ":smooth_granite_from_smelting");

        ShapelessRecipeBuilder.shapelessRecipe(ECBlockRegistry.SMOOTH_GRANITE.get()).addIngredient(Blocks.POLISHED_GRANITE).addCriterion("has_polished_granite", hasItem(Blocks.POLISHED_GRANITE)).build(
            consumer);
        CreateBasicRecipes(consumer, ECBlockRegistry.SMOOTH_GRANITE.get(), ECBlockRegistry.SMOOTH_GRANITE_STAIRS.get(), ECBlockRegistry.SMOOTH_GRANITE_SLAB.get(), ECBlockRegistry.SMOOTH_GRANITE_WALL.get(),
            ECBlockRegistry.SMOOTH_GRANITE_PRESSURE_PLATE.get(), null);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.GRANITE_PAVING.get(), 4).patternLine("ii").patternLine("ii").key('i', Blocks.POLISHED_GRANITE).addCriterion("has_polished_granite",
            hasItem(Blocks.POLISHED_GRANITE)).build(consumer);
        CreateBasicRecipes(consumer, ECBlockRegistry.GRANITE_PAVING.get(), ECBlockRegistry.GRANITE_PAVING_STAIRS.get(), ECBlockRegistry.GRANITE_PAVING_SLAB.get(), ECBlockRegistry.GRANITE_PAVING_WALL.get(),
            ECBlockRegistry.GRANITE_PAVING_PRESSURE_PLATE.get(), null);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.GRANITE_TILES.get(), 4).patternLine("ii").patternLine("ii").key('i', ECBlockRegistry.GRANITE_PAVING.get()).addCriterion("has_granite_paving",
            hasItem(ECBlockRegistry.GRANITE_PAVING.get())).build(consumer);
        CreateBasicRecipes(consumer, ECBlockRegistry.GRANITE_TILES.get(), ECBlockRegistry.GRANITE_TILES_STAIRS.get(), ECBlockRegistry.GRANITE_TILES_SLAB.get(), ECBlockRegistry.GRANITE_TILES_WALL.get(),
            ECBlockRegistry.GRANITE_TILES_PRESSURE_PLATE.get(), null);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.GRANITE_BRICKS.get(), 4).patternLine("ii").patternLine("ii").key('i', ECBlockRegistry.SMOOTH_GRANITE.get()).addCriterion("has_smooth_granite",
            hasItem(ECBlockRegistry.SMOOTH_GRANITE.get())).build(consumer);
        CreateBasicRecipes(consumer, ECBlockRegistry.GRANITE_BRICKS.get(), ECBlockRegistry.GRANITE_BRICKS_STAIRS.get(), ECBlockRegistry.GRANITE_BRICKS_SLAB.get(), ECBlockRegistry.GRANITE_BRICKS_WALL.get(),
            ECBlockRegistry.GRANITE_BRICKS_PRESSURE_PLATE.get(), null);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.GRANITE_LARGE_BRICKS.get(), 4).patternLine("ii").patternLine("ii").key('i', ECBlockRegistry.GRANITE_BRICKS.get()).addCriterion("has_granite_bricks",
            hasItem(ECBlockRegistry.GRANITE_BRICKS.get())).build(consumer);
        CreateBasicRecipes(consumer, ECBlockRegistry.GRANITE_LARGE_BRICKS.get(), ECBlockRegistry.GRANITE_LARGE_BRICKS_STAIRS.get(), ECBlockRegistry.GRANITE_LARGE_BRICKS_SLAB.get(),
            ECBlockRegistry.GRANITE_LARGE_BRICKS_WALL.get(), ECBlockRegistry.GRANITE_LARGE_BRICKS_PRESSURE_PLATE.get(), null);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.GRANITE_PAVING_STONES.get(), 4).patternLine(" i ").patternLine("i i").patternLine(" i ").key('i', ECBlockRegistry.GRANITE_BRICKS.get()).addCriterion(
            "has_granite_bricks", hasItem(ECBlockRegistry.GRANITE_BRICKS.get())).build(consumer);
        CreateBasicRecipes(consumer, ECBlockRegistry.GRANITE_PAVING_STONES.get(), ECBlockRegistry.GRANITE_PAVING_STONES_STAIRS.get(), ECBlockRegistry.GRANITE_PAVING_STONES_SLAB.get(),
            ECBlockRegistry.GRANITE_PAVING_STONES_WALL.get(), ECBlockRegistry.GRANITE_PAVING_STONES_PRESSURE_PLATE.get(), null);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.GRANITE_ORNAMENT.get()).patternLine(" i ").patternLine("i i").patternLine(" i ").key('i', ECBlockRegistry.SMOOTH_GRANITE_SLAB.get()).addCriterion(
            "has_smooth_granite_slab", hasItem(ECBlockRegistry.SMOOTH_GRANITE_SLAB.get())).build(consumer, ECConstants.MODID + ":granite_ornament_from_smooth_slabs");
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.GRANITE_ORNAMENT.get()).patternLine(" i ").patternLine("i i").patternLine(" i ").key('i', Blocks.POLISHED_GRANITE_SLAB).addCriterion(
            "has_polished_granite_slab", hasItem(Blocks.POLISHED_GRANITE_SLAB)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.GRANITE_ORNAMENT_PRESSURE_PLATE.get()).key('#', ECBlockRegistry.GRANITE_ORNAMENT.get()).patternLine("##").addCriterion("has_granite_ornament",
            hasItem(ECBlockRegistry.GRANITE_ORNAMENT.get())).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.GRANITE_ROOFTILES.get(), 4).patternLine(" i ").patternLine("i i").patternLine(" i ").key('i', Blocks.GRANITE).addCriterion("has_granite",
            hasItem(Blocks.GRANITE)).build(consumer, ECConstants.MODID + ":granite_rooftiles_from_granite");
        CreateBasicRecipes(consumer, ECBlockRegistry.GRANITE_ROOFTILES.get(), ECBlockRegistry.GRANITE_ROOFTILES_STAIRS.get(), ECBlockRegistry.GRANITE_ROOFTILES_SLAB.get(), null, null, null);

        // Sandstone
        ShapelessRecipeBuilder.shapelessRecipe(ECBlockRegistry.SANDSTONE_BUTTON.get()).addIngredient(Blocks.SANDSTONE).addCriterion("has_sandstone", hasItem(Blocks.SANDSTONE)).build(consumer);

        ShapelessRecipeBuilder.shapelessRecipe(ECBlockRegistry.POLISHED_SANDSTONE.get()).addIngredient(Blocks.SMOOTH_SANDSTONE).addCriterion("has_smooth_sandstone", hasItem(Blocks.SMOOTH_SANDSTONE)).build(
            consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.POLISHED_SANDSTONE_SLAB.get(), 6).patternLine("iii").key('i', ECBlockRegistry.POLISHED_SANDSTONE.get()).addCriterion("has_polished_sandstone",
            hasItem(ECBlockRegistry.POLISHED_SANDSTONE.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.POLISHED_SANDSTONE.get()).patternLine("i").patternLine("i").key('i', ECBlockRegistry.POLISHED_SANDSTONE_SLAB.get()).addCriterion(
            "has_polished_sandstone_slab", hasItem(ECBlockRegistry.POLISHED_SANDSTONE_SLAB.get())).build(consumer, ECConstants.MODID + ":polished_sandstone_from_slabs");
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.POLISHED_SANDSTONE_STAIRS.get(), 4).key('#', ECBlockRegistry.POLISHED_SANDSTONE.get()).patternLine("#  ").patternLine("## ").patternLine(
            "###").addCriterion("has_polished_sandstone", hasItem(ECBlockRegistry.POLISHED_SANDSTONE.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.POLISHED_SANDSTONE_WALL.get(), 6).key('#', ECBlockRegistry.POLISHED_SANDSTONE.get()).patternLine("###").patternLine("###").addCriterion(
            "has_polished_sandstone", hasItem(ECBlockRegistry.POLISHED_SANDSTONE.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.POLISHED_SANDSTONE_PRESSURE_PLATE.get()).key('#', ECBlockRegistry.POLISHED_SANDSTONE.get()).patternLine("##").addCriterion("has_polished_sandstone",
            hasItem(ECBlockRegistry.POLISHED_SANDSTONE.get())).build(consumer);

        ShapelessRecipeBuilder.shapelessRecipe(Blocks.SMOOTH_SANDSTONE).addIngredient(ECBlockRegistry.POLISHED_SANDSTONE.get()).addCriterion("has_polished_sandstone",
            hasItem(ECBlockRegistry.POLISHED_SANDSTONE.get())).build(consumer, ECConstants.MODID + "smooth_sandstone_from_polished_sandstone");
        ShapedRecipeBuilder.shapedRecipe(Blocks.SMOOTH_SANDSTONE).patternLine("i").patternLine("i").key('i', Blocks.SMOOTH_SANDSTONE_SLAB).addCriterion("has_smooth_sandstone_slab",
            hasItem(Blocks.SMOOTH_SANDSTONE_SLAB)).build(consumer, ECConstants.MODID + ":smooth_sandstone_from_slabs");
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.SMOOTH_SANDSTONE_WALL.get(), 6).key('#', Blocks.SMOOTH_SANDSTONE).patternLine("###").patternLine("###").addCriterion("has_smooth_sandstone",
            hasItem(Blocks.SMOOTH_SANDSTONE)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.SMOOTH_SANDSTONE_PRESSURE_PLATE.get()).key('#', Blocks.SMOOTH_SANDSTONE).patternLine("##").addCriterion("has_smooth_sandstone",
            hasItem(Blocks.SMOOTH_SANDSTONE)).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.SANDSTONE_PAVING.get(), 4).patternLine("ii").patternLine("ii").key('i', ECBlockRegistry.POLISHED_SANDSTONE.get()).addCriterion("has_polished_sandstone",
            hasItem(ECBlockRegistry.POLISHED_SANDSTONE.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.SANDSTONE_PAVING_SLAB.get(), 6).patternLine("iii").key('i', ECBlockRegistry.SANDSTONE_PAVING.get()).addCriterion("has_sandstone_paving",
            hasItem(ECBlockRegistry.SANDSTONE_PAVING.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.SANDSTONE_PAVING.get()).patternLine("i").patternLine("i").key('i', ECBlockRegistry.SANDSTONE_PAVING_SLAB.get()).addCriterion("has_sandstone_paving_slab",
            hasItem(ECBlockRegistry.SANDSTONE_PAVING_SLAB.get())).build(consumer, ECConstants.MODID + ":sandstone_paving_from_slabs");
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.SANDSTONE_PAVING_STAIRS.get(), 4).key('#', ECBlockRegistry.SANDSTONE_PAVING.get()).patternLine("#  ").patternLine("## ").patternLine("###").addCriterion(
            "has_sandstone_paving", hasItem(ECBlockRegistry.SANDSTONE_PAVING.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.SANDSTONE_PAVING_WALL.get(), 6).key('#', ECBlockRegistry.SANDSTONE_PAVING.get()).patternLine("###").patternLine("###").addCriterion(
            "has_sandstone_paving", hasItem(ECBlockRegistry.SANDSTONE_PAVING.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.SANDSTONE_PAVING_PRESSURE_PLATE.get()).key('#', ECBlockRegistry.SANDSTONE_PAVING.get()).patternLine("##").addCriterion("has_sandstone_paving",
            hasItem(ECBlockRegistry.SANDSTONE_PAVING.get())).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.SANDSTONE_TILES.get(), 4).patternLine("ii").patternLine("ii").key('i', ECBlockRegistry.SANDSTONE_PAVING.get()).addCriterion("has_sandstone_paving",
            hasItem(ECBlockRegistry.SANDSTONE_PAVING.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.SANDSTONE_TILES_SLAB.get(), 6).patternLine("iii").key('i', ECBlockRegistry.SANDSTONE_TILES.get()).addCriterion("has_sandstone_tiles",
            hasItem(ECBlockRegistry.SANDSTONE_TILES.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.SANDSTONE_TILES.get()).patternLine("i").patternLine("i").key('i', ECBlockRegistry.SANDSTONE_TILES_SLAB.get()).addCriterion("has_sandstone_tiles_slab",
            hasItem(ECBlockRegistry.SANDSTONE_TILES_SLAB.get())).build(consumer, ECConstants.MODID + ":sandstone_tiles_from_slabs");
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.SANDSTONE_TILES_STAIRS.get(), 4).key('#', ECBlockRegistry.SANDSTONE_TILES.get()).patternLine("#  ").patternLine("## ").patternLine("###").addCriterion(
            "has_sandstone_tiles", hasItem(ECBlockRegistry.SANDSTONE_TILES.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.SANDSTONE_TILES_WALL.get(), 6).key('#', ECBlockRegistry.SANDSTONE_TILES.get()).patternLine("###").patternLine("###").addCriterion("has_sandstone_tiles",
            hasItem(ECBlockRegistry.SANDSTONE_TILES.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.SANDSTONE_TILES_PRESSURE_PLATE.get()).key('#', ECBlockRegistry.SANDSTONE_TILES.get()).patternLine("##").addCriterion("has_sandstone_tiles",
            hasItem(ECBlockRegistry.SANDSTONE_TILES.get())).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.SANDSTONE_BRICKS.get(), 4).patternLine("ii").patternLine("ii").key('i', Blocks.CUT_SANDSTONE).addCriterion("has_cut_sandstone",
            hasItem(Blocks.CUT_SANDSTONE)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.SANDSTONE_BRICKS_SLAB.get(), 6).patternLine("iii").key('i', ECBlockRegistry.SANDSTONE_BRICKS.get()).addCriterion("has_sandstone_bricks",
            hasItem(ECBlockRegistry.SANDSTONE_BRICKS.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.SANDSTONE_BRICKS.get()).patternLine("i").patternLine("i").key('i', ECBlockRegistry.SANDSTONE_BRICKS_SLAB.get()).addCriterion("has_sandstone_bricks_slab",
            hasItem(ECBlockRegistry.SANDSTONE_BRICKS_SLAB.get())).build(consumer, ECConstants.MODID + ":sandstone_bricks_from_slabs");
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.SANDSTONE_BRICKS_STAIRS.get(), 4).key('#', ECBlockRegistry.SANDSTONE_BRICKS.get()).patternLine("#  ").patternLine("## ").patternLine("###").addCriterion(
            "has_sandstone_bricks", hasItem(ECBlockRegistry.SANDSTONE_BRICKS.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.SANDSTONE_BRICKS_WALL.get(), 6).key('#', ECBlockRegistry.SANDSTONE_BRICKS.get()).patternLine("###").patternLine("###").addCriterion(
            "has_sandstone_bricks", hasItem(ECBlockRegistry.SANDSTONE_BRICKS.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.SANDSTONE_BRICKS_PRESSURE_PLATE.get()).key('#', ECBlockRegistry.SANDSTONE_BRICKS.get()).patternLine("##").addCriterion("has_sandstone_bricks",
            hasItem(ECBlockRegistry.SANDSTONE_BRICKS.get())).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.SANDSTONE_LARGE_BRICKS.get(), 4).patternLine("ii").patternLine("ii").key('i', ECBlockRegistry.SANDSTONE_BRICKS.get()).addCriterion(
            "has_sandstone_bricks", hasItem(ECBlockRegistry.SANDSTONE_BRICKS.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.SANDSTONE_LARGE_BRICKS_SLAB.get(), 6).patternLine("iii").key('i', ECBlockRegistry.SANDSTONE_LARGE_BRICKS.get()).addCriterion(
            "has_sandstone_large_bricks", hasItem(ECBlockRegistry.SANDSTONE_LARGE_BRICKS.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.SANDSTONE_LARGE_BRICKS.get()).patternLine("i").patternLine("i").key('i', ECBlockRegistry.SANDSTONE_LARGE_BRICKS_SLAB.get()).addCriterion(
            "has_sandstone_large_bricks_slab", hasItem(ECBlockRegistry.SANDSTONE_LARGE_BRICKS_SLAB.get())).build(consumer, ECConstants.MODID + ":sandstone_large_bricks_from_slabs");
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.SANDSTONE_LARGE_BRICKS_STAIRS.get(), 4).key('#', ECBlockRegistry.SANDSTONE_LARGE_BRICKS.get()).patternLine("#  ").patternLine("## ").patternLine(
            "###").addCriterion("has_sandstone_large_bricks", hasItem(ECBlockRegistry.SANDSTONE_LARGE_BRICKS.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.SANDSTONE_LARGE_BRICKS_WALL.get(), 6).key('#', ECBlockRegistry.SANDSTONE_LARGE_BRICKS.get()).patternLine("###").patternLine("###").addCriterion(
            "has_sandstone_large_bricks", hasItem(ECBlockRegistry.SANDSTONE_LARGE_BRICKS.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.SANDSTONE_LARGE_BRICKS_PRESSURE_PLATE.get()).key('#', ECBlockRegistry.SANDSTONE_LARGE_BRICKS.get()).patternLine("##").addCriterion(
            "has_sandstone_large_bricks", hasItem(ECBlockRegistry.SANDSTONE_LARGE_BRICKS.get())).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.SANDSTONE_PAVING_STONES.get(), 4).patternLine(" i ").patternLine("i i").patternLine(" i ").key('i', ECBlockRegistry.SANDSTONE_BRICKS.get()).addCriterion(
            "has_sandstone_bricks", hasItem(ECBlockRegistry.SANDSTONE_BRICKS.get())).build(consumer);
        CreateBasicRecipes(consumer, ECBlockRegistry.SANDSTONE_PAVING_STONES.get(), ECBlockRegistry.SANDSTONE_PAVING_STONES_STAIRS.get(), ECBlockRegistry.SANDSTONE_PAVING_STONES_SLAB.get(),
            ECBlockRegistry.SANDSTONE_PAVING_STONES_WALL.get(), ECBlockRegistry.SANDSTONE_PAVING_STONES_PRESSURE_PLATE.get(), null);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.SANDSTONE_ROOFTILES.get(), 4).patternLine(" i ").patternLine("i i").patternLine(" i ").key('i', Blocks.SANDSTONE).addCriterion("has_sandstone",
            hasItem(Blocks.SANDSTONE)).build(consumer, ECConstants.MODID + ":sandstone_rooftiles_from_sandstone");
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.SANDSTONE_ROOFTILES_SLAB.get(), 6).patternLine("iii").key('i', ECBlockRegistry.SANDSTONE_ROOFTILES.get()).addCriterion("has_sandstone_rooftiles",
            hasItem(ECBlockRegistry.SANDSTONE_ROOFTILES.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.SANDSTONE_ROOFTILES.get()).patternLine("i").patternLine("i").key('i', ECBlockRegistry.SANDSTONE_ROOFTILES_SLAB.get()).addCriterion(
            "has_sandstone_rooftiles_slab", hasItem(ECBlockRegistry.SANDSTONE_ROOFTILES_SLAB.get())).build(consumer, ECConstants.MODID + ":sandstone_rooftiles_from_slabs");
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.SANDSTONE_ROOFTILES_STAIRS.get(), 4).key('#', ECBlockRegistry.SANDSTONE_ROOFTILES.get()).patternLine("#  ").patternLine("## ").patternLine(
            "###").addCriterion("has_sandstone_rooftiles", hasItem(ECBlockRegistry.SANDSTONE_ROOFTILES.get())).build(consumer);

        // Red Sandstone
        ShapelessRecipeBuilder.shapelessRecipe(ECBlockRegistry.RED_SANDSTONE_BUTTON.get()).addIngredient(Blocks.RED_SANDSTONE).addCriterion("has_red_sandstone", hasItem(Blocks.RED_SANDSTONE)).build(consumer);

        ShapelessRecipeBuilder.shapelessRecipe(ECBlockRegistry.POLISHED_RED_SANDSTONE.get()).addIngredient(Blocks.SMOOTH_RED_SANDSTONE).addCriterion("has_smooth_red_sandstone",
            hasItem(Blocks.SMOOTH_RED_SANDSTONE)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.POLISHED_RED_SANDSTONE_SLAB.get(), 6).patternLine("iii").key('i', ECBlockRegistry.POLISHED_RED_SANDSTONE.get()).addCriterion(
            "has_polished_red_sandstone", hasItem(ECBlockRegistry.POLISHED_RED_SANDSTONE.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.POLISHED_RED_SANDSTONE.get()).patternLine("i").patternLine("i").key('i', ECBlockRegistry.POLISHED_RED_SANDSTONE_SLAB.get()).addCriterion(
            "has_polished_red_sandstone_slab", hasItem(ECBlockRegistry.POLISHED_RED_SANDSTONE_SLAB.get())).build(consumer, ECConstants.MODID + ":polished_red_sandstone_from_slabs");
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.POLISHED_RED_SANDSTONE_STAIRS.get(), 4).key('#', ECBlockRegistry.POLISHED_RED_SANDSTONE.get()).patternLine("#  ").patternLine("## ").patternLine(
            "###").addCriterion("has_polished_red_sandstone", hasItem(ECBlockRegistry.POLISHED_RED_SANDSTONE.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.POLISHED_RED_SANDSTONE_WALL.get(), 6).key('#', ECBlockRegistry.POLISHED_RED_SANDSTONE.get()).patternLine("###").patternLine("###").addCriterion(
            "has_polished_red_sandstone", hasItem(ECBlockRegistry.POLISHED_RED_SANDSTONE.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.POLISHED_RED_SANDSTONE_PRESSURE_PLATE.get()).key('#', ECBlockRegistry.POLISHED_RED_SANDSTONE.get()).patternLine("##").addCriterion(
            "has_polished_red_sandstone", hasItem(ECBlockRegistry.POLISHED_RED_SANDSTONE.get())).build(consumer);

        ShapelessRecipeBuilder.shapelessRecipe(Blocks.SMOOTH_RED_SANDSTONE).addIngredient(ECBlockRegistry.POLISHED_RED_SANDSTONE.get()).addCriterion("has_polished_red_sandstone",
            hasItem(ECBlockRegistry.POLISHED_RED_SANDSTONE.get())).build(consumer, ECConstants.MODID + "smooth_red_sandstone_from_polished_red_sandstone");
        ShapedRecipeBuilder.shapedRecipe(Blocks.SMOOTH_RED_SANDSTONE).patternLine("i").patternLine("i").key('i', Blocks.SMOOTH_RED_SANDSTONE_SLAB).addCriterion("has_smooth_red_sandstone_slab",
            hasItem(Blocks.SMOOTH_RED_SANDSTONE_SLAB)).build(consumer, ECConstants.MODID + ":smooth_red_sandstone_from_slabs");
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.SMOOTH_RED_SANDSTONE_WALL.get(), 6).key('#', Blocks.SMOOTH_RED_SANDSTONE).patternLine("###").patternLine("###").addCriterion("has_smooth_red_sandstone",
            hasItem(Blocks.SMOOTH_RED_SANDSTONE)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.SMOOTH_RED_SANDSTONE_PRESSURE_PLATE.get()).key('#', Blocks.SMOOTH_RED_SANDSTONE).patternLine("##").addCriterion("has_smooth_red_sandstone",
            hasItem(Blocks.SMOOTH_RED_SANDSTONE)).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.RED_SANDSTONE_PAVING.get(), 4).patternLine("ii").patternLine("ii").key('i', ECBlockRegistry.POLISHED_RED_SANDSTONE.get()).addCriterion(
            "has_polished_red_sandstone", hasItem(ECBlockRegistry.POLISHED_RED_SANDSTONE.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.RED_SANDSTONE_PAVING_SLAB.get(), 6).patternLine("iii").key('i', ECBlockRegistry.RED_SANDSTONE_PAVING.get()).addCriterion("has_red_sandstone_paving",
            hasItem(ECBlockRegistry.RED_SANDSTONE_PAVING.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.RED_SANDSTONE_PAVING.get()).patternLine("i").patternLine("i").key('i', ECBlockRegistry.RED_SANDSTONE_PAVING_SLAB.get()).addCriterion(
            "has_red_sandstone_paving_slab", hasItem(ECBlockRegistry.RED_SANDSTONE_PAVING_SLAB.get())).build(consumer, ECConstants.MODID + ":red_sandstone_paving_from_slabs");
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.RED_SANDSTONE_PAVING_STAIRS.get(), 4).key('#', ECBlockRegistry.RED_SANDSTONE_PAVING.get()).patternLine("#  ").patternLine("## ").patternLine(
            "###").addCriterion("has_red_sandstone_paving", hasItem(ECBlockRegistry.RED_SANDSTONE_PAVING.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.RED_SANDSTONE_PAVING_WALL.get(), 6).key('#', ECBlockRegistry.RED_SANDSTONE_PAVING.get()).patternLine("###").patternLine("###").addCriterion(
            "has_red_sandstone_paving", hasItem(ECBlockRegistry.RED_SANDSTONE_PAVING.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.RED_SANDSTONE_PAVING_PRESSURE_PLATE.get()).key('#', ECBlockRegistry.RED_SANDSTONE_PAVING.get()).patternLine("##").addCriterion(
            "has_red_sandstone_paving", hasItem(ECBlockRegistry.RED_SANDSTONE_PAVING.get())).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.RED_SANDSTONE_TILES.get(), 4).patternLine("ii").patternLine("ii").key('i', ECBlockRegistry.RED_SANDSTONE_PAVING.get()).addCriterion(
            "has_red_sandstone_paving", hasItem(ECBlockRegistry.RED_SANDSTONE_PAVING.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.RED_SANDSTONE_TILES_SLAB.get(), 6).patternLine("iii").key('i', ECBlockRegistry.RED_SANDSTONE_TILES.get()).addCriterion("has_red_sandstone_tiles",
            hasItem(ECBlockRegistry.RED_SANDSTONE_TILES.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.RED_SANDSTONE_TILES.get()).patternLine("i").patternLine("i").key('i', ECBlockRegistry.RED_SANDSTONE_TILES_SLAB.get()).addCriterion(
            "has_red_sandstone_tiles_slab", hasItem(ECBlockRegistry.RED_SANDSTONE_TILES_SLAB.get())).build(consumer, ECConstants.MODID + ":red_sandstone_tiles_from_slabs");
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.RED_SANDSTONE_TILES_STAIRS.get(), 4).key('#', ECBlockRegistry.RED_SANDSTONE_TILES.get()).patternLine("#  ").patternLine("## ").patternLine(
            "###").addCriterion("has_red_sandstone_tiles", hasItem(ECBlockRegistry.RED_SANDSTONE_TILES.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.RED_SANDSTONE_TILES_WALL.get(), 6).key('#', ECBlockRegistry.RED_SANDSTONE_TILES.get()).patternLine("###").patternLine("###").addCriterion(
            "has_red_sandstone_tiles", hasItem(ECBlockRegistry.RED_SANDSTONE_TILES.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.RED_SANDSTONE_TILES_PRESSURE_PLATE.get()).key('#', ECBlockRegistry.RED_SANDSTONE_TILES.get()).patternLine("##").addCriterion("has_red_sandstone_tiles",
            hasItem(ECBlockRegistry.RED_SANDSTONE_TILES.get())).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.RED_SANDSTONE_BRICKS.get(), 4).patternLine("ii").patternLine("ii").key('i', Blocks.CUT_RED_SANDSTONE).addCriterion("has_cut_red_sandstone",
            hasItem(Blocks.CUT_RED_SANDSTONE)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.RED_SANDSTONE_BRICKS_SLAB.get(), 6).patternLine("iii").key('i', ECBlockRegistry.RED_SANDSTONE_BRICKS.get()).addCriterion("has_red_sandstone_bricks",
            hasItem(ECBlockRegistry.RED_SANDSTONE_BRICKS.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.RED_SANDSTONE_BRICKS.get()).patternLine("i").patternLine("i").key('i', ECBlockRegistry.RED_SANDSTONE_BRICKS_SLAB.get()).addCriterion(
            "has_red_sandstone_bricks_slab", hasItem(ECBlockRegistry.RED_SANDSTONE_BRICKS_SLAB.get())).build(consumer, ECConstants.MODID + ":red_sandstone_bricks_from_slabs");
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.RED_SANDSTONE_BRICKS_STAIRS.get(), 4).key('#', ECBlockRegistry.RED_SANDSTONE_BRICKS.get()).patternLine("#  ").patternLine("## ").patternLine(
            "###").addCriterion("has_red_sandstone_bricks", hasItem(ECBlockRegistry.RED_SANDSTONE_BRICKS.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.RED_SANDSTONE_BRICKS_WALL.get(), 6).key('#', ECBlockRegistry.RED_SANDSTONE_BRICKS.get()).patternLine("###").patternLine("###").addCriterion(
            "has_red_sandstone_bricks", hasItem(ECBlockRegistry.RED_SANDSTONE_BRICKS.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.RED_SANDSTONE_BRICKS_PRESSURE_PLATE.get()).key('#', ECBlockRegistry.RED_SANDSTONE_BRICKS.get()).patternLine("##").addCriterion(
            "has_red_sandstone_bricks", hasItem(ECBlockRegistry.RED_SANDSTONE_BRICKS.get())).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.RED_SANDSTONE_LARGE_BRICKS.get(), 4).patternLine("ii").patternLine("ii").key('i', ECBlockRegistry.RED_SANDSTONE_BRICKS.get()).addCriterion(
            "has_red_sandstone_bricks", hasItem(ECBlockRegistry.RED_SANDSTONE_BRICKS.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.RED_SANDSTONE_LARGE_BRICKS_SLAB.get(), 6).patternLine("iii").key('i', ECBlockRegistry.RED_SANDSTONE_LARGE_BRICKS.get()).addCriterion(
            "has_red_sandstone_large_bricks", hasItem(ECBlockRegistry.RED_SANDSTONE_LARGE_BRICKS.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.RED_SANDSTONE_LARGE_BRICKS.get()).patternLine("i").patternLine("i").key('i', ECBlockRegistry.RED_SANDSTONE_LARGE_BRICKS_SLAB.get()).addCriterion(
            "has_red_sandstone_large_bricks_slab", hasItem(ECBlockRegistry.RED_SANDSTONE_LARGE_BRICKS_SLAB.get())).build(consumer, ECConstants.MODID + ":red_sandstone_large_bricks_from_slabs");
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.RED_SANDSTONE_LARGE_BRICKS_STAIRS.get(), 4).key('#', ECBlockRegistry.RED_SANDSTONE_LARGE_BRICKS.get()).patternLine("#  ").patternLine("## ").patternLine(
            "###").addCriterion("has_red_sandstone_large_bricks", hasItem(ECBlockRegistry.RED_SANDSTONE_LARGE_BRICKS.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.RED_SANDSTONE_LARGE_BRICKS_WALL.get(), 6).key('#', ECBlockRegistry.RED_SANDSTONE_LARGE_BRICKS.get()).patternLine("###").patternLine("###").addCriterion(
            "has_red_sandstone_large_bricks", hasItem(ECBlockRegistry.RED_SANDSTONE_LARGE_BRICKS.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.RED_SANDSTONE_LARGE_BRICKS_PRESSURE_PLATE.get()).key('#', ECBlockRegistry.RED_SANDSTONE_LARGE_BRICKS.get()).patternLine("##").addCriterion(
            "has_red_sandstone_large_bricks", hasItem(ECBlockRegistry.RED_SANDSTONE_LARGE_BRICKS.get())).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.RED_SANDSTONE_PAVING_STONES.get(), 4).patternLine(" i ").patternLine("i i").patternLine(" i ").key('i',
            ECBlockRegistry.RED_SANDSTONE_BRICKS.get()).addCriterion("has_red_sandstone_bricks", hasItem(ECBlockRegistry.RED_SANDSTONE_BRICKS.get())).build(consumer);
        CreateBasicRecipes(consumer, ECBlockRegistry.RED_SANDSTONE_PAVING_STONES.get(), ECBlockRegistry.RED_SANDSTONE_PAVING_STONES_STAIRS.get(), ECBlockRegistry.RED_SANDSTONE_PAVING_STONES_SLAB.get(),
            ECBlockRegistry.RED_SANDSTONE_PAVING_STONES_WALL.get(), ECBlockRegistry.RED_SANDSTONE_PAVING_STONES_PRESSURE_PLATE.get(), null);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.RED_SANDSTONE_ROOFTILES.get(), 4).patternLine(" i ").patternLine("i i").patternLine(" i ").key('i', Blocks.RED_SANDSTONE).addCriterion(
            "has_red_sandstone", hasItem(Blocks.RED_SANDSTONE)).build(consumer, ECConstants.MODID + ":red_sandstone_rooftiles_from_red_sandstone");
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.RED_SANDSTONE_ROOFTILES_SLAB.get(), 6).patternLine("iii").key('i', ECBlockRegistry.RED_SANDSTONE_ROOFTILES.get()).addCriterion(
            "has_red_sandstone_rooftiles", hasItem(ECBlockRegistry.RED_SANDSTONE_ROOFTILES.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.RED_SANDSTONE_ROOFTILES.get()).patternLine("i").patternLine("i").key('i', ECBlockRegistry.RED_SANDSTONE_ROOFTILES_SLAB.get()).addCriterion(
            "has_red_sandstone_rooftiles_slab", hasItem(ECBlockRegistry.RED_SANDSTONE_ROOFTILES_SLAB.get())).build(consumer, ECConstants.MODID + ":red_sandstone_rooftiles_from_slabs");
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.RED_SANDSTONE_ROOFTILES_STAIRS.get(), 4).key('#', ECBlockRegistry.RED_SANDSTONE_ROOFTILES.get()).patternLine("#  ").patternLine("## ").patternLine(
            "###").addCriterion("has_red_sandstone_rooftiles", hasItem(ECBlockRegistry.RED_SANDSTONE_ROOFTILES.get())).build(consumer);

        // Terracotta

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.TERRACOTTA_SLAB.get(), 6).patternLine("iii").key('i', Blocks.TERRACOTTA).addCriterion("has_terracotta", hasItem(Blocks.TERRACOTTA)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(Blocks.TERRACOTTA).patternLine("i").patternLine("i").key('i', ECBlockRegistry.TERRACOTTA_SLAB.get()).addCriterion("has_terracotta_slab",
            hasItem(ECBlockRegistry.TERRACOTTA_SLAB.get())).build(consumer, ECConstants.MODID + ":terracotta_from_slabs");
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.TERRACOTTA_STAIRS.get(), 4).key('#', Blocks.TERRACOTTA).patternLine("#  ").patternLine("## ").patternLine("###").addCriterion("has_terracotta",
            hasItem(Blocks.TERRACOTTA)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.TERRACOTTA_WALL.get(), 6).key('#', Blocks.TERRACOTTA).patternLine("###").patternLine("###").addCriterion("has_terracotta",
            hasItem(Blocks.TERRACOTTA)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.TERRACOTTA_PRESSURE_PLATE.get()).key('#', Blocks.TERRACOTTA).patternLine("##").addCriterion("has_terracotta", hasItem(Blocks.TERRACOTTA)).build(
            consumer);
        ShapelessRecipeBuilder.shapelessRecipe(ECBlockRegistry.TERRACOTTA_BUTTON.get()).addIngredient(Blocks.TERRACOTTA).addCriterion("has_terracotta", hasItem(Blocks.TERRACOTTA)).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.POLISHED_TERRACOTTA.get()).patternLine("i").patternLine("i").key('i', Blocks.TERRACOTTA).addCriterion("has_terracotta",
            hasItem(Blocks.TERRACOTTA)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.POLISHED_TERRACOTTA_SLAB.get(), 6).patternLine("iii").key('i', ECBlockRegistry.POLISHED_TERRACOTTA.get()).addCriterion("has_polished_terracotta",
            hasItem(ECBlockRegistry.POLISHED_TERRACOTTA.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.POLISHED_TERRACOTTA.get()).patternLine("i").patternLine("i").key('i', ECBlockRegistry.POLISHED_TERRACOTTA_SLAB.get()).addCriterion(
            "has_polished_terracotta_slab", hasItem(ECBlockRegistry.POLISHED_TERRACOTTA_SLAB.get())).build(consumer, ECConstants.MODID + ":polished_terracotta_from_slabs");
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.POLISHED_TERRACOTTA_STAIRS.get(), 4).key('#', ECBlockRegistry.POLISHED_TERRACOTTA.get()).patternLine("#  ").patternLine("## ").patternLine(
            "###").addCriterion("has_polished_terracotta", hasItem(ECBlockRegistry.POLISHED_TERRACOTTA.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.POLISHED_TERRACOTTA_WALL.get(), 6).key('#', ECBlockRegistry.POLISHED_TERRACOTTA.get()).patternLine("###").patternLine("###").addCriterion(
            "has_polished_terracotta", hasItem(ECBlockRegistry.POLISHED_TERRACOTTA.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.POLISHED_TERRACOTTA_PRESSURE_PLATE.get()).key('#', ECBlockRegistry.POLISHED_TERRACOTTA.get()).patternLine("##").addCriterion("has_polished_terracotta",
            hasItem(ECBlockRegistry.POLISHED_TERRACOTTA.get())).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.TERRACOTTA_PAVING.get(), 4).patternLine("ii").patternLine("ii").key('i', ECBlockRegistry.POLISHED_TERRACOTTA.get()).addCriterion(
            "has_polished_terracotta", hasItem(ECBlockRegistry.POLISHED_TERRACOTTA.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.TERRACOTTA_PAVING_SLAB.get(), 6).patternLine("iii").key('i', ECBlockRegistry.TERRACOTTA_PAVING.get()).addCriterion("has_terracotta_paving",
            hasItem(ECBlockRegistry.TERRACOTTA_PAVING.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.TERRACOTTA_PAVING.get()).patternLine("i").patternLine("i").key('i', ECBlockRegistry.TERRACOTTA_PAVING_SLAB.get()).addCriterion(
            "has_terracotta_paving_slab", hasItem(ECBlockRegistry.TERRACOTTA_PAVING_SLAB.get())).build(consumer, ECConstants.MODID + ":terracotta_paving_from_slabs");
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.TERRACOTTA_PAVING_STAIRS.get(), 4).key('#', ECBlockRegistry.TERRACOTTA_PAVING.get()).patternLine("#  ").patternLine("## ").patternLine(
            "###").addCriterion("has_terracotta_paving", hasItem(ECBlockRegistry.TERRACOTTA_PAVING.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.TERRACOTTA_PAVING_WALL.get(), 6).key('#', ECBlockRegistry.TERRACOTTA_PAVING.get()).patternLine("###").patternLine("###").addCriterion(
            "has_terracotta_paving", hasItem(ECBlockRegistry.TERRACOTTA_PAVING.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.TERRACOTTA_PAVING_PRESSURE_PLATE.get()).key('#', ECBlockRegistry.TERRACOTTA_PAVING.get()).patternLine("##").addCriterion("has_terracotta_paving",
            hasItem(ECBlockRegistry.TERRACOTTA_PAVING.get())).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.TERRACOTTA_TILES.get(), 4).patternLine("ii").patternLine("ii").key('i', ECBlockRegistry.TERRACOTTA_PAVING.get()).addCriterion("has_terracotta_paving",
            hasItem(ECBlockRegistry.TERRACOTTA_PAVING.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.TERRACOTTA_TILES_SLAB.get(), 6).patternLine("iii").key('i', ECBlockRegistry.TERRACOTTA_TILES.get()).addCriterion("has_terracotta_tiles",
            hasItem(ECBlockRegistry.TERRACOTTA_TILES.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.TERRACOTTA_TILES.get()).patternLine("i").patternLine("i").key('i', ECBlockRegistry.TERRACOTTA_TILES_SLAB.get()).addCriterion("has_terracotta_tiles_slab",
            hasItem(ECBlockRegistry.TERRACOTTA_TILES_SLAB.get())).build(consumer, ECConstants.MODID + ":terracotta_tiles_from_slabs");
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.TERRACOTTA_TILES_STAIRS.get(), 4).key('#', ECBlockRegistry.TERRACOTTA_TILES.get()).patternLine("#  ").patternLine("## ").patternLine("###").addCriterion(
            "has_terracotta_tiles", hasItem(ECBlockRegistry.TERRACOTTA_TILES.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.TERRACOTTA_TILES_WALL.get(), 6).key('#', ECBlockRegistry.TERRACOTTA_TILES.get()).patternLine("###").patternLine("###").addCriterion(
            "has_terracotta_tiles", hasItem(ECBlockRegistry.TERRACOTTA_TILES.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.TERRACOTTA_TILES_PRESSURE_PLATE.get()).key('#', ECBlockRegistry.TERRACOTTA_TILES.get()).patternLine("##").addCriterion("has_terracotta_tiles",
            hasItem(ECBlockRegistry.TERRACOTTA_TILES.get())).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.TERRACOTTA_BRICKS.get(), 4).patternLine("ii").patternLine("ii").key('i', Blocks.TERRACOTTA).addCriterion("has_terracotta",
            hasItem(Blocks.TERRACOTTA)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.TERRACOTTA_BRICKS_SLAB.get(), 6).patternLine("iii").key('i', ECBlockRegistry.TERRACOTTA_BRICKS.get()).addCriterion("has_terracotta_bricks",
            hasItem(ECBlockRegistry.TERRACOTTA_BRICKS.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.TERRACOTTA_BRICKS.get()).patternLine("i").patternLine("i").key('i', ECBlockRegistry.TERRACOTTA_BRICKS_SLAB.get()).addCriterion(
            "has_terracotta_bricks_slab", hasItem(ECBlockRegistry.TERRACOTTA_BRICKS_SLAB.get())).build(consumer, ECConstants.MODID + ":terracotta_bricks_from_slabs");
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.TERRACOTTA_BRICKS_STAIRS.get(), 4).key('#', ECBlockRegistry.TERRACOTTA_BRICKS.get()).patternLine("#  ").patternLine("## ").patternLine(
            "###").addCriterion("has_terracotta_bricks", hasItem(ECBlockRegistry.TERRACOTTA_BRICKS.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.TERRACOTTA_BRICKS_WALL.get(), 6).key('#', ECBlockRegistry.TERRACOTTA_BRICKS.get()).patternLine("###").patternLine("###").addCriterion(
            "has_terracotta_bricks", hasItem(ECBlockRegistry.TERRACOTTA_BRICKS.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.TERRACOTTA_BRICKS_PRESSURE_PLATE.get()).key('#', ECBlockRegistry.TERRACOTTA_BRICKS.get()).patternLine("##").addCriterion("has_terracotta_bricks",
            hasItem(ECBlockRegistry.TERRACOTTA_BRICKS.get())).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.TERRACOTTA_LARGE_BRICKS.get(), 4).patternLine("ii").patternLine("ii").key('i', ECBlockRegistry.TERRACOTTA_BRICKS.get()).addCriterion(
            "has_terracotta_bricks", hasItem(ECBlockRegistry.TERRACOTTA_BRICKS.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.TERRACOTTA_LARGE_BRICKS_SLAB.get(), 6).patternLine("iii").key('i', ECBlockRegistry.TERRACOTTA_LARGE_BRICKS.get()).addCriterion(
            "has_terracotta_large_bricks", hasItem(ECBlockRegistry.TERRACOTTA_LARGE_BRICKS.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.TERRACOTTA_LARGE_BRICKS.get()).patternLine("i").patternLine("i").key('i', ECBlockRegistry.TERRACOTTA_LARGE_BRICKS_SLAB.get()).addCriterion(
            "has_terracotta_large_bricks_slab", hasItem(ECBlockRegistry.TERRACOTTA_LARGE_BRICKS_SLAB.get())).build(consumer, ECConstants.MODID + ":terracotta_large_bricks_from_slabs");
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.TERRACOTTA_LARGE_BRICKS_STAIRS.get(), 4).key('#', ECBlockRegistry.TERRACOTTA_LARGE_BRICKS.get()).patternLine("#  ").patternLine("## ").patternLine(
            "###").addCriterion("has_terracotta_large_bricks", hasItem(ECBlockRegistry.TERRACOTTA_LARGE_BRICKS.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.TERRACOTTA_LARGE_BRICKS_WALL.get(), 6).key('#', ECBlockRegistry.TERRACOTTA_LARGE_BRICKS.get()).patternLine("###").patternLine("###").addCriterion(
            "has_terracotta_large_bricks", hasItem(ECBlockRegistry.TERRACOTTA_LARGE_BRICKS.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.TERRACOTTA_LARGE_BRICKS_PRESSURE_PLATE.get()).key('#', ECBlockRegistry.TERRACOTTA_LARGE_BRICKS.get()).patternLine("##").addCriterion(
            "has_terracotta_large_bricks", hasItem(ECBlockRegistry.TERRACOTTA_LARGE_BRICKS.get())).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.TERRACOTTA_PAVING_STONES.get(), 4).patternLine(" i ").patternLine("i i").patternLine(" i ").key('i',
            ECBlockRegistry.TERRACOTTA_BRICKS.get()).addCriterion("has_terracotta_bricks", hasItem(ECBlockRegistry.TERRACOTTA_BRICKS.get())).build(consumer);
        CreateBasicRecipes(consumer, ECBlockRegistry.TERRACOTTA_PAVING_STONES.get(), ECBlockRegistry.TERRACOTTA_PAVING_STONES_STAIRS.get(), ECBlockRegistry.TERRACOTTA_PAVING_STONES_SLAB.get(),
            ECBlockRegistry.TERRACOTTA_PAVING_STONES_WALL.get(), ECBlockRegistry.TERRACOTTA_PAVING_STONES_PRESSURE_PLATE.get(), null);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.TERRACOTTA_ROOFTILES.get(), 4).patternLine(" i ").patternLine("i i").patternLine(" i ").key('i', Blocks.TERRACOTTA).addCriterion("has_terracotta",
            hasItem(Blocks.TERRACOTTA)).build(consumer, ECConstants.MODID + ":terracotta_rooftiles_from_terracotta");
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.TERRACOTTA_ROOFTILES_SLAB.get(), 6).patternLine("iii").key('i', ECBlockRegistry.TERRACOTTA_ROOFTILES.get()).addCriterion("has_terracotta_rooftiles",
            hasItem(ECBlockRegistry.TERRACOTTA_ROOFTILES.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.TERRACOTTA_ROOFTILES.get()).patternLine("i").patternLine("i").key('i', ECBlockRegistry.TERRACOTTA_ROOFTILES_SLAB.get()).addCriterion(
            "has_terracotta_rooftiles_slab", hasItem(ECBlockRegistry.TERRACOTTA_ROOFTILES_SLAB.get())).build(consumer, ECConstants.MODID + ":terracotta_rooftiles_from_slabs");
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.TERRACOTTA_ROOFTILES_STAIRS.get(), 4).key('#', ECBlockRegistry.TERRACOTTA_ROOFTILES.get()).patternLine("#  ").patternLine("## ").patternLine(
            "###").addCriterion("has_terracotta_rooftiles", hasItem(ECBlockRegistry.TERRACOTTA_ROOFTILES.get())).build(consumer);

        // Other bricks
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.DARK_BRICKS.get(), 9).patternLine("iii").patternLine("idi").patternLine("iii").key('i', Blocks.BRICKS).key('d', Blocks.SOUL_SAND).addCriterion(
            "has_soul_sand", hasItem(Blocks.SOUL_SAND)).addCriterion("has_bricks", hasItem(Blocks.BRICKS)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.DARK_BRICKS_SLAB.get(), 6).patternLine("iii").key('i', ECBlockRegistry.DARK_BRICKS.get()).addCriterion("has_dark_bricks",
            hasItem(ECBlockRegistry.DARK_BRICKS.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.DARK_BRICKS.get()).patternLine("i").patternLine("i").key('i', ECBlockRegistry.DARK_BRICKS_SLAB.get()).addCriterion("has_dark_bricks_slab",
            hasItem(ECBlockRegistry.DARK_BRICKS_SLAB.get())).build(consumer, ECConstants.MODID + ":dark_bricks_from_slabs");
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.DARK_BRICKS_STAIRS.get(), 4).key('#', ECBlockRegistry.DARK_BRICKS.get()).patternLine("#  ").patternLine("## ").patternLine("###").addCriterion(
            "has_dark_bricks", hasItem(ECBlockRegistry.DARK_BRICKS.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.DARK_BRICKS_WALL.get(), 6).key('#', ECBlockRegistry.DARK_BRICKS.get()).patternLine("###").patternLine("###").addCriterion("has_dark_bricks",
            hasItem(ECBlockRegistry.DARK_BRICKS.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.DARK_BRICKS_PRESSURE_PLATE.get()).key('#', ECBlockRegistry.DARK_BRICKS.get()).patternLine("##").addCriterion("has_dark_bricks",
            hasItem(ECBlockRegistry.DARK_BRICKS.get())).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.DARK_LARGE_BRICKS.get(), 4).patternLine("ii").patternLine("ii").key('i', ECBlockRegistry.DARK_BRICKS.get()).addCriterion("has_dark_bricks",
            hasItem(ECBlockRegistry.DARK_BRICKS.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.DARK_LARGE_BRICKS_SLAB.get(), 6).patternLine("iii").key('i', ECBlockRegistry.DARK_LARGE_BRICKS.get()).addCriterion("has_dark_large_bricks",
            hasItem(ECBlockRegistry.DARK_LARGE_BRICKS.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.DARK_LARGE_BRICKS.get()).patternLine("i").patternLine("i").key('i', ECBlockRegistry.DARK_LARGE_BRICKS_SLAB.get()).addCriterion(
            "has_dark_large_bricks_slab", hasItem(ECBlockRegistry.DARK_LARGE_BRICKS_SLAB.get())).build(consumer, ECConstants.MODID + ":dark_large_bricks_from_slabs");
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.DARK_LARGE_BRICKS_STAIRS.get(), 4).key('#', ECBlockRegistry.DARK_LARGE_BRICKS.get()).patternLine("#  ").patternLine("## ").patternLine(
            "###").addCriterion("has_dark_large_bricks", hasItem(ECBlockRegistry.DARK_LARGE_BRICKS.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.DARK_LARGE_BRICKS_WALL.get(), 6).key('#', ECBlockRegistry.DARK_LARGE_BRICKS.get()).patternLine("###").patternLine("###").addCriterion(
            "has_dark_large_bricks", hasItem(ECBlockRegistry.DARK_LARGE_BRICKS.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.DARK_LARGE_BRICKS_PRESSURE_PLATE.get()).key('#', ECBlockRegistry.DARK_LARGE_BRICKS.get()).patternLine("##").addCriterion("has_dark_large_bricks",
            hasItem(ECBlockRegistry.DARK_LARGE_BRICKS.get())).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.OLD_BRICKS.get(), 9).patternLine("iii").patternLine("idi").patternLine("iii").key('i', ECBlockRegistry.WEARED_BRICKS.get()).key('d',
            Blocks.NETHERRACK).addCriterion("has_netherrack", hasItem(Blocks.NETHERRACK)).addCriterion("has_weared_bricks", hasItem(ECBlockRegistry.WEARED_BRICKS.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.OLD_BRICKS_SLAB.get(), 6).patternLine("iii").key('i', ECBlockRegistry.OLD_BRICKS.get()).addCriterion("has_old_bricks",
            hasItem(ECBlockRegistry.OLD_BRICKS.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.OLD_BRICKS.get()).patternLine("i").patternLine("i").key('i', ECBlockRegistry.OLD_BRICKS_SLAB.get()).addCriterion("has_old_bricks_slab",
            hasItem(ECBlockRegistry.OLD_BRICKS_SLAB.get())).build(consumer, ECConstants.MODID + ":old_bricks_from_slabs");
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.OLD_BRICKS_STAIRS.get(), 4).key('#', ECBlockRegistry.OLD_BRICKS.get()).patternLine("#  ").patternLine("## ").patternLine("###").addCriterion(
            "has_old_bricks", hasItem(ECBlockRegistry.OLD_BRICKS.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.OLD_BRICKS_WALL.get(), 6).key('#', ECBlockRegistry.OLD_BRICKS.get()).patternLine("###").patternLine("###").addCriterion("has_old_bricks",
            hasItem(ECBlockRegistry.OLD_BRICKS.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.OLD_BRICKS_PRESSURE_PLATE.get()).key('#', ECBlockRegistry.OLD_BRICKS.get()).patternLine("##").addCriterion("has_old_bricks",
            hasItem(ECBlockRegistry.OLD_BRICKS.get())).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.OLD_LARGE_BRICKS.get(), 4).patternLine("ii").patternLine("ii").key('i', ECBlockRegistry.OLD_BRICKS.get()).addCriterion("has_old_bricks",
            hasItem(ECBlockRegistry.OLD_BRICKS.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.OLD_LARGE_BRICKS_SLAB.get(), 6).patternLine("iii").key('i', ECBlockRegistry.OLD_LARGE_BRICKS.get()).addCriterion("has_old_large_bricks",
            hasItem(ECBlockRegistry.OLD_LARGE_BRICKS.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.OLD_LARGE_BRICKS.get()).patternLine("i").patternLine("i").key('i', ECBlockRegistry.OLD_LARGE_BRICKS_SLAB.get()).addCriterion("has_old_large_bricks_slab",
            hasItem(ECBlockRegistry.OLD_LARGE_BRICKS_SLAB.get())).build(consumer, ECConstants.MODID + ":old_large_bricks_from_slabs");
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.OLD_LARGE_BRICKS_STAIRS.get(), 4).key('#', ECBlockRegistry.OLD_LARGE_BRICKS.get()).patternLine("#  ").patternLine("## ").patternLine("###").addCriterion(
            "has_old_large_bricks", hasItem(ECBlockRegistry.OLD_LARGE_BRICKS.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.OLD_LARGE_BRICKS_WALL.get(), 6).key('#', ECBlockRegistry.OLD_LARGE_BRICKS.get()).patternLine("###").patternLine("###").addCriterion(
            "has_old_large_bricks", hasItem(ECBlockRegistry.OLD_LARGE_BRICKS.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.OLD_LARGE_BRICKS_PRESSURE_PLATE.get()).key('#', ECBlockRegistry.OLD_LARGE_BRICKS.get()).patternLine("##").addCriterion("has_old_large_bricks",
            hasItem(ECBlockRegistry.OLD_LARGE_BRICKS.get())).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.WEARED_BRICKS.get(), 9).patternLine("iii").patternLine("idi").patternLine("iii").key('i', Blocks.BRICKS).key('d', Blocks.NETHERRACK).addCriterion(
            "has_netherrack", hasItem(Blocks.NETHERRACK)).addCriterion("has_bricks", hasItem(Blocks.BRICKS)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.WEARED_BRICKS_SLAB.get(), 6).patternLine("iii").key('i', ECBlockRegistry.WEARED_BRICKS.get()).addCriterion("has_weared_bricks",
            hasItem(ECBlockRegistry.WEARED_BRICKS.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.WEARED_BRICKS.get()).patternLine("i").patternLine("i").key('i', ECBlockRegistry.WEARED_BRICKS_SLAB.get()).addCriterion("has_weared_bricks_slab",
            hasItem(ECBlockRegistry.WEARED_BRICKS_SLAB.get())).build(consumer, ECConstants.MODID + ":weared_bricks_from_slabs");
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.WEARED_BRICKS_STAIRS.get(), 4).key('#', ECBlockRegistry.WEARED_BRICKS.get()).patternLine("#  ").patternLine("## ").patternLine("###").addCriterion(
            "has_weared_bricks", hasItem(ECBlockRegistry.WEARED_BRICKS.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.WEARED_BRICKS_WALL.get(), 6).key('#', ECBlockRegistry.WEARED_BRICKS.get()).patternLine("###").patternLine("###").addCriterion("has_weared_bricks",
            hasItem(ECBlockRegistry.WEARED_BRICKS.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.WEARED_BRICKS_PRESSURE_PLATE.get()).key('#', ECBlockRegistry.WEARED_BRICKS.get()).patternLine("##").addCriterion("has_weared_bricks",
            hasItem(ECBlockRegistry.WEARED_BRICKS.get())).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.WEARED_LARGE_BRICKS.get(), 4).patternLine("ii").patternLine("ii").key('i', ECBlockRegistry.WEARED_BRICKS.get()).addCriterion("has_weared_bricks",
            hasItem(ECBlockRegistry.WEARED_BRICKS.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.WEARED_LARGE_BRICKS_SLAB.get(), 6).patternLine("iii").key('i', ECBlockRegistry.WEARED_LARGE_BRICKS.get()).addCriterion("has_weared_large_bricks",
            hasItem(ECBlockRegistry.WEARED_LARGE_BRICKS.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.WEARED_LARGE_BRICKS.get()).patternLine("i").patternLine("i").key('i', ECBlockRegistry.WEARED_LARGE_BRICKS_SLAB.get()).addCriterion(
            "has_weared_large_bricks_slab", hasItem(ECBlockRegistry.WEARED_LARGE_BRICKS_SLAB.get())).build(consumer, ECConstants.MODID + ":weared_large_bricks_from_slabs");
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.WEARED_LARGE_BRICKS_STAIRS.get(), 4).key('#', ECBlockRegistry.WEARED_LARGE_BRICKS.get()).patternLine("#  ").patternLine("## ").patternLine(
            "###").addCriterion("has_weared_large_bricks", hasItem(ECBlockRegistry.WEARED_LARGE_BRICKS.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.WEARED_LARGE_BRICKS_WALL.get(), 6).key('#', ECBlockRegistry.WEARED_LARGE_BRICKS.get()).patternLine("###").patternLine("###").addCriterion(
            "has_weared_large_bricks", hasItem(ECBlockRegistry.WEARED_LARGE_BRICKS.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.WEARED_LARGE_BRICKS_PRESSURE_PLATE.get()).key('#', ECBlockRegistry.WEARED_LARGE_BRICKS.get()).patternLine("##").addCriterion("has_weared_large_bricks",
            hasItem(ECBlockRegistry.WEARED_LARGE_BRICKS.get())).build(consumer);

        // Pavings
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.CONCRETE_PAVING.get(), 4).patternLine("ii").patternLine("ii").key('i', Blocks.LIGHT_GRAY_CONCRETE_POWDER).addCriterion("has_light_gray_concrete_powder",
            hasItem(Blocks.LIGHT_GRAY_CONCRETE_POWDER)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.CONCRETE_PAVING_SLAB.get(), 6).patternLine("iii").key('i', ECBlockRegistry.CONCRETE_PAVING.get()).addCriterion("has_concrete_paving",
            hasItem(ECBlockRegistry.CONCRETE_PAVING.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.CONCRETE_PAVING.get()).patternLine("i").patternLine("i").key('i', ECBlockRegistry.CONCRETE_PAVING_SLAB.get()).addCriterion("has_concrete_paving_slab",
            hasItem(ECBlockRegistry.CONCRETE_PAVING_SLAB.get())).build(consumer, ECConstants.MODID + ":concrete_paving_from_slabs");
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.CONCRETE_PAVING_STAIRS.get(), 4).key('#', ECBlockRegistry.CONCRETE_PAVING.get()).patternLine("#  ").patternLine("## ").patternLine("###").addCriterion(
            "has_concrete_paving", hasItem(ECBlockRegistry.CONCRETE_PAVING.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.CONCRETE_PAVING_WALL.get(), 6).key('#', ECBlockRegistry.CONCRETE_PAVING.get()).patternLine("###").patternLine("###").addCriterion("has_concrete_paving",
            hasItem(ECBlockRegistry.CONCRETE_PAVING.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.CONCRETE_PAVING_PRESSURE_PLATE.get()).key('#', ECBlockRegistry.CONCRETE_PAVING.get()).patternLine("##").addCriterion("has_concrete_paving",
            hasItem(ECBlockRegistry.CONCRETE_PAVING.get())).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.DAMAGED_PAVING.get(), 4).patternLine("ic").patternLine("ci").key('i', Blocks.LIGHT_GRAY_CONCRETE_POWDER).key('c', Blocks.COBBLESTONE).addCriterion(
            "has_light_gray_concrete_powder", hasItem(Blocks.LIGHT_GRAY_CONCRETE_POWDER)).addCriterion("has_cobblestone", hasItem(Blocks.COBBLESTONE)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.DAMAGED_PAVING_SLAB.get(), 6).patternLine("iii").key('i', ECBlockRegistry.DAMAGED_PAVING.get()).addCriterion("has_damaged_paving",
            hasItem(ECBlockRegistry.DAMAGED_PAVING.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.DAMAGED_PAVING.get()).patternLine("i").patternLine("i").key('i', ECBlockRegistry.DAMAGED_PAVING_SLAB.get()).addCriterion("has_damaged_paving_slab",
            hasItem(ECBlockRegistry.DAMAGED_PAVING_SLAB.get())).build(consumer, ECConstants.MODID + ":damaged_paving_from_slabs");
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.DAMAGED_PAVING_STAIRS.get(), 4).key('#', ECBlockRegistry.DAMAGED_PAVING.get()).patternLine("#  ").patternLine("## ").patternLine("###").addCriterion(
            "has_damaged_paving", hasItem(ECBlockRegistry.DAMAGED_PAVING.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.DAMAGED_PAVING_WALL.get(), 6).key('#', ECBlockRegistry.DAMAGED_PAVING.get()).patternLine("###").patternLine("###").addCriterion("has_damaged_paving",
            hasItem(ECBlockRegistry.DAMAGED_PAVING.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.DAMAGED_PAVING_PRESSURE_PLATE.get()).key('#', ECBlockRegistry.DAMAGED_PAVING.get()).patternLine("##").addCriterion("has_damaged_paving",
            hasItem(ECBlockRegistry.DAMAGED_PAVING.get())).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.DARK_CONCRETE_PAVING.get(), 4).patternLine("ii").patternLine("ii").key('i', Blocks.GRAY_CONCRETE_POWDER).addCriterion("has_gray_concrete_powder",
            hasItem(Blocks.GRAY_CONCRETE_POWDER)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.DARK_CONCRETE_PAVING_SLAB.get(), 6).patternLine("iii").key('i', ECBlockRegistry.DARK_CONCRETE_PAVING.get()).addCriterion("has_dark_concrete_paving",
            hasItem(ECBlockRegistry.DARK_CONCRETE_PAVING.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.DARK_CONCRETE_PAVING.get()).patternLine("i").patternLine("i").key('i', ECBlockRegistry.DARK_CONCRETE_PAVING_SLAB.get()).addCriterion(
            "has_dark_concrete_paving_slab", hasItem(ECBlockRegistry.DARK_CONCRETE_PAVING_SLAB.get())).build(consumer, ECConstants.MODID + ":dark_concrete_paving_from_slabs");
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.DARK_CONCRETE_PAVING_STAIRS.get(), 4).key('#', ECBlockRegistry.DARK_CONCRETE_PAVING.get()).patternLine("#  ").patternLine("## ").patternLine(
            "###").addCriterion("has_dark_concrete_paving", hasItem(ECBlockRegistry.DARK_CONCRETE_PAVING.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.DARK_CONCRETE_PAVING_WALL.get(), 6).key('#', ECBlockRegistry.DARK_CONCRETE_PAVING.get()).patternLine("###").patternLine("###").addCriterion(
            "has_dark_concrete_paving", hasItem(ECBlockRegistry.DARK_CONCRETE_PAVING.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.DARK_CONCRETE_PAVING_PRESSURE_PLATE.get()).key('#', ECBlockRegistry.DARK_CONCRETE_PAVING.get()).patternLine("##").addCriterion(
            "has_dark_concrete_paving", hasItem(ECBlockRegistry.DARK_CONCRETE_PAVING.get())).build(consumer);

        ShapelessRecipeBuilder.shapelessRecipe(ECBlockRegistry.MOIST_PAVING.get()).addIngredient(ECBlockRegistry.POLISHED_PAVING.get()).addIngredient(Blocks.VINE).addCriterion("has_polished_paving",
            hasItem(ECBlockRegistry.POLISHED_PAVING.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.MOIST_PAVING_SLAB.get(), 6).patternLine("iii").key('i', ECBlockRegistry.MOIST_PAVING.get()).addCriterion("has_moist_paving",
            hasItem(ECBlockRegistry.MOIST_PAVING.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.MOIST_PAVING.get()).patternLine("i").patternLine("i").key('i', ECBlockRegistry.MOIST_PAVING_SLAB.get()).addCriterion("has_moist_paving_slab",
            hasItem(ECBlockRegistry.MOIST_PAVING_SLAB.get())).build(consumer, ECConstants.MODID + ":moist_paving_from_slabs");
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.MOIST_PAVING_STAIRS.get(), 4).key('#', ECBlockRegistry.MOIST_PAVING.get()).patternLine("#  ").patternLine("## ").patternLine("###").addCriterion(
            "has_moist_paving", hasItem(ECBlockRegistry.MOIST_PAVING.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.MOIST_PAVING_WALL.get(), 6).key('#', ECBlockRegistry.MOIST_PAVING.get()).patternLine("###").patternLine("###").addCriterion("has_moist_paving",
            hasItem(ECBlockRegistry.MOIST_PAVING.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.MOIST_PAVING_PRESSURE_PLATE.get()).key('#', ECBlockRegistry.MOIST_PAVING.get()).patternLine("##").addCriterion("has_moist_paving",
            hasItem(ECBlockRegistry.MOIST_PAVING.get())).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.POLISHED_PAVING.get(), 4).patternLine("ii").patternLine("ii").key('i', Blocks.WHITE_CONCRETE).addCriterion("has_white_concrete",
            hasItem(Blocks.WHITE_CONCRETE)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.POLISHED_PAVING_SLAB.get(), 6).patternLine("iii").key('i', ECBlockRegistry.POLISHED_PAVING.get()).addCriterion("has_polished_paving",
            hasItem(ECBlockRegistry.POLISHED_PAVING.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.POLISHED_PAVING.get()).patternLine("i").patternLine("i").key('i', ECBlockRegistry.POLISHED_PAVING_SLAB.get()).addCriterion("has_polished_paving_slab",
            hasItem(ECBlockRegistry.POLISHED_PAVING_SLAB.get())).build(consumer, ECConstants.MODID + ":polished_paving_from_slabs");
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.POLISHED_PAVING_STAIRS.get(), 4).key('#', ECBlockRegistry.POLISHED_PAVING.get()).patternLine("#  ").patternLine("## ").patternLine("###").addCriterion(
            "has_polished_paving", hasItem(ECBlockRegistry.POLISHED_PAVING.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.POLISHED_PAVING_WALL.get(), 6).key('#', ECBlockRegistry.POLISHED_PAVING.get()).patternLine("###").patternLine("###").addCriterion("has_polished_paving",
            hasItem(ECBlockRegistry.POLISHED_PAVING.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.POLISHED_PAVING_PRESSURE_PLATE.get()).key('#', ECBlockRegistry.POLISHED_PAVING.get()).patternLine("##").addCriterion("has_polished_paving",
            hasItem(ECBlockRegistry.POLISHED_PAVING.get())).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.WHITE_CONCRETE_PAVING.get(), 4).patternLine("ii").patternLine("ii").key('i', Blocks.WHITE_CONCRETE_POWDER).addCriterion("has_white_concrete_powder",
            hasItem(Blocks.WHITE_CONCRETE_POWDER)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.WHITE_CONCRETE_PAVING_SLAB.get(), 6).patternLine("iii").key('i', ECBlockRegistry.WHITE_CONCRETE_PAVING.get()).addCriterion("has_white_concrete_paving",
            hasItem(ECBlockRegistry.WHITE_CONCRETE_PAVING.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.WHITE_CONCRETE_PAVING.get()).patternLine("i").patternLine("i").key('i', ECBlockRegistry.WHITE_CONCRETE_PAVING_SLAB.get()).addCriterion(
            "has_white_concrete_paving_slab", hasItem(ECBlockRegistry.WHITE_CONCRETE_PAVING_SLAB.get())).build(consumer, ECConstants.MODID + ":white_concrete_paving_from_slabs");
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.WHITE_CONCRETE_PAVING_STAIRS.get(), 4).key('#', ECBlockRegistry.WHITE_CONCRETE_PAVING.get()).patternLine("#  ").patternLine("## ").patternLine(
            "###").addCriterion("has_white_concrete_paving", hasItem(ECBlockRegistry.WHITE_CONCRETE_PAVING.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.WHITE_CONCRETE_PAVING_WALL.get(), 6).key('#', ECBlockRegistry.WHITE_CONCRETE_PAVING.get()).patternLine("###").patternLine("###").addCriterion(
            "has_white_concrete_paving", hasItem(ECBlockRegistry.WHITE_CONCRETE_PAVING.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.WHITE_CONCRETE_PAVING_PRESSURE_PLATE.get()).key('#', ECBlockRegistry.WHITE_CONCRETE_PAVING.get()).patternLine("##").addCriterion(
            "has_white_concrete_paving", hasItem(ECBlockRegistry.WHITE_CONCRETE_PAVING.get())).build(consumer);

        // Tiles
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.CONCRETE_TILES.get(), 4).patternLine("ii").patternLine("ii").key('i', ECBlockRegistry.CONCRETE_PAVING.get()).addCriterion("has_concrete_tiles",
            hasItem(ECBlockRegistry.CONCRETE_PAVING.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.CONCRETE_TILES_SLAB.get(), 6).patternLine("iii").key('i', ECBlockRegistry.CONCRETE_TILES.get()).addCriterion("has_concrete_tiles",
            hasItem(ECBlockRegistry.CONCRETE_TILES.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.CONCRETE_TILES.get()).patternLine("i").patternLine("i").key('i', ECBlockRegistry.CONCRETE_TILES_SLAB.get()).addCriterion("has_concrete_tiles_slab",
            hasItem(ECBlockRegistry.CONCRETE_TILES_SLAB.get())).build(consumer, ECConstants.MODID + ":concrete_tiles_from_slabs");
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.CONCRETE_TILES_STAIRS.get(), 4).key('#', ECBlockRegistry.CONCRETE_TILES.get()).patternLine("#  ").patternLine("## ").patternLine("###").addCriterion(
            "has_concrete_tiles", hasItem(ECBlockRegistry.CONCRETE_TILES.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.CONCRETE_TILES_WALL.get(), 6).key('#', ECBlockRegistry.CONCRETE_TILES.get()).patternLine("###").patternLine("###").addCriterion("has_concrete_tiles",
            hasItem(ECBlockRegistry.CONCRETE_TILES.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.CONCRETE_TILES_PRESSURE_PLATE.get()).key('#', ECBlockRegistry.CONCRETE_TILES.get()).patternLine("##").addCriterion("has_concrete_tiles",
            hasItem(ECBlockRegistry.CONCRETE_TILES.get())).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.SKYBLUE_TILES.get(), 8).patternLine("iii").patternLine("idi").patternLine("iii").key('i', ECBlockRegistry.BLUE_TILES.get()).key('d',
            Tags.Items.DYES_WHITE).addCriterion("has_blue_tiles", hasItem(ECBlockRegistry.BLUE_TILES.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.SKYBLUE_TILES_SLAB.get(), 6).patternLine("iii").key('i', ECBlockRegistry.SKYBLUE_TILES.get()).addCriterion("has_skyblue_tiles",
            hasItem(ECBlockRegistry.SKYBLUE_TILES.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.SKYBLUE_TILES.get()).patternLine("i").patternLine("i").key('i', ECBlockRegistry.SKYBLUE_TILES_SLAB.get()).addCriterion("has_skyblue_tiles_slab",
            hasItem(ECBlockRegistry.SKYBLUE_TILES_SLAB.get())).build(consumer, ECConstants.MODID + ":skyblue_tiles_from_slabs");
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.SKYBLUE_TILES_STAIRS.get(), 4).key('#', ECBlockRegistry.SKYBLUE_TILES.get()).patternLine("#  ").patternLine("## ").patternLine("###").addCriterion(
            "has_skyblue_tiles", hasItem(ECBlockRegistry.SKYBLUE_TILES.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.SKYBLUE_TILES_WALL.get(), 6).key('#', ECBlockRegistry.SKYBLUE_TILES.get()).patternLine("###").patternLine("###").addCriterion("has_skyblue_tiles",
            hasItem(ECBlockRegistry.SKYBLUE_TILES.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.SKYBLUE_TILES_PRESSURE_PLATE.get()).key('#', ECBlockRegistry.SKYBLUE_TILES.get()).patternLine("##").addCriterion("has_skyblue_tiles",
            hasItem(ECBlockRegistry.SKYBLUE_TILES.get())).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.ORANGE_TILES.get(), 8).patternLine("iii").patternLine("idi").patternLine("iii").key('i', ECBlockRegistry.CONCRETE_TILES.get()).key('d',
            Tags.Items.DYES_ORANGE).addCriterion("has_concrete_tiles", hasItem(ECBlockRegistry.CONCRETE_TILES.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.ORANGE_TILES_SLAB.get(), 6).patternLine("iii").key('i', ECBlockRegistry.ORANGE_TILES.get()).addCriterion("has_orange_tiles",
            hasItem(ECBlockRegistry.ORANGE_TILES.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.ORANGE_TILES.get()).patternLine("i").patternLine("i").key('i', ECBlockRegistry.ORANGE_TILES_SLAB.get()).addCriterion("has_orange_tiles_slab",
            hasItem(ECBlockRegistry.ORANGE_TILES_SLAB.get())).build(consumer, ECConstants.MODID + ":orange_tiles_from_slabs");
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.ORANGE_TILES_STAIRS.get(), 4).key('#', ECBlockRegistry.ORANGE_TILES.get()).patternLine("#  ").patternLine("## ").patternLine("###").addCriterion(
            "has_orange_tiles", hasItem(ECBlockRegistry.ORANGE_TILES.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.ORANGE_TILES_WALL.get(), 6).key('#', ECBlockRegistry.ORANGE_TILES.get()).patternLine("###").patternLine("###").addCriterion("has_orange_tiles",
            hasItem(ECBlockRegistry.ORANGE_TILES.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.ORANGE_TILES_PRESSURE_PLATE.get()).key('#', ECBlockRegistry.ORANGE_TILES.get()).patternLine("##").addCriterion("has_orange_tiles",
            hasItem(ECBlockRegistry.ORANGE_TILES.get())).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.BLUE_TILES.get(), 8).patternLine("iii").patternLine("idi").patternLine("iii").key('i', ECBlockRegistry.CONCRETE_TILES.get()).key('d',
            Tags.Items.DYES_BLUE).addCriterion("has_concrete_tiles", hasItem(ECBlockRegistry.CONCRETE_TILES.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.BLUE_TILES_SLAB.get(), 6).patternLine("iii").key('i', ECBlockRegistry.BLUE_TILES.get()).addCriterion("has_blue_tiles",
            hasItem(ECBlockRegistry.BLUE_TILES.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.BLUE_TILES.get()).patternLine("i").patternLine("i").key('i', ECBlockRegistry.BLUE_TILES_SLAB.get()).addCriterion("has_blue_tiles_slab",
            hasItem(ECBlockRegistry.BLUE_TILES_SLAB.get())).build(consumer, ECConstants.MODID + ":blue_tiles_from_slabs");
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.BLUE_TILES_STAIRS.get(), 4).key('#', ECBlockRegistry.BLUE_TILES.get()).patternLine("#  ").patternLine("## ").patternLine("###").addCriterion(
            "has_blue_tiles", hasItem(ECBlockRegistry.BLUE_TILES.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.BLUE_TILES_WALL.get(), 6).key('#', ECBlockRegistry.BLUE_TILES.get()).patternLine("###").patternLine("###").addCriterion("has_blue_tiles",
            hasItem(ECBlockRegistry.BLUE_TILES.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.BLUE_TILES_PRESSURE_PLATE.get()).key('#', ECBlockRegistry.BLUE_TILES.get()).patternLine("##").addCriterion("has_blue_tiles",
            hasItem(ECBlockRegistry.BLUE_TILES.get())).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.LIGHT_BLUE_TILES.get(), 8).patternLine("iii").patternLine("idi").patternLine("iii").key('i', ECBlockRegistry.CONCRETE_TILES.get()).key('d',
            Tags.Items.DYES_LIGHT_BLUE).addCriterion("has_concrete_tiles", hasItem(ECBlockRegistry.CONCRETE_TILES.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.LIGHT_BLUE_TILES_SLAB.get(), 6).patternLine("iii").key('i', ECBlockRegistry.LIGHT_BLUE_TILES.get()).addCriterion("has_light_blue_tiles",
            hasItem(ECBlockRegistry.LIGHT_BLUE_TILES.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.LIGHT_BLUE_TILES.get()).patternLine("i").patternLine("i").key('i', ECBlockRegistry.LIGHT_BLUE_TILES_SLAB.get()).addCriterion("has_light_blue_tiles_slab",
            hasItem(ECBlockRegistry.LIGHT_BLUE_TILES_SLAB.get())).build(consumer, ECConstants.MODID + ":light_blue_tiles_from_slabs");
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.LIGHT_BLUE_TILES_STAIRS.get(), 4).key('#', ECBlockRegistry.LIGHT_BLUE_TILES.get()).patternLine("#  ").patternLine("## ").patternLine("###").addCriterion(
            "has_light_blue_tiles", hasItem(ECBlockRegistry.LIGHT_BLUE_TILES.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.LIGHT_BLUE_TILES_WALL.get(), 6).key('#', ECBlockRegistry.LIGHT_BLUE_TILES.get()).patternLine("###").patternLine("###").addCriterion(
            "has_light_blue_tiles", hasItem(ECBlockRegistry.LIGHT_BLUE_TILES.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.LIGHT_BLUE_TILES_PRESSURE_PLATE.get()).key('#', ECBlockRegistry.LIGHT_BLUE_TILES.get()).patternLine("##").addCriterion("has_light_blue_tiles",
            hasItem(ECBlockRegistry.LIGHT_BLUE_TILES.get())).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.RED_TILES.get(), 8).patternLine("iii").patternLine("idi").patternLine("iii").key('i', ECBlockRegistry.CONCRETE_TILES.get()).key('d',
            Tags.Items.DYES_RED).addCriterion("has_concrete_tiles", hasItem(ECBlockRegistry.CONCRETE_TILES.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.RED_TILES_SLAB.get(), 6).patternLine("iii").key('i', ECBlockRegistry.RED_TILES.get()).addCriterion("has_red_tiles",
            hasItem(ECBlockRegistry.RED_TILES.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.RED_TILES.get()).patternLine("i").patternLine("i").key('i', ECBlockRegistry.RED_TILES_SLAB.get()).addCriterion("has_red_tiles_slab",
            hasItem(ECBlockRegistry.RED_TILES_SLAB.get())).build(consumer, ECConstants.MODID + ":red_tiles_from_slabs");
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.RED_TILES_STAIRS.get(), 4).key('#', ECBlockRegistry.RED_TILES.get()).patternLine("#  ").patternLine("## ").patternLine("###").addCriterion(
            "has_red_tiles", hasItem(ECBlockRegistry.RED_TILES.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.RED_TILES_WALL.get(), 6).key('#', ECBlockRegistry.RED_TILES.get()).patternLine("###").patternLine("###").addCriterion("has_red_tiles",
            hasItem(ECBlockRegistry.RED_TILES.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.RED_TILES_PRESSURE_PLATE.get()).key('#', ECBlockRegistry.RED_TILES.get()).patternLine("##").addCriterion("has_red_tiles",
            hasItem(ECBlockRegistry.RED_TILES.get())).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.WHITE_TILES.get(), 8).patternLine("iii").patternLine("idi").patternLine("iii").key('i', ECBlockRegistry.CONCRETE_TILES.get()).key('d',
            Tags.Items.DYES_WHITE).addCriterion("has_concrete_tiles", hasItem(ECBlockRegistry.CONCRETE_TILES.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.WHITE_TILES_SLAB.get(), 6).patternLine("iii").key('i', ECBlockRegistry.WHITE_TILES.get()).addCriterion("has_white_tiles",
            hasItem(ECBlockRegistry.WHITE_TILES.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.WHITE_TILES.get()).patternLine("i").patternLine("i").key('i', ECBlockRegistry.WHITE_TILES_SLAB.get()).addCriterion("has_white_tiles_slab",
            hasItem(ECBlockRegistry.WHITE_TILES_SLAB.get())).build(consumer, ECConstants.MODID + ":white_tiles_from_slabs");
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.WHITE_TILES_STAIRS.get(), 4).key('#', ECBlockRegistry.WHITE_TILES.get()).patternLine("#  ").patternLine("## ").patternLine("###").addCriterion(
            "has_white_tiles", hasItem(ECBlockRegistry.WHITE_TILES.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.WHITE_TILES_WALL.get(), 6).key('#', ECBlockRegistry.WHITE_TILES.get()).patternLine("###").patternLine("###").addCriterion("has_white_tiles",
            hasItem(ECBlockRegistry.WHITE_TILES.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.WHITE_TILES_PRESSURE_PLATE.get()).key('#', ECBlockRegistry.WHITE_TILES.get()).patternLine("##").addCriterion("has_white_tiles",
            hasItem(ECBlockRegistry.WHITE_TILES.get())).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.YELLOW_TILES.get(), 8).patternLine("iii").patternLine("idi").patternLine("iii").key('i', ECBlockRegistry.CONCRETE_TILES.get()).key('d',
            Tags.Items.DYES_YELLOW).addCriterion("has_concrete_tiles", hasItem(ECBlockRegistry.CONCRETE_TILES.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.YELLOW_TILES_SLAB.get(), 6).patternLine("iii").key('i', ECBlockRegistry.YELLOW_TILES.get()).addCriterion("has_yellow_tiles",
            hasItem(ECBlockRegistry.YELLOW_TILES.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.YELLOW_TILES.get()).patternLine("i").patternLine("i").key('i', ECBlockRegistry.YELLOW_TILES_SLAB.get()).addCriterion("has_yellow_tiles_slab",
            hasItem(ECBlockRegistry.YELLOW_TILES_SLAB.get())).build(consumer, ECConstants.MODID + ":yellow_tiles_from_slabs");
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.YELLOW_TILES_STAIRS.get(), 4).key('#', ECBlockRegistry.YELLOW_TILES.get()).patternLine("#  ").patternLine("## ").patternLine("###").addCriterion(
            "has_yellow_tiles", hasItem(ECBlockRegistry.YELLOW_TILES.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.YELLOW_TILES_WALL.get(), 6).key('#', ECBlockRegistry.YELLOW_TILES.get()).patternLine("###").patternLine("###").addCriterion("has_yellow_tiles",
            hasItem(ECBlockRegistry.YELLOW_TILES.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.YELLOW_TILES_PRESSURE_PLATE.get()).key('#', ECBlockRegistry.YELLOW_TILES.get()).patternLine("##").addCriterion("has_yellow_tiles",
            hasItem(ECBlockRegistry.YELLOW_TILES.get())).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.YELLOW_GREY_TILES.get(), 8).patternLine("iii").patternLine("idi").patternLine("iii").key('i', ECBlockRegistry.YELLOW_TILES.get()).key('d',
            Tags.Items.DYES_GRAY).addCriterion("has_yellow_tiles", hasItem(ECBlockRegistry.YELLOW_TILES.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.YELLOW_GREY_TILES_SLAB.get(), 6).patternLine("iii").key('i', ECBlockRegistry.YELLOW_GREY_TILES.get()).addCriterion("has_concrete_tiles",
            hasItem(ECBlockRegistry.YELLOW_GREY_TILES.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.YELLOW_GREY_TILES.get()).patternLine("i").patternLine("i").key('i', ECBlockRegistry.YELLOW_GREY_TILES_SLAB.get()).addCriterion("has_concrete_tiles_slab",
            hasItem(ECBlockRegistry.YELLOW_GREY_TILES_SLAB.get())).build(consumer, ECConstants.MODID + ":yellow_grey_tiles_from_slabs");
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.YELLOW_GREY_TILES_STAIRS.get(), 4).key('#', ECBlockRegistry.YELLOW_GREY_TILES.get()).patternLine("#  ").patternLine("## ").patternLine(
            "###").addCriterion("has_concrete_tiles", hasItem(ECBlockRegistry.YELLOW_GREY_TILES.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.YELLOW_GREY_TILES_WALL.get(), 6).key('#', ECBlockRegistry.YELLOW_GREY_TILES.get()).patternLine("###").patternLine("###").addCriterion(
            "has_concrete_tiles", hasItem(ECBlockRegistry.YELLOW_GREY_TILES.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.YELLOW_GREY_TILES_PRESSURE_PLATE.get()).key('#', ECBlockRegistry.YELLOW_GREY_TILES.get()).patternLine("##").addCriterion("has_concrete_tiles",
            hasItem(ECBlockRegistry.YELLOW_GREY_TILES.get())).build(consumer);

        // Corrugated metal plates
        for(int j = 0; j < Arrays.stream(DyeColor.values()).count(); j++)
        {
            ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.CORRUGATED_METAL_PLATE_BLOCKS.get(DyeColor.byId(j)).get(), 8).patternLine("iii").patternLine("idi").patternLine("iii").key('i',
                BaseTags.ForgeItems.PLATES_STEEL).key('d', DyeColor.byId(j).getTag()).addCriterion("has_steel_plate", hasItem(BaseTags.ForgeItems.PLATES_STEEL)).build(consumer);
            ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.CORRUGATED_METAL_PLATE_SLABS.get(DyeColor.byId(j)).get(), 6).patternLine("iii").key('i',
                ECBlockRegistry.CORRUGATED_METAL_PLATE_BLOCKS.get(DyeColor.byId(j)).get()).addCriterion("has_" + DyeColor.byId(j).getString() + "_corrugated_metal_plate",
                    hasItem(ECBlockRegistry.CORRUGATED_METAL_PLATE_BLOCKS.get(DyeColor.byId(j)).get())).build(consumer);
            ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.CORRUGATED_METAL_PLATE_BLOCKS.get(DyeColor.byId(j)).get()).patternLine("i").patternLine("i").key('i',
                ECBlockRegistry.CORRUGATED_METAL_PLATE_SLABS.get(DyeColor.byId(j)).get()).addCriterion("has_" + DyeColor.byId(j).getString() + "_corrugated_metal_plate_slab",
                    hasItem(ECBlockRegistry.CORRUGATED_METAL_PLATE_SLABS.get(DyeColor.byId(j)).get())).build(consumer,
                        ECConstants.MODID + ":" + DyeColor.byId(j).getString() + "_corrugated_metal_plate_from_slabs");
            ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.CORRUGATED_METAL_PLATE_STAIRS.get(DyeColor.byId(j)).get(), 4).key('#',
                ECBlockRegistry.CORRUGATED_METAL_PLATE_BLOCKS.get(DyeColor.byId(j)).get()).patternLine("#  ").patternLine("## ").patternLine("###").addCriterion(
                    "has_" + DyeColor.byId(j).getString() + "_corrugated_metal_plate", hasItem(ECBlockRegistry.CORRUGATED_METAL_PLATE_BLOCKS.get(DyeColor.byId(j)).get())).build(consumer);
            ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.CORRUGATED_METAL_PLATE_WALLS.get(DyeColor.byId(j)).get(), 6).key('#',
                ECBlockRegistry.CORRUGATED_METAL_PLATE_BLOCKS.get(DyeColor.byId(j)).get()).patternLine("###").patternLine("###").addCriterion("has_" + DyeColor.byId(j).getString() + "_corrugated_metal_plate",
                    hasItem(ECBlockRegistry.CORRUGATED_METAL_PLATE_BLOCKS.get(DyeColor.byId(j)).get())).build(consumer);
            ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.CORRUGATED_METAL_PLATE_PRESSURE_PLATES.get(DyeColor.byId(j)).get()).key('#',
                ECBlockRegistry.CORRUGATED_METAL_PLATE_BLOCKS.get(DyeColor.byId(j)).get()).patternLine("##").addCriterion("has_" + DyeColor.byId(j).getString() + "_corrugated_metal_plate",
                    hasItem(ECBlockRegistry.CORRUGATED_METAL_PLATE_BLOCKS.get(DyeColor.byId(j)).get())).build(consumer);
            ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.CORRUGATED_METAL_PLATE_FENCES.get(DyeColor.byId(j)).get(), 6).key('S', BaseTags.ForgeItems.RODS_STEEL).key('#',
                ECBlockRegistry.CORRUGATED_METAL_PLATE_BLOCKS.get(DyeColor.byId(j)).get()).patternLine("#S#").patternLine("#S#").addCriterion("has_" + DyeColor.byId(j).getString() + "_corrugated_metal_plate",
                    hasItem(ECBlockRegistry.CORRUGATED_METAL_PLATE_BLOCKS.get(DyeColor.byId(j)).get())).build(consumer);
            ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.CORRUGATED_METAL_PLATE_FENCE_GATES.get(DyeColor.byId(j)).get(), 6).key('S', BaseTags.ForgeItems.RODS_STEEL).key('#',
                ECBlockRegistry.CORRUGATED_METAL_PLATE_BLOCKS.get(DyeColor.byId(j)).get()).patternLine("S#S").patternLine("S#S").addCriterion("has_" + DyeColor.byId(j).getString() + "_corrugated_metal_plate",
                    hasItem(ECBlockRegistry.CORRUGATED_METAL_PLATE_BLOCKS.get(DyeColor.byId(j)).get())).build(consumer);
        }

        // Metal blocks
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.LIGHT_METAL_FLOOR.get(), 4).patternLine("iid").patternLine("ii ").key('i', BaseTags.ForgeItems.PLATES_STEEL).key('d', Tags.Items.DYES_GRAY).addCriterion(
            "has_steel_plate", hasItem(BaseTags.ForgeItems.PLATES_STEEL)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.LIGHT_METAL_FLOOR_SLAB.get(), 6).patternLine("iii").key('i', ECBlockRegistry.LIGHT_METAL_FLOOR.get()).addCriterion("has_light_metal_floor",
            hasItem(ECBlockRegistry.LIGHT_METAL_FLOOR.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.LIGHT_METAL_FLOOR.get()).patternLine("i").patternLine("i").key('i', ECBlockRegistry.LIGHT_METAL_FLOOR_SLAB.get()).addCriterion(
            "has_light_metal_floor_slab", hasItem(ECBlockRegistry.LIGHT_METAL_FLOOR_SLAB.get())).build(consumer, ECConstants.MODID + ":light_metal_floor_from_slabs");
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.LIGHT_METAL_FLOOR_STAIRS.get(), 4).key('#', ECBlockRegistry.LIGHT_METAL_FLOOR.get()).patternLine("#  ").patternLine("## ").patternLine(
            "###").addCriterion("has_light_metal_floor", hasItem(ECBlockRegistry.LIGHT_METAL_FLOOR.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.LIGHT_METAL_FLOOR_WALL.get(), 6).key('#', ECBlockRegistry.LIGHT_METAL_FLOOR.get()).patternLine("###").patternLine("###").addCriterion(
            "has_light_metal_floor", hasItem(ECBlockRegistry.LIGHT_METAL_FLOOR.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.LIGHT_METAL_FLOOR_PRESSURE_PLATE.get()).key('#', ECBlockRegistry.LIGHT_METAL_FLOOR.get()).patternLine("##").addCriterion("has_light_metal_floor",
            hasItem(ECBlockRegistry.LIGHT_METAL_FLOOR.get())).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.DARK_METAL_FLOOR.get(), 4).patternLine("iid").patternLine("ii ").key('i', BaseTags.ForgeItems.PLATES_STEEL).key('d', Tags.Items.DYES_BLACK).addCriterion(
            "has_steel_plate", hasItem(BaseTags.ForgeItems.PLATES_STEEL)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.DARK_METAL_FLOOR_SLAB.get(), 6).patternLine("iii").key('i', ECBlockRegistry.DARK_METAL_FLOOR.get()).addCriterion("has_dark_metal_floor",
            hasItem(ECBlockRegistry.DARK_METAL_FLOOR.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.DARK_METAL_FLOOR.get()).patternLine("i").patternLine("i").key('i', ECBlockRegistry.DARK_METAL_FLOOR_SLAB.get()).addCriterion("has_dark_metal_floor_slab",
            hasItem(ECBlockRegistry.DARK_METAL_FLOOR_SLAB.get())).build(consumer, ECConstants.MODID + ":dark_metal_floor_from_slabs");
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.DARK_METAL_FLOOR_STAIRS.get(), 4).key('#', ECBlockRegistry.DARK_METAL_FLOOR.get()).patternLine("#  ").patternLine("## ").patternLine("###").addCriterion(
            "has_dark_metal_floor", hasItem(ECBlockRegistry.DARK_METAL_FLOOR.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.DARK_METAL_FLOOR_WALL.get(), 6).key('#', ECBlockRegistry.DARK_METAL_FLOOR.get()).patternLine("###").patternLine("###").addCriterion(
            "has_dark_metal_floor", hasItem(ECBlockRegistry.DARK_METAL_FLOOR.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.DARK_METAL_FLOOR_PRESSURE_PLATE.get()).key('#', ECBlockRegistry.DARK_METAL_FLOOR.get()).patternLine("##").addCriterion("has_dark_metal_floor",
            hasItem(ECBlockRegistry.DARK_METAL_FLOOR.get())).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.RUSTY_PLATE.get(), 4).patternLine(" i ").patternLine("idi").patternLine(" i ").key('i', BaseTags.ForgeItems.PLATES_STEEL).key('d',
            Tags.Items.DYES_ORANGE).addCriterion("has_steel_plate", hasItem(BaseTags.ForgeItems.PLATES_STEEL)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.RUSTY_PLATE_SLAB.get(), 6).patternLine("iii").key('i', ECBlockRegistry.RUSTY_PLATE.get()).addCriterion("has_rusty_plate",
            hasItem(ECBlockRegistry.RUSTY_PLATE.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.RUSTY_PLATE.get()).patternLine("i").patternLine("i").key('i', ECBlockRegistry.RUSTY_PLATE_SLAB.get()).addCriterion("has_rusty_plate_slab",
            hasItem(ECBlockRegistry.RUSTY_PLATE_SLAB.get())).build(consumer, ECConstants.MODID + ":rusty_plate_from_slabs");
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.RUSTY_PLATE_STAIRS.get(), 4).key('#', ECBlockRegistry.RUSTY_PLATE.get()).patternLine("#  ").patternLine("## ").patternLine("###").addCriterion(
            "has_rusty_plate", hasItem(ECBlockRegistry.RUSTY_PLATE.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.RUSTY_PLATE_WALL.get(), 6).key('#', ECBlockRegistry.RUSTY_PLATE.get()).patternLine("###").patternLine("###").addCriterion("has_rusty_plate",
            hasItem(ECBlockRegistry.RUSTY_PLATE.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.RUSTY_PLATE_PRESSURE_PLATE.get()).key('#', ECBlockRegistry.RUSTY_PLATE.get()).patternLine("##").addCriterion("has_rusty_plate",
            hasItem(ECBlockRegistry.RUSTY_PLATE.get())).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.IRON_BEAM.get(), 3).patternLine("iii").key('i', Tags.Items.INGOTS_IRON).addCriterion("has_iron_ingot", hasItem(Tags.Items.INGOTS_IRON)).build(consumer);
        ShapelessRecipeBuilder.shapelessRecipe(ECBlockRegistry.BOLTED_IRON_BEAM.get()).addIngredient(ECBlockRegistry.IRON_BEAM.get()).addIngredient(BaseItems.BOLT.get()).addCriterion("has_iron_beam",
            hasItem(ECBlockRegistry.IRON_BEAM.get())).build(consumer);
        ShapelessRecipeBuilder.shapelessRecipe(ECBlockRegistry.IRON_BEAM_JUNCTION.get()).addIngredient(ECBlockRegistry.IRON_BEAM.get()).addCriterion("has_iron_beam",
            hasItem(ECBlockRegistry.IRON_BEAM.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.STEEL_BEAM.get(), 3).patternLine("iii").key('i', BaseTags.ForgeItems.INGOTS_STEEL).addCriterion("has_steel_ingot",
            hasItem(BaseTags.ForgeItems.INGOTS_STEEL)).build(consumer);
        ShapelessRecipeBuilder.shapelessRecipe(ECBlockRegistry.BOLTED_STEEL_BEAM.get()).addIngredient(ECBlockRegistry.STEEL_BEAM.get()).addIngredient(BaseItems.BOLT.get()).addCriterion("has_steel_beam",
            hasItem(ECBlockRegistry.STEEL_BEAM.get())).build(consumer);
        ShapelessRecipeBuilder.shapelessRecipe(ECBlockRegistry.STEEL_BEAM_JUNCTION.get()).addIngredient(ECBlockRegistry.STEEL_BEAM.get()).addCriterion("has_steel_beam",
            hasItem(ECBlockRegistry.STEEL_BEAM.get())).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.AIR_DUCT.get(), 4).patternLine(" i ").patternLine("igi").patternLine(" i ").key('i', BaseTags.ForgeItems.INGOTS_STEEL).key('g',
            Blocks.IRON_BARS).addCriterion("has_steel_ingot", hasItem(BaseTags.ForgeItems.INGOTS_STEEL)).build(consumer);
        ShapelessRecipeBuilder.shapelessRecipe(ECBlockRegistry.VENT_AIR_DUCT.get()).addIngredient(ECBlockRegistry.AIR_DUCT.get()).addIngredient(Blocks.IRON_BARS).addCriterion("has_air_duct",
            hasItem(ECBlockRegistry.AIR_DUCT.get())).build(consumer);
        ShapelessRecipeBuilder.shapelessRecipe(ECBlockRegistry.GRID_AIR_DUCT.get()).addIngredient(ECBlockRegistry.VENT_AIR_DUCT.get()).addIngredient(Blocks.IRON_BARS).addCriterion("has_vent_air_duct",
            hasItem(ECBlockRegistry.VENT_AIR_DUCT.get())).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.BULKHEAD.get(), 2).patternLine("i").patternLine("i").key('i', ECBlockRegistry.IRON_BEAM.get()).addCriterion("has_iron_beam",
            hasItem(ECBlockRegistry.IRON_BEAM.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.BULKHEAD_TOP.get(), 2).patternLine("c").patternLine("i").key('c', BaseTags.Items.CONCRETE).key('i', ECBlockRegistry.BULKHEAD.get()).addCriterion(
            "has_bulkhead", hasItem(ECBlockRegistry.BULKHEAD.get())).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.STEEL_WALL_LADDER.get(), 8).patternLine("r r").patternLine("rir").patternLine("r r").key('r', BaseTags.ForgeItems.RODS_STEEL).key('i',
            BaseTags.ForgeItems.INGOTS_STEEL).addCriterion("has_steel_ingot", hasItem(BaseTags.ForgeItems.INGOTS_STEEL)).addCriterion("has_steel_rod", hasItem(BaseTags.ForgeItems.RODS_STEEL)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.RUSTY_WALL_LADDER.get(), 8).patternLine("lll").patternLine("lbl").patternLine("lll").key('l', ECBlockRegistry.STEEL_WALL_LADDER.get()).key('b',
            Items.WATER_BUCKET).addCriterion("has_steel_wall_ladder", hasItem(ECBlockRegistry.STEEL_WALL_LADDER.get())).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.STEEL_RUNGS.get(), 8).patternLine("r r").patternLine(" r ").key('r', BaseTags.ForgeItems.RODS_STEEL).addCriterion("has_steel_rod",
            hasItem(BaseTags.ForgeItems.RODS_STEEL)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.RUSTY_RUNGS.get(), 8).patternLine("lll").patternLine("lbl").patternLine("lll").key('l', ECBlockRegistry.STEEL_RUNGS.get()).key('b',
            Items.WATER_BUCKET).addCriterion("has_steel_rungs", hasItem(ECBlockRegistry.STEEL_RUNGS.get())).build(consumer);

        // Wallpapers
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.WHITE_BLUE_WALLPAPER.get(), 3).patternLine("  s").patternLine("lps").patternLine("  s").key('s', Blocks.STONE).key('l', Tags.Items.DYES_LIGHT_BLUE).key(
            'p', Items.PAPER).addCriterion("has_paper", hasItem(Items.PAPER)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.WHITE_BLUE_WALLPAPER_SLAB.get(), 6).patternLine("iii").key('i', ECBlockRegistry.WHITE_BLUE_WALLPAPER.get()).addCriterion("has_white_blue_wallpaper",
            hasItem(ECBlockRegistry.WHITE_BLUE_WALLPAPER.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.WHITE_BLUE_WALLPAPER.get()).patternLine("i").patternLine("i").key('i', ECBlockRegistry.WHITE_BLUE_WALLPAPER_SLAB.get()).addCriterion(
            "has_white_blue_wallpaper_slab", hasItem(ECBlockRegistry.WHITE_BLUE_WALLPAPER_SLAB.get())).build(consumer, ECConstants.MODID + ":white_blue_wallpaper_from_slabs");
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.WHITE_BLUE_WALLPAPER_STAIRS.get(), 4).key('#', ECBlockRegistry.WHITE_BLUE_WALLPAPER.get()).patternLine("#  ").patternLine("## ").patternLine(
            "###").addCriterion("has_white_blue_wallpaper", hasItem(ECBlockRegistry.WHITE_BLUE_WALLPAPER.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.WHITE_BLUE_WALLPAPER_PLINTH.get()).patternLine("w").patternLine("s").key('w', ECBlockRegistry.WHITE_BLUE_WALLPAPER.get()).key('s',
            ItemTags.WOODEN_SLABS).addCriterion("has_white_blue_wallpaper", hasItem(ECBlockRegistry.WHITE_BLUE_WALLPAPER.get())).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.BEIGE_FLOWER_WALLPAPER.get(), 3).patternLine("  s").patternLine("lps").patternLine("g s").key('s', Blocks.STONE).key('l', Tags.Items.DYES_PINK).key('p',
            Items.PAPER).key('g', Tags.Items.DYES_GRAY).addCriterion("has_paper", hasItem(Items.PAPER)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.BEIGE_FLOWER_WALLPAPER_SLAB.get(), 6).patternLine("iii").key('i', ECBlockRegistry.BEIGE_FLOWER_WALLPAPER.get()).addCriterion(
            "has_beige_flower_wallpaper", hasItem(ECBlockRegistry.BEIGE_FLOWER_WALLPAPER.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.BEIGE_FLOWER_WALLPAPER.get()).patternLine("i").patternLine("i").key('i', ECBlockRegistry.BEIGE_FLOWER_WALLPAPER_SLAB.get()).addCriterion(
            "has_beige_flower_wallpaper_slab", hasItem(ECBlockRegistry.BEIGE_FLOWER_WALLPAPER_SLAB.get())).build(consumer, ECConstants.MODID + ":beige_flower_wallpaper_from_slabs");
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.BEIGE_FLOWER_WALLPAPER_STAIRS.get(), 4).key('#', ECBlockRegistry.BEIGE_FLOWER_WALLPAPER.get()).patternLine("#  ").patternLine("## ").patternLine(
            "###").addCriterion("has_beige_flower_wallpaper", hasItem(ECBlockRegistry.BEIGE_FLOWER_WALLPAPER.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.BEIGE_FLOWER_WALLPAPER_PLINTH.get()).patternLine("w").patternLine("s").key('w', ECBlockRegistry.BEIGE_FLOWER_WALLPAPER.get()).key('s',
            ItemTags.WOODEN_SLABS).addCriterion("has_beige_flower_wallpaper", hasItem(ECBlockRegistry.BEIGE_FLOWER_WALLPAPER.get())).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.BEIGE_WALLPAPER.get(), 3).patternLine("  s").patternLine("lps").patternLine("w s").key('s', Blocks.STONE).key('l', Tags.Items.DYES_PINK).key('w',
            Tags.Items.DYES_WHITE).key('p', Items.PAPER).addCriterion("has_paper", hasItem(Items.PAPER)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.BEIGE_WALLPAPER_SLAB.get(), 6).patternLine("iii").key('i', ECBlockRegistry.BEIGE_WALLPAPER.get()).addCriterion("has_beige_wallpaper",
            hasItem(ECBlockRegistry.BEIGE_WALLPAPER.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.BEIGE_WALLPAPER.get()).patternLine("i").patternLine("i").key('i', ECBlockRegistry.BEIGE_WALLPAPER_SLAB.get()).addCriterion("has_beige_wallpaper_slab",
            hasItem(ECBlockRegistry.BEIGE_WALLPAPER_SLAB.get())).build(consumer, ECConstants.MODID + ":beige_wallpaper_from_slabs");
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.BEIGE_WALLPAPER_STAIRS.get(), 4).key('#', ECBlockRegistry.BEIGE_WALLPAPER.get()).patternLine("#  ").patternLine("## ").patternLine("###").addCriterion(
            "has_beige_wallpaper", hasItem(ECBlockRegistry.BEIGE_WALLPAPER.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.BEIGE_WALLPAPER_PLINTH.get()).patternLine("w").patternLine("s").key('w', ECBlockRegistry.BEIGE_WALLPAPER.get()).key('s',
            ItemTags.WOODEN_SLABS).addCriterion("has_beige_wallpaper", hasItem(ECBlockRegistry.BEIGE_WALLPAPER.get())).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.PINK_WALLPAPER.get(), 3).patternLine("  s").patternLine("lps").patternLine("  s").key('s', Blocks.STONE).key('l', Tags.Items.DYES_PINK).key('p',
            Items.PAPER).addCriterion("has_paper", hasItem(Items.PAPER)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.PINK_WALLPAPER_SLAB.get(), 6).patternLine("iii").key('i', ECBlockRegistry.PINK_WALLPAPER.get()).addCriterion("has_pink_wallpaper",
            hasItem(ECBlockRegistry.PINK_WALLPAPER.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.PINK_WALLPAPER.get()).patternLine("i").patternLine("i").key('i', ECBlockRegistry.PINK_WALLPAPER_SLAB.get()).addCriterion("has_pink_wallpaper_slab",
            hasItem(ECBlockRegistry.PINK_WALLPAPER_SLAB.get())).build(consumer, ECConstants.MODID + ":pink_wallpaper_from_slabs");
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.PINK_WALLPAPER_STAIRS.get(), 4).key('#', ECBlockRegistry.PINK_WALLPAPER.get()).patternLine("#  ").patternLine("## ").patternLine("###").addCriterion(
            "has_pink_wallpaper", hasItem(ECBlockRegistry.PINK_WALLPAPER.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.PINK_WALLPAPER_PLINTH.get()).patternLine("w").patternLine("s").key('w', ECBlockRegistry.PINK_WALLPAPER.get()).key('s',
            ItemTags.WOODEN_SLABS).addCriterion("has_pink_wallpaper", hasItem(ECBlockRegistry.PINK_WALLPAPER.get())).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.WHITE_GREEN_WALLPAPER.get(), 3).patternLine("  s").patternLine("lps").patternLine("  s").key('s', Blocks.STONE).key('l', Tags.Items.DYES_LIME).key('p',
            Items.PAPER).addCriterion("has_paper", hasItem(Items.PAPER)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.WHITE_GREEN_WALLPAPER_SLAB.get(), 6).patternLine("iii").key('i', ECBlockRegistry.WHITE_GREEN_WALLPAPER.get()).addCriterion("has_white_green_wallpaper",
            hasItem(ECBlockRegistry.WHITE_GREEN_WALLPAPER.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.WHITE_GREEN_WALLPAPER.get()).patternLine("i").patternLine("i").key('i', ECBlockRegistry.WHITE_GREEN_WALLPAPER_SLAB.get()).addCriterion(
            "has_white_green_wallpaper_slab", hasItem(ECBlockRegistry.WHITE_GREEN_WALLPAPER_SLAB.get())).build(consumer, ECConstants.MODID + ":white_green_wallpaper_from_slabs");
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.WHITE_GREEN_WALLPAPER_STAIRS.get(), 4).key('#', ECBlockRegistry.WHITE_GREEN_WALLPAPER.get()).patternLine("#  ").patternLine("## ").patternLine(
            "###").addCriterion("has_white_green_wallpaper", hasItem(ECBlockRegistry.WHITE_GREEN_WALLPAPER.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.WHITE_GREEN_WALLPAPER_PLINTH.get()).patternLine("w").patternLine("s").key('w', ECBlockRegistry.WHITE_GREEN_WALLPAPER.get()).key('s',
            ItemTags.WOODEN_SLABS).addCriterion("has_white_green_wallpaper", hasItem(ECBlockRegistry.WHITE_GREEN_WALLPAPER.get())).build(consumer);

        // Furniture
        for(int j = 0; j < Arrays.stream(McWoods.values()).count(); j++)
        {
            ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.CHAIR_BLOCKS.get(McWoods.byId(j)).get()).key('W', ECConstants.McWoodenSlabs[j]).key('S', Tags.Items.RODS_WOODEN).patternLine("S  ").patternLine(
                "SWS").patternLine("S S").setGroup("chairs").addCriterion("has_" + McWoods.byId(j).getString() + "_slab", hasItem(ECConstants.McWoodenSlabs[j])).build(consumer);
            ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.TERRACE_CHAIR_BLOCKS.get(McWoods.byId(j)).get()).key('W', ECConstants.McWoodenPressures[j]).key('S', Tags.Items.RODS_WOODEN).patternLine(
                "S  ").patternLine("SWS").patternLine("S S").setGroup("terrace_chairs").addCriterion("has_" + McWoods.byId(j).getString() + "_pressure_plate", hasItem(ECConstants.McWoodenPressures[j])).build(
                    consumer);
            ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.TABLE_BLOCKS.get(McWoods.byId(j)).get()).key('W', ECConstants.McWoodenSlabs[j]).key('S', Tags.Items.RODS_WOODEN).patternLine("SWS").patternLine(
                "S S").patternLine("S S").setGroup("tables").addCriterion("has_" + McWoods.byId(j).getString() + "_slab", hasItem(ECConstants.McWoodenSlabs[j])).build(consumer);
            ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.TERRACE_TABLE_BLOCKS.get(McWoods.byId(j)).get()).key('W', ECConstants.McWoodenPressures[j]).key('S', Tags.Items.RODS_WOODEN).patternLine(
                "WWW").patternLine(" S ").patternLine(" S ").setGroup("terrace_tables").addCriterion("has_" + McWoods.byId(j).getString() + "_pressure_plate", hasItem(ECConstants.McWoodenPressures[j])).build(
                    consumer);
            ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.FANCY_TABLE_BLOCKS.get(McWoods.byId(j)).get(), 2).key('W', ECConstants.McWoodenPlanks[j]).key('S', ECConstants.McWoodenLogs[j]).patternLine(
                "WWW").patternLine("S S").patternLine("S S").setGroup("fancy_tables").addCriterion("has_" + McWoods.byId(j).getString() + "_planks", hasItem(ECConstants.McWoodenPlanks[j])).build(consumer);
            ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.FANCY_DOOR_BLOCKS.get(McWoods.byId(j)).get(), 3).key('P', ECConstants.McWoodenPlanks[j]).key('B', ECConstants.McWoodenButtons[j]).patternLine(
                "PP").patternLine("PB").patternLine("PP").setGroup("fancy_doors").addCriterion("has_" + McWoods.byId(j).getString() + "_planks", hasItem(ECConstants.McWoodenPlanks[j])).build(consumer);
            ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.PLAIN_DOOR_BLOCKS.get(McWoods.byId(j)).get(), 3).key('P', ECConstants.McWoodenLogs[j]).key('B', ECConstants.McWoodenButtons[j]).patternLine(
                "PP").patternLine("PB").patternLine("PP").setGroup("plain_doors").addCriterion("has_" + McWoods.byId(j).getString() + "_log", hasItem(ECConstants.McWoodenLogs[j])).build(consumer);
            ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.SUSPENDED_STAIRS_BLOCKS.get(McWoods.byId(j)).get(), 6).key('P', ECConstants.McWoodenPlanks[j]).key('S', Tags.Items.RODS_WOODEN).patternLine(
                "  P").patternLine(" PS").patternLine("PS ").setGroup("suspended_stairs").addCriterion("has_" + McWoods.byId(j).getString() + "_planks", hasItem(ECConstants.McWoodenPlanks[j])).build(consumer);
            ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.WOODEN_CRATE_BLOCKS.get(McWoods.byId(j)).get()).key('B', BaseItems.BOLT.get()).key('W', ECConstants.McWoodenPlanks[j]).patternLine(
                "BWB").patternLine("W W").patternLine("BWB").setGroup("wooden_crates").addCriterion("has_" + McWoods.byId(j).getString() + "_planks", hasItem(ECConstants.McWoodenPlanks[j])).build(consumer);
            ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.FANCY_CHEST_BLOCKS.get(McWoods.byId(j)).get()).key('C', Blocks.CHEST).key('W', ECConstants.McWoodenSlabs[j]).patternLine(" W ").patternLine(
                "WCW").patternLine(" W ").setGroup("fancy_chests").addCriterion("has_chest", hasItem(Blocks.CHEST)).build(consumer);
        }

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.LOCKER.get()).key('P', BaseTags.ForgeItems.PLATES_STEEL).key('I', BaseTags.ForgeItems.INGOTS_STEEL).patternLine("PPP").patternLine("P P").patternLine(
            "PIP").addCriterion("has_steel_ingot", hasItem(BaseTags.ForgeItems.INGOTS_STEEL)).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.STEEL_SUSPENDED_STAIRS.get(), 6).key('P', BaseTags.ForgeItems.PLATES_STEEL).key('S', BaseTags.ForgeItems.RODS_STEEL).patternLine("  P").patternLine(
            " PS").patternLine("PS ").addCriterion("has_steel_plate", hasItem(BaseTags.ForgeItems.PLATES_STEEL)).build(consumer);
        ShapelessRecipeBuilder.shapelessRecipe(ECBlockRegistry.RUSTY_SUSPENDED_STAIRS.get()).addIngredient(ECBlockRegistry.STEEL_SUSPENDED_STAIRS.get()).addIngredient(Items.WATER_BUCKET).addCriterion(
            "has_steel_suspended_stairs", hasItem(ECBlockRegistry.STEEL_SUSPENDED_STAIRS.get())).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.STEEL_TERRACE_CHAIR.get()).key('W', BaseTags.ForgeItems.PLATES_STEEL).key('S', BaseTags.ForgeItems.RODS_STEEL).patternLine("S  ").patternLine(
            "SWS").patternLine("S S").addCriterion("has_steel_plate", hasItem(BaseTags.ForgeItems.PLATES_STEEL)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.STEEL_TERRACE_TABLE.get()).key('W', BaseTags.ForgeItems.PLATES_STEEL).key('S', BaseTags.ForgeItems.RODS_STEEL).patternLine("WWW").patternLine(
            " S ").patternLine(" S ").addCriterion("has_steel_plate", hasItem(BaseTags.ForgeItems.PLATES_STEEL)).build(consumer);

        for(int j = 0; j < Arrays.stream(DyeColor.values()).count(); j++)
        {
            ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.COUCH_BLOCKS.get(DyeColor.byId(j)).get(), 3).patternLine("w ").patternLine("ww").patternLine("pp").key('p', ItemTags.WOODEN_SLABS).key('w',
                ECConstants.McWools[j]).addCriterion("has_" + DyeColor.byId(j).getString() + "_wool", hasItem(ECConstants.McWools[j])).build(consumer);
            ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.TABLE_LAMP_BLOCKS.get(DyeColor.byId(j)).get()).patternLine(" w ").patternLine("wgw").patternLine(" p ").key('g', Tags.Items.DUSTS_GLOWSTONE).key('p',
                ItemTags.PLANKS).key('w', ECConstants.McWools[j]).addCriterion("has_" + DyeColor.byId(j).getString() + "_wool", hasItem(ECConstants.McWools[j])).build(consumer);

            ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.PILLOW_BLOCKS.get(DyeColor.byId(j)).get()).patternLine(" S ").patternLine("SWS").patternLine(" S ").key('S', Tags.Items.STRING).key('W',
                ECConstants.McWools[j]).addCriterion("has_" + DyeColor.byId(j).getString() + "_wool", hasItem(ECConstants.McWools[j])).build(consumer);

            ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.ACACIA_FANCY_BED_BLOCKS.get(DyeColor.byId(j)).get()).key('P', Blocks.ACACIA_PLANKS).key('W', ECConstants.McWools[j]).patternLine("P P").patternLine(
                "WWW").patternLine("PPP").setGroup("fancy_beds").addCriterion("has_acacia_planks", hasItem(Blocks.ACACIA_PLANKS)).build(consumer);
            ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.BIRCH_FANCY_BED_BLOCKS.get(DyeColor.byId(j)).get()).key('P', Blocks.BIRCH_PLANKS).key('W', ECConstants.McWools[j]).patternLine("P P").patternLine(
                "WWW").patternLine("PPP").setGroup("fancy_beds").addCriterion("has_birch_planks", hasItem(Blocks.BIRCH_PLANKS)).build(consumer);
            ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.DARK_OAK_FANCY_BED_BLOCKS.get(DyeColor.byId(j)).get()).key('P', Blocks.DARK_OAK_PLANKS).key('W', ECConstants.McWools[j]).patternLine(
                "P P").patternLine("WWW").patternLine("PPP").setGroup("fancy_beds").addCriterion("has_dark_oak_planks", hasItem(Blocks.DARK_OAK_PLANKS)).build(consumer);
            ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.JUNGLE_FANCY_BED_BLOCKS.get(DyeColor.byId(j)).get()).key('P', Blocks.JUNGLE_PLANKS).key('W', ECConstants.McWools[j]).patternLine("P P").patternLine(
                "WWW").patternLine("PPP").setGroup("fancy_beds").addCriterion("has_jungle_planks", hasItem(Blocks.JUNGLE_PLANKS)).build(consumer);
            ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.OAK_FANCY_BED_BLOCKS.get(DyeColor.byId(j)).get()).key('P', Blocks.OAK_PLANKS).key('W', ECConstants.McWools[j]).patternLine("P P").patternLine(
                "WWW").patternLine("PPP").setGroup("fancy_beds").addCriterion("has_oak_planks", hasItem(Blocks.OAK_PLANKS)).build(consumer);
            ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.SPRUCE_FANCY_BED_BLOCKS.get(DyeColor.byId(j)).get()).key('P', Blocks.SPRUCE_PLANKS).key('W', ECConstants.McWools[j]).patternLine("P P").patternLine(
                "WWW").patternLine("PPP").setGroup("fancy_beds").addCriterion("has_spruce_planks", hasItem(Blocks.SPRUCE_PLANKS)).build(consumer);
            ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.WARPED_FANCY_BED_BLOCKS.get(DyeColor.byId(j)).get()).key('P', Blocks.WARPED_PLANKS).key('W', ECConstants.McWools[j]).patternLine("P P").patternLine(
                "WWW").patternLine("PPP").setGroup("fancy_beds").addCriterion("has_warped_planks", hasItem(Blocks.WARPED_PLANKS)).build(consumer);
            ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.CRIMSON_FANCY_BED_BLOCKS.get(DyeColor.byId(j)).get()).key('P', Blocks.CRIMSON_PLANKS).key('W', ECConstants.McWools[j]).patternLine(
                "P P").patternLine("WWW").patternLine("PPP").setGroup("fancy_beds").addCriterion("has_crimson_planks", hasItem(Blocks.CRIMSON_PLANKS)).build(consumer);
        }

        for(int j = 1; j < Arrays.stream(DyeColor.values()).count(); j++)
        {
            ShapelessRecipeBuilder.shapelessRecipe(ECBlockRegistry.PILLOW_BLOCKS.get(DyeColor.byId(j)).get()).addIngredient(ECBlockRegistry.PILLOW_BLOCKS.get(DyeColor.byId(0)).get()).addIngredient(
                DyeColor.byId(j).getTag()).addCriterion("has_white_pillow", hasItem(ECBlockRegistry.PILLOW_BLOCKS.get(DyeColor.byId(0)).get())).build(consumer,
                    DyeColor.byId(j).getString() + "_pillow_from_white");

            ShapelessRecipeBuilder.shapelessRecipe(ECBlockRegistry.COUCH_BLOCKS.get(DyeColor.byId(j)).get()).addIngredient(ECBlockRegistry.COUCH_BLOCKS.get(DyeColor.byId(0)).get()).addIngredient(
                DyeColor.byId(j).getTag()).addCriterion("has_white_couch", hasItem(ECBlockRegistry.COUCH_BLOCKS.get(DyeColor.byId(0)).get())).build(consumer, DyeColor.byId(j).getString() + "_couch_from_white");

            ShapelessRecipeBuilder.shapelessRecipe(ECBlockRegistry.TABLE_LAMP_BLOCKS.get(DyeColor.byId(j)).get()).addIngredient(ECBlockRegistry.TABLE_LAMP_BLOCKS.get(DyeColor.byId(0)).get()).addIngredient(
                DyeColor.byId(j).getTag()).addCriterion("has_white_table_lamp", hasItem(ECBlockRegistry.TABLE_LAMP_BLOCKS.get(DyeColor.byId(0)).get())).build(consumer,
                    DyeColor.byId(j).getString() + "_table_lamp_from_white");

            ShapelessRecipeBuilder.shapelessRecipe(ECBlockRegistry.CORRUGATED_METAL_PLATE_BLOCKS.get(DyeColor.byId(j)).get()).addIngredient(
                ECBlockRegistry.CORRUGATED_METAL_PLATE_BLOCKS.get(DyeColor.byId(0)).get()).addIngredient(DyeColor.byId(j).getTag()).addCriterion("has_white_corrugated_metal_plate",
                    hasItem(ECBlockRegistry.CORRUGATED_METAL_PLATE_BLOCKS.get(DyeColor.byId(0)).get())).build(consumer, DyeColor.byId(j).getString() + "_corrugated_metal_plate_from_white");
            ShapelessRecipeBuilder.shapelessRecipe(ECBlockRegistry.CORRUGATED_METAL_PLATE_SLABS.get(DyeColor.byId(j)).get()).addIngredient(
                ECBlockRegistry.CORRUGATED_METAL_PLATE_SLABS.get(DyeColor.byId(0)).get()).addIngredient(DyeColor.byId(j).getTag()).addCriterion("has_white_corrugated_metal_plate_slab",
                    hasItem(ECBlockRegistry.CORRUGATED_METAL_PLATE_SLABS.get(DyeColor.byId(0)).get())).build(consumer, DyeColor.byId(j).getString() + "_corrugated_metal_plate_slab_from_white");
            ShapelessRecipeBuilder.shapelessRecipe(ECBlockRegistry.CORRUGATED_METAL_PLATE_WALLS.get(DyeColor.byId(j)).get()).addIngredient(
                ECBlockRegistry.CORRUGATED_METAL_PLATE_WALLS.get(DyeColor.byId(0)).get()).addIngredient(DyeColor.byId(j).getTag()).addCriterion("has_white_corrugated_metal_plate_wall",
                    hasItem(ECBlockRegistry.CORRUGATED_METAL_PLATE_WALLS.get(DyeColor.byId(0)).get())).build(consumer, DyeColor.byId(j).getString() + "_corrugated_metal_plate_wall_from_white");
            ShapelessRecipeBuilder.shapelessRecipe(ECBlockRegistry.CORRUGATED_METAL_PLATE_STAIRS.get(DyeColor.byId(j)).get()).addIngredient(
                ECBlockRegistry.CORRUGATED_METAL_PLATE_STAIRS.get(DyeColor.byId(0)).get()).addIngredient(DyeColor.byId(j).getTag()).addCriterion("has_white_corrugated_metal_plate_stairs",
                    hasItem(ECBlockRegistry.CORRUGATED_METAL_PLATE_STAIRS.get(DyeColor.byId(0)).get())).build(consumer, DyeColor.byId(j).getString() + "_corrugated_metal_plate_stairs_from_white");
            ShapelessRecipeBuilder.shapelessRecipe(ECBlockRegistry.CORRUGATED_METAL_PLATE_PRESSURE_PLATES.get(DyeColor.byId(j)).get()).addIngredient(
                ECBlockRegistry.CORRUGATED_METAL_PLATE_PRESSURE_PLATES.get(DyeColor.byId(0)).get()).addIngredient(DyeColor.byId(j).getTag()).addCriterion("has_white_corrugated_metal_plate_pressure_plate",
                    hasItem(ECBlockRegistry.CORRUGATED_METAL_PLATE_PRESSURE_PLATES.get(DyeColor.byId(0)).get())).build(consumer,
                        DyeColor.byId(j).getString() + "_corrugated_metal_plate_pressure_plate_from_white");
            ShapelessRecipeBuilder.shapelessRecipe(ECBlockRegistry.CORRUGATED_METAL_PLATE_FENCES.get(DyeColor.byId(j)).get()).addIngredient(
                ECBlockRegistry.CORRUGATED_METAL_PLATE_FENCES.get(DyeColor.byId(0)).get()).addIngredient(DyeColor.byId(j).getTag()).addCriterion("has_white_corrugated_metal_plate_fence",
                    hasItem(ECBlockRegistry.CORRUGATED_METAL_PLATE_FENCES.get(DyeColor.byId(0)).get())).build(consumer, DyeColor.byId(j).getString() + "_corrugated_metal_plate_fence_from_white");
            ShapelessRecipeBuilder.shapelessRecipe(ECBlockRegistry.CORRUGATED_METAL_PLATE_FENCE_GATES.get(DyeColor.byId(j)).get()).addIngredient(
                ECBlockRegistry.CORRUGATED_METAL_PLATE_FENCE_GATES.get(DyeColor.byId(0)).get()).addIngredient(DyeColor.byId(j).getTag()).addCriterion("has_white_corrugated_metal_plate_fence_gate",
                    hasItem(ECBlockRegistry.CORRUGATED_METAL_PLATE_FENCE_GATES.get(DyeColor.byId(0)).get())).build(consumer, DyeColor.byId(j).getString() + "_corrugated_metal_plate_fence_gate_from_white");

            ShapelessRecipeBuilder.shapelessRecipe(ECBlockRegistry.ACACIA_FANCY_BED_BLOCKS.get(DyeColor.byId(j)).get()).addIngredient(
                ECBlockRegistry.ACACIA_FANCY_BED_BLOCKS.get(DyeColor.byId(0)).get()).addIngredient(DyeColor.byId(j).getTag()).addCriterion("has_white_acacia_fancy_bed",
                    hasItem(ECBlockRegistry.ACACIA_FANCY_BED_BLOCKS.get(DyeColor.byId(0)).get())).build(consumer, DyeColor.byId(j).getString() + "_acacia_fancy_bed_from_white");
            ShapelessRecipeBuilder.shapelessRecipe(ECBlockRegistry.BIRCH_FANCY_BED_BLOCKS.get(DyeColor.byId(j)).get()).addIngredient(
                ECBlockRegistry.BIRCH_FANCY_BED_BLOCKS.get(DyeColor.byId(0)).get()).addIngredient(DyeColor.byId(j).getTag()).addCriterion("has_white_birch_fancy_bed",
                    hasItem(ECBlockRegistry.BIRCH_FANCY_BED_BLOCKS.get(DyeColor.byId(0)).get())).build(consumer, DyeColor.byId(j).getString() + "_birch_fancy_bed_from_white");
            ShapelessRecipeBuilder.shapelessRecipe(ECBlockRegistry.DARK_OAK_FANCY_BED_BLOCKS.get(DyeColor.byId(j)).get()).addIngredient(
                ECBlockRegistry.DARK_OAK_FANCY_BED_BLOCKS.get(DyeColor.byId(0)).get()).addIngredient(DyeColor.byId(j).getTag()).addCriterion("has_white_dark_oak_fancy_bed",
                    hasItem(ECBlockRegistry.DARK_OAK_FANCY_BED_BLOCKS.get(DyeColor.byId(0)).get())).build(consumer, DyeColor.byId(j).getString() + "_dark_oak_fancy_bed_from_white");
            ShapelessRecipeBuilder.shapelessRecipe(ECBlockRegistry.JUNGLE_FANCY_BED_BLOCKS.get(DyeColor.byId(j)).get()).addIngredient(
                ECBlockRegistry.JUNGLE_FANCY_BED_BLOCKS.get(DyeColor.byId(0)).get()).addIngredient(DyeColor.byId(j).getTag()).addCriterion("has_white_jungle_fancy_bed",
                    hasItem(ECBlockRegistry.JUNGLE_FANCY_BED_BLOCKS.get(DyeColor.byId(0)).get())).build(consumer, DyeColor.byId(j).getString() + "_jungle_fancy_bed_from_white");
            ShapelessRecipeBuilder.shapelessRecipe(ECBlockRegistry.OAK_FANCY_BED_BLOCKS.get(DyeColor.byId(j)).get()).addIngredient(
                ECBlockRegistry.OAK_FANCY_BED_BLOCKS.get(DyeColor.byId(0)).get()).addIngredient(DyeColor.byId(j).getTag()).addCriterion("has_white_oak_fancy_bed",
                    hasItem(ECBlockRegistry.OAK_FANCY_BED_BLOCKS.get(DyeColor.byId(0)).get())).build(consumer, DyeColor.byId(j).getString() + "_oak_fancy_bed_from_white");
            ShapelessRecipeBuilder.shapelessRecipe(ECBlockRegistry.SPRUCE_FANCY_BED_BLOCKS.get(DyeColor.byId(j)).get()).addIngredient(
                ECBlockRegistry.SPRUCE_FANCY_BED_BLOCKS.get(DyeColor.byId(0)).get()).addIngredient(DyeColor.byId(j).getTag()).addCriterion("has_white_spruce_fancy_bed",
                    hasItem(ECBlockRegistry.SPRUCE_FANCY_BED_BLOCKS.get(DyeColor.byId(0)).get())).build(consumer, DyeColor.byId(j).getString() + "_spruce_fancy_bed_from_white");
        }

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.PLATE.get(), 4).key('W', Tags.Items.DYES_WHITE).key('C', Items.CLAY_BALL).patternLine(" C ").patternLine("CWC").patternLine(" C ").addCriterion(
            "has_clay_ball", hasItem(Items.CLAY_BALL)).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.STEEL_DOOR.get(), 3).key('S', BaseTags.ForgeItems.INGOTS_STEEL).patternLine("SS").patternLine("SS").patternLine("SS").addCriterion("has_steel_ingot",
            hasItem(BaseTags.ForgeItems.INGOTS_STEEL)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.STURDY_STEEL_DOOR.get()).key('P', BaseTags.ForgeItems.PLATES_STEEL).key('D', ECBlockRegistry.STEEL_DOOR.get()).patternLine("D").patternLine(
            "P").addCriterion("has_steel_door", hasItem(ECBlockRegistry.STEEL_DOOR.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.WARNING_STEEL_DOOR.get()).key('P', ECBlockRegistry.STEEL_DOOR.get()).key('D', Tags.Items.DYES_YELLOW).patternLine("D").patternLine("P").addCriterion(
            "has_steel_door", hasItem(ECBlockRegistry.STEEL_DOOR.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.WHITE_STEEL_DOOR.get()).key('P', ECBlockRegistry.STEEL_DOOR.get()).key('D', Tags.Items.DYES_WHITE).patternLine("D").patternLine("P").addCriterion(
            "has_steel_door", hasItem(ECBlockRegistry.STEEL_DOOR.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.STURDY_WHITE_STEEL_DOOR.get()).key('P', BaseTags.ForgeItems.PLATES_STEEL).key('D', ECBlockRegistry.WHITE_STEEL_DOOR.get()).patternLine("D").patternLine(
            "P").addCriterion("has_white_steel_door", hasItem(ECBlockRegistry.WHITE_STEEL_DOOR.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ECBlockRegistry.WARNING_WHITE_STEEL_DOOR.get()).key('P', ECBlockRegistry.WHITE_STEEL_DOOR.get()).key('D', Tags.Items.DYES_YELLOW).patternLine("D").patternLine(
            "P").addCriterion("has_white_steel_door", hasItem(ECBlockRegistry.WHITE_STEEL_DOOR.get())).build(consumer);

        ShapelessRecipeBuilder.shapelessRecipe(ECBlockRegistry.RUSTY_DOOR.get()).addIngredient(ECBlockRegistry.STEEL_DOOR.get()).addIngredient(Items.WATER_BUCKET).addCriterion("has_steel_door",
            hasItem(ECBlockRegistry.STEEL_DOOR.get())).build(consumer);
        ShapelessRecipeBuilder.shapelessRecipe(ECBlockRegistry.STURDY_RUSTY_DOOR.get()).addIngredient(ECBlockRegistry.STURDY_STEEL_DOOR.get()).addIngredient(Items.WATER_BUCKET).addCriterion(
            "has_sturdy_steel_door", hasItem(ECBlockRegistry.STURDY_STEEL_DOOR.get())).build(consumer);
        ShapelessRecipeBuilder.shapelessRecipe(ECBlockRegistry.WARNING_RUSTY_DOOR.get()).addIngredient(ECBlockRegistry.WARNING_STEEL_DOOR.get()).addIngredient(Items.WATER_BUCKET).addCriterion(
            "has_warning_steel_door", hasItem(ECBlockRegistry.WARNING_STEEL_DOOR.get())).build(consumer);
    }
}