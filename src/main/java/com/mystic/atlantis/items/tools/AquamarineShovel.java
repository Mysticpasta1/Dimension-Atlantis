package com.mystic.atlantis.items.tools;

import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;

public class AquamarineShovel extends ShovelItem {
    public AquamarineShovel(Tier tier, Properties properties) {
        super(tier, properties
                .stacksTo(1)
                .durability(tier.getUses()));
    }
}
