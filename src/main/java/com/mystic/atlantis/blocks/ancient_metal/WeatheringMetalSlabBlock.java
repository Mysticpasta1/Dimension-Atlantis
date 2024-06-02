package com.mystic.atlantis.blocks.ancient_metal;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.ChangeOverTimeBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class WeatheringMetalSlabBlock extends SlabBlock implements WeatheringMetal {
    public static final MapCodec<WeatheringMetalSlabBlock> CODEC = RecordCodecBuilder.mapCodec(
        p_308851_ -> p_308851_.group(WeatheringMetal.WeatherState.CODEC.fieldOf("weathering_state").forGetter(ChangeOverTimeBlock::getAge), propertiesCodec())
                .apply(p_308851_, WeatheringMetalSlabBlock::new)
    );
    private final WeatheringMetal.WeatherState weatherState;

    @Override
    public MapCodec<WeatheringMetalSlabBlock> codec() {
        return CODEC;
    }

    public WeatheringMetalSlabBlock(WeatheringMetal.WeatherState p_154938_, BlockBehaviour.Properties p_154939_) {
        super(p_154939_);
        this.weatherState = p_154938_;
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
