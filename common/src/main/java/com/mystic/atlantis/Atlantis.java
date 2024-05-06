package com.mystic.atlantis;

import com.mystic.atlantis.blocks.base.ExtendedBlockEntity;
import com.mystic.atlantis.config.AtlantisConfig;
import com.mystic.atlantis.dimension.DimensionAtlantis;
import com.mystic.atlantis.entities.*;
import com.mystic.atlantis.feature.AtlantisFeature;
import com.mystic.atlantis.init.*;
import com.mystic.atlantis.items.armor.BasicArmorMaterial;
import com.mystic.atlantis.particles.ModParticleTypes;
import com.mystic.atlantis.screen.LinguisticScreen;
import com.mystic.atlantis.screen.WritingScreen;
import com.mystic.atlantis.structures.AtlantisStructures;
import com.mystic.atlantis.util.Reference;
import dev.architectury.event.events.client.ClientLifecycleEvent;
import dev.architectury.event.events.common.LifecycleEvent;
import dev.architectury.hooks.item.tool.AxeItemHooks;
import dev.architectury.registry.level.entity.SpawnPlacementsRegistry;
import dev.architectury.registry.menu.MenuRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.Heightmap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Atlantis {
    public static final Logger LOGGER = LogManager.getLogger(Reference.MODID);

    public Atlantis() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, AtlantisConfig.CONFIG_SPEC);
        onInitialize();
    }

    public static ResourceLocation id(String id) {
        return new ResourceLocation("atlantis", id);
    }

    //Don't remove needed for legacy portal block!
    public static ResourceKey<Level> getOverworldKey() {
        ResourceLocation OVERWORLD_ID = LevelStem.OVERWORLD.location();
        return ResourceKey.create(Registries.DIMENSION, OVERWORLD_ID);
    }

    public static void init() {
//        GeckoLibClient.init();
        BlockInit.init();
        BasicArmorMaterial.init();
        ItemInit.init();
        PaintingVariantsInit.init();
        AtlantisModifierInit.init();
        TileEntityInit.init();
        FluidInit.init();
        AtlantisGroupInit.init();
        AtlantisEntityInit.init();
        AtlantisSoundEventInit.init();
        EffectsInit.init();
        EnchantmentInit.init();
        MenuTypeInit.init();
        RecipesInit.init();
        POITypesInit.init();
        DimensionAtlantis.init();
        ModParticleTypes.init();
        AtlantisFeature.init();
        AtlantisStructures.init();

        LifecycleEvent.SETUP.register(Atlantis::onCommonSet);

        ClientLifecycleEvent.CLIENT_SETUP.register(Atlantis::onClientSet);
    }

    public static void onClientSet(Minecraft event) {
        event.submit(() -> {
            MenuRegistry.registerScreenFactory(MenuTypeInit.LINGUISTIC.get(), LinguisticScreen::new);
            MenuRegistry.registerScreenFactory(MenuTypeInit.WRITING.get(), WritingScreen::new);
        });
    }

    public static void onCommonSet() {
        TagsInit.init();
        ((ExtendedBlockEntity) BlockEntityType.SIGN).addAdditionalValidBlock(BlockInit.ATLANTEAN_SIGNS.get(), BlockInit.ATLANTEAN_WALL_SIGN.get());
        spawnPlacements();

        AxeItemHooks.addStrippable(BlockInit.PALM_LOG.get(), BlockInit.STRIPPED_PALM_LOG.get());
        AxeItemHooks.addStrippable(BlockInit.ATLANTEAN_LOGS.get(), BlockInit.STRIPPED_ATLANTEAN_LOG.get());
    }

    public static void spawnPlacements() {
        SpawnPlacementsRegistry.register(AtlantisEntityInit.CRAB, SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, CrabEntity::canSpawn);
        SpawnPlacementsRegistry.register(AtlantisEntityInit.COCONUT_CRAB, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, CoconutCrabEntity::canSpawn);
        SpawnPlacementsRegistry.register(AtlantisEntityInit.JELLYFISH, SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, JellyfishEntity::canSpawn);
        SpawnPlacementsRegistry.register(AtlantisEntityInit.STARFISH, SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, StarfishEntity::canSpawn);
        SpawnPlacementsRegistry.register(AtlantisEntityInit.STARFISH_ZOM, SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, StarfishZomEntity::canSpawn);
        SpawnPlacementsRegistry.register(AtlantisEntityInit.SHRIMP, SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, ShrimpEntity::canSpawn);
        SpawnPlacementsRegistry.register(AtlantisEntityInit.LEVIATHAN, SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, LeviathanEntity::canSpawn);
        SpawnPlacementsRegistry.register(AtlantisEntityInit.SEAHORSE, SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SeahorseEntity::canSpawn);
    }
}
