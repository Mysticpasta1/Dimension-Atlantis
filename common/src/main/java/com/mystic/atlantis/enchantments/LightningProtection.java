package com.mystic.atlantis.enchantments;

import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;

import java.util.Optional;

public class LightningProtection extends Enchantment {
    public LightningProtection() {
        super(new EnchantmentDefinition(
                ItemTags.CHEST_ARMOR_ENCHANTABLE,
                Optional.of(ItemTags.CHEST_ARMOR_ENCHANTABLE),
                1, 1, Enchantment.constantCost(2),Enchantment.constantCost(32),
                3, FeatureFlagSet.of(), EquipmentSlot.values()
        ));
    }

    public boolean canEnchant(ItemStack pStack) {
        return pStack.getItem() instanceof ArmorItem || super.canEnchant(pStack);
    }
}
