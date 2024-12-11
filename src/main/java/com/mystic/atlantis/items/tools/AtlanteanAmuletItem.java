package com.mystic.atlantis.items.tools;

import com.mystic.atlantis.items.DefaultItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.function.Consumer;

public class AtlanteanAmuletItem extends DefaultItem {
    public AtlanteanAmuletItem() {
        super(new Properties().stacksTo(1).durability(250));
    }

    @Override
    public void inventoryTick(ItemStack stack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if (pEntity instanceof LivingEntity livingEntity) {
            MobEffectInstance mobEffect = new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 120, 1, false, false);
            livingEntity.addEffect(mobEffect);
            if(livingEntity.isOnFire()) {
                stack.getItem().damageItem(stack, 1, livingEntity, livingEntity1 -> {
                    livingEntity.removeEffect(mobEffect.getEffect());
                });
            }
        }
    }
}