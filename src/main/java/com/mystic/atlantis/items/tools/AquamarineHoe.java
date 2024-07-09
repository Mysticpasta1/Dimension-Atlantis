package com.mystic.atlantis.items.tools;

import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Tier;

public class AquamarineHoe extends HoeItem {
    public AquamarineHoe(Tier tier, Properties properties) {
        super(tier, properties
                .stacksTo(1)
                .durability(tier.getUses()));
    }
}
