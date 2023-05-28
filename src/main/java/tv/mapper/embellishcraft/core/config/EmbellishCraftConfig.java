package tv.mapper.embellishcraft.core.config;

import java.util.ArrayList;

import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.commons.lang3.tuple.Pair;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;

public final class EmbellishCraftConfig
{
    public static ForgeConfigSpec.BooleanValue ENABLE_WORLDGEN;

    public static ForgeConfigSpec.BooleanValue BASALT_GENERATION;
    public static ForgeConfigSpec.IntValue BASALT_CHANCE;
    public static ForgeConfigSpec.IntValue BASALT_SIZE;
    public static ForgeConfigSpec.IntValue BASALT_MIN_HEIGHT;
    public static ForgeConfigSpec.IntValue BASALT_MAX_HEIGHT;

    public static ForgeConfigSpec.BooleanValue SLATE_GENERATION;
    public static ForgeConfigSpec.IntValue SLATE_CHANCE;
    public static ForgeConfigSpec.IntValue SLATE_SIZE;
    public static ForgeConfigSpec.IntValue SLATE_MIN_HEIGHT;
    public static ForgeConfigSpec.IntValue SLATE_MAX_HEIGHT;

    public static ForgeConfigSpec.BooleanValue MARBLE_GENERATION;
    public static ForgeConfigSpec.IntValue MARBLE_CHANCE;
    public static ForgeConfigSpec.IntValue MARBLE_SIZE;
    public static ForgeConfigSpec.IntValue MARBLE_MIN_HEIGHT;
    public static ForgeConfigSpec.IntValue MARBLE_MAX_HEIGHT;

    public static ForgeConfigSpec.BooleanValue GNEISS_GENERATION;
    public static ForgeConfigSpec.IntValue GNEISS_CHANCE;
    public static ForgeConfigSpec.IntValue GNEISS_SIZE;
    public static ForgeConfigSpec.IntValue GNEISS_MIN_HEIGHT;
    public static ForgeConfigSpec.IntValue GNEISS_MAX_HEIGHT;

    public static ForgeConfigSpec.BooleanValue JADE_GENERATION;
    public static ForgeConfigSpec.IntValue JADE_CHANCE;
    public static ForgeConfigSpec.IntValue JADE_SIZE;
    public static ForgeConfigSpec.IntValue JADE_MIN_HEIGHT;
    public static ForgeConfigSpec.IntValue JADE_MAX_HEIGHT;

    public static ForgeConfigSpec.BooleanValue LARVIKITE_GENERATION;
    public static ForgeConfigSpec.IntValue LARVIKITE_CHANCE;
    public static ForgeConfigSpec.IntValue LARVIKITE_SIZE;
    public static ForgeConfigSpec.IntValue LARVIKITE_MIN_HEIGHT;
    public static ForgeConfigSpec.IntValue LARVIKITE_MAX_HEIGHT;

        /*public static ForgeConfigSpec.BooleanValue BASALT_WHITELIST_MODE;
        public static ForgeConfigSpec.BooleanValue SLATE_WHITELIST_MODE;
        public static ForgeConfigSpec.BooleanValue MARBLE_WHITELIST_MODE;
        public static ForgeConfigSpec.BooleanValue GNEISS_WHITELIST_MODE;
        public static ForgeConfigSpec.BooleanValue JADE_WHITELIST_MODE;
        public static ForgeConfigSpec.BooleanValue LARVIKITE_WHITELIST_MODE;
        public static ConfigValue<ArrayList<String>> BASALT_BIOME_LIST;
        public static ConfigValue<ArrayList<String>> SLATE_BIOME_LIST;
        public static ConfigValue<ArrayList<String>> MARBLE_BIOME_LIST;
        public static ConfigValue<ArrayList<String>> GNEISS_BIOME_LIST;
        public static ConfigValue<ArrayList<String>> JADE_BIOME_LIST;
        public static ConfigValue<ArrayList<String>> LARVIKITE_BIOME_LIST;

        private static ArrayList<String> default_biomes = new ArrayList<>();
        private static ArrayList<String> cold_biomes = new ArrayList<>();*/

    public static void initialize() {
        var COMMON_BUILDER = new ForgeConfigSpec.Builder();

            /*// Nether biomes
            default_biomes.add("minecraft:nether_wastes");
            default_biomes.add("minecraft:soul_sand_valley");
            default_biomes.add("minecraft:basalt_deltas");
            default_biomes.add("minecraft:crimson_forest");
            default_biomes.add("minecraft:warped_forest");
            // End biomes
            default_biomes.add("minecraft:the_end");
            default_biomes.add("minecraft:end_barrens");
            default_biomes.add("minecraft:end_midlands");
            default_biomes.add("minecraft:end_highlands");
            default_biomes.add("minecraft:small_end_islands");
            default_biomes.add("minecraft:the_void");
            
            cold_biomes.add("minecraft:cold_ocean");
            cold_biomes.add("minecraft:frozen_ocean");
            cold_biomes.add("minecraft:frozen_peaks");
            cold_biomes.add("minecraft:frozen_river");
            cold_biomes.add("minecraft:grove");
            cold_biomes.add("minecraft:ice_spikes");
            cold_biomes.add("minecraft:jagged_peaks");
            cold_biomes.add("minecraft:old_growth_pine_taiga");
            cold_biomes.add("minecraft:old_growth_spruce_taiga"); // Missing from forge/is_cold
            cold_biomes.add("minecraft:snowy_beach");
            cold_biomes.add("minecraft:snowy_plains");
            cold_biomes.add("minecraft:snowy_slopes");
            cold_biomes.add("minecraft:snowy_taiga");
            cold_biomes.add("minecraft:stony_peaks"); // Missing from forge/is_cold
            cold_biomes.add("minecraft:taiga");
            cold_biomes.add("minecraft:windswept_forest");  // Missing from forge/is_cold
            cold_biomes.add("minecraft:windswept_gravelly_hills");  // Missing from forge/is_cold
            cold_biomes.add("minecraft:windswept_hills");  // Missing from forge/is_cold
            // extra: deep_cold_ocean, deep_frozen_ocean*/

        COMMON_BUILDER.comment("Global Worldgen Settings").push("worldgen");

        ENABLE_WORLDGEN = COMMON_BUILDER.comment("Set this to false to disable all worldgen [true / false, default: true]").define("enableWorldgen", true);

        COMMON_BUILDER.pop();
        COMMON_BUILDER.comment("Basalt Generation").push("basalt");

        BASALT_GENERATION = COMMON_BUILDER.comment("Generate basalt in the world [true / false]").define("basaltGeneration", true);
        BASALT_SIZE = COMMON_BUILDER.comment("Size of basalt pockets [0-100, default: 33]").defineInRange("basaltSize", 56, 0, 100);
        BASALT_CHANCE = COMMON_BUILDER.comment("Amount of of basalt pocket being generated [0-20, default: 5]").defineInRange("basaltChance", 5, 0, 20);
        BASALT_MIN_HEIGHT = COMMON_BUILDER.comment("Minimal height for basalt pocket generation [-63~318, default: -56]").defineInRange("basaltMinHeight", -56, -63, 319);
        BASALT_MAX_HEIGHT = COMMON_BUILDER.comment("Maximal height for basalt pocket generation, must be higher than minimal height [-63~319, default: 8]").defineInRange("basaltMaxHeight", 8, -64, 384);

        COMMON_BUILDER.pop();
        COMMON_BUILDER.comment("Slate Generation").push("slate");

        SLATE_GENERATION = COMMON_BUILDER.comment("Generate slate in the world [true / false]").define("slateGeneration", true);
        SLATE_SIZE = COMMON_BUILDER.comment("Size of slate pockets [0-100, default: 48]").defineInRange("slateSize", 48, 0, 100);
        SLATE_CHANCE = COMMON_BUILDER.comment("Amount of of slate pocket being generated [0-20, default: 3]").defineInRange("slateChance", 3, 0, 20);
        SLATE_MIN_HEIGHT = COMMON_BUILDER.comment("Minimal height for slate pocket generation [-63~318, default: 32]").defineInRange("slateMinHeight", 32, -63, 318);
        SLATE_MAX_HEIGHT = COMMON_BUILDER.comment("Maximal height for slate pocket generation, must be higher than minimal height [-63~319, default: 128]").defineInRange("slateMaxHeight", 128, -63, 319);

        COMMON_BUILDER.pop();
        COMMON_BUILDER.comment("Marble Generation").push("marble");

        MARBLE_GENERATION = COMMON_BUILDER.comment("Generate marble in the world [true / false]").define("marbleGeneration", true);
        MARBLE_SIZE = COMMON_BUILDER.comment("Size of marble pockets [0-100, default: 32]").defineInRange("marbleSize", 32, 0, 100);
        MARBLE_CHANCE = COMMON_BUILDER.comment("Amount of of marble pocket being generated [0-20, default: 3]").defineInRange("marbleChance", 3, 0, 20);
        MARBLE_MIN_HEIGHT = COMMON_BUILDER.comment("Minimal height for marble pocket generation [-63~318, default: 64]").defineInRange("marbleMinHeight", 64, -63, 318);
        MARBLE_MAX_HEIGHT = COMMON_BUILDER.comment("Maximal height for marble pocket generation, must be higher than minimal height [-63~319, default: 196]").defineInRange("marbleMaxHeight", 196, -63, 319);

        COMMON_BUILDER.pop();
        COMMON_BUILDER.comment("Gneiss Generation").push("gneiss");

        GNEISS_GENERATION = COMMON_BUILDER.comment("Generate gneiss in the world [true / false]").define("gneissGeneration", true);
        GNEISS_SIZE = COMMON_BUILDER.comment("Size of gneiss pockets [0-100, default: 16]").defineInRange("gneissSize", 32, 0, 100);
        GNEISS_CHANCE = COMMON_BUILDER.comment("Amount of of gneiss pocket being generated [0-20, default: 2]").defineInRange("gneissChance", 2, 0, 20);
        GNEISS_MIN_HEIGHT = COMMON_BUILDER.comment("Minimal height for gneiss pocket generation [-63~318, default: 16]").defineInRange("gneissMinHeight", 16, -63, 318);
        GNEISS_MAX_HEIGHT = COMMON_BUILDER.comment("Maximal height for gneiss pocket generation, must be higher than minimal height [-63~319, default: 64]").defineInRange("gneissMaxHeight", 64, -63, 319);

        COMMON_BUILDER.pop();
        COMMON_BUILDER.comment("Jade Generation").push("jade");

        JADE_GENERATION = COMMON_BUILDER.comment("Generate jade in the world [true / false]").define("jadeGeneration", true);
        JADE_SIZE = COMMON_BUILDER.comment("Size of jade pockets [0-100, default: 15]").defineInRange("jadeSize", 16, 0, 100);
        JADE_CHANCE = COMMON_BUILDER.comment("Amount of of jade pocket being generated [0-20, default: 5]").defineInRange("jadeChance", 3, 0, 20);
        JADE_MIN_HEIGHT = COMMON_BUILDER.comment("Minimal height for jade pocket generation, [-63~318, default: 50]").defineInRange("jadeMinHeight", 72, -63, 318);
        JADE_MAX_HEIGHT = COMMON_BUILDER.comment("Maximal height for jade pocket generation, must be higher than minimal height [-63~319, default: 100]").defineInRange("jadeMaxHeight", 192, -63, 319);

        COMMON_BUILDER.pop();
        COMMON_BUILDER.comment("Larvikite Generation").push("larvikite");

        LARVIKITE_GENERATION = COMMON_BUILDER.comment("Generate larvikite in the world [true / false]").define("larvikiteGeneration", true);
        LARVIKITE_SIZE = COMMON_BUILDER.comment("Size of larvikite pockets [0-100, default: 15]").defineInRange("larvikiteSize", 48, 0, 100);
        LARVIKITE_CHANCE = COMMON_BUILDER.comment("Amount of of larvikite pocket being generated [0-20, default: 5]").defineInRange("larvikiteChance", 1, 0, 20);
        LARVIKITE_MIN_HEIGHT = COMMON_BUILDER.comment("Minimal height for larvikite pocket generation, [-63~318, default: 50]").defineInRange("larvikiteMinHeight", 48, -63, 318);
        LARVIKITE_MAX_HEIGHT = COMMON_BUILDER.comment("Maximal height for larvikite pocket generation, must be higher than minimal height [-63~319, default: 100]").defineInRange("larvikiteMaxHeight", 72, -63, 319);

        COMMON_BUILDER.pop();
            /*COMMON_BUILDER.comment("Biome Blacklist: list here the biomes you do not want a rock to be generated in (syntax: \"modid:biome\". Examples: \"minecraft:plains\", \"biomesoplenty:meadow\"...). Note: you can replace the default values, rocks only generate where stone is. They never generate in the Nether or the End.").push("blacklist");

            BASALT_WHITELIST_MODE = COMMON_BUILDER.comment("Set to true to switch basalt blacklist to whitelist mode [true / false]").define("basaltWhitelist", false);
            BASALT_BIOME_LIST = COMMON_BUILDER.comment("List of blacklisted biomes for basalt generation").define("basaltBiomeBlacklist", default_biomes);
            SLATE_WHITELIST_MODE = COMMON_BUILDER.comment("Set to true to switch slate blacklist to whitelist mode [true / false]").define("slateWhitelist", false);
            SLATE_BIOME_LIST = COMMON_BUILDER.comment("List of blacklisted biomes for slate generation").define("slateBiomeBlacklist", default_biomes);
            MARBLE_WHITELIST_MODE = COMMON_BUILDER.comment("Set to true to switch marble blacklist to whitelist mode [true / false]").define("marbleWhitelist", false);
            MARBLE_BIOME_LIST = COMMON_BUILDER.comment("List of blacklisted biomes for marble generation").define("marbleBiomeBlacklist", default_biomes);
            GNEISS_WHITELIST_MODE = COMMON_BUILDER.comment("Set to true to switch gneiss blacklist to whitelist mode [true / false]").define("gneissWhitelist", false);
            GNEISS_BIOME_LIST = COMMON_BUILDER.comment("List of blacklisted biomes for gneiss generation").define("gneissBiomeBlacklist", default_biomes);
            JADE_WHITELIST_MODE = COMMON_BUILDER.comment("Set to true to switch jade blacklist to whitelist mode [true / false]").define("jadeWhitelist", false);
            JADE_BIOME_LIST = COMMON_BUILDER.comment("List of blacklisted biomes for jade generation").define("jadeBiomeBlacklist", default_biomes);
            LARVIKITE_WHITELIST_MODE = COMMON_BUILDER.comment("Set to true to switch larvikite blacklist to whitelist mode [true / false] (default is true for larvikite)").define("larvikiteWhitelist", true);
            LARVIKITE_BIOME_LIST = COMMON_BUILDER.comment("List of blacklisted biomes for larvikite generation (note, by default larvikite only generates in those biomes)").define("larvikiteBiomeBlacklist", cold_biomes);

            COMMON_BUILDER.pop();*/

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, COMMON_BUILDER.build());
    }
}