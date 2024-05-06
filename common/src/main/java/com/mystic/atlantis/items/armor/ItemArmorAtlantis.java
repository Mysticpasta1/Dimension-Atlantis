package com.mystic.atlantis.items.armor;

import com.google.common.collect.ImmutableMap;
import com.mystic.atlantis.init.ItemInit;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Random;

public class ItemArmorAtlantis extends ArmorItem {
    private static final Map<Holder<ArmorMaterial>, Holder<MobEffect>> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<Holder<ArmorMaterial>, Holder<MobEffect>>())
                    .put(BasicArmorMaterial.ARMOR_AQUAMARINE, MobEffects.DOLPHINS_GRACE).build();

    public ItemArmorAtlantis(Holder<ArmorMaterial> material, Type slot, Properties settings) {
        super(material, slot, settings);
    }

    @Override
    public void inventoryTick(@NotNull ItemStack stack, Level world, @NotNull Entity entity, int slot, boolean selected) {
        if (!world.isClientSide()) {
            if (entity instanceof Player player) {
                if (hasFullSuitOfArmorOn(player)) {
                    evaluateArmorEffects(player);
                }
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private void evaluateArmorEffects(Player player) {
        for (Map.Entry<Holder<ArmorMaterial>, Holder<MobEffect>> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            Holder<ArmorMaterial> mapArmorMaterial = entry.getKey();
            Holder<MobEffect> mapStatusEffect = entry.getValue();

            if (hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffect);
            }
        }
    }

    private void addStatusEffectForMaterial(Player player, Holder<ArmorMaterial> mapArmorMaterial, Holder<MobEffect> mapStatusEffect) {
        boolean hasPlayerEffect = player.hasEffect(mapStatusEffect);

        if (hasCorrectArmorOn(mapArmorMaterial, player) && !hasPlayerEffect) {
            player.addEffect(new MobEffectInstance(mapStatusEffect, 200, 1, false, false));
        }
    }

    private boolean hasFullSuitOfArmorOn(Player player) {
        ItemStack boots = player.getInventory().getArmor(0);
        ItemStack leggings = player.getInventory().getArmor(1);
        ItemStack breastplate = player.getInventory().getArmor(2);
        ItemStack helmet = player.getInventory().getArmor(3);

        return !helmet.isEmpty() && !breastplate.isEmpty()
                && !leggings.isEmpty() && !boots.isEmpty();
    }

    private boolean hasCorrectArmorOn(Holder<ArmorMaterial> material, Player player) {
        for (ItemStack armor : player.getInventory().armor) {
            if (armor.getItem() instanceof ArmorItem armorItem) {
                if (armorItem.getMaterial() != material) {
                    return false;
                }
            } else {
                return false;
            }
        }

        ItemStack boots = player.getInventory().getArmor(0);
        ItemStack leggings = player.getInventory().getArmor(1);
        ItemStack breastplate = player.getInventory().getArmor(2);
        ItemStack helmet = player.getInventory().getArmor(3);

        return helmet.is(ItemInit.AQUAMARINE_HELMET.get()) && breastplate.is(ItemInit.AQUAMARINE_CHESTPLATE.get()) &&
                leggings.is(ItemInit.AQUAMARINE_LEGGINGS.get()) && boots.is(ItemInit.AQUAMARINE_BOOTS.get());
    }
}
