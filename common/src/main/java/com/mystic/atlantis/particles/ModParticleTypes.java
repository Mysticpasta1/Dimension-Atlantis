package com.mystic.atlantis.particles;

import com.mystic.atlantis.util.Reference;
import dev.architectury.registry.registries.DeferredRegister;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;

import java.util.function.Supplier;

import static net.minecraft.core.registries.Registries.PARTICLE_TYPE;

public class ModParticleTypes {

    public static DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(Reference.MODID, PARTICLE_TYPE);
    public static final Supplier<SimpleParticleType> PUSH_BUBBLESTREAM = registerSimple(false);

    private static Supplier<SimpleParticleType> registerSimple(boolean b) {
        return PARTICLES.register("push_bubblestream", () -> new SimpleParticleType(b) {});
    }

    public static void init() {
        PARTICLES.register();;
    }
}
