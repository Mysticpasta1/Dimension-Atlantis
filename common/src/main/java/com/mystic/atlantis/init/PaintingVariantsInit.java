package com.mystic.atlantis.init;

import dev.architectury.registry.registries.DeferredRegister;
import net.minecraft.world.entity.decoration.PaintingVariant;

import java.util.function.Supplier;

import static net.minecraft.core.registries.Registries.PAINTING_VARIANT;

public class PaintingVariantsInit {
    public static final DeferredRegister<PaintingVariant> UNDERWATER_PAINTING_VARIANTS = DeferredRegister.create("atlantis", PAINTING_VARIANT);

    public static final Supplier<PaintingVariant> SPLASH = UNDERWATER_PAINTING_VARIANTS.register("splash", () -> new PaintingVariant(32, 32));
    public static final Supplier<PaintingVariant> DRAGON = UNDERWATER_PAINTING_VARIANTS.register("dragon", () -> new PaintingVariant(32, 32));
    public static final Supplier<PaintingVariant> SUNRISE = UNDERWATER_PAINTING_VARIANTS.register("sunrise", () -> new PaintingVariant(16, 16));
    public static final Supplier<PaintingVariant> KRAKEN = UNDERWATER_PAINTING_VARIANTS.register("kraken", () -> new PaintingVariant(32, 64));

    public static void init() {
        UNDERWATER_PAINTING_VARIANTS.register();
    }
}
