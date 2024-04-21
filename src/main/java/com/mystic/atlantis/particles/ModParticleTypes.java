package com.mystic.atlantis.particles;

import com.mystic.atlantis.util.Reference;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.ForgeRegistries;
import net.neoforged.neoforge.registries.RegistryObject;

public class ModParticleTypes {

    public static DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, Reference.MODID);
    public static final RegistryObject<SimpleParticleType> PUSH_BUBBLESTREAM = PARTICLES.register("push_bubblestream", () -> new SimpleParticleType(false));


}
