package com.mystic.atlantis;

import com.mystic.atlantis.init.BlockInit;
import com.mystic.atlantis.init.ItemInit;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.ItemLike;

import java.util.Set;

public class TagsInit {
    public static void init() {
        Item.init();
    }

    public static class Item {
        public static TagKey<net.minecraft.world.item.Item> CAN_ITEM_SINK = ItemTags.create(Atlantis.id("can_item_sink"));

        public static Set<ItemLike> getItemsThatCanSink() {
            return Set.of(
                    ItemInit.ORICHALCUM_BLEND.get(),
                    ItemInit.ORICHALCUM_INGOT.get(),
                    ItemInit.ORICHALCUM_AXE.get(),
                    ItemInit.ORICHALCUM_PICKAXE.get(),
                    ItemInit.ORICHALCUM_SHOVEL.get(),
                    ItemInit.ORICHALCUM_HOE.get(),
                    ItemInit.ORICHALCUM_SWORD.get(),
                    ItemInit.ORICHALCUM_HELMET.get(),
                    ItemInit.ORICHALCUM_CHESTPLATE.get(),
                    ItemInit.ORICHALCUM_LEGGINGS.get(),
                    ItemInit.ORICHALCUM_BOOTS.get(),
                    BlockInit.ORICHALCUM_BLOCK.get());
        }

        public static void init() {

        }
    }
}
