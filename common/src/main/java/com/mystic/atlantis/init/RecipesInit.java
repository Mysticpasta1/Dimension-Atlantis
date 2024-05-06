package com.mystic.atlantis.init;

import com.mystic.atlantis.recipes.WritingRecipe;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

import java.util.function.Supplier;

import static net.minecraft.core.registries.Registries.RECIPE_SERIALIZER;
import static net.minecraft.core.registries.Registries.RECIPE_TYPE;

public class RecipesInit {

    public static class Types {
        public static final DeferredRegister<RecipeType<?>> RECIPE_WRITING = DeferredRegister.create("atlantis", RECIPE_TYPE);

        public static final RegistrySupplier<RecipeType<?>> WRITING = RECIPE_WRITING.register("writing", () -> new RecipeType<WritingRecipe>() {
            @Override
            public String toString() {
                return "writing";
            }
        });
    }

    public static class Serializers {
        public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create("atlantis", RECIPE_SERIALIZER);

        public static final Supplier<RecipeSerializer<?>> WRITING_SERIALIZER = RECIPE_SERIALIZERS.register("writing", () -> new WritingRecipe.Serializer<>(WritingRecipe::new));;
    }
    
    public static void init() {
        Serializers.RECIPE_SERIALIZERS.register();
        Types.RECIPE_WRITING.register();
    }
}
