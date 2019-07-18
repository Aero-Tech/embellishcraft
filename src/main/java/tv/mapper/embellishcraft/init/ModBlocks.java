package tv.mapper.embellishcraft.init;

import net.minecraft.block.Block;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.WallBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;
import tv.mapper.embellishcraft.Constants;
import tv.mapper.embellishcraft.block.ChairBlock;
import tv.mapper.embellishcraft.block.CustomPressurePlateBlock;
import tv.mapper.embellishcraft.block.CustomStairsBlock;
import tv.mapper.embellishcraft.block.TerraceChairBlock;
import tv.mapper.embellishcraft.block.TerraceTableBlock;
import tv.mapper.embellishcraft.block.UpDownBlock;
import tv.mapper.embellishcraft.item.FuelBlockItem;
import tv.mapper.embellishcraft.item.ModItemGroups;

@ObjectHolder(Constants.MODID)
@EventBusSubscriber(bus = Bus.MOD)
public class ModBlocks
{
    // World (blocks that generate in the world)

    public static final Block BASALT = null;
    public static final Block BASALT_STAIRS = null;
    public static final Block BASALT_SLAB = null;
    public static final Block BASALT_WALL = null;
    public static final Block BASALT_PRESSURE_PLATE = null;

    public static final Block SLATE = null;
    public static final Block SLATE_STAIRS = null;
    public static final Block SLATE_SLAB = null;
    public static final Block SLATE_WALL = null;
    public static final Block SLATE_PRESSURE_PLATE = null;

    public static final Block MARBLE = null;
    public static final Block MARBLE_STAIRS = null;
    public static final Block MARBLE_SLAB = null;
    public static final Block MARBLE_WALL = null;
    public static final Block MARBLE_PRESSURE_PLATE = null;

    public static final Block GNEISS = null;
    public static final Block GNEISS_STAIRS = null;
    public static final Block GNEISS_SLAB = null;
    public static final Block GNEISS_WALL = null;
    public static final Block GNEISS_PRESSURE_PLATE = null;

    // Cobblestones

    public static final Block BASALT_COBBLESTONE = null;
    public static final Block BASALT_COBBLESTONE_STAIRS = null;
    public static final Block BASALT_COBBLESTONE_SLAB = null;
    public static final Block BASALT_COBBLESTONE_WALL = null;
    public static final Block BASALT_COBBLESTONE_PRESSURE_PLATE = null;

    public static final Block SLATE_COBBLESTONE = null;
    public static final Block SLATE_COBBLESTONE_STAIRS = null;
    public static final Block SLATE_COBBLESTONE_SLAB = null;
    public static final Block SLATE_COBBLESTONE_WALL = null;
    public static final Block SLATE_COBBLESTONE_PRESSURE_PLATE = null;

    public static final Block MARBLE_COBBLESTONE = null;
    public static final Block MARBLE_COBBLESTONE_STAIRS = null;
    public static final Block MARBLE_COBBLESTONE_SLAB = null;
    public static final Block MARBLE_COBBLESTONE_WALL = null;
    public static final Block MARBLE_COBBLESTONE_PRESSURE_PLATE = null;

    public static final Block GNEISS_COBBLESTONE = null;
    public static final Block GNEISS_COBBLESTONE_STAIRS = null;
    public static final Block GNEISS_COBBLESTONE_SLAB = null;
    public static final Block GNEISS_COBBLESTONE_WALL = null;
    public static final Block GNEISS_COBBLESTONE_PRESSURE_PLATE = null;

    // Bricks

    public static final Block BASALT_BRICKS = null;
    public static final Block BASALT_BRICKS_STAIRS = null;
    public static final Block BASALT_BRICKS_SLAB = null;
    public static final Block BASALT_BRICKS_WALL = null;
    public static final Block BASALT_BRICKS_PRESSURE_PLATE = null;

    public static final Block DARK_BRICKS = null;
    public static final Block DARK_BRICKS_STAIRS = null;
    public static final Block DARK_BRICKS_SLAB = null;
    public static final Block DARK_BRICKS_WALL = null;
    public static final Block DARK_BRICKS_PRESSURE_PLATE = null;

    public static final Block DIORITE_BRICKS = null;
    public static final Block DIORITE_BRICKS_STAIRS = null;
    public static final Block DIORITE_BRICKS_SLAB = null;
    public static final Block DIORITE_BRICKS_WALL = null;
    public static final Block DIORITE_BRICKS_PRESSURE_PLATE = null;

    public static final Block OLD_BRICKS = null;
    public static final Block OLD_BRICKS_STAIRS = null;
    public static final Block OLD_BRICKS_SLAB = null;
    public static final Block OLD_BRICKS_WALL = null;
    public static final Block OLD_BRICKS_PRESSURE_PLATE = null;

    public static final Block SANDSTONE_BRICKS = null;
    public static final Block SANDSTONE_BRICKS_STAIRS = null;
    public static final Block SANDSTONE_BRICKS_SLAB = null;
    public static final Block SANDSTONE_BRICKS_WALL = null;
    public static final Block SANDSTONE_BRICKS_PRESSURE_PLATE = null;

    public static final Block SLATE_BRICKS = null;
    public static final Block SLATE_BRICKS_STAIRS = null;
    public static final Block SLATE_BRICKS_SLAB = null;
    public static final Block SLATE_BRICKS_WALL = null;
    public static final Block SLATE_BRICKS_PRESSURE_PLATE = null;

    public static final Block TERRACOTTA_BRICKS = null;
    public static final Block TERRACOTTA_BRICKS_STAIRS = null;
    public static final Block TERRACOTTA_BRICKS_SLAB = null;
    public static final Block TERRACOTTA_BRICKS_WALL = null;
    public static final Block TERRACOTTA_BRICKS_PRESSURE_PLATE = null;

    public static final Block WEARED_BRICKS = null;
    public static final Block WEARED_BRICKS_STAIRS = null;
    public static final Block WEARED_BRICKS_SLAB = null;
    public static final Block WEARED_BRICKS_WALL = null;
    public static final Block WEARED_BRICKS_PRESSURE_PLATE = null;

    public static final Block MARBLE_BRICKS = null;
    public static final Block MARBLE_BRICKS_STAIRS = null;
    public static final Block MARBLE_BRICKS_SLAB = null;
    public static final Block MARBLE_BRICKS_WALL = null;
    public static final Block MARBLE_BRICKS_PRESSURE_PLATE = null;

    public static final Block GNEISS_BRICKS = null;
    public static final Block GNEISS_BRICKS_STAIRS = null;
    public static final Block GNEISS_BRICKS_SLAB = null;
    public static final Block GNEISS_BRICKS_WALL = null;
    public static final Block GNEISS_BRICKS_PRESSURE_PLATE = null;

