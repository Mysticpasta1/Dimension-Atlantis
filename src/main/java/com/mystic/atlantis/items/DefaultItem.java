package com.mystic.atlantis.items;

import com.mystic.atlantis.init.AtlantisGroupInit;
import net.minecraft.world.item.Item;

/**
 * Legacy {@code ItemBase}.
 */
public class DefaultItem extends Item {
    public DefaultItem(Properties settings) {
        super (settings.tab(AtlantisGroupInit.MAIN));
    }

    public DefaultItem() {
        this(new Properties());
    }
}
