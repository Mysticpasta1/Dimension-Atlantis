package com.mystic.atlantis.util;

import net.minecraft.world.entity.player.Player;
import net.minecraft.core.Direction;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Logic to keep track of the side of the block that was last hit
 *
 * Lifted directly from Tinker's Construct. This code is wholesale MIT.
 */
public class BlockSideHitListener {
  private static final Map<UUID,Direction> HIT_FACE = new HashMap<>();
  private static boolean init = false;

  /** Initializies this listener */
  public static void init() {
    if (init) {
      return;
    }
    init = true;
    NeoForge.EVENT_BUS.addListener(BlockSideHitListener::onLeftClickBlock);
    NeoForge.EVENT_BUS.addListener(BlockSideHitListener::onLeaveServer);
  }

  /** Called when the player left clicks a block to store the face */
  private static void onLeftClickBlock(PlayerInteractEvent.LeftClickBlock event) {
    HIT_FACE.put(event.getEntity().getUUID(), event.getFace());
  }

  /** Called when a player leaves the server to clear the face */
  private static void onLeaveServer(PlayerEvent.PlayerLoggedOutEvent event) {
    HIT_FACE.remove(event.getEntity().getUUID());
  }

  /**
   * Gets the side this player last hit, should return correct values in most modifier hooks related to block breaking
   * @param player  Player
   * @return  Side last hit
   */
  public static Direction getSideHit(Player player) {
    return HIT_FACE.getOrDefault(player.getUUID(), Direction.UP);
  }
}
