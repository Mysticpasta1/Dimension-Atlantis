package com.mystic.atlantis.init;

import java.util.function.Supplier;

import com.mystic.atlantis.effects.SpikesEffect;
import com.mystic.atlantis.util.Reference;

import dev.architectury.registry.registries.DeferredRegister;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class EffectsInit {

    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(Reference.MODID, BuiltInRegistries.MOB_EFFECT);

    public static final Supplier<SpikesEffect> SPIKES = registerEffects("spikes", () -> new SpikesEffect(MobEffectCategory.BENEFICIAL, 0xff0000));
    
    private static <M extends MobEffect> Supplier<M> registerEffects(String name, Supplier<M> mobEffect) {
        Supplier<M> reg = MOB_EFFECTS.register(name, mobEffect);
        return reg;
    }
    
    public static void init() {
        MOB_EFFECTS.register();
    }

}
