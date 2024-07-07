package com.mystic.atlantis.recipes;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.mystic.atlantis.init.BlockInit;
import com.mystic.atlantis.init.RecipesInit;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class WritingRecipe extends SingleItemRecipe {
    public WritingRecipe(String string , Ingredient arg2, ItemStack arg3) {
        super(RecipesInit.Types.WRITING, RecipesInit.Serializers.WRITING_SERIALIZER.get(), string, arg2, arg3);
    }

    @Override
    public boolean matches(SingleRecipeInput p_346065_, @NotNull Level p_345375_) {
        return this.ingredient.test(p_346065_.item());
    }

    @Override
    public ItemStack getToastSymbol() {
        return new ItemStack(BlockInit.WRITING_BLOCK.get());
    }

    @Override
    public String getGroup() {
        return this.group;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider registries) {
        return this.result;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> nonnulllist = NonNullList.create();
        nonnulllist.add(this.ingredient);
        return nonnulllist;
    }

    /**
     * Used to determine if this recipe can fit in a grid of the given width/height
     */
    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    public ItemStack assemble(SingleRecipeInput p_345857_, HolderLookup.Provider p_335463_) {
        return this.result.copy();
    }

    public static class WritingSerializer implements RecipeSerializer<com.mystic.atlantis.recipes.WritingRecipe> {
        final SingleItemRecipe.Factory<WritingRecipe> factory;
        private final MapCodec<WritingRecipe> codec;
        private final StreamCodec<RegistryFriendlyByteBuf, WritingRecipe> streamCodec;

        public WritingSerializer(SingleItemRecipe.Factory<WritingRecipe> factory) {
            this.factory = factory;
            this.codec = RecordCodecBuilder.mapCodec(
                    p_340781_ -> p_340781_.group(
                                    Codec.STRING.optionalFieldOf("group", "").forGetter(SingleItemRecipe::getGroup),
                                    Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(p_301068_ -> p_301068_.ingredient),
                                    ItemStack.STRICT_CODEC.fieldOf("result").forGetter(p_302316_ -> p_302316_.result)
                            )
                            .apply(p_340781_, factory::create)
            );
            this.streamCodec = StreamCodec.composite(
                    ByteBufCodecs.STRING_UTF8,
                    p_319737_ -> p_319737_.group,
                    Ingredient.CONTENTS_STREAM_CODEC,
                    p_319738_ -> p_319738_.ingredient,
                    ItemStack.STREAM_CODEC,
                    p_319736_ -> p_319736_.result,
                    factory::create
            );
        }

        @Override
        public MapCodec<WritingRecipe> codec() {
            return this.codec;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, WritingRecipe> streamCodec() {
            return this.streamCodec;
        }
    }
}

