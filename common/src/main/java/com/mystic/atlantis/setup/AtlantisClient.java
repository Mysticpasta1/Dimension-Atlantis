package com.mystic.atlantis.setup;

import com.google.common.collect.ArrayListMultimap;
import com.mystic.atlantis.AtlantisDimensionalEffect;
import com.mystic.atlantis.blocks.blockentities.plants.GeneralPlantBlockEntity;
import com.mystic.atlantis.blocks.blockentities.renderers.GeneralPlantRenderer;
import com.mystic.atlantis.blocks.blockentities.renderers.SodiumBombRenderer;
import com.mystic.atlantis.dimension.DimensionAtlantis;
import com.mystic.atlantis.entities.models.*;
import com.mystic.atlantis.entities.renders.*;
import com.mystic.atlantis.init.AtlantisEntityInit;
import com.mystic.atlantis.init.BlockInit;
import com.mystic.atlantis.init.FluidInit;
import com.mystic.atlantis.init.TileEntityInit;
import com.mystic.atlantis.particles.PushBubbleStreamParticle;
import com.mystic.atlantis.util.Reference;
import dev.architectury.registry.client.level.entity.EntityRendererRegistry;
import dev.architectury.registry.client.particle.ParticleProviderRegistry;
import dev.architectury.registry.client.rendering.BlockEntityRendererRegistry;
import dev.architectury.registry.client.rendering.ColorHandlerRegistry;
import dev.architectury.registry.client.rendering.RenderTypeRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.RegisterDimensionSpecialEffectsEvent;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;
import java.util.stream.Stream;

import static com.mystic.atlantis.init.BlockInit.*;

public class AtlantisClient {
    public static DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(Reference.MODID, Registries.PARTICLE_TYPE);
    public static final RegistrySupplier<SimpleParticleType> PUSH_BUBBLESTREAM = PARTICLES.register("push_bubblestream", () -> new SimpleParticleType(false));

