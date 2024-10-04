package com.mystic.atlantis.blocks.blockentities.plants;

import com.mystic.atlantis.init.TileEntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class AnemoneTileEntity extends GeneralPlantBlockEntity<AnemoneTileEntity> {
    public AnemoneTileEntity(BlockPos targetPos, BlockState targetState) {
        super(TileEntityInit.ANEMONE_TILE, "anemone_controller", targetPos, targetState);
    }
}
