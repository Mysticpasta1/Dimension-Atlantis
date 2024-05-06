package com.mystic.atlantis.mixin.client;

import net.minecraft.client.gui.Gui;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;

@Mixin(Gui.class)
class GuiMixin {
    @Inject(method = "re", at = @At("TAIL"))
    public void renderCameraOverlays() {

    }
}