package com.mystic.atlantis.datagen;

import com.mystic.atlantis.Atlantis;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.BiasedToBottomInt;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

import static com.mystic.atlantis.datagen.ConfiguredFeaturesInit.*;
import static net.minecraft.world.level.levelgen.Heightmap.Types.OCEAN_FLOOR_WG;
import static net.minecraft.world.level.levelgen.placement.BiomeFilter.biome;
import static net.minecraft.world.level.levelgen.placement.HeightmapPlacement.onHeightmap;
import static net.minecraft.world.level.levelgen.placement.InSquarePlacement.spread;
import static net.minecraft.world.level.levelgen.placement.RarityFilter.onAverageOnceEvery;
import static net.minecraft.world.level.levelgen.placement.SurfaceWaterDepthFilter.forMaxDepth;

public class PlacedFeatureInit {
    public static final ResourceKey<PlacedFeature> ANCIENT_METAL_PLACED = key("ancient_metal_placed");
    public static final ResourceKey<PlacedFeature> AQUAMARINE_PLACED = key("aquamarine_placed");
    public static final ResourceKey<PlacedFeature> ATLANTEAN_PALM_TREE_PLACED = key("atlantean_palm_tree_placed");
    public static final ResourceKey<PlacedFeature> ATLANTEAN_TREE_PLACED = key("atlantean_tree_placed");
    public static final ResourceKey<PlacedFeature> ATLANTEAN_GLOWSTONES_PLACED = key("atlantean_glowstones_placed");
    public static final ResourceKey<PlacedFeature> ATLANTEAN_ISLANDS_PLACED = key("atlantean_islands_placed");
    public static final ResourceKey<PlacedFeature> ATLANTEAN_VOLCANO_PLACED = key("atlantean_volcano_placed");
    public static final ResourceKey<PlacedFeature> UNDERWATER_FLOWER_PLACED = key("underwater_flower_placed");
    public static final ResourceKey<PlacedFeature> GARDEN_FOLIAGE_PLACED = key("garden_foliage_placed");
    public static final ResourceKey<PlacedFeature> JETSTREAM_LAKE_PLACED = key("jetstream_lake_placed");
    public static final ResourceKey<PlacedFeature> UNDERWATER_MUSHROOM_PLACED = key("underwater_mushroom_placed");
    public static final ResourceKey<PlacedFeature> SALT_ROCK_GEODE_PLACED = key("salt_rock_geode_placed");
    public static final ResourceKey<PlacedFeature> SALTY_SEA_LAKE_PLACED = key("salty_sea_lake_placed");
    public static final ResourceKey<PlacedFeature> SHELL_BLOCK_PLACED = key("shell_block_placed");
    public static final ResourceKey<PlacedFeature> ORE_SUNKEN_GRAVEL_PLACED = key("ore_sunken_gravel_placed");

    private static ResourceKey<PlacedFeature> key(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Atlantis.id(name));
    }

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var registry = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, registry, ANCIENT_METAL_PLACED, ANCIENT_METAL_CONFIGURED,
                count( 120),
                spread(),
                absolute(-64, 450),
                biome());

        register(context, registry, AQUAMARINE_PLACED, AQUAMARINE_CONFIGURED,
                count(150),
                spread(),
                absolute(-64, 450),
                biome());

        register(context, registry, ATLANTEAN_PALM_TREE_PLACED, ATLANTEAN_PALM_TREE_CONFIGURED,
                count(2),
                spread(),
                forMaxDepth(0),
                onHeightmap(OCEAN_FLOOR_WG),
                biome());

        register(context, registry, ATLANTEAN_TREE_PLACED, ATLANTEAN_TREE_CONFIGURED,
                count(5),
                spread(),
                onHeightmap(OCEAN_FLOOR_WG),
                biome());

        register(context, registry, ATLANTEAN_GLOWSTONES_PLACED, ATLANTEAN_GLOWSTONES_CONFIGURED,
                biome(),
                spread(),
                onHeightmap(OCEAN_FLOOR_WG),
                absolute(100, 270));

        register(context, registry, ATLANTEAN_ISLANDS_PLACED, ATLANTEAN_ISLANDS_CONFIGURED,
                biome(),
                spread(),
                absolute(100, 270));

        register(context, registry, ATLANTEAN_VOLCANO_PLACED, ATLANTEAN_VOLCANO_CONFiGURED,
                biome(),
                spread(),
                onHeightmap(OCEAN_FLOOR_WG),
                absolute(100, 270));

        register(context, registry, UNDERWATER_FLOWER_PLACED, UNDERWATER_FLOWER_CONFIGURED,
                onAverageOnceEvery(1),
                biome(),
                onHeightmap(OCEAN_FLOOR_WG),
                countOnEveryLayer(0, 99));

        register(context, registry, GARDEN_FOLIAGE_PLACED, GARDEN_FOLIAGE_CONFIGURED,
                onAverageOnceEvery(1),
                biome(),
                onHeightmap(OCEAN_FLOOR_WG),
                countOnEveryLayer(0, 99));

        register(context, registry, JETSTREAM_LAKE_PLACED, JETSTREAM_LAKE_CONFIGURED,
                count(2),
                absolute(-60, 80),
                biome());

        register(context, registry, UNDERWATER_MUSHROOM_PLACED, UNDERWATER_MUSHROOM_CONFIGURED,
                count(1),
                biome(),
                onHeightmap(OCEAN_FLOOR_WG),
                countOnEveryLayer(0, 99));

        register(context, registry, SALT_ROCK_GEODE_PLACED, SALT_ROCK_GEODE_CONFIGURED,
                biome(),
                absolute(-30, 70),
                count(10));

        register(context, registry, SALTY_SEA_LAKE_PLACED, SALTY_SEA_LAKE_CONFIGURED,
                count(2),
                absolute(-60, 80),
                biome());

        register(context, registry, SHELL_BLOCK_PLACED, SHELL_BLOCK_CONFIGURED,
                onAverageOnceEvery(1),
                biome(),
                onHeightmap(OCEAN_FLOOR_WG),
                countOnEveryLayer(0, 99));

        register(context, registry, ORE_SUNKEN_GRAVEL_PLACED, ORE_SUNKEN_GRAVEL_CONFIGURED,
                count(10),
                spread(),
                absolute(-64, 45),
                biome());
    }

    private static CountOnEveryLayerPlacement countOnEveryLayer(int min, int max) {
        return CountOnEveryLayerPlacement.of(BiasedToBottomInt.of(min, max)); //TODO: Haunted figure out what its replacement is.
    }

    private static void register(BootstrapContext<PlacedFeature> context, HolderGetter<ConfiguredFeature<?,?>> registry, ResourceKey<PlacedFeature> key, ResourceKey<ConfiguredFeature<?, ?>> configuredKey, PlacementModifier... modifiers) {
        context.register(key, new PlacedFeature(registry.getOrThrow(configuredKey), List.of(modifiers)));
    }

    private static HeightRangePlacement absolute(int min, int max) {
        return HeightRangePlacement.of(
                UniformHeight.of(
                        VerticalAnchor.absolute(min),
                        VerticalAnchor.absolute(max)
        ));
    }

    private  static CountPlacement count(int count) {
        return CountPlacement.of(count);
    }
}
