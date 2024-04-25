package com.mystic.atlantis.entities.models;

import com.mystic.atlantis.Atlantis;
import com.mystic.atlantis.entities.CoconutCrabEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CoconutCrabEntityModel extends AnimatedGeoModel<CoconutCrabEntity> {
    @Override
    public ResourceLocation getModelResource(CoconutCrabEntity object) {
        return Atlantis.id("geo/crab.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CoconutCrabEntity entity) {
        return Atlantis.id("textures/entity/coconut_crab.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CoconutCrabEntity animatable) {
        return Atlantis.id("animations/crab.animation.json");
    }
}