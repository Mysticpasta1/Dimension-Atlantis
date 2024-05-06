package com.mystic.atlantis.init;

import com.google.common.collect.ImmutableSet;
import com.mystic.atlantis.util.Reference;
import dev.architectury.registry.registries.DeferredRegister;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.ai.village.poi.PoiTypes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Set;
import java.util.function.Supplier;

import static net.minecraft.core.registries.Registries.POINT_OF_INTEREST_TYPE;

public class POITypesInit extends PoiTypes {
    public static final DeferredRegister<PoiType> POI = DeferredRegister.create(Reference.MODID, POINT_OF_INTEREST_TYPE);

    public static final Supplier<PoiType> ATLANTEAN_PORTAL = POI.register("atlantean_portal" , () -> new PoiType(getBlockStates(BlockInit.ATLANTIS_CLEAR_PORTAL.get()), 0, 1));

    private static Set<BlockState> getBlockStates(Block pBlock) {
        return ImmutableSet.copyOf(pBlock.getStateDefinition().getPossibleStates());
    }

    public static void init() {
        POI.register();
    }
}
