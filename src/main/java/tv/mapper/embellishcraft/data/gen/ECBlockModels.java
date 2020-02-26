package tv.mapper.embellishcraft.data.gen;

import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.client.model.generators.ExistingFileHelper;

public class ECBlockModels extends BlockModelProvider
{
    public ECBlockModels(DataGenerator generator, String modid, ExistingFileHelper existingFileHelper)
    {
        super(generator, modid, existingFileHelper);
    }

    @Override
    public String getName()
    {
        return "EmbellishCraft Block Models";
    }

    @Override
    protected void registerModels()
    {
        buildAllStone("basalt");
        buildAllStone("slate");
        buildAllStone("marble");
        buildAllStone("gneiss");
        buildAllStone("jade");
        buildAllStone("larvikite");

        buildMcStone("andesite");
        buildMcStone("diorite");
        buildMcStone("granite");

        buildMcSandstone("sandstone");
        buildMcSandstone("red_sandstone");

        // Terracotta
        buildWall("terracotta", mcLoc("block/terracotta"));
        buildWall("polished_terracotta", modLoc("block/polished_terracotta"));
        buildWall("terracotta_paving", modLoc("block/terracotta_paving"));
        buildWall("terracotta_tiles", modLoc("block/terracotta_tiles"));
        buildWall("terracotta_bricks", modLoc("block/terracotta_bricks"));
        buildWall("terracotta_large_bricks", modLoc("block/terracotta_large_bricks"));
        buildButton("terracotta", mcLoc("block/terracotta"));

        buildPressure("terracotta", mcLoc("block/terracotta"));
        buildPressure("polished_terracotta", modLoc("block/polished_terracotta"));
        buildPressure("terracotta_paving", modLoc("block/terracotta_paving"));
        buildPressure("terracotta_tiles", modLoc("block/terracotta_tiles"));
        buildPressure("terracotta_bricks", modLoc("block/terracotta_bricks"));
        buildPressure("terracotta_large_bricks", modLoc("block/terracotta_large_bricks"));

        // Other bricks
        buildWall("dark_bricks", modLoc("block/dark_bricks"));
        buildWall("old_bricks", modLoc("block/old_bricks"));
        buildWall("weared_bricks", modLoc("block/weared_bricks"));
        buildPressure("dark_bricks", modLoc("block/dark_bricks"));
        buildPressure("old_bricks", modLoc("block/old_bricks"));
        buildPressure("weared_bricks", modLoc("block/weared_bricks"));

        buildWall("dark_large_bricks", modLoc("block/dark_large_bricks"));
        buildWall("old_large_bricks", modLoc("block/old_large_bricks"));
        buildWall("weared_large_bricks", modLoc("block/weared_large_bricks"));
        buildPressure("dark_large_bricks", modLoc("block/dark_large_bricks"));
        buildPressure("old_large_bricks", modLoc("block/old_large_bricks"));
        buildPressure("weared_large_bricks", modLoc("block/weared_large_bricks"));

        // Pavings
        buildWall("concrete_paving", modLoc("block/concrete_paving"));
        buildWall("damaged_paving", modLoc("block/damaged_paving"));
        buildWall("dark_concrete_paving", modLoc("block/dark_concrete_paving"));
        buildWall("moist_paving", modLoc("block/moist_paving"));
        buildWall("polished_paving", modLoc("block/polished_paving"));
        buildWall("white_concrete_paving", modLoc("block/white_concrete_paving"));
        buildPressure("concrete_paving", modLoc("block/concrete_paving"));
        buildPressure("damaged_paving", modLoc("block/damaged_paving"));
        buildPressure("dark_concrete_paving", modLoc("block/dark_concrete_paving"));
        buildPressure("moist_paving", modLoc("block/moist_paving"));
        buildPressure("polished_paving", modLoc("block/polished_paving"));
        buildPressure("white_concrete_paving", modLoc("block/white_concrete_paving"));

        // Tiles
        buildWall("concrete_tiles", modLoc("block/concrete_tiles"));
        buildWall("skyblue_tiles", modLoc("block/skyblue_tiles"));
        buildWall("orange_tiles", modLoc("block/orange_tiles"));
        buildWall("blue_tiles", modLoc("block/blue_tiles"));
        buildWall("light_blue_tiles", modLoc("block/light_blue_tiles"));
        buildWall("red_tiles", modLoc("block/red_tiles"));
        buildWall("white_tiles", modLoc("block/white_tiles"));
        buildWall("yellow_tiles", modLoc("block/yellow_tiles"));
        buildWall("yellow_grey_tiles", modLoc("block/yellow_grey_tiles"));
        buildPressure("concrete_tiles", modLoc("block/concrete_tiles"));
        buildPressure("skyblue_tiles", modLoc("block/skyblue_tiles"));
        buildPressure("orange_tiles", modLoc("block/orange_tiles"));
        buildPressure("blue_tiles", modLoc("block/blue_tiles"));
        buildPressure("light_blue_tiles", modLoc("block/light_blue_tiles"));
        buildPressure("red_tiles", modLoc("block/red_tiles"));
        buildPressure("white_tiles", modLoc("block/white_tiles"));
        buildPressure("yellow_tiles", modLoc("block/yellow_tiles"));
        buildPressure("yellow_grey_tiles", modLoc("block/yellow_grey_tiles"));

        // Corrugated metal plates
        buildWall("black_corrugated_metal_plate", modLoc("block/black_corrugated_metal_plate"));
        buildWall("blue_corrugated_metal_plate", modLoc("block/blue_corrugated_metal_plate"));
        buildWall("brown_corrugated_metal_plate", modLoc("block/brown_corrugated_metal_plate"));
        buildWall("cyan_corrugated_metal_plate", modLoc("block/cyan_corrugated_metal_plate"));
        buildWall("gray_corrugated_metal_plate", modLoc("block/gray_corrugated_metal_plate"));
        buildWall("green_corrugated_metal_plate", modLoc("block/green_corrugated_metal_plate"));
        buildWall("light_blue_corrugated_metal_plate", modLoc("block/light_blue_corrugated_metal_plate"));
        buildWall("light_gray_corrugated_metal_plate", modLoc("block/light_gray_corrugated_metal_plate"));
        buildWall("lime_corrugated_metal_plate", modLoc("block/lime_corrugated_metal_plate"));
        buildWall("magenta_corrugated_metal_plate", modLoc("block/magenta_corrugated_metal_plate"));
        buildWall("orange_corrugated_metal_plate", modLoc("block/orange_corrugated_metal_plate"));
        buildWall("pink_corrugated_metal_plate", modLoc("block/pink_corrugated_metal_plate"));
        buildWall("purple_corrugated_metal_plate", modLoc("block/purple_corrugated_metal_plate"));
        buildWall("red_corrugated_metal_plate", modLoc("block/red_corrugated_metal_plate"));
        buildWall("white_corrugated_metal_plate", modLoc("block/white_corrugated_metal_plate"));
        buildWall("yellow_corrugated_metal_plate", modLoc("block/yellow_corrugated_metal_plate"));

        buildPressure("black_corrugated_metal_plate", modLoc("block/black_corrugated_metal_plate"));
        buildPressure("blue_corrugated_metal_plate", modLoc("block/blue_corrugated_metal_plate"));
        buildPressure("brown_corrugated_metal_plate", modLoc("block/brown_corrugated_metal_plate"));
        buildPressure("cyan_corrugated_metal_plate", modLoc("block/cyan_corrugated_metal_plate"));
        buildPressure("gray_corrugated_metal_plate", modLoc("block/gray_corrugated_metal_plate"));
        buildPressure("green_corrugated_metal_plate", modLoc("block/green_corrugated_metal_plate"));
        buildPressure("light_blue_corrugated_metal_plate", modLoc("block/light_blue_corrugated_metal_plate"));
        buildPressure("light_gray_corrugated_metal_plate", modLoc("block/light_gray_corrugated_metal_plate"));
        buildPressure("lime_corrugated_metal_plate", modLoc("block/lime_corrugated_metal_plate"));
        buildPressure("magenta_corrugated_metal_plate", modLoc("block/magenta_corrugated_metal_plate"));
        buildPressure("orange_corrugated_metal_plate", modLoc("block/orange_corrugated_metal_plate"));
        buildPressure("pink_corrugated_metal_plate", modLoc("block/pink_corrugated_metal_plate"));
        buildPressure("purple_corrugated_metal_plate", modLoc("block/purple_corrugated_metal_plate"));
        buildPressure("red_corrugated_metal_plate", modLoc("block/red_corrugated_metal_plate"));
        buildPressure("white_corrugated_metal_plate", modLoc("block/white_corrugated_metal_plate"));
        buildPressure("yellow_corrugated_metal_plate", modLoc("block/yellow_corrugated_metal_plate"));

        // Wallpaper
        buildWallpaper("white_blue_wallpaper", modLoc("block/white_blue_wallpaper"), modLoc("block/side_wallpaper"), modLoc("block/white_blue_wallpaper_plinth"));
        buildWallpaper("beige_flower_wallpaper", modLoc("block/beige_flower_wallpaper"), modLoc("block/side_wallpaper"), modLoc("block/beige_flower_wallpaper_plinth"));
        buildWallpaper("beige_wallpaper", modLoc("block/beige_wallpaper"), modLoc("block/side_wallpaper"), modLoc("block/beige_wallpaper_plinth"));
        buildWallpaper("pink_wallpaper", modLoc("block/pink_wallpaper"), modLoc("block/side_wallpaper"), modLoc("block/pink_wallpaper_plinth"));
        buildWallpaper("white_green_wallpaper", modLoc("block/white_green_wallpaper"), modLoc("block/side_wallpaper"), modLoc("block/white_green_wallpaper_plinth"));
    }