    // Large bricks

    public static final Block BASALT_LARGE_BRICKS = null;
    public static final Block BASALT_LARGE_BRICKS_STAIRS = null;
    public static final Block BASALT_LARGE_BRICKS_SLAB = null;
    public static final Block BASALT_LARGE_BRICKS_WALL = null;
    public static final Block BASALT_LARGE_BRICKS_PRESSURE_PLATE = null;

    public static final Block DIORITE_LARGE_BRICKS = null;
    public static final Block DIORITE_LARGE_BRICKS_STAIRS = null;
    public static final Block DIORITE_LARGE_BRICKS_SLAB = null;
    public static final Block DIORITE_LARGE_BRICKS_WALL = null;
    public static final Block DIORITE_LARGE_BRICKS_PRESSURE_PLATE = null;

    public static final Block DARK_LARGE_BRICKS = null;
    public static final Block DARK_LARGE_BRICKS_STAIRS = null;
    public static final Block DARK_LARGE_BRICKS_SLAB = null;
    public static final Block DARK_LARGE_BRICKS_WALL = null;
    public static final Block DARK_LARGE_BRICKS_PRESSURE_PLATE = null;

    public static final Block MARBLE_LARGE_BRICKS = null;
    public static final Block MARBLE_LARGE_BRICKS_STAIRS = null;
    public static final Block MARBLE_LARGE_BRICKS_SLAB = null;
    public static final Block MARBLE_LARGE_BRICKS_WALL = null;
    public static final Block MARBLE_LARGE_BRICKS_PRESSURE_PLATE = null;

    public static final Block OLD_LARGE_BRICKS = null;
    public static final Block OLD_LARGE_BRICKS_STAIRS = null;
    public static final Block OLD_LARGE_BRICKS_SLAB = null;
    public static final Block OLD_LARGE_BRICKS_WALL = null;
    public static final Block OLD_LARGE_BRICKS_PRESSURE_PLATE = null;

    public static final Block SANDSTONE_LARGE_BRICKS = null;
    public static final Block SANDSTONE_LARGE_BRICKS_STAIRS = null;
    public static final Block SANDSTONE_LARGE_BRICKS_SLAB = null;
    public static final Block SANDSTONE_LARGE_BRICKS_WALL = null;
    public static final Block SANDSTONE_LARGE_BRICKS_PRESSURE_PLATE = null;

    public static final Block SLATE_LARGE_BRICKS = null;
    public static final Block SLATE_LARGE_BRICKS_STAIRS = null;
    public static final Block SLATE_LARGE_BRICKS_SLAB = null;
    public static final Block SLATE_LARGE_BRICKS_WALL = null;
    public static final Block SLATE_LARGE_BRICKS_PRESSURE_PLATE = null;

    public static final Block TERRACOTTA_LARGE_BRICKS = null;
    public static final Block TERRACOTTA_LARGE_BRICKS_STAIRS = null;
    public static final Block TERRACOTTA_LARGE_BRICKS_SLAB = null;
    public static final Block TERRACOTTA_LARGE_BRICKS_WALL = null;
    public static final Block TERRACOTTA_LARGE_BRICKS_PRESSURE_PLATE = null;

    public static final Block WEARED_LARGE_BRICKS = null;
    public static final Block WEARED_LARGE_BRICKS_STAIRS = null;
    public static final Block WEARED_LARGE_BRICKS_SLAB = null;
    public static final Block WEARED_LARGE_BRICKS_WALL = null;
    public static final Block WEARED_LARGE_BRICKS_PRESSURE_PLATE = null;

    public static final Block GNEISS_LARGE_BRICKS = null;
    public static final Block GNEISS_LARGE_BRICKS_STAIRS = null;
    public static final Block GNEISS_LARGE_BRICKS_SLAB = null;
    public static final Block GNEISS_LARGE_BRICKS_WALL = null;
    public static final Block GNEISS_LARGE_BRICKS_PRESSURE_PLATE = null;

    // Paving

    public static final Block CONCRETE_PAVING = null;
    public static final Block CONCRETE_PAVING_STAIRS = null;
    public static final Block CONCRETE_PAVING_SLAB = null;
    public static final Block CONCRETE_PAVING_PRESSURE_PLATE = null;
    public static final Block CONCRETE_PAVING_WALL = null;

    public static final Block DAMAGED_PAVING = null;
    public static final Block DAMAGED_PAVING_STAIRS = null;
    public static final Block DAMAGED_PAVING_SLAB = null;
    public static final Block DAMAGED_PAVING_PRESSURE_PLATE = null;
    public static final Block DAMAGED_PAVING_WALL = null;

    public static final Block DARK_CONCRETE_PAVING = null;
    public static final Block DARK_CONCRETE_PAVING_STAIRS = null;
    public static final Block DARK_CONCRETE_PAVING_SLAB = null;
    public static final Block DARK_CONCRETE_PAVING_PRESSURE_PLATE = null;
    public static final Block DARK_CONCRETE_PAVING_WALL = null;

    public static final Block DIORITE_PAVING = null;
    public static final Block DIORITE_PAVING_STAIRS = null;
    public static final Block DIORITE_PAVING_SLAB = null;
    public static final Block DIORITE_PAVING_PRESSURE_PLATE = null;
    public static final Block DIORITE_PAVING_WALL = null;

    public static final Block MOIST_PAVING = null;
    public static final Block MOIST_PAVING_STAIRS = null;
    public static final Block MOIST_PAVING_SLAB = null;
    public static final Block MOIST_PAVING_PRESSURE_PLATE = null;
    public static final Block MOIST_PAVING_WALL = null;

    public static final Block POLISHED_PAVING = null;
    public static final Block POLISHED_PAVING_STAIRS = null;
    public static final Block POLISHED_PAVING_SLAB = null;
    public static final Block POLISHED_PAVING_PRESSURE_PLATE = null;
    public static final Block POLISHED_PAVING_WALL = null;

    public static final Block SLATE_PAVING = null;
    public static final Block SLATE_PAVING_STAIRS = null;
    public static final Block SLATE_PAVING_SLAB = null;
    public static final Block SLATE_PAVING_PRESSURE_PLATE = null;
    public static final Block SLATE_PAVING_WALL = null;

    public static final Block WHITE_CONCRETE_PAVING = null;
    public static final Block WHITE_CONCRETE_PAVING_STAIRS = null;
    public static final Block WHITE_CONCRETE_PAVING_SLAB = null;
    public static final Block WHITE_CONCRETE_PAVING_PRESSURE_PLATE = null;
    public static final Block WHITE_CONCRETE_PAVING_WALL = null;

