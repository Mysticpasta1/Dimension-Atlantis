package com.mystic.atlantis.setup;

import com.google.common.collect.ArrayListMultimap;
import com.mystic.atlantis.AtlantisDimensionalEffect;
import com.mystic.atlantis.blocks.BlockType;
import com.mystic.atlantis.blocks.ancient_metal.TrailsGroup;
import com.mystic.atlantis.blocks.blockentities.plants.GeneralPlantBlockEntity;
import com.mystic.atlantis.blocks.blockentities.renderers.*;
import com.mystic.atlantis.dimension.DimensionAtlantis;
import com.mystic.atlantis.entities.models.*;
import com.mystic.atlantis.entities.renders.*;
import com.mystic.atlantis.init.*;
import com.mystic.atlantis.particles.*;
import com.mystic.atlantis.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.util.FastColor;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.client.event.RegisterDimensionSpecialEffectsEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.RegistryObject;

import java.util.Map;
import java.util.stream.Stream;

import static com.mystic.atlantis.init.BlockInit.*;
import static com.mystic.atlantis.init.BlockInit.ANEMONE_BLOCK;

@Mod.EventBusSubscriber(modid = Reference.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup {
    @SubscribeEvent
    public static void onInitializeClient(FMLClientSetupEvent event) {

        ItemBlockRenderTypes.setRenderLayer(FluidInit.JETSTREAM_WATER.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(FluidInit.FLOWING_JETSTREAM_WATER.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(FluidInit.SALTY_SEA_WATER.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(FluidInit.FLOWING_SALTY_SEA_WATER.get(), RenderType.translucent());

        //ItemBlockRenderTypes.setRenderLayer(FluidInit.COCONUT_MILK.get(), RenderType.translucent());
        //ItemBlockRenderTypes.setRenderLayer(FluidInit.FLOWING_COCONUT_MILK.get(), RenderType.translucent());

        registerPlantRenderer(TileEntityInit.UNDERWATER_SHROOM_TILE, "underwater_shroom");

        registerPlantRenderer(TileEntityInit.TUBER_UP_TILE, "tuber_up");

        registerPlantRenderer(TileEntityInit.BLUE_LILY_TILE, "blue_lily");

        registerPlantRenderer(TileEntityInit.BURNT_DEEP_TILE, "burnt_deep");

        registerPlantRenderer(TileEntityInit.ANEMONE_TILE, "anemone");

        for (DyeColor dyeColor : DyeColor.values()) {
            registerBlockRenderLayers(RenderType.cutoutMipped(),
                    MOSSY_SHELL_BLOCKS.get(dyeColor).get(),
                    CRACKED_MOSSY_SHELL_BLOCKS.get(dyeColor).get());
        }

        for(TrailsGroup group : ANCIENT_METALS.values()) {
            registerBlockRenderLayers(RenderType.cutoutMipped(), group.grate().get(), group.waxed_grate().get());
        }

        for (DyeColor dyeColor : DyeColor.values()) {
            registerBlockRenderLayers(RenderType.cutoutMipped(),
                    MOSSY_SHELL_BLOCKS.get(dyeColor).get(),
                    CRACKED_MOSSY_SHELL_BLOCKS.get(dyeColor).get());
        }

        for (TrailsGroup group : ANCIENT_METALS.values()) {
            registerBlockRenderLayers(RenderType.cutoutMipped(),
                    group.grate().get());
        }

        for (BlockType seaGlass : SEA_GLASS_LIST.values()) {
            registerBlockRenderLayers(RenderType.translucent(),
                    seaGlass.block().get(),
                    seaGlass.button().get(),
                    seaGlass.wall().get(),
                    seaGlass.slab().get(),
                    seaGlass.pressurePlate().get(),
                    seaGlass.stairs().get());
        }

        for (BlockType seaGlass : SEA_GLASS_PATTERNS.values()) {
            registerBlockRenderLayers(RenderType.translucent(),
                    seaGlass.block().get(),
                    seaGlass.button().get(),
                    seaGlass.wall().get(),
                    seaGlass.slab().get(),
                    seaGlass.pressurePlate().get(),
                    seaGlass.stairs().get());
        }

        registerBlockRenderLayers(RenderType.cutout(),
                BLUE_LILY_BLOCK.get(),
                BURNT_DEEP_BLOCK.get(),
                ANEMONE_BLOCK.get(),
                TUBER_UP_BLOCK.get(),
                UNDERWATER_SHROOM_BLOCK.get(),
                ATLANTEAN_FIRE_MELON_FRUIT.get(),
                ATLANTEAN_FIRE_MELON_FRUIT_SPIKED.get(),
                ATLANTEAN_FIRE_MELON_STEM.get(),
                ATLANTEAN_FIRE_MELON_TOP.get(),
                ATLANTEAN_DOOR.get(),
                ATLANTEAN_TRAPDOOR.get(),
                ATLANTEAN_SAPLING.get(),
                ATLANTEAN_PALM_SAPLING.get(),
                UNDERWATER_FLOWER.get(),
                ALGAE.get(),
                ATLANTEAN_POWER_TORCH.get(),
                WALL_ATLANTEAN_POWER_TORCH.get(),
                ATLANTEAN_POWER_DUST_WIRE.get(),
                ATLANTEAN_POWER_REPEATER.get(),
                ATLANTEAN_TRIPWIRE.get(),
                ATLANTEAN_TRIPWIRE_HOOK.get(),
                YELLOW_UNDERWATER_FLOWER.get(),
                RED_UNDERWATER_FLOWER.get(),
                ATLANTEAN_POWER_COMPARATOR.get(),
                ANCIENT_ACACIA_WOOD_MOSS_DOOR.get(),
                ANCIENT_BIRCH_WOOD_MOSS_DOOR.get(),
                ANCIENT_DARK_OAK_WOOD_MOSS_DOOR.get(),
                ANCIENT_JUNGLE_WOOD_MOSS_DOOR.get(),
                ANCIENT_OAK_WOOD_MOSS_DOOR.get(),
                ANCIENT_SPRUCE_WOOD_MOSS_DOOR.get(),
                ANCIENT_ACACIA_WOOD_MOSS_TRAPDOOR.get(),
                ANCIENT_BIRCH_WOOD_MOSS_TRAPDOOR.get(),
                ANCIENT_DARK_OAK_WOOD_MOSS_TRAPDOOR.get(),
                ANCIENT_JUNGLE_WOOD_MOSS_TRAPDOOR.get(),
                ANCIENT_OAK_WOOD_MOSS_TRAPDOOR.get(),
                ANCIENT_SPRUCE_WOOD_MOSS_TRAPDOOR.get(),
                PURPLE_GLOWING_MUSHROOM.get(),
                YELLOW_GLOWING_MUSHROOM.get());
        registerBlockRenderLayers(RenderType.translucent(),
                BLACK_PEARL_BLOCK.get(),
                GRAY_PEARL_BLOCK.get(),
                WHITE_PEARL_BLOCK.get(),
                LIGHT_GRAY_PEARL_BLOCK.get(),
                BLUE_PEARL_BLOCK.get(),
                LIGHT_BLUE_PEARL_BLOCK.get(),
                RED_PEARL_BLOCK.get(),
                ORANGE_PEARL_BLOCK.get(),
                PINK_PEARL_BLOCK.get(),
                YELLOW_PEARL_BLOCK.get(),
                GREEN_PEARL_BLOCK.get(),
                LIME_PEARL_BLOCK.get(),
                PURPLE_PEARL_BLOCK.get(),
                MAGENTA_PEARL_BLOCK.get(),
                CYAN_PEARL_BLOCK.get(),
                BROWN_PEARL_BLOCK.get(),
                ATLANTIS_CLEAR_PORTAL.get());
        registerBlockRenderLayers(RenderType.cutoutMipped(),
                PALM_LEAVES.get(),
                ATLANTEAN_LEAVES.get());
    }

    private static <T extends GeneralPlantBlockEntity<T>> void registerPlantRenderer(RegistryObject<BlockEntityType<T>> registryObject, String name) {
        BlockEntityRenderers.register(registryObject.get(), pContext -> new GeneralPlantRenderer<T>(name));
    }

    @SubscribeEvent
    public static void registerDimensionEffect(RegisterDimensionSpecialEffectsEvent event) {
        event.register(DimensionAtlantis.ATLANTIS_DIMENSION_EFFECT, AtlantisDimensionalEffect.INSTANCE);
    }

    @SubscribeEvent
    public static void entityRegisterEvent(EntityRenderersEvent.RegisterRenderers bus) {
        bus.registerEntityRenderer(AtlantisEntityInit.CRAB.get(), entityRenderDispatcher -> new CrabEntityRenderer(entityRenderDispatcher, new CrabEntityModel()));
        bus.registerEntityRenderer(AtlantisEntityInit.COCONUT_CRAB.get(), entityRenderDispatcher -> new CoconutCrabEntityRenderer(entityRenderDispatcher, new CoconutCrabEntityModel()));
        bus.registerEntityRenderer(AtlantisEntityInit.JELLYFISH.get(), entityRenderDispatcher -> new JellyfishEntityRenderer(entityRenderDispatcher, new JellyfishEntityModel()));
        bus.registerEntityRenderer(AtlantisEntityInit.SHRIMP.get(), entityRenderDispatcher -> new ShrimpEntityRenderer(entityRenderDispatcher, new ShrimpEntityModel()));
        bus.registerEntityRenderer(AtlantisEntityInit.SUBMARINE.get(), SubmarineEntityRenderer::new);
        bus.registerEntityRenderer(AtlantisEntityInit.ATLANTEAN_BOAT.get(), AtlanteanBoatRenderer::new);
        bus.registerEntityRenderer(AtlantisEntityInit.PALM_BOAT.get(), PalmBoatRenderer::new);
        bus.registerEntityRenderer(AtlantisEntityInit.LEVIATHAN.get(), entityRenderDispatcher -> new LeviathanEntityRenderer(entityRenderDispatcher, new LeviathanEntityModel()));
        bus.registerEntityRenderer(AtlantisEntityInit.SEAHORSE.get(), entityRenderDispatcher -> new SeahorseEntityRenderer(entityRenderDispatcher, new SeahorseEntityModel()));
        bus.registerEntityRenderer(AtlantisEntityInit.STARFISH.get(), entityRenderDispatcher -> new StarfishEntityRenderer(entityRenderDispatcher, new StarfishEntityModel()));
        bus.registerEntityRenderer(AtlantisEntityInit.STARFISH_ZOM.get(), entityRenderDispatcher -> new StarfishZomEntityRenderer(entityRenderDispatcher, new StarfishZomEntityModel()));

        bus.registerEntityRenderer(AtlantisEntityInit.BOMB.get(), SodiumBombRenderer::new);
    }

    @SubscribeEvent
    public static void spawnRules(SpawnPlacementRegisterEvent event) {
        event.register(AtlantisEntityInit.STARFISH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR_WG, (pEntityType, pServerLevel, pSpawnType, pPos, pRandom) -> true, SpawnPlacementRegisterEvent.Operation.OR);
        event.register(AtlantisEntityInit.STARFISH_ZOM.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR_WG, (pEntityType, pServerLevel, pSpawnType, pPos, pRandom) -> true, SpawnPlacementRegisterEvent.Operation.OR);
        event.register(AtlantisEntityInit.SEAHORSE.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR_WG, (pEntityType, pServerLevel, pSpawnType, pPos, pRandom) -> true, SpawnPlacementRegisterEvent.Operation.OR);
    }

    @SubscribeEvent
    public static void init(RegisterParticleProvidersEvent bus) {
        Minecraft.getInstance().particleEngine.register(ModParticleTypes.PUSH_BUBBLESTREAM_UP.get(), PushBubbleStreamParticleUp.Factory::new);
        Minecraft.getInstance().particleEngine.register(ModParticleTypes.PUSH_BUBBLESTREAM_DOWN.get(), PushBubbleStreamParticleDown.Factory::new);
        Minecraft.getInstance().particleEngine.register(ModParticleTypes.PUSH_BUBBLESTREAM_NORTH.get(), PushBubbleStreamParticleNorth.Factory::new);
        Minecraft.getInstance().particleEngine.register(ModParticleTypes.PUSH_BUBBLESTREAM_SOUTH.get(), PushBubbleStreamParticleSouth.Factory::new);
        Minecraft.getInstance().particleEngine.register(ModParticleTypes.PUSH_BUBBLESTREAM_EAST.get(), PushBubbleStreamParticleEast.Factory::new);
        Minecraft.getInstance().particleEngine.register(ModParticleTypes.PUSH_BUBBLESTREAM_WEST.get(), PushBubbleStreamParticleWest.Factory::new);
    }

    private static void registerBlockRenderLayers(RenderType layer, Block... blocks) {
        Stream.of(blocks).forEach(block -> ItemBlockRenderTypes.setRenderLayer(block, layer));
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void registerBlockColor(RegisterColorHandlersEvent.Block event) {
        ArrayListMultimap<DyeColor, Block> mapLinguistic = ArrayListMultimap.create();

        for(Map<DyeColor, RegistryObject<Block>> colorMapLinguistics : DYED_LINGUISTICS.values()) {
            colorMapLinguistics.forEach((k,v) -> mapLinguistic.put(k, v.get()));
        }

        BlockColors blockColors = event.getBlockColors();

        BlockColor WHITE = (arg, arg2, arg3, i) -> 0xf9fffe;
        BlockColor ORANGE = (arg, arg2, arg3, i) -> 0xf9801d;
        BlockColor MAGENTA = (arg, arg2, arg3, i) -> 0xc74ebd;
        BlockColor LIGHT_BLUE = (arg, arg2, arg3, i) -> 0x3ab3da;
        BlockColor YELLOW = (arg, arg2, arg3, i) -> 0xfed83d;
        BlockColor LIME = (arg, arg2, arg3, i) -> 0x80c71f;
        BlockColor PINK = (arg, arg2, arg3, i) -> 0xf38baa;
        BlockColor GRAY = (arg, arg2, arg3, i) -> 0x474f52;
        BlockColor LIGHT_GRAY = (arg, arg2, arg3, i) -> 0x9d9d97;
        BlockColor CYAN = (arg, arg2, arg3, i) -> 0x169c9c;
        BlockColor PURPLE = (arg, arg2, arg3, i) -> 0x8932b8;
        BlockColor BLUE = (arg, arg2, arg3, i) -> 0x3c44aa;
        BlockColor BROWN = (arg, arg2, arg3, i) -> 0x835432;
        BlockColor GREEN = (arg, arg2, arg3, i) -> 0x5e7c16;
        BlockColor RED = (arg, arg2, arg3, i) -> 0xb02e26;
        BlockColor BLACK = (arg, arg2, arg3, i) -> 0x1d1d21;

        mapLinguistic.get(DyeColor.WHITE).forEach(block -> blockColors.register(WHITE, block));
        mapLinguistic.get(DyeColor.ORANGE).forEach(block -> blockColors.register(ORANGE, block));
        mapLinguistic.get(DyeColor.MAGENTA).forEach(block -> blockColors.register(MAGENTA, block));
        mapLinguistic.get(DyeColor.LIGHT_BLUE).forEach(block -> blockColors.register(LIGHT_BLUE, block));
        mapLinguistic.get(DyeColor.YELLOW).forEach(block -> blockColors.register(YELLOW, block));
        mapLinguistic.get(DyeColor.LIME).forEach(block -> blockColors.register(LIME, block));
        mapLinguistic.get(DyeColor.PINK).forEach(block -> blockColors.register(PINK, block));
        mapLinguistic.get(DyeColor.GRAY).forEach(block -> blockColors.register(GRAY, block));
        mapLinguistic.get(DyeColor.LIGHT_GRAY).forEach(block -> blockColors.register(LIGHT_GRAY, block));
        mapLinguistic.get(DyeColor.CYAN).forEach(block -> blockColors.register(CYAN, block));
        mapLinguistic.get(DyeColor.PURPLE).forEach(block -> blockColors.register(PURPLE, block));
        mapLinguistic.get(DyeColor.BLUE).forEach(block -> blockColors.register(BLUE, block));
        mapLinguistic.get(DyeColor.BROWN).forEach(block -> blockColors.register(BROWN, block));
        mapLinguistic.get(DyeColor.GREEN).forEach(block -> blockColors.register(GREEN, block));
        mapLinguistic.get(DyeColor.RED).forEach(block -> blockColors.register(RED, block));
        mapLinguistic.get(DyeColor.BLACK).forEach(block -> blockColors.register(BLACK, block));

        blockColors.register(WHITE, COLORED_SHELL_BLOCKS.get(DyeColor.WHITE).get());
        blockColors.register(ORANGE, COLORED_SHELL_BLOCKS.get(DyeColor.ORANGE).get());
        blockColors.register(MAGENTA, COLORED_SHELL_BLOCKS.get(DyeColor.MAGENTA).get());
        blockColors.register(LIGHT_BLUE, COLORED_SHELL_BLOCKS.get(DyeColor.LIGHT_BLUE).get());
        blockColors.register(YELLOW, COLORED_SHELL_BLOCKS.get(DyeColor.YELLOW).get());
        blockColors.register(LIME, COLORED_SHELL_BLOCKS.get(DyeColor.LIME).get());
        blockColors.register(PINK, COLORED_SHELL_BLOCKS.get(DyeColor.PINK).get());
        blockColors.register(GRAY, COLORED_SHELL_BLOCKS.get(DyeColor.GRAY).get());
        blockColors.register(LIGHT_GRAY, COLORED_SHELL_BLOCKS.get(DyeColor.LIGHT_GRAY).get());
        blockColors.register(CYAN, COLORED_SHELL_BLOCKS.get(DyeColor.CYAN).get());
        blockColors.register(PURPLE, COLORED_SHELL_BLOCKS.get(DyeColor.PURPLE).get());
        blockColors.register(BLUE, COLORED_SHELL_BLOCKS.get(DyeColor.BLUE).get());
        blockColors.register(BROWN, COLORED_SHELL_BLOCKS.get(DyeColor.BROWN).get());
        blockColors.register(GREEN, COLORED_SHELL_BLOCKS.get(DyeColor.GREEN).get());
        blockColors.register(RED, COLORED_SHELL_BLOCKS.get(DyeColor.RED).get());
        blockColors.register(BLACK, COLORED_SHELL_BLOCKS.get(DyeColor.BLACK).get());


        blockColors.register(WHITE, CRACKED_SHELL_BLOCKS.get(DyeColor.WHITE).get());
        blockColors.register(ORANGE, CRACKED_SHELL_BLOCKS.get(DyeColor.ORANGE).get());
        blockColors.register(MAGENTA, CRACKED_SHELL_BLOCKS.get(DyeColor.MAGENTA).get());
        blockColors.register(LIGHT_BLUE, CRACKED_SHELL_BLOCKS.get(DyeColor.LIGHT_BLUE).get());
        blockColors.register(YELLOW, CRACKED_SHELL_BLOCKS.get(DyeColor.YELLOW).get());
        blockColors.register(LIME, CRACKED_SHELL_BLOCKS.get(DyeColor.LIME).get());
        blockColors.register(PINK, CRACKED_SHELL_BLOCKS.get(DyeColor.PINK).get());
        blockColors.register(GRAY, CRACKED_SHELL_BLOCKS.get(DyeColor.GRAY).get());
        blockColors.register(LIGHT_GRAY, CRACKED_SHELL_BLOCKS.get(DyeColor.LIGHT_GRAY).get());
        blockColors.register(CYAN, CRACKED_SHELL_BLOCKS.get(DyeColor.CYAN).get());
        blockColors.register(PURPLE, CRACKED_SHELL_BLOCKS.get(DyeColor.PURPLE).get());
        blockColors.register(BLUE, CRACKED_SHELL_BLOCKS.get(DyeColor.BLUE).get());
        blockColors.register(BROWN, CRACKED_SHELL_BLOCKS.get(DyeColor.BROWN).get());
        blockColors.register(GREEN, CRACKED_SHELL_BLOCKS.get(DyeColor.GREEN).get());
        blockColors.register(RED, CRACKED_SHELL_BLOCKS.get(DyeColor.RED).get());
        blockColors.register(BLACK, CRACKED_SHELL_BLOCKS.get(DyeColor.BLACK).get());

        blockColors.register(WHITE, CRACKED_MOSSY_SHELL_BLOCKS.get(DyeColor.WHITE).get());
        blockColors.register(ORANGE, CRACKED_MOSSY_SHELL_BLOCKS.get(DyeColor.ORANGE).get());
        blockColors.register(MAGENTA, CRACKED_MOSSY_SHELL_BLOCKS.get(DyeColor.MAGENTA).get());
        blockColors.register(LIGHT_BLUE, CRACKED_MOSSY_SHELL_BLOCKS.get(DyeColor.LIGHT_BLUE).get());
        blockColors.register(YELLOW, CRACKED_MOSSY_SHELL_BLOCKS.get(DyeColor.YELLOW).get());
        blockColors.register(LIME, CRACKED_MOSSY_SHELL_BLOCKS.get(DyeColor.LIME).get());
        blockColors.register(PINK, CRACKED_MOSSY_SHELL_BLOCKS.get(DyeColor.PINK).get());
        blockColors.register(GRAY, CRACKED_MOSSY_SHELL_BLOCKS.get(DyeColor.GRAY).get());
        blockColors.register(LIGHT_GRAY, CRACKED_MOSSY_SHELL_BLOCKS.get(DyeColor.LIGHT_GRAY).get());
        blockColors.register(CYAN, CRACKED_MOSSY_SHELL_BLOCKS.get(DyeColor.CYAN).get());
        blockColors.register(PURPLE, CRACKED_MOSSY_SHELL_BLOCKS.get(DyeColor.PURPLE).get());
        blockColors.register(BLUE, CRACKED_MOSSY_SHELL_BLOCKS.get(DyeColor.BLUE).get());
        blockColors.register(BROWN, CRACKED_MOSSY_SHELL_BLOCKS.get(DyeColor.BROWN).get());
        blockColors.register(GREEN, CRACKED_MOSSY_SHELL_BLOCKS.get(DyeColor.GREEN).get());
        blockColors.register(RED, CRACKED_MOSSY_SHELL_BLOCKS.get(DyeColor.RED).get());
        blockColors.register(BLACK, CRACKED_MOSSY_SHELL_BLOCKS.get(DyeColor.BLACK).get());

        blockColors.register(WHITE, MOSSY_SHELL_BLOCKS.get(DyeColor.WHITE).get());
        blockColors.register(ORANGE, MOSSY_SHELL_BLOCKS.get(DyeColor.ORANGE).get());
        blockColors.register(MAGENTA, MOSSY_SHELL_BLOCKS.get(DyeColor.MAGENTA).get());
        blockColors.register(LIGHT_BLUE, MOSSY_SHELL_BLOCKS.get(DyeColor.LIGHT_BLUE).get());
        blockColors.register(YELLOW, MOSSY_SHELL_BLOCKS.get(DyeColor.YELLOW).get());
        blockColors.register(LIME, MOSSY_SHELL_BLOCKS.get(DyeColor.LIME).get());
        blockColors.register(PINK, MOSSY_SHELL_BLOCKS.get(DyeColor.PINK).get());
        blockColors.register(GRAY, MOSSY_SHELL_BLOCKS.get(DyeColor.GRAY).get());
        blockColors.register(LIGHT_GRAY, MOSSY_SHELL_BLOCKS.get(DyeColor.LIGHT_GRAY).get());
        blockColors.register(CYAN, MOSSY_SHELL_BLOCKS.get(DyeColor.CYAN).get());
        blockColors.register(PURPLE, MOSSY_SHELL_BLOCKS.get(DyeColor.PURPLE).get());
        blockColors.register(BLUE, MOSSY_SHELL_BLOCKS.get(DyeColor.BLUE).get());
        blockColors.register(BROWN, MOSSY_SHELL_BLOCKS.get(DyeColor.BROWN).get());
        blockColors.register(GREEN, MOSSY_SHELL_BLOCKS.get(DyeColor.GREEN).get());
        blockColors.register(RED, MOSSY_SHELL_BLOCKS.get(DyeColor.RED).get());
        blockColors.register(BLACK, MOSSY_SHELL_BLOCKS.get(DyeColor.BLACK).get());


        BlockColor REGULAR = (arg, arg2, arg3, i) -> 0x8caed2; NON_LINGUISTICS.values().stream().map(RegistryObject::get).forEach(block -> blockColors.register(REGULAR, block));

        BlockColor JetstreamWaterColor = (arg, arg2, arg3, i) -> FastColor.ARGB32.color(255, 169, 255, 208);
        blockColors.register(JetstreamWaterColor, BlockInit.JETSTREAM_WATER_BLOCK.get());

        BlockColor SaltySeaWaterColor = (arg, arg2, arg3, i) -> FastColor.ARGB32.color(255, 10, 96, 208);
        blockColors.register(SaltySeaWaterColor, BlockInit.SALTY_SEA_WATER_BLOCK.get());

        //BlockColor CoconutMilkColor = (arg, arg2, arg3, i) -> 0xFFFFFFFF;
        //blockColors.register(CoconutMilkColor, BlockInit.COCONUT_MILK.get());
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void registerItemColor(RegisterColorHandlersEvent.Item event) {
        ArrayListMultimap<DyeColor, Block> map = ArrayListMultimap.<DyeColor, Block>create();

        for(Map<DyeColor, RegistryObject<Block>> colorMap : DYED_LINGUISTICS.values()) {
            colorMap.forEach((k,v) -> map.put(k, v.get()));
        }

        ItemColors blockColors = event.getItemColors();

        ItemColor WHITE = (arg, i) -> 0xf9fffe;
        map.get(DyeColor.WHITE).forEach(block -> blockColors.register(WHITE, block));
        ItemColor ORANGE = (arg, i) -> 0xf9801d;
        map.get(DyeColor.ORANGE).forEach(block -> blockColors.register(ORANGE, block));
        ItemColor MAGENTA = (arg, i) -> 0xc74ebd;
        map.get(DyeColor.MAGENTA).forEach(block -> blockColors.register(MAGENTA, block));
        ItemColor LIGHT_BLUE = (arg, i) -> 0x3ab3da;
        map.get(DyeColor.LIGHT_BLUE).forEach(block -> blockColors.register(LIGHT_BLUE, block));
        ItemColor YELLOW = (arg, i) -> 0xfed83d;
        map.get(DyeColor.YELLOW).forEach(block -> blockColors.register(YELLOW, block));
        ItemColor LIME = (arg, i) -> 0x80c71f;
        map.get(DyeColor.LIME).forEach(block -> blockColors.register(LIME, block));
        ItemColor PINK = (arg, i) -> 0xf38baa;
        map.get(DyeColor.PINK).forEach(block -> blockColors.register(PINK, block));
        ItemColor GRAY = (arg, i) -> 0x474f52;
        map.get(DyeColor.GRAY).forEach(block -> blockColors.register(GRAY, block));
        ItemColor LIGHT_GRAY = (arg, i) -> 0x9d9d97;
        map.get(DyeColor.LIGHT_GRAY).forEach(block -> blockColors.register(LIGHT_GRAY, block));
        ItemColor CYAN = (arg, i) -> 0x169c9c;
        map.get(DyeColor.CYAN).forEach(block -> blockColors.register(CYAN, block));
        ItemColor PURPLE = (arg, i) -> 0x8932b8;
        map.get(DyeColor.PURPLE).forEach(block -> blockColors.register(PURPLE, block));
        ItemColor BLUE = (arg, i) -> 0x3c44aa;
        map.get(DyeColor.BLUE).forEach(block -> blockColors.register(BLUE, block));
        ItemColor BROWN = (arg, i) -> 0x835432;
        map.get(DyeColor.BROWN).forEach(block -> blockColors.register(BROWN, block));
        ItemColor GREEN = (arg, i) -> 0x5e7c16;
        map.get(DyeColor.GREEN).forEach(block -> blockColors.register(GREEN, block));
        ItemColor RED = (arg, i) -> 0xb02e26;
        map.get(DyeColor.RED).forEach(block -> blockColors.register(RED, block));
        ItemColor BLACK = (arg, i) -> 0x1d1d21;
        map.get(DyeColor.BLACK).forEach(block -> blockColors.register(BLACK, block));

        blockColors.register(WHITE, COLORED_SHELL_BLOCKS.get(DyeColor.WHITE).get());
        blockColors.register(ORANGE, COLORED_SHELL_BLOCKS.get(DyeColor.ORANGE).get());
        blockColors.register(MAGENTA, COLORED_SHELL_BLOCKS.get(DyeColor.MAGENTA).get());
        blockColors.register(LIGHT_BLUE, COLORED_SHELL_BLOCKS.get(DyeColor.LIGHT_BLUE).get());
        blockColors.register(YELLOW, COLORED_SHELL_BLOCKS.get(DyeColor.YELLOW).get());
        blockColors.register(LIME, COLORED_SHELL_BLOCKS.get(DyeColor.LIME).get());
        blockColors.register(PINK, COLORED_SHELL_BLOCKS.get(DyeColor.PINK).get());
        blockColors.register(GRAY, COLORED_SHELL_BLOCKS.get(DyeColor.GRAY).get());
        blockColors.register(LIGHT_GRAY, COLORED_SHELL_BLOCKS.get(DyeColor.LIGHT_GRAY).get());
        blockColors.register(CYAN, COLORED_SHELL_BLOCKS.get(DyeColor.CYAN).get());
        blockColors.register(PURPLE, COLORED_SHELL_BLOCKS.get(DyeColor.PURPLE).get());
        blockColors.register(BLUE, COLORED_SHELL_BLOCKS.get(DyeColor.BLUE).get());
        blockColors.register(BROWN, COLORED_SHELL_BLOCKS.get(DyeColor.BROWN).get());
        blockColors.register(GREEN, COLORED_SHELL_BLOCKS.get(DyeColor.GREEN).get());
        blockColors.register(RED, COLORED_SHELL_BLOCKS.get(DyeColor.RED).get());
        blockColors.register(BLACK, COLORED_SHELL_BLOCKS.get(DyeColor.BLACK).get());


        blockColors.register(WHITE, CRACKED_SHELL_BLOCKS.get(DyeColor.WHITE).get());
        blockColors.register(ORANGE, CRACKED_SHELL_BLOCKS.get(DyeColor.ORANGE).get());
        blockColors.register(MAGENTA, CRACKED_SHELL_BLOCKS.get(DyeColor.MAGENTA).get());
        blockColors.register(LIGHT_BLUE, CRACKED_SHELL_BLOCKS.get(DyeColor.LIGHT_BLUE).get());
        blockColors.register(YELLOW, CRACKED_SHELL_BLOCKS.get(DyeColor.YELLOW).get());
        blockColors.register(LIME, CRACKED_SHELL_BLOCKS.get(DyeColor.LIME).get());
        blockColors.register(PINK, CRACKED_SHELL_BLOCKS.get(DyeColor.PINK).get());
        blockColors.register(GRAY, CRACKED_SHELL_BLOCKS.get(DyeColor.GRAY).get());
        blockColors.register(LIGHT_GRAY, CRACKED_SHELL_BLOCKS.get(DyeColor.LIGHT_GRAY).get());
        blockColors.register(CYAN, CRACKED_SHELL_BLOCKS.get(DyeColor.CYAN).get());
        blockColors.register(PURPLE, CRACKED_SHELL_BLOCKS.get(DyeColor.PURPLE).get());
        blockColors.register(BLUE, CRACKED_SHELL_BLOCKS.get(DyeColor.BLUE).get());
        blockColors.register(BROWN, CRACKED_SHELL_BLOCKS.get(DyeColor.BROWN).get());
        blockColors.register(GREEN, CRACKED_SHELL_BLOCKS.get(DyeColor.GREEN).get());
        blockColors.register(RED, CRACKED_SHELL_BLOCKS.get(DyeColor.RED).get());
        blockColors.register(BLACK, CRACKED_SHELL_BLOCKS.get(DyeColor.BLACK).get());

        blockColors.register(WHITE, CRACKED_MOSSY_SHELL_BLOCKS.get(DyeColor.WHITE).get());
        blockColors.register(ORANGE, CRACKED_MOSSY_SHELL_BLOCKS.get(DyeColor.ORANGE).get());
        blockColors.register(MAGENTA, CRACKED_MOSSY_SHELL_BLOCKS.get(DyeColor.MAGENTA).get());
        blockColors.register(LIGHT_BLUE, CRACKED_MOSSY_SHELL_BLOCKS.get(DyeColor.LIGHT_BLUE).get());
        blockColors.register(YELLOW, CRACKED_MOSSY_SHELL_BLOCKS.get(DyeColor.YELLOW).get());
        blockColors.register(LIME, CRACKED_MOSSY_SHELL_BLOCKS.get(DyeColor.LIME).get());
        blockColors.register(PINK, CRACKED_MOSSY_SHELL_BLOCKS.get(DyeColor.PINK).get());
        blockColors.register(GRAY, CRACKED_MOSSY_SHELL_BLOCKS.get(DyeColor.GRAY).get());
        blockColors.register(LIGHT_GRAY, CRACKED_MOSSY_SHELL_BLOCKS.get(DyeColor.LIGHT_GRAY).get());
        blockColors.register(CYAN, CRACKED_MOSSY_SHELL_BLOCKS.get(DyeColor.CYAN).get());
        blockColors.register(PURPLE, CRACKED_MOSSY_SHELL_BLOCKS.get(DyeColor.PURPLE).get());
        blockColors.register(BLUE, CRACKED_MOSSY_SHELL_BLOCKS.get(DyeColor.BLUE).get());
        blockColors.register(BROWN, CRACKED_MOSSY_SHELL_BLOCKS.get(DyeColor.BROWN).get());
        blockColors.register(GREEN, CRACKED_MOSSY_SHELL_BLOCKS.get(DyeColor.GREEN).get());
        blockColors.register(RED, CRACKED_MOSSY_SHELL_BLOCKS.get(DyeColor.RED).get());
        blockColors.register(BLACK, CRACKED_MOSSY_SHELL_BLOCKS.get(DyeColor.BLACK).get());

        blockColors.register(WHITE, MOSSY_SHELL_BLOCKS.get(DyeColor.WHITE).get());
        blockColors.register(ORANGE, MOSSY_SHELL_BLOCKS.get(DyeColor.ORANGE).get());
        blockColors.register(MAGENTA, MOSSY_SHELL_BLOCKS.get(DyeColor.MAGENTA).get());
        blockColors.register(LIGHT_BLUE, MOSSY_SHELL_BLOCKS.get(DyeColor.LIGHT_BLUE).get());
        blockColors.register(YELLOW, MOSSY_SHELL_BLOCKS.get(DyeColor.YELLOW).get());
        blockColors.register(LIME, MOSSY_SHELL_BLOCKS.get(DyeColor.LIME).get());
        blockColors.register(PINK, MOSSY_SHELL_BLOCKS.get(DyeColor.PINK).get());
        blockColors.register(GRAY, MOSSY_SHELL_BLOCKS.get(DyeColor.GRAY).get());
        blockColors.register(LIGHT_GRAY, MOSSY_SHELL_BLOCKS.get(DyeColor.LIGHT_GRAY).get());
        blockColors.register(CYAN, MOSSY_SHELL_BLOCKS.get(DyeColor.CYAN).get());
        blockColors.register(PURPLE, MOSSY_SHELL_BLOCKS.get(DyeColor.PURPLE).get());
        blockColors.register(BLUE, MOSSY_SHELL_BLOCKS.get(DyeColor.BLUE).get());
        blockColors.register(BROWN, MOSSY_SHELL_BLOCKS.get(DyeColor.BROWN).get());
        blockColors.register(GREEN, MOSSY_SHELL_BLOCKS.get(DyeColor.GREEN).get());
        blockColors.register(RED, MOSSY_SHELL_BLOCKS.get(DyeColor.RED).get());
        blockColors.register(BLACK, MOSSY_SHELL_BLOCKS.get(DyeColor.BLACK).get());

        ItemColor REGULAR = (arg, i) -> 0x8caed2; NON_LINGUISTICS.values().stream().map(RegistryObject::get).forEach(block -> blockColors.register(REGULAR, block));
    }
}
