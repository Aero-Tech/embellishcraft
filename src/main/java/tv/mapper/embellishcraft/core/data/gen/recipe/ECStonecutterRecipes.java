package tv.mapper.embellishcraft.core.data.gen.recipe;

import java.util.Objects;
import java.util.function.Consumer;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.SingleItemRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import tv.mapper.mapperbase.data.gen.BaseRecipes;

public class ECStonecutterRecipes extends BaseRecipes
{
    public ECStonecutterRecipes(DataGenerator generatorIn)
    {
        super(generatorIn);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer)
    {}

    protected void basicRecipes(Consumer<FinishedRecipe> consumer, Block base, Block slab, Block stairs, Block wall, Block pressure)
    {
        String base_name = Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(base)).getPath();

        if(slab != null)
            SingleItemRecipeBuilder.stonecutting(Ingredient.of(base), slab, 2).unlockedBy("has_" + base_name, has(base)).save(consumer, base_name + "_slab_from_" + base_name + "_stonecutting");
        if(stairs != null)
            SingleItemRecipeBuilder.stonecutting(Ingredient.of(base), stairs).unlockedBy("has_" + base_name, has(base)).save(consumer, base_name + "_stairs_from_" + base_name + "_stonecutting");
        if(wall != null)
            SingleItemRecipeBuilder.stonecutting(Ingredient.of(base), wall).unlockedBy("has_" + base_name, has(base)).save(consumer, base_name + "_wall_from_" + base_name + "_stonecutting");
        if(pressure != null)
            SingleItemRecipeBuilder.stonecutting(Ingredient.of(base), pressure, 2).unlockedBy("has_" + base_name, has(base)).save(consumer, base_name + "_pressure_plate_from_" + base_name + "_stonecutting");
    }
}