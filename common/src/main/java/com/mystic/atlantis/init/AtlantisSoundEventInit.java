package com.mystic.atlantis.init;

import com.mystic.atlantis.util.Reference;
import dev.architectury.registry.registries.DeferredRegister;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

import java.util.function.Supplier;

import static net.minecraft.core.registries.Registries.SOUND_EVENT;

public class AtlantisSoundEventInit {
	public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(Reference.MODID, SOUND_EVENT);

    public static final Supplier<SoundEvent> PANBEE = registerSound("panbee");
    public static final Supplier<SoundEvent> COLUMN = registerSound("column_cavitation");

    private static Supplier<SoundEvent> registerSound(String name) {
        return SOUNDS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Reference.MODID, name)));
    }
    
    public static void init() {
    	SOUNDS.register();
    }
}
