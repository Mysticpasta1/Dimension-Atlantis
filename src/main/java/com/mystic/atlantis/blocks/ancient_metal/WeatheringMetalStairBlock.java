package com.mystic.atlantis.blocks.ancient_metal;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.ChangeOverTimeBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class WeatheringMetalStairBlock extends StairBlock implements WeatheringMetal {
    public static final MapCodec<WeatheringMetalStairBlock> CODEC = RecordCodecBuilder.mapCodec(
        p_308852_ -> p_308852_.group(
                    WeatheringMetal.WeatherState.CODEC.fieldOf("weathering_state").forGetter(ChangeOverTimeBlock::getAge),
                    BlockState.CODEC.fieldOf("base_state").forGetter(p_304556_ -> p_304556_.baseState),
                    propertiesCodec()
                )
                .apply(p_308852_, WeatheringMetalStairBlock::new)
    );
    private final WeatheringMetal.WeatherState weatherState;

    @Override
    public MapCodec<WeatheringMetalStairBlock> codec() {
        return CODEC;
    }

    public WeatheringMetalStairBlock(WeatheringMetal.WeatherState p_154951_, BlockState p_154952_, BlockBehaviour.Properties p_154953_) {
        super(p_154952_, p_154953_);
        this.weatherState = p_154951_;
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