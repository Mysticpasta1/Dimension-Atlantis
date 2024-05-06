package com.mystic.atlantis.init;

import com.mystic.atlantis.enchantments.LightningProtection;
import com.mystic.atlantis.util.Reference;
import dev.architectury.registry.registries.DeferredRegister;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.enchantment.Enchantment;

import java.util.function.Supplier;

public class EnchantmentInit {
    public static final DeferredRegister<Enchantment> ENCHANTMENT = DeferredRegister.create(Reference.MODID, Registries.ENCHANTMENT);

    public static final Supplier<LightningProtection> LIGHTNING_PROTECTION = ENCHANTMENT.register("lightning_protection", LightningProtection::new);

    public static void init() {
        ENCHANTMENT.register();
    }
}
