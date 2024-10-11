package com.mystic.atlantis.util.neoforge;

import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.event.level.BlockEvent;

import java.util.HashMap;
import java.util.Map;

public class StrippableImpl {
    private static Map<Block, Block> STRIPPABLE = new HashMap<>();

    public static void add(RegistrySupplier<? extends Block> from, RegistrySupplier<? extends Block> to) {
        STRIPPABLE.put(from.get(), to.get());
    }

    public static void init(BlockEvent.BlockToolModificationEvent event) {
        if(event.getItemAbility() == ItemAbilities.AXE_STRIP) {
            var block = STRIPPABLE.getOrDefault(event.getState().getBlock(), null);
            if(block != null) event.setFinalState(block.defaultBlockState());
        }
    }
}
