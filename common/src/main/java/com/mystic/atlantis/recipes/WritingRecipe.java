package com.mystic.atlantis.recipes;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.mystic.atlantis.init.BlockInit;
import com.mystic.atlantis.init.RecipesInit;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SingleItemRecipe;
import net.minecraft.world.level.Level;

public class WritingRecipe extends SingleItemRecipe {
    public WritingRecipe(String string, Ingredient arg2, ItemStack arg3) {
        super(RecipesInit.Types.WRITING, RecipesInit.Serializers.WRITING_SERIALIZER.get(), string, arg2, arg3);
    }

    @Override
    public boolean matches(Container container, Level level) {
        return this.ingredient.test(container.getItem(0));
    }

    @Override
    public ItemStack getToastSymbol() {
        return new ItemStack(BlockInit.WRITING_BLOCK.get());
    }

    public static class Serializer<T extends SingleItemRecipe> implements RecipeSerializer<WritingRecipe> {
        final SingleItemRecipe.Factory<WritingRecipe> factory;
        private final MapCodec<WritingRecipe> codec;
        private final StreamCodec<RegistryFriendlyByteBuf, WritingRecipe> streamCodec;

        public Serializer(WritingRecipe.Factory<WritingRecipe> pFactory) {
            this.factory = pFactory;
            this.codec = RecordCodecBuilder.mapCodec(
                    p_340781_ -> p_340781_.group(
                                    Codec.STRING.optionalFieldOf("group", "").forGetter(p_300947_ -> p_300947_.group),
                                    Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(p_301068_ -> p_301068_.ingredient),
                                    ItemStack.STRICT_CODEC.fieldOf("result").forGetter(p_302316_ -> p_302316_.result)
                            )
                            .apply(p_340781_, pFactory::create)
            );
            this.streamCodec = StreamCodec.composite(
                    ByteBufCodecs.STRING_UTF8,
                    p_319737_ -> p_319737_.group,
                    Ingredient.CONTENTS_STREAM_CODEC,
                    p_319738_ -> p_319738_.ingredient,
                    ItemStack.STREAM_CODEC,
                    p_319736_ -> p_319736_.result,
                    pFactory::create
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

