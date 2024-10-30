package com.mystic.atlantis.blocks.base;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Equipable;

public class EquipableCoconut extends Coconut implements Equipable {
   public EquipableCoconut(Properties p_289677_) {
      super(p_289677_);
   }

   public EquipmentSlot getEquipmentSlot() {
      return EquipmentSlot.HEAD;
   }
}