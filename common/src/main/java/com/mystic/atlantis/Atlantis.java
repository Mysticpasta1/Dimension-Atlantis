package com.mystic.atlantis;

import com.mystic.atlantis.init.*;
import com.mystic.atlantis.items.armor.BasicArmorMaterial;
import net.minecraft.resources.ResourceLocation;

public class Atlantis {
    public static void init() {
        onInitialize();

    }

    public static void onInitialize() {
        BlockInit.init();
        BasicArmorMaterial.init();
        ItemInit.init();
        PaintingVariantsInit.init();
        TileEntityInit.init();
        FluidTypesInit.init();
        AtlantisGroupInit.init();
        FluidInit.init();
        AtlantisEntityInit.init();
        AtlantisSoundEventInit.init();
        EffectsInit.init();
        EnchantmentInit.init();
        MenuTypeInit.init();
        RecipesInit.init();
        POITypesInit.init();
        DimensionAtlantis.init(bus);
        ModParticleTypes.init(bus);
        FeaturesInit.init(bus);
        AtlantisStructures.init(bus);
    }

    public static ResourceLocation id(String id) {
        return ResourceLocation.fromNamespaceAndPath("atlantis", id);
    }
}
