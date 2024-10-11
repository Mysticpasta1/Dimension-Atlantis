//package com.mystic.atlantis.init;
//
//import com.mystic.atlantis.enchantments.LightningProtection;
//import com.mystic.atlantis.util.Reference;
//import dev.architectury.registry.registries.DeferredRegister;
//import net.minecraft.core.registries.Registries;
//import net.minecraft.world.entity.EquipmentSlot;
//import net.minecraft.world.item.enchantment.Enchantment;
//import net.minecraft.world.item.enchantment.EnchantmentCategory;
//import net.minecraftforge.eventbus.api.IEventBus;
//import net.minecraftforge.registries.DeferredRegister;
//import net.minecraftforge.registries.ForgeRegistries;
//import net.minecraftforge.registries.RegistryObject;
//
//TODO: You deal with this - Waterpicker
//public class EnchantmentInit {
//    public static final DeferredRegister<Enchantment> ENCHANTMENT = DeferredRegister.create(Reference.MODID, Registries.ENCHANTMENT);
//
//    public static final RegistryObject<LightningProtection> LIGHTNING_PROTECTION = ENCHANTMENT.register("lightning_protection", () -> new LightningProtection(Enchantment.Rarity.COMMON, EnchantmentCategory.ARMOR_CHEST, EquipmentSlot.values()));
//
//    public static void init(IEventBus bus) {
//        ENCHANTMENT.register(bus);
//    }
//}
