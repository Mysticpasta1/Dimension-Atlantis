package com.mystic.atlantis.blocks.ancient_metal;

import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;

public record TrailsGroup(
        DeferredHolder<Block, WeatheringMetalFullBlock> block,
        DeferredHolder<Block, WeatheringMetalFullBlock> cut,
        DeferredHolder<Block, WeatheringMetalFullBlock> chiseled,
        DeferredHolder<Block, WeatheringMetalStairBlock> cutStairs,
        DeferredHolder<Block, WeatheringMetalSlabBlock> cutSlab,
        DeferredHolder<Block, WeatheringMetalDoorBlock> door,
        DeferredHolder<Block, WeatheringMetalTrapDoorBlock> trapdoor,
        DeferredHolder<Block, WeatheringMetalGrateBlock> grate,
        DeferredHolder<Block, WeatheringMetalBulbBlock> bulb) {
}
