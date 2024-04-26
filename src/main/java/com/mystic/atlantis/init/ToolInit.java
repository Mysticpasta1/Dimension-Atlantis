package com.mystic.atlantis.init;

import java.util.function.Supplier;

import com.mystic.atlantis.util.Lazy;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

public enum ToolInit implements Tier {
    AQUAMARINE(286,5,4,2, () -> Ingredient.of(ItemInit.AQUAMARINE_GEM.get())),
    ORICHAClUM(286,5,4,2, () -> Ingredient.of(ItemInit.ORICHALCUM_INGOT.get()));;

    private final int maxUses;
    private final float toolEfficiency;
    private final float attackDamage;
    private final int enchantability;
    private final Lazy<Ingredient> repairMaterial;

    ToolInit(int uses, float efficiency, float damage, int enchant, Supplier<Ingredient> material) {
        maxUses = uses;
        toolEfficiency = efficiency;
        attackDamage = damage;
        enchantability = enchant;
        repairMaterial = new Lazy<>(material);
    }

    @Override
    public int getUses() {
        return maxUses;
    }

    @Override
    public float getSpeed() {
        return toolEfficiency;
    }

    @Override
    public float getAttackDamageBonus() {
        return attackDamage;
    }

    @Override
    public TagKey<Block> getIncorrectBlocksForDrops() {
        return Tiers.IRON.getIncorrectBlocksForDrops();
    }

    @Override
    public int getEnchantmentValue() {
        return enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairMaterial.get();
    }
}
