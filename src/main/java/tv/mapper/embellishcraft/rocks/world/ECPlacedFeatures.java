package tv.mapper.embellishcraft.rocks.world;

import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import tv.mapper.embellishcraft.core.ECConstants;
import tv.mapper.embellishcraft.core.config.EmbellishCraftConfig;

import java.util.List;

public class ECPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, ECConstants.MODID);

    // Basalt
    public static final RegistryObject<PlacedFeature> BASALT_ORE_PLACED = PLACED_FEATURES.register("basalt_ore",
            () -> new PlacedFeature(ECConfiguredFeatures.BASALT_ORE.getHolder().get(),
                    commonOrePlacement(EmbellishCraftConfig.BASALT_CHANCE.get(),
                            HeightRangePlacement.uniform(
                                    VerticalAnchor.absolute(EmbellishCraftConfig.BASALT_MIN_HEIGHT.get()),
                                    VerticalAnchor.absolute(EmbellishCraftConfig.BASALT_MAX_HEIGHT.get())
                            ))));

    // Slate
    public static final RegistryObject<PlacedFeature> SLATE_ORE_PLACED = PLACED_FEATURES.register("slate_ore",
            () -> new PlacedFeature(ECConfiguredFeatures.SLATE_ORE.getHolder().get(),
                    commonOrePlacement(EmbellishCraftConfig.SLATE_CHANCE.get(),
                            HeightRangePlacement.uniform(
                                    VerticalAnchor.absolute(EmbellishCraftConfig.SLATE_MIN_HEIGHT.get()),
                                    VerticalAnchor.absolute(EmbellishCraftConfig.SLATE_MAX_HEIGHT.get())
                            ))));

    // Marble
    public static final RegistryObject<PlacedFeature> MARBLE_ORE_PLACED = PLACED_FEATURES.register("marble_ore",
            () -> new PlacedFeature(ECConfiguredFeatures.MARBLE_ORE.getHolder().get(),
                    commonOrePlacement(EmbellishCraftConfig.MARBLE_CHANCE.get(),
                            HeightRangePlacement.uniform(
                                    VerticalAnchor.absolute(EmbellishCraftConfig.MARBLE_MIN_HEIGHT.get()),
                                    VerticalAnchor.absolute(EmbellishCraftConfig.MARBLE_MAX_HEIGHT.get())
                            ))));

    // Gneiss
    public static final RegistryObject<PlacedFeature> GNEISS_ORE_PLACED = PLACED_FEATURES.register("gneiss_ore",
            () -> new PlacedFeature(ECConfiguredFeatures.GNEISS_ORE.getHolder().get(),
                    commonOrePlacement(EmbellishCraftConfig.GNEISS_CHANCE.get(),
                            HeightRangePlacement.uniform(
                                    VerticalAnchor.absolute(EmbellishCraftConfig.GNEISS_MIN_HEIGHT.get()),
                                    VerticalAnchor.absolute(EmbellishCraftConfig.GNEISS_MAX_HEIGHT.get())
                            ))));

    // Jade
    public static final RegistryObject<PlacedFeature> JADE_ORE_PLACED = PLACED_FEATURES.register("jade_ore",
            () -> new PlacedFeature(ECConfiguredFeatures.JADE_ORE.getHolder().get(),
                    commonOrePlacement(EmbellishCraftConfig.JADE_CHANCE.get(),
                            HeightRangePlacement.uniform(
                                    VerticalAnchor.absolute(EmbellishCraftConfig.JADE_MIN_HEIGHT.get()),
                                    VerticalAnchor.absolute(EmbellishCraftConfig.JADE_MAX_HEIGHT.get())
                            ))));

    // Larvikite
    public static final RegistryObject<PlacedFeature> LARVIKITE_ORE_PLACED = PLACED_FEATURES.register("larvikite_ore",
            () -> new PlacedFeature(ECConfiguredFeatures.LARVIKITE_ORE.getHolder().get(),
                    commonOrePlacement(EmbellishCraftConfig.LARVIKITE_CHANCE.get(),
                            HeightRangePlacement.uniform(
                                    VerticalAnchor.absolute(EmbellishCraftConfig.LARVIKITE_MIN_HEIGHT.get()),
                                    VerticalAnchor.absolute(EmbellishCraftConfig.LARVIKITE_MAX_HEIGHT.get())
                            ))));



    public static List<PlacementModifier> orePlacement(PlacementModifier count, PlacementModifier height) {
        return List.of(count, InSquarePlacement.spread(), height, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int countPerChunk, PlacementModifier height) {
        return orePlacement(CountPlacement.of(countPerChunk), height);
    }
}
