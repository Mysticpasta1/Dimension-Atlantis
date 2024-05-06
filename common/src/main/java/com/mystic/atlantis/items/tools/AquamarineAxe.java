package com.mystic.atlantis.items.tools;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Tier;

public class AquamarineAxe extends AxeItem {
    public AquamarineAxe(Tier tier, float attack) {
        super(tier, new Properties()
                .stacksTo(1)
                .durability(tier.getUses()));
    }

}