    public static void onInitializeClient() {

        RenderTypeRegistry.register(RenderType.translucent(), FluidInit.JETSTREAM_WATER.get());
        RenderTypeRegistry.register(RenderType.translucent(), FluidInit.FLOWING_JETSTREAM_WATER.get());

        RenderTypeRegistry.register(RenderType.translucent(), FluidInit.SALTY_SEA_WATER.get());
        RenderTypeRegistry.register(RenderType.translucent(), FluidInit.FLOWING_SALTY_SEA_WATER.get());

        //ItemBlockRenderTypes.setRenderLayer(FluidInit.COCONUT_MILK.get(), RenderType.translucent());
        //ItemBlockRenderTypes.setRenderLayer(FluidInit.FLOWING_COCONUT_MILK.get(), RenderType.translucent());

        registerPlantRenderer(TileEntityInit.UNDERWATER_SHROOM_TILE, "underwater_shroom");

        registerPlantRenderer(TileEntityInit.TUBER_UP_TILE, "tuber_up");

        registerPlantRenderer(TileEntityInit.BLUE_LILY_TILE, "blue_lily");

        registerPlantRenderer(TileEntityInit.BURNT_DEEP_TILE, "burnt_deep");

        registerPlantRenderer(TileEntityInit.ENENMOMY_TILE, "enenmomy");

        for (DyeColor dyeColor : DyeColor.values()) {
            RenderTypeRegistry.register(RenderType.cutoutMipped(),
                    MOSSY_SHELL_BLOCKS.get(dyeColor).get(),
                    CRACKED_MOSSY_SHELL_BLOCKS.get(dyeColor).get());
        }

        RenderTypeRegistry.register(RenderType.cutout(),
                BlockInit.BLUE_LILY_BLOCK.get(),
                BlockInit.BURNT_DEEP_BLOCK.get(),
                BlockInit.ENENMOMY_BLOCK.get(),
                BlockInit.TUBER_UP_BLOCK.get(),
                BlockInit.UNDERWATER_SHROOM_BLOCK.get(),
                BlockInit.ATLANTEAN_FIRE_MELON_FRUIT.get(),
                BlockInit.ATLANTEAN_FIRE_MELON_FRUIT_SPIKED.get(),
                BlockInit.ATLANTEAN_FIRE_MELON_STEM.get(),
                BlockInit.ATLANTEAN_FIRE_MELON_TOP.get(),
                BlockInit.ATLANTEAN_DOOR.get(),
                BlockInit.ATLANTEAN_TRAPDOOR.get(),
                BlockInit.ATLANTEAN_SAPLING.get(),
                BlockInit.ATLANTEAN_PALM_SAPLING.get(),
                BlockInit.UNDERWATER_FLOWER.get(),
                BlockInit.ALGAE.get(),
                BlockInit.ATLANTEAN_POWER_TORCH.get(),
                BlockInit.WALL_ATLANTEAN_POWER_TORCH.get(),
                BlockInit.ATLANTEAN_POWER_DUST_WIRE.get(),
                BlockInit.ATLANTEAN_POWER_REPEATER.get(),
                BlockInit.ATLANTEAN_TRIPWIRE.get(),
                BlockInit.ATLANTEAN_TRIPWIRE_HOOK.get(),
                BlockInit.YELLOW_UNDERWATER_FLOWER.get(),
                BlockInit.RED_UNDERWATER_FLOWER.get(),
                BlockInit.ATLANTEAN_POWER_COMPARATOR.get(),
                BlockInit.ANCIENT_ACACIA_WOOD_MOSS_DOOR.get(),
                BlockInit.ANCIENT_BIRCH_WOOD_MOSS_DOOR.get(),
                BlockInit.ANCIENT_DARK_OAK_WOOD_MOSS_DOOR.get(),
                BlockInit.ANCIENT_JUNGLE_WOOD_MOSS_DOOR.get(),
                BlockInit.ANCIENT_OAK_WOOD_MOSS_DOOR.get(),
                BlockInit.ANCIENT_SPRUCE_WOOD_MOSS_DOOR.get(),
                BlockInit.ANCIENT_ACACIA_WOOD_MOSS_TRAPDOOR.get(),
                BlockInit.ANCIENT_BIRCH_WOOD_MOSS_TRAPDOOR.get(),
                BlockInit.ANCIENT_DARK_OAK_WOOD_MOSS_TRAPDOOR.get(),
                BlockInit.ANCIENT_JUNGLE_WOOD_MOSS_TRAPDOOR.get(),
                BlockInit.ANCIENT_OAK_WOOD_MOSS_TRAPDOOR.get(),
                BlockInit.ANCIENT_SPRUCE_WOOD_MOSS_TRAPDOOR.get(),
                BlockInit.PURPLE_GLOWING_MUSHROOM.get(),
                BlockInit.YELLOW_GLOWING_MUSHROOM.get());
        RenderTypeRegistry.register(RenderType.translucent(),
                BlockInit.BLACK_PEARL_BLOCK.get(),
                BlockInit.GRAY_PEARL_BLOCK.get(),
                BlockInit.WHITE_PEARL_BLOCK.get(),
                BlockInit.LIGHT_GRAY_PEARL_BLOCK.get(),
                BlockInit.BLUE_PEARL_BLOCK.get(),
                BlockInit.LIGHT_BLUE_PEARL_BLOCK.get(),
                BlockInit.RED_PEARL_BLOCK.get(),
                BlockInit.ORANGE_PEARL_BLOCK.get(),
                BlockInit.PINK_PEARL_BLOCK.get(),
                BlockInit.YELLOW_PEARL_BLOCK.get(),
                BlockInit.GREEN_PEARL_BLOCK.get(),
                BlockInit.LIME_PEARL_BLOCK.get(),
                BlockInit.PURPLE_PEARL_BLOCK.get(),
                BlockInit.MAGENTA_PEARL_BLOCK.get(),
                BlockInit.CYAN_PEARL_BLOCK.get(),
                BlockInit.BROWN_PEARL_BLOCK.get(),
                BlockInit.ATLANTIS_CLEAR_PORTAL.get());
        RenderTypeRegistry.register(RenderType.cutoutMipped(),
                BlockInit.PALM_LEAVES.get(),
                BlockInit.ATLANTEAN_LEAVES.get());

        registerColors();
        init();
        entityRegisterEvent();
    }

    private static <T extends GeneralPlantBlockEntity<T>> void registerPlantRenderer(Supplier<BlockEntityType<T>> registryObject, String name) {
        BlockEntityRendererRegistry.register(registryObject.get(), pContext -> new GeneralPlantRenderer<>(name));
    }

    @SubscribeEvent
    public static void registerDimensionEffect(RegisterDimensionSpecialEffectsEvent event) {
        event.register(DimensionAtlantis.ATLANTIS_DIMENSION_EFFECT, AtlantisDimensionalEffect.INSTANCE);
    }

