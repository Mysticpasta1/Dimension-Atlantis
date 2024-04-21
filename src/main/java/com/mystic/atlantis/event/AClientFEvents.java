package com.mystic.atlantis.event;

import com.mystic.atlantis.overlay.OverlayEventHandler;
import com.mystic.atlantis.util.Reference;
import net.neoforged.neoforge.client.event.RegisterGuiOverlaysEvent;
import net.neoforged.neoforge.client.gui.overlay.VanillaGuiOverlay;
import net.neoforged.neoforge.eventbus.api.SubscribeEvent;
import net.neoforged.neoforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = Reference.MODID)
public class AClientFEvents {
    @SubscribeEvent
    public static void onOverlayRender(RegisterGuiOverlaysEvent event) {
        event.registerBelow(VanillaGuiOverlay.VIGNETTE.id(), Reference.MODID, new OverlayEventHandler());
    }
}
