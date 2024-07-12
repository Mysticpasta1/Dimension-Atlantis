package com.mystic.atlantis.blocks.ancient_metal;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ChangeOverTimeBlock;
import net.minecraft.world.level.block.state.BlockState;

public class WeatheringMetalFullBlock extends Block implements WeatheringMetal {
    public static final MapCodec<WeatheringMetalFullBlock> CODEC = RecordCodecBuilder.mapCodec(
            p_308850_ -> p_308850_.group(WeatherState.CODEC.fieldOf("weathering_state").forGetter(ChangeOverTimeBlock::getAge), propertiesCodec())
                    .apply(p_308850_, WeatheringMetalFullBlock::new)
    );
    private final WeatherState weatherState;

    @Override
    public MapCodec<WeatheringMetalFullBlock> codec() {
        return CODEC;
    }

    public WeatheringMetalFullBlock(WeatherState p_154925_, Properties p_154926_) {
        super(p_154926_);
        this.weatherState = p_154925_;
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
