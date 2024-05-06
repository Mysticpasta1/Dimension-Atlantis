package com.mystic.atlantis.init;

import com.mystic.atlantis.blocks.power.atlanteanstone.SodiumPrimedBombBlock;
import com.mystic.atlantis.entities.*;
import com.mystic.atlantis.util.Reference;

import dev.architectury.registry.level.entity.EntityAttributeRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

import java.util.function.Supplier;

import static net.minecraft.core.registries.Registries.ENTITY_TYPE;

public class AtlantisEntityInit {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(Reference.MODID, ENTITY_TYPE);

    //Boats
    public static final Supplier<EntityType<AtlanteanBoatEntity>> ATLANTEAN_BOAT = register("atlantean_boat", EntityType.Builder.of(AtlanteanBoatEntity::new, MobCategory.MISC).sized(1.375f, 0.5625f).clientTrackingRange(10));

    //Geckolib Creatures
    public static final Supplier<EntityType<CrabEntity>> CRAB = register("atlantean_crab", EntityType.Builder.of(CrabEntity::new, MobCategory.WATER_CREATURE).sized(1.2f, 0.3f));
    public static final Supplier<EntityType<CoconutCrabEntity>> COCONUT_CRAB = register("coconut_crab",EntityType.Builder.of(CoconutCrabEntity::new, MobCategory.CREATURE).sized(1.2f, 0.3f));
    public static final Supplier<EntityType<JellyfishEntity>> JELLYFISH = register("atlantean_jellyfish", EntityType.Builder.of(JellyfishEntity::new, MobCategory.WATER_AMBIENT).sized(0.4f, 0.8f));
    public static final Supplier<EntityType<ShrimpEntity>> SHRIMP = register("atlantean_shrimp", EntityType.Builder.of(ShrimpEntity::new, MobCategory.WATER_AMBIENT).sized(0.5f, 0.5f));
    public static final Supplier<EntityType<LeviathanEntity>> LEVIATHAN = register("leviathan", EntityType.Builder.of(LeviathanEntity::new, MobCategory.WATER_CREATURE).sized(1.5f, 0.7f).eyeHeight(0.245f));
    public static final Supplier<EntityType<SeahorseEntity>> SEAHORSE = register("atlantean_seahorse", EntityType.Builder.of(SeahorseEntity::new, MobCategory.CREATURE).sized(.4f, 1.5f).eyeHeight(1.03125f));
    public static final Supplier<EntityType<StarfishEntity>> STARFISH = register("atlantean_starfish", EntityType.Builder.of(StarfishEntity::new, MobCategory.CREATURE).sized(1.5f, 0.7f));
    public static final Supplier<EntityType<StarfishZomEntity>> STARFISH_ZOM = register("atlantean_starzomfish", EntityType.Builder.of(StarfishZomEntity::new, MobCategory.MONSTER).sized(1.5f, 0.7f));

    //Explosives
    public static final Supplier<EntityType<SodiumPrimedBombBlock>> BOMB = register("sodium_bomb", EntityType.Builder.<SodiumPrimedBombBlock>of(SodiumPrimedBombBlock::new, MobCategory.MISC).fireImmune().sized(0.98f, 0.98f).clientTrackingRange(10).updateInterval(10));

    //Submarines
    public static final Supplier<EntityType<SubmarineEntity>> SUBMARINE = register("atlantean_submarine", EntityType.Builder.of(SubmarineEntity::new, MobCategory.MISC).sized(1.6F, 1.6F).clientTrackingRange(1));

    private static <T extends Entity> Supplier<EntityType<T>> register(String name, EntityType.Builder<T> builder) {
        return ENTITIES.register(name, ()->builder.build("atlantis:" + name));
    }

    public static void onAttributeModify() {
        EntityAttributeRegistry.register(AtlantisEntityInit.COCONUT_CRAB, CoconutCrabEntity::createCoconutCrabAttributes);
        EntityAttributeRegistry.register(AtlantisEntityInit.CRAB, CrabEntity::createCrabAttributes);
        EntityAttributeRegistry.register(AtlantisEntityInit.JELLYFISH, JellyfishEntity::createJellyfishAttributes);
        EntityAttributeRegistry.register(AtlantisEntityInit.SHRIMP, ShrimpEntity::createShrimpAttributes);
        EntityAttributeRegistry.register(AtlantisEntityInit.LEVIATHAN, LeviathanEntity::createLeviathanAttributes);
        EntityAttributeRegistry.register(AtlantisEntityInit.SEAHORSE, SeahorseEntity::createSeahorseAttributes);
        EntityAttributeRegistry.register(AtlantisEntityInit.STARFISH, StarfishEntity::createStarfishAttributes);
        EntityAttributeRegistry.register(AtlantisEntityInit.STARFISH_ZOM, StarfishZomEntity::createStarfishAttributes);
    }

    public static void init() {
        ENTITIES.register();
        onAttributeModify();
    }
}
