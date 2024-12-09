package com.mystic.atlantis.blocks.base;

import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class CoconutSlice extends SlabBlock {
    public CoconutSlice(BlockBehaviour.Properties pProperties) {
        super(pProperties
                .sound(SoundType.CHERRY_WOOD)
                .requiresCorrectToolForDrops()
                .strength(3.0F, 6.0F));
    }
}
