package com.mystic.atlantis.blocks.ancient_metal;

import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.registries.DeferredHolder;

public record TrailsGroup(
        DeferredHolder<Block, WeatheringMetalFullBlock> block,
        DeferredHolder<Block, WeatheringMetalFullBlock> cut,
        DeferredHolder<Block, WeatheringMetalFullBlock> chiseled,
        DeferredHolder<Block, WeatheringMetalStairBlock> cut_stairs,
        DeferredHolder<Block, WeatheringMetalSlabBlock> cut_slab,
        DeferredHolder<Block, WeatheringMetalDoorBlock> door,
        DeferredHolder<Block, WeatheringMetalTrapDoorBlock> trapdoor,
        DeferredHolder<Block, WeatheringMetalGrateBlock> grate,
        DeferredHolder<Block, WeatheringMetalBulbBlock> bulb,
        DeferredHolder<Block, Block> waxed_block,
        DeferredHolder<Block, Block> waxed_cut,
        DeferredHolder<Block, Block> waxed_chiseled,
        DeferredHolder<Block, StairBlock> waxed_cut_stairs,
        DeferredHolder<Block, SlabBlock> waxed_cut_slab,
        DeferredHolder<Block, DoorBlock> waxed_door,
        DeferredHolder<Block, TrapDoorBlock> waxed_trapdoor,
        DeferredHolder<Block, Block> waxed_grate,
        DeferredHolder<Block, MetalBulbBlock> waxed_bulb) {
}
