package com.mystic.atlantis.items.tools;

import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Tier;

public class AtlanteanHoeItem extends HoeItem {
    public AtlanteanHoeItem(Tier tier, int attack) {
        super(tier, new Properties().attributes(createAttributes(tier, attack, -3.2f))
                .stacksTo(1)
                .durability(tier.getUses()));
    }
}
