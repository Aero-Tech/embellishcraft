package tv.mapper.embellishcraft.furniture.data.gen;

import net.minecraft.core.Direction;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.block.state.properties.ChestType;
import net.minecraft.world.level.block.state.properties.StairsShape;
import net.minecraftforge.client.model.generators.ModelFile.UncheckedModelFile;
import net.minecraftforge.client.model.generators.MultiPartBlockStateBuilder;
import net.minecraftforge.client.model.generators.VariantBlockStateBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import tv.mapper.embellishcraft.core.data.gen.ECBlockStates;
import tv.mapper.embellishcraft.core.util.McWoods;
import tv.mapper.embellishcraft.furniture.world.level.block.CouchBlock;
import tv.mapper.embellishcraft.furniture.world.level.block.InitFurnitureBlocks;
import tv.mapper.embellishcraft.furniture.world.level.block.PlateBlock;
import tv.mapper.embellishcraft.furniture.world.level.block.TableBlock;

import java.util.Objects;

public class FurnitureBlockStates extends ECBlockStates
{
    public FurnitureBlockStates(DataGenerator gen, String modid, ExistingFileHelper exFileHelper)
    {
        super(gen, modid, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels()
    {
        // Furniture
        for(int j = 0; j < McWoods.values().length; j++)
        {
            horizontalBlock(InitFurnitureBlocks.CHAIR_BLOCKS.get(McWoods.byId(j)).get(), new UncheckedModelFile(mod_id + ":block/" + McWoods.byId(j).getSerializedName() + "_chair"), 0);
            horizontalBlock(InitFurnitureBlocks.TERRACE_CHAIR_BLOCKS.get(McWoods.byId(j)).get(), new UncheckedModelFile(mod_id + ":block/" + McWoods.byId(j).getSerializedName() + "_terrace_chair"), 0);
            tableBlock(InitFurnitureBlocks.TABLE_BLOCKS.get(McWoods.byId(j)).get());
            tableBlock(InitFurnitureBlocks.FANCY_TABLE_BLOCKS.get(McWoods.byId(j)).get());
            simpleBlock(InitFurnitureBlocks.TERRACE_TABLE_BLOCKS.get(McWoods.byId(j)).get());
            simpleBlock(InitFurnitureBlocks.WOODEN_CRATE_BLOCKS.get(McWoods.byId(j)).get());
            // getVariantBuilder(InitFurnitureBlocks.FANCY_CHEST_BLOCKS.get(McWoods.byId(j)).get()).partialState().setModels(
            // new ConfiguredModel(new UncheckedModelFile(mod_id + ":model/" + McWoods.byId(j).getString() + "_fancy_chest")));
            // chestBlock(InitFurnitureBlocks.FANCY_CHEST_BLOCKS.get(McWoods.byId(j)).get(), 0);
        }
        // verticalChestBlock(InitFurnitureBlocks.LOCKER.get(), 0);

        simpleBlock(InitFurnitureBlocks.STEEL_TERRACE_TABLE.get());
        horizontalBlock(InitFurnitureBlocks.STEEL_TERRACE_CHAIR.get(), new UncheckedModelFile(mod_id + ":block/steel_terrace_chair"), 0);

        for(int j = 0; j < DyeColor.values().length; j++)
        {
            couchBlock(InitFurnitureBlocks.COUCH_BLOCKS.get(DyeColor.byId(j)).get(), 90);
            horizontalBlock(InitFurnitureBlocks.PILLOW_BLOCKS.get(DyeColor.byId(j)).get(), new UncheckedModelFile(mod_id + ":block/" + DyeColor.byId(j).getSerializedName() + "_pillow"), 0);
            bedBlock(InitFurnitureBlocks.OAK_FANCY_BED_BLOCKS.get(DyeColor.byId(j)).get(), 180);
            bedBlock(InitFurnitureBlocks.BIRCH_FANCY_BED_BLOCKS.get(DyeColor.byId(j)).get(), 180);
            bedBlock(InitFurnitureBlocks.SPRUCE_FANCY_BED_BLOCKS.get(DyeColor.byId(j)).get(), 180);
            bedBlock(InitFurnitureBlocks.JUNGLE_FANCY_BED_BLOCKS.get(DyeColor.byId(j)).get(), 180);
            bedBlock(InitFurnitureBlocks.DARK_OAK_FANCY_BED_BLOCKS.get(DyeColor.byId(j)).get(), 180);
            bedBlock(InitFurnitureBlocks.ACACIA_FANCY_BED_BLOCKS.get(DyeColor.byId(j)).get(), 180);
            bedBlock(InitFurnitureBlocks.WARPED_FANCY_BED_BLOCKS.get(DyeColor.byId(j)).get(), 180);
            bedBlock(InitFurnitureBlocks.CRIMSON_FANCY_BED_BLOCKS.get(DyeColor.byId(j)).get(), 180);
        }

        plateBlock(InitFurnitureBlocks.PLATE.get());
    }

    private void plateBlock(Block block)
    {
        VariantBlockStateBuilder builder = getVariantBuilder(block);
        for(int i = 1; i < 9; i++)
            builder.partialState().with(PlateBlock.PLATES, i).modelForState().modelFile(new UncheckedModelFile(mod_id + ":block/plate_" + i)).addModel();
    }

    /**
     * Creates a blockstate file for the modular table blocks (normal and fancy)
     */
    private void tableBlock(Block block)
    {
        String name = Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block)).getPath();
        MultiPartBlockStateBuilder builder = getMultipartBuilder(block).part().modelFile(new UncheckedModelFile(mod_id + ":block/" + name + "_top")).addModel().end();
        builder.part().modelFile(new UncheckedModelFile(mod_id + ":block/" + name + "_foot")).uvLock(true).addModel().condition(TableBlock.TABLE_NORTH, true).end();
        builder.part().modelFile(new UncheckedModelFile(mod_id + ":block/" + name + "_foot")).rotationY(90).uvLock(true).addModel().condition(TableBlock.TABLE_EAST, true).end();
        builder.part().modelFile(new UncheckedModelFile(mod_id + ":block/" + name + "_foot")).rotationY(180).uvLock(true).addModel().condition(TableBlock.TABLE_SOUTH, true).end();
        builder.part().modelFile(new UncheckedModelFile(mod_id + ":block/" + name + "_foot")).rotationY(270).uvLock(true).addModel().condition(TableBlock.TABLE_WEST, true).end();
    }

    @SuppressWarnings("unused")
    private void couchBlock(CouchBlock block)
    {
        couchBlock(block, 0);
    }

    private void couchBlock(CouchBlock block, int offset)
    {
        String name = Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block)).getPath();
        MultiPartBlockStateBuilder builder = getMultipartBuilder(block);

        for(Direction dir : Direction.Plane.HORIZONTAL)
        {
            builder.part().modelFile(new UncheckedModelFile(mod_id + ":block/" + name + "_left")).rotationY(((int)(dir.toYRot() + offset) % 360)).uvLock(true).addModel().condition(CouchBlock.FACING, dir).condition(CouchBlock.LEFT_END, true).end();
            builder.part().modelFile(new UncheckedModelFile(mod_id + ":block/" + name + "_right")).rotationY(((int)(dir.toYRot() + offset) % 360)).uvLock(true).addModel().condition(CouchBlock.FACING, dir).condition(CouchBlock.RIGHT_END, true).end();

            builder.part().modelFile(new UncheckedModelFile(mod_id + ":block/" + name)).rotationY(((int)(dir.toYRot() + offset) % 360)).uvLock(true).addModel().condition(CouchBlock.FACING, dir).condition(CouchBlock.SHAPE, StairsShape.STRAIGHT).end();

            builder.part().modelFile(new UncheckedModelFile(mod_id + ":block/outer_" + name)).rotationY(((int)(dir.toYRot() + 270 + offset) % 360)).uvLock(true).addModel().condition(CouchBlock.FACING, dir).condition(CouchBlock.SHAPE, StairsShape.OUTER_LEFT).end();
            builder.part().modelFile(new UncheckedModelFile(mod_id + ":block/inner_" + name)).rotationY(((int)(dir.toYRot() + offset) % 360)).uvLock(true).addModel().condition(CouchBlock.FACING, dir).condition(CouchBlock.SHAPE, StairsShape.INNER_LEFT).end();

            builder.part().modelFile(new UncheckedModelFile(mod_id + ":block/outer_" + name)).rotationY(((int)(dir.toYRot() + offset) % 360)).uvLock(true).addModel().condition(CouchBlock.FACING, dir).condition(CouchBlock.SHAPE, StairsShape.OUTER_RIGHT).end();
            builder.part().modelFile(new UncheckedModelFile(mod_id + ":block/inner_" + name)).rotationY(((int)(dir.toYRot() + 90 + offset) % 360)).uvLock(true).addModel().condition(CouchBlock.FACING, dir).condition(CouchBlock.SHAPE, StairsShape.INNER_RIGHT).end();
        }
    }

    private void bedBlock(BedBlock block, int offset)
    {
        String name = Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block)).getPath();
        VariantBlockStateBuilder builder = getVariantBuilder(block);
        String model;

        for(Direction dir : Direction.Plane.HORIZONTAL)
        {
            for(BedPart type : BedPart.values())
            {
                model = type == BedPart.HEAD ? mod_id + ":block/" + name + "_head" : mod_id + ":block/" + name + "_foot";

                builder.partialState().with(BedBlock.PART, type).with(ChestBlock.FACING, dir).modelForState().modelFile(new UncheckedModelFile(model)).rotationY((int)((dir.toYRot() + offset) % 360)).addModel();
            }
        }
    }

    @SuppressWarnings("unused")
    private void chestBlock(ChestBlock block, int offset)
    {
        String name = Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block)).getPath();
        VariantBlockStateBuilder builder = getVariantBuilder(block);
        String model;

        for(Direction dir : Direction.Plane.HORIZONTAL)
        {
            for(ChestType type : ChestType.BY_ID)
            {
                model = type == ChestType.SINGLE ? mod_id + ":block/" + name : type == ChestType.LEFT ? mod_id + ":block/" + name + "_left" : mod_id + ":block/" + name + "_right";

                builder.partialState().with(ChestBlock.TYPE, type).with(ChestBlock.FACING, dir).modelForState().modelFile(new UncheckedModelFile(model)).rotationY((int)((dir.toYRot() + offset) % 360)).addModel();
            }
        }
    }

//    private void verticalChestBlock(VerticalChestBlock block, int offset)
//    {
//        String raw[] = block.getRegistryName().toString().split(":");
//        String name = raw[1];
//        VariantBlockStateBuilder builder = getVariantBuilder(block);
//        String model;
//
//        for(Direction dir : Direction.Plane.HORIZONTAL)
//        {
//            for(VerticalChestType type : VerticalChestType.VALUES)
//            {
//                model = type == VerticalChestType.SINGLE ? mod_id + ":block/" + name + "_small" : type == VerticalChestType.TOP ? mod_id + ":block/" + name + "_top" : mod_id + ":block/" + name + "_bottom";
//
//                builder.partialState().with(VerticalChestBlock.TYPE, type).with(ChestBlock.FACING, dir).modelForState().modelFile(new UncheckedModelFile(model)).rotationY((int)((dir.toYRot() + offset) % 360)).addModel();
//            }
//        }
//    }
}