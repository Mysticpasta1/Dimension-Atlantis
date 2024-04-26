package com.mystic.atlantis.entities.renders;

import com.mystic.atlantis.entities.SeahorseEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SeahorseEntityRenderer extends GeoEntityRenderer<SeahorseEntity> {

    public SeahorseEntityRenderer(EntityRendererProvider.Context renderManager, GeoModel<SeahorseEntity> modelProvider) {
        super(renderManager, modelProvider);
    }
}
