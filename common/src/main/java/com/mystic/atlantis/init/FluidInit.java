package com.mystic.atlantis.init;

import com.mystic.atlantis.util.Reference;
import dev.architectury.core.fluid.ArchitecturyFlowingFluid;
import dev.architectury.core.fluid.SimpleArchitecturyFluidAttributes;
import dev.architectury.registry.registries.DeferredRegister;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;

import java.util.function.Supplier;

public class FluidInit {
    public static final ResourceLocation WATER_STILL = new ResourceLocation("block/water_still");
    public static final ResourceLocation WATER_FLOWING = new ResourceLocation("block/water_flow");
    public static final ResourceLocation WATER_OVERLAY = new ResourceLocation("block/water_overlay");
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(Reference.MODID, Registries.FLUID);

    public static final Supplier<FlowingFluid> JETSTREAM_WATER = FLUIDS.register("jetstream_water",
            () -> new ArchitecturyFlowingFluid.Source(FluidInit.JETSTREAM_WATER_FLUID_PROPERTIES));
    public static final Supplier<FlowingFluid> FLOWING_JETSTREAM_WATER = FLUIDS.register("flowing_jetstream_water",
            () -> new ArchitecturyFlowingFluid.Flowing(FluidInit.JETSTREAM_WATER_FLUID_PROPERTIES));


    public static final SimpleArchitecturyFluidAttributes JETSTREAM_WATER_FLUID_PROPERTIES = SimpleArchitecturyFluidAttributes.of(JETSTREAM_WATER, FLOWING_JETSTREAM_WATER)
            .slopeFindDistance(2).dropOff(1).block(BlockInit.JETSTREAM_WATER_BLOCK)
            .bucketItem(ItemInit.JETSTREAM_WATER_BUCKET).density(15).viscosity(1000)
            .overlayTexture(WATER_OVERLAY).flowingTexture(WATER_FLOWING).sourceTexture(WATER_STILL)
            .color(0x52A9FFD0);

    public static final Supplier<FlowingFluid> SALTY_SEA_WATER = FLUIDS.register("salty_sea_water",
            () -> new ArchitecturyFlowingFluid.Source(FluidInit.SALTY_SEA_WATER_FLUID_PROPERTIES));
    public static final Supplier<FlowingFluid> FLOWING_SALTY_SEA_WATER = FLUIDS.register("flowing_salty_sea_water",
            () -> new ArchitecturyFlowingFluid.Flowing(FluidInit.SALTY_SEA_WATER_FLUID_PROPERTIES));

    public static final SimpleArchitecturyFluidAttributes SALTY_SEA_WATER_FLUID_PROPERTIES = SimpleArchitecturyFluidAttributes.of(SALTY_SEA_WATER, FLOWING_SALTY_SEA_WATER)
            .slopeFindDistance(2).dropOff(3).block(BlockInit.SALTY_SEA_WATER_BLOCK)
            .bucketItem(ItemInit.SALTY_SEA_WATER_BUCKET).density(0).viscosity(1000)
            .overlayTexture(WATER_OVERLAY).flowingTexture(WATER_FLOWING).sourceTexture(WATER_STILL)
            .color(0x100A60D0);

  // public static final Supplier<FlowingFluid> COCONUT_MILK = FLUIDS.register("coconut_milk",
  //         () -> new ForgeFlowingFluid.Source(FluidInit.COCONUT_MILK_FLUID_PROPERTIES));
  // public static final Supplier<FlowingFluid> FLOWING_COCONUT_MILK = FLUIDS.register("flowing_coconut_milk",
  //         () -> new ForgeFlowingFluid.Flowing(FluidInit.COCONUT_MILK_FLUID_PROPERTIES));

  // public static final ForgeFlowingFluid.Properties COCONUT_MILK_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
  //         FluidTypesInit.COCONUT_MILK_FLUID_TYPE, COCONUT_MILK, FLOWING_COCONUT_MILK)
  //         .slopeFindDistance(2).levelDecreasePerBlock(1).block(BlockInit.COCONUT_MILK)
  //         .bucket(ItemInit.COCONUT_MILK_BUCKET);

    public static void init() {
        FLUIDS.register();
    }
}
