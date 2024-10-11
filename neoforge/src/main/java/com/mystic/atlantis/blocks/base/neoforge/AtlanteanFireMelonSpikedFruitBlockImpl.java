package com.mystic.atlantis.blocks.base.neoforge;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.CommonHooks;
import net.neoforged.neoforge.common.ItemAbilities;

public class AtlanteanFireMelonSpikedFruitBlockImpl {
    public static boolean canCropGrow(ServerLevel level, BlockPos targetPos, BlockState targetState, boolean b) {
        return CommonHooks.canCropGrow(level, targetPos, targetState, b);
    }

    public static void fireCropGrowPost(ServerLevel level, BlockPos targetPos, BlockState targetState) {
        CommonHooks.fireCropGrowPost(level, targetPos, targetState);
    }

    public static boolean canShear(ItemStack mainHandStack) {
        return mainHandStack.canPerformAction(ItemAbilities.SHEARS_CARVE);
    }
}
