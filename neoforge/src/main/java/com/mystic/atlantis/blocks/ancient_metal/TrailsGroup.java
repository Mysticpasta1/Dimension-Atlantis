package com.mystic.atlantis.blocks.ancient_metal;

import net.minecraft.world.level.block.*;
import net.minecraftforge.registries.RegistryObject;

public record TrailsGroup(
       RegistryObject<WeatheringMetalFullBlock> block,
       RegistryObject<WeatheringMetalFullBlock> cut,
       RegistryObject<WeatheringMetalFullBlock> chiseled,
       RegistryObject<WeatheringMetalStairBlock> cut_stairs,
       RegistryObject<WeatheringMetalSlabBlock> cut_slab,
       RegistryObject<WeatheringMetalDoorBlock> door,
       RegistryObject<WeatheringMetalTrapDoorBlock> trapdoor,
       RegistryObject<WeatheringMetalGrateBlock> grate,
       RegistryObject<WeatheringMetalBulbBlock> bulb,
       RegistryObject<Block> waxed_block,
       RegistryObject<Block> waxed_cut,
       RegistryObject<Block> waxed_chiseled,
       RegistryObject<StairBlock> waxed_cut_stairs,
       RegistryObject<SlabBlock> waxed_cut_slab,
       RegistryObject<DoorBlock> waxed_door,
       RegistryObject<TrapDoorBlock> waxed_trapdoor,
       RegistryObject<Block> waxed_grate,
       RegistryObject<MetalBulbBlock> waxed_bulb) {
}
