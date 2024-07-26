package com.mystic.atlantis.dimension;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.MapCodec;
import com.mystic.atlantis.datagen.BiomeInit;
import com.mystic.atlantis.datagen.NoiseSettingsInit;
import com.mystic.atlantis.util.Reference;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.server.ServerStartedEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = Reference.MODID, value = Dist.DEDICATED_SERVER)
public class DimensionAtlantis {
    public static final DeferredRegister<MapCodec<? extends BiomeSource>> BIOME_SOURCE = DeferredRegister.create(BuiltInRegistries.BIOME_SOURCE, Reference.MODID);
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

    @SubscribeEvent
    public static void onServerStarted(ServerStartedEvent event) {
        DimensionAtlantis.ATLANTIS_TYPE = event.getServer().registryAccess().registryOrThrow(Registries.DIMENSION_TYPE).get(ATLANTIS_DIMENSION_TYPE_KEY);
        DimensionAtlantis.ATLANTIS_DIMENSION = event.getServer().getLevel(ATLANTIS_WORLD);
    }

    public static void init(IEventBus bus) {
        BIOME_SOURCE.register(bus);
    }

    public DimensionAtlantis(BootstrapContext<LevelStem> context) {
        var holderGetter = context.lookup(Registries.BIOME);
        var holderGetter1 = context.lookup(Registries.DIMENSION_TYPE);
        var holderGetter2 = context.lookup(Registries.NOISE_SETTINGS);
        context.register(ATLANTIS_DIMENSION_STEM, new LevelStem(holderGetter1.getOrThrow(ATLANTIS_DIMENSION_TYPE_KEY),
               new NoiseBasedChunkGenerator(MultiNoiseBiomeSource.createFromList(
                       new Climate.ParameterList<>(
                               List.of(
                                       Pair.of(Climate.parameters(0.2F, 0.2F, 0.2F, 0.5F, 0.1F, 0.1F, 0.1F), holderGetter.getOrThrow(BiomeInit.GOO_LAGOONS_KEY).getDelegate()),
                                       Pair.of(Climate.parameters(0.2F, 0.2F, 0.3F, 0.5F, 0.1F, 0.1F, 0.1F), holderGetter.getOrThrow(BiomeInit.COCONUT_ISLES_KEY).getDelegate()),
                                       Pair.of(Climate.parameters(0.5F, 0.4F, 0.3F, 0.2F, 0.2F, 0.1F, 0.3F), holderGetter.getOrThrow(BiomeInit.ATLANTEAN_GARDEN_KEY).getDelegate()),
                                       Pair.of(Climate.parameters(0.2F, 0.2F, 0.1F, 0.2F, 0.2F, 0.1F, 0.3F), holderGetter.getOrThrow(BiomeInit.ATLANTIS_BIOME_KEY).getDelegate()),
                                       Pair.of(Climate.parameters(0.0F, 0.3F, 0.2F, 0.2F, 0.2F, 0.2F, 0.3F), holderGetter.getOrThrow(BiomeInit.JELLYFISH_FIELDS_KEY).getDelegate()),
                                       Pair.of(Climate.parameters(0.2F, 0.0F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F), holderGetter.getOrThrow(BiomeInit.ATLANTEAN_ISLANDS_BIOME_KEY).getDelegate()),
                                       Pair.of(Climate.parameters(0.1F, 0.1F, 0.3F, 0.2F, 0.2F, 0.1F, 0.2F), holderGetter.getOrThrow(BiomeInit.VOLCANIC_DARKSEA_KEY).getDelegate())
                               ))), holderGetter2.getOrThrow(ATLANTIS_DIMENSION_NOISE_SETTING).getDelegate())));
    }
}
