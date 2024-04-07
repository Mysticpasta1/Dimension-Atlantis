package com.mystic.atlantis.items.tools;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class AtlanteanSpearItem extends SwordItem {
    public AtlanteanSpearItem(Tier tier, int attack) {
        super(tier, attack, -5.2F, new Item.Properties()
                .stacksTo(1)
                .defaultDurability(tier.getUses()));
    }
}


