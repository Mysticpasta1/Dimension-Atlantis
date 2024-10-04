package com.mystic.atlantis.init;

import com.mystic.atlantis.recipes.WritingRecipe;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

import java.util.function.Supplier;

public class RecipesInit {

    public static class Types {
        public static final DeferredRegister<RecipeType<?>> RECIPE_WRITING = DeferredRegister.create("atlantis", Registries.RECIPE_TYPE);

        public static final RegistrySupplier<RecipeType<WritingRecipe>> WRITING = register("writing");

        public static <T extends Recipe<?>> RegistrySupplier<RecipeType<T>> register(String name) {
            return RECIPE_WRITING.register(name, () -> new RecipeType<T>() {
                @Override
                public String toString() {
                    return name;
                }
            });
        }
    }

    public static class Serializers {
        public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create("atlantis", Registries.RECIPE_SERIALIZER);
        public static final Supplier<RecipeSerializer<?>> WRITING_SERIALIZER = RECIPE_SERIALIZERS.register("writing", WritingRecipe.WritingSerializer::new);
    }

    public static void init() {
        Serializers.RECIPE_SERIALIZERS.register();
        Types.RECIPE_WRITING.register();
    }
}
