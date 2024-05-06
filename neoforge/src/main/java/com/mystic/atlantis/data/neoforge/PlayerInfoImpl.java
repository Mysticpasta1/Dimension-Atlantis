package com.mystic.atlantis.data.neoforge;

import com.mojang.serialization.Codec;
import com.mystic.atlantis.util.Reference;
import net.minecraft.world.entity.player.Player;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.GAME)
public class PlayerInfoImpl {
    private static final DeferredRegister<AttachmentType<?>> ATTACHMENTS = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, Reference.MODID);

    private static final Supplier<AttachmentType<Boolean>> SPAWNED_IN_ATLANTIS = ATTACHMENTS.register("spawned_in_atlantis", () -> AttachmentType.builder(() -> false).serialize(Codec.BOOL).build());
    public static boolean spawnedInAtlantis(Player player) {

    }


}
