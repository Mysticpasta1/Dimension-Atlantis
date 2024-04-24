package com.mystic.atlantis.blocks.blockentities.plants;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.RegistryObject;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

public class GeneralPlantBlockEntity<T extends GeneralPlantBlockEntity<?>> extends BlockEntity implements IAnimatable {
    private final AnimationFactory factory = GeckoLibUtil.createFactory(this);
    private final AnimationController<T> mainController;

    public GeneralPlantBlockEntity(RegistryObject<BlockEntityType<T>> registryObject, String name, BlockPos targetPos, BlockState targetState) {
        super(registryObject.get(), targetPos, targetState);
        mainController = new AnimationController<T>((T) this, name, 0, this::predicate);
    }

    private <E extends BlockEntity & IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        AnimationController<?> controller = event.getController();
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData controllerRegistrar) {
        controllerRegistrar.addAnimationController(mainController);
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }
}