    public static void entityRegisterEvent() {
        EntityRendererRegistry.register(AtlantisEntityInit.CRAB, entityRenderDispatcher -> new CrabEntityRenderer(entityRenderDispatcher, new CrabEntityModel()));
        EntityRendererRegistry.register(AtlantisEntityInit.COCONUT_CRAB, entityRenderDispatcher -> new CoconutCrabEntityRenderer(entityRenderDispatcher, new CoconutCrabEntityModel()));
        EntityRendererRegistry.register(AtlantisEntityInit.JELLYFISH, entityRenderDispatcher -> new JellyfishEntityRenderer(entityRenderDispatcher, new JellyfishEntityModel()));
        EntityRendererRegistry.register(AtlantisEntityInit.SHRIMP, entityRenderDispatcher -> new ShrimpEntityRenderer(entityRenderDispatcher, new ShrimpEntityModel()));
        EntityRendererRegistry.register(AtlantisEntityInit.SUBMARINE, SubmarineEntityRenderer::new);
        EntityRendererRegistry.register(AtlantisEntityInit.ATLANTEAN_BOAT, AtlanteanBoatRenderer::new);
        EntityRendererRegistry.register(AtlantisEntityInit.LEVIATHAN, entityRenderDispatcher -> new LeviathanEntityRenderer(entityRenderDispatcher, new LeviathanEntityModel()));
        EntityRendererRegistry.register(AtlantisEntityInit.SEAHORSE, entityRenderDispatcher -> new SeahorseEntityRenderer(entityRenderDispatcher, new SeahorseEntityModel()));
        EntityRendererRegistry.register(AtlantisEntityInit.STARFISH, entityRenderDispatcher -> new StarfishEntityRenderer(entityRenderDispatcher, new StarfishEntityModel()));
        EntityRendererRegistry.register(AtlantisEntityInit.STARFISH_ZOM, entityRenderDispatcher -> new StarfishZomEntityRenderer(entityRenderDispatcher, new StarfishZomEntityModel()));

        EntityRendererRegistry.register(AtlantisEntityInit.BOMB, SodiumBombRenderer::new);
    }

    public static void init() {
        ParticleProviderRegistry.register(PUSH_BUBBLESTREAM.get(), PushBubbleStreamParticle.Factory::new);
    }

    public static void registerColors() {
        ArrayListMultimap<DyeColor, Supplier<? extends Block>> map = ArrayListMultimap.<DyeColor, Supplier<? extends Block>>create();

        Stream.concat(DYED_LINGUISTICS.values().stream(), Stream.of(COLORED_SHELL_BLOCKS, CRACKED_SHELL_BLOCKS, CRACKED_MOSSY_SHELL_BLOCKS)).forEach(colorMap -> colorMap.forEach((k, v) -> map.put(k, v)));

        GenericColor WHITE = () -> 0xf9fffe;
        map.get(DyeColor.WHITE).forEach(block -> register(WHITE, block));
        GenericColor ORANGE = () -> 0xf9801d;
        map.get(DyeColor.ORANGE).forEach(block -> register(ORANGE, block));
        GenericColor MAGENTA = () -> 0xc74ebd;
        map.get(DyeColor.MAGENTA).forEach(block -> register(MAGENTA, block));
        GenericColor LIGHT_BLUE = () -> 0x3ab3da;
        map.get(DyeColor.LIGHT_BLUE).forEach(block -> register(LIGHT_BLUE, block));
        GenericColor YELLOW = () -> 0xfed83d;
        map.get(DyeColor.YELLOW).forEach(block -> register(YELLOW, block));
        GenericColor LIME = () -> 0x80c71f;
        map.get(DyeColor.LIME).forEach(block -> register(LIME, block));
        GenericColor PINK = () -> 0xf38baa;
        map.get(DyeColor.PINK).forEach(block -> register(PINK, block));
        GenericColor GRAY = () -> 0x474f52;
        map.get(DyeColor.GRAY).forEach(block -> register(GRAY, block));
        GenericColor LIGHT_GRAY = () -> 0x9d9d97;
        map.get(DyeColor.LIGHT_GRAY).forEach(block -> register(LIGHT_GRAY, block));
        GenericColor CYAN = () -> 0x169c9c;
        map.get(DyeColor.CYAN).forEach(block -> register(CYAN, block));
        GenericColor PURPLE = () -> 0x8932b8;
        map.get(DyeColor.PURPLE).forEach(block -> register(PURPLE, block));
        GenericColor BLUE = () -> 0x3c44aa;
        map.get(DyeColor.BLUE).forEach(block -> register(BLUE, block));
        GenericColor BROWN = () -> 0x835432;
        map.get(DyeColor.BROWN).forEach(block -> register(BROWN, block));
        GenericColor GREEN = () -> 0x5e7c16;
        map.get(DyeColor.GREEN).forEach(block -> register(GREEN, block));
        GenericColor RED = () -> 0xb02e26;
        map.get(DyeColor.RED).forEach(block -> register(RED, block));
        GenericColor BLACK = () -> 0x1d1d21;
        map.get(DyeColor.BLACK).forEach(block -> register(BLACK, block));

        GenericColor REGULAR = () -> 0x8caed2;
        NON_LINGUISTICS.values().forEach(block -> register(REGULAR, block));
    }

    public static void register(GenericColor color, Supplier<? extends Block> supplier) {
        ColorHandlerRegistry.registerItemColors(color, supplier);
        ColorHandlerRegistry.registerBlockColors(color, supplier);
    }

    public interface GenericColor extends ItemColor, BlockColor {
        @Override
        default int getColor(BlockState blockState, @Nullable BlockAndTintGetter blockAndTintGetter, @Nullable BlockPos blockPos, int i) {
            return getColor();
        }

        @Override
        default int getColor(ItemStack itemStack, int i) {
            return getColor();
        }

        int getColor();
    }
}
