package com.mystic.atlantis.mixin;

import com.mystic.atlantis.blocks.base.PushBubbleColumnBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BlockBehaviour.class)
public class BlockBehaviourMixin {
    @Inject(method = "onRemove", at = @At("TAIL"))
    private void addPushBubbleColumn(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pMovedByPiston, CallbackInfo ci) {
        if(!pLevel.isClientSide() && pState.isSolid()) {
            PushBubbleColumnBlock.update((ServerLevel) pLevel, pPos);
        }
    }
}