    private void buildWallpaper(String name, ResourceLocation side, ResourceLocation bottom, ResourceLocation plinth)
    {
        cubeColumn(name, side, bottom);
        stairs(name + "_stairs", side, bottom, side);
        stairsInner(name + "_stairs_inner", side, bottom, side);
        stairsOuter(name + "_stairs_outer", side, bottom, side);
        slab(name + "_slab", side, bottom, side);
        slabTop(name + "_slab_top", side, bottom, side);
        getBuilder(name + "_plinth").parent(getExistingFile(mcLoc("block/cube_column"))).texture("side", plinth).texture("end", bottom);
    }

    private void buildWall(String name, ResourceLocation texture)
    {
        getBuilder(name + "_wall_inventory").parent(getExistingFile(mcLoc("block/wall_inventory"))).texture("wall", texture);
    }

    private void buildPressure(String name, ResourceLocation texture)
    {
        getBuilder(name + "_pressure_plate").parent(getExistingFile(mcLoc("block/pressure_plate_up"))).texture("texture", texture);
        getBuilder(name + "_pressure_plate_down").parent(getExistingFile(mcLoc("block/pressure_plate_down"))).texture("texture", texture);
    }

    private void buildButton(String name, ResourceLocation texture)
    {
        getBuilder(name + "_button_inventory").parent(getExistingFile(mcLoc("block/button_inventory"))).texture("texture", texture);
        getBuilder(name + "_button_pressed").parent(getExistingFile(mcLoc("block/button_pressed"))).texture("texture", texture);
        getBuilder(name + "_button").parent(getExistingFile(mcLoc("block/button"))).texture("texture", texture);
    }

