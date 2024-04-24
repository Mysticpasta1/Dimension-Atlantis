package com.mystic.atlantis.blocks.base;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;

public class SeaBedBlock extends Block {
	
    public SeaBedBlock(Properties settings) {
        super(settings
        		.strength(1.0f, 6.0f)
        		.sound(SoundType.STONE)
        		.requiresCorrectToolForDrops());
    }
}
