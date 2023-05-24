package tv.mapper.embellishcraft.core.data.gen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.data.event.GatherDataEvent;
import tv.mapper.embellishcraft.building.data.gen.BuildingBlockModels;
import tv.mapper.embellishcraft.building.data.gen.BuildingBlockStates;
import tv.mapper.embellishcraft.building.data.gen.BuildingItemModels;
import tv.mapper.embellishcraft.building.data.gen.BuildingLootTables;
import tv.mapper.embellishcraft.building.data.gen.recipe.BuildingRecipes;
import tv.mapper.embellishcraft.building.data.gen.recipe.BuildingStoneCutter;
import tv.mapper.embellishcraft.core.ECConstants;
import tv.mapper.embellishcraft.core.data.gen.recipe.ECRecipes;
import tv.mapper.embellishcraft.core.data.gen.recipe.ECStonecutterRecipes;
import tv.mapper.embellishcraft.furniture.data.gen.FurnitureBlockModels;
import tv.mapper.embellishcraft.furniture.data.gen.FurnitureBlockStates;
import tv.mapper.embellishcraft.furniture.data.gen.FurnitureItemModels;
import tv.mapper.embellishcraft.furniture.data.gen.FurnitureLootTables;
import tv.mapper.embellishcraft.furniture.data.gen.recipe.FurnitureRecipes;
import tv.mapper.embellishcraft.industrial.data.gen.IndustrialBlockModels;
import tv.mapper.embellishcraft.industrial.data.gen.IndustrialBlockStates;
import tv.mapper.embellishcraft.industrial.data.gen.IndustrialItemModels;
import tv.mapper.embellishcraft.industrial.data.gen.IndustrialLootTables;
import tv.mapper.embellishcraft.industrial.data.gen.recipe.IndustrialRecipes;
import tv.mapper.embellishcraft.lights.data.gen.LightBlockModels;
import tv.mapper.embellishcraft.lights.data.gen.LightBlockStates;
import tv.mapper.embellishcraft.lights.data.gen.LightItemModels;
import tv.mapper.embellishcraft.lights.data.gen.LightLootTables;
import tv.mapper.embellishcraft.lights.data.gen.recipe.LightRecipes;
import tv.mapper.embellishcraft.rocks.data.gen.RockBlockModels;
import tv.mapper.embellishcraft.rocks.data.gen.RockBlockStates;
import tv.mapper.embellishcraft.rocks.data.gen.RockItemModels;
import tv.mapper.embellishcraft.rocks.data.gen.RockLootTables;
import tv.mapper.embellishcraft.rocks.data.gen.recipe.RockRecipes;
import tv.mapper.embellishcraft.rocks.data.gen.recipe.RockStoneCutter;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ECGenerators
{
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event)
    {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        // Recipes
        generator.addProvider(true, new ECRecipes(generator));
        generator.addProvider(true, new RockRecipes(generator));
        generator.addProvider(true, new IndustrialRecipes(generator));
        generator.addProvider(true, new BuildingRecipes(generator));
        generator.addProvider(true, new FurnitureRecipes(generator));
        generator.addProvider(true, new LightRecipes(generator));

        // Stonecutter
        generator.addProvider(true, new ECStonecutterRecipes(generator));
        generator.addProvider(true, new RockStoneCutter(generator));
        generator.addProvider(true, new BuildingStoneCutter(generator));

        // Loot Tables
        generator.addProvider(true, new ECLootTables(generator));
        generator.addProvider(true, new RockLootTables(generator));
        generator.addProvider(true, new IndustrialLootTables(generator));
        generator.addProvider(true, new BuildingLootTables(generator));
        generator.addProvider(true, new FurnitureLootTables(generator));
        generator.addProvider(true, new LightLootTables(generator));

        // Block States
        generator.addProvider(true, new ECBlockStates(generator, ECConstants.MODID, existingFileHelper));
        generator.addProvider(true, new RockBlockStates(generator, ECConstants.MODID, existingFileHelper));
        generator.addProvider(true, new IndustrialBlockStates(generator, ECConstants.MODID, existingFileHelper));
        generator.addProvider(true, new BuildingBlockStates(generator, ECConstants.MODID, existingFileHelper));
        generator.addProvider(true, new FurnitureBlockStates(generator, ECConstants.MODID, existingFileHelper));
        generator.addProvider(true, new LightBlockStates(generator, ECConstants.MODID, existingFileHelper));

        // Block Models
        generator.addProvider(true, new ECBlockModels(generator, ECConstants.MODID, existingFileHelper));
        generator.addProvider(true, new RockBlockModels(generator, ECConstants.MODID, existingFileHelper));
        generator.addProvider(true, new IndustrialBlockModels(generator, ECConstants.MODID, existingFileHelper));
        generator.addProvider(true, new BuildingBlockModels(generator, ECConstants.MODID, existingFileHelper));
        generator.addProvider(true, new FurnitureBlockModels(generator, ECConstants.MODID, existingFileHelper));
        generator.addProvider(true, new LightBlockModels(generator, ECConstants.MODID, existingFileHelper));

        // Item Models
        generator.addProvider(true, new ECItemModels(generator, ECConstants.MODID, existingFileHelper));
        generator.addProvider(true, new RockItemModels(generator, ECConstants.MODID, existingFileHelper));
        generator.addProvider(true, new IndustrialItemModels(generator, ECConstants.MODID, existingFileHelper));
        generator.addProvider(true, new BuildingItemModels(generator, ECConstants.MODID, existingFileHelper));
        generator.addProvider(true, new FurnitureItemModels(generator, ECConstants.MODID, existingFileHelper));
        generator.addProvider(true, new LightItemModels(generator, ECConstants.MODID, existingFileHelper));

        ECBlockTags blockTags = new ECBlockTags(generator, ECConstants.MODID, existingFileHelper);

        generator.addProvider(true, blockTags);
        generator.addProvider(true, new ECItemTags(generator, blockTags, existingFileHelper));

        // Lang
        generator.addProvider(true, new ECLang(generator, ECConstants.MODID, "en_us"));
        generator.addProvider(true, new ECLang(generator, ECConstants.MODID, "fr_fr"));
    }
}