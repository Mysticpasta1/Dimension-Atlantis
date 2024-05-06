package com.mystic.atlantis.init;

import com.mystic.atlantis.inventory.LinguisticMenu;
import com.mystic.atlantis.inventory.WritingMenu;
import com.mystic.atlantis.util.Reference;
import dev.architectury.registry.registries.DeferredRegister;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.inventory.MenuType;

import java.util.function.Supplier;

import static net.minecraft.core.registries.Registries.MENU;

public class MenuTypeInit {
    public static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(Reference.MODID, MENU);
    public static final Supplier<MenuType<LinguisticMenu>> LINGUISTIC = CONTAINERS.register("linguistic", () -> new MenuType<>(LinguisticMenu::new, FeatureFlagSet.of()));
    public static final Supplier<MenuType<WritingMenu>> WRITING = CONTAINERS.register("writing", () -> new MenuType<>(WritingMenu::new, FeatureFlagSet.of()));

    public static void init() {
        CONTAINERS.register();
    }
}