    public static final Block GNEISS_PAVING = null;
    public static final Block GNEISS_PAVING_STAIRS = null;
    public static final Block GNEISS_PAVING_SLAB = null;
    public static final Block GNEISS_PAVING_WALL = null;
    public static final Block GNEISS_PAVING_PRESSURE_PLATE = null;

    // Tiles

    public static final Block CONCRETE_TILES = null;
    public static final Block CONCRETE_TILES_STAIRS = null;
    public static final Block CONCRETE_TILES_SLAB = null;
    public static final Block CONCRETE_TILES_PRESSURE_PLATE = null;
    public static final Block CONCRETE_TILES_WALL = null;

    public static final Block SKYBLUE_TILES = null;
    public static final Block SKYBLUE_TILES_STAIRS = null;
    public static final Block SKYBLUE_TILES_SLAB = null;
    public static final Block SKYBLUE_TILES_PRESSURE_PLATE = null;
    public static final Block SKYBLUE_TILES_WALL = null;

    public static final Block ORANGE_TILES = null;
    public static final Block ORANGE_TILES_STAIRS = null;
    public static final Block ORANGE_TILES_SLAB = null;
    public static final Block ORANGE_TILES_PRESSURE_PLATE = null;
    public static final Block ORANGE_TILES_WALL = null;

    public static final Block BLUE_TILES = null;
    public static final Block BLUE_TILES_STAIRS = null;
    public static final Block BLUE_TILES_SLAB = null;
    public static final Block BLUE_TILES_PRESSURE_PLATE = null;
    public static final Block BLUE_TILES_WALL = null;

    public static final Block LIGHT_BLUE_TILES = null;
    public static final Block LIGHT_BLUE_TILES_STAIRS = null;
    public static final Block LIGHT_BLUE_TILES_SLAB = null;
    public static final Block LIGHT_BLUE_TILES_PRESSURE_PLATE = null;
    public static final Block LIGHT_BLUE_TILES_WALL = null;

    public static final Block RED_TILES = null;
    public static final Block RED_TILES_STAIRS = null;
    public static final Block RED_TILES_SLAB = null;
    public static final Block RED_TILES_PRESSURE_PLATE = null;
    public static final Block RED_TILES_WALL = null;

    public static final Block WHITE_TILES = null;
    public static final Block WHITE_TILES_STAIRS = null;
    public static final Block WHITE_TILES_SLAB = null;
    public static final Block WHITE_TILES_PRESSURE_PLATE = null;
    public static final Block WHITE_TILES_WALL = null;

    public static final Block YELLOW_TILES = null;
    public static final Block YELLOW_TILES_STAIRS = null;
    public static final Block YELLOW_TILES_SLAB = null;
    public static final Block YELLOW_TILES_PRESSURE_PLATE = null;
    public static final Block YELLOW_TILES_WALL = null;

    public static final Block YELLOW_GREY_TILES = null;
    public static final Block YELLOW_GREY_TILES_STAIRS = null;
    public static final Block YELLOW_GREY_TILES_SLAB = null;
    public static final Block YELLOW_GREY_TILES_PRESSURE_PLATE = null;
    public static final Block YELLOW_GREY_TILES_WALL = null;

    // Wallpaper

    public static final Block WHITE_BLUE_WALLPAPER = null;
    public static final Block WHITE_BLUE_WALLPAPER_STAIRS = null;
    public static final Block WHITE_BLUE_WALLPAPER_SLAB = null;
    public static final Block WHITE_BLUE_WALLPAPER_PLINTH = null;

    public static final Block BEIGE_WALLPAPER = null;
    public static final Block BEIGE_WALLPAPER_STAIRS = null;
    public static final Block BEIGE_WALLPAPER_SLAB = null;
    public static final Block BEIGE_WALLPAPER_PLINTH = null;

    public static final Block PINK_WALLPAPER = null;
    public static final Block PINK_WALLPAPER_STAIRS = null;
    public static final Block PINK_WALLPAPER_SLAB = null;
    public static final Block PINK_WALLPAPER_PLINTH = null;

    public static final Block BEIGE_FLOWER_WALLPAPER = null;
    public static final Block BEIGE_FLOWER_WALLPAPER_STAIRS = null;
    public static final Block BEIGE_FLOWER_WALLPAPER_SLAB = null;
    public static final Block BEIGE_FLOWER_WALLPAPER_PLINTH = null;

    public static final Block WHITE_GREEN_WALLPAPER = null;
    public static final Block WHITE_GREEN_WALLPAPER_STAIRS = null;
    public static final Block WHITE_GREEN_WALLPAPER_SLAB = null;
    public static final Block WHITE_GREEN_WALLPAPER_PLINTH = null;

    // Furniture

    public static final Block OAK_CHAIR = null;
    public static final Block DARK_OAK_CHAIR = null;
    public static final Block BIRCH_CHAIR = null;
    public static final Block JUNGLE_CHAIR = null;
    public static final Block SPRUCE_CHAIR = null;
    public static final Block ACACIA_CHAIR = null;

    public static final Block METALLIC_TERRACE_TABLE = null;
    public static final Block OAK_TERRACE_TABLE = null;
    public static final Block BIRCH_TERRACE_TABLE = null;
    public static final Block SPRUCE_TERRACE_TABLE = null;
    public static final Block JUNGLE_TERRACE_TABLE = null;
    public static final Block DARK_OAK_TERRACE_TABLE = null;
    public static final Block ACACIA_TERRACE_TABLE = null;

    public static final Block METALLIC_TERRACE_CHAIR = null;
    public static final Block OAK_TERRACE_CHAIR = null;
    public static final Block DARK_OAK_TERRACE_CHAIR = null;
    public static final Block BIRCH_TERRACE_CHAIR = null;
    public static final Block SPRUCE_TERRACE_CHAIR = null;
    public static final Block JUNGLE_TERRACE_CHAIR = null;
    public static final Block ACACIA_TERRACE_CHAIR = null;

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
        // World

        createBlockWithVariants(event, "basalt", true, true, true, true);
        createBlockWithVariants(event, "slate", true, true, true, true);
        createBlockWithVariants(event, "marble", true, true, true, true);
        createBlockWithVariants(event, "gneiss", true, true, true, true);

        // Cobblestones

        createBlockWithVariants(event, "basalt_cobblestone", true, true, true, true);
        createBlockWithVariants(event, "slate_cobblestone", true, true, true, true);
        createBlockWithVariants(event, "marble_cobblestone", true, true, true, true);
        createBlockWithVariants(event, "gneiss_cobblestone", true, true, true, true);

        // Bricks

