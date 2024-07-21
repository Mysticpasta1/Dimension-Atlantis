package com.mystic.atlantis.util;

import com.google.common.collect.AbstractIterator;
import com.mystic.atlantis.items.tools.AtlanteanHammerItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Collections;
import java.util.function.Predicate;

/**
 * AOE harvest logic that mines blocks in a rectangle
 */
public class BoxAOEIterator {

  /** Gets the size for a given level of expanded */
  private static BoxSize sizeFor(ItemStack stack) {
    if (!(stack.getItem() instanceof AtlanteanHammerItem hammerItem)) {
      return new BoxSize(1, 1, 1);
    }

    var size = hammerItem.size();

    int depth = stack.get(DataComponents.ENCHANTMENTS).keySet().stream().anyMatch(enchantmentHolder -> enchantmentHolder.is(hammerItem.enchantment())) ? size : 1;

    return new BoxSize(size, size, depth);
  }


  public static Iterable<BlockPos> getBlocks(ItemStack stack, Player player, BlockState state, Level world, BlockPos origin, Direction sideHit) {
    // expanded gives an extra width every odd level, and an extra height every even level

    return calculate(stack, world, player, origin, sideHit, sizeFor(stack));
  }

  /**
   *
   * @param stack         Item stack used for harvest (for vanilla hooks)
   * @param world         World containing the block
   * @param player        Player harvesting
   * @param origin        Center of harvest
   * @param sideHit       Block side hit
   * @param extraSize     Extra size to iterate
   * @return  List of block positions
   */
  public static Iterable<BlockPos> calculate(ItemStack stack, Level world, Player player, BlockPos origin, Direction sideHit, BoxSize extraSize) {
    // skip if no work
    if (extraSize.isZero()) {
      return Collections.emptyList();
    }

    ExpansionDirections expansion = getExpansion(player, sideHit);

    Predicate<BlockPos> posPredicate = defaultBlockPredicate(stack, world, origin);
    return () -> new RectangleIterator(origin, expansion.width(), extraSize.width, expansion.height(), extraSize.height, expansion.traverseDown(), expansion.depth(), extraSize.depth, posPredicate);
  }

  /** Iterator used for getting the blocks */
  public static class RectangleIterator extends AbstractIterator<BlockPos> {
    /** Primary direction of iteration */
    private final Direction widthDir;
    /** Secondary direction of iteration, mostly interchangeable with primary */
    private final Direction heightDir;
    /** Direction of iteration away from the player */
    private final Direction depthDir;

    /* Bounding box size in the direction of width */
    private final int maxWidth;
    /* Bounding box size in the direction of height */
    private final int maxHeight;
    /* Bounding box size in the direction of depth */
    private final int maxDepth;

    /** Current position in the direction of width */
    private int currentWidth = 0;
    /** Current position in the direction of height */
    private int currentHeight = 0;
    /** Current position in the direction of depth */
    private int currentDepth = 0;

    /** Original position, skipped in iteration */
    protected final BlockPos origin;
    /** Position modified as we iterate */
    protected final BlockPos.MutableBlockPos mutablePos;
    /** Predicate to check before returning a position */
    protected final Predicate<BlockPos> posPredicate;
    /** Last returned values for the three coords */
    protected int lastX, lastY, lastZ;

