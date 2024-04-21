package com.mystic.atlantis.init;

import com.mystic.atlantis.blocks.blockentities.AtlantisPortalBlockEntity;
import com.mystic.atlantis.blocks.blockentities.DummyDataStorage;
import com.mystic.atlantis.blocks.blockentities.plants.BlueLilyTileEntity;
import com.mystic.atlantis.blocks.blockentities.plants.BurntDeepTileEntity;
import com.mystic.atlantis.blocks.blockentities.plants.EnenmomyTileEntity;
import com.mystic.atlantis.blocks.blockentities.plants.TuberUpTileEntity;
import com.mystic.atlantis.blocks.blockentities.plants.UnderwaterShroomTileEntity;
import com.mystic.atlantis.util.Reference;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;


public class TileEntityInit {
	public static final DeferredRegister<BlockEntityType<?>> TILE_ENTITIES = DeferredRegister
			.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, Reference.MODID);

	public static final Supplier<BlockEntityType<UnderwaterShroomTileEntity>> UNDERWATER_SHROOM_TILE = TILE_ENTITIES.register("underwater_shroom", () -> BlockEntityType.Builder.of(UnderwaterShroomTileEntity::new, BlockInit.UNDERWATER_SHROOM_BLOCK.get()).build(null));
	public static final Supplier<BlockEntityType<TuberUpTileEntity>> TUBER_UP_TILE = TILE_ENTITIES.register("tuber_up", () -> BlockEntityType.Builder.of(TuberUpTileEntity::new, BlockInit.TUBER_UP_BLOCK.get()).build(null));
	public static final Supplier<BlockEntityType<BlueLilyTileEntity>> BLUE_LILY_TILE = TILE_ENTITIES.register("blue_lily", () -> BlockEntityType.Builder.of(BlueLilyTileEntity::new, BlockInit.BLUE_LILY_BLOCK.get()).build(null));
	public static final Supplier<BlockEntityType<BurntDeepTileEntity>> BURNT_DEEP_TILE = TILE_ENTITIES.register("burnt_deep", () -> BlockEntityType.Builder.of(BurntDeepTileEntity::new, BlockInit.BURNT_DEEP_BLOCK.get()).build(null));
	public static final Supplier<BlockEntityType<EnenmomyTileEntity>> ENENMOMY_TILE = TILE_ENTITIES.register("enenmomy", () -> BlockEntityType.Builder.of(EnenmomyTileEntity::new, BlockInit.ENENMOMY_BLOCK.get()).build(null));
	public static final Supplier<BlockEntityType<AtlantisPortalBlockEntity>> ATLANTIS_PORTAL = TILE_ENTITIES.register("atlantis_portal", () -> BlockEntityType.Builder.of(AtlantisPortalBlockEntity::new, BlockInit.ATLANTIS_CLEAR_PORTAL.get()).build(null));
	public static final Supplier<BlockEntityType<DummyDataStorage>> DUMMY_DATA_STORAGE = TILE_ENTITIES.register("dummydatastorage", () -> BlockEntityType.Builder.of(DummyDataStorage::new, BlockInit.ATLANTIS_PORTAL.get()).build(null));
	public static void init(IEventBus bus) {
		TILE_ENTITIES.register(bus);
	}

}
