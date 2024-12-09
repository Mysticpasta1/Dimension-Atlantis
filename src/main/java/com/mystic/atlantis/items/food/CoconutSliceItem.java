package com.mystic.atlantis.items.food;

import com.mystic.atlantis.blocks.base.Coconut;
import com.mystic.atlantis.init.BlockInit;
import com.mystic.atlantis.items.DefaultItem;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.material.Fluids;

public class CoconutSliceItem extends BlockItem {
    public CoconutSliceItem(Properties settings) {
        super(BlockInit.COCONUT_SLICE.get(), settings.stacksTo(64).food(new FoodProperties.Builder().nutrition(4).saturationMod(2.4f).build()));
    }
}
