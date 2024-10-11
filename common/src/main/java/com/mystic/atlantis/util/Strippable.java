package com.mystic.atlantis.util;

import dev.architectury.injectables.annotations.ExpectPlatform;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.world.level.block.Block;

public class Strippable {

    @ExpectPlatform
    public static void add(RegistrySupplier<? extends Block> from, RegistrySupplier<? extends Block> to) {
        throw new RuntimeException();
    }
}
