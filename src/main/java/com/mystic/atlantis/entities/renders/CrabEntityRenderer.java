package com.mystic.atlantis.entities.renders;

import com.mystic.atlantis.entities.CrabEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class CrabEntityRenderer extends GeoEntityRenderer<CrabEntity> {

    public CrabEntityRenderer(EntityRendererProvider.Context renderManager, AnimatedGeoModel<CrabEntity> modelProvider) {
        super(renderManager, modelProvider);
    }
}
