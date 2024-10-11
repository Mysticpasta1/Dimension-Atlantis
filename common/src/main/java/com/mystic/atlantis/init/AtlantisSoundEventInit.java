package com.mystic.atlantis.init;

import com.mystic.atlantis.util.Reference;
import dev.architectury.registry.registries.DeferredRegister;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;

import java.util.function.Supplier;

public class AtlantisSoundEventInit {
	public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(Reference.MODID, Registries.SOUND_EVENT);
    public static final DeferredRegister<JukeboxSong> SONGS = DeferredRegister.create(Reference.MODID, Registries.JUKEBOX_SONG);

    public static final Supplier<SoundEvent> PANBEE = registerSound("panbee");
    public static final Supplier<SoundEvent> COLUMN = registerSound("column_cavitation");

    public static final Supplier<JukeboxSong> PANBEE_SONG = SONGS.register("panbee", () ->  new JukeboxSong(Holder.direct(PANBEE.get()), Component.literal("by LudoCrypt"), 202, 15));
    public static final Supplier<JukeboxSong> COLUMN_SONG = SONGS.register("column_cavitation", () ->  new JukeboxSong(Holder.direct(COLUMN.get()), Component.literal("by LudoCrypt"), 222, 15));

    private static Supplier<SoundEvent> registerSound(String name) {
        return SOUNDS.register(name, () ->  SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Reference.MODID, name)));
    }
    
    public static void init() {
    	SOUNDS.register();
        SONGS.register();
    }
}
