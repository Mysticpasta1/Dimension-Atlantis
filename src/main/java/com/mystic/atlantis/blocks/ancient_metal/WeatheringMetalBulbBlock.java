package com.mystic.atlantis.blocks.ancient_metal;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;

public class WeatheringMetalBulbBlock extends MetalBulbBlock implements WeatheringMetal {
    public static final MapCodec<WeatheringMetalBulbBlock> CODEC = RecordCodecBuilder.mapCodec(
        p_309135_ -> p_309135_.group(
                    WeatherState.CODEC.fieldOf("weathering_state").forGetter(WeatheringMetalBulbBlock::getAge), propertiesCodec()
                )
                .apply(p_309135_, WeatheringMetalBulbBlock::new)
    );
    private final WeatherState weatherState;

    @Override
    protected MapCodec<WeatheringMetalBulbBlock> codec() {
        return CODEC;
    }

    public WeatheringMetalBulbBlock(WeatherState p_308927_, Properties p_309010_) {
        super(p_309010_);
        this.weatherState = p_308927_;
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

    public WeatherState getAge() {
        return this.weatherState;
    }
}
