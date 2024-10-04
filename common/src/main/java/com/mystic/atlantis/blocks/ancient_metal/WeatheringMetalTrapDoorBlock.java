package com.mystic.atlantis.blocks.ancient_metal;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class WeatheringMetalTrapDoorBlock extends TrapDoorBlock implements WeatheringMetal {
    public static final MapCodec<WeatheringMetalTrapDoorBlock> CODEC = RecordCodecBuilder.mapCodec(
        p_308882_ -> p_308882_.group(
                    WeatherState.CODEC.fieldOf("weathering_state").forGetter(WeatheringMetalTrapDoorBlock::getAge),
                    propertiesCodec()
                )
                .apply(p_308882_, WeatheringMetalTrapDoorBlock::new)
    );
    private final WeatherState weatherState;

    @Override
    public MapCodec<WeatheringMetalTrapDoorBlock> codec() {
        return CODEC;
    }

    public WeatheringMetalTrapDoorBlock(WeatherState p_309166_, Properties p_308943_) {
        super(BlockSetType.COPPER, p_308943_.randomTicks());
        this.weatherState = p_309166_;
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
