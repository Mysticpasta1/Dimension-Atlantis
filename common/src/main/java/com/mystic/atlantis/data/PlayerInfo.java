package com.mystic.atlantis.data;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.entity.player.Player;

public class PlayerInfo {

    @ExpectPlatform
    public static boolean spawnedInAtlantis(Player player) {
        throw new RuntimeException();
    }

    @ExpectPlatform
    public static void setSpawnedInAtlantis(Player player) {
        throw new RuntimeException();
    }
}
