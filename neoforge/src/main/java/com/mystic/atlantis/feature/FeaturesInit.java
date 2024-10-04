package com.mystic.atlantis.feature;

import com.mojang.serialization.Codec;
import com.mystic.atlantis.util.Reference;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;
import java.util.function.Supplier;

public class FeaturesInit {

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(BuiltInRegistries.FEATURE, Reference.MODID);

    public static void init(IEventBus bus) {
        FEATURES.register(bus);
    }

    public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> UNDERWATER_FLOWER_ATLANTIS = registerNone("underwater_flower_feature",UnderwaterFlowerAtlantis::new);
    public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> GARDEN_FOLIAGE_PLACER_ATLANTIS = registerNone("garden_foliage_feature", GardenFoliagePlacerAtlantis::new);
    public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> SHELL_BLOCK_FEATURE = registerNone("shell_block_feature", ShellBlockFeature::new);
    public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> ATLANTEAN_ISLANDS = registerNone("atlantean_islands_feature", AtlanteanIslands::new);
    public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> ATLANTEAN_VOLCANO = registerNone("atlantean_volcano_feature", AtlanteanVolcano::new);
    public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> UNDERWATER_MUSHROOM_ATLANTIS = registerNone("underwater_mushroom", UnderwaterMushroomAtlantis::new);
    public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> ATLANTEAN_GLOWSTONES_FEATURE = registerNone("atlantean_glowstones_feature", AtlanteanGlowstonesFeature::new);

    public static <T extends FeatureConfiguration> DeferredHolder<Feature<?>, Feature<T>> register(String id, Supplier<Feature<T>> t) {
        return FEATURES.register(id, t);
    }

    public static <T extends FeatureConfiguration> DeferredHolder<Feature<?>, Feature<T>> registerNone(String id, Function<Codec<NoneFeatureConfiguration>, Feature<T>> function) {
        return FEATURES.register(id, () -> function.apply(NoneFeatureConfiguration.CODEC));
    }
}

