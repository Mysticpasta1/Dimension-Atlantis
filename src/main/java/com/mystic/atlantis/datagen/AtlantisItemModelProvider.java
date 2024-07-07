package com.mystic.atlantis.datagen;

import com.mystic.atlantis.Atlantis;
import com.mystic.atlantis.blocks.base.LinguisticGlyph;
import com.mystic.atlantis.init.BlockInit;
import com.mystic.atlantis.init.ItemInit;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;

public class AtlantisItemModelProvider extends ItemModelProvider {
    public AtlantisItemModelProvider(PackOutput generator, ExistingFileHelper existingFileHelper) {
        super(generator, "atlantis", existingFileHelper);
    }

    @Override
    protected void registerModels() {
        item((DeferredHolder<Item, Item>) ItemInit.LINGUISTIC_GLYPH_SCROLL);
        item((DeferredHolder<Item, Item>) ItemInit.LINGUISTIC_GLYPH_SCROLL_A);
        item((DeferredHolder<Item, Item>) ItemInit.LINGUISTIC_GLYPH_SCROLL_B);
        item((DeferredHolder<Item, Item>) ItemInit.LINGUISTIC_GLYPH_SCROLL_C);
        item((DeferredHolder<Item, Item>) ItemInit.LINGUISTIC_GLYPH_SCROLL_D);
        item((DeferredHolder<Item, Item>) ItemInit.LINGUISTIC_GLYPH_SCROLL_E);
        item((DeferredHolder<Item, Item>) ItemInit.LINGUISTIC_GLYPH_SCROLL_F);
        item((DeferredHolder<Item, Item>) ItemInit.LINGUISTIC_GLYPH_SCROLL_G);
        item((DeferredHolder<Item, Item>) ItemInit.LINGUISTIC_GLYPH_SCROLL_H);
        item((DeferredHolder<Item, Item>) ItemInit.LINGUISTIC_GLYPH_SCROLL_I);
        item((DeferredHolder<Item, Item>) ItemInit.LINGUISTIC_GLYPH_SCROLL_J);
        item((DeferredHolder<Item, Item>) ItemInit.LINGUISTIC_GLYPH_SCROLL_K);
        item((DeferredHolder<Item, Item>) ItemInit.LINGUISTIC_GLYPH_SCROLL_L);
        item((DeferredHolder<Item, Item>) ItemInit.LINGUISTIC_GLYPH_SCROLL_M);
        item((DeferredHolder<Item, Item>) ItemInit.LINGUISTIC_GLYPH_SCROLL_N);
        item((DeferredHolder<Item, Item>) ItemInit.LINGUISTIC_GLYPH_SCROLL_O);
        item((DeferredHolder<Item, Item>) ItemInit.LINGUISTIC_GLYPH_SCROLL_P);
        item((DeferredHolder<Item, Item>) ItemInit.LINGUISTIC_GLYPH_SCROLL_Q);
        item((DeferredHolder<Item, Item>) ItemInit.LINGUISTIC_GLYPH_SCROLL_R);
        item((DeferredHolder<Item, Item>) ItemInit.LINGUISTIC_GLYPH_SCROLL_S);
        item((DeferredHolder<Item, Item>) ItemInit.LINGUISTIC_GLYPH_SCROLL_T);
        item((DeferredHolder<Item, Item>) ItemInit.LINGUISTIC_GLYPH_SCROLL_U);
        item((DeferredHolder<Item, Item>) ItemInit.LINGUISTIC_GLYPH_SCROLL_V);
        item((DeferredHolder<Item, Item>) ItemInit.LINGUISTIC_GLYPH_SCROLL_W);
        item((DeferredHolder<Item, Item>) ItemInit.LINGUISTIC_GLYPH_SCROLL_X);
        item((DeferredHolder<Item, Item>) ItemInit.LINGUISTIC_GLYPH_SCROLL_Y);
        item((DeferredHolder<Item, Item>) ItemInit.LINGUISTIC_GLYPH_SCROLL_Z);
        item((DeferredHolder<Item, Item>) ItemInit.LINGUISTIC_GLYPH_SCROLL_0);
        item((DeferredHolder<Item, Item>) ItemInit.LINGUISTIC_GLYPH_SCROLL_1);
        item((DeferredHolder<Item, Item>) ItemInit.LINGUISTIC_GLYPH_SCROLL_2);
        item((DeferredHolder<Item, Item>) ItemInit.LINGUISTIC_GLYPH_SCROLL_3);
        item((DeferredHolder<Item, Item>) ItemInit.LINGUISTIC_GLYPH_SCROLL_4);
        item((DeferredHolder<Item, Item>) ItemInit.LINGUISTIC_GLYPH_SCROLL_5);
        item((DeferredHolder<Item, Item>) ItemInit.LINGUISTIC_GLYPH_SCROLL_6);
        item((DeferredHolder<Item, Item>) ItemInit.LINGUISTIC_GLYPH_SCROLL_7);
        item((DeferredHolder<Item, Item>) ItemInit.LINGUISTIC_GLYPH_SCROLL_8);
        item((DeferredHolder<Item, Item>) ItemInit.LINGUISTIC_GLYPH_SCROLL_9);

        for(LinguisticGlyph glyph : LinguisticGlyph.values()) {
            for(DyeColor color : DyeColor.values()) {
                withParent(BlockInit.getLinguisticBlock(glyph, color), glyph);
            }

            withParent(BlockInit.getLinguisticBlock(glyph, null), glyph);
        }

        //        block(BlockInit.WRITING_BLOCK);
        block((DeferredHolder<Block, Block>) BlockInit.ORICHALCUM_BLOCK);

        item((DeferredHolder<Item, Item>) ItemInit.ORICHALCUM_INGOT);
        item((DeferredHolder<Item, Item>) ItemInit.ORICHALCUM_BLEND);

        item((DeferredHolder<Item, Item>) ItemInit.ORICHALCUM_HELMET);
        item((DeferredHolder<Item, Item>) ItemInit.ORICHALCUM_CHESTPLATE);
        item((DeferredHolder<Item, Item>) ItemInit.ORICHALCUM_LEGGINGS);
        item((DeferredHolder<Item, Item>) ItemInit.ORICHALCUM_BOOTS);
        itemTool((DeferredHolder<Item, Item>) ItemInit.ORICHALCUM_AXE);
        itemTool((DeferredHolder<Item, Item>) ItemInit.ORICHALCUM_PICKAXE);
        itemTool((DeferredHolder<Item, Item>) ItemInit.ORICHALCUM_SHOVEL);
        itemTool((DeferredHolder<Item, Item>) ItemInit.ORICHALCUM_SWORD);
        itemTool((DeferredHolder<Item, Item>) ItemInit.ORICHALCUM_HOE);
    }

    private void itemTool(DeferredHolder<Item, Item> tool) {
        getBuilder(tool.getId().getPath())
                .parent(getExistingFile(mcLoc("item/handheld")))
                .texture("layer0", items(tool.getId()));
    }

    private void withParent(DeferredHolder<Block, Block> block, LinguisticGlyph glyph) {
        withExistingParent(block.getId().getPath(), block(Atlantis.id("linguistic_" + glyph.name().toLowerCase())));
    }

    private void block(DeferredHolder<Block, Block> block) {
        withExistingParent(block.getId().getPath(), block(block.getId()));
    }

    private void item(DeferredHolder<Item, Item> block) {
        try {
            getBuilder(block.getId().getPath())
                    .parent(getExistingFile(mcLoc("item/generated")))
                    .texture("layer0", items(block.getId()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private ResourceLocation block(ResourceLocation location) {
        return ResourceLocation.fromNamespaceAndPath(location.getNamespace(), "block/" + location.getPath());
    }


    private ResourceLocation items(ResourceLocation location) {
        return ResourceLocation.fromNamespaceAndPath(location.getNamespace(), "item/" + location.getPath());
    }
}
