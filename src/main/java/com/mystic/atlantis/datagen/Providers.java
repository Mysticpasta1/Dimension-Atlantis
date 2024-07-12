package com.mystic.atlantis.datagen;

import com.mystic.atlantis.TagsInit;
import com.mystic.atlantis.init.BlockInit;
import com.mystic.atlantis.init.ItemInit;
import com.mystic.atlantis.recipes.WritingRecipe;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SingleItemRecipeBuilder;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;

import java.util.function.Supplier;

public class Providers {
    public static void init(IEventBus bus) {
        bus.addListener(Providers::dataGather);
    }

    public static void dataGather(GatherDataEvent event) {
        var output = event.getGenerator().getPackOutput();


        if(event.includeServer()) {
            event.getGenerator().addProvider(true, new AtlantisLootTableProvider(event.getGenerator()));
            event.getGenerator().addProvider(true, new AtlantisRecipeProvider(output));
        }

        if(event.includeClient()) {
            event.getGenerator().addProvider(true, new AtlantisBlockModelProvider(output, event.getExistingFileHelper()));
            event.getGenerator().addProvider(true, new AtlantisMainProvider(output, event.getExistingFileHelper(), AtlantisBlockStateProvider::new));
            event.getGenerator().addProvider(true, new AtlantisItemModelProvider(output, event.getExistingFileHelper()));
            event.getGenerator().addProvider(true, new AtlantisEnglishLanguageProvider(output));
            event.getGenerator().addProvider(true, new RecipeProvider(output, event.getLookupProvider()) {
                @Override
                protected void buildRecipes(RecipeOutput recipeOutput) {
                    var list = ItemInit.getScrolls();
                    var ingredient = Ingredient.of(list.toArray(Item[]::new));

                    for (var result : list) {
                        glyphScroll(recipeOutput, result, ingredient);
                    }
                }

                protected static void glyphScroll(RecipeOutput recipeOutput, ItemLike result, Ingredient material) {
                    writing(material, RecipeCategory.MISC, result, 1)
                            .unlockedBy(getHasName(ItemInit.LINGUISTIC_GLYPH_SCROLL.get()), has(ItemInit.LINGUISTIC_GLYPH_SCROLL.get()))
                            .save(recipeOutput, getConversionRecipeName(result, ItemInit.LINGUISTIC_GLYPH_SCROLL.get()) + "_writing");
                }

                public static SingleItemRecipeBuilder writing(Ingredient ingredient, RecipeCategory category, ItemLike result, int count) {
                    return new SingleItemRecipeBuilder(category, WritingRecipe::new, ingredient, result, count);
                }
            });

            BlockTagsProvider blockTagsProvider = new BlockTagsProvider(output, event.getLookupProvider(), "atlantis", event.getExistingFileHelper()) {
                @Override
                protected void addTags(HolderLookup.Provider pProvider) {
                    tag(BlockTags.MINEABLE_WITH_PICKAXE).add(BlockInit.ORICHALCUM_BLOCK.get());
                    tag(BlockTags.NEEDS_IRON_TOOL).add(BlockInit.ORICHALCUM_BLOCK.get());
                }
            };

            event.getGenerator().addProvider(true, blockTagsProvider);

            event.getGenerator().addProvider(true, new ItemTagsProvider(output, event.getLookupProvider(), blockTagsProvider.contentsGetter(),"atlantis", event.getExistingFileHelper()) {
                @Override
                protected void addTags(HolderLookup.Provider pProvider) {
                    TagAppender<Item> tag = tag(TagsInit.Item.CAN_ITEM_SINK);
                    TagsInit.Item.getItemsThatCanSink().stream().map(Supplier::get).map(Item::builtInRegistryHolder).map(Holder.Reference::key).forEach(tag::add);
                }
            });
        }
    }
}
