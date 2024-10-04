package com.mystic.atlantis.blocks.ancient_metal;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;

public class WeatheringMetalDoorBlock extends DoorBlock implements WeatheringMetal {
    public static final MapCodec<WeatheringMetalDoorBlock> CODEC = RecordCodecBuilder.mapCodec(
        p_309083_ -> p_309083_.group(
                    BlockSetType.CODEC.fieldOf("block_set_type").forGetter(DoorBlock::type),
                    WeatherState.CODEC.fieldOf("weathering_state").forGetter(WeatheringMetalDoorBlock::getAge),
                    propertiesCodec()
                )
                .apply(p_309083_, WeatheringMetalDoorBlock::new)
    );
    private final WeatherState weatherState;

    @Override
    public MapCodec<WeatheringMetalDoorBlock> codec() {
        return CODEC;
    }

    public WeatheringMetalDoorBlock(BlockSetType p_309051_, WeatherState p_308937_, Properties p_309122_) {
        super(p_309051_, p_309122_.randomTicks());
        this.weatherState = p_308937_;
    }

    /**
     * Performs a random tick on a block.
     */
    @Override
    protected void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pState.getValue(DoorBlock.HALF) == DoubleBlockHalf.LOWER) {
            this.changeOverTime(pState, pLevel, pPos, pRandom);
        }
    }

    @Override
    protected boolean isRandomlyTicking(BlockState pState) {
        return WeatheringMetal.getNext(pState.getBlock()).isPresent();
    }

    public WeatherState getAge() {
        return this.weatherState;
    }
}