        createBlockWithVariants(event, "basalt_bricks", true, true, true, true);
        createBlockWithVariants(event, "dark_bricks", true, true, true, true);
        createBlockWithVariants(event, "diorite_bricks", true, true, true, true);
        createBlockWithVariants(event, "old_bricks", true, true, true, true);
        createBlockWithVariants(event, "sandstone_bricks", true, true, true, true);
        createBlockWithVariants(event, "slate_bricks", true, true, true, true);
        createBlockWithVariants(event, "terracotta_bricks", true, true, true, true);
        createBlockWithVariants(event, "weared_bricks", true, true, true, true);
        createBlockWithVariants(event, "marble_bricks", true, true, true, true);
        createBlockWithVariants(event, "gneiss_bricks", true, true, true, true);

        // Large bricks

        createBlockWithVariants(event, "basalt_large_bricks", true, true, true, true);
        createBlockWithVariants(event, "diorite_large_bricks", true, true, true, true);
        createBlockWithVariants(event, "dark_large_bricks", true, true, true, true);
        createBlockWithVariants(event, "marble_large_bricks", true, true, true, true);
        createBlockWithVariants(event, "old_large_bricks", true, true, true, true);
        createBlockWithVariants(event, "sandstone_large_bricks", true, true, true, true);
        createBlockWithVariants(event, "slate_large_bricks", true, true, true, true);
        createBlockWithVariants(event, "terracotta_large_bricks", true, true, true, true);
        createBlockWithVariants(event, "weared_large_bricks", true, true, true, true);
        createBlockWithVariants(event, "gneiss_large_bricks", true, true, true, true);

        // Paving

        createBlockWithVariants(event, "concrete_paving", true, true, true, true);
        createBlockWithVariants(event, "damaged_paving", true, true, true, true);
        createBlockWithVariants(event, "dark_concrete_paving", true, true, true, true);
        createBlockWithVariants(event, "diorite_paving", true, true, true, true);
        createBlockWithVariants(event, "moist_paving", true, true, true, true);
        createBlockWithVariants(event, "polished_paving", true, true, true, true);
        createBlockWithVariants(event, "slate_paving", true, true, true, true);
        createBlockWithVariants(event, "white_concrete_paving", true, true, true, true);
        createBlockWithVariants(event, "gneiss_paving", true, true, true, true);

        // Tiles

        createBlockWithVariants(event, "concrete_tiles", true, true, true, true);
        createBlockWithVariants(event, "skyblue_tiles", true, true, true, true);
        createBlockWithVariants(event, "orange_tiles", true, true, true, true);
        createBlockWithVariants(event, "blue_tiles", true, true, true, true);
        createBlockWithVariants(event, "light_blue_tiles", true, true, true, true);
        createBlockWithVariants(event, "red_tiles", true, true, true, true);
        createBlockWithVariants(event, "white_tiles", true, true, true, true);
        createBlockWithVariants(event, "yellow_tiles", true, true, true, true);
        createBlockWithVariants(event, "yellow_grey_tiles", true, true, true, true);

        // Wallpaper

