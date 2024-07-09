package com.mystic.atlantis.items.tools;

import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;

public class AquamarinePickaxe extends PickaxeItem {
    public AquamarinePickaxe(Tier tier, Properties properties) {
        super(tier, properties
                .stacksTo(1)
                .durability(tier.getUses()));
    }
}
