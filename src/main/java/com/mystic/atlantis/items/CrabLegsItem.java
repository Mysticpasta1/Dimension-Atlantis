package com.mystic.atlantis.items;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class CrabLegsItem extends Item
{
    public CrabLegsItem(Properties settings) {
        super(settings.stacksTo(64).food(new FoodProperties.Builder().meat().nutrition(6).saturationMod(0.5f).build()));
    }
}
