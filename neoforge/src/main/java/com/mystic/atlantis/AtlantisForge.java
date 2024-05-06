package com.mystic.atlantis;

import com.mystic.atlantis.datagen.Providers;
import com.mystic.atlantis.util.Reference;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Reference.MODID)
@EventBusSubscriber(modid = Reference.MODID, bus = EventBusSubscriber.Bus.MOD)
public class AtlantisForge {
    public AtlantisForge() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        Providers.init(bus);
        Atlantis.init();
    }
}
