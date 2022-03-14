package com.mystic.atlantis.blocks.blockentities.models;

import com.mystic.atlantis.blocks.blockentities.plants.EnenmomyTileEntity;
import com.mystic.atlantis.util.Reference;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.GeckoLib;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class EnenmomyModel extends AnimatedGeoModel<EnenmomyTileEntity>
{
    @Override
    public ResourceLocation getModelLocation(EnenmomyTileEntity object)
    {
        return new ResourceLocation(Reference.MODID, "geo/enenmomy.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(EnenmomyTileEntity object)
    {
        return new ResourceLocation(Reference.MODID, "textures/block/anenomy.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(EnenmomyTileEntity object)
    {
        return new ResourceLocation(GeckoLib.ModID, "animations/jackinthebox.animation.json");
    }
}