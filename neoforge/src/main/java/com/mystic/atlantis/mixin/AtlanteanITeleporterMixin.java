package com.mystic.atlantis.mixin;

import com.mystic.atlantis.dimension.AtlanteanITeleporter;
import net.neoforged.neoforge.common.util.ITeleporter;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(AtlanteanITeleporter.class)
public interface AtlanteanITeleporterMixin extends ITeleporter {
}
