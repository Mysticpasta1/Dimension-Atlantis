package com.mystic.atlantis.blocks.base.fabric;

import com.mystic.atlantis.dimension.AtlanteanPortalForcer;
import dev.architectury.event.events.common.PlayerEvent;
import net.fabricmc.fabric.api.dimension.v1.FabricDimensions;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;

public class AtlantisClearPortalBlockImpl {
    public static void changeDimension(Entity entity, ServerLevel serverlevel, AtlanteanPortalForcer atlanteanPortalForcer) {
        FabricDimensions.teleport(entity, serverlevel, atlanteanPortalForcer.getPortalInfo(entity, serverlevel));
    }
}
