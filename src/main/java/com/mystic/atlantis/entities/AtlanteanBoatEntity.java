package com.mystic.atlantis.entities;

import com.mystic.atlantis.init.ItemInit;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

public class AtlanteanBoatEntity extends Boat implements IAnimatable {

    private AnimationFactory factory = GeckoLibUtil.createFactory(this);

    public AtlanteanBoatEntity(EntityType<? extends Boat> arg, Level arg2) {
        super(arg, arg2);
    }

    @Override
    public @NotNull Item getDropItem() {
        return ItemInit.ATLANTEAN_BOAT.get();
    }

    @Override
    public void registerControllers(AnimationData data) {}

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }
}