    private void buildAllStoneWall(String name)
    {
        buildWall(name, modLoc("block/" + name));
        buildWall(name + "_cobblestone", modLoc("block/" + name + "_cobblestone"));
        buildWall("smooth_" + name, modLoc("block/smooth_" + name));
        buildWall("polished_" + name, modLoc("block/polished_" + name));
        buildWall(name + "_paving", modLoc("block/" + name + "_paving"));
        buildWall(name + "_tiles", modLoc("block/" + name + "_tiles"));
        buildWall(name + "_bricks", modLoc("block/" + name + "_bricks"));
        buildWall(name + "_large_bricks", modLoc("block/" + name + "_large_bricks"));
    }

    private void buildAllStonePressure(String name)
    {
        buildPressure(name, modLoc("block/" + name));
        buildPressure(name + "_cobblestone", modLoc("block/" + name + "_cobblestone"));
        buildPressure("smooth_" + name, modLoc("block/smooth_" + name));
        buildPressure("polished_" + name, modLoc("block/polished_" + name));
        buildPressure(name + "_paving", modLoc("block/" + name + "_paving"));
        buildPressure(name + "_tiles", modLoc("block/" + name + "_tiles"));
        buildPressure(name + "_bricks", modLoc("block/" + name + "_bricks"));
        buildPressure(name + "_large_bricks", modLoc("block/" + name + "_large_bricks"));
        buildPressure(name + "_ornament", modLoc("block/" + name + "_ornament"));
    }

    private void buildAllStone(String name)
    {
        buildAllStoneWall(name);
        buildAllStonePressure(name);
        buildButton(name, modLoc("block/" + name));
    }

    private void buildMcStone(String name)
    {
        buildWall("smooth_" + name, modLoc("block/smooth_" + name));
        buildPressure("smooth_" + name, modLoc("block/smooth_" + name));
        buildButton(name, mcLoc("block/" + name));

        buildWall(name + "_paving", modLoc("block/" + name + "_paving"));
        buildPressure(name + "_paving", modLoc("block/" + name + "_paving"));

        buildWall(name + "_tiles", modLoc("block/" + name + "_tiles"));
        buildPressure(name + "_tiles", modLoc("block/" + name + "_tiles"));

        buildWall(name + "_bricks", modLoc("block/" + name + "_bricks"));
        buildPressure(name + "_bricks", modLoc("block/" + name + "_bricks"));

        buildWall(name + "_large_bricks", modLoc("block/" + name + "_large_bricks"));
        buildPressure(name + "_large_bricks", modLoc("block/" + name + "_large_bricks"));

        buildPressure(name + "_ornament", modLoc("block/" + name + "_ornament"));
    }

    private void buildMcSandstone(String name)
    {
        buildButton(name, mcLoc("block/" + name));

        buildWall("smooth_" + name, mcLoc("block/" + name + "_top"));
        buildPressure("smooth_" + name, mcLoc("block/" + name + "_top"));

        buildWall("polished_" + name, modLoc("block/polished_" + name));
        buildPressure("polished_" + name, modLoc("block/polished_" + name));

        buildWall(name + "_paving", modLoc("block/" + name + "_paving"));
        buildPressure(name + "_paving", modLoc("block/" + name + "_paving"));

        buildWall(name + "_tiles", modLoc("block/" + name + "_tiles"));
        buildPressure(name + "_tiles", modLoc("block/" + name + "_tiles"));

        buildWall(name + "_bricks", modLoc("block/" + name + "_bricks"));
        buildPressure(name + "_bricks", modLoc("block/" + name + "_bricks"));

        buildWall(name + "_large_bricks", modLoc("block/" + name + "_large_bricks"));
        buildPressure(name + "_large_bricks", modLoc("block/" + name + "_large_bricks"));
    }
}
