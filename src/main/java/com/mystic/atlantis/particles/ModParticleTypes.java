package com.mystic.atlantis.particles;

import com.mystic.atlantis.util.Reference;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModParticleTypes {

    public static DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, Reference.MODID);
    public static final RegistryObject<SimpleParticleType> PUSH_BUBBLESTREAM_UP = PARTICLES.register("push_bubblestream_up", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> PUSH_BUBBLESTREAM_DOWN = PARTICLES.register("push_bubblestream_down", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> PUSH_BUBBLESTREAM_NORTH = PARTICLES.register("push_bubblestream_north", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> PUSH_BUBBLESTREAM_SOUTH = PARTICLES.register("push_bubblestream_south", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> PUSH_BUBBLESTREAM_EAST = PARTICLES.register("push_bubblestream_east", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> PUSH_BUBBLESTREAM_WEST = PARTICLES.register("push_bubblestream_west", () -> new SimpleParticleType(false));


}
