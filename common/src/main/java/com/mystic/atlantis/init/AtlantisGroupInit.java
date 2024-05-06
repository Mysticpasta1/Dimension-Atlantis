package com.mystic.atlantis.init;

import com.mystic.atlantis.util.Reference;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static net.minecraft.core.registries.Registries.CREATIVE_MODE_TAB;

public class AtlantisGroupInit {
    public static DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Reference.MODID, CREATIVE_MODE_TAB);

    public static final List<Supplier<? extends ItemLike>> MAIN_BLOCKS = new ArrayList<>();
    public static final List<Supplier<? extends ItemLike>> GLYPH_BLOCKS = new ArrayList<>();
    public static final List<Supplier<? extends ItemLike>> MAIN_ITEMS = new ArrayList<>();
    public static final List<Supplier<? extends ItemLike>> GLYPH_ITEMS = new ArrayList<>();

    public static final Supplier<CreativeModeTab> MAIN = CREATIVE_TABS.register("main", () -> CreativeTabRegistry.create(builder ->
            builder.title(Component.translatable("itemGroup.atlantis.general"))
            .icon(BlockInit.CHISELED_GOLDEN_AQUAMARINE.get().asItem()::getDefaultInstance)

            .hideTitle()
            .displayItems((pParameters, pOutput) -> {
                MAIN_BLOCKS.forEach(itemLike -> pOutput.accept(itemLike.get()));
                MAIN_ITEMS.forEach(itemLike -> pOutput.accept(itemLike.get()));
            })
            .backgroundSuffix("tab_atlantis.png")
            .build()));

    public static final Supplier<CreativeModeTab> GLYPH = CREATIVE_TABS.register("glyph", () -> CreativeTabRegistry.create(builder -> {
            builder.title(Component.translatable("itemGroup.atlantis.glyph"))
            .icon(BlockInit.LINGUISTIC_BLOCK.get().asItem()::getDefaultInstance)
            .hideTitle()
            .displayItems((pParameters, pOutput) -> {
                GLYPH_BLOCKS.forEach(itemLike -> pOutput.accept(itemLike.get()));
                GLYPH_ITEMS.forEach(itemLike -> pOutput.accept(itemLike.get()));
            }).backgroundSuffix("tab_glyph.png");
    }));


    public static <T extends Item> Supplier<T> addToMainTab (Supplier<T> itemLike) {
        MAIN_BLOCKS.add(itemLike);
        return itemLike;
    }

    public static <T extends Item> Supplier<T> addToGylphTab (Supplier<T> itemLike) {
        GLYPH_BLOCKS.add(itemLike);
        return itemLike;
    }

    public static <T extends Item> Supplier<T> addToMainTabItems (Supplier<T> itemLike) {
        MAIN_ITEMS.add(itemLike);
        return itemLike;
    }

    public static <T extends Item> Supplier<T> addToGylphTabItems (Supplier<T> itemLike) {
        GLYPH_ITEMS.add(itemLike);
        return itemLike;
    }

    public static void init(){
        CREATIVE_TABS.register();
    }
}
