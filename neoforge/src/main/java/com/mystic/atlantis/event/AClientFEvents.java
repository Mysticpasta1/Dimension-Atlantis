package com.mystic.atlantis.event;

import com.mystic.atlantis.overlay.OverlayEventHandler;
import com.mystic.atlantis.util.Reference;
import dev.architectury.event.events.client.ClientGuiEvent;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.LayeredDraw;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent;
import net.neoforged.neoforge.client.gui.VanillaGuiLayers;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = Reference.MODID)
public class AClientFEvents {
    @SubscribeEvent
    public static void onOverlayRender(RegisterGuiLayersEvent event) {
        event.registerBelow(VanillaGuiLayers.EFFECTS, OverlayEventHandler.COCONUT_BLUR, (arg, f) -> OverlayEventHandler.renderCoconutBlur(arg));
    }
}
