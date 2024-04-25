package com.mystic.atlantis.blocks.base;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Wearable;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class EquipableCarvedCoconut extends CarvedCoconut implements Wearable {
   public EquipableCarvedCoconut(BlockBehaviour.Properties p_289677_) {
      super(p_289677_);
   }

   public EquipmentSlot getEquipmentSlot() {
      return EquipmentSlot.HEAD;
   }
}