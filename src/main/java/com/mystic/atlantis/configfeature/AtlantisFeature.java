package com.mystic.atlantis.configfeature;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.CountConfig;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.UniformIntDistribution;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import com.mystic.atlantis.init.BlockInit;
import com.mystic.atlantis.util.Reference;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;

public class AtlantisFeature {
    public static final Feature<CountConfig> UNDERWATER_FLOWER_ATLANTIS = register(
            "underwater_flower_atlantis", new UnderwaterFlowerAtlantis(CountConfig.CODEC));
    public static final Feature<DefaultFeatureConfig> ALGAE_FEATURE_ATLANTIS = register(
            "algae_feature_atlantis", new AlgaeFeatureAtlantis(DefaultFeatureConfig.CODEC));
    public static final Feature<CountConfig> SHELL_BLOCK_FEATURE = register(
            "shell_block_feature", new ShellBlockFeature(CountConfig.CODEC));
    public static final Feature<AtlantisOreFeatureConfig> AQUAMARINE_ORE_FEATURE = register(
            "aquamarine_ore_feature", new AquamarineOreFeature(AtlantisOreFeatureConfig.CODEC));

    public static <T extends FeatureConfig> Feature<T> register(String id, Feature<T> t) {
        Registry.register(Registry.FEATURE, new Identifier(Reference.MODID, id), t);
        return t;
    }
    
    public static final int l = 20;

    public static final class ConfiguredFeaturesAtlantis {
        public static final ConfiguredFeature<?, ?> UNDERWATER_FLOWER_ATLANTIS = AtlantisFeature.UNDERWATER_FLOWER_ATLANTIS.configure(new CountConfig(UniformIntDistribution.of(l)));
        public static final ConfiguredFeature<?, ?> ALGAE_FEATURE_ATLANTIS = AtlantisFeature.ALGAE_FEATURE_ATLANTIS.configure(FeatureConfig.DEFAULT);
        public static final ConfiguredFeature<?, ?> SHELL_BLOCK_FEATURE = AtlantisFeature.SHELL_BLOCK_FEATURE.configure(new CountConfig(UniformIntDistribution.of(l)));
        public static final ConfiguredFeature<?, ?> AQUAMARINE_ORE_FEATURE = AtlantisFeature.AQUAMARINE_ORE_FEATURE.configure(new AtlantisOreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, BlockInit.AQUAMARINE_ORE.getDefaultState(), 30, "Aquamarine_Ore_Feature_Configuration"));

        public static final RegistryKey<ConfiguredFeature<?,?>> UNDERWATER_FLOWER_ATLANTIS_KEY = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier(Reference.MODID, "underwater_flower_altantis"));
        public static final RegistryKey<ConfiguredFeature<?,?>> ALGAE_FEATURE_ATLANTIS_KEY = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier(Reference.MODID, "algae_feature_altantis"));
        public static final RegistryKey<ConfiguredFeature<?,?>> SHELL_BLOCK_FEATURE_KEY = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier(Reference.MODID, "shell_block_feature"));
        public static final RegistryKey<ConfiguredFeature<?,?>> AQUAMARINE_ORE_FEATURE_KEY = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier(Reference.MODID, "aquamarine_ore_feature"));

        public static void registerConfiguredFeatures() {
            
            register("underwater_flower_altantis", ConfiguredFeaturesAtlantis.UNDERWATER_FLOWER_ATLANTIS.rangeOf(32).spreadHorizontally().repeat(100));

            register("algae_feature_altantis", ConfiguredFeaturesAtlantis.ALGAE_FEATURE_ATLANTIS.rangeOf(32).spreadHorizontally().repeat(80));

            register("shell_block_feature", ConfiguredFeaturesAtlantis.SHELL_BLOCK_FEATURE.rangeOf(32).spreadHorizontally().repeat(100));

            register("aquamarine_ore_feature", ConfiguredFeaturesAtlantis.AQUAMARINE_ORE_FEATURE.rangeOf(15).spreadHorizontally().repeat(30));

            BiomeModifications.create(new Identifier(Reference.MODID, "feature_removal")).add(ModificationPhase.REMOVALS,
                    BiomeSelectors.foundInTheEnd().or(BiomeSelectors.foundInTheNether()),
                    biomeModificationContext -> {
                biomeModificationContext.getGenerationSettings().removeFeature(GenerationStep.Feature.VEGETAL_DECORATION, UNDERWATER_FLOWER_ATLANTIS_KEY);
                biomeModificationContext.getGenerationSettings().removeFeature(GenerationStep.Feature.VEGETAL_DECORATION, ALGAE_FEATURE_ATLANTIS_KEY);
                biomeModificationContext.getGenerationSettings().removeFeature(GenerationStep.Feature.SURFACE_STRUCTURES, SHELL_BLOCK_FEATURE_KEY);
                biomeModificationContext.getGenerationSettings().removeFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, AQUAMARINE_ORE_FEATURE_KEY);
            });
        }

        private static <FC extends FeatureConfig> void register(String name, ConfiguredFeature<FC, ?> feature) {
            Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Reference.MODID, name), feature);
        }
    }
}