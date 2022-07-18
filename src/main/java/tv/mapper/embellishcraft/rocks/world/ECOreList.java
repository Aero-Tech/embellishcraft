package tv.mapper.embellishcraft.rocks.world;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import tv.mapper.embellishcraft.core.config.EmbellishCraftConfig.CommonConfig;
import tv.mapper.embellishcraft.core.util.RockType;
import tv.mapper.embellishcraft.rocks.world.level.block.InitRockBlocks;
import tv.mapper.mapperbase.world.BaseOreGenerator;
import tv.mapper.mapperbase.world.CustomOre;
import tv.mapper.mapperbase.world.OreList;

public class ECOreList {
    static OreConfiguration basaltConfig = new OreConfiguration(
            OreFeatures.DEEPSLATE_ORE_REPLACEABLES,
            InitRockBlocks.ROCK_BLOCKS.get(RockType.BASALT).get().defaultBlockState(),
            CommonConfig.BASALT_SIZE.get());
    public static Holder<PlacedFeature> BASALT = registerPlacedOreFeature("basalt", new ConfiguredFeature<>(Feature.ORE, basaltConfig),
            BaseOreGenerator.commonOrePlacement(
                    CommonConfig.BASALT_CHANCE.get(),
                    HeightRangePlacement.uniform(
                            VerticalAnchor.absolute(CommonConfig.BASALT_MIN_HEIGHT.get()),
                            VerticalAnchor.absolute(CommonConfig.BASALT_MAX_HEIGHT.get())
                    )
            ));

    static OreConfiguration slateConfig = new OreConfiguration(
            OreFeatures.STONE_ORE_REPLACEABLES,
            InitRockBlocks.ROCK_BLOCKS.get(RockType.SLATE).get().defaultBlockState(),
            CommonConfig.BASALT_SIZE.get());
    public static Holder<PlacedFeature> SLATE = registerPlacedOreFeature("slate", new ConfiguredFeature<>(Feature.ORE, slateConfig),
            BaseOreGenerator.commonOrePlacement(
                    CommonConfig.SLATE_CHANCE.get(),
                    HeightRangePlacement.uniform(
                            VerticalAnchor.absolute(CommonConfig.SLATE_MIN_HEIGHT.get()),
                            VerticalAnchor.absolute(CommonConfig.SLATE_MAX_HEIGHT.get())
                    )
            ));

    static OreConfiguration marbleConfig = new OreConfiguration(
            OreFeatures.STONE_ORE_REPLACEABLES,
            InitRockBlocks.ROCK_BLOCKS.get(RockType.MARBLE).get().defaultBlockState(),
            CommonConfig.MARBLE_SIZE.get());
    public static Holder<PlacedFeature> MARBLE = registerPlacedOreFeature("marble", new ConfiguredFeature<>(Feature.ORE, marbleConfig),
            BaseOreGenerator.commonOrePlacement(
                    CommonConfig.MARBLE_CHANCE.get(),
                    HeightRangePlacement.uniform(
                            VerticalAnchor.absolute(CommonConfig.MARBLE_MIN_HEIGHT.get()),
                            VerticalAnchor.absolute(CommonConfig.MARBLE_MAX_HEIGHT.get())
                    )
            ));

    static OreConfiguration gneissConfig = new OreConfiguration(
            OreFeatures.STONE_ORE_REPLACEABLES,
            InitRockBlocks.ROCK_BLOCKS.get(RockType.GNEISS).get().defaultBlockState(),
            CommonConfig.GNEISS_SIZE.get());
    public static Holder<PlacedFeature> GNEISS = registerPlacedOreFeature("gneiss", new ConfiguredFeature<>(Feature.ORE, gneissConfig),
            BaseOreGenerator.commonOrePlacement(
                    CommonConfig.GNEISS_CHANCE.get(),
                    HeightRangePlacement.uniform(
                            VerticalAnchor.absolute(CommonConfig.GNEISS_MIN_HEIGHT.get()),
                            VerticalAnchor.absolute(CommonConfig.GNEISS_MAX_HEIGHT.get())
                    )
            ));

    static OreConfiguration jadeConfig = new OreConfiguration(
            OreFeatures.STONE_ORE_REPLACEABLES,
            InitRockBlocks.ROCK_BLOCKS.get(RockType.JADE).get().defaultBlockState(),
            CommonConfig.JADE_SIZE.get());
    public static Holder<PlacedFeature> JADE = registerPlacedOreFeature("jade", new ConfiguredFeature<>(Feature.ORE, jadeConfig),
            BaseOreGenerator.commonOrePlacement(
                    CommonConfig.JADE_CHANCE.get(),
                    HeightRangePlacement.uniform(
                            VerticalAnchor.absolute(CommonConfig.JADE_MIN_HEIGHT.get()),
                            VerticalAnchor.absolute(CommonConfig.JADE_MAX_HEIGHT.get())
                    )
            ));

    static OreConfiguration larvikiteConfig = new OreConfiguration(
            OreFeatures.STONE_ORE_REPLACEABLES,
            InitRockBlocks.ROCK_BLOCKS.get(RockType.LARVIKITE).get().defaultBlockState(),
            CommonConfig.LARVIKITE_SIZE.get());
    public static Holder<PlacedFeature> LARVIKITE = registerPlacedOreFeature("larvikite", new ConfiguredFeature<>(Feature.ORE, larvikiteConfig),
            BaseOreGenerator.commonOrePlacement(
                    CommonConfig.LARVIKITE_CHANCE.get(),
                    HeightRangePlacement.uniform(
                            VerticalAnchor.absolute(CommonConfig.LARVIKITE_MIN_HEIGHT.get()),
                            VerticalAnchor.absolute(CommonConfig.LARVIKITE_MAX_HEIGHT.get())
                    )
            ));

    public static final CustomOre basalt = new CustomOre("basalt", BASALT, CommonConfig.BASALT_GENERATION.get(), CommonConfig.BASALT_WHITELIST_MODE.get(), CommonConfig.BASALT_BIOME_LIST.get());
    public static final CustomOre slate = new CustomOre("slate", SLATE, CommonConfig.SLATE_GENERATION.get(), CommonConfig.SLATE_WHITELIST_MODE.get(), CommonConfig.SLATE_BIOME_LIST.get());
    public static final CustomOre marble = new CustomOre("marble", MARBLE, CommonConfig.MARBLE_GENERATION.get(), CommonConfig.MARBLE_WHITELIST_MODE.get(), CommonConfig.MARBLE_BIOME_LIST.get());
    public static final CustomOre gneiss = new CustomOre("gneiss", GNEISS, CommonConfig.GNEISS_GENERATION.get(), CommonConfig.GNEISS_WHITELIST_MODE.get(), CommonConfig.GNEISS_BIOME_LIST.get());
    public static final CustomOre jade = new CustomOre("jade", JADE, CommonConfig.JADE_GENERATION.get(), CommonConfig.JADE_WHITELIST_MODE.get(), CommonConfig.JADE_BIOME_LIST.get());
    public static final CustomOre larvikite = new CustomOre("larvikite", LARVIKITE, CommonConfig.LARVIKITE_GENERATION.get(), CommonConfig.LARVIKITE_WHITELIST_MODE.get(), CommonConfig.LARVIKITE_BIOME_LIST.get());

    public static void initOres() {
        ArrayList<CustomOre> list = new ArrayList<CustomOre>();
        list.add(basalt);
        list.add(slate);
        list.add(marble);
        list.add(gneiss);
        list.add(jade);
        list.add(larvikite);

        OreList.addOre(list);
    }

    private static <C extends FeatureConfiguration, F extends Feature<C>> Holder<PlacedFeature> registerPlacedOreFeature(String registryName, ConfiguredFeature<C, F> feature, List<PlacementModifier> placementModifiers) {
        return PlacementUtils.register(registryName, Holder.direct(feature), placementModifiers);
    }
}