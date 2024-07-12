package com.mystic.atlantis.blocks.ancient_metal;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.WaterloggedTransparentBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class WeatheringMetalGrateBlock extends WaterloggedTransparentBlock implements WeatheringMetal {
    public static final MapCodec<WeatheringMetalGrateBlock> CODEC = RecordCodecBuilder.mapCodec(
        p_309146_ -> p_309146_.group(
                    WeatheringMetal.WeatherState.CODEC.fieldOf("weathering_state").forGetter(WeatheringMetalGrateBlock::getAge), propertiesCodec()
                )
                .apply(p_309146_, WeatheringMetalGrateBlock::new)
    );
    private final WeatheringMetal.WeatherState weatherState;

    @Override
    protected MapCodec<WeatheringMetalGrateBlock> codec() {
        return CODEC;
    }

    public WeatheringMetalGrateBlock(WeatheringMetal.WeatherState p_309130_, BlockBehaviour.Properties p_309077_) {
        super(p_309077_);
        this.weatherState = p_309130_;
    }

    /**
     * Performs a random tick on a block.
     */
    @Override
    protected void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        this.changeOverTime(pState, pLevel, pPos, pRandom);
    }

    @Override
    protected boolean isRandomlyTicking(BlockState pState) {
        return WeatheringMetal.getNext(pState.getBlock()).isPresent();
    }

    public WeatheringMetal.WeatherState getAge() {
        return this.weatherState;
    }
}
