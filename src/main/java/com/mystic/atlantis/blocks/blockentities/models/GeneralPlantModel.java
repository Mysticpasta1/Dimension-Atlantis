package com.mystic.atlantis.blocks.blockentities.models;

import com.mystic.atlantis.blocks.blockentities.plants.GeneralPlantBlockEntity;
import com.mystic.atlantis.util.Reference;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.GeckoLib;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.geo.render.built.GeoModel;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GeneralPlantModel<T extends GeneralPlantBlockEntity<?>> extends AnimatedGeoModel<T> {
    private final ResourceLocation model;
    private final ResourceLocation texture;

    public GeneralPlantModel(String name) {
        this.model = new ResourceLocation(Reference.MODID, "geo/" + name + ".geo.json");
        this.texture = new ResourceLocation(Reference.MODID, "textures/block/" + name + ".png");
    }


    @Override
    public ResourceLocation getModelResource(T object) {
        return model;
    }

    @Override
    public ResourceLocation getTextureResource(T object) {
        return texture;
    }

    @Override
    public ResourceLocation getAnimationResource(T object) {
        return new ResourceLocation(GeckoLib.ModID, "animations/jackinthebox.animation.json");
    }
}