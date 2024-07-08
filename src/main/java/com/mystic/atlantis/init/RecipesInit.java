package com.mystic.atlantis.init;

import com.mystic.atlantis.recipes.WritingRecipe;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class RecipesInit {

    public static class Types {
        public static final DeferredRegister<RecipeType<?>> RECIPE_WRITING = DeferredRegister.create(Registries.RECIPE_TYPE, "atlantis");

        public static final DeferredHolder<RecipeType<?>, RecipeType<WritingRecipe>> WRITING = RECIPE_WRITING.register("writing", RecipeType::simple);
    }

    public static class Serializers {
        public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(Registries.RECIPE_SERIALIZER, "atlantis");
        public static final Supplier<RecipeSerializer<?>> WRITING_SERIALIZER = RECIPE_SERIALIZERS.register("writing", WritingRecipe.WritingSerializer::new);
    }

    public static void init(IEventBus bus) {
        Serializers.RECIPE_SERIALIZERS.register(bus);
        Types.RECIPE_WRITING.register(bus);
    }
}
