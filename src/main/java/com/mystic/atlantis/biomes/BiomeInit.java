package com.mystic.atlantis.biomes;

import com.mystic.atlantis.Atlantis;
import com.mystic.atlantis.util.Reference;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public class BiomeInit {
    public static final ResourceKey<Biome> ATLANTEAN_GARDEN = key("atlantean_garden");
    public static final ResourceKey<Biome> ATLANTEAN_ISLANDS_BIOME = key("atlantean_islands_biome");
    public static final ResourceKey<Biome> ATLANTIS_BIOME = key("atlantis_biome");
    public static final ResourceKey<Biome> COCONUT_ISLES = key("coconut_isles");
    public static final ResourceKey<Biome> GOO_LAGOONS = key("goo_lagoons");
    public static final ResourceKey<Biome> JELLYFISH_FIELDS = key("jellyfish_fields");
    public static final ResourceKey<Biome> VOLCANIC_DARKSEA = key("volcanic_darksea");

    private static ResourceKey<Biome> key(String name) {
        return ResourceKey.create(Registries.BIOME, Atlantis.id(name));
    }

    public static void bootstrap(BootstrapContext<Biome> context) {
//        context.

//        register(context, "atlantean_garden", new Biome.BiomeBuilder()
//                .temperature(0.7f)
//                .hasPrecipitation(true)
//                .generationSettings(new BiomeGenerationSettings.PlainBuilder()
//                        .
//                        .build())
//                .build());
//        ));
    }

    private static void register(BootstrapContext<Biome> context, String name, Biome biome) {
        var key = ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(Reference.MODID, name));
        context.register(key, biome);
    }
}
