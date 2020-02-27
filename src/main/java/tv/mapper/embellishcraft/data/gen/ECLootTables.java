package tv.mapper.embellishcraft.data.gen;

import java.util.Arrays;

import net.minecraft.data.DataGenerator;
import net.minecraft.item.DyeColor;
import tv.mapper.embellishcraft.ECConstants;
import tv.mapper.embellishcraft.block.ECBlockRegistry;
import tv.mapper.mapperbase.data.gen.BaseLootTableProvider;

public class ECLootTables extends BaseLootTableProvider
{

    public ECLootTables(DataGenerator dataGeneratorIn)
    {
        super(dataGeneratorIn);
    }

    @Override
    protected void addTables()
    {
        // Basalt
        lootTables.put(ECBlockRegistry.BASALT.get(), createSilkTable(ECConstants.MODID, ECBlockRegistry.BASALT.get(), ECBlockRegistry.BASALT_COBBLESTONE.get()));
        lootTables.put(ECBlockRegistry.BASALT_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.BASALT_SLAB.get()));
        lootTables.put(ECBlockRegistry.BASALT_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.BASALT_STAIRS.get()));
        lootTables.put(ECBlockRegistry.BASALT_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.BASALT_WALL.get()));
        lootTables.put(ECBlockRegistry.BASALT_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.BASALT_PRESSURE_PLATE.get()));
        lootTables.put(ECBlockRegistry.BASALT_BUTTON.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.BASALT_BUTTON.get()));

        lootTables.put(ECBlockRegistry.BASALT_COBBLESTONE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.BASALT_COBBLESTONE.get()));
        lootTables.put(ECBlockRegistry.BASALT_COBBLESTONE_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.BASALT_COBBLESTONE_SLAB.get()));
        lootTables.put(ECBlockRegistry.BASALT_COBBLESTONE_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.BASALT_COBBLESTONE_STAIRS.get()));
        lootTables.put(ECBlockRegistry.BASALT_COBBLESTONE_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.BASALT_COBBLESTONE_WALL.get()));
        lootTables.put(ECBlockRegistry.BASALT_COBBLESTONE_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.BASALT_COBBLESTONE_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.SMOOTH_BASALT.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SMOOTH_BASALT.get()));
        lootTables.put(ECBlockRegistry.SMOOTH_BASALT_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.SMOOTH_BASALT_SLAB.get()));
        lootTables.put(ECBlockRegistry.SMOOTH_BASALT_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SMOOTH_BASALT_STAIRS.get()));
        lootTables.put(ECBlockRegistry.SMOOTH_BASALT_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SMOOTH_BASALT_WALL.get()));
        lootTables.put(ECBlockRegistry.SMOOTH_BASALT_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SMOOTH_BASALT_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.POLISHED_BASALT.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.POLISHED_BASALT.get()));
        lootTables.put(ECBlockRegistry.POLISHED_BASALT_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.POLISHED_BASALT_SLAB.get()));
        lootTables.put(ECBlockRegistry.POLISHED_BASALT_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.POLISHED_BASALT_STAIRS.get()));
        lootTables.put(ECBlockRegistry.POLISHED_BASALT_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.POLISHED_BASALT_WALL.get()));
        lootTables.put(ECBlockRegistry.POLISHED_BASALT_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.POLISHED_BASALT_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.BASALT_PAVING.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.BASALT_PAVING.get()));
        lootTables.put(ECBlockRegistry.BASALT_PAVING_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.BASALT_PAVING_SLAB.get()));
        lootTables.put(ECBlockRegistry.BASALT_PAVING_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.BASALT_PAVING_STAIRS.get()));
        lootTables.put(ECBlockRegistry.BASALT_PAVING_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.BASALT_PAVING_WALL.get()));
        lootTables.put(ECBlockRegistry.BASALT_PAVING_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.BASALT_PAVING_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.BASALT_TILES.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.BASALT_TILES.get()));
        lootTables.put(ECBlockRegistry.BASALT_TILES_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.BASALT_TILES_SLAB.get()));
        lootTables.put(ECBlockRegistry.BASALT_TILES_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.BASALT_TILES_STAIRS.get()));
        lootTables.put(ECBlockRegistry.BASALT_TILES_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.BASALT_TILES_WALL.get()));
        lootTables.put(ECBlockRegistry.BASALT_TILES_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.BASALT_TILES_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.BASALT_BRICKS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.BASALT_BRICKS.get()));
        lootTables.put(ECBlockRegistry.BASALT_BRICKS_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.BASALT_BRICKS_SLAB.get()));
        lootTables.put(ECBlockRegistry.BASALT_BRICKS_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.BASALT_BRICKS_STAIRS.get()));
        lootTables.put(ECBlockRegistry.BASALT_BRICKS_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.BASALT_BRICKS_WALL.get()));
        lootTables.put(ECBlockRegistry.BASALT_BRICKS_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.BASALT_BRICKS_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.BASALT_LARGE_BRICKS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.BASALT_LARGE_BRICKS.get()));
        lootTables.put(ECBlockRegistry.BASALT_LARGE_BRICKS_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.BASALT_LARGE_BRICKS_SLAB.get()));
        lootTables.put(ECBlockRegistry.BASALT_LARGE_BRICKS_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.BASALT_LARGE_BRICKS_STAIRS.get()));
        lootTables.put(ECBlockRegistry.BASALT_LARGE_BRICKS_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.BASALT_LARGE_BRICKS_WALL.get()));
        lootTables.put(ECBlockRegistry.BASALT_LARGE_BRICKS_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.BASALT_LARGE_BRICKS_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.BASALT_ORNAMENT.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.BASALT_ORNAMENT.get()));
        lootTables.put(ECBlockRegistry.BASALT_ORNAMENT_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.BASALT_ORNAMENT_PRESSURE_PLATE.get()));

        // Slate
        lootTables.put(ECBlockRegistry.SLATE.get(), createSilkTable(ECConstants.MODID, ECBlockRegistry.SLATE.get(), ECBlockRegistry.SLATE_COBBLESTONE.get()));
        lootTables.put(ECBlockRegistry.SLATE_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.SLATE_SLAB.get()));
        lootTables.put(ECBlockRegistry.SLATE_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SLATE_STAIRS.get()));
        lootTables.put(ECBlockRegistry.SLATE_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SLATE_WALL.get()));
        lootTables.put(ECBlockRegistry.SLATE_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SLATE_PRESSURE_PLATE.get()));
        lootTables.put(ECBlockRegistry.SLATE_BUTTON.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SLATE_BUTTON.get()));

        lootTables.put(ECBlockRegistry.SLATE_COBBLESTONE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SLATE_COBBLESTONE.get()));
        lootTables.put(ECBlockRegistry.SLATE_COBBLESTONE_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.SLATE_COBBLESTONE_SLAB.get()));
        lootTables.put(ECBlockRegistry.SLATE_COBBLESTONE_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SLATE_COBBLESTONE_STAIRS.get()));
        lootTables.put(ECBlockRegistry.SLATE_COBBLESTONE_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SLATE_COBBLESTONE_WALL.get()));
        lootTables.put(ECBlockRegistry.SLATE_COBBLESTONE_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SLATE_COBBLESTONE_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.SMOOTH_SLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SMOOTH_SLATE.get()));
        lootTables.put(ECBlockRegistry.SMOOTH_SLATE_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.SMOOTH_SLATE_SLAB.get()));
        lootTables.put(ECBlockRegistry.SMOOTH_SLATE_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SMOOTH_SLATE_STAIRS.get()));
        lootTables.put(ECBlockRegistry.SMOOTH_SLATE_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SMOOTH_SLATE_WALL.get()));
        lootTables.put(ECBlockRegistry.SMOOTH_SLATE_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SMOOTH_SLATE_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.POLISHED_SLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.POLISHED_SLATE.get()));
        lootTables.put(ECBlockRegistry.POLISHED_SLATE_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.POLISHED_SLATE_SLAB.get()));
        lootTables.put(ECBlockRegistry.POLISHED_SLATE_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.POLISHED_SLATE_STAIRS.get()));
        lootTables.put(ECBlockRegistry.POLISHED_SLATE_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.POLISHED_SLATE_WALL.get()));
        lootTables.put(ECBlockRegistry.POLISHED_SLATE_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.POLISHED_SLATE_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.SLATE_PAVING.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SLATE_PAVING.get()));
        lootTables.put(ECBlockRegistry.SLATE_PAVING_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.SLATE_PAVING_SLAB.get()));
        lootTables.put(ECBlockRegistry.SLATE_PAVING_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SLATE_PAVING_STAIRS.get()));
        lootTables.put(ECBlockRegistry.SLATE_PAVING_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SLATE_PAVING_WALL.get()));
        lootTables.put(ECBlockRegistry.SLATE_PAVING_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SLATE_PAVING_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.SLATE_TILES.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SLATE_TILES.get()));
        lootTables.put(ECBlockRegistry.SLATE_TILES_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.SLATE_TILES_SLAB.get()));
        lootTables.put(ECBlockRegistry.SLATE_TILES_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SLATE_TILES_STAIRS.get()));
        lootTables.put(ECBlockRegistry.SLATE_TILES_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SLATE_TILES_WALL.get()));
        lootTables.put(ECBlockRegistry.SLATE_TILES_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SLATE_TILES_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.SLATE_BRICKS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SLATE_BRICKS.get()));
        lootTables.put(ECBlockRegistry.SLATE_BRICKS_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.SLATE_BRICKS_SLAB.get()));
        lootTables.put(ECBlockRegistry.SLATE_BRICKS_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SLATE_BRICKS_STAIRS.get()));
        lootTables.put(ECBlockRegistry.SLATE_BRICKS_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SLATE_BRICKS_WALL.get()));
        lootTables.put(ECBlockRegistry.SLATE_BRICKS_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SLATE_BRICKS_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.SLATE_LARGE_BRICKS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SLATE_LARGE_BRICKS.get()));
        lootTables.put(ECBlockRegistry.SLATE_LARGE_BRICKS_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.SLATE_LARGE_BRICKS_SLAB.get()));
        lootTables.put(ECBlockRegistry.SLATE_LARGE_BRICKS_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SLATE_LARGE_BRICKS_STAIRS.get()));
        lootTables.put(ECBlockRegistry.SLATE_LARGE_BRICKS_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SLATE_LARGE_BRICKS_WALL.get()));
        lootTables.put(ECBlockRegistry.SLATE_LARGE_BRICKS_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SLATE_LARGE_BRICKS_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.SLATE_ORNAMENT.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SLATE_ORNAMENT.get()));
        lootTables.put(ECBlockRegistry.SLATE_ORNAMENT_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SLATE_ORNAMENT_PRESSURE_PLATE.get()));

        // Marble
        lootTables.put(ECBlockRegistry.MARBLE.get(), createSilkTable(ECConstants.MODID, ECBlockRegistry.MARBLE.get(), ECBlockRegistry.MARBLE_COBBLESTONE.get()));
        lootTables.put(ECBlockRegistry.MARBLE_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.MARBLE_SLAB.get()));
        lootTables.put(ECBlockRegistry.MARBLE_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.MARBLE_STAIRS.get()));
        lootTables.put(ECBlockRegistry.MARBLE_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.MARBLE_WALL.get()));
        lootTables.put(ECBlockRegistry.MARBLE_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.MARBLE_PRESSURE_PLATE.get()));
        lootTables.put(ECBlockRegistry.MARBLE_BUTTON.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.MARBLE_BUTTON.get()));

        lootTables.put(ECBlockRegistry.MARBLE_COBBLESTONE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.MARBLE_COBBLESTONE.get()));
        lootTables.put(ECBlockRegistry.MARBLE_COBBLESTONE_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.MARBLE_COBBLESTONE_SLAB.get()));
        lootTables.put(ECBlockRegistry.MARBLE_COBBLESTONE_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.MARBLE_COBBLESTONE_STAIRS.get()));
        lootTables.put(ECBlockRegistry.MARBLE_COBBLESTONE_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.MARBLE_COBBLESTONE_WALL.get()));
        lootTables.put(ECBlockRegistry.MARBLE_COBBLESTONE_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.MARBLE_COBBLESTONE_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.SMOOTH_MARBLE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SMOOTH_MARBLE.get()));
        lootTables.put(ECBlockRegistry.SMOOTH_MARBLE_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.SMOOTH_MARBLE_SLAB.get()));
        lootTables.put(ECBlockRegistry.SMOOTH_MARBLE_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SMOOTH_MARBLE_STAIRS.get()));
        lootTables.put(ECBlockRegistry.SMOOTH_MARBLE_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SMOOTH_MARBLE_WALL.get()));
        lootTables.put(ECBlockRegistry.SMOOTH_MARBLE_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SMOOTH_MARBLE_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.POLISHED_MARBLE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.POLISHED_MARBLE.get()));
        lootTables.put(ECBlockRegistry.POLISHED_MARBLE_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.POLISHED_MARBLE_SLAB.get()));
        lootTables.put(ECBlockRegistry.POLISHED_MARBLE_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.POLISHED_MARBLE_STAIRS.get()));
        lootTables.put(ECBlockRegistry.POLISHED_MARBLE_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.POLISHED_MARBLE_WALL.get()));
        lootTables.put(ECBlockRegistry.POLISHED_MARBLE_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.POLISHED_MARBLE_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.MARBLE_PAVING.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.MARBLE_PAVING.get()));
        lootTables.put(ECBlockRegistry.MARBLE_PAVING_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.MARBLE_PAVING_SLAB.get()));
        lootTables.put(ECBlockRegistry.MARBLE_PAVING_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.MARBLE_PAVING_STAIRS.get()));
        lootTables.put(ECBlockRegistry.MARBLE_PAVING_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.MARBLE_PAVING_WALL.get()));
        lootTables.put(ECBlockRegistry.MARBLE_PAVING_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.MARBLE_PAVING_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.MARBLE_TILES.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.MARBLE_TILES.get()));
        lootTables.put(ECBlockRegistry.MARBLE_TILES_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.MARBLE_TILES_SLAB.get()));
        lootTables.put(ECBlockRegistry.MARBLE_TILES_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.MARBLE_TILES_STAIRS.get()));
        lootTables.put(ECBlockRegistry.MARBLE_TILES_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.MARBLE_TILES_WALL.get()));
        lootTables.put(ECBlockRegistry.MARBLE_TILES_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.MARBLE_TILES_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.MARBLE_BRICKS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.MARBLE_BRICKS.get()));
        lootTables.put(ECBlockRegistry.MARBLE_BRICKS_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.MARBLE_BRICKS_SLAB.get()));
        lootTables.put(ECBlockRegistry.MARBLE_BRICKS_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.MARBLE_BRICKS_STAIRS.get()));
        lootTables.put(ECBlockRegistry.MARBLE_BRICKS_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.MARBLE_BRICKS_WALL.get()));
        lootTables.put(ECBlockRegistry.MARBLE_BRICKS_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.MARBLE_BRICKS_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.MARBLE_LARGE_BRICKS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.MARBLE_LARGE_BRICKS.get()));
        lootTables.put(ECBlockRegistry.MARBLE_LARGE_BRICKS_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.MARBLE_LARGE_BRICKS_SLAB.get()));
        lootTables.put(ECBlockRegistry.MARBLE_LARGE_BRICKS_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.MARBLE_LARGE_BRICKS_STAIRS.get()));
        lootTables.put(ECBlockRegistry.MARBLE_LARGE_BRICKS_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.MARBLE_LARGE_BRICKS_WALL.get()));
        lootTables.put(ECBlockRegistry.MARBLE_LARGE_BRICKS_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.MARBLE_LARGE_BRICKS_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.MARBLE_ORNAMENT.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.MARBLE_ORNAMENT.get()));
        lootTables.put(ECBlockRegistry.MARBLE_ORNAMENT_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.MARBLE_ORNAMENT_PRESSURE_PLATE.get()));

        // Gneiss
        lootTables.put(ECBlockRegistry.GNEISS.get(), createSilkTable(ECConstants.MODID, ECBlockRegistry.GNEISS.get(), ECBlockRegistry.GNEISS_COBBLESTONE.get()));
        lootTables.put(ECBlockRegistry.GNEISS_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.GNEISS_SLAB.get()));
        lootTables.put(ECBlockRegistry.GNEISS_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.GNEISS_STAIRS.get()));
        lootTables.put(ECBlockRegistry.GNEISS_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.GNEISS_WALL.get()));
        lootTables.put(ECBlockRegistry.GNEISS_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.GNEISS_PRESSURE_PLATE.get()));
        lootTables.put(ECBlockRegistry.GNEISS_BUTTON.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.GNEISS_BUTTON.get()));

        lootTables.put(ECBlockRegistry.GNEISS_COBBLESTONE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.GNEISS_COBBLESTONE.get()));
        lootTables.put(ECBlockRegistry.GNEISS_COBBLESTONE_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.GNEISS_COBBLESTONE_SLAB.get()));
        lootTables.put(ECBlockRegistry.GNEISS_COBBLESTONE_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.GNEISS_COBBLESTONE_STAIRS.get()));
        lootTables.put(ECBlockRegistry.GNEISS_COBBLESTONE_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.GNEISS_COBBLESTONE_WALL.get()));
        lootTables.put(ECBlockRegistry.GNEISS_COBBLESTONE_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.GNEISS_COBBLESTONE_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.SMOOTH_GNEISS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SMOOTH_GNEISS.get()));
        lootTables.put(ECBlockRegistry.SMOOTH_GNEISS_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.SMOOTH_GNEISS_SLAB.get()));
        lootTables.put(ECBlockRegistry.SMOOTH_GNEISS_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SMOOTH_GNEISS_STAIRS.get()));
        lootTables.put(ECBlockRegistry.SMOOTH_GNEISS_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SMOOTH_GNEISS_WALL.get()));
        lootTables.put(ECBlockRegistry.SMOOTH_GNEISS_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SMOOTH_GNEISS_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.POLISHED_GNEISS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.POLISHED_GNEISS.get()));
        lootTables.put(ECBlockRegistry.POLISHED_GNEISS_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.POLISHED_GNEISS_SLAB.get()));
        lootTables.put(ECBlockRegistry.POLISHED_GNEISS_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.POLISHED_GNEISS_STAIRS.get()));
        lootTables.put(ECBlockRegistry.POLISHED_GNEISS_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.POLISHED_GNEISS_WALL.get()));
        lootTables.put(ECBlockRegistry.POLISHED_GNEISS_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.POLISHED_GNEISS_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.GNEISS_PAVING.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.GNEISS_PAVING.get()));
        lootTables.put(ECBlockRegistry.GNEISS_PAVING_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.GNEISS_PAVING_SLAB.get()));
        lootTables.put(ECBlockRegistry.GNEISS_PAVING_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.GNEISS_PAVING_STAIRS.get()));
        lootTables.put(ECBlockRegistry.GNEISS_PAVING_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.GNEISS_PAVING_WALL.get()));
        lootTables.put(ECBlockRegistry.GNEISS_PAVING_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.GNEISS_PAVING_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.GNEISS_TILES.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.GNEISS_TILES.get()));
        lootTables.put(ECBlockRegistry.GNEISS_TILES_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.GNEISS_TILES_SLAB.get()));
        lootTables.put(ECBlockRegistry.GNEISS_TILES_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.GNEISS_TILES_STAIRS.get()));
        lootTables.put(ECBlockRegistry.GNEISS_TILES_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.GNEISS_TILES_WALL.get()));
        lootTables.put(ECBlockRegistry.GNEISS_TILES_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.GNEISS_TILES_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.GNEISS_BRICKS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.GNEISS_BRICKS.get()));
        lootTables.put(ECBlockRegistry.GNEISS_BRICKS_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.GNEISS_BRICKS_SLAB.get()));
        lootTables.put(ECBlockRegistry.GNEISS_BRICKS_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.GNEISS_BRICKS_STAIRS.get()));
        lootTables.put(ECBlockRegistry.GNEISS_BRICKS_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.GNEISS_BRICKS_WALL.get()));
        lootTables.put(ECBlockRegistry.GNEISS_BRICKS_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.GNEISS_BRICKS_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.GNEISS_LARGE_BRICKS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.GNEISS_LARGE_BRICKS.get()));
        lootTables.put(ECBlockRegistry.GNEISS_LARGE_BRICKS_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.GNEISS_LARGE_BRICKS_SLAB.get()));
        lootTables.put(ECBlockRegistry.GNEISS_LARGE_BRICKS_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.GNEISS_LARGE_BRICKS_STAIRS.get()));
        lootTables.put(ECBlockRegistry.GNEISS_LARGE_BRICKS_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.GNEISS_LARGE_BRICKS_WALL.get()));
        lootTables.put(ECBlockRegistry.GNEISS_LARGE_BRICKS_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.GNEISS_LARGE_BRICKS_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.GNEISS_ORNAMENT.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.GNEISS_ORNAMENT.get()));
        lootTables.put(ECBlockRegistry.GNEISS_ORNAMENT_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.GNEISS_ORNAMENT_PRESSURE_PLATE.get()));

        // Jade
        lootTables.put(ECBlockRegistry.JADE.get(), createSilkTable(ECConstants.MODID, ECBlockRegistry.JADE.get(), ECBlockRegistry.JADE_COBBLESTONE.get()));
        lootTables.put(ECBlockRegistry.JADE_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.JADE_SLAB.get()));
        lootTables.put(ECBlockRegistry.JADE_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.JADE_STAIRS.get()));
        lootTables.put(ECBlockRegistry.JADE_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.JADE_WALL.get()));
        lootTables.put(ECBlockRegistry.JADE_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.JADE_PRESSURE_PLATE.get()));
        lootTables.put(ECBlockRegistry.JADE_BUTTON.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.JADE_BUTTON.get()));

        lootTables.put(ECBlockRegistry.JADE_COBBLESTONE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.JADE_COBBLESTONE.get()));
        lootTables.put(ECBlockRegistry.JADE_COBBLESTONE_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.JADE_COBBLESTONE_SLAB.get()));
        lootTables.put(ECBlockRegistry.JADE_COBBLESTONE_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.JADE_COBBLESTONE_STAIRS.get()));
        lootTables.put(ECBlockRegistry.JADE_COBBLESTONE_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.JADE_COBBLESTONE_WALL.get()));
        lootTables.put(ECBlockRegistry.JADE_COBBLESTONE_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.JADE_COBBLESTONE_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.SMOOTH_JADE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SMOOTH_JADE.get()));
        lootTables.put(ECBlockRegistry.SMOOTH_JADE_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.SMOOTH_JADE_SLAB.get()));
        lootTables.put(ECBlockRegistry.SMOOTH_JADE_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SMOOTH_JADE_STAIRS.get()));
        lootTables.put(ECBlockRegistry.SMOOTH_JADE_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SMOOTH_JADE_WALL.get()));
        lootTables.put(ECBlockRegistry.SMOOTH_JADE_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SMOOTH_JADE_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.POLISHED_JADE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.POLISHED_JADE.get()));
        lootTables.put(ECBlockRegistry.POLISHED_JADE_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.POLISHED_JADE_SLAB.get()));
        lootTables.put(ECBlockRegistry.POLISHED_JADE_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.POLISHED_JADE_STAIRS.get()));
        lootTables.put(ECBlockRegistry.POLISHED_JADE_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.POLISHED_JADE_WALL.get()));
        lootTables.put(ECBlockRegistry.POLISHED_JADE_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.POLISHED_JADE_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.JADE_PAVING.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.JADE_PAVING.get()));
        lootTables.put(ECBlockRegistry.JADE_PAVING_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.JADE_PAVING_SLAB.get()));
        lootTables.put(ECBlockRegistry.JADE_PAVING_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.JADE_PAVING_STAIRS.get()));
        lootTables.put(ECBlockRegistry.JADE_PAVING_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.JADE_PAVING_WALL.get()));
        lootTables.put(ECBlockRegistry.JADE_PAVING_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.JADE_PAVING_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.JADE_TILES.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.JADE_TILES.get()));
        lootTables.put(ECBlockRegistry.JADE_TILES_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.JADE_TILES_SLAB.get()));
        lootTables.put(ECBlockRegistry.JADE_TILES_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.JADE_TILES_STAIRS.get()));
        lootTables.put(ECBlockRegistry.JADE_TILES_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.JADE_TILES_WALL.get()));
        lootTables.put(ECBlockRegistry.JADE_TILES_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.JADE_TILES_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.JADE_BRICKS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.JADE_BRICKS.get()));
        lootTables.put(ECBlockRegistry.JADE_BRICKS_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.JADE_BRICKS_SLAB.get()));
        lootTables.put(ECBlockRegistry.JADE_BRICKS_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.JADE_BRICKS_STAIRS.get()));
        lootTables.put(ECBlockRegistry.JADE_BRICKS_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.JADE_BRICKS_WALL.get()));
        lootTables.put(ECBlockRegistry.JADE_BRICKS_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.JADE_BRICKS_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.JADE_LARGE_BRICKS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.JADE_LARGE_BRICKS.get()));
        lootTables.put(ECBlockRegistry.JADE_LARGE_BRICKS_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.JADE_LARGE_BRICKS_SLAB.get()));
        lootTables.put(ECBlockRegistry.JADE_LARGE_BRICKS_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.JADE_LARGE_BRICKS_STAIRS.get()));
        lootTables.put(ECBlockRegistry.JADE_LARGE_BRICKS_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.JADE_LARGE_BRICKS_WALL.get()));
        lootTables.put(ECBlockRegistry.JADE_LARGE_BRICKS_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.JADE_LARGE_BRICKS_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.JADE_ORNAMENT.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.JADE_ORNAMENT.get()));
        lootTables.put(ECBlockRegistry.JADE_ORNAMENT_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.JADE_ORNAMENT_PRESSURE_PLATE.get()));

        // Larvikite
        lootTables.put(ECBlockRegistry.LARVIKITE.get(), createSilkTable(ECConstants.MODID, ECBlockRegistry.LARVIKITE.get(), ECBlockRegistry.LARVIKITE_COBBLESTONE.get()));
        lootTables.put(ECBlockRegistry.LARVIKITE_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.LARVIKITE_SLAB.get()));
        lootTables.put(ECBlockRegistry.LARVIKITE_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.LARVIKITE_STAIRS.get()));
        lootTables.put(ECBlockRegistry.LARVIKITE_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.LARVIKITE_WALL.get()));
        lootTables.put(ECBlockRegistry.LARVIKITE_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.LARVIKITE_PRESSURE_PLATE.get()));
        lootTables.put(ECBlockRegistry.LARVIKITE_BUTTON.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.LARVIKITE_BUTTON.get()));

        lootTables.put(ECBlockRegistry.LARVIKITE_COBBLESTONE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.LARVIKITE_COBBLESTONE.get()));
        lootTables.put(ECBlockRegistry.LARVIKITE_COBBLESTONE_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.LARVIKITE_COBBLESTONE_SLAB.get()));
        lootTables.put(ECBlockRegistry.LARVIKITE_COBBLESTONE_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.LARVIKITE_COBBLESTONE_STAIRS.get()));
        lootTables.put(ECBlockRegistry.LARVIKITE_COBBLESTONE_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.LARVIKITE_COBBLESTONE_WALL.get()));
        lootTables.put(ECBlockRegistry.LARVIKITE_COBBLESTONE_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.LARVIKITE_COBBLESTONE_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.SMOOTH_LARVIKITE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SMOOTH_LARVIKITE.get()));
        lootTables.put(ECBlockRegistry.SMOOTH_LARVIKITE_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.SMOOTH_LARVIKITE_SLAB.get()));
        lootTables.put(ECBlockRegistry.SMOOTH_LARVIKITE_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SMOOTH_LARVIKITE_STAIRS.get()));
        lootTables.put(ECBlockRegistry.SMOOTH_LARVIKITE_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SMOOTH_LARVIKITE_WALL.get()));
        lootTables.put(ECBlockRegistry.SMOOTH_LARVIKITE_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SMOOTH_LARVIKITE_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.POLISHED_LARVIKITE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.POLISHED_LARVIKITE.get()));
        lootTables.put(ECBlockRegistry.POLISHED_LARVIKITE_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.POLISHED_LARVIKITE_SLAB.get()));
        lootTables.put(ECBlockRegistry.POLISHED_LARVIKITE_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.POLISHED_LARVIKITE_STAIRS.get()));
        lootTables.put(ECBlockRegistry.POLISHED_LARVIKITE_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.POLISHED_LARVIKITE_WALL.get()));
        lootTables.put(ECBlockRegistry.POLISHED_LARVIKITE_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.POLISHED_LARVIKITE_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.LARVIKITE_PAVING.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.LARVIKITE_PAVING.get()));
        lootTables.put(ECBlockRegistry.LARVIKITE_PAVING_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.LARVIKITE_PAVING_SLAB.get()));
        lootTables.put(ECBlockRegistry.LARVIKITE_PAVING_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.LARVIKITE_PAVING_STAIRS.get()));
        lootTables.put(ECBlockRegistry.LARVIKITE_PAVING_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.LARVIKITE_PAVING_WALL.get()));
        lootTables.put(ECBlockRegistry.LARVIKITE_PAVING_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.LARVIKITE_PAVING_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.LARVIKITE_TILES.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.LARVIKITE_TILES.get()));
        lootTables.put(ECBlockRegistry.LARVIKITE_TILES_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.LARVIKITE_TILES_SLAB.get()));
        lootTables.put(ECBlockRegistry.LARVIKITE_TILES_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.LARVIKITE_TILES_STAIRS.get()));
        lootTables.put(ECBlockRegistry.LARVIKITE_TILES_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.LARVIKITE_TILES_WALL.get()));
        lootTables.put(ECBlockRegistry.LARVIKITE_TILES_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.LARVIKITE_TILES_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.LARVIKITE_BRICKS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.LARVIKITE_BRICKS.get()));
        lootTables.put(ECBlockRegistry.LARVIKITE_BRICKS_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.LARVIKITE_BRICKS_SLAB.get()));
        lootTables.put(ECBlockRegistry.LARVIKITE_BRICKS_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.LARVIKITE_BRICKS_STAIRS.get()));
        lootTables.put(ECBlockRegistry.LARVIKITE_BRICKS_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.LARVIKITE_BRICKS_WALL.get()));
        lootTables.put(ECBlockRegistry.LARVIKITE_BRICKS_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.LARVIKITE_BRICKS_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.LARVIKITE_LARGE_BRICKS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.LARVIKITE_LARGE_BRICKS.get()));
        lootTables.put(ECBlockRegistry.LARVIKITE_LARGE_BRICKS_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.LARVIKITE_LARGE_BRICKS_SLAB.get()));
        lootTables.put(ECBlockRegistry.LARVIKITE_LARGE_BRICKS_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.LARVIKITE_LARGE_BRICKS_STAIRS.get()));
        lootTables.put(ECBlockRegistry.LARVIKITE_LARGE_BRICKS_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.LARVIKITE_LARGE_BRICKS_WALL.get()));
        lootTables.put(ECBlockRegistry.LARVIKITE_LARGE_BRICKS_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.LARVIKITE_LARGE_BRICKS_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.LARVIKITE_ORNAMENT.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.LARVIKITE_ORNAMENT.get()));
        lootTables.put(ECBlockRegistry.LARVIKITE_ORNAMENT_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.LARVIKITE_ORNAMENT_PRESSURE_PLATE.get()));

        // Andesite
        lootTables.put(ECBlockRegistry.SMOOTH_ANDESITE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SMOOTH_ANDESITE.get()));
        lootTables.put(ECBlockRegistry.SMOOTH_ANDESITE_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.SMOOTH_ANDESITE_SLAB.get()));
        lootTables.put(ECBlockRegistry.SMOOTH_ANDESITE_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SMOOTH_ANDESITE_STAIRS.get()));
        lootTables.put(ECBlockRegistry.SMOOTH_ANDESITE_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SMOOTH_ANDESITE_WALL.get()));
        lootTables.put(ECBlockRegistry.SMOOTH_ANDESITE_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SMOOTH_ANDESITE_PRESSURE_PLATE.get()));
        lootTables.put(ECBlockRegistry.ANDESITE_BUTTON.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.ANDESITE_BUTTON.get()));

        lootTables.put(ECBlockRegistry.ANDESITE_PAVING.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.ANDESITE_PAVING.get()));
        lootTables.put(ECBlockRegistry.ANDESITE_PAVING_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.ANDESITE_PAVING_SLAB.get()));
        lootTables.put(ECBlockRegistry.ANDESITE_PAVING_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.ANDESITE_PAVING_STAIRS.get()));
        lootTables.put(ECBlockRegistry.ANDESITE_PAVING_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.ANDESITE_PAVING_WALL.get()));
        lootTables.put(ECBlockRegistry.ANDESITE_PAVING_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.ANDESITE_PAVING_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.ANDESITE_TILES.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.ANDESITE_TILES.get()));
        lootTables.put(ECBlockRegistry.ANDESITE_TILES_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.ANDESITE_TILES_SLAB.get()));
        lootTables.put(ECBlockRegistry.ANDESITE_TILES_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.ANDESITE_TILES_STAIRS.get()));
        lootTables.put(ECBlockRegistry.ANDESITE_TILES_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.ANDESITE_TILES_WALL.get()));
        lootTables.put(ECBlockRegistry.ANDESITE_TILES_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.ANDESITE_TILES_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.ANDESITE_BRICKS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.ANDESITE_BRICKS.get()));
        lootTables.put(ECBlockRegistry.ANDESITE_BRICKS_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.ANDESITE_BRICKS_SLAB.get()));
        lootTables.put(ECBlockRegistry.ANDESITE_BRICKS_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.ANDESITE_BRICKS_STAIRS.get()));
        lootTables.put(ECBlockRegistry.ANDESITE_BRICKS_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.ANDESITE_BRICKS_WALL.get()));
        lootTables.put(ECBlockRegistry.ANDESITE_BRICKS_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.ANDESITE_BRICKS_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.ANDESITE_LARGE_BRICKS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.ANDESITE_LARGE_BRICKS.get()));
        lootTables.put(ECBlockRegistry.ANDESITE_LARGE_BRICKS_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.ANDESITE_LARGE_BRICKS_SLAB.get()));
        lootTables.put(ECBlockRegistry.ANDESITE_LARGE_BRICKS_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.ANDESITE_LARGE_BRICKS_STAIRS.get()));
        lootTables.put(ECBlockRegistry.ANDESITE_LARGE_BRICKS_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.ANDESITE_LARGE_BRICKS_WALL.get()));
        lootTables.put(ECBlockRegistry.ANDESITE_LARGE_BRICKS_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.ANDESITE_LARGE_BRICKS_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.ANDESITE_ORNAMENT.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.ANDESITE_ORNAMENT.get()));
        lootTables.put(ECBlockRegistry.ANDESITE_ORNAMENT_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.ANDESITE_ORNAMENT_PRESSURE_PLATE.get()));

        // Diorite
        lootTables.put(ECBlockRegistry.SMOOTH_DIORITE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SMOOTH_DIORITE.get()));
        lootTables.put(ECBlockRegistry.SMOOTH_DIORITE_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.SMOOTH_DIORITE_SLAB.get()));
        lootTables.put(ECBlockRegistry.SMOOTH_DIORITE_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SMOOTH_DIORITE_STAIRS.get()));
        lootTables.put(ECBlockRegistry.SMOOTH_DIORITE_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SMOOTH_DIORITE_WALL.get()));
        lootTables.put(ECBlockRegistry.SMOOTH_DIORITE_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SMOOTH_DIORITE_PRESSURE_PLATE.get()));
        lootTables.put(ECBlockRegistry.DIORITE_BUTTON.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.DIORITE_BUTTON.get()));

        lootTables.put(ECBlockRegistry.DIORITE_PAVING.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.DIORITE_PAVING.get()));
        lootTables.put(ECBlockRegistry.DIORITE_PAVING_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.DIORITE_PAVING_SLAB.get()));
        lootTables.put(ECBlockRegistry.DIORITE_PAVING_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.DIORITE_PAVING_STAIRS.get()));
        lootTables.put(ECBlockRegistry.DIORITE_PAVING_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.DIORITE_PAVING_WALL.get()));
        lootTables.put(ECBlockRegistry.DIORITE_PAVING_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.DIORITE_PAVING_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.DIORITE_TILES.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.DIORITE_TILES.get()));
        lootTables.put(ECBlockRegistry.DIORITE_TILES_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.DIORITE_TILES_SLAB.get()));
        lootTables.put(ECBlockRegistry.DIORITE_TILES_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.DIORITE_TILES_STAIRS.get()));
        lootTables.put(ECBlockRegistry.DIORITE_TILES_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.DIORITE_TILES_WALL.get()));
        lootTables.put(ECBlockRegistry.DIORITE_TILES_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.DIORITE_TILES_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.DIORITE_BRICKS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.DIORITE_BRICKS.get()));
        lootTables.put(ECBlockRegistry.DIORITE_BRICKS_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.DIORITE_BRICKS_SLAB.get()));
        lootTables.put(ECBlockRegistry.DIORITE_BRICKS_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.DIORITE_BRICKS_STAIRS.get()));
        lootTables.put(ECBlockRegistry.DIORITE_BRICKS_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.DIORITE_BRICKS_WALL.get()));
        lootTables.put(ECBlockRegistry.DIORITE_BRICKS_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.DIORITE_BRICKS_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.DIORITE_LARGE_BRICKS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.DIORITE_LARGE_BRICKS.get()));
        lootTables.put(ECBlockRegistry.DIORITE_LARGE_BRICKS_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.DIORITE_LARGE_BRICKS_SLAB.get()));
        lootTables.put(ECBlockRegistry.DIORITE_LARGE_BRICKS_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.DIORITE_LARGE_BRICKS_STAIRS.get()));
        lootTables.put(ECBlockRegistry.DIORITE_LARGE_BRICKS_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.DIORITE_LARGE_BRICKS_WALL.get()));
        lootTables.put(ECBlockRegistry.DIORITE_LARGE_BRICKS_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.DIORITE_LARGE_BRICKS_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.DIORITE_ORNAMENT.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.DIORITE_ORNAMENT.get()));
        lootTables.put(ECBlockRegistry.DIORITE_ORNAMENT_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.DIORITE_ORNAMENT_PRESSURE_PLATE.get()));

        // Granite
        lootTables.put(ECBlockRegistry.SMOOTH_GRANITE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SMOOTH_GRANITE.get()));
        lootTables.put(ECBlockRegistry.SMOOTH_GRANITE_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.SMOOTH_GRANITE_SLAB.get()));
        lootTables.put(ECBlockRegistry.SMOOTH_GRANITE_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SMOOTH_GRANITE_STAIRS.get()));
        lootTables.put(ECBlockRegistry.SMOOTH_GRANITE_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SMOOTH_GRANITE_WALL.get()));
        lootTables.put(ECBlockRegistry.SMOOTH_GRANITE_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SMOOTH_GRANITE_PRESSURE_PLATE.get()));
        lootTables.put(ECBlockRegistry.GRANITE_BUTTON.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.GRANITE_BUTTON.get()));

        lootTables.put(ECBlockRegistry.GRANITE_PAVING.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.GRANITE_PAVING.get()));
        lootTables.put(ECBlockRegistry.GRANITE_PAVING_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.GRANITE_PAVING_SLAB.get()));
        lootTables.put(ECBlockRegistry.GRANITE_PAVING_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.GRANITE_PAVING_STAIRS.get()));
        lootTables.put(ECBlockRegistry.GRANITE_PAVING_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.GRANITE_PAVING_WALL.get()));
        lootTables.put(ECBlockRegistry.GRANITE_PAVING_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.GRANITE_PAVING_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.GRANITE_TILES.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.GRANITE_TILES.get()));
        lootTables.put(ECBlockRegistry.GRANITE_TILES_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.GRANITE_TILES_SLAB.get()));
        lootTables.put(ECBlockRegistry.GRANITE_TILES_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.GRANITE_TILES_STAIRS.get()));
        lootTables.put(ECBlockRegistry.GRANITE_TILES_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.GRANITE_TILES_WALL.get()));
        lootTables.put(ECBlockRegistry.GRANITE_TILES_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.GRANITE_TILES_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.GRANITE_BRICKS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.GRANITE_BRICKS.get()));
        lootTables.put(ECBlockRegistry.GRANITE_BRICKS_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.GRANITE_BRICKS_SLAB.get()));
        lootTables.put(ECBlockRegistry.GRANITE_BRICKS_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.GRANITE_BRICKS_STAIRS.get()));
        lootTables.put(ECBlockRegistry.GRANITE_BRICKS_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.GRANITE_BRICKS_WALL.get()));
        lootTables.put(ECBlockRegistry.GRANITE_BRICKS_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.GRANITE_BRICKS_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.GRANITE_LARGE_BRICKS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.GRANITE_LARGE_BRICKS.get()));
        lootTables.put(ECBlockRegistry.GRANITE_LARGE_BRICKS_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.GRANITE_LARGE_BRICKS_SLAB.get()));
        lootTables.put(ECBlockRegistry.GRANITE_LARGE_BRICKS_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.GRANITE_LARGE_BRICKS_STAIRS.get()));
        lootTables.put(ECBlockRegistry.GRANITE_LARGE_BRICKS_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.GRANITE_LARGE_BRICKS_WALL.get()));
        lootTables.put(ECBlockRegistry.GRANITE_LARGE_BRICKS_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.GRANITE_LARGE_BRICKS_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.GRANITE_ORNAMENT.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.GRANITE_ORNAMENT.get()));
        lootTables.put(ECBlockRegistry.GRANITE_ORNAMENT_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.GRANITE_ORNAMENT_PRESSURE_PLATE.get()));

        // Sandstone
        lootTables.put(ECBlockRegistry.SANDSTONE_BUTTON.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SANDSTONE_BUTTON.get()));

        lootTables.put(ECBlockRegistry.SMOOTH_SANDSTONE_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SMOOTH_SANDSTONE_WALL.get()));
        lootTables.put(ECBlockRegistry.SMOOTH_SANDSTONE_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SMOOTH_SANDSTONE_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.POLISHED_SANDSTONE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.POLISHED_SANDSTONE.get()));
        lootTables.put(ECBlockRegistry.POLISHED_SANDSTONE_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.POLISHED_SANDSTONE_SLAB.get()));
        lootTables.put(ECBlockRegistry.POLISHED_SANDSTONE_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.POLISHED_SANDSTONE_STAIRS.get()));
        lootTables.put(ECBlockRegistry.POLISHED_SANDSTONE_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.POLISHED_SANDSTONE_WALL.get()));
        lootTables.put(ECBlockRegistry.POLISHED_SANDSTONE_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.POLISHED_SANDSTONE_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.SANDSTONE_PAVING.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SANDSTONE_PAVING.get()));
        lootTables.put(ECBlockRegistry.SANDSTONE_PAVING_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.SANDSTONE_PAVING_SLAB.get()));
        lootTables.put(ECBlockRegistry.SANDSTONE_PAVING_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SANDSTONE_PAVING_STAIRS.get()));
        lootTables.put(ECBlockRegistry.SANDSTONE_PAVING_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SANDSTONE_PAVING_WALL.get()));
        lootTables.put(ECBlockRegistry.SANDSTONE_PAVING_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SANDSTONE_PAVING_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.SANDSTONE_TILES.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SANDSTONE_TILES.get()));
        lootTables.put(ECBlockRegistry.SANDSTONE_TILES_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.SANDSTONE_TILES_SLAB.get()));
        lootTables.put(ECBlockRegistry.SANDSTONE_TILES_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SANDSTONE_TILES_STAIRS.get()));
        lootTables.put(ECBlockRegistry.SANDSTONE_TILES_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SANDSTONE_TILES_WALL.get()));
        lootTables.put(ECBlockRegistry.SANDSTONE_TILES_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SANDSTONE_TILES_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.SANDSTONE_BRICKS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SANDSTONE_BRICKS.get()));
        lootTables.put(ECBlockRegistry.SANDSTONE_BRICKS_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.SANDSTONE_BRICKS_SLAB.get()));
        lootTables.put(ECBlockRegistry.SANDSTONE_BRICKS_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SANDSTONE_BRICKS_STAIRS.get()));
        lootTables.put(ECBlockRegistry.SANDSTONE_BRICKS_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SANDSTONE_BRICKS_WALL.get()));
        lootTables.put(ECBlockRegistry.SANDSTONE_BRICKS_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SANDSTONE_BRICKS_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.SANDSTONE_LARGE_BRICKS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SANDSTONE_LARGE_BRICKS.get()));
        lootTables.put(ECBlockRegistry.SANDSTONE_LARGE_BRICKS_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.SANDSTONE_LARGE_BRICKS_SLAB.get()));
        lootTables.put(ECBlockRegistry.SANDSTONE_LARGE_BRICKS_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SANDSTONE_LARGE_BRICKS_STAIRS.get()));
        lootTables.put(ECBlockRegistry.SANDSTONE_LARGE_BRICKS_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SANDSTONE_LARGE_BRICKS_WALL.get()));
        lootTables.put(ECBlockRegistry.SANDSTONE_LARGE_BRICKS_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SANDSTONE_LARGE_BRICKS_PRESSURE_PLATE.get()));

        // Red Sandstone
        lootTables.put(ECBlockRegistry.RED_SANDSTONE_BUTTON.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.RED_SANDSTONE_BUTTON.get()));

        lootTables.put(ECBlockRegistry.SMOOTH_RED_SANDSTONE_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SMOOTH_RED_SANDSTONE_WALL.get()));
        lootTables.put(ECBlockRegistry.SMOOTH_RED_SANDSTONE_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SMOOTH_RED_SANDSTONE_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.POLISHED_RED_SANDSTONE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.POLISHED_RED_SANDSTONE.get()));
        lootTables.put(ECBlockRegistry.POLISHED_RED_SANDSTONE_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.POLISHED_RED_SANDSTONE_SLAB.get()));
        lootTables.put(ECBlockRegistry.POLISHED_RED_SANDSTONE_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.POLISHED_RED_SANDSTONE_STAIRS.get()));
        lootTables.put(ECBlockRegistry.POLISHED_RED_SANDSTONE_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.POLISHED_RED_SANDSTONE_WALL.get()));
        lootTables.put(ECBlockRegistry.POLISHED_RED_SANDSTONE_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.POLISHED_RED_SANDSTONE_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.RED_SANDSTONE_PAVING.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.RED_SANDSTONE_PAVING.get()));
        lootTables.put(ECBlockRegistry.RED_SANDSTONE_PAVING_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.RED_SANDSTONE_PAVING_SLAB.get()));
        lootTables.put(ECBlockRegistry.RED_SANDSTONE_PAVING_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.RED_SANDSTONE_PAVING_STAIRS.get()));
        lootTables.put(ECBlockRegistry.RED_SANDSTONE_PAVING_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.RED_SANDSTONE_PAVING_WALL.get()));
        lootTables.put(ECBlockRegistry.RED_SANDSTONE_PAVING_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.RED_SANDSTONE_PAVING_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.RED_SANDSTONE_TILES.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.RED_SANDSTONE_TILES.get()));
        lootTables.put(ECBlockRegistry.RED_SANDSTONE_TILES_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.RED_SANDSTONE_TILES_SLAB.get()));
        lootTables.put(ECBlockRegistry.RED_SANDSTONE_TILES_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.RED_SANDSTONE_TILES_STAIRS.get()));
        lootTables.put(ECBlockRegistry.RED_SANDSTONE_TILES_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.RED_SANDSTONE_TILES_WALL.get()));
        lootTables.put(ECBlockRegistry.RED_SANDSTONE_TILES_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.RED_SANDSTONE_TILES_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.RED_SANDSTONE_BRICKS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.RED_SANDSTONE_BRICKS.get()));
        lootTables.put(ECBlockRegistry.RED_SANDSTONE_BRICKS_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.RED_SANDSTONE_BRICKS_SLAB.get()));
        lootTables.put(ECBlockRegistry.RED_SANDSTONE_BRICKS_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.RED_SANDSTONE_BRICKS_STAIRS.get()));
        lootTables.put(ECBlockRegistry.RED_SANDSTONE_BRICKS_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.RED_SANDSTONE_BRICKS_WALL.get()));
        lootTables.put(ECBlockRegistry.RED_SANDSTONE_BRICKS_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.RED_SANDSTONE_BRICKS_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.RED_SANDSTONE_LARGE_BRICKS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.RED_SANDSTONE_LARGE_BRICKS.get()));
        lootTables.put(ECBlockRegistry.RED_SANDSTONE_LARGE_BRICKS_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.RED_SANDSTONE_LARGE_BRICKS_SLAB.get()));
        lootTables.put(ECBlockRegistry.RED_SANDSTONE_LARGE_BRICKS_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.RED_SANDSTONE_LARGE_BRICKS_STAIRS.get()));
        lootTables.put(ECBlockRegistry.RED_SANDSTONE_LARGE_BRICKS_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.RED_SANDSTONE_LARGE_BRICKS_WALL.get()));
        lootTables.put(ECBlockRegistry.RED_SANDSTONE_LARGE_BRICKS_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.RED_SANDSTONE_LARGE_BRICKS_PRESSURE_PLATE.get()));

        // Terracotta
        lootTables.put(ECBlockRegistry.TERRACOTTA_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.TERRACOTTA_SLAB.get()));
        lootTables.put(ECBlockRegistry.TERRACOTTA_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.TERRACOTTA_STAIRS.get()));
        lootTables.put(ECBlockRegistry.TERRACOTTA_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.TERRACOTTA_WALL.get()));
        lootTables.put(ECBlockRegistry.TERRACOTTA_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.TERRACOTTA_PRESSURE_PLATE.get()));
        lootTables.put(ECBlockRegistry.TERRACOTTA_BUTTON.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.TERRACOTTA_BUTTON.get()));

        lootTables.put(ECBlockRegistry.POLISHED_TERRACOTTA.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.POLISHED_TERRACOTTA.get()));
        lootTables.put(ECBlockRegistry.POLISHED_TERRACOTTA_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.POLISHED_TERRACOTTA_SLAB.get()));
        lootTables.put(ECBlockRegistry.POLISHED_TERRACOTTA_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.POLISHED_TERRACOTTA_STAIRS.get()));
        lootTables.put(ECBlockRegistry.POLISHED_TERRACOTTA_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.POLISHED_TERRACOTTA_WALL.get()));
        lootTables.put(ECBlockRegistry.POLISHED_TERRACOTTA_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.POLISHED_TERRACOTTA_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.TERRACOTTA_PAVING.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.TERRACOTTA_PAVING.get()));
        lootTables.put(ECBlockRegistry.TERRACOTTA_PAVING_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.TERRACOTTA_PAVING_SLAB.get()));
        lootTables.put(ECBlockRegistry.TERRACOTTA_PAVING_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.TERRACOTTA_PAVING_STAIRS.get()));
        lootTables.put(ECBlockRegistry.TERRACOTTA_PAVING_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.TERRACOTTA_PAVING_WALL.get()));
        lootTables.put(ECBlockRegistry.TERRACOTTA_PAVING_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.TERRACOTTA_PAVING_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.TERRACOTTA_TILES.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.TERRACOTTA_TILES.get()));
        lootTables.put(ECBlockRegistry.TERRACOTTA_TILES_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.TERRACOTTA_TILES_SLAB.get()));
        lootTables.put(ECBlockRegistry.TERRACOTTA_TILES_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.TERRACOTTA_TILES_STAIRS.get()));
        lootTables.put(ECBlockRegistry.TERRACOTTA_TILES_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.TERRACOTTA_TILES_WALL.get()));
        lootTables.put(ECBlockRegistry.TERRACOTTA_TILES_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.TERRACOTTA_TILES_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.TERRACOTTA_BRICKS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.TERRACOTTA_BRICKS.get()));
        lootTables.put(ECBlockRegistry.TERRACOTTA_BRICKS_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.TERRACOTTA_BRICKS_SLAB.get()));
        lootTables.put(ECBlockRegistry.TERRACOTTA_BRICKS_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.TERRACOTTA_BRICKS_STAIRS.get()));
        lootTables.put(ECBlockRegistry.TERRACOTTA_BRICKS_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.TERRACOTTA_BRICKS_WALL.get()));
        lootTables.put(ECBlockRegistry.TERRACOTTA_BRICKS_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.TERRACOTTA_BRICKS_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.TERRACOTTA_LARGE_BRICKS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.TERRACOTTA_LARGE_BRICKS.get()));
        lootTables.put(ECBlockRegistry.TERRACOTTA_LARGE_BRICKS_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.TERRACOTTA_LARGE_BRICKS_SLAB.get()));
        lootTables.put(ECBlockRegistry.TERRACOTTA_LARGE_BRICKS_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.TERRACOTTA_LARGE_BRICKS_STAIRS.get()));
        lootTables.put(ECBlockRegistry.TERRACOTTA_LARGE_BRICKS_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.TERRACOTTA_LARGE_BRICKS_WALL.get()));
        lootTables.put(ECBlockRegistry.TERRACOTTA_LARGE_BRICKS_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.TERRACOTTA_LARGE_BRICKS_PRESSURE_PLATE.get()));

        // Other bricks
        lootTables.put(ECBlockRegistry.DARK_BRICKS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.DARK_BRICKS.get()));
        lootTables.put(ECBlockRegistry.DARK_BRICKS_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.DARK_BRICKS_SLAB.get()));
        lootTables.put(ECBlockRegistry.DARK_BRICKS_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.DARK_BRICKS_STAIRS.get()));
        lootTables.put(ECBlockRegistry.DARK_BRICKS_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.DARK_BRICKS_WALL.get()));
        lootTables.put(ECBlockRegistry.DARK_BRICKS_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.DARK_BRICKS_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.DARK_LARGE_BRICKS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.DARK_LARGE_BRICKS.get()));
        lootTables.put(ECBlockRegistry.DARK_LARGE_BRICKS_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.DARK_LARGE_BRICKS_SLAB.get()));
        lootTables.put(ECBlockRegistry.DARK_LARGE_BRICKS_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.DARK_LARGE_BRICKS_STAIRS.get()));
        lootTables.put(ECBlockRegistry.DARK_LARGE_BRICKS_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.DARK_LARGE_BRICKS_WALL.get()));
        lootTables.put(ECBlockRegistry.DARK_LARGE_BRICKS_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.DARK_LARGE_BRICKS_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.OLD_BRICKS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.OLD_BRICKS.get()));
        lootTables.put(ECBlockRegistry.OLD_BRICKS_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.OLD_BRICKS_SLAB.get()));
        lootTables.put(ECBlockRegistry.OLD_BRICKS_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.OLD_BRICKS_STAIRS.get()));
        lootTables.put(ECBlockRegistry.OLD_BRICKS_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.OLD_BRICKS_WALL.get()));
        lootTables.put(ECBlockRegistry.OLD_BRICKS_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.OLD_BRICKS_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.OLD_LARGE_BRICKS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.OLD_LARGE_BRICKS.get()));
        lootTables.put(ECBlockRegistry.OLD_LARGE_BRICKS_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.OLD_LARGE_BRICKS_SLAB.get()));
        lootTables.put(ECBlockRegistry.OLD_LARGE_BRICKS_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.OLD_LARGE_BRICKS_STAIRS.get()));
        lootTables.put(ECBlockRegistry.OLD_LARGE_BRICKS_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.OLD_LARGE_BRICKS_WALL.get()));
        lootTables.put(ECBlockRegistry.OLD_LARGE_BRICKS_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.OLD_LARGE_BRICKS_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.WEARED_BRICKS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.WEARED_BRICKS.get()));
        lootTables.put(ECBlockRegistry.WEARED_BRICKS_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.WEARED_BRICKS_SLAB.get()));
        lootTables.put(ECBlockRegistry.WEARED_BRICKS_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.WEARED_BRICKS_STAIRS.get()));
        lootTables.put(ECBlockRegistry.WEARED_BRICKS_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.WEARED_BRICKS_WALL.get()));
        lootTables.put(ECBlockRegistry.WEARED_BRICKS_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.WEARED_BRICKS_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.WEARED_LARGE_BRICKS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.WEARED_LARGE_BRICKS.get()));
        lootTables.put(ECBlockRegistry.WEARED_LARGE_BRICKS_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.WEARED_LARGE_BRICKS_SLAB.get()));
        lootTables.put(ECBlockRegistry.WEARED_LARGE_BRICKS_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.WEARED_LARGE_BRICKS_STAIRS.get()));
        lootTables.put(ECBlockRegistry.WEARED_LARGE_BRICKS_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.WEARED_LARGE_BRICKS_WALL.get()));
        lootTables.put(ECBlockRegistry.WEARED_LARGE_BRICKS_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.WEARED_LARGE_BRICKS_PRESSURE_PLATE.get()));

        // Pavings
        lootTables.put(ECBlockRegistry.CONCRETE_PAVING.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.CONCRETE_PAVING.get()));
        lootTables.put(ECBlockRegistry.CONCRETE_PAVING_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.CONCRETE_PAVING_SLAB.get()));
        lootTables.put(ECBlockRegistry.CONCRETE_PAVING_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.CONCRETE_PAVING_STAIRS.get()));
        lootTables.put(ECBlockRegistry.CONCRETE_PAVING_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.CONCRETE_PAVING_WALL.get()));
        lootTables.put(ECBlockRegistry.CONCRETE_PAVING_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.CONCRETE_PAVING_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.DAMAGED_PAVING.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.DAMAGED_PAVING.get()));
        lootTables.put(ECBlockRegistry.DAMAGED_PAVING_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.DAMAGED_PAVING_SLAB.get()));
        lootTables.put(ECBlockRegistry.DAMAGED_PAVING_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.DAMAGED_PAVING_STAIRS.get()));
        lootTables.put(ECBlockRegistry.DAMAGED_PAVING_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.DAMAGED_PAVING_WALL.get()));
        lootTables.put(ECBlockRegistry.DAMAGED_PAVING_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.DAMAGED_PAVING_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.DARK_CONCRETE_PAVING.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.DARK_CONCRETE_PAVING.get()));
        lootTables.put(ECBlockRegistry.DARK_CONCRETE_PAVING_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.DARK_CONCRETE_PAVING_SLAB.get()));
        lootTables.put(ECBlockRegistry.DARK_CONCRETE_PAVING_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.DARK_CONCRETE_PAVING_STAIRS.get()));
        lootTables.put(ECBlockRegistry.DARK_CONCRETE_PAVING_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.DARK_CONCRETE_PAVING_WALL.get()));
        lootTables.put(ECBlockRegistry.DARK_CONCRETE_PAVING_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.DARK_CONCRETE_PAVING_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.MOIST_PAVING.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.MOIST_PAVING.get()));
        lootTables.put(ECBlockRegistry.MOIST_PAVING_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.MOIST_PAVING_SLAB.get()));
        lootTables.put(ECBlockRegistry.MOIST_PAVING_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.MOIST_PAVING_STAIRS.get()));
        lootTables.put(ECBlockRegistry.MOIST_PAVING_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.MOIST_PAVING_WALL.get()));
        lootTables.put(ECBlockRegistry.MOIST_PAVING_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.MOIST_PAVING_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.POLISHED_PAVING.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.POLISHED_PAVING.get()));
        lootTables.put(ECBlockRegistry.POLISHED_PAVING_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.POLISHED_PAVING_SLAB.get()));
        lootTables.put(ECBlockRegistry.POLISHED_PAVING_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.POLISHED_PAVING_STAIRS.get()));
        lootTables.put(ECBlockRegistry.POLISHED_PAVING_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.POLISHED_PAVING_WALL.get()));
        lootTables.put(ECBlockRegistry.POLISHED_PAVING_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.POLISHED_PAVING_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.WHITE_CONCRETE_PAVING.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.WHITE_CONCRETE_PAVING.get()));
        lootTables.put(ECBlockRegistry.WHITE_CONCRETE_PAVING_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.WHITE_CONCRETE_PAVING_SLAB.get()));
        lootTables.put(ECBlockRegistry.WHITE_CONCRETE_PAVING_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.WHITE_CONCRETE_PAVING_STAIRS.get()));
        lootTables.put(ECBlockRegistry.WHITE_CONCRETE_PAVING_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.WHITE_CONCRETE_PAVING_WALL.get()));
        lootTables.put(ECBlockRegistry.WHITE_CONCRETE_PAVING_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.WHITE_CONCRETE_PAVING_PRESSURE_PLATE.get()));

        // Tiles
        lootTables.put(ECBlockRegistry.CONCRETE_TILES.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.CONCRETE_TILES.get()));
        lootTables.put(ECBlockRegistry.CONCRETE_TILES_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.CONCRETE_TILES_SLAB.get()));
        lootTables.put(ECBlockRegistry.CONCRETE_TILES_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.CONCRETE_TILES_STAIRS.get()));
        lootTables.put(ECBlockRegistry.CONCRETE_TILES_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.CONCRETE_TILES_WALL.get()));
        lootTables.put(ECBlockRegistry.CONCRETE_TILES_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.CONCRETE_TILES_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.SKYBLUE_TILES.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SKYBLUE_TILES.get()));
        lootTables.put(ECBlockRegistry.SKYBLUE_TILES_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.SKYBLUE_TILES_SLAB.get()));
        lootTables.put(ECBlockRegistry.SKYBLUE_TILES_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SKYBLUE_TILES_STAIRS.get()));
        lootTables.put(ECBlockRegistry.SKYBLUE_TILES_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SKYBLUE_TILES_WALL.get()));
        lootTables.put(ECBlockRegistry.SKYBLUE_TILES_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.SKYBLUE_TILES_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.ORANGE_TILES.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.ORANGE_TILES.get()));
        lootTables.put(ECBlockRegistry.ORANGE_TILES_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.ORANGE_TILES_SLAB.get()));
        lootTables.put(ECBlockRegistry.ORANGE_TILES_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.ORANGE_TILES_STAIRS.get()));
        lootTables.put(ECBlockRegistry.ORANGE_TILES_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.ORANGE_TILES_WALL.get()));
        lootTables.put(ECBlockRegistry.ORANGE_TILES_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.ORANGE_TILES_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.BLUE_TILES.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.BLUE_TILES.get()));
        lootTables.put(ECBlockRegistry.BLUE_TILES_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.BLUE_TILES_SLAB.get()));
        lootTables.put(ECBlockRegistry.BLUE_TILES_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.BLUE_TILES_STAIRS.get()));
        lootTables.put(ECBlockRegistry.BLUE_TILES_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.BLUE_TILES_WALL.get()));
        lootTables.put(ECBlockRegistry.BLUE_TILES_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.BLUE_TILES_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.LIGHT_BLUE_TILES.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.LIGHT_BLUE_TILES.get()));
        lootTables.put(ECBlockRegistry.LIGHT_BLUE_TILES_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.LIGHT_BLUE_TILES_SLAB.get()));
        lootTables.put(ECBlockRegistry.LIGHT_BLUE_TILES_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.LIGHT_BLUE_TILES_STAIRS.get()));
        lootTables.put(ECBlockRegistry.LIGHT_BLUE_TILES_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.LIGHT_BLUE_TILES_WALL.get()));
        lootTables.put(ECBlockRegistry.LIGHT_BLUE_TILES_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.LIGHT_BLUE_TILES_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.RED_TILES.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.RED_TILES.get()));
        lootTables.put(ECBlockRegistry.RED_TILES_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.RED_TILES_SLAB.get()));
        lootTables.put(ECBlockRegistry.RED_TILES_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.RED_TILES_STAIRS.get()));
        lootTables.put(ECBlockRegistry.RED_TILES_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.RED_TILES_WALL.get()));
        lootTables.put(ECBlockRegistry.RED_TILES_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.RED_TILES_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.WHITE_TILES.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.WHITE_TILES.get()));
        lootTables.put(ECBlockRegistry.WHITE_TILES_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.WHITE_TILES_SLAB.get()));
        lootTables.put(ECBlockRegistry.WHITE_TILES_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.WHITE_TILES_STAIRS.get()));
        lootTables.put(ECBlockRegistry.WHITE_TILES_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.WHITE_TILES_WALL.get()));
        lootTables.put(ECBlockRegistry.WHITE_TILES_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.WHITE_TILES_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.YELLOW_TILES.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.YELLOW_TILES.get()));
        lootTables.put(ECBlockRegistry.YELLOW_TILES_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.YELLOW_TILES_SLAB.get()));
        lootTables.put(ECBlockRegistry.YELLOW_TILES_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.YELLOW_TILES_STAIRS.get()));
        lootTables.put(ECBlockRegistry.YELLOW_TILES_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.YELLOW_TILES_WALL.get()));
        lootTables.put(ECBlockRegistry.YELLOW_TILES_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.YELLOW_TILES_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.YELLOW_GREY_TILES.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.YELLOW_GREY_TILES.get()));
        lootTables.put(ECBlockRegistry.YELLOW_GREY_TILES_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.YELLOW_GREY_TILES_SLAB.get()));
        lootTables.put(ECBlockRegistry.YELLOW_GREY_TILES_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.YELLOW_GREY_TILES_STAIRS.get()));
        lootTables.put(ECBlockRegistry.YELLOW_GREY_TILES_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.YELLOW_GREY_TILES_WALL.get()));
        lootTables.put(ECBlockRegistry.YELLOW_GREY_TILES_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.YELLOW_GREY_TILES_PRESSURE_PLATE.get()));

        // Corrugated metal plates
        for(int j = 0; j < Arrays.stream(DyeColor.values()).count(); j++)
        {
            lootTables.put(ECBlockRegistry.CORRUGATED_METAL_PLATE_BLOCKS.get(DyeColor.byId(j)).get(),
                createStandardTable(ECConstants.MODID, ECBlockRegistry.CORRUGATED_METAL_PLATE_BLOCKS.get(DyeColor.byId(j)).get()));
            lootTables.put(ECBlockRegistry.CORRUGATED_METAL_PLATE_STAIRS.get(DyeColor.byId(j)).get(),
                createStandardTable(ECConstants.MODID, ECBlockRegistry.CORRUGATED_METAL_PLATE_STAIRS.get(DyeColor.byId(j)).get()));
            lootTables.put(ECBlockRegistry.CORRUGATED_METAL_PLATE_SLABS.get(DyeColor.byId(j)).get(),
                createSlabTable(ECConstants.MODID, ECBlockRegistry.CORRUGATED_METAL_PLATE_SLABS.get(DyeColor.byId(j)).get()));
            lootTables.put(ECBlockRegistry.CORRUGATED_METAL_PLATE_WALLS.get(DyeColor.byId(j)).get(),
                createStandardTable(ECConstants.MODID, ECBlockRegistry.CORRUGATED_METAL_PLATE_WALLS.get(DyeColor.byId(j)).get()));
            lootTables.put(ECBlockRegistry.CORRUGATED_METAL_PLATE_PRESSURE_PLATES.get(DyeColor.byId(j)).get(),
                createStandardTable(ECConstants.MODID, ECBlockRegistry.CORRUGATED_METAL_PLATE_PRESSURE_PLATES.get(DyeColor.byId(j)).get()));
        }

        // Metal blocks
        lootTables.put(ECBlockRegistry.DARK_METAL_FLOOR.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.DARK_METAL_FLOOR.get()));
        lootTables.put(ECBlockRegistry.DARK_METAL_FLOOR_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.DARK_METAL_FLOOR_SLAB.get()));
        lootTables.put(ECBlockRegistry.DARK_METAL_FLOOR_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.DARK_METAL_FLOOR_STAIRS.get()));
        lootTables.put(ECBlockRegistry.DARK_METAL_FLOOR_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.DARK_METAL_FLOOR_WALL.get()));
        lootTables.put(ECBlockRegistry.DARK_METAL_FLOOR_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.DARK_METAL_FLOOR_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.LIGHT_METAL_FLOOR.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.LIGHT_METAL_FLOOR.get()));
        lootTables.put(ECBlockRegistry.LIGHT_METAL_FLOOR_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.LIGHT_METAL_FLOOR_SLAB.get()));
        lootTables.put(ECBlockRegistry.LIGHT_METAL_FLOOR_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.LIGHT_METAL_FLOOR_STAIRS.get()));
        lootTables.put(ECBlockRegistry.LIGHT_METAL_FLOOR_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.LIGHT_METAL_FLOOR_WALL.get()));
        lootTables.put(ECBlockRegistry.LIGHT_METAL_FLOOR_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.LIGHT_METAL_FLOOR_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.RUSTY_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.RUSTY_PLATE.get()));
        lootTables.put(ECBlockRegistry.RUSTY_PLATE_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.RUSTY_PLATE_SLAB.get()));
        lootTables.put(ECBlockRegistry.RUSTY_PLATE_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.RUSTY_PLATE_STAIRS.get()));
        lootTables.put(ECBlockRegistry.RUSTY_PLATE_WALL.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.RUSTY_PLATE_WALL.get()));
        lootTables.put(ECBlockRegistry.RUSTY_PLATE_PRESSURE_PLATE.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.RUSTY_PLATE_PRESSURE_PLATE.get()));

        lootTables.put(ECBlockRegistry.IRON_BEAM.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.IRON_BEAM.get()));
        lootTables.put(ECBlockRegistry.BOLTED_IRON_BEAM.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.BOLTED_IRON_BEAM.get()));
        lootTables.put(ECBlockRegistry.IRON_BEAM_JUNCTION.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.IRON_BEAM_JUNCTION.get()));
        lootTables.put(ECBlockRegistry.STEEL_BEAM.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.STEEL_BEAM.get()));
        lootTables.put(ECBlockRegistry.BOLTED_STEEL_BEAM.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.BOLTED_STEEL_BEAM.get()));
        lootTables.put(ECBlockRegistry.STEEL_BEAM_JUNCTION.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.STEEL_BEAM_JUNCTION.get()));

        lootTables.put(ECBlockRegistry.AIR_DUCT.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.AIR_DUCT.get()));
        lootTables.put(ECBlockRegistry.VENT_AIR_DUCT.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.VENT_AIR_DUCT.get()));
        lootTables.put(ECBlockRegistry.GRID_AIR_DUCT.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.GRID_AIR_DUCT.get()));

        lootTables.put(ECBlockRegistry.BULKHEAD.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.BULKHEAD.get()));
        lootTables.put(ECBlockRegistry.BULKHEAD_TOP.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.BULKHEAD_TOP.get()));

        lootTables.put(ECBlockRegistry.STEEL_WALL_LADDER.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.STEEL_WALL_LADDER.get()));
        lootTables.put(ECBlockRegistry.RUSTY_WALL_LADDER.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.RUSTY_WALL_LADDER.get()));
        lootTables.put(ECBlockRegistry.STEEL_RUNGS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.STEEL_RUNGS.get()));
        lootTables.put(ECBlockRegistry.RUSTY_RUNGS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.RUSTY_RUNGS.get()));

        // Wallpapers
        lootTables.put(ECBlockRegistry.WHITE_BLUE_WALLPAPER.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.WHITE_BLUE_WALLPAPER.get()));
        lootTables.put(ECBlockRegistry.WHITE_BLUE_WALLPAPER_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.WHITE_BLUE_WALLPAPER_SLAB.get()));
        lootTables.put(ECBlockRegistry.WHITE_BLUE_WALLPAPER_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.WHITE_BLUE_WALLPAPER_STAIRS.get()));
        lootTables.put(ECBlockRegistry.WHITE_BLUE_WALLPAPER_PLINTH.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.WHITE_BLUE_WALLPAPER_PLINTH.get()));

        lootTables.put(ECBlockRegistry.BEIGE_FLOWER_WALLPAPER.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.BEIGE_FLOWER_WALLPAPER.get()));
        lootTables.put(ECBlockRegistry.BEIGE_FLOWER_WALLPAPER_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.BEIGE_FLOWER_WALLPAPER_SLAB.get()));
        lootTables.put(ECBlockRegistry.BEIGE_FLOWER_WALLPAPER_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.BEIGE_FLOWER_WALLPAPER_STAIRS.get()));
        lootTables.put(ECBlockRegistry.BEIGE_FLOWER_WALLPAPER_PLINTH.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.BEIGE_FLOWER_WALLPAPER_PLINTH.get()));

        lootTables.put(ECBlockRegistry.BEIGE_WALLPAPER.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.BEIGE_WALLPAPER.get()));
        lootTables.put(ECBlockRegistry.BEIGE_WALLPAPER_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.BEIGE_WALLPAPER_SLAB.get()));
        lootTables.put(ECBlockRegistry.BEIGE_WALLPAPER_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.BEIGE_WALLPAPER_STAIRS.get()));
        lootTables.put(ECBlockRegistry.BEIGE_WALLPAPER_PLINTH.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.BEIGE_WALLPAPER_PLINTH.get()));

        lootTables.put(ECBlockRegistry.PINK_WALLPAPER.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.PINK_WALLPAPER.get()));
        lootTables.put(ECBlockRegistry.PINK_WALLPAPER_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.PINK_WALLPAPER_SLAB.get()));
        lootTables.put(ECBlockRegistry.PINK_WALLPAPER_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.PINK_WALLPAPER_STAIRS.get()));
        lootTables.put(ECBlockRegistry.PINK_WALLPAPER_PLINTH.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.PINK_WALLPAPER_PLINTH.get()));

        lootTables.put(ECBlockRegistry.WHITE_GREEN_WALLPAPER.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.WHITE_GREEN_WALLPAPER.get()));
        lootTables.put(ECBlockRegistry.WHITE_GREEN_WALLPAPER_SLAB.get(), createSlabTable(ECConstants.MODID, ECBlockRegistry.WHITE_GREEN_WALLPAPER_SLAB.get()));
        lootTables.put(ECBlockRegistry.WHITE_GREEN_WALLPAPER_STAIRS.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.WHITE_GREEN_WALLPAPER_STAIRS.get()));
        lootTables.put(ECBlockRegistry.WHITE_GREEN_WALLPAPER_PLINTH.get(), createStandardTable(ECConstants.MODID, ECBlockRegistry.WHITE_GREEN_WALLPAPER_PLINTH.get()));
    }
}