    /**
     * Iterates through a rectangular solid
     * @param origin         Center position
     * @param widthDir       Direction for width traversal
     * @param extraWidth     Radius in width direction
     * @param heightDir      Direction for height traversal
     * @param extraHeight    Amount in the height direction
     * @param traverseDown   If true, navigates extraHeight both up and down
     * @param depthDir       Direction to travel backwards
     * @param extraDepth     Extra amount to traverse in the backwards direction
     * @param posPredicate   Predicate to validate positions
     */
    public RectangleIterator(BlockPos origin, Direction widthDir, int extraWidth, Direction heightDir, int extraHeight, boolean traverseDown, Direction depthDir, int extraDepth, Predicate<BlockPos> posPredicate) {
      this.origin = origin;
      this.widthDir = widthDir;
      this.heightDir = heightDir;
      this.depthDir = depthDir;
      this.maxWidth = extraWidth * 2;
      this.maxHeight = traverseDown ? extraHeight * 2 : extraHeight;
      this.maxDepth = extraDepth;
      // start 1 block before start on the correct axis
      // computed values
      this.mutablePos = new MutableBlockPos(origin.getX(), origin.getY(), origin.getZ());
      this.posPredicate = posPredicate;
      // offset position back by 1 so we start at 0, 0, 0
      if (extraWidth > 0) {
        currentWidth--;
      } else if (extraHeight > 0) {
        currentHeight--;
      }
      // offset the mutable position back along the rectangle
      this.mutablePos.move(widthDir, -extraWidth + currentWidth);
      if (traverseDown) {
        this.mutablePos.move(heightDir, -extraHeight + currentHeight);
      } else if (currentHeight != 0) {
        this.mutablePos.move(heightDir, currentHeight);
      }
      this.lastX = this.mutablePos.getX();
      this.lastY = this.mutablePos.getY();
      this.lastZ = this.mutablePos.getZ();
    }

    /**
     * Updates the mutable block position
     * @return False if at the end of data
     */
    protected boolean incrementPosition() {
      // first, increment values
      // if at the end of the width, increment height
      if (currentWidth == maxWidth) {
        // at the end of the height, increment depth
        if (currentHeight == maxHeight) {
          // at the end of depth, we are done
          if (currentDepth == maxDepth) {
            return false;
          }
          // increase depth
          currentDepth++;
          mutablePos.move(depthDir);
          // reset height
          currentHeight = 0;
          mutablePos.move(heightDir, -maxHeight);
        } else {
          currentHeight++;
          mutablePos.move(heightDir);
        }
        currentWidth = 0;
        mutablePos.move(widthDir, -maxWidth);
      } else {
        currentWidth++;
        mutablePos.move(widthDir);
      }
      return true;
    }

    @Override
    protected BlockPos computeNext() {
      // ensure the position did not get changed by the consumer last time
      mutablePos.set(lastX, lastY, lastZ);
      // as long as we have another position, try using it
      while (incrementPosition()) {
        // skip over the origin, ensure it matches the predicate
        if (!mutablePos.equals(origin) && posPredicate.test(mutablePos)) {
          // store position in case the consumer changes it
          lastX = mutablePos.getX();
          lastY = mutablePos.getY();
          lastZ = mutablePos.getZ();
          return mutablePos;
        }
      }
      return endOfData();
    }
  }

  /** Record encoding how AOE expands with each level */
  private record BoxSize(int width, int height, int depth) {
    public static final BoxSize ZERO = new BoxSize(0, 0, 0);

    /** If true, the box is 0 in all dimensions */
    public boolean isZero() {
      return width == 0 && height == 0 && depth == 0;
    }
  }

  static Predicate<BlockPos> defaultBlockPredicate(ItemStack stack, Level world, BlockPos origin) {
    // requires effectiveness

    // don't let hardness vary too much
    float refHardness = world.getBlockState(origin).getDestroySpeed(world, origin);
    return pos -> {
      BlockState state = world.getBlockState(pos);
      if (state.isAir()) {
        return false;
      }
      // if the hardness varies by too much, don't allow breaking
      float hardness = state.getDestroySpeed(world, pos);
      if (hardness == -1) {
        return false;
      }
      if (refHardness == 0 ? hardness == 0 : hardness / refHardness <= 3) {
        // must not be broken, and the tool definition must be effective
        return stack.getItem().isCorrectToolForDrops(stack, state);
      }
      return false;
    };
  }

  public static ExpansionDirections getExpansion(Player player, Direction sideHit) {
    // depth is always direction into the block
    Direction depth = sideHit.getOpposite();
    Direction width, height;
    // for Y, direction is based on facing
    if (sideHit.getAxis() == Direction.Axis.Y) {
      height = player.getDirection();
      width = height.getClockWise();
    } else {
      // for X and Z, just rotate from side hit
      width = sideHit.getCounterClockWise();
      height = Direction.UP;
    }
    return new ExpansionDirections(width, height, depth, true);
  }

  record ExpansionDirections(Direction width, Direction height, Direction depth, boolean traverseDown) {}
}
