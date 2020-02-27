package tv.mapper.embellishcraft.data.gen;

import java.util.Arrays;
import java.util.function.Function;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.DyeColor;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ExistingFileHelper;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.ModelFile.UncheckedModelFile;
import net.minecraftforge.client.model.generators.MultiPartBlockStateBuilder;
import tv.mapper.embellishcraft.ECConstants;
import tv.mapper.embellishcraft.block.ECBlockRegistry;
import tv.mapper.embellishcraft.block.TableBlock;
import tv.mapper.embellishcraft.util.RockType;
import tv.mapper.mapperbase.data.gen.BaseBlockStates;

public class ECBlockStates extends BaseBlockStates
{
    public ECBlockStates(DataGenerator gen, ExistingFileHelper exFileHelper)
    {
        super(gen, ECConstants.MODID, exFileHelper);
    }

    private void registerStoneVariant(String name, Block block, SlabBlock slab, StairsBlock stairs, WallBlock wall, Block pressure, Block button)
    {
        if(block != null)
            simpleBlock(block);
        if(slab != null)
            slabBlock(slab, modLoc("block/" + name), modLoc("block/" + name));
        if(stairs != null)
            stairsBlock(stairs, modLoc("block/" + name));
        if(wall != null)
            wallBlock(wall, modLoc("block/" + name));
        if(pressure != null)
            pressurePlateBlock(pressure, new UncheckedModelFile(ECConstants.MODID + ":block/" + name + "_pressure_plate"), new UncheckedModelFile(ECConstants.MODID + ":block/" + name + "_pressure_plate_down"));
        if(button != null)
            buttonBlock(button, new UncheckedModelFile(ECConstants.MODID + ":block/" + name + "_button"), new UncheckedModelFile(ECConstants.MODID + ":block/" + name + "_button_pressed"), 180);
    }

