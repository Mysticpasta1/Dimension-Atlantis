package com.mystic.atlantis.util.fabric;

import dev.architectury.registry.registries.RegistrySupplier;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.world.level.block.Block;

public class StrippableImpl {
    public static void add(RegistrySupplier<? extends Block> from, RegistrySupplier<? extends Block> to) {
        StrippableBlockRegistry.register(from.get(), to.get());
    }
}
