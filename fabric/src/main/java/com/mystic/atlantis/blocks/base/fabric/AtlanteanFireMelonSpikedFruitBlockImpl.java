package com.mystic.atlantis.blocks.base.fabric;

import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;

public class AtlanteanFireMelonSpikedFruitBlockImpl {
    public static boolean canCropGrow(ServerLevel level, BlockPos targetPos, BlockState targetState, boolean b) {
        return true;
    }

    public static void fireCropGrowPost(ServerLevel level, BlockPos targetPos, BlockState targetState) {
    }

    public static boolean canShear(ItemStack mainHandStack) {
        return mainHandStack.is(ConventionalItemTags.SHEAR_TOOLS);
    }
}
