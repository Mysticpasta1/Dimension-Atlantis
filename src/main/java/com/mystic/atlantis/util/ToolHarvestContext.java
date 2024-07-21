package com.mystic.atlantis.util;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;

import javax.annotation.Nullable;

/** Context for harvest related modifier hooks */
public class ToolHarvestContext {
  /** World containing the harvested block */
  private final ServerLevel world;
  /** Living entity harvesting the block */
  private final LivingEntity living;
  /** Player harvesting the block, null if not a player */
  @Nullable
  private final ServerPlayer player;
  /** State being harvested */
  private final BlockState state;
  /** Position being harvested */
  private final BlockPos pos;
  /** Side of the block being hit */
  private final Direction sideHit;
  /** If true, this block can be harvested by the tool */
  private final boolean canHarvest;
  /** If true, the tool is effective on the block */
  private final boolean isEffective;

  /* AOE context */
  /** If true, this block is not the originally targeted block */
  private final boolean isAOE;
  /** Originally targeted position for AOE blocks. Will be the same as {@link #pos} for the original block */
  private final BlockPos targetedPos;
  /** Originally targeted block state. Will be the same as {@link #state} for the original block */
  private final BlockState targetedState;

  public ToolHarvestContext(ServerLevel world, ServerPlayer player, BlockState state, BlockPos pos, Direction sideHit, boolean canHarvest, boolean isEffective) {
    this.world = world;
    this.living = player;
    this.player = player;
    this.state = state;
    this.pos = pos;
    this.canHarvest = canHarvest;
    this.isEffective = isEffective;
    this.sideHit = sideHit;
    this.isAOE = false;
    this.targetedPos = pos;
    this.targetedState = state;
  }

  public ToolHarvestContext(ServerLevel world, LivingEntity living, BlockState state, BlockPos pos, Direction sideHit, boolean canHarvest, boolean isEffective) {
    this.world = world;
    this.living = living;
    this.player = living instanceof ServerPlayer ? (ServerPlayer) living : null;
    this.state = state;
    this.pos = pos;
    this.canHarvest = canHarvest;
    this.isEffective = isEffective;
    this.sideHit = sideHit;
    this.isAOE = false;
    this.targetedPos = pos;
    this.targetedState = state;
  }

  public ToolHarvestContext(ServerLevel world, LivingEntity living, ServerPlayer player, BlockState state, BlockPos pos, Direction sideHit, boolean canHarvest, boolean isEffective, boolean isAOE, BlockPos targetedPos, BlockState targetedState) {
    this.world = world;
    this.living = living;
    this.player = player;
    this.state = state;
    this.pos = pos;
    this.sideHit = sideHit;
    this.canHarvest = canHarvest;
    this.isEffective = isEffective;
    this.isAOE = isAOE;
    this.targetedPos = targetedPos;
    this.targetedState = targetedState;
  }

  /** Creates a copy of this context for the given position */
  public ToolHarvestContext forPosition(BlockPos pos, BlockState state) {
    return new ToolHarvestContext(this.world, this.living, this.player, state, pos, this.sideHit, state.canHarvestBlock(world, pos, player), true, true, this.targetedPos, this.targetedState);
  }

  public boolean isEffective() {
      return isEffective;
  }

  public ServerLevel getWorld() {
    return world;
  }

  public ServerPlayer getPlayer() {
    return player;
  }

  public BlockPos getPos() {
    return pos;
  }

  public BlockState getState() {
    return state;
  }

  public boolean canHarvest() {
    return canHarvest;
  }
}
