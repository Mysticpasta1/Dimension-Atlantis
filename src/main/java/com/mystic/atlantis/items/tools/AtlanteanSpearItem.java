package com.mystic.atlantis.items.tools;

import com.mystic.atlantis.init.AtlantisGroupInit;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class AtlanteanSpearItem extends SwordItem {
    public AtlanteanSpearItem(Tier tier, int attack) {
        super(tier, attack, -5.2F, new Item.Properties()
                .tab(AtlantisGroupInit.MAIN)
                .stacksTo(1)
                .defaultDurability(tier.getUses()));
    }
}


