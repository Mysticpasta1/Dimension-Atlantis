package com.mystic.atlantis.blocks.ancient_metal;

import java.util.function.Supplier;

public record TrailsGroup(
        Supplier<WeatheringMetalFullBlock> block,
        Supplier<WeatheringMetalFullBlock> cut,
        Supplier<WeatheringMetalFullBlock> chiseled,
        Supplier<WeatheringMetalStairBlock> cutStairs,
        Supplier<WeatheringMetalSlabBlock> cutSlab,
        Supplier<WeatheringMetalDoorBlock> door,
        Supplier<WeatheringMetalTrapDoorBlock> trapdoor,
        Supplier<WeatheringMetalGrateBlock> grate,
        Supplier<WeatheringMetalBulbBlock> bulb) {
}
