package com.mystic.atlantis.blocks.ancient_metal;

import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.world.level.block.*;

public record TrailsGroup(
        RegistrySupplier<WeatheringMetalFullBlock> block,
        RegistrySupplier<WeatheringMetalFullBlock> cut,
        RegistrySupplier<WeatheringMetalFullBlock> chiseled,
        RegistrySupplier<WeatheringMetalStairBlock> cut_stairs,
        RegistrySupplier<WeatheringMetalSlabBlock> cut_slab,
        RegistrySupplier<WeatheringMetalDoorBlock> door,
        RegistrySupplier<WeatheringMetalTrapDoorBlock> trapdoor,
        RegistrySupplier<WeatheringMetalGrateBlock> grate,
        RegistrySupplier<WeatheringMetalBulbBlock> bulb,
        RegistrySupplier<Block> waxed_block,
        RegistrySupplier<Block> waxed_cut,
        RegistrySupplier<Block> waxed_chiseled,
        RegistrySupplier<StairBlock> waxed_cut_stairs,
        RegistrySupplier<SlabBlock> waxed_cut_slab,
        RegistrySupplier<DoorBlock> waxed_door,
        RegistrySupplier<TrapDoorBlock> waxed_trapdoor,
        RegistrySupplier<Block> waxed_grate,
        RegistrySupplier<MetalBulbBlock> waxed_bulb) {
}
