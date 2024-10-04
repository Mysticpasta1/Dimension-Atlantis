package com.mystic.atlantis.dimension;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.MapCodec;
import com.mystic.atlantis.datagen.BiomeInit;
import com.mystic.atlantis.util.Reference;
import dev.architectury.event.events.common.LifecycleEvent;
import dev.architectury.registry.registries.DeferredRegister;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.MultiNoiseBiomeSource;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;

import java.util.List;

public class DimensionAtlantis {
    public static final DeferredRegister<MapCodec<? extends BiomeSource>> BIOME_SOURCE = DeferredRegister.create(Reference.MODID, Registries.BIOME_SOURCE);
    public static ResourceKey<Level> ATLANTIS_WORLD = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("atlantis:atlantis"));
    public static final ResourceKey<DimensionType> ATLANTIS_DIMENSION_TYPE_KEY = ResourceKey.create(Registries.DIMENSION_TYPE, ResourceLocation.parse("atlantis:atlantis"));
    public static final ResourceLocation ATLANTIS_DIMENSION_EFFECT = ResourceLocation.fromNamespaceAndPath("atlantis","skyeffect");
    public static ResourceKey<LevelStem> ATLANTIS_DIMENSION_STEM = ResourceKey.create(Registries.LEVEL_STEM, ResourceLocation.parse("atlantis:atlantis"));

    public static DimensionType ATLANTIS_TYPE;

    public static ServerLevel ATLANTIS_DIMENSION;
    public static ResourceKey<NoiseGeneratorSettings> ATLANTIS_DIMENSION_NOISE_SETTING = ResourceKey.create(Registries.NOISE_SETTINGS, ResourceLocation.parse("atlantis:atlantis"));;

    public static boolean isAtlantisDimension(Level world) {
        return world != null && world.dimension().equals(ATLANTIS_WORLD);
    }

    public static void onServerStarted(MinecraftServer event) {
        DimensionAtlantis.ATLANTIS_TYPE = event.registryAccess().registryOrThrow(Registries.DIMENSION_TYPE).get(ATLANTIS_DIMENSION_TYPE_KEY);
        DimensionAtlantis.ATLANTIS_DIMENSION = event.getLevel(ATLANTIS_WORLD);
    }

    public static void init() {
        LifecycleEvent.SERVER_STARTED.register(DimensionAtlantis::onServerStarted);
        BIOME_SOURCE.register();
    }

    public DimensionAtlantis(BootstrapContext<LevelStem> context) {
        var holderGetter = context.lookup(Registries.BIOME);
        var holderGetter1 = context.lookup(Registries.DIMENSION_TYPE);
        var holderGetter2 = context.lookup(Registries.NOISE_SETTINGS);
        context.register(ATLANTIS_DIMENSION_STEM, new LevelStem(holderGetter1.getOrThrow(ATLANTIS_DIMENSION_TYPE_KEY),
               new NoiseBasedChunkGenerator(MultiNoiseBiomeSource.createFromList(
                       new Climate.ParameterList<>(
                               List.of(
                                       Pair.of(Climate.parameters(0.2F, 0.2F, 0.2F, 0.5F, 0.1F, 0.1F, 0.1F), holderGetter.get(BiomeInit.GOO_LAGOONS_KEY).get()),
                                       Pair.of(Climate.parameters(0.2F, 0.2F, 0.3F, 0.5F, 0.1F, 0.1F, 0.1F), holderGetter.get(BiomeInit.COCONUT_ISLES_KEY).get()),
                                       Pair.of(Climate.parameters(0.5F, 0.4F, 0.3F, 0.2F, 0.2F, 0.1F, 0.3F), holderGetter.get(BiomeInit.ATLANTEAN_GARDEN_KEY).get()),
                                       Pair.of(Climate.parameters(0.2F, 0.2F, 0.1F, 0.2F, 0.2F, 0.1F, 0.3F), holderGetter.get(BiomeInit.ATLANTIS_BIOME_KEY).get()),
                                       Pair.of(Climate.parameters(0.0F, 0.3F, 0.2F, 0.2F, 0.2F, 0.2F, 0.3F), holderGetter.get(BiomeInit.JELLYFISH_FIELDS_KEY).get()),
                                       Pair.of(Climate.parameters(0.2F, 0.0F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F), holderGetter.get(BiomeInit.ATLANTEAN_ISLANDS_BIOME_KEY).get()),
                                       Pair.of(Climate.parameters(0.1F, 0.1F, 0.3F, 0.2F, 0.2F, 0.1F, 0.2F), holderGetter.get(BiomeInit.VOLCANIC_DARKSEA_KEY).get())
                               ))), holderGetter2.get(ATLANTIS_DIMENSION_NOISE_SETTING).get())));
    }
}
