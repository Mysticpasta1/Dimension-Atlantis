package com.mystic.atlantis.init;

import net.minecraft.world.entity.decoration.PaintingVariant;
import net.neoforged.neoforge.eventbus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.ForgeRegistries;
import net.neoforged.neoforge.registries.RegistryObject;

public class PaintingVariantsInit {
    public static final DeferredRegister<PaintingVariant> UNDERWATER_PAINTING_VARIANTS = DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, "atlantis");

    public static final RegistryObject<PaintingVariant> SPLASH = UNDERWATER_PAINTING_VARIANTS.register("splash", () -> new PaintingVariant(32, 32));
    public static final RegistryObject<PaintingVariant> DRAGON = UNDERWATER_PAINTING_VARIANTS.register("dragon", () -> new PaintingVariant(32, 32));
    public static final RegistryObject<PaintingVariant> SUNRISE = UNDERWATER_PAINTING_VARIANTS.register("sunrise", () -> new PaintingVariant(16, 16));
    public static final RegistryObject<PaintingVariant> KRAKEN = UNDERWATER_PAINTING_VARIANTS.register("kraken", () -> new PaintingVariant(32, 64));

    public static void init(IEventBus bus) {
        UNDERWATER_PAINTING_VARIANTS.register(bus);
    }
}
