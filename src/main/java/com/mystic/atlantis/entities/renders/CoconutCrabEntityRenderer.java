package com.mystic.atlantis.entities.renders;

import com.mystic.atlantis.entities.CoconutCrabEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class CoconutCrabEntityRenderer extends GeoEntityRenderer<CoconutCrabEntity> {

    public CoconutCrabEntityRenderer(EntityRendererProvider.Context renderManager, AnimatedGeoModel<CoconutCrabEntity> modelProvider) {
        super(renderManager, modelProvider);
    }
}
