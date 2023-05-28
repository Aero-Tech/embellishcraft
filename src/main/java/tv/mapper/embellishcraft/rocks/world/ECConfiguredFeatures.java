package tv.mapper.embellishcraft.rocks.world;

import com.google.common.base.Suppliers;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import tv.mapper.embellishcraft.core.ECConstants;
import tv.mapper.embellishcraft.core.config.EmbellishCraftConfig;
import tv.mapper.embellishcraft.core.util.RockType;
import tv.mapper.embellishcraft.rocks.world.level.block.InitRockBlocks;

import java.util.List;
import java.util.function.Supplier;

public class ECConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, ECConstants.MODID);

    // Basalt
    public static final Supplier<List<OreConfiguration.TargetBlockState>> BASALT_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, InitRockBlocks.ROCK_BLOCKS.get(RockType.BASALT).get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, InitRockBlocks.ROCK_BLOCKS.get(RockType.BASALT).get().defaultBlockState())));
    public static final RegistryObject<ConfiguredFeature<?, ?>> BASALT_ORE = CONFIGURED_FEATURES.register("basalt_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(BASALT_ORES.get(), EmbellishCraftConfig.BASALT_SIZE.get())));

    // Slate
    public static final Supplier<List<OreConfiguration.TargetBlockState>> SLATE_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, InitRockBlocks.ROCK_BLOCKS.get(RockType.SLATE).get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, InitRockBlocks.ROCK_BLOCKS.get(RockType.SLATE).get().defaultBlockState())));
    public static final RegistryObject<ConfiguredFeature<?, ?>> SLATE_ORE = CONFIGURED_FEATURES.register("slate_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(SLATE_ORES.get(), EmbellishCraftConfig.SLATE_SIZE.get())));

    // Marble
    public static final Supplier<List<OreConfiguration.TargetBlockState>> MARBLE_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, InitRockBlocks.ROCK_BLOCKS.get(RockType.MARBLE).get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, InitRockBlocks.ROCK_BLOCKS.get(RockType.MARBLE).get().defaultBlockState())));
    public static final RegistryObject<ConfiguredFeature<?, ?>> MARBLE_ORE = CONFIGURED_FEATURES.register("marble_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(MARBLE_ORES.get(), EmbellishCraftConfig.MARBLE_SIZE.get())));

    // Gneiss
    public static final Supplier<List<OreConfiguration.TargetBlockState>> GNEISS_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, InitRockBlocks.ROCK_BLOCKS.get(RockType.GNEISS).get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, InitRockBlocks.ROCK_BLOCKS.get(RockType.GNEISS).get().defaultBlockState())));
    public static final RegistryObject<ConfiguredFeature<?, ?>> GNEISS_ORE = CONFIGURED_FEATURES.register("gneiss_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(GNEISS_ORES.get(), EmbellishCraftConfig.GNEISS_SIZE.get())));

    // Jade
    public static final Supplier<List<OreConfiguration.TargetBlockState>> JADE_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, InitRockBlocks.ROCK_BLOCKS.get(RockType.JADE).get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, InitRockBlocks.ROCK_BLOCKS.get(RockType.JADE).get().defaultBlockState())));
    public static final RegistryObject<ConfiguredFeature<?, ?>> JADE_ORE = CONFIGURED_FEATURES.register("jade_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(JADE_ORES.get(), EmbellishCraftConfig.JADE_SIZE.get())));

    // Larvikite
    public static final Supplier<List<OreConfiguration.TargetBlockState>> LARVIKITE_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, InitRockBlocks.ROCK_BLOCKS.get(RockType.LARVIKITE).get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, InitRockBlocks.ROCK_BLOCKS.get(RockType.LARVIKITE).get().defaultBlockState())));
    public static final RegistryObject<ConfiguredFeature<?, ?>> LARVIKITE_ORE = CONFIGURED_FEATURES.register("larvikite_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(LARVIKITE_ORES.get(), EmbellishCraftConfig.LARVIKITE_SIZE.get())));
}
