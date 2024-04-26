package com.mystic.atlantis.event;

import com.mystic.atlantis.overlay.OverlayEventHandler;
import com.mystic.atlantis.util.Reference;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent;
import net.neoforged.neoforge.client.gui.VanillaGuiLayers;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = Reference.MODID)
public class AClientFEvents {
    @SubscribeEvent
    public static void onOverlayRender(RegisterGuiLayersEvent event) {
        event.registerBelow(VanillaGuiLayers.EFFECTS, OverlayEventHandler.COCONUT_BLUR, new OverlayEventHandler());
    }
}
