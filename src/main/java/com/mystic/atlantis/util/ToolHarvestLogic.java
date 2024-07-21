package com.mystic.atlantis.util;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundBlockUpdatePacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Collections;
import java.util.Objects;

/**
 * External logic for the ToolCore that handles mining calculations and breaking blocks.
 * TODO: needs big updates
 */
public class ToolHarvestLogic {
  private ToolHarvestLogic() {}

  /**
   * Breaks a secondary block
   * @param context   Tool harvest context
   */
  public static void breakExtraBlock(ToolHarvestContext context) {
    // break the actual block
    if (context.getPlayer().gameMode.destroyBlock(context.getPos())) {
      Level world = context.getWorld();
      BlockPos pos = context.getPos();
      // need to send the event to tell the client a block was broken
      // normally this is sent within one of the block breaking hooks that is called on both sides, suppressing the packet being sent to the breaking player
      // we only break the center block client side, so need to send the event directly
      // TODO: in theory, we can use this to reduce the number of sounds playing on breaking a lot of blocks, would require sending a custom packet if we want the particles still
      world.levelEvent(2001, pos, Block.getId(context.getState()));
      sendVanillaPacket(Objects.requireNonNull(context.getPlayer()), new ClientboundBlockUpdatePacket(world, pos));
    }
  }

  /**
   * Sends a vanilla packet to the given player
   * @param player  Player
   * @param packet  Packet
   */
  public static void sendVanillaPacket(Entity player, Packet<?> packet) {
    if (player instanceof ServerPlayer serverPlayer) {
      serverPlayer.connection.send(packet);
    }
  }


  /**
   * Call on block break to break a block.
   * See also {@link net.minecraft.client.multiplayer.MultiPlayerGameMode#destroyBlock(BlockPos)} (client)
   * and {@link net.minecraft.server.level.ServerPlayerGameMode#destroyBlock(BlockPos)} (server)
   * @param stack   Stack instance
   * @param pos     Position to break
   * @param player  Player instance
   * @return  True if the block break is overridden.
   */
  public static boolean handleBlockBreak(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player) {
    // client can run normal block breaking
    if (level.isClientSide || !(player instanceof ServerPlayer serverPlayer) ) {
      return false;
    }

    // create contexts
    ServerLevel world = (ServerLevel) level;
    Direction sideHit = BlockSideHitListener.getSideHit(player);

    // if broken, clear the item stack temporarily then break

      // add in harvest info
      // must not be broken, and the tool definition must be effective
      ToolHarvestContext context = new ToolHarvestContext(world, serverPlayer, state, pos, sideHit,
              !player.isCreative() && state.canHarvestBlock(world, pos, player),
              stack.getItem().isCorrectToolForDrops(stack, state));

      Iterable<BlockPos> extraBlocks = context.isEffective() ? BoxAOEIterator.getBlocks(stack, player, state, world, pos, sideHit) : Collections.emptyList();

      // actually break the block, run AOE if successful
      boolean didHarvest = ((ServerPlayer) player).gameMode.destroyBlock(pos);
      if (didHarvest) {
        for (BlockPos extraPos : extraBlocks) {
          BlockState extraState = world.getBlockState(extraPos);
          // prevent calling that stuff for air blocks, could lead to unexpected behaviour since it fires events
          // this should never actually happen, but just in case some AOE is odd
          if (!extraState.isAir()) {
            // prevent mutable position leak, breakBlock has a few places wanting immutable
            breakExtraBlock(context.forPosition(extraPos.immutable(), extraState));
          }
        }
      }

    return true;
  }
}
