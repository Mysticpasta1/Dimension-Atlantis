package com.mystic.atlantis.datagen;

import com.mystic.atlantis.Atlantis;
import com.mystic.atlantis.blocks.base.PalmLeavesBlock;
import com.mystic.atlantis.blocks.base.PalmLog;
import com.mystic.atlantis.feature.AtlantisFeature;
import com.mystic.atlantis.init.BlockInit;
import net.minecraft.core.Direction;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GeodeBlockSettings;
import net.minecraft.world.level.levelgen.GeodeCrackSettings;
import net.minecraft.world.level.levelgen.GeodeLayerSettings;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.LakeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.AcaciaFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.RandomSpreadFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class ConfiguredFeaturesInit {
    public static final ResourceKey<ConfiguredFeature<?, ?>> ANCIENT_METAL_CONFIGURED = Atlantis.configuredFeatureKey("ancient_metal_configured");
    public static final ResourceKey<ConfiguredFeature<?, ?>> AQUAMARINE_CONFIGURED = Atlantis.configuredFeatureKey("aquamarine_configured");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_SUNKEN_GRAVEL_CONFIGURED = Atlantis.configuredFeatureKey("ore_sunken_gravel_configured");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SALT_ROCK_GEODE_CONFIGURED = Atlantis.configuredFeatureKey("salt_rock_geode_configured");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ATLANTEAN_PALM_TREE_CONFIGURED = Atlantis.configuredFeatureKey("atlantean_palm_tree_configured");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ATLANTEAN_TREE_CONFIGURED = Atlantis.configuredFeatureKey("atlantean_tree_configured");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ATLANTEAN_GLOWSTONES_CONFIGURED = Atlantis.configuredFeatureKey("atlantean_glowstones_configured");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SALTY_SEA_LAKE_CONFIGURED = Atlantis.configuredFeatureKey("salty_sea_lake_configured");
    public static final ResourceKey<ConfiguredFeature<?, ?>> UNDERWATER_FLOWER_CONFIGURED = Atlantis.configuredFeatureKey("underwater_flower_configured");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ATLANTEAN_VOLCANO_CONFiGURED = Atlantis.configuredFeatureKey("atlantean_volcano_configured");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ATLANTEAN_ISLANDS_CONFIGURED = Atlantis.configuredFeatureKey("atlantean_islands_configured");
    public static final ResourceKey<ConfiguredFeature<?, ?>> JETSTREAM_LAKE_CONFIGURED = Atlantis.configuredFeatureKey("jetstream_lake_configured");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SHELL_BLOCK_CONFIGURED = Atlantis.configuredFeatureKey("shell_block_configured");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GARDEN_FOLIAGE_CONFIGURED = Atlantis.configuredFeatureKey("garden_foliage_configured");
    public static final ResourceKey<ConfiguredFeature<?, ?>> UNDERWATER_MUSHROOM_CONFIGURED = Atlantis.configuredFeatureKey("underwater_mushroom_configured");

    public ConfiguredFeaturesInit(BootstapContext<ConfiguredFeature<?, ?>> context) {
        registerOre(context, ANCIENT_METAL_CONFIGURED, BlockInit.ANCIENT_METAL_ORE, BlockInit.DEEPSLATE_ANCIENT_METAL_ORE, 6, 0);
        registerOre(context, AQUAMARINE_CONFIGURED, BlockInit.AQUAMARINE_ORE, BlockInit.AQUAMARINE_DEEPSLATE_ORE, 4, 0);
        registerOre(context, ORE_SUNKEN_GRAVEL_CONFIGURED, BlockInit.SUNKEN_GRAVEL, BlockInit.SUNKEN_GRAVEL, 40, 0);
        register(context, SALT_ROCK_GEODE_CONFIGURED, Feature.GEODE, new GeodeConfiguration(
                new GeodeBlockSettings(
                        BlockStateProvider.simple(BlockInit.SEA_SALT_CHUNK.get()),
                        BlockStateProvider.simple(BlockInit.SEA_SALT_CHUNK.get()),
                        BlockStateProvider.simple(BlockInit.SEA_SALT_CHUNK.get()),
                        BlockStateProvider.simple(Blocks.CALCITE),
                        BlockStateProvider.simple(BlockInit.CALCITE_BLOCK.get()),
                        List.of(BlockInit.SEA_SALT_CHUNK.get().defaultBlockState()),
                        BlockTags.ANCIENT_CITY_REPLACEABLE,
                        BlockTags.REDSTONE_ORES
                ), new GeodeLayerSettings(3.7, 4.2, 5.3, 6.2),
                new GeodeCrackSettings(0.95, 2, 2),
                0.35, 0.085, false,
                ConstantInt.of(1), ConstantInt.of(1), ConstantInt.ZERO,
                -16, 16, 0.05, 1
        ));
        register(context, ATLANTEAN_TREE_CONFIGURED, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(BlockInit.ATLANTEAN_LOGS.get()),
                new FancyTrunkPlacer(25, 20, 22),
                BlockStateProvider.simple(BlockInit.ATLANTEAN_LEAVES.get()),

                new RandomSpreadFoliagePlacer(ConstantInt.of(3), ConstantInt.of(3), ConstantInt.of(3), 256),
                Optional.empty(),
                new TwoLayersFeatureSize(1, 0, 1, OptionalInt.of(5)))
                        .dirt(BlockStateProvider.simple(BlockInit.SEABED.get())).ignoreVines().build()
        );

        register(context, ATLANTEAN_PALM_TREE_CONFIGURED, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(BlockInit.PALM_LOG.get().defaultBlockState().setValue(PalmLog.AXIS, Direction.Axis.Y)),
                new StraightTrunkPlacer(5, 2, 2),
                BlockStateProvider.simple(BlockInit.PALM_LEAVES.get().defaultBlockState().setValue(PalmLeavesBlock.DISTANCE, 7).setValue(PalmLeavesBlock.PERSISTENT, false).setValue(PalmLeavesBlock.WATERLOGGED, false)),
                new AcaciaFoliagePlacer(ConstantInt.of(3), ConstantInt.ZERO),
                Optional.empty(),
                new TwoLayersFeatureSize(1, 0, 1)).dirt(BlockStateProvider.simple(Blocks.SANDSTONE))
                        .decorators(List.of(new WaterAttachedToLeavesDecorator(0.25f, 0, 0, BlockStateProvider.simple(BlockInit.COCONUT.get().defaultBlockState()), List.of(Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST))))
                .ignoreVines().build());
        registerNone(context, ATLANTEAN_GLOWSTONES_CONFIGURED, AtlantisFeature.ATLANTEAN_GLOWSTONES_FEATURE);
        registerNone(context, ATLANTEAN_ISLANDS_CONFIGURED, AtlantisFeature.ATLANTEAN_ISLANDS);
        registerNone(context, ATLANTEAN_VOLCANO_CONFiGURED, AtlantisFeature.ATLANTEAN_VOLCANO);
        registerNone(context, UNDERWATER_FLOWER_CONFIGURED, AtlantisFeature.UNDERWATER_FLOWER_ATLANTIS);
        registerNone(context, GARDEN_FOLIAGE_CONFIGURED, AtlantisFeature.GARDEN_FOLIAGE_PLACER_ATLANTIS);
        registerLake(context, JETSTREAM_LAKE_CONFIGURED, BlockInit.JETSTREAM_WATER_BLOCK.get(), Blocks.STONE);
        registerNone(context, UNDERWATER_MUSHROOM_CONFIGURED, AtlantisFeature.UNDERWATER_MUSHROOM_ATLANTIS);
        registerLake(context, SALTY_SEA_LAKE_CONFIGURED, BlockInit.SALTY_SEA_WATER_BLOCK.get(), Blocks.STONE);
        registerNone(context, SHELL_BLOCK_CONFIGURED, AtlantisFeature.SHELL_BLOCK_FEATURE);

    }

    private static void registerLake(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, Block fluid, Block barrier) {
        register(context, key, Feature.LAKE, new LakeFeature.Configuration(BlockStateProvider.simple(fluid), BlockStateProvider.simple(barrier)));
    }

    private static <T extends Block, V extends Block> void registerOre(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, RegistryObject<Block> regular, RegistryObject<Block> deepslate, int size, int discardChanceOnAirExposure) {
        register(context, key, Feature.ORE, new OreConfiguration(List.of(
                OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), regular.get().defaultBlockState()),
                OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), deepslate.get().defaultBlockState())

        ), size, discardChanceOnAirExposure));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<FC, F>(feature, configuration));
    }

    private static <T extends Feature<NoneFeatureConfiguration>> void registerNone(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, RegistryObject<T> holder) {
        context.register(key, new ConfiguredFeature<NoneFeatureConfiguration, T>(holder.get(), FeatureConfiguration.NONE));
    }
}