    @Override
    protected void registerStatesAndModels()
    {
        // Rocks
        for(int j = 0; j < Arrays.stream(RockType.values()).count(); j++)
        {
            registerStoneVariant(RockType.byId(j).getName(), ECBlockRegistry.ROCK_BLOCKS.get(RockType.byId(j)).get(), ECBlockRegistry.ROCK_SLABS.get(RockType.byId(j)).get(),
                ECBlockRegistry.ROCK_STAIRS.get(RockType.byId(j)).get(), ECBlockRegistry.ROCK_WALLS.get(RockType.byId(j)).get(), ECBlockRegistry.ROCK_PRESSURE_PLATES.get(RockType.byId(j)).get(), null);

            registerStoneVariant(RockType.byId(j).getName(), ECBlockRegistry.ROCK_COBBLESTONES.get(RockType.byId(j)).get(), ECBlockRegistry.ROCK_COBBLESTONE_SLABS.get(RockType.byId(j)).get(),
                ECBlockRegistry.ROCK_COBBLESTONE_STAIRS.get(RockType.byId(j)).get(), ECBlockRegistry.ROCK_COBBLESTONE_WALLS.get(RockType.byId(j)).get(),
                ECBlockRegistry.ROCK_COBBLESTONE_PRESSURE_PLATES.get(RockType.byId(j)).get(), null);

            registerStoneVariant(RockType.byId(j).getName(), ECBlockRegistry.SMOOTH_ROCK_BLOCKS.get(RockType.byId(j)).get(), ECBlockRegistry.SMOOTH_ROCK_SLABS.get(RockType.byId(j)).get(),
                ECBlockRegistry.SMOOTH_ROCK_STAIRS.get(RockType.byId(j)).get(), ECBlockRegistry.SMOOTH_ROCK_WALLS.get(RockType.byId(j)).get(),
                ECBlockRegistry.SMOOTH_ROCK_PRESSURE_PLATES.get(RockType.byId(j)).get(), null);

            registerStoneVariant(RockType.byId(j).getName(), ECBlockRegistry.POLISHED_ROCK_BLOCKS.get(RockType.byId(j)).get(), ECBlockRegistry.POLISHED_ROCK_SLABS.get(RockType.byId(j)).get(),
                ECBlockRegistry.POLISHED_ROCK_STAIRS.get(RockType.byId(j)).get(), ECBlockRegistry.POLISHED_ROCK_WALLS.get(RockType.byId(j)).get(),
                ECBlockRegistry.POLISHED_ROCK_PRESSURE_PLATES.get(RockType.byId(j)).get(), null);

            registerStoneVariant(RockType.byId(j).getName(), ECBlockRegistry.ROCK_PAVINGS.get(RockType.byId(j)).get(), ECBlockRegistry.ROCK_PAVING_SLABS.get(RockType.byId(j)).get(),
                ECBlockRegistry.ROCK_PAVING_STAIRS.get(RockType.byId(j)).get(), ECBlockRegistry.ROCK_PAVING_WALLS.get(RockType.byId(j)).get(),
                ECBlockRegistry.ROCK_PAVING_PRESSURE_PLATES.get(RockType.byId(j)).get(), null);

            registerStoneVariant(RockType.byId(j).getName(), ECBlockRegistry.ROCK_TILES.get(RockType.byId(j)).get(), ECBlockRegistry.ROCK_TILES_SLABS.get(RockType.byId(j)).get(),
                ECBlockRegistry.ROCK_TILES_STAIRS.get(RockType.byId(j)).get(), ECBlockRegistry.ROCK_TILES_WALLS.get(RockType.byId(j)).get(),
                ECBlockRegistry.ROCK_TILES_PRESSURE_PLATES.get(RockType.byId(j)).get(), null);

            registerStoneVariant(RockType.byId(j).getName(), ECBlockRegistry.ROCK_BRICKS.get(RockType.byId(j)).get(), ECBlockRegistry.ROCK_BRICKS_SLABS.get(RockType.byId(j)).get(),
                ECBlockRegistry.ROCK_BRICKS_STAIRS.get(RockType.byId(j)).get(), ECBlockRegistry.ROCK_BRICKS_WALLS.get(RockType.byId(j)).get(),
                ECBlockRegistry.ROCK_BRICKS_PRESSURE_PLATES.get(RockType.byId(j)).get(), null);

            registerStoneVariant(RockType.byId(j).getName(), ECBlockRegistry.ROCK_LARGE_BRICKS.get(RockType.byId(j)).get(), ECBlockRegistry.ROCK_LARGE_BRICKS_SLABS.get(RockType.byId(j)).get(),
                ECBlockRegistry.ROCK_LARGE_BRICKS_STAIRS.get(RockType.byId(j)).get(), ECBlockRegistry.ROCK_LARGE_BRICKS_WALLS.get(RockType.byId(j)).get(),
                ECBlockRegistry.ROCK_LARGE_BRICKS_PRESSURE_PLATES.get(RockType.byId(j)).get(), null);

            registerStoneVariant(RockType.byId(j).getName(), ECBlockRegistry.ROCK_ORNAMENTS.get(RockType.byId(j)).get(), null, null, null,
                ECBlockRegistry.ROCK_ORNAMENT_PRESSURE_PLATES.get(RockType.byId(j)).get(), null);
        }

        // // Basalt
        // registerStoneVariant("basalt", ECBlockRegistry.BASALT.get(), ECBlockRegistry.BASALT_SLAB.get(), ECBlockRegistry.BASALT_STAIRS.get(), ECBlockRegistry.BASALT_WALL.get(),
        // ECBlockRegistry.BASALT_PRESSURE_PLATE.get(), ECBlockRegistry.BASALT_BUTTON.get());
        // registerStoneVariant("basalt_cobblestone", ECBlockRegistry.BASALT_COBBLESTONE.get(), ECBlockRegistry.BASALT_COBBLESTONE_SLAB.get(), ECBlockRegistry.BASALT_COBBLESTONE_STAIRS.get(),
        // ECBlockRegistry.BASALT_COBBLESTONE_WALL.get(), ECBlockRegistry.BASALT_COBBLESTONE_PRESSURE_PLATE.get(), null);
        // registerStoneVariant("smooth_basalt", ECBlockRegistry.SMOOTH_BASALT.get(), ECBlockRegistry.SMOOTH_BASALT_SLAB.get(), ECBlockRegistry.SMOOTH_BASALT_STAIRS.get(),
        // ECBlockRegistry.SMOOTH_BASALT_WALL.get(),
        // ECBlockRegistry.SMOOTH_BASALT_PRESSURE_PLATE.get(), null);
        // registerStoneVariant("polished_basalt", ECBlockRegistry.POLISHED_BASALT.get(), ECBlockRegistry.POLISHED_BASALT_SLAB.get(), ECBlockRegistry.POLISHED_BASALT_STAIRS.get(),
        // ECBlockRegistry.POLISHED_BASALT_WALL.get(), ECBlockRegistry.POLISHED_BASALT_PRESSURE_PLATE.get(), null);
        // registerStoneVariant("basalt_paving", ECBlockRegistry.BASALT_PAVING.get(), ECBlockRegistry.BASALT_PAVING_SLAB.get(), ECBlockRegistry.BASALT_PAVING_STAIRS.get(),
        // ECBlockRegistry.BASALT_PAVING_WALL.get(),
        // ECBlockRegistry.BASALT_PAVING_PRESSURE_PLATE.get(), null);
        // registerStoneVariant("basalt_tiles", ECBlockRegistry.BASALT_TILES.get(), ECBlockRegistry.BASALT_TILES_SLAB.get(), ECBlockRegistry.BASALT_TILES_STAIRS.get(),
        // ECBlockRegistry.BASALT_TILES_WALL.get(),
        // ECBlockRegistry.BASALT_TILES_PRESSURE_PLATE.get(), null);
        // registerStoneVariant("basalt_bricks", ECBlockRegistry.BASALT_BRICKS.get(), ECBlockRegistry.BASALT_BRICKS_SLAB.get(), ECBlockRegistry.BASALT_BRICKS_STAIRS.get(),
        // ECBlockRegistry.BASALT_BRICKS_WALL.get(),
        // ECBlockRegistry.BASALT_BRICKS_PRESSURE_PLATE.get(), null);
        // registerStoneVariant("basalt_large_bricks", ECBlockRegistry.BASALT_LARGE_BRICKS.get(), ECBlockRegistry.BASALT_LARGE_BRICKS_SLAB.get(), ECBlockRegistry.BASALT_LARGE_BRICKS_STAIRS.get(),
        // ECBlockRegistry.BASALT_LARGE_BRICKS_WALL.get(), ECBlockRegistry.BASALT_LARGE_BRICKS_PRESSURE_PLATE.get(), null);
        // registerStoneVariant("basalt_ornament", ECBlockRegistry.BASALT_ORNAMENT.get(), null, null, null, ECBlockRegistry.BASALT_ORNAMENT_PRESSURE_PLATE.get(), null);
        //
        // // Slate
        // registerStoneVariant("slate", ECBlockRegistry.SLATE.get(), ECBlockRegistry.SLATE_SLAB.get(), ECBlockRegistry.SLATE_STAIRS.get(), ECBlockRegistry.SLATE_WALL.get(),
        // ECBlockRegistry.SLATE_PRESSURE_PLATE.get(), ECBlockRegistry.SLATE_BUTTON.get());
        // registerStoneVariant("slate_cobblestone", ECBlockRegistry.SLATE_COBBLESTONE.get(), ECBlockRegistry.SLATE_COBBLESTONE_SLAB.get(), ECBlockRegistry.SLATE_COBBLESTONE_STAIRS.get(),
        // ECBlockRegistry.SLATE_COBBLESTONE_WALL.get(), ECBlockRegistry.SLATE_COBBLESTONE_PRESSURE_PLATE.get(), null);
        // registerStoneVariant("smooth_slate", ECBlockRegistry.SMOOTH_SLATE.get(), ECBlockRegistry.SMOOTH_SLATE_SLAB.get(), ECBlockRegistry.SMOOTH_SLATE_STAIRS.get(),
        // ECBlockRegistry.SMOOTH_SLATE_WALL.get(),
        // ECBlockRegistry.SMOOTH_SLATE_PRESSURE_PLATE.get(), null);
        // registerStoneVariant("polished_slate", ECBlockRegistry.POLISHED_SLATE.get(), ECBlockRegistry.POLISHED_SLATE_SLAB.get(), ECBlockRegistry.POLISHED_SLATE_STAIRS.get(),
        // ECBlockRegistry.POLISHED_SLATE_WALL.get(), ECBlockRegistry.POLISHED_SLATE_PRESSURE_PLATE.get(), null);
        // registerStoneVariant("slate_paving", ECBlockRegistry.SLATE_PAVING.get(), ECBlockRegistry.SLATE_PAVING_SLAB.get(), ECBlockRegistry.SLATE_PAVING_STAIRS.get(),
        // ECBlockRegistry.SLATE_PAVING_WALL.get(),
        // ECBlockRegistry.SLATE_PAVING_PRESSURE_PLATE.get(), null);
        // registerStoneVariant("slate_tiles", ECBlockRegistry.SLATE_TILES.get(), ECBlockRegistry.SLATE_TILES_SLAB.get(), ECBlockRegistry.SLATE_TILES_STAIRS.get(),
        // ECBlockRegistry.SLATE_TILES_WALL.get(),
        // ECBlockRegistry.SLATE_TILES_PRESSURE_PLATE.get(), null);
        // registerStoneVariant("slate_bricks", ECBlockRegistry.SLATE_BRICKS.get(), ECBlockRegistry.SLATE_BRICKS_SLAB.get(), ECBlockRegistry.SLATE_BRICKS_STAIRS.get(),
        // ECBlockRegistry.SLATE_BRICKS_WALL.get(),
        // ECBlockRegistry.SLATE_BRICKS_PRESSURE_PLATE.get(), null);
        // registerStoneVariant("slate_large_bricks", ECBlockRegistry.SLATE_LARGE_BRICKS.get(), ECBlockRegistry.SLATE_LARGE_BRICKS_SLAB.get(), ECBlockRegistry.SLATE_LARGE_BRICKS_STAIRS.get(),
        // ECBlockRegistry.SLATE_LARGE_BRICKS_WALL.get(), ECBlockRegistry.SLATE_LARGE_BRICKS_PRESSURE_PLATE.get(), null);
        // registerStoneVariant("slate_ornament", ECBlockRegistry.SLATE_ORNAMENT.get(), null, null, null, ECBlockRegistry.SLATE_ORNAMENT_PRESSURE_PLATE.get(), null);
        //
        // // Marble
        // registerStoneVariant("marble", ECBlockRegistry.MARBLE.get(), ECBlockRegistry.MARBLE_SLAB.get(), ECBlockRegistry.MARBLE_STAIRS.get(), ECBlockRegistry.MARBLE_WALL.get(),
        // ECBlockRegistry.MARBLE_PRESSURE_PLATE.get(), ECBlockRegistry.MARBLE_BUTTON.get());
        // registerStoneVariant("marble_cobblestone", ECBlockRegistry.MARBLE_COBBLESTONE.get(), ECBlockRegistry.MARBLE_COBBLESTONE_SLAB.get(), ECBlockRegistry.MARBLE_COBBLESTONE_STAIRS.get(),
        // ECBlockRegistry.MARBLE_COBBLESTONE_WALL.get(), ECBlockRegistry.MARBLE_COBBLESTONE_PRESSURE_PLATE.get(), null);
        // registerStoneVariant("smooth_marble", ECBlockRegistry.SMOOTH_MARBLE.get(), ECBlockRegistry.SMOOTH_MARBLE_SLAB.get(), ECBlockRegistry.SMOOTH_MARBLE_STAIRS.get(),
        // ECBlockRegistry.SMOOTH_MARBLE_WALL.get(),
        // ECBlockRegistry.SMOOTH_MARBLE_PRESSURE_PLATE.get(), null);
        // registerStoneVariant("polished_marble", ECBlockRegistry.POLISHED_MARBLE.get(), ECBlockRegistry.POLISHED_MARBLE_SLAB.get(), ECBlockRegistry.POLISHED_MARBLE_STAIRS.get(),
        // ECBlockRegistry.POLISHED_MARBLE_WALL.get(), ECBlockRegistry.POLISHED_MARBLE_PRESSURE_PLATE.get(), null);
        // registerStoneVariant("marble_paving", ECBlockRegistry.MARBLE_PAVING.get(), ECBlockRegistry.MARBLE_PAVING_SLAB.get(), ECBlockRegistry.MARBLE_PAVING_STAIRS.get(),
        // ECBlockRegistry.MARBLE_PAVING_WALL.get(),
        // ECBlockRegistry.MARBLE_PAVING_PRESSURE_PLATE.get(), null);
        // registerStoneVariant("marble_tiles", ECBlockRegistry.MARBLE_TILES.get(), ECBlockRegistry.MARBLE_TILES_SLAB.get(), ECBlockRegistry.MARBLE_TILES_STAIRS.get(),
        // ECBlockRegistry.MARBLE_TILES_WALL.get(),
        // ECBlockRegistry.MARBLE_TILES_PRESSURE_PLATE.get(), null);
        // registerStoneVariant("marble_bricks", ECBlockRegistry.MARBLE_BRICKS.get(), ECBlockRegistry.MARBLE_BRICKS_SLAB.get(), ECBlockRegistry.MARBLE_BRICKS_STAIRS.get(),
        // ECBlockRegistry.MARBLE_BRICKS_WALL.get(),
        // ECBlockRegistry.MARBLE_BRICKS_PRESSURE_PLATE.get(), null);
        // registerStoneVariant("marble_large_bricks", ECBlockRegistry.MARBLE_LARGE_BRICKS.get(), ECBlockRegistry.MARBLE_LARGE_BRICKS_SLAB.get(), ECBlockRegistry.MARBLE_LARGE_BRICKS_STAIRS.get(),
        // ECBlockRegistry.MARBLE_LARGE_BRICKS_WALL.get(), ECBlockRegistry.MARBLE_LARGE_BRICKS_PRESSURE_PLATE.get(), null);
        // registerStoneVariant("marble_ornament", ECBlockRegistry.MARBLE_ORNAMENT.get(), null, null, null, ECBlockRegistry.MARBLE_ORNAMENT_PRESSURE_PLATE.get(), null);
        //
        // // Gneiss
        // registerStoneVariant("gneiss", ECBlockRegistry.GNEISS.get(), ECBlockRegistry.GNEISS_SLAB.get(), ECBlockRegistry.GNEISS_STAIRS.get(), ECBlockRegistry.GNEISS_WALL.get(),
        // ECBlockRegistry.GNEISS_PRESSURE_PLATE.get(), ECBlockRegistry.GNEISS_BUTTON.get());
        // registerStoneVariant("gneiss_cobblestone", ECBlockRegistry.GNEISS_COBBLESTONE.get(), ECBlockRegistry.GNEISS_COBBLESTONE_SLAB.get(), ECBlockRegistry.GNEISS_COBBLESTONE_STAIRS.get(),
        // ECBlockRegistry.GNEISS_COBBLESTONE_WALL.get(), ECBlockRegistry.GNEISS_COBBLESTONE_PRESSURE_PLATE.get(), null);
        // registerStoneVariant("smooth_gneiss", ECBlockRegistry.SMOOTH_GNEISS.get(), ECBlockRegistry.SMOOTH_GNEISS_SLAB.get(), ECBlockRegistry.SMOOTH_GNEISS_STAIRS.get(),
        // ECBlockRegistry.SMOOTH_GNEISS_WALL.get(),
        // ECBlockRegistry.SMOOTH_GNEISS_PRESSURE_PLATE.get(), null);
        // registerStoneVariant("polished_gneiss", ECBlockRegistry.POLISHED_GNEISS.get(), ECBlockRegistry.POLISHED_GNEISS_SLAB.get(), ECBlockRegistry.POLISHED_GNEISS_STAIRS.get(),
        // ECBlockRegistry.POLISHED_GNEISS_WALL.get(), ECBlockRegistry.POLISHED_GNEISS_PRESSURE_PLATE.get(), null);
        // registerStoneVariant("gneiss_paving", ECBlockRegistry.GNEISS_PAVING.get(), ECBlockRegistry.GNEISS_PAVING_SLAB.get(), ECBlockRegistry.GNEISS_PAVING_STAIRS.get(),
        // ECBlockRegistry.GNEISS_PAVING_WALL.get(),
        // ECBlockRegistry.GNEISS_PAVING_PRESSURE_PLATE.get(), null);
        // registerStoneVariant("gneiss_tiles", ECBlockRegistry.GNEISS_TILES.get(), ECBlockRegistry.GNEISS_TILES_SLAB.get(), ECBlockRegistry.GNEISS_TILES_STAIRS.get(),
        // ECBlockRegistry.GNEISS_TILES_WALL.get(),
        // ECBlockRegistry.GNEISS_TILES_PRESSURE_PLATE.get(), null);
        // registerStoneVariant("gneiss_bricks", ECBlockRegistry.GNEISS_BRICKS.get(), ECBlockRegistry.GNEISS_BRICKS_SLAB.get(), ECBlockRegistry.GNEISS_BRICKS_STAIRS.get(),
        // ECBlockRegistry.GNEISS_BRICKS_WALL.get(),
        // ECBlockRegistry.GNEISS_BRICKS_PRESSURE_PLATE.get(), null);
        // registerStoneVariant("gneiss_large_bricks", ECBlockRegistry.GNEISS_LARGE_BRICKS.get(), ECBlockRegistry.GNEISS_LARGE_BRICKS_SLAB.get(), ECBlockRegistry.GNEISS_LARGE_BRICKS_STAIRS.get(),
        // ECBlockRegistry.GNEISS_LARGE_BRICKS_WALL.get(), ECBlockRegistry.GNEISS_LARGE_BRICKS_PRESSURE_PLATE.get(), null);
        // registerStoneVariant("gneiss_ornament", ECBlockRegistry.GNEISS_ORNAMENT.get(), null, null, null, ECBlockRegistry.GNEISS_ORNAMENT_PRESSURE_PLATE.get(), null);
        //
        // // Jade
        // registerStoneVariant("jade", ECBlockRegistry.JADE.get(), ECBlockRegistry.JADE_SLAB.get(), ECBlockRegistry.JADE_STAIRS.get(), ECBlockRegistry.JADE_WALL.get(),
        // ECBlockRegistry.JADE_PRESSURE_PLATE.get(),
        // ECBlockRegistry.JADE_BUTTON.get());
        // registerStoneVariant("jade_cobblestone", ECBlockRegistry.JADE_COBBLESTONE.get(), ECBlockRegistry.JADE_COBBLESTONE_SLAB.get(), ECBlockRegistry.JADE_COBBLESTONE_STAIRS.get(),
        // ECBlockRegistry.JADE_COBBLESTONE_WALL.get(), ECBlockRegistry.JADE_COBBLESTONE_PRESSURE_PLATE.get(), null);
        // registerStoneVariant("smooth_jade", ECBlockRegistry.SMOOTH_JADE.get(), ECBlockRegistry.SMOOTH_JADE_SLAB.get(), ECBlockRegistry.SMOOTH_JADE_STAIRS.get(),
        // ECBlockRegistry.SMOOTH_JADE_WALL.get(),
        // ECBlockRegistry.SMOOTH_JADE_PRESSURE_PLATE.get(), null);
        // registerStoneVariant("polished_jade", ECBlockRegistry.POLISHED_JADE.get(), ECBlockRegistry.POLISHED_JADE_SLAB.get(), ECBlockRegistry.POLISHED_JADE_STAIRS.get(),
        // ECBlockRegistry.POLISHED_JADE_WALL.get(),
        // ECBlockRegistry.POLISHED_JADE_PRESSURE_PLATE.get(), null);
        // registerStoneVariant("jade_paving", ECBlockRegistry.JADE_PAVING.get(), ECBlockRegistry.JADE_PAVING_SLAB.get(), ECBlockRegistry.JADE_PAVING_STAIRS.get(),
        // ECBlockRegistry.JADE_PAVING_WALL.get(),
        // ECBlockRegistry.JADE_PAVING_PRESSURE_PLATE.get(), null);
        // registerStoneVariant("jade_tiles", ECBlockRegistry.JADE_TILES.get(), ECBlockRegistry.JADE_TILES_SLAB.get(), ECBlockRegistry.JADE_TILES_STAIRS.get(), ECBlockRegistry.JADE_TILES_WALL.get(),
        // ECBlockRegistry.JADE_TILES_PRESSURE_PLATE.get(), null);
        // registerStoneVariant("jade_bricks", ECBlockRegistry.JADE_BRICKS.get(), ECBlockRegistry.JADE_BRICKS_SLAB.get(), ECBlockRegistry.JADE_BRICKS_STAIRS.get(),
        // ECBlockRegistry.JADE_BRICKS_WALL.get(),
        // ECBlockRegistry.JADE_BRICKS_PRESSURE_PLATE.get(), null);
        // registerStoneVariant("jade_large_bricks", ECBlockRegistry.JADE_LARGE_BRICKS.get(), ECBlockRegistry.JADE_LARGE_BRICKS_SLAB.get(), ECBlockRegistry.JADE_LARGE_BRICKS_STAIRS.get(),
        // ECBlockRegistry.JADE_LARGE_BRICKS_WALL.get(), ECBlockRegistry.JADE_LARGE_BRICKS_PRESSURE_PLATE.get(), null);
        // registerStoneVariant("jade_ornament", ECBlockRegistry.JADE_ORNAMENT.get(), null, null, null, ECBlockRegistry.JADE_ORNAMENT_PRESSURE_PLATE.get(), null);
        //
        // // Larvikite
        // registerStoneVariant("larvikite", ECBlockRegistry.LARVIKITE.get(), ECBlockRegistry.LARVIKITE_SLAB.get(), ECBlockRegistry.LARVIKITE_STAIRS.get(), ECBlockRegistry.LARVIKITE_WALL.get(),
        // ECBlockRegistry.LARVIKITE_PRESSURE_PLATE.get(), ECBlockRegistry.LARVIKITE_BUTTON.get());
        // registerStoneVariant("larvikite_cobblestone", ECBlockRegistry.LARVIKITE_COBBLESTONE.get(), ECBlockRegistry.LARVIKITE_COBBLESTONE_SLAB.get(),
        // ECBlockRegistry.LARVIKITE_COBBLESTONE_STAIRS.get(),
        // ECBlockRegistry.LARVIKITE_COBBLESTONE_WALL.get(), ECBlockRegistry.LARVIKITE_COBBLESTONE_PRESSURE_PLATE.get(), null);
        // registerStoneVariant("smooth_larvikite", ECBlockRegistry.SMOOTH_LARVIKITE.get(), ECBlockRegistry.SMOOTH_LARVIKITE_SLAB.get(), ECBlockRegistry.SMOOTH_LARVIKITE_STAIRS.get(),
        // ECBlockRegistry.SMOOTH_LARVIKITE_WALL.get(), ECBlockRegistry.SMOOTH_LARVIKITE_PRESSURE_PLATE.get(), null);
        // registerStoneVariant("polished_larvikite", ECBlockRegistry.POLISHED_LARVIKITE.get(), ECBlockRegistry.POLISHED_LARVIKITE_SLAB.get(), ECBlockRegistry.POLISHED_LARVIKITE_STAIRS.get(),
        // ECBlockRegistry.POLISHED_LARVIKITE_WALL.get(), ECBlockRegistry.POLISHED_LARVIKITE_PRESSURE_PLATE.get(), null);
        // registerStoneVariant("larvikite_paving", ECBlockRegistry.LARVIKITE_PAVING.get(), ECBlockRegistry.LARVIKITE_PAVING_SLAB.get(), ECBlockRegistry.LARVIKITE_PAVING_STAIRS.get(),
        // ECBlockRegistry.LARVIKITE_PAVING_WALL.get(), ECBlockRegistry.LARVIKITE_PAVING_PRESSURE_PLATE.get(), null);
        // registerStoneVariant("larvikite_tiles", ECBlockRegistry.LARVIKITE_TILES.get(), ECBlockRegistry.LARVIKITE_TILES_SLAB.get(), ECBlockRegistry.LARVIKITE_TILES_STAIRS.get(),
        // ECBlockRegistry.LARVIKITE_TILES_WALL.get(), ECBlockRegistry.LARVIKITE_TILES_PRESSURE_PLATE.get(), null);
        // registerStoneVariant("larvikite_bricks", ECBlockRegistry.LARVIKITE_BRICKS.get(), ECBlockRegistry.LARVIKITE_BRICKS_SLAB.get(), ECBlockRegistry.LARVIKITE_BRICKS_STAIRS.get(),
        // ECBlockRegistry.LARVIKITE_BRICKS_WALL.get(), ECBlockRegistry.LARVIKITE_BRICKS_PRESSURE_PLATE.get(), null);
        // registerStoneVariant("larvikite_large_bricks", ECBlockRegistry.LARVIKITE_LARGE_BRICKS.get(), ECBlockRegistry.LARVIKITE_LARGE_BRICKS_SLAB.get(),
        // ECBlockRegistry.LARVIKITE_LARGE_BRICKS_STAIRS.get(),
        // ECBlockRegistry.LARVIKITE_LARGE_BRICKS_WALL.get(), ECBlockRegistry.LARVIKITE_LARGE_BRICKS_PRESSURE_PLATE.get(), null);
        // registerStoneVariant("larvikite_ornament", ECBlockRegistry.LARVIKITE_ORNAMENT.get(), null, null, null, ECBlockRegistry.LARVIKITE_ORNAMENT_PRESSURE_PLATE.get(), null);

        // Andesite
        registerStoneVariant("andesite", null, null, null, null, null, ECBlockRegistry.ANDESITE_BUTTON.get());
        registerStoneVariant("smooth_andesite", ECBlockRegistry.SMOOTH_ANDESITE.get(), ECBlockRegistry.SMOOTH_ANDESITE_SLAB.get(), ECBlockRegistry.SMOOTH_ANDESITE_STAIRS.get(),
            ECBlockRegistry.SMOOTH_ANDESITE_WALL.get(), ECBlockRegistry.SMOOTH_ANDESITE_PRESSURE_PLATE.get(), null);
        registerStoneVariant("andesite_paving", ECBlockRegistry.ANDESITE_PAVING.get(), ECBlockRegistry.ANDESITE_PAVING_SLAB.get(), ECBlockRegistry.ANDESITE_PAVING_STAIRS.get(),
            ECBlockRegistry.ANDESITE_PAVING_WALL.get(), ECBlockRegistry.ANDESITE_PAVING_PRESSURE_PLATE.get(), null);
        registerStoneVariant("andesite_tiles", ECBlockRegistry.ANDESITE_TILES.get(), ECBlockRegistry.ANDESITE_TILES_SLAB.get(), ECBlockRegistry.ANDESITE_TILES_STAIRS.get(),
            ECBlockRegistry.ANDESITE_TILES_WALL.get(), ECBlockRegistry.ANDESITE_TILES_PRESSURE_PLATE.get(), null);
        registerStoneVariant("andesite_bricks", ECBlockRegistry.ANDESITE_BRICKS.get(), ECBlockRegistry.ANDESITE_BRICKS_SLAB.get(), ECBlockRegistry.ANDESITE_BRICKS_STAIRS.get(),
            ECBlockRegistry.ANDESITE_BRICKS_WALL.get(), ECBlockRegistry.ANDESITE_BRICKS_PRESSURE_PLATE.get(), null);
        registerStoneVariant("andesite_large_bricks", ECBlockRegistry.ANDESITE_LARGE_BRICKS.get(), ECBlockRegistry.ANDESITE_LARGE_BRICKS_SLAB.get(), ECBlockRegistry.ANDESITE_LARGE_BRICKS_STAIRS.get(),
            ECBlockRegistry.ANDESITE_LARGE_BRICKS_WALL.get(), ECBlockRegistry.ANDESITE_LARGE_BRICKS_PRESSURE_PLATE.get(), null);
        registerStoneVariant("andesite_ornament", ECBlockRegistry.ANDESITE_ORNAMENT.get(), null, null, null, ECBlockRegistry.ANDESITE_ORNAMENT_PRESSURE_PLATE.get(), null);

        // Diorite
        registerStoneVariant("diorite", null, null, null, null, null, ECBlockRegistry.DIORITE_BUTTON.get());
        registerStoneVariant("smooth_diorite", ECBlockRegistry.SMOOTH_DIORITE.get(), ECBlockRegistry.SMOOTH_DIORITE_SLAB.get(), ECBlockRegistry.SMOOTH_DIORITE_STAIRS.get(),
            ECBlockRegistry.SMOOTH_DIORITE_WALL.get(), ECBlockRegistry.SMOOTH_DIORITE_PRESSURE_PLATE.get(), null);
        registerStoneVariant("diorite_paving", ECBlockRegistry.DIORITE_PAVING.get(), ECBlockRegistry.DIORITE_PAVING_SLAB.get(), ECBlockRegistry.DIORITE_PAVING_STAIRS.get(),
            ECBlockRegistry.DIORITE_PAVING_WALL.get(), ECBlockRegistry.DIORITE_PAVING_PRESSURE_PLATE.get(), null);
        registerStoneVariant("diorite_tiles", ECBlockRegistry.DIORITE_TILES.get(), ECBlockRegistry.DIORITE_TILES_SLAB.get(), ECBlockRegistry.DIORITE_TILES_STAIRS.get(), ECBlockRegistry.DIORITE_TILES_WALL.get(),
            ECBlockRegistry.DIORITE_TILES_PRESSURE_PLATE.get(), null);
        registerStoneVariant("diorite_bricks", ECBlockRegistry.DIORITE_BRICKS.get(), ECBlockRegistry.DIORITE_BRICKS_SLAB.get(), ECBlockRegistry.DIORITE_BRICKS_STAIRS.get(),
            ECBlockRegistry.DIORITE_BRICKS_WALL.get(), ECBlockRegistry.DIORITE_BRICKS_PRESSURE_PLATE.get(), null);
        registerStoneVariant("diorite_large_bricks", ECBlockRegistry.DIORITE_LARGE_BRICKS.get(), ECBlockRegistry.DIORITE_LARGE_BRICKS_SLAB.get(), ECBlockRegistry.DIORITE_LARGE_BRICKS_STAIRS.get(),
            ECBlockRegistry.DIORITE_LARGE_BRICKS_WALL.get(), ECBlockRegistry.DIORITE_LARGE_BRICKS_PRESSURE_PLATE.get(), null);
        registerStoneVariant("diorite_ornament", ECBlockRegistry.DIORITE_ORNAMENT.get(), null, null, null, ECBlockRegistry.DIORITE_ORNAMENT_PRESSURE_PLATE.get(), null);

        // Granite
        registerStoneVariant("granite", null, null, null, null, null, ECBlockRegistry.GRANITE_BUTTON.get());
        registerStoneVariant("smooth_granite", ECBlockRegistry.SMOOTH_GRANITE.get(), ECBlockRegistry.SMOOTH_GRANITE_SLAB.get(), ECBlockRegistry.SMOOTH_GRANITE_STAIRS.get(),
            ECBlockRegistry.SMOOTH_GRANITE_WALL.get(), ECBlockRegistry.SMOOTH_GRANITE_PRESSURE_PLATE.get(), null);
        registerStoneVariant("granite_paving", ECBlockRegistry.GRANITE_PAVING.get(), ECBlockRegistry.GRANITE_PAVING_SLAB.get(), ECBlockRegistry.GRANITE_PAVING_STAIRS.get(),
            ECBlockRegistry.GRANITE_PAVING_WALL.get(), ECBlockRegistry.GRANITE_PAVING_PRESSURE_PLATE.get(), null);
        registerStoneVariant("granite_tiles", ECBlockRegistry.GRANITE_TILES.get(), ECBlockRegistry.GRANITE_TILES_SLAB.get(), ECBlockRegistry.GRANITE_TILES_STAIRS.get(), ECBlockRegistry.GRANITE_TILES_WALL.get(),
            ECBlockRegistry.GRANITE_TILES_PRESSURE_PLATE.get(), null);
        registerStoneVariant("granite_bricks", ECBlockRegistry.GRANITE_BRICKS.get(), ECBlockRegistry.GRANITE_BRICKS_SLAB.get(), ECBlockRegistry.GRANITE_BRICKS_STAIRS.get(),
            ECBlockRegistry.GRANITE_BRICKS_WALL.get(), ECBlockRegistry.GRANITE_BRICKS_PRESSURE_PLATE.get(), null);
        registerStoneVariant("granite_large_bricks", ECBlockRegistry.GRANITE_LARGE_BRICKS.get(), ECBlockRegistry.GRANITE_LARGE_BRICKS_SLAB.get(), ECBlockRegistry.GRANITE_LARGE_BRICKS_STAIRS.get(),
            ECBlockRegistry.GRANITE_LARGE_BRICKS_WALL.get(), ECBlockRegistry.GRANITE_LARGE_BRICKS_PRESSURE_PLATE.get(), null);
        registerStoneVariant("granite_ornament", ECBlockRegistry.GRANITE_ORNAMENT.get(), null, null, null, ECBlockRegistry.GRANITE_ORNAMENT_PRESSURE_PLATE.get(), null);

        // Sandstone
        buttonBlock(ECBlockRegistry.SANDSTONE_BUTTON.get(), new UncheckedModelFile(ECConstants.MODID + ":block/sandstone_button"), new UncheckedModelFile(ECConstants.MODID + ":block/sandstone_button_pressed"),
            180);

        wallBlock(ECBlockRegistry.SMOOTH_SANDSTONE_WALL.get(), mcLoc("block/sandstone_top"));
        pressurePlateBlock(ECBlockRegistry.SMOOTH_SANDSTONE_PRESSURE_PLATE.get(), new UncheckedModelFile(ECConstants.MODID + ":block/smooth_sandstone_pressure_plate"),
            new UncheckedModelFile(ECConstants.MODID + ":block/smooth_sandstone_pressure_plate_down"));

        registerStoneVariant("polished_sandstone", ECBlockRegistry.POLISHED_SANDSTONE.get(), ECBlockRegistry.POLISHED_SANDSTONE_SLAB.get(), ECBlockRegistry.POLISHED_SANDSTONE_STAIRS.get(),
            ECBlockRegistry.POLISHED_SANDSTONE_WALL.get(), ECBlockRegistry.POLISHED_SANDSTONE_PRESSURE_PLATE.get(), null);
        registerStoneVariant("sandstone_paving", ECBlockRegistry.SANDSTONE_PAVING.get(), ECBlockRegistry.SANDSTONE_PAVING_SLAB.get(), ECBlockRegistry.SANDSTONE_PAVING_STAIRS.get(),
            ECBlockRegistry.SANDSTONE_PAVING_WALL.get(), ECBlockRegistry.SANDSTONE_PAVING_PRESSURE_PLATE.get(), null);
        registerStoneVariant("sandstone_tiles", ECBlockRegistry.SANDSTONE_TILES.get(), ECBlockRegistry.SANDSTONE_TILES_SLAB.get(), ECBlockRegistry.SANDSTONE_TILES_STAIRS.get(),
            ECBlockRegistry.SANDSTONE_TILES_WALL.get(), ECBlockRegistry.SANDSTONE_TILES_PRESSURE_PLATE.get(), null);
        registerStoneVariant("sandstone_bricks", ECBlockRegistry.SANDSTONE_BRICKS.get(), ECBlockRegistry.SANDSTONE_BRICKS_SLAB.get(), ECBlockRegistry.SANDSTONE_BRICKS_STAIRS.get(),
            ECBlockRegistry.SANDSTONE_BRICKS_WALL.get(), ECBlockRegistry.SANDSTONE_BRICKS_PRESSURE_PLATE.get(), null);
        registerStoneVariant("sandstone_large_bricks", ECBlockRegistry.SANDSTONE_LARGE_BRICKS.get(), ECBlockRegistry.SANDSTONE_LARGE_BRICKS_SLAB.get(), ECBlockRegistry.SANDSTONE_LARGE_BRICKS_STAIRS.get(),
            ECBlockRegistry.SANDSTONE_LARGE_BRICKS_WALL.get(), ECBlockRegistry.SANDSTONE_LARGE_BRICKS_PRESSURE_PLATE.get(), null);

        // Red Sandstone
        buttonBlock(ECBlockRegistry.RED_SANDSTONE_BUTTON.get(), new UncheckedModelFile(ECConstants.MODID + ":block/red_sandstone_button"),
            new UncheckedModelFile(ECConstants.MODID + ":block/red_sandstone_button_pressed"), 180);

        wallBlock(ECBlockRegistry.SMOOTH_RED_SANDSTONE_WALL.get(), mcLoc("block/red_sandstone_top"));
        pressurePlateBlock(ECBlockRegistry.SMOOTH_RED_SANDSTONE_PRESSURE_PLATE.get(), new UncheckedModelFile(ECConstants.MODID + ":block/smooth_red_sandstone_pressure_plate"),
            new UncheckedModelFile(ECConstants.MODID + ":block/smooth_red_sandstone_pressure_plate_down"));

        registerStoneVariant("polished_red_sandstone", ECBlockRegistry.POLISHED_RED_SANDSTONE.get(), ECBlockRegistry.POLISHED_RED_SANDSTONE_SLAB.get(), ECBlockRegistry.POLISHED_RED_SANDSTONE_STAIRS.get(),
            ECBlockRegistry.POLISHED_RED_SANDSTONE_WALL.get(), ECBlockRegistry.POLISHED_RED_SANDSTONE_PRESSURE_PLATE.get(), null);
        registerStoneVariant("red_sandstone_paving", ECBlockRegistry.RED_SANDSTONE_PAVING.get(), ECBlockRegistry.RED_SANDSTONE_PAVING_SLAB.get(), ECBlockRegistry.RED_SANDSTONE_PAVING_STAIRS.get(),
            ECBlockRegistry.RED_SANDSTONE_PAVING_WALL.get(), ECBlockRegistry.RED_SANDSTONE_PAVING_PRESSURE_PLATE.get(), null);
        registerStoneVariant("red_sandstone_tiles", ECBlockRegistry.RED_SANDSTONE_TILES.get(), ECBlockRegistry.RED_SANDSTONE_TILES_SLAB.get(), ECBlockRegistry.RED_SANDSTONE_TILES_STAIRS.get(),
            ECBlockRegistry.RED_SANDSTONE_TILES_WALL.get(), ECBlockRegistry.RED_SANDSTONE_TILES_PRESSURE_PLATE.get(), null);
        registerStoneVariant("red_sandstone_bricks", ECBlockRegistry.RED_SANDSTONE_BRICKS.get(), ECBlockRegistry.RED_SANDSTONE_BRICKS_SLAB.get(), ECBlockRegistry.RED_SANDSTONE_BRICKS_STAIRS.get(),
            ECBlockRegistry.RED_SANDSTONE_BRICKS_WALL.get(), ECBlockRegistry.RED_SANDSTONE_BRICKS_PRESSURE_PLATE.get(), null);
        registerStoneVariant("red_sandstone_large_bricks", ECBlockRegistry.RED_SANDSTONE_LARGE_BRICKS.get(), ECBlockRegistry.RED_SANDSTONE_LARGE_BRICKS_SLAB.get(),
            ECBlockRegistry.RED_SANDSTONE_LARGE_BRICKS_STAIRS.get(), ECBlockRegistry.RED_SANDSTONE_LARGE_BRICKS_WALL.get(), ECBlockRegistry.RED_SANDSTONE_LARGE_BRICKS_PRESSURE_PLATE.get(), null);

        // Terracotta
        slabBlock(ECBlockRegistry.TERRACOTTA_SLAB.get(), mcLoc("block/terracotta"), mcLoc("block/terracotta"));
        stairsBlock(ECBlockRegistry.TERRACOTTA_STAIRS.get(), mcLoc("block/terracotta"));
        wallBlock(ECBlockRegistry.TERRACOTTA_WALL.get(), mcLoc("block/terracotta"));
        pressurePlateBlock(ECBlockRegistry.TERRACOTTA_PRESSURE_PLATE.get(), new UncheckedModelFile(ECConstants.MODID + ":block/terracotta_pressure_plate"),
            new UncheckedModelFile(ECConstants.MODID + ":block/terracotta_pressure_plate_down"));
        buttonBlock(ECBlockRegistry.TERRACOTTA_BUTTON.get(), new UncheckedModelFile(ECConstants.MODID + ":block/terracotta_button"),
            new UncheckedModelFile(ECConstants.MODID + ":block/terracotta_button_pressed"), 180);

        registerStoneVariant("polished_terracotta", ECBlockRegistry.POLISHED_TERRACOTTA.get(), ECBlockRegistry.POLISHED_TERRACOTTA_SLAB.get(), ECBlockRegistry.POLISHED_TERRACOTTA_STAIRS.get(),
            ECBlockRegistry.POLISHED_TERRACOTTA_WALL.get(), ECBlockRegistry.POLISHED_TERRACOTTA_PRESSURE_PLATE.get(), null);
        registerStoneVariant("terracotta_paving", ECBlockRegistry.TERRACOTTA_PAVING.get(), ECBlockRegistry.TERRACOTTA_PAVING_SLAB.get(), ECBlockRegistry.TERRACOTTA_PAVING_STAIRS.get(),
            ECBlockRegistry.TERRACOTTA_PAVING_WALL.get(), ECBlockRegistry.TERRACOTTA_PAVING_PRESSURE_PLATE.get(), null);
        registerStoneVariant("terracotta_tiles", ECBlockRegistry.TERRACOTTA_TILES.get(), ECBlockRegistry.TERRACOTTA_TILES_SLAB.get(), ECBlockRegistry.TERRACOTTA_TILES_STAIRS.get(),
            ECBlockRegistry.TERRACOTTA_TILES_WALL.get(), ECBlockRegistry.TERRACOTTA_TILES_PRESSURE_PLATE.get(), null);
        registerStoneVariant("terracotta_bricks", ECBlockRegistry.TERRACOTTA_BRICKS.get(), ECBlockRegistry.TERRACOTTA_BRICKS_SLAB.get(), ECBlockRegistry.TERRACOTTA_BRICKS_STAIRS.get(),
            ECBlockRegistry.TERRACOTTA_BRICKS_WALL.get(), ECBlockRegistry.TERRACOTTA_BRICKS_PRESSURE_PLATE.get(), null);
        registerStoneVariant("terracotta_large_bricks", ECBlockRegistry.TERRACOTTA_LARGE_BRICKS.get(), ECBlockRegistry.TERRACOTTA_LARGE_BRICKS_SLAB.get(), ECBlockRegistry.TERRACOTTA_LARGE_BRICKS_STAIRS.get(),
            ECBlockRegistry.TERRACOTTA_LARGE_BRICKS_WALL.get(), ECBlockRegistry.TERRACOTTA_LARGE_BRICKS_PRESSURE_PLATE.get(), null);

        // Other bricks
        registerStoneVariant("dark_bricks", ECBlockRegistry.DARK_BRICKS.get(), ECBlockRegistry.DARK_BRICKS_SLAB.get(), ECBlockRegistry.DARK_BRICKS_STAIRS.get(), ECBlockRegistry.DARK_BRICKS_WALL.get(),
            ECBlockRegistry.DARK_BRICKS_PRESSURE_PLATE.get(), null);
        registerStoneVariant("old_bricks", ECBlockRegistry.OLD_BRICKS.get(), ECBlockRegistry.OLD_BRICKS_SLAB.get(), ECBlockRegistry.OLD_BRICKS_STAIRS.get(), ECBlockRegistry.OLD_BRICKS_WALL.get(),
            ECBlockRegistry.OLD_BRICKS_PRESSURE_PLATE.get(), null);
        registerStoneVariant("weared_bricks", ECBlockRegistry.WEARED_BRICKS.get(), ECBlockRegistry.WEARED_BRICKS_SLAB.get(), ECBlockRegistry.WEARED_BRICKS_STAIRS.get(), ECBlockRegistry.WEARED_BRICKS_WALL.get(),
            ECBlockRegistry.WEARED_BRICKS_PRESSURE_PLATE.get(), null);

        registerStoneVariant("dark_large_bricks", ECBlockRegistry.DARK_LARGE_BRICKS.get(), ECBlockRegistry.DARK_LARGE_BRICKS_SLAB.get(), ECBlockRegistry.DARK_LARGE_BRICKS_STAIRS.get(),
            ECBlockRegistry.DARK_LARGE_BRICKS_WALL.get(), ECBlockRegistry.DARK_LARGE_BRICKS_PRESSURE_PLATE.get(), null);
        registerStoneVariant("old_large_bricks", ECBlockRegistry.OLD_LARGE_BRICKS.get(), ECBlockRegistry.OLD_LARGE_BRICKS_SLAB.get(), ECBlockRegistry.OLD_LARGE_BRICKS_STAIRS.get(),
            ECBlockRegistry.OLD_LARGE_BRICKS_WALL.get(), ECBlockRegistry.OLD_LARGE_BRICKS_PRESSURE_PLATE.get(), null);
        registerStoneVariant("weared_large_bricks", ECBlockRegistry.WEARED_LARGE_BRICKS.get(), ECBlockRegistry.WEARED_LARGE_BRICKS_SLAB.get(), ECBlockRegistry.WEARED_LARGE_BRICKS_STAIRS.get(),
            ECBlockRegistry.WEARED_LARGE_BRICKS_WALL.get(), ECBlockRegistry.WEARED_LARGE_BRICKS_PRESSURE_PLATE.get(), null);

        // Pavings
        registerStoneVariant("concrete_paving", ECBlockRegistry.CONCRETE_PAVING.get(), ECBlockRegistry.CONCRETE_PAVING_SLAB.get(), ECBlockRegistry.CONCRETE_PAVING_STAIRS.get(),
            ECBlockRegistry.CONCRETE_PAVING_WALL.get(), ECBlockRegistry.CONCRETE_PAVING_PRESSURE_PLATE.get(), null);
        registerStoneVariant("damaged_paving", ECBlockRegistry.DAMAGED_PAVING.get(), ECBlockRegistry.DAMAGED_PAVING_SLAB.get(), ECBlockRegistry.DAMAGED_PAVING_STAIRS.get(),
            ECBlockRegistry.DAMAGED_PAVING_WALL.get(), ECBlockRegistry.DAMAGED_PAVING_PRESSURE_PLATE.get(), null);
        registerStoneVariant("dark_concrete_paving", ECBlockRegistry.DARK_CONCRETE_PAVING.get(), ECBlockRegistry.DARK_CONCRETE_PAVING_SLAB.get(), ECBlockRegistry.DARK_CONCRETE_PAVING_STAIRS.get(),
            ECBlockRegistry.DARK_CONCRETE_PAVING_WALL.get(), ECBlockRegistry.DARK_CONCRETE_PAVING_PRESSURE_PLATE.get(), null);
        registerStoneVariant("moist_paving", ECBlockRegistry.MOIST_PAVING.get(), ECBlockRegistry.MOIST_PAVING_SLAB.get(), ECBlockRegistry.MOIST_PAVING_STAIRS.get(), ECBlockRegistry.MOIST_PAVING_WALL.get(),
            ECBlockRegistry.MOIST_PAVING_PRESSURE_PLATE.get(), null);
        registerStoneVariant("polished_paving", ECBlockRegistry.POLISHED_PAVING.get(), ECBlockRegistry.POLISHED_PAVING_SLAB.get(), ECBlockRegistry.POLISHED_PAVING_STAIRS.get(),
            ECBlockRegistry.POLISHED_PAVING_WALL.get(), ECBlockRegistry.POLISHED_PAVING_PRESSURE_PLATE.get(), null);
        registerStoneVariant("white_concrete_paving", ECBlockRegistry.WHITE_CONCRETE_PAVING.get(), ECBlockRegistry.WHITE_CONCRETE_PAVING_SLAB.get(), ECBlockRegistry.WHITE_CONCRETE_PAVING_STAIRS.get(),
            ECBlockRegistry.WHITE_CONCRETE_PAVING_WALL.get(), ECBlockRegistry.WHITE_CONCRETE_PAVING_PRESSURE_PLATE.get(), null);

        // Tiles
        registerStoneVariant("concrete_tiles", ECBlockRegistry.CONCRETE_TILES.get(), ECBlockRegistry.CONCRETE_TILES_SLAB.get(), ECBlockRegistry.CONCRETE_TILES_STAIRS.get(),
            ECBlockRegistry.CONCRETE_TILES_WALL.get(), ECBlockRegistry.CONCRETE_TILES_PRESSURE_PLATE.get(), null);
        registerStoneVariant("skyblue_tiles", ECBlockRegistry.SKYBLUE_TILES.get(), ECBlockRegistry.SKYBLUE_TILES_SLAB.get(), ECBlockRegistry.SKYBLUE_TILES_STAIRS.get(), ECBlockRegistry.SKYBLUE_TILES_WALL.get(),
            ECBlockRegistry.SKYBLUE_TILES_PRESSURE_PLATE.get(), null);
        registerStoneVariant("orange_tiles", ECBlockRegistry.ORANGE_TILES.get(), ECBlockRegistry.ORANGE_TILES_SLAB.get(), ECBlockRegistry.ORANGE_TILES_STAIRS.get(), ECBlockRegistry.ORANGE_TILES_WALL.get(),
            ECBlockRegistry.ORANGE_TILES_PRESSURE_PLATE.get(), null);
        registerStoneVariant("blue_tiles", ECBlockRegistry.BLUE_TILES.get(), ECBlockRegistry.BLUE_TILES_SLAB.get(), ECBlockRegistry.BLUE_TILES_STAIRS.get(), ECBlockRegistry.BLUE_TILES_WALL.get(),
            ECBlockRegistry.BLUE_TILES_PRESSURE_PLATE.get(), null);
        registerStoneVariant("light_blue_tiles", ECBlockRegistry.LIGHT_BLUE_TILES.get(), ECBlockRegistry.LIGHT_BLUE_TILES_SLAB.get(), ECBlockRegistry.LIGHT_BLUE_TILES_STAIRS.get(),
            ECBlockRegistry.LIGHT_BLUE_TILES_WALL.get(), ECBlockRegistry.LIGHT_BLUE_TILES_PRESSURE_PLATE.get(), null);
        registerStoneVariant("red_tiles", ECBlockRegistry.RED_TILES.get(), ECBlockRegistry.RED_TILES_SLAB.get(), ECBlockRegistry.RED_TILES_STAIRS.get(), ECBlockRegistry.RED_TILES_WALL.get(),
            ECBlockRegistry.RED_TILES_PRESSURE_PLATE.get(), null);
        registerStoneVariant("white_tiles", ECBlockRegistry.WHITE_TILES.get(), ECBlockRegistry.WHITE_TILES_SLAB.get(), ECBlockRegistry.WHITE_TILES_STAIRS.get(), ECBlockRegistry.WHITE_TILES_WALL.get(),
            ECBlockRegistry.WHITE_TILES_PRESSURE_PLATE.get(), null);
        registerStoneVariant("yellow_tiles", ECBlockRegistry.YELLOW_TILES.get(), ECBlockRegistry.YELLOW_TILES_SLAB.get(), ECBlockRegistry.YELLOW_TILES_STAIRS.get(), ECBlockRegistry.YELLOW_TILES_WALL.get(),
            ECBlockRegistry.YELLOW_TILES_PRESSURE_PLATE.get(), null);
        registerStoneVariant("yellow_grey_tiles", ECBlockRegistry.YELLOW_GREY_TILES.get(), ECBlockRegistry.YELLOW_GREY_TILES_SLAB.get(), ECBlockRegistry.YELLOW_GREY_TILES_STAIRS.get(),
            ECBlockRegistry.YELLOW_GREY_TILES_WALL.get(), ECBlockRegistry.YELLOW_GREY_TILES_PRESSURE_PLATE.get(), null);

        // Metal blocks
        registerStoneVariant("dark_metal_floor", ECBlockRegistry.DARK_METAL_FLOOR.get(), ECBlockRegistry.DARK_METAL_FLOOR_SLAB.get(), ECBlockRegistry.DARK_METAL_FLOOR_STAIRS.get(),
            ECBlockRegistry.DARK_METAL_FLOOR_WALL.get(), ECBlockRegistry.DARK_METAL_FLOOR_PRESSURE_PLATE.get(), null);
        registerStoneVariant("light_metal_floor", ECBlockRegistry.LIGHT_METAL_FLOOR.get(), ECBlockRegistry.LIGHT_METAL_FLOOR_SLAB.get(), ECBlockRegistry.LIGHT_METAL_FLOOR_STAIRS.get(),
            ECBlockRegistry.LIGHT_METAL_FLOOR_WALL.get(), ECBlockRegistry.LIGHT_METAL_FLOOR_PRESSURE_PLATE.get(), null);
        registerStoneVariant("rusty_plate", ECBlockRegistry.RUSTY_PLATE.get(), ECBlockRegistry.RUSTY_PLATE_SLAB.get(), ECBlockRegistry.RUSTY_PLATE_STAIRS.get(), ECBlockRegistry.RUSTY_PLATE_WALL.get(),
            ECBlockRegistry.RUSTY_PLATE_PRESSURE_PLATE.get(), null);

        axisBlock(ECBlockRegistry.IRON_BEAM.get(), modLoc("block/iron_beam"), modLoc("block/iron_beam_junction"));
        axisBlock(ECBlockRegistry.BOLTED_IRON_BEAM.get(), modLoc("block/bolted_iron_beam"), modLoc("block/iron_beam_junction"));
        simpleBlock(ECBlockRegistry.IRON_BEAM_JUNCTION.get());

        axisBlock(ECBlockRegistry.STEEL_BEAM.get(), modLoc("block/steel_beam"), modLoc("block/steel_beam_junction"));
        axisBlock(ECBlockRegistry.BOLTED_STEEL_BEAM.get(), modLoc("block/bolted_steel_beam"), modLoc("block/steel_beam_junction"));
        simpleBlock(ECBlockRegistry.STEEL_BEAM_JUNCTION.get());

        simpleBlock(ECBlockRegistry.AIR_DUCT.get());
        directionalBlock(ECBlockRegistry.VENT_AIR_DUCT.get(), new UncheckedModelFile(ECConstants.MODID + ":block/vent_air_duct"));
        directionalBlock(ECBlockRegistry.GRID_AIR_DUCT.get(), new UncheckedModelFile(ECConstants.MODID + ":block/grid_air_duct"));

        simpleBlock(ECBlockRegistry.BULKHEAD.get());
        simpleBlock(ECBlockRegistry.BULKHEAD_TOP.get());

        horizontalBlock(ECBlockRegistry.STEEL_WALL_LADDER.get(), new UncheckedModelFile(ECConstants.MODID + ":block/steel_wall_ladder"), 0);
        horizontalBlock(ECBlockRegistry.RUSTY_WALL_LADDER.get(), new UncheckedModelFile(ECConstants.MODID + ":block/rusty_wall_ladder"), 0);
        horizontalBlock(ECBlockRegistry.STEEL_RUNGS.get(), new UncheckedModelFile(ECConstants.MODID + ":block/steel_rungs"));
        horizontalBlock(ECBlockRegistry.RUSTY_RUNGS.get(), new UncheckedModelFile(ECConstants.MODID + ":block/rusty_rungs"));

        // Corrugated metal plates
        for(int j = 0; j < Arrays.stream(DyeColor.values()).count(); j++)
        {
            registerStoneVariant(DyeColor.byId(j).getName() + "_corrugated_metal_plate", ECBlockRegistry.CORRUGATED_METAL_PLATE_BLOCKS.get(DyeColor.byId(j)).get(),
                ECBlockRegistry.CORRUGATED_METAL_PLATE_SLABS.get(DyeColor.byId(j)).get(), ECBlockRegistry.CORRUGATED_METAL_PLATE_STAIRS.get(DyeColor.byId(j)).get(),
                ECBlockRegistry.CORRUGATED_METAL_PLATE_WALLS.get(DyeColor.byId(j)).get(), ECBlockRegistry.CORRUGATED_METAL_PLATE_PRESSURE_PLATES.get(DyeColor.byId(j)).get(), null);
        }

        // Wallpaper
        registerStoneVariant("white_blue_wallpaper", ECBlockRegistry.WHITE_BLUE_WALLPAPER.get(), ECBlockRegistry.WHITE_BLUE_WALLPAPER_SLAB.get(), ECBlockRegistry.WHITE_BLUE_WALLPAPER_STAIRS.get(), null, null,
            null);
        upDownBlock(ECBlockRegistry.WHITE_BLUE_WALLPAPER_PLINTH.get(), new UncheckedModelFile(ECConstants.MODID + ":block/white_blue_wallpaper_plinth"));
        registerStoneVariant("beige_flower_wallpaper", ECBlockRegistry.BEIGE_FLOWER_WALLPAPER.get(), ECBlockRegistry.BEIGE_FLOWER_WALLPAPER_SLAB.get(), ECBlockRegistry.BEIGE_FLOWER_WALLPAPER_STAIRS.get(), null,
            null, null);
        upDownBlock(ECBlockRegistry.BEIGE_FLOWER_WALLPAPER_PLINTH.get(), new UncheckedModelFile(ECConstants.MODID + ":block/beige_flower_wallpaper_plinth"));
        registerStoneVariant("beige_wallpaper", ECBlockRegistry.BEIGE_WALLPAPER.get(), ECBlockRegistry.BEIGE_WALLPAPER_SLAB.get(), ECBlockRegistry.BEIGE_WALLPAPER_STAIRS.get(), null, null, null);
        upDownBlock(ECBlockRegistry.BEIGE_WALLPAPER_PLINTH.get(), new UncheckedModelFile(ECConstants.MODID + ":block/beige_wallpaper_plinth"));
        registerStoneVariant("pink_wallpaper", ECBlockRegistry.PINK_WALLPAPER.get(), ECBlockRegistry.PINK_WALLPAPER_SLAB.get(), ECBlockRegistry.PINK_WALLPAPER_STAIRS.get(), null, null, null);
        upDownBlock(ECBlockRegistry.PINK_WALLPAPER_PLINTH.get(), new UncheckedModelFile(ECConstants.MODID + ":block/pink_wallpaper_plinth"));
        registerStoneVariant("white_green_wallpaper", ECBlockRegistry.WHITE_GREEN_WALLPAPER.get(), ECBlockRegistry.WHITE_GREEN_WALLPAPER_SLAB.get(), ECBlockRegistry.WHITE_GREEN_WALLPAPER_STAIRS.get(), null,
            null, null);
        upDownBlock(ECBlockRegistry.WHITE_GREEN_WALLPAPER_PLINTH.get(), new UncheckedModelFile(ECConstants.MODID + ":block/white_green_wallpaper_plinth"));
    }

    /**
     * Creates a blockstate file for blocks that have 4 orientations depeding of cardinal (north, south etc). e.g. chairs, suspended stairs...
     */
    protected void orientableBlock(Block block, ModelFile model, int angleOffset)
    {
        orientableBlock(block, $ -> model, angleOffset);
    }

    protected void orientableBlock(Block block, Function<BlockState, ModelFile> modelFunc, int angleOffset)
    {
        getVariantBuilder(block).forAllStatesExcept(
            state -> ConfiguredModel.builder().modelFile(modelFunc.apply(state)).rotationY(((int)state.get(BlockStateProperties.HORIZONTAL_FACING).getHorizontalAngle() + angleOffset) % 360).build(),
            BlockStateProperties.WATERLOGGED);
    }

    /**
     * Creates a blockstate file for the modular table blocks (normal and fancy)
     */
    protected void tableBlock(Block block)
    {
        String name = block.getRegistryName().toString().replace("embellishcraft-bop:", "");
        MultiPartBlockStateBuilder builder = getMultipartBuilder(block).part().modelFile(new UncheckedModelFile(ECConstants.MODID + ":block/" + name + "_top")).addModel().end();
        builder.part().modelFile(new UncheckedModelFile(ECConstants.MODID + ":block/" + name + "_foot")).uvLock(true).addModel().condition(TableBlock.TABLE_NORTH, true).end();
        builder.part().modelFile(new UncheckedModelFile(ECConstants.MODID + ":block/" + name + "_foot")).rotationY(90).uvLock(true).addModel().condition(TableBlock.TABLE_EAST, true).end();
        builder.part().modelFile(new UncheckedModelFile(ECConstants.MODID + ":block/" + name + "_foot")).rotationY(180).uvLock(true).addModel().condition(TableBlock.TABLE_SOUTH, true).end();
        builder.part().modelFile(new UncheckedModelFile(ECConstants.MODID + ":block/" + name + "_foot")).rotationY(270).uvLock(true).addModel().condition(TableBlock.TABLE_WEST, true).end();
    }
}