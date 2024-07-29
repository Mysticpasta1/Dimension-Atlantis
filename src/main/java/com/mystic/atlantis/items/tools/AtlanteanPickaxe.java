package com.mystic.atlantis.items.tools;

import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;

public class AtlanteanPickaxe extends PickaxeItem {
    public AtlanteanPickaxe(Tier tier, int attack) {
        super(tier, attack, -3.2F, new Properties()
                .stacksTo(1)
                .defaultDurability(tier.getUses()));
    }
}
