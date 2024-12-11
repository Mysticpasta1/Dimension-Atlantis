package com.mystic.atlantis.items.tools;

import com.mystic.atlantis.items.DefaultItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class AtlanteanAmuletItem extends DefaultItem {
    public AtlanteanAmuletItem() {
        super(new Properties().stacksTo(1).durability(270).fireResistant());
    }

    @Override
    public void inventoryTick(ItemStack stack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if (pEntity instanceof LivingEntity livingEntity) {
            MobEffectInstance mobEffect = new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 20, 1, false, false);
            if(stack.getItem() instanceof AtlanteanAmuletItem && livingEntity.isOnFire()) {
                livingEntity.addEffect(mobEffect);
                if (pEntity.tickCount % 20 == 0) {
                    stack.hurtAndBreak(1, livingEntity, livingEntity1 -> {});
                }
            }
        }
    }
}