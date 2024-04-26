package com.mystic.atlantis.init;

import com.mystic.atlantis.enchantments.LightningProtection;
import com.mystic.atlantis.util.Reference;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class EnchantmentInit {
    public static final DeferredRegister<Enchantment> ENCHANTMENT = DeferredRegister.create(BuiltInRegistries.ENCHANTMENT, Reference.MODID);

    public static final Supplier<LightningProtection> LIGHTNING_PROTECTION = ENCHANTMENT.register("lightning_protection", LightningProtection::new);

    public static void init(IEventBus bus) {
        ENCHANTMENT.register(bus);
    }
}
