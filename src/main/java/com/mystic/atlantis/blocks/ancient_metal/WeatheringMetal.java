package com.mystic.atlantis.blocks.ancient_metal;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import com.mojang.serialization.Codec;
import java.util.Optional;
import java.util.function.Supplier;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ChangeOverTimeBlock;
import net.minecraft.world.level.block.state.BlockState;

public interface WeatheringMetal extends ChangeOverTimeBlock<WeatheringMetal.WeatherState> {
    Supplier<BiMap<Block, Block>> NEXT_BY_BLOCK = Suppliers.memoize(
            () -> ImmutableBiMap.<Block, Block>builder()
                    .put(Blocks.COPPER_BLOCK, Blocks.EXPOSED_COPPER)
                    .put(Blocks.EXPOSED_COPPER, Blocks.WEATHERED_COPPER)
                    .put(Blocks.WEATHERED_COPPER, Blocks.OXIDIZED_COPPER)
                    .put(Blocks.CUT_COPPER, Blocks.EXPOSED_CUT_COPPER)
                    .put(Blocks.EXPOSED_CUT_COPPER, Blocks.WEATHERED_CUT_COPPER)
                    .put(Blocks.WEATHERED_CUT_COPPER, Blocks.OXIDIZED_CUT_COPPER)
                    .put(Blocks.CHISELED_COPPER, Blocks.EXPOSED_CHISELED_COPPER)
                    .put(Blocks.EXPOSED_CHISELED_COPPER, Blocks.WEATHERED_CHISELED_COPPER)
                    .put(Blocks.WEATHERED_CHISELED_COPPER, Blocks.OXIDIZED_CHISELED_COPPER)
                    .put(Blocks.CUT_COPPER_SLAB, Blocks.EXPOSED_CUT_COPPER_SLAB)
                    .put(Blocks.EXPOSED_CUT_COPPER_SLAB, Blocks.WEATHERED_CUT_COPPER_SLAB)
                    .put(Blocks.WEATHERED_CUT_COPPER_SLAB, Blocks.OXIDIZED_CUT_COPPER_SLAB)
                    .put(Blocks.CUT_COPPER_STAIRS, Blocks.EXPOSED_CUT_COPPER_STAIRS)
                    .put(Blocks.EXPOSED_CUT_COPPER_STAIRS, Blocks.WEATHERED_CUT_COPPER_STAIRS)
                    .put(Blocks.WEATHERED_CUT_COPPER_STAIRS, Blocks.OXIDIZED_CUT_COPPER_STAIRS)
                    .put(Blocks.COPPER_DOOR, Blocks.EXPOSED_COPPER_DOOR)
                    .put(Blocks.EXPOSED_COPPER_DOOR, Blocks.WEATHERED_COPPER_DOOR)
                    .put(Blocks.WEATHERED_COPPER_DOOR, Blocks.OXIDIZED_COPPER_DOOR)
                    .put(Blocks.COPPER_TRAPDOOR, Blocks.EXPOSED_COPPER_TRAPDOOR)
                    .put(Blocks.EXPOSED_COPPER_TRAPDOOR, Blocks.WEATHERED_COPPER_TRAPDOOR)
                    .put(Blocks.WEATHERED_COPPER_TRAPDOOR, Blocks.OXIDIZED_COPPER_TRAPDOOR)
                    .put(Blocks.COPPER_GRATE, Blocks.EXPOSED_COPPER_GRATE)
                    .put(Blocks.EXPOSED_COPPER_GRATE, Blocks.WEATHERED_COPPER_GRATE)
                    .put(Blocks.WEATHERED_COPPER_GRATE, Blocks.OXIDIZED_COPPER_GRATE)
                    .put(Blocks.COPPER_BULB, Blocks.EXPOSED_COPPER_BULB)
                    .put(Blocks.EXPOSED_COPPER_BULB, Blocks.WEATHERED_COPPER_BULB)
                    .put(Blocks.WEATHERED_COPPER_BULB, Blocks.OXIDIZED_COPPER_BULB)
                    .build()
    );
    Supplier<BiMap<Block, Block>> PREVIOUS_BY_BLOCK = Suppliers.memoize(() -> NEXT_BY_BLOCK.get().inverse());

    static Optional<Block> getPrevious(Block pBlock) {
        return Optional.ofNullable(PREVIOUS_BY_BLOCK.get().get(pBlock));
    }

    static Block getFirst(Block pBlock) {
        Block block = pBlock;

        for (Block block1 = PREVIOUS_BY_BLOCK.get().get(pBlock); block1 != null; block1 = PREVIOUS_BY_BLOCK.get().get(block1)) {
            block = block1;
        }

        return block;
    }

    static Optional<BlockState> getPrevious(BlockState pState) {
        return getPrevious(pState.getBlock()).map(p_154903_ -> p_154903_.withPropertiesOf(pState));
    }

    static Optional<Block> getNext(Block pBlock) {
        return Optional.ofNullable(NEXT_BY_BLOCK.get().get(pBlock));
    }

    static BlockState getFirst(BlockState pState) {
        return getFirst(pState.getBlock()).withPropertiesOf(pState);
    }

    @Override
    default Optional<BlockState> getNext(BlockState pState) {
        return getNext(pState.getBlock()).map(p_154896_ -> p_154896_.withPropertiesOf(pState));
    }

    @Override
    default float getChanceModifier() {
        return this.getAge() == WeatheringMetal.WeatherState.UNAFFECTED ? 0.75F : 1.0F;
    }

    public static enum WeatherState implements StringRepresentable {
        UNAFFECTED("unaffected"),
        EXPOSED("exposed"),
        WEATHERED("weathered"),
        OXIDIZED("oxidized");

        public static final Codec<WeatheringMetal.WeatherState> CODEC = StringRepresentable.fromEnum(WeatheringMetal.WeatherState::values);
        private final String name;

        private WeatherState(String pName) {
            this.name = pName;
        }

        @Override
        public String getSerializedName() {
            return this.name;
        }
    }
}