        createBlockWithVariants(event, "white_blue_wallpaper", true, true, false, false);
        event.getRegistry().register(new UpDownBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5f)).setRegistryName("white_blue_wallpaper_plinth"));
        createBlockWithVariants(event, "beige_wallpaper", true, true, false, false);
        event.getRegistry().register(new UpDownBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5f)).setRegistryName("beige_wallpaper_plinth"));
        createBlockWithVariants(event, "pink_wallpaper", true, true, false, false);
        event.getRegistry().register(new UpDownBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5f)).setRegistryName("pink_wallpaper_plinth"));
        createBlockWithVariants(event, "beige_flower_wallpaper", true, true, false, false);
        event.getRegistry().register(new UpDownBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5f)).setRegistryName("beige_flower_wallpaper_plinth"));
        createBlockWithVariants(event, "white_green_wallpaper", true, true, false, false);
        event.getRegistry().register(new UpDownBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5f)).setRegistryName("white_green_wallpaper_plinth"));

        // Furniture

        event.getRegistry().register(new ChairBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.75F, 0.5F).sound(SoundType.WOOD)).setRegistryName("oak_chair"));
        event.getRegistry().register(new ChairBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.75F, 0.5F).sound(SoundType.WOOD)).setRegistryName("dark_oak_chair"));
        event.getRegistry().register(new ChairBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.75F, 0.5F).sound(SoundType.WOOD)).setRegistryName("birch_chair"));
        event.getRegistry().register(new ChairBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.75F, 0.5F).sound(SoundType.WOOD)).setRegistryName("jungle_chair"));
        event.getRegistry().register(new ChairBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.75F, 0.5F).sound(SoundType.WOOD)).setRegistryName("spruce_chair"));
        event.getRegistry().register(new ChairBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.75F, 0.5F).sound(SoundType.WOOD)).setRegistryName("acacia_chair"));

        event.getRegistry().register(new TerraceTableBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(0.75F, 0.5F).sound(SoundType.LANTERN)).setRegistryName("metallic_terrace_table"));
        event.getRegistry().register(new TerraceTableBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.75F, 0.5F).sound(SoundType.WOOD)).setRegistryName("oak_terrace_table"));
        event.getRegistry().register(new TerraceTableBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.75F, 0.5F).sound(SoundType.WOOD)).setRegistryName("birch_terrace_table"));
        event.getRegistry().register(new TerraceTableBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.75F, 0.5F).sound(SoundType.WOOD)).setRegistryName("spruce_terrace_table"));
        event.getRegistry().register(new TerraceTableBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.75F, 0.5F).sound(SoundType.WOOD)).setRegistryName("jungle_terrace_table"));
        event.getRegistry().register(new TerraceTableBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.75F, 0.5F).sound(SoundType.WOOD)).setRegistryName("dark_oak_terrace_table"));
        event.getRegistry().register(new TerraceTableBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.75F, 0.5F).sound(SoundType.WOOD)).setRegistryName("acacia_terrace_table"));

        event.getRegistry().register(new TerraceChairBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(0.75F, 0.5F).sound(SoundType.LANTERN)).setRegistryName("metallic_terrace_chair"));
        event.getRegistry().register(new TerraceChairBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.75F, 0.5F).sound(SoundType.WOOD)).setRegistryName("oak_terrace_chair"));
        event.getRegistry().register(new TerraceChairBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.75F, 0.5F).sound(SoundType.WOOD)).setRegistryName("dark_oak_terrace_chair"));
        event.getRegistry().register(new TerraceChairBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.75F, 0.5F).sound(SoundType.WOOD)).setRegistryName("birch_terrace_chair"));
        event.getRegistry().register(new TerraceChairBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.75F, 0.5F).sound(SoundType.WOOD)).setRegistryName("spruce_terrace_chair"));
        event.getRegistry().register(new TerraceChairBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.75F, 0.5F).sound(SoundType.WOOD)).setRegistryName("jungle_terrace_chair"));
        event.getRegistry().register(new TerraceChairBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.75F, 0.5F).sound(SoundType.WOOD)).setRegistryName("acacia_terrace_chair"));
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        // World

        createItemBlockWithVariants(event, ModItemGroups.EMBELLISHCRAFT, BASALT, BASALT_STAIRS, BASALT_SLAB, BASALT_WALL, BASALT_PRESSURE_PLATE);
        createItemBlockWithVariants(event, ModItemGroups.EMBELLISHCRAFT, SLATE, SLATE_STAIRS, SLATE_SLAB, SLATE_WALL, SLATE_PRESSURE_PLATE);
        createItemBlockWithVariants(event, ModItemGroups.EMBELLISHCRAFT, MARBLE, MARBLE_STAIRS, MARBLE_SLAB, MARBLE_WALL, MARBLE_PRESSURE_PLATE);
        createItemBlockWithVariants(event, ModItemGroups.EMBELLISHCRAFT, GNEISS, GNEISS_STAIRS, GNEISS_SLAB, GNEISS_WALL, GNEISS_PRESSURE_PLATE);

        // Cobblestones

        createItemBlockWithVariants(event, ModItemGroups.EMBELLISHCRAFT, BASALT_COBBLESTONE, BASALT_COBBLESTONE_STAIRS, BASALT_COBBLESTONE_SLAB, BASALT_COBBLESTONE_WALL, BASALT_COBBLESTONE_PRESSURE_PLATE);
        createItemBlockWithVariants(event, ModItemGroups.EMBELLISHCRAFT, SLATE_COBBLESTONE, SLATE_COBBLESTONE_STAIRS, SLATE_COBBLESTONE_SLAB, SLATE_COBBLESTONE_WALL, SLATE_COBBLESTONE_PRESSURE_PLATE);
        createItemBlockWithVariants(event, ModItemGroups.EMBELLISHCRAFT, MARBLE_COBBLESTONE, MARBLE_COBBLESTONE_STAIRS, MARBLE_COBBLESTONE_SLAB, MARBLE_COBBLESTONE_WALL, MARBLE_COBBLESTONE_PRESSURE_PLATE);
        createItemBlockWithVariants(event, ModItemGroups.EMBELLISHCRAFT, GNEISS_COBBLESTONE, GNEISS_COBBLESTONE_STAIRS, GNEISS_COBBLESTONE_SLAB, GNEISS_COBBLESTONE_WALL, GNEISS_COBBLESTONE_PRESSURE_PLATE);

        // Bricks

        createItemBlockWithVariants(event, ModItemGroups.EMBELLISHCRAFT, BASALT_BRICKS, BASALT_BRICKS_STAIRS, BASALT_BRICKS_SLAB, BASALT_BRICKS_WALL, BASALT_BRICKS_PRESSURE_PLATE);
        createItemBlockWithVariants(event, ModItemGroups.EMBELLISHCRAFT, DARK_BRICKS, DARK_BRICKS_STAIRS, DARK_BRICKS_SLAB, DARK_BRICKS_WALL, DARK_BRICKS_PRESSURE_PLATE);
        createItemBlockWithVariants(event, ModItemGroups.EMBELLISHCRAFT, DIORITE_BRICKS, DIORITE_BRICKS_STAIRS, DIORITE_BRICKS_SLAB, DIORITE_BRICKS_WALL, DIORITE_BRICKS_PRESSURE_PLATE);
        createItemBlockWithVariants(event, ModItemGroups.EMBELLISHCRAFT, OLD_BRICKS, OLD_BRICKS_STAIRS, OLD_BRICKS_SLAB, OLD_BRICKS_WALL, OLD_BRICKS_PRESSURE_PLATE);
        createItemBlockWithVariants(event, ModItemGroups.EMBELLISHCRAFT, SANDSTONE_BRICKS, SANDSTONE_BRICKS_STAIRS, SANDSTONE_BRICKS_SLAB, SANDSTONE_BRICKS_WALL, SANDSTONE_BRICKS_PRESSURE_PLATE);
        createItemBlockWithVariants(event, ModItemGroups.EMBELLISHCRAFT, SLATE_BRICKS, SLATE_BRICKS_STAIRS, SLATE_BRICKS_SLAB, SLATE_BRICKS_WALL, SLATE_BRICKS_PRESSURE_PLATE);
        createItemBlockWithVariants(event, ModItemGroups.EMBELLISHCRAFT, TERRACOTTA_BRICKS, TERRACOTTA_BRICKS_STAIRS, TERRACOTTA_BRICKS_SLAB, TERRACOTTA_BRICKS_WALL, TERRACOTTA_BRICKS_PRESSURE_PLATE);
        createItemBlockWithVariants(event, ModItemGroups.EMBELLISHCRAFT, WEARED_BRICKS, WEARED_BRICKS_STAIRS, WEARED_BRICKS_SLAB, WEARED_BRICKS_WALL, WEARED_BRICKS_PRESSURE_PLATE);
        createItemBlockWithVariants(event, ModItemGroups.EMBELLISHCRAFT, MARBLE_BRICKS, MARBLE_BRICKS_STAIRS, MARBLE_BRICKS_SLAB, MARBLE_BRICKS_WALL, MARBLE_BRICKS_PRESSURE_PLATE);
        createItemBlockWithVariants(event, ModItemGroups.EMBELLISHCRAFT, GNEISS_BRICKS, GNEISS_BRICKS_STAIRS, GNEISS_BRICKS_SLAB, GNEISS_BRICKS_WALL, GNEISS_BRICKS_PRESSURE_PLATE);

        // Large bricks

        createItemBlockWithVariants(event, ModItemGroups.EMBELLISHCRAFT, BASALT_LARGE_BRICKS, BASALT_LARGE_BRICKS_STAIRS, BASALT_LARGE_BRICKS_SLAB, BASALT_LARGE_BRICKS_WALL, BASALT_LARGE_BRICKS_PRESSURE_PLATE);
        createItemBlockWithVariants(event, ModItemGroups.EMBELLISHCRAFT, DIORITE_LARGE_BRICKS, DIORITE_LARGE_BRICKS_STAIRS, DIORITE_LARGE_BRICKS_SLAB, DIORITE_LARGE_BRICKS_WALL, DIORITE_LARGE_BRICKS_PRESSURE_PLATE);
        createItemBlockWithVariants(event, ModItemGroups.EMBELLISHCRAFT, DARK_LARGE_BRICKS, DARK_LARGE_BRICKS_STAIRS, DARK_LARGE_BRICKS_SLAB, DARK_LARGE_BRICKS_WALL, DARK_LARGE_BRICKS_PRESSURE_PLATE);
        createItemBlockWithVariants(event, ModItemGroups.EMBELLISHCRAFT, MARBLE_LARGE_BRICKS, MARBLE_LARGE_BRICKS_STAIRS, MARBLE_LARGE_BRICKS_SLAB, MARBLE_LARGE_BRICKS_WALL, MARBLE_LARGE_BRICKS_PRESSURE_PLATE);
        createItemBlockWithVariants(event, ModItemGroups.EMBELLISHCRAFT, OLD_LARGE_BRICKS, OLD_LARGE_BRICKS_STAIRS, OLD_LARGE_BRICKS_SLAB, OLD_LARGE_BRICKS_WALL, OLD_LARGE_BRICKS_PRESSURE_PLATE);
        createItemBlockWithVariants(event, ModItemGroups.EMBELLISHCRAFT, SANDSTONE_LARGE_BRICKS, SANDSTONE_LARGE_BRICKS_STAIRS, SANDSTONE_LARGE_BRICKS_SLAB, SANDSTONE_LARGE_BRICKS_WALL, SANDSTONE_LARGE_BRICKS_PRESSURE_PLATE);
        createItemBlockWithVariants(event, ModItemGroups.EMBELLISHCRAFT, SLATE_LARGE_BRICKS, SLATE_LARGE_BRICKS_STAIRS, SLATE_LARGE_BRICKS_SLAB, SLATE_LARGE_BRICKS_WALL, SLATE_LARGE_BRICKS_PRESSURE_PLATE);
        createItemBlockWithVariants(event, ModItemGroups.EMBELLISHCRAFT, TERRACOTTA_LARGE_BRICKS, TERRACOTTA_LARGE_BRICKS_STAIRS, TERRACOTTA_LARGE_BRICKS_SLAB, TERRACOTTA_LARGE_BRICKS_WALL, TERRACOTTA_LARGE_BRICKS_PRESSURE_PLATE);
        createItemBlockWithVariants(event, ModItemGroups.EMBELLISHCRAFT, WEARED_LARGE_BRICKS, WEARED_LARGE_BRICKS_STAIRS, WEARED_LARGE_BRICKS_SLAB, WEARED_LARGE_BRICKS_WALL, WEARED_LARGE_BRICKS_PRESSURE_PLATE);
        createItemBlockWithVariants(event, ModItemGroups.EMBELLISHCRAFT, GNEISS_LARGE_BRICKS, GNEISS_LARGE_BRICKS_STAIRS, GNEISS_LARGE_BRICKS_SLAB, GNEISS_LARGE_BRICKS_WALL, GNEISS_LARGE_BRICKS_PRESSURE_PLATE);

        // Paving

        createItemBlockWithVariants(event, ModItemGroups.EMBELLISHCRAFT, CONCRETE_PAVING, CONCRETE_PAVING_STAIRS, CONCRETE_PAVING_SLAB, CONCRETE_PAVING_WALL, CONCRETE_PAVING_PRESSURE_PLATE);
        createItemBlockWithVariants(event, ModItemGroups.EMBELLISHCRAFT, DAMAGED_PAVING, DAMAGED_PAVING_STAIRS, DAMAGED_PAVING_SLAB, DAMAGED_PAVING_WALL, DAMAGED_PAVING_PRESSURE_PLATE);
        createItemBlockWithVariants(event, ModItemGroups.EMBELLISHCRAFT, DARK_CONCRETE_PAVING, DARK_CONCRETE_PAVING_STAIRS, DARK_CONCRETE_PAVING_SLAB, DARK_CONCRETE_PAVING_WALL, DARK_CONCRETE_PAVING_PRESSURE_PLATE);
        createItemBlockWithVariants(event, ModItemGroups.EMBELLISHCRAFT, DIORITE_PAVING, DIORITE_PAVING_STAIRS, DIORITE_PAVING_SLAB, DIORITE_PAVING_WALL, DIORITE_PAVING_PRESSURE_PLATE);
        createItemBlockWithVariants(event, ModItemGroups.EMBELLISHCRAFT, MOIST_PAVING, MOIST_PAVING_STAIRS, MOIST_PAVING_SLAB, MOIST_PAVING_WALL, MOIST_PAVING_PRESSURE_PLATE);
        createItemBlockWithVariants(event, ModItemGroups.EMBELLISHCRAFT, POLISHED_PAVING, POLISHED_PAVING_STAIRS, POLISHED_PAVING_SLAB, POLISHED_PAVING_WALL, POLISHED_PAVING_PRESSURE_PLATE);
        createItemBlockWithVariants(event, ModItemGroups.EMBELLISHCRAFT, SLATE_PAVING, SLATE_PAVING_STAIRS, SLATE_PAVING_SLAB, SLATE_PAVING_WALL, SLATE_PAVING_PRESSURE_PLATE);
        createItemBlockWithVariants(event, ModItemGroups.EMBELLISHCRAFT, WHITE_CONCRETE_PAVING, WHITE_CONCRETE_PAVING_STAIRS, WHITE_CONCRETE_PAVING_SLAB, WHITE_CONCRETE_PAVING_WALL, WHITE_CONCRETE_PAVING_PRESSURE_PLATE);
        createItemBlockWithVariants(event, ModItemGroups.EMBELLISHCRAFT, GNEISS_PAVING, GNEISS_PAVING_STAIRS, GNEISS_PAVING_SLAB, GNEISS_PAVING_WALL, GNEISS_PAVING_PRESSURE_PLATE);

        // Tiles

        createItemBlockWithVariants(event, ModItemGroups.EMBELLISHCRAFT, CONCRETE_TILES, CONCRETE_TILES_STAIRS, CONCRETE_TILES_SLAB, CONCRETE_TILES_WALL, CONCRETE_TILES_PRESSURE_PLATE);
        createItemBlockWithVariants(event, ModItemGroups.EMBELLISHCRAFT, SKYBLUE_TILES, SKYBLUE_TILES_STAIRS, SKYBLUE_TILES_SLAB, SKYBLUE_TILES_WALL, SKYBLUE_TILES_PRESSURE_PLATE);
        createItemBlockWithVariants(event, ModItemGroups.EMBELLISHCRAFT, ORANGE_TILES, ORANGE_TILES_STAIRS, ORANGE_TILES_SLAB, ORANGE_TILES_WALL, ORANGE_TILES_PRESSURE_PLATE);
        createItemBlockWithVariants(event, ModItemGroups.EMBELLISHCRAFT, BLUE_TILES, BLUE_TILES_STAIRS, BLUE_TILES_SLAB, BLUE_TILES_WALL, BLUE_TILES_PRESSURE_PLATE);
        createItemBlockWithVariants(event, ModItemGroups.EMBELLISHCRAFT, LIGHT_BLUE_TILES, LIGHT_BLUE_TILES_STAIRS, LIGHT_BLUE_TILES_SLAB, LIGHT_BLUE_TILES_WALL, LIGHT_BLUE_TILES_PRESSURE_PLATE);
        createItemBlockWithVariants(event, ModItemGroups.EMBELLISHCRAFT, RED_TILES, RED_TILES_STAIRS, RED_TILES_SLAB, RED_TILES_WALL, RED_TILES_PRESSURE_PLATE);
        createItemBlockWithVariants(event, ModItemGroups.EMBELLISHCRAFT, WHITE_TILES, WHITE_TILES_STAIRS, WHITE_TILES_SLAB, WHITE_TILES_WALL, WHITE_TILES_PRESSURE_PLATE);
        createItemBlockWithVariants(event, ModItemGroups.EMBELLISHCRAFT, YELLOW_TILES, YELLOW_TILES_STAIRS, YELLOW_TILES_SLAB, YELLOW_TILES_WALL, YELLOW_TILES_PRESSURE_PLATE);
        createItemBlockWithVariants(event, ModItemGroups.EMBELLISHCRAFT, YELLOW_GREY_TILES, YELLOW_GREY_TILES_STAIRS, YELLOW_GREY_TILES_SLAB, YELLOW_GREY_TILES_WALL, YELLOW_GREY_TILES_PRESSURE_PLATE);

        // Wallpapers

        createItemBlockWithVariants(event, ModItemGroups.EMBELLISHCRAFT, WHITE_BLUE_WALLPAPER, WHITE_BLUE_WALLPAPER_STAIRS, WHITE_BLUE_WALLPAPER_SLAB, null, null);
        event.getRegistry().register(new BlockItem(WHITE_BLUE_WALLPAPER_PLINTH, new Item.Properties().group(ModItemGroups.EMBELLISHCRAFT)).setRegistryName(WHITE_BLUE_WALLPAPER_PLINTH.getRegistryName()));
        createItemBlockWithVariants(event, ModItemGroups.EMBELLISHCRAFT, BEIGE_WALLPAPER, BEIGE_WALLPAPER_STAIRS, BEIGE_WALLPAPER_SLAB, null, null);
        event.getRegistry().register(new BlockItem(BEIGE_WALLPAPER_PLINTH, new Item.Properties().group(ModItemGroups.EMBELLISHCRAFT)).setRegistryName(BEIGE_WALLPAPER_PLINTH.getRegistryName()));
        createItemBlockWithVariants(event, ModItemGroups.EMBELLISHCRAFT, PINK_WALLPAPER, PINK_WALLPAPER_STAIRS, PINK_WALLPAPER_SLAB, null, null);
        event.getRegistry().register(new BlockItem(PINK_WALLPAPER_PLINTH, new Item.Properties().group(ModItemGroups.EMBELLISHCRAFT)).setRegistryName(PINK_WALLPAPER_PLINTH.getRegistryName()));
        createItemBlockWithVariants(event, ModItemGroups.EMBELLISHCRAFT, BEIGE_FLOWER_WALLPAPER, BEIGE_FLOWER_WALLPAPER_STAIRS, BEIGE_FLOWER_WALLPAPER_SLAB, null, null);
        event.getRegistry().register(new BlockItem(BEIGE_FLOWER_WALLPAPER_PLINTH, new Item.Properties().group(ModItemGroups.EMBELLISHCRAFT)).setRegistryName(BEIGE_FLOWER_WALLPAPER_PLINTH.getRegistryName()));
        createItemBlockWithVariants(event, ModItemGroups.EMBELLISHCRAFT, WHITE_GREEN_WALLPAPER, WHITE_GREEN_WALLPAPER_STAIRS, WHITE_GREEN_WALLPAPER_SLAB, null, null);
        event.getRegistry().register(new BlockItem(WHITE_GREEN_WALLPAPER_PLINTH, new Item.Properties().group(ModItemGroups.EMBELLISHCRAFT)).setRegistryName(WHITE_GREEN_WALLPAPER_PLINTH.getRegistryName()));

        // Furniture

        event.getRegistry().register(new FuelBlockItem(OAK_CHAIR, new Item.Properties().group(ModItemGroups.EMBELLISHCRAFT), Constants.chairBurnTime).setRegistryName(OAK_CHAIR.getRegistryName()));
        event.getRegistry().register(new FuelBlockItem(DARK_OAK_CHAIR, new Item.Properties().group(ModItemGroups.EMBELLISHCRAFT), Constants.chairBurnTime).setRegistryName(DARK_OAK_CHAIR.getRegistryName()));
        event.getRegistry().register(new FuelBlockItem(BIRCH_CHAIR, new Item.Properties().group(ModItemGroups.EMBELLISHCRAFT), Constants.chairBurnTime).setRegistryName(BIRCH_CHAIR.getRegistryName()));
        event.getRegistry().register(new FuelBlockItem(JUNGLE_CHAIR, new Item.Properties().group(ModItemGroups.EMBELLISHCRAFT), Constants.chairBurnTime).setRegistryName(JUNGLE_CHAIR.getRegistryName()));
        event.getRegistry().register(new FuelBlockItem(SPRUCE_CHAIR, new Item.Properties().group(ModItemGroups.EMBELLISHCRAFT), Constants.chairBurnTime).setRegistryName(SPRUCE_CHAIR.getRegistryName()));
        event.getRegistry().register(new FuelBlockItem(ACACIA_CHAIR, new Item.Properties().group(ModItemGroups.EMBELLISHCRAFT), Constants.chairBurnTime).setRegistryName(ACACIA_CHAIR.getRegistryName()));

        event.getRegistry().register(new BlockItem(METALLIC_TERRACE_TABLE, new Item.Properties().group(ModItemGroups.EMBELLISHCRAFT)).setRegistryName(METALLIC_TERRACE_TABLE.getRegistryName()));
        event.getRegistry().register(new FuelBlockItem(OAK_TERRACE_TABLE, new Item.Properties().group(ModItemGroups.EMBELLISHCRAFT), Constants.chairBurnTime).setRegistryName(OAK_TERRACE_TABLE.getRegistryName()));
        event.getRegistry().register(new FuelBlockItem(BIRCH_TERRACE_TABLE, new Item.Properties().group(ModItemGroups.EMBELLISHCRAFT), Constants.chairBurnTime).setRegistryName(BIRCH_TERRACE_TABLE.getRegistryName()));
        event.getRegistry().register(new FuelBlockItem(SPRUCE_TERRACE_TABLE, new Item.Properties().group(ModItemGroups.EMBELLISHCRAFT), Constants.chairBurnTime).setRegistryName(SPRUCE_TERRACE_TABLE.getRegistryName()));
        event.getRegistry().register(new FuelBlockItem(JUNGLE_TERRACE_TABLE, new Item.Properties().group(ModItemGroups.EMBELLISHCRAFT), Constants.chairBurnTime).setRegistryName(JUNGLE_TERRACE_TABLE.getRegistryName()));
        event.getRegistry().register(new FuelBlockItem(DARK_OAK_TERRACE_TABLE, new Item.Properties().group(ModItemGroups.EMBELLISHCRAFT), Constants.chairBurnTime).setRegistryName(DARK_OAK_TERRACE_TABLE.getRegistryName()));
        event.getRegistry().register(new FuelBlockItem(ACACIA_TERRACE_TABLE, new Item.Properties().group(ModItemGroups.EMBELLISHCRAFT), Constants.chairBurnTime).setRegistryName(ACACIA_TERRACE_TABLE.getRegistryName()));

        event.getRegistry().register(new BlockItem(METALLIC_TERRACE_CHAIR, new Item.Properties().group(ModItemGroups.EMBELLISHCRAFT)).setRegistryName(METALLIC_TERRACE_CHAIR.getRegistryName()));
        event.getRegistry().register(new BlockItem(OAK_TERRACE_CHAIR, new Item.Properties().group(ModItemGroups.EMBELLISHCRAFT)).setRegistryName(OAK_TERRACE_CHAIR.getRegistryName()));
        event.getRegistry().register(new BlockItem(DARK_OAK_TERRACE_CHAIR, new Item.Properties().group(ModItemGroups.EMBELLISHCRAFT)).setRegistryName(DARK_OAK_TERRACE_CHAIR.getRegistryName()));
        event.getRegistry().register(new BlockItem(BIRCH_TERRACE_CHAIR, new Item.Properties().group(ModItemGroups.EMBELLISHCRAFT)).setRegistryName(BIRCH_TERRACE_CHAIR.getRegistryName()));
        event.getRegistry().register(new BlockItem(SPRUCE_TERRACE_CHAIR, new Item.Properties().group(ModItemGroups.EMBELLISHCRAFT)).setRegistryName(SPRUCE_TERRACE_CHAIR.getRegistryName()));
        event.getRegistry().register(new BlockItem(JUNGLE_TERRACE_CHAIR, new Item.Properties().group(ModItemGroups.EMBELLISHCRAFT)).setRegistryName(JUNGLE_TERRACE_CHAIR.getRegistryName()));
        event.getRegistry().register(new BlockItem(ACACIA_TERRACE_CHAIR, new Item.Properties().group(ModItemGroups.EMBELLISHCRAFT)).setRegistryName(ACACIA_TERRACE_CHAIR.getRegistryName()));

    }

    /**
     * Registers a Block with its variants.
     * @param event
     *        The RegistryEvent
     * @param name
     *        The Block registry name
     * @param stairs
     *        If true, stairs variant will be registered
     * @param slab
     *        If true, slab variant will be registered
     * @param wall
     *        If true, wall variant will be registered
     * @param pressure
     *        If true, pressure plate variant will be registered
     */
    private static void createBlockWithVariants(RegistryEvent.Register<Block> event, String name, boolean stairs, boolean slab, boolean wall, boolean pressure)
    {
        Block block; // Needed to register the stairs
        event.getRegistry().register(block = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F)).setRegistryName(name));
        if(stairs)
            event.getRegistry().register(new CustomStairsBlock(block.getDefaultState(), Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F)).setRegistryName(name + "_stairs"));
        if(slab)
            event.getRegistry().register(new SlabBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F)).setRegistryName(name + "_slab"));
        if(wall)
            event.getRegistry().register(new WallBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F)).setRegistryName(name + "_wall"));
        if(pressure)
            event.getRegistry().register(new CustomPressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, Block.Properties.create(Material.ROCK).doesNotBlockMovement().hardnessAndResistance(0.5F)).setRegistryName(name + "_pressure_plate"));

    }

    /**
     * Registers only variants of specified block.
     * @param event
     *        The RegistryEvent
     * @param name
     *        The Block registry name
     * @param stairs
     *        If true, stairs variant will be registered
     * @param slab
     *        If true, slab variant will be registered
     * @param wall
     *        If true, wall variant will be registered
     * @param pressure
     *        If true, pressure plate variant will be registered
     */
    // private static void createOnlyVariants(RegistryEvent.Register<Block> event, String name, boolean stairs, boolean slab, boolean wall, boolean pressure)
    // {
    // Block block = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F)).setRegistryName(name);; // Needed to register the stairs
    // if(stairs)
    // event.getRegistry().register(new CustomStairsBlock(block.getDefaultState(), Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F)).setRegistryName(name + "_stairs"));
    // if(slab)
    // event.getRegistry().register(new SlabBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F)).setRegistryName(name + "_slab"));
    // if(wall)
    // event.getRegistry().register(new WallBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F)).setRegistryName(name + "_wall"));
    // if(pressure)
    // event.getRegistry().register(new CustomPressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5F)).setRegistryName(name +
    // "_pressure_plate"));
    //
    // }

    /**
     * Registers a Block with its variants.
     * @param event
     *        The RegistryEvent
     * @param group
     *        The ItemGroup name
     * @param block
     *        The associated block
     * @param stairs
     *        The associated stairs (send null to not generate ItemBlock for it)
     * @param slab
     *        The associated slab (send null to not generate ItemBlock for it)
     * @param wall
     *        The associated wall (send null to not generate ItemBlock for it)
     * @param pressure
     *        The associated pressure plate (send null tot no generate ItemBlock for it)
     */
    private static void createItemBlockWithVariants(RegistryEvent.Register<Item> event, ItemGroup group, Block block, Block stairs, Block slab, Block wall, Block pressure)
    {
        event.getRegistry().register(new BlockItem(block, new Item.Properties().group(group)).setRegistryName(block.getRegistryName()));
        if(stairs != null)
            event.getRegistry().register(new BlockItem(stairs, new Item.Properties().group(group)).setRegistryName(stairs.getRegistryName()));
        if(slab != null)
            event.getRegistry().register(new BlockItem(slab, new Item.Properties().group(group)).setRegistryName(slab.getRegistryName()));
        if(wall != null)
            event.getRegistry().register(new BlockItem(wall, new Item.Properties().group(group)).setRegistryName(wall.getRegistryName()));
        if(pressure != null)
            event.getRegistry().register(new BlockItem(pressure, new Item.Properties().group(group)).setRegistryName(pressure.getRegistryName()));
    }
}