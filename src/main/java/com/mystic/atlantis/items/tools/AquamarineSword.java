package com.mystic.atlantis.items.tools;

import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class AquamarineSword extends SwordItem {
    public AquamarineSword(Tier tier, Properties properties) {
        super(tier, properties
                .stacksTo(1)
                .durability(tier.getUses()));
    }
}
