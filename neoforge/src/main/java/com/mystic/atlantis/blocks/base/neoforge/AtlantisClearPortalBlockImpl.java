package com.mystic.atlantis.blocks.base.neoforge;

import com.mystic.atlantis.dimension.AtlanteanPortalForcer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.portal.PortalInfo;
import net.neoforged.neoforge.common.util.ITeleporter;
import org.jetbrains.annotations.Nullable;

import java.util.function.Function;

public class AtlantisClearPortalBlockImpl {
    public static void changeDimension(Entity entity, ServerLevel serverlevel, AtlanteanPortalForcer atlanteanPortalForcer) {
        ITeleporter teleporter = new Teleporter(atlanteanPortalForcer);

        entity.changeDimension(serverlevel, teleporter);
    }

    private record Teleporter(AtlanteanPortalForcer forcer) implements ITeleporter {
        @Override
        public @Nullable PortalInfo getPortalInfo(Entity entity, ServerLevel destWorld, Function<ServerLevel, PortalInfo> defaultPortalInfo) {
            return forcer.getPortalInfo(entity, destWorld);
        }
    }
}
