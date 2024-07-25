package com.mystic.atlantis.datagen;

import com.mystic.atlantis.Atlantis;
import com.mystic.atlantis.TagsInit;
import com.mystic.atlantis.init.AtlantisEntityInit;
import com.mystic.atlantis.structures.*;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.WeightedRandomList;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.heightproviders.ConstantHeight;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSpawnOverride;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;
import net.minecraft.world.level.levelgen.structure.pools.DimensionPadding;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.structures.JigsawStructure;
import net.minecraft.world.level.levelgen.structure.templatesystem.LiquidSettings;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class StructureInit {
    public static final ResourceKey<Structure> ATLANTEAN_VILLAGE = key("atlantean_village");
    public static final ResourceKey<Structure> CONFIGURED_ATLANTEAN_FOUNTAIN = key("configured_atlantean_fountain");
    public static final ResourceKey<Structure> CONFIGURED_ATLANTEAN_HOUSE_1 = key("configured_atlantean_house_1");
    public static final ResourceKey<Structure> CONFIGURED_ATLANTEAN_HOUSE_3 = key("configured_atlantean_house_3");
    public static final ResourceKey<Structure> CONFIGURED_ATLANTEAN_SPIRE = key("configured_atlantean_spire");
    public static final ResourceKey<Structure> CONFIGURED_ATLANTEAN_TEMPLE = key("configured_atlantean_temple");
    public static final ResourceKey<Structure> CONFIGURED_ATLANTEAN_TOWER = key("configured_atlantean_tower");
    public static final ResourceKey<Structure> CONFIGURED_OYSTER_STRUCTURE = key("configured_oyster_structure");

    private static ResourceKey<Structure> key(String name) {
        return ResourceKey.create(Registries.STRUCTURE, Atlantis.id(name));
    }

    public StructureInit(BootstrapContext<Structure> context) {
        HolderGetter<Biome> holderGetter = context.lookup(Registries.BIOME);
        HolderGetter<StructureTemplatePool> holderGetter1 = context.lookup(Registries.TEMPLATE_POOL);

        context.register(ATLANTEAN_VILLAGE, new JigsawStructure(
                new Structure.StructureSettings.Builder(
                        holderGetter.getOrThrow(TagsInit.Biome.HAS_ATLANTEAN_VILLAGE))
                        .generationStep(GenerationStep.Decoration.SURFACE_STRUCTURES)
                        .spawnOverrides(Map.of(MobCategory.WATER_AMBIENT, new StructureSpawnOverride(StructureSpawnOverride.BoundingBoxType.STRUCTURE,
                                WeightedRandomList.create(new MobSpawnSettings.SpawnerData(EntityType.TROPICAL_FISH,
                                        25, 4, 10)))))
                        .spawnOverrides(Map.of(MobCategory.WATER_CREATURE, new StructureSpawnOverride(StructureSpawnOverride.BoundingBoxType.STRUCTURE,
                                WeightedRandomList.create(new MobSpawnSettings.SpawnerData(AtlantisEntityInit.STARFISH.get(),
                                        25, 3, 6)))))
                        .terrainAdapation(TerrainAdjustment.BEARD_THIN)
                        .build(),
                holderGetter1.getOrThrow(TemplatePoolInit.ATLANTEAN_VILLAGE_START).getDelegate(),
                Optional.empty(),
                6, ConstantHeight.of(VerticalAnchor.absolute(0)),
                true, Optional.of(Heightmap.Types.OCEAN_FLOOR_WG),
                112, List.of(), DimensionPadding.ZERO,
                LiquidSettings.APPLY_WATERLOGGING));

        context.register(CONFIGURED_ATLANTEAN_FOUNTAIN, new AtlanteanFountain(
                new Structure.StructureSettings.Builder(
                        holderGetter.getOrThrow(TagsInit.Biome.HAS_CONFIGURED_ATLANTEAN_FOUNTAIN))
                        .generationStep(GenerationStep.Decoration.SURFACE_STRUCTURES)
                        .spawnOverrides(Map.of(MobCategory.WATER_AMBIENT, new StructureSpawnOverride(StructureSpawnOverride.BoundingBoxType.STRUCTURE,
                                WeightedRandomList.create(new MobSpawnSettings.SpawnerData(EntityType.TROPICAL_FISH,
                                        25, 4, 10)))))
                        .spawnOverrides(Map.of(MobCategory.WATER_CREATURE, new StructureSpawnOverride(StructureSpawnOverride.BoundingBoxType.STRUCTURE,
                                WeightedRandomList.create(new MobSpawnSettings.SpawnerData(AtlantisEntityInit.STARFISH.get(),
                                        25, 3, 6)))))
                        .terrainAdapation(TerrainAdjustment.NONE)
                        .build(),
                holderGetter1.getOrThrow(TemplatePoolInit.ATLANTEAN_FOUNTAIN).getDelegate(),
                Optional.empty(),
                1, ConstantHeight.of(VerticalAnchor.absolute(0)), Optional.of(Heightmap.Types.OCEAN_FLOOR_WG),
                1));

        context.register(CONFIGURED_ATLANTEAN_HOUSE_1, new AtlantisHouse1(
                new Structure.StructureSettings.Builder(
                        holderGetter.getOrThrow(TagsInit.Biome.HAS_CONFIGURED_ATLANTEAN_HOUSE_1))
                        .generationStep(GenerationStep.Decoration.SURFACE_STRUCTURES)
                        .spawnOverrides(Map.of(MobCategory.WATER_AMBIENT, new StructureSpawnOverride(StructureSpawnOverride.BoundingBoxType.STRUCTURE,
                                WeightedRandomList.create(new MobSpawnSettings.SpawnerData(EntityType.TROPICAL_FISH,
                                        25, 4, 10)))))
                        .terrainAdapation(TerrainAdjustment.NONE)
                        .build(),
                holderGetter1.getOrThrow(TemplatePoolInit.ATLANTIS_HOUSE_1).getDelegate(),
                Optional.empty(),
                1, ConstantHeight.of(VerticalAnchor.absolute(0)), Optional.of(Heightmap.Types.OCEAN_FLOOR_WG),
                1));

        context.register(CONFIGURED_ATLANTEAN_HOUSE_3, new AtlantisHouse3(
                new Structure.StructureSettings.Builder(
                        holderGetter.getOrThrow(TagsInit.Biome.HAS_CONFIGURED_ATLANTEAN_HOUSE_3))
                        .generationStep(GenerationStep.Decoration.SURFACE_STRUCTURES)
                        .spawnOverrides(Map.of(MobCategory.WATER_AMBIENT, new StructureSpawnOverride(StructureSpawnOverride.BoundingBoxType.STRUCTURE,
                                WeightedRandomList.create(new MobSpawnSettings.SpawnerData(EntityType.TROPICAL_FISH,
                                        25, 4, 10)))))
                        .terrainAdapation(TerrainAdjustment.NONE)
                        .build(),
                holderGetter1.getOrThrow(TemplatePoolInit.ATLANTIS_HOUSE_3).getDelegate(),
                Optional.empty(),
                1, ConstantHeight.of(VerticalAnchor.absolute(0)), Optional.of(Heightmap.Types.OCEAN_FLOOR_WG),
                1));

        context.register(CONFIGURED_ATLANTEAN_SPIRE, new AtlanteanFountain(
                new Structure.StructureSettings.Builder(
                        holderGetter.getOrThrow(TagsInit.Biome.HAS_CONFIGURED_ATLANTEAN_SPIRE))
                        .generationStep(GenerationStep.Decoration.SURFACE_STRUCTURES)
                        .spawnOverrides(Map.of(MobCategory.WATER_AMBIENT, new StructureSpawnOverride(StructureSpawnOverride.BoundingBoxType.STRUCTURE,
                                WeightedRandomList.create(new MobSpawnSettings.SpawnerData(EntityType.TROPICAL_FISH,
                                        25, 4, 10)))))
                        .spawnOverrides(Map.of(MobCategory.MONSTER, new StructureSpawnOverride(StructureSpawnOverride.BoundingBoxType.STRUCTURE,
                                WeightedRandomList.create(new MobSpawnSettings.SpawnerData(AtlantisEntityInit.ATLANTEAN_ZOMBIE_STARFISH.get(),
                                        25, 3, 6)))))
                        .spawnOverrides(Map.of(MobCategory.MONSTER, new StructureSpawnOverride(StructureSpawnOverride.BoundingBoxType.STRUCTURE,
                                WeightedRandomList.create(new MobSpawnSettings.SpawnerData(EntityType.DROWNED,
                                        25, 6, 12)))))
                        .terrainAdapation(TerrainAdjustment.NONE)
                        .build(),
                holderGetter1.getOrThrow(TemplatePoolInit.ATLANTEAN_SPIRE).getDelegate(),
                Optional.empty(),
                1, ConstantHeight.of(VerticalAnchor.absolute(0)), Optional.of(Heightmap.Types.OCEAN_FLOOR_WG),
                1));

        context.register(CONFIGURED_ATLANTEAN_TEMPLE, new AtlanteanTemple(
                new Structure.StructureSettings.Builder(
                        holderGetter.getOrThrow(TagsInit.Biome.HAS_CONFIGURED_ATLANTEAN_TEMPLE))
                        .generationStep(GenerationStep.Decoration.SURFACE_STRUCTURES)
                        .spawnOverrides(Map.of(MobCategory.WATER_AMBIENT, new StructureSpawnOverride(StructureSpawnOverride.BoundingBoxType.STRUCTURE,
                                WeightedRandomList.create(new MobSpawnSettings.SpawnerData(EntityType.TROPICAL_FISH,
                                        25, 4, 10)))))
                        .spawnOverrides(Map.of(MobCategory.MONSTER, new StructureSpawnOverride(StructureSpawnOverride.BoundingBoxType.STRUCTURE,
                                WeightedRandomList.create(new MobSpawnSettings.SpawnerData(EntityType.GUARDIAN,
                                        25, 2, 5)))))
                        .terrainAdapation(TerrainAdjustment.NONE)
                        .build(),
                holderGetter1.getOrThrow(TemplatePoolInit.ATLANTEAN_TEMPLE).getDelegate(),
                Optional.empty(),
                1, ConstantHeight.of(VerticalAnchor.absolute(0)), Optional.of(Heightmap.Types.OCEAN_FLOOR_WG),
                1));

        context.register(CONFIGURED_ATLANTEAN_TOWER, new AtlantisTower(
                new Structure.StructureSettings.Builder(
                        holderGetter.getOrThrow(TagsInit.Biome.HAS_CONFIGURED_ATLANTEAN_TOWER))
                        .generationStep(GenerationStep.Decoration.SURFACE_STRUCTURES)
                        .spawnOverrides(Map.of(MobCategory.WATER_AMBIENT, new StructureSpawnOverride(StructureSpawnOverride.BoundingBoxType.STRUCTURE,
                                WeightedRandomList.create(new MobSpawnSettings.SpawnerData(EntityType.TROPICAL_FISH,
                                        25, 4, 10)))))
                        .terrainAdapation(TerrainAdjustment.NONE)
                        .build(),
                holderGetter1.getOrThrow(TemplatePoolInit.ATLANTIS_TOWER).getDelegate(),
                Optional.empty(),
                1, ConstantHeight.of(VerticalAnchor.absolute(0)), Optional.of(Heightmap.Types.OCEAN_FLOOR_WG),
                1));

        context.register(CONFIGURED_OYSTER_STRUCTURE, new OysterStructure(
                new Structure.StructureSettings.Builder(
                        holderGetter.getOrThrow(TagsInit.Biome.HAS_CONFIGURED_OYSTER_STRUCTURE))
                        .generationStep(GenerationStep.Decoration.SURFACE_STRUCTURES)
                        .spawnOverrides(Map.of(MobCategory.WATER_AMBIENT, new StructureSpawnOverride(StructureSpawnOverride.BoundingBoxType.STRUCTURE,
                                WeightedRandomList.create(new MobSpawnSettings.SpawnerData(EntityType.TROPICAL_FISH,
                                        25, 4, 10)))))
                        .spawnOverrides(Map.of(MobCategory.WATER_CREATURE, new StructureSpawnOverride(StructureSpawnOverride.BoundingBoxType.STRUCTURE,
                                WeightedRandomList.create(new MobSpawnSettings.SpawnerData(AtlantisEntityInit.STARFISH.get(),
                                        25, 3, 6)))))
                        .terrainAdapation(TerrainAdjustment.NONE)
                        .build(),
                holderGetter1.getOrThrow(TemplatePoolInit.OYSTER_STRUCTURE).getDelegate(),
                Optional.empty(),
                1, ConstantHeight.of(VerticalAnchor.absolute(0)), Optional.of(Heightmap.Types.OCEAN_FLOOR_WG),
                1));

    }
}
