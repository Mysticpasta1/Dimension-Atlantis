package com.mystic.atlantis.init;

import com.mystic.atlantis.blocks.BlockType;
import com.mystic.atlantis.blocks.ancient_metal.*;
import com.mystic.atlantis.blocks.ancient_metal.WaterloggedTransparentBlock;
import com.mystic.atlantis.blocks.base.*;
import com.mystic.atlantis.blocks.blockentities.plants.*;
import com.mystic.atlantis.blocks.plants.*;
import com.mystic.atlantis.blocks.power.atlanteanstone.*;
import com.mystic.atlantis.blocks.shells.ColoredShellBlock;
import com.mystic.atlantis.blocks.shells.CrackedShellBlock;
import com.mystic.atlantis.blocks.shells.NautilusShellBlock;
import com.mystic.atlantis.blocks.shells.OysterShellBlock;
import com.mystic.atlantis.blocks.signs.AtlanteanSignBlock;
import com.mystic.atlantis.blocks.signs.AtlanteanWallSignBlock;
import com.mystic.atlantis.blocks.slabs.AncientWoodSlabBlock;
import com.mystic.atlantis.blocks.slabs.AtlanteanWoodSlabBlock;
import com.mystic.atlantis.util.Reference;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(BuiltInRegistries.BLOCK, Reference.MODID);

    public static final Map<LinguisticGlyph, Map<DyeColor, Supplier<Block>>> DYED_LINGUISTICS = new HashMap<>();
    public static final Map<LinguisticGlyph, Supplier<Block>> NON_LINGUISTICS = new HashMap<>();
    public static final Map<DyeColor, Supplier<Block>> COLORED_SHELL_BLOCKS = new HashMap<>();
    public static final Map<DyeColor, Supplier<Block>> CRACKED_SHELL_BLOCKS = new HashMap<>();
    public static final Map<DyeColor, Supplier<Block>> CRACKED_MOSSY_SHELL_BLOCKS = new HashMap<>();
    public static final Map<DyeColor, Supplier<Block>> MOSSY_SHELL_BLOCKS = new HashMap<>();
    public static final Supplier<Block> WATERFALL_BLOCK = registerBlock("waterfall_block", () -> new WaterfallBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<Block> WAVE_BLOCK = registerBlock("wave_block", () -> new WaveBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<Block> CRYSTAL_TRANSFERENCE = registerBlock("crystal_transference_block", () -> new CrystalRedstoneTransferenceBlock(BlockBehaviour.Properties.of()));

    //Portal
    public static final Supplier<Block> ATLANTEAN_PORTAL_FRAME = registerBlock("atlantean_portal_frame", AtlanteanCoreFrame::new);
    public static final Supplier<AtlantisClearPortalBlock> ATLANTIS_CLEAR_PORTAL = registerOnlyBlock("atlantis_clear_portal", () -> new AtlantisClearPortalBlock(BlockBehaviour.Properties.of()));

    //Fluid Blocks
    public static final Supplier<LiquidBlock> JETSTREAM_WATER_BLOCK = BLOCKS.register("jetstream_water",
            () -> new LiquidBlock(FluidInit.JETSTREAM_WATER.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER)));
    public static final Supplier<LiquidBlock> SALTY_SEA_WATER_BLOCK = BLOCKS.register("salty_sea_water",
            () -> new LiquidBlock(FluidInit.SALTY_SEA_WATER.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER)));

    //public static final Supplier<LiquidBlock> COCONUT_MILK = BLOCKS.register("coconut_milk",
    //        () -> new LiquidBlock(FluidInit.COCONUT_MILK, BlockBehaviour.Properties.copy(Blocks.WATER)));

    //Atlantean Wood Type
    public static final WoodType ATLANTEAN = WoodType.register(new WoodType("atlantean", BlockSetType.OAK));
    public static final WoodType PALM = WoodType.register(new WoodType("palm", BlockSetType.OAK));

    //Pottery
    public static final Supplier<Block> POTTERY_BLOCK_1 = registerBlock("pottery_1_off", () -> new AtlanteanPotteryBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT).sound(SoundType.DECORATED_POT)));
    public static final Supplier<Block> POTTERY_BLOCK_2 = registerBlock("pottery_2_off", () -> new AtlanteanPotteryBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT).sound(SoundType.DECORATED_POT)));
    public static final Supplier<Block> POTTERY_BLOCK_3 = registerBlock("pottery_3_off", () -> new AtlanteanPotteryBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT).sound(SoundType.DECORATED_POT)));
    public static final Supplier<Block> POTTERY_BLOCK_4 = registerBlock("pottery_4_off", () -> new AtlanteanPotteryBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT).sound(SoundType.DECORATED_POT)));
    public static final Supplier<Block> POTTERY_BLOCK_5 = registerBlock("pottery_5_off", () -> new AtlanteanPotteryBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT).sound(SoundType.DECORATED_POT)));
    public static final Supplier<Block> POTTERY_BLOCK_6 = registerBlock("pottery_6_off", () -> new AtlanteanPotteryBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT).sound(SoundType.DECORATED_POT)));
    public static final Supplier<Block> POTTERY_BLOCK_7 = registerBlock("pottery_7_off", () -> new AtlanteanPotteryBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT).sound(SoundType.DECORATED_POT)));

    //Coconut stuff
    public static final Supplier<CoconutSlice> COCONUT_SLICE = registerBlock("coconut_slab", () -> new CoconutSlice(BlockBehaviour.Properties.of()));
    public static final Supplier<Coconut> COCONUT = registerBlock("coconut", () -> new Coconut(BlockBehaviour.Properties.of()));
    public static final Supplier<EquipableCarvedCoconut> CARVED_COCONUT = registerBlock("carved_coconut", () -> new EquipableCarvedCoconut(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).strength(1.0F).sound(SoundType.WOOD)));
    public static final Supplier<CarvedCoconut> SATIRE_LANTERN = registerBlock("satire_lantern", () -> new CarvedCoconut(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).strength(1.0F).sound(SoundType.WOOD).lightLevel((p_50870_) -> 15)));

    //Atlantean Palm Wood Variants
    public static final Supplier<PalmLog> PALM_LOG = registerBlock("palm_log", () -> new PalmLog(BlockBehaviour.Properties.of()));
    public static final Supplier<StrippedPalmLog> STRIPPED_PALM_LOG = registerBlock("stripped_palm_log", () -> new StrippedPalmLog(BlockBehaviour.Properties.of()));
    public static final Supplier<PalmWoodBlock> PALM_PLANKS = registerBlock("palm_planks", () -> new PalmWoodBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<AtlanteanButtonBlock> PALM_BUTTON = registerBlock("palm_button", () -> new AtlanteanButtonBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<AtlanteanWoodDoorBlock> PALM_DOOR = registerBlock("palm_door", () -> new AtlanteanWoodDoorBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<AtlanteanWoodFenceBlock> PALM_FENCE = registerBlock("palm_fence", () -> new AtlanteanWoodFenceBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<AtlanteanFenceGateBlock> PALM_FENCE_GATE = registerBlock("palm_fence_gate", () -> new AtlanteanFenceGateBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<AtlanteanPressurePlateBlock> PALM_PRESSURE_PLATE = registerBlock("palm_pressure_plate", () -> new AtlanteanPressurePlateBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<AtlanteanSignBlock> PALM_SIGNS = registerOnlyBlock("palm_sign", () -> new AtlanteanSignBlock(BlockBehaviour.Properties.of(), PALM));
    public static final Supplier<AtlanteanWoodSlabBlock> PALM_SLAB = registerBlock("palm_slab", () -> new AtlanteanWoodSlabBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<AtlanteanWoodStairBlock> PALM_STAIRS = registerBlock("palm_stairs", () -> new AtlanteanWoodStairBlock(BlockInit.PALM_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.of()));
    public static final Supplier<AtlanteanWoodTrapdoorBlock> PALM_TRAPDOOR = registerBlock("palm_trapdoor", () -> new AtlanteanWoodTrapdoorBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<AtlanteanWallSignBlock> PALM_WALL_SIGN = registerOnlyBlock("palm_wall_sign", () -> new AtlanteanWallSignBlock(BlockBehaviour.Properties.of(), PALM));


    //Atlantean Wood Variants
    public static final Supplier<StrippedAtlanteanLog> STRIPPED_ATLANTEAN_LOG = registerBlock("stripped_atlantean_log", () -> new StrippedAtlanteanLog(BlockBehaviour.Properties.of()));
    public static final Supplier<AtlanteanButtonBlock> ATLANTEAN_BUTTON = registerBlock("atlantean_button", () -> new AtlanteanButtonBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<AtlanteanWoodDoorBlock> ATLANTEAN_DOOR = registerBlock("atlantean_door", () -> new AtlanteanWoodDoorBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<AtlanteanWoodFenceBlock> ATLANTEAN_FENCE = registerBlock("atlantean_fence", () -> new AtlanteanWoodFenceBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<AtlanteanFenceGateBlock> ATLANTEAN_FENCE_GATE = registerBlock("atlantean_fence_gate", () -> new AtlanteanFenceGateBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<AtlanteanWoodBlock> ATLANTEAN_PLANKS = registerBlock("atlantean_planks", () -> new AtlanteanWoodBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<AtlanteanPressurePlateBlock> ATLANTEAN_PRESSURE_PLATE = registerBlock("atlantean_pressure_plate", () -> new AtlanteanPressurePlateBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<AtlanteanSignBlock> ATLANTEAN_SIGNS = registerOnlyBlock("atlantean_sign", () -> new AtlanteanSignBlock(BlockBehaviour.Properties.of(), ATLANTEAN));
    public static final Supplier<AtlanteanWoodSlabBlock> ATLANTEAN_SLAB = registerBlock("atlantean_slab", () -> new AtlanteanWoodSlabBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<AtlanteanWoodStairBlock> ATLANTEAN_STAIRS = registerBlock("atlantean_stairs", () -> new AtlanteanWoodStairBlock(BlockInit.ATLANTEAN_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.of()));
    public static final Supplier<AtlanteanWoodTrapdoorBlock> ATLANTEAN_TRAPDOOR = registerBlock("atlantean_trapdoor", () -> new AtlanteanWoodTrapdoorBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<AtlanteanWallSignBlock> ATLANTEAN_WALL_SIGN = registerOnlyBlock("atlantean_wall_sign", () -> new AtlanteanWallSignBlock(BlockBehaviour.Properties.of(), ATLANTEAN));

    //Geckolib blocktypes
    public static final Supplier<UnderwaterShroomBlock> UNDERWATER_SHROOM_BLOCK = registerBlock("underwater_shroom", UnderwaterShroomBlock::new);
    public static final Supplier<TuberUpBlock> TUBER_UP_BLOCK = registerBlock("tuber_up", TuberUpBlock::new);
    public static final Supplier<BlueLilyBlock> BLUE_LILY_BLOCK = registerBlock("blue_lily", BlueLilyBlock::new);
    public static final Supplier<BurntDeepBlock> BURNT_DEEP_BLOCK = registerBlock("burnt_deep", BurntDeepBlock::new);
    public static final Supplier<EnenmomyBlock> ENENMOMY_BLOCK = registerBlock("enenmomy", EnenmomyBlock::new);

    //Trapdoors
    public static final Supplier<AncientWoodTrapdoorBlock> ANCIENT_DARK_OAK_WOOD_MOSS_TRAPDOOR = registerBlock("ancient_dark_oak_wood_moss_trapdoor", () -> new AncientWoodTrapdoorBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<AncientWoodTrapdoorBlock> ANCIENT_BIRCH_WOOD_MOSS_TRAPDOOR = registerBlock("ancient_birch_wood_moss_trapdoor", () -> new AncientWoodTrapdoorBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<AncientWoodTrapdoorBlock> ANCIENT_SPRUCE_WOOD_MOSS_TRAPDOOR = registerBlock("ancient_spruce_wood_moss_trapdoor", () -> new AncientWoodTrapdoorBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<AncientWoodTrapdoorBlock> ANCIENT_JUNGLE_WOOD_MOSS_TRAPDOOR = registerBlock("ancient_jungle_wood_moss_trapdoor", () -> new AncientWoodTrapdoorBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<AncientWoodTrapdoorBlock> ANCIENT_OAK_WOOD_MOSS_TRAPDOOR = registerBlock("ancient_oak_wood_moss_trapdoor", () -> new AncientWoodTrapdoorBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<AncientWoodTrapdoorBlock> ANCIENT_ACACIA_WOOD_MOSS_TRAPDOOR = registerBlock("ancient_acacia_wood_moss_trapdoor", () -> new AncientWoodTrapdoorBlock(BlockBehaviour.Properties.of()));

    //Stairs
    public static final Supplier<AncientWoodStairBlock> ANCIENT_DARK_OAK_WOOD_MOSS_STAIRS = registerBlock("ancient_dark_oak_wood_moss_stairs", () -> new AncientWoodStairBlock(Blocks.DARK_OAK_STAIRS.defaultBlockState(), BlockBehaviour.Properties.of()));
    public static final Supplier<AncientWoodStairBlock> ANCIENT_BIRCH_WOOD_MOSS_STAIRS = registerBlock("ancient_birch_wood_moss_stairs", () -> new AncientWoodStairBlock(Blocks.BIRCH_STAIRS.defaultBlockState(), BlockBehaviour.Properties.of()));
    public static final Supplier<AncientWoodStairBlock> ANCIENT_SPRUCE_WOOD_MOSS_STAIRS = registerBlock("ancient_spruce_wood_moss_stairs", () -> new AncientWoodStairBlock(Blocks.SPRUCE_STAIRS.defaultBlockState(), BlockBehaviour.Properties.of()));
    public static final Supplier<AncientWoodStairBlock> ANCIENT_JUNGLE_WOOD_MOSS_STAIRS = registerBlock("ancient_jungle_wood_moss_stairs", () -> new AncientWoodStairBlock(Blocks.JUNGLE_STAIRS.defaultBlockState(), BlockBehaviour.Properties.of()));
    public static final Supplier<AncientWoodStairBlock> ANCIENT_OAK_WOOD_MOSS_STAIRS = registerBlock("ancient_oak_wood_moss_stairs", () -> new AncientWoodStairBlock(Blocks.OAK_STAIRS.defaultBlockState(), BlockBehaviour.Properties.of()));
    public static final Supplier<AncientWoodStairBlock> ANCIENT_ACACIA_WOOD_MOSS_STAIRS = registerBlock("ancient_acacia_wood_moss_stairs", () -> new AncientWoodStairBlock(Blocks.ACACIA_STAIRS.defaultBlockState(), BlockBehaviour.Properties.of()));

    //Fences
    public static final Supplier<AncientWoodFenceBlock> ANCIENT_DARK_OAK_WOOD_MOSS_FENCE = registerBlock("ancient_dark_oak_wood_moss_fence", () -> new AncientWoodFenceBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<AncientWoodFenceBlock> ANCIENT_BIRCH_WOOD_MOSS_FENCE = registerBlock("ancient_birch_wood_moss_fence", () -> new AncientWoodFenceBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<AncientWoodFenceBlock> ANCIENT_SPRUCE_WOOD_MOSS_FENCE = registerBlock("ancient_spruce_wood_moss_fence", () -> new AncientWoodFenceBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<AncientWoodFenceBlock> ANCIENT_JUNGLE_WOOD_MOSS_FENCE = registerBlock("ancient_jungle_wood_moss_fence", () -> new AncientWoodFenceBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<AncientWoodFenceBlock> ANCIENT_OAK_WOOD_MOSS_FENCE = registerBlock("ancient_oak_wood_moss_fence", () -> new AncientWoodFenceBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<AncientWoodFenceBlock> ANCIENT_ACACIA_WOOD_MOSS_FENCE = registerBlock("ancient_acacia_wood_moss_fence", () -> new AncientWoodFenceBlock(BlockBehaviour.Properties.of()));

    //Doors
    public static final Supplier<AncientWoodDoorBlock> ANCIENT_DARK_OAK_WOOD_MOSS_DOOR = registerBlock("ancient_dark_oak_wood_moss_door", () -> new AncientWoodDoorBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<AncientWoodDoorBlock> ANCIENT_BIRCH_WOOD_MOSS_DOOR = registerBlock("ancient_birch_wood_moss_door", () -> new AncientWoodDoorBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<AncientWoodDoorBlock> ANCIENT_SPRUCE_WOOD_MOSS_DOOR = registerBlock("ancient_spruce_wood_moss_door", () -> new AncientWoodDoorBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<AncientWoodDoorBlock> ANCIENT_JUNGLE_WOOD_MOSS_DOOR = registerBlock("ancient_jungle_wood_moss_door", () -> new AncientWoodDoorBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<AncientWoodDoorBlock> ANCIENT_OAK_WOOD_MOSS_DOOR = registerBlock("ancient_oak_wood_moss_door", () -> new AncientWoodDoorBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<AncientWoodDoorBlock> ANCIENT_ACACIA_WOOD_MOSS_DOOR = registerBlock("ancient_acacia_wood_moss_door", () -> new AncientWoodDoorBlock(BlockBehaviour.Properties.of()));

    //Shells
    public static final Supplier<OysterShellBlock> OYSTER_SHELL_BLOCK = registerBlock("oyster_shell_block", () -> new OysterShellBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<NautilusShellBlock> NAUTILUS_SHELL_BLOCK = registerBlock("nautilus_shell_block", () -> new NautilusShellBlock(BlockBehaviour.Properties.of().strength(2.0F, 6.0F).requiresCorrectToolForDrops().sound(SoundType.BONE_BLOCK)));
    public static final Supplier<OysterShellBlock> OYSTER_SHELL_CRACKED = registerBlock("oyster_shell_cracked", () -> new OysterShellBlock(BlockBehaviour.Properties.of().strength(1.5F, 5.0F)));
    public static final Supplier<NautilusShellBlock> NAUTILUS_SHELL_CRACKED = registerBlock("nautilus_shell_cracked", () -> new NautilusShellBlock(BlockBehaviour.Properties.of().strength(1.5F, 5.0F).requiresCorrectToolForDrops().sound(SoundType.BONE_BLOCK)));
    public static final Supplier<OysterShellBlock> OYSTER_SHELL_CRACKED_MOSSY = registerBlock("oyster_shell_cracked_mossy", () -> new OysterShellBlock(BlockBehaviour.Properties.of().strength(1.5F, 5.0F)));
    public static final Supplier<NautilusShellBlock> NAUTILUS_SHELL_CRACKED_MOSSY = registerBlock("nautilus_shell_cracked_mossy", () -> new NautilusShellBlock(BlockBehaviour.Properties.of().strength(1.5F, 5.0F).requiresCorrectToolForDrops().sound(SoundType.BONE_BLOCK)));
    public static final Supplier<OysterShellBlock> OYSTER_SHELL_MOSSY = registerBlock("oyster_shell_mossy", () -> new OysterShellBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<NautilusShellBlock> NAUTILUS_SHELL_MOSSY = registerBlock("nautilus_shell_mossy", () -> new NautilusShellBlock(BlockBehaviour.Properties.of().strength(2.0F, 6.0F).requiresCorrectToolForDrops().sound(SoundType.BONE_BLOCK)));
    //Regular blocks
    public static final Supplier<SodiumBombBlock> SODIUM_BOMB = registerBlock("sodium_bomb", () -> new SodiumBombBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<SeaSaltChunkBlock> SEA_SALT_CHUNK = registerBlock("sea_salt_chunk", () -> new SeaSaltChunkBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<SunkenGravelBlock> SUNKEN_GRAVEL = registerBlock("sunken_gravel", () -> new SunkenGravelBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<CrackedGlowStoneBlock> CRACKED_GLOWSTONE = registerBlock("cracked_glowstone", () -> new CrackedGlowStoneBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<DeadGlowStoneBlock> DEAD_GLOWSTONE = registerBlock("dead_glowstone", () -> new DeadGlowStoneBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<AlgaeDetritusStoneBlock> ALGAE_DETRITUS_STONE = registerBlock("algae_detritus_stone", () -> new AlgaeDetritusStoneBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<DetritusSandStoneBlock> DETRITUS_SANDSTONE = registerBlock("detritus_sandstone", () -> new DetritusSandStoneBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<AtlanteanPrismarineBlock> ATLANTEAN_PRISMARINE = registerBlock("atlantean_prismarine", () -> new AtlanteanPrismarineBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<BubbleMagmaBlock> BUBBLE_MAGMA = registerBlock("bubble_magma", () -> new BubbleMagmaBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<PalmLeavesBlock> PALM_LEAVES = registerBlock("palm_leaves", () -> new PalmLeavesBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<AtlanteanLeavesBlock> ATLANTEAN_LEAVES = registerBlock("atlantean_leaf_block", () -> new AtlanteanLeavesBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<AtlanteanLogBlock> ATLANTEAN_LOGS = registerBlock("atlantean_log", () -> new AtlanteanLogBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<AncientWoodBlock> ANCIENT_ACACIA_WOOD_MOSS = registerBlock("ancient_acacia_wood_moss", () -> new AncientWoodBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<AncientWoodBlock> ANCIENT_OAK_WOOD_MOSS = registerBlock("ancient_oak_wood_moss", () -> new AncientWoodBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<AncientWoodBlock> ANCIENT_JUNGLE_WOOD_MOSS = registerBlock("ancient_jungle_wood_moss", () -> new AncientWoodBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<AncientWoodBlock> ANCIENT_SPRUCE_WOOD_MOSS = registerBlock("ancient_spruce_wood_moss", () -> new AncientWoodBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<AncientWoodBlock> ANCIENT_BIRCH_WOOD_MOSS = registerBlock("ancient_birch_wood_moss", () -> new AncientWoodBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<AncientWoodBlock> ANCIENT_DARK_OAK_WOOD_MOSS = registerBlock("ancient_dark_oak_wood_moss", () -> new AncientWoodBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<DropExperienceBlock> AQUAMARINE_ORE = registerBlock("aquamarine_ore", () -> new DropExperienceBlock(ConstantInt.of(5), BlockBehaviour.Properties.of()
            .sound(SoundType.STONE)
            .requiresCorrectToolForDrops()
            .strength(3.0F, 15.0F)
            .lightLevel((state) -> 2)));

    public static final Supplier<DropExperienceBlock> AQUAMARINE_DEEPSLATE_ORE = registerBlock("aquamarine_deepslate_ore", () -> new DropExperienceBlock(ConstantInt.of(5), BlockBehaviour.Properties.of()
            .sound(SoundType.STONE)
            .requiresCorrectToolForDrops()
            .strength(5.0F, 15.0F)
            .lightLevel((state) -> 4)));

    public static final Supplier<SeaBedBlock> SEABED = registerBlock("seabed", () -> new SeaBedBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<OceanLanternBlock> OCEAN_LANTERN = registerBlock("ocean_lantern", () -> new OceanLanternBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<AtlantianSeaLanternBlock> ATLANTEAN_SEA_LANTERN = registerBlock("atlantean_sea_lantern", () -> new AtlantianSeaLanternBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<AtlanteanCoreBlock> ATLANTEAN_CORE = registerBlock("atlantean_core", () -> new AtlanteanCoreBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<AquamarineBlock> BLOCK_OF_AQUAMARINE = registerBlock("block_of_aquamarine", () -> new AquamarineBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<AquamarineBlock> CHISELED_GOLDEN_BLOCK = registerBlock("chiseled_golden_block", () -> new AquamarineBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<AquamarineBlock> CHISELED_GOLDEN_AQUAMARINE = registerBlock("chiseled_golden_aquamarine", () -> new AquamarineBlock(BlockBehaviour.Properties.of()));
    ;
    public static final Supplier<PearlBlock> BLACK_PEARL_BLOCK = registerBlock("black_pearl_block", () -> new PearlBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<PearlBlock> BLUE_PEARL_BLOCK = registerBlock("blue_pearl_block", () -> new PearlBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<PearlBlock> BROWN_PEARL_BLOCK = registerBlock("brown_pearl_block", () -> new PearlBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<PearlBlock> CYAN_PEARL_BLOCK = registerBlock("cyan_pearl_block", () -> new PearlBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<PearlBlock> GRAY_PEARL_BLOCK = registerBlock("gray_pearl_block", () -> new PearlBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<PearlBlock> GREEN_PEARL_BLOCK = registerBlock("green_pearl_block", () -> new PearlBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<PearlBlock> LIGHT_BLUE_PEARL_BLOCK = registerBlock("light_blue_pearl_block", () -> new PearlBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<PearlBlock> LIGHT_GRAY_PEARL_BLOCK = registerBlock("light_gray_pearl_block", () -> new PearlBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<PearlBlock> LIME_PEARL_BLOCK = registerBlock("lime_pearl_block", () -> new PearlBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<PearlBlock> MAGENTA_PEARL_BLOCK = registerBlock("magenta_pearl_block", () -> new PearlBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<PearlBlock> ORANGE_PEARL_BLOCK = registerBlock("orange_pearl_block", () -> new PearlBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<PearlBlock> PINK_PEARL_BLOCK = registerBlock("pink_pearl_block", () -> new PearlBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<PearlBlock> PURPLE_PEARL_BLOCK = registerBlock("purple_pearl_block", () -> new PearlBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<PearlBlock> RED_PEARL_BLOCK = registerBlock("red_pearl_block", () -> new PearlBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<PearlBlock> WHITE_PEARL_BLOCK = registerBlock("white_pearl_block", () -> new PearlBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<PearlBlock> YELLOW_PEARL_BLOCK = registerBlock("yellow_pearl_block", () -> new PearlBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<AtlantisPortalBlock> ATLANTIS_PORTAL = registerBlock("atlantis_portal", () -> new AtlantisPortalBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<UnderwaterFlower> UNDERWATER_FLOWER = registerBlock("underwater_flower", () -> new UnderwaterFlower(BlockBehaviour.Properties.of()));
    public static final Supplier<UnderwaterFlower> RED_UNDERWATER_FLOWER = registerBlock("red_underwater_flower", () -> new UnderwaterFlower(BlockBehaviour.Properties.of()));
    public static final Supplier<PurpleGlowingMushroom> PURPLE_GLOWING_MUSHROOM = registerBlock("purple_glowing_mushroom", () -> new PurpleGlowingMushroom(BlockBehaviour.Properties.of()));
    public static final Supplier<YellowGlowingMushroom> YELLOW_GLOWING_MUSHROOM = registerBlock("yellow_glowing_mushroom", () -> new YellowGlowingMushroom(BlockBehaviour.Properties.of()));
    public static final Supplier<UnderwaterFlower> YELLOW_UNDERWATER_FLOWER = registerBlock("yellow_underwater_flower", () -> new UnderwaterFlower(BlockBehaviour.Properties.of()));
    public static final Supplier<AlgaePlantBlock> ALGAE = registerBlock("algae", () -> new AlgaePlantBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<AtlanteanPowerStoneBlock> ATLANTEAN_POWER_STONE = registerBlock("atlantean_power_stone", () -> new AtlanteanPowerStoneBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<AtlanteanPowerLampBlock> ATLANTEAN_POWER_LAMP = registerBlock("atlantean_power_lamp", () -> new AtlanteanPowerLampBlock(BlockBehaviour.Properties.of().strength(0.3F)));
    public static final Supplier<AtlanteanPowerTorchBlock> ATLANTEAN_POWER_TORCH = registerOnlyBlock("atlantean_power_torch", () -> new AtlanteanPowerTorchBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<WallAtlanteanPowerTorchBlock> WALL_ATLANTEAN_POWER_TORCH = registerOnlyBlock("atlantean_power_wall_torch", () -> new WallAtlanteanPowerTorchBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<AtlanteanPowerDustBlock> ATLANTEAN_POWER_DUST_WIRE = registerOnlyBlock("atlantean_power_dust", () -> new AtlanteanPowerDustBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<AtlanteanPowerRepeaterBlock> ATLANTEAN_POWER_REPEATER = registerBlock("atlantean_power_repeater", () -> new AtlanteanPowerRepeaterBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<AtlanteanTripwireHook> ATLANTEAN_TRIPWIRE_HOOK = registerBlock("atlantean_tripwire_hook", () -> new AtlanteanTripwireHook(BlockBehaviour.Properties.of().noCollission()));
    public static final Supplier<AtlanteanTripwireBlock> ATLANTEAN_TRIPWIRE = registerOnlyBlock("atlantean_tripwire", () -> new AtlanteanTripwireBlock(ATLANTEAN_TRIPWIRE_HOOK.get(), BlockBehaviour.Properties.of().noCollission()));
    public static final Supplier<AtlanteanPowerLeverBlock> ATLANTEAN_POWER_LEVER = registerBlock("atlantean_power_lever", () -> new AtlanteanPowerLeverBlock(BlockBehaviour.Properties.of().noCollission().strength(0.5F).sound(SoundType.WOOD)));
    public static final Supplier<AtlanteanPowerComparatorBlock> ATLANTEAN_POWER_COMPARATOR = registerBlock("atlantean_power_comparator", () -> new AtlanteanPowerComparatorBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<CalciteBlock> CALCITE_BLOCK = registerBlock("calcite_block", () -> new CalciteBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<PushBubbleColumnBlock> PUSH_BUBBLE_COLUMN = registerOnlyBlock("push_bubble_column", () -> new PushBubbleColumnBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<AncientWoodSlabBlock> ANCIENT_ACACIA_WOOD_MOSS_SLAB = registerBlock("ancient_acacia_wood_moss_slab", () -> new AncientWoodSlabBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<AncientWoodSlabBlock> ANCIENT_OAK_WOOD_MOSS_SLAB = registerBlock("ancient_oak_wood_moss_slab", () -> new AncientWoodSlabBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<AncientWoodSlabBlock> ANCIENT_JUNGLE_WOOD_MOSS_SLAB = registerBlock("ancient_jungle_wood_moss_slab", () -> new AncientWoodSlabBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<AncientWoodSlabBlock> ANCIENT_SPRUCE_WOOD_MOSS_SLAB = registerBlock("ancient_spruce_wood_moss_slab", () -> new AncientWoodSlabBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<AncientWoodSlabBlock> ANCIENT_BIRCH_WOOD_MOSS_SLAB = registerBlock("ancient_birch_wood_moss_slab", () -> new AncientWoodSlabBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<AncientWoodSlabBlock> ANCIENT_DARK_OAK_WOOD_MOSS_SLAB = registerBlock("ancient_dark_oak_wood_moss_slab", () -> new AncientWoodSlabBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<AlgaeBlock> ALGAE_BLOCK = registerBlock("algae_block", () -> new AlgaeBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<ChiseledAquamarineBlock> CHISELED_AQUAMARINE = registerBlock("chiseled_aquamarine", () -> new ChiseledAquamarineBlock(BlockBehaviour.Properties.of()));

    public static final Supplier<Block> ORICHALCUM_BLOCK = registerBlock("orichalcum_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL)));

    public static final Supplier<LinguisticBlock> LINGUISTIC_BLOCK = registerLinguisticBlock("linguistic_block", () -> new LinguisticBlock(BlockBehaviour.Properties.of().strength(2.5F).sound(SoundType.WOOD)));

    public static final Supplier<WritingBlock> WRITING_BLOCK = registerLinguisticBlock("writing_block", () -> new WritingBlock(BlockBehaviour.Properties.of().strength(2.5F).sound(SoundType.WOOD)));
    public static final Supplier<AtlanteanSaplingBlock> ATLANTEAN_SAPLING = registerBlock("atlantean_sapling", () ->
            new AtlanteanSaplingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));

    public static final Supplier<AtlanteanPalmSaplingBlock> ATLANTEAN_PALM_SAPLING = registerBlock("palm_sapling", () ->
            new AtlanteanPalmSaplingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));

    public static final Supplier<AtlanteanFireMelonSpikedFruitBlock> ATLANTEAN_FIRE_MELON_FRUIT_SPIKED = registerOnlyBlock("atlantean_fire_melon_fruit_spiked", () -> new AtlanteanFireMelonSpikedFruitBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<AtlanteanFireMelonFruitBlock> ATLANTEAN_FIRE_MELON_FRUIT = registerOnlyBlock("atlantean_fire_melon_fruit", () -> new AtlanteanFireMelonFruitBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()));

    public static final Supplier<AtlanteanFireMelonBody> ATLANTEAN_FIRE_MELON_STEM = registerOnlyBlock("atlantean_fire_melon_stem", () -> new AtlanteanFireMelonBody(BlockBehaviour.Properties.of()));
    public static final Supplier<AtlanteanFireMelonHead> ATLANTEAN_FIRE_MELON_TOP = registerOnlyBlock("atlantean_fire_melon_top", () -> new AtlanteanFireMelonHead(BlockBehaviour.Properties.of()));

    public static final BlockType MAGENTA_SEA_GLASS = registerSeaGlass("magenta");
    public static final BlockType LIGHT_GRAY_SEA_GLASS = registerSeaGlass("light_gray");
    public static final BlockType PINK_SEA_GLASS = registerSeaGlass("pink");
    public static final BlockType YELLOW_SEA_GLASS = registerSeaGlass("yellow");
    public static final BlockType PURPLE_SEA_GLASS = registerSeaGlass("purple");
    public static final BlockType SEA_GLASS = registerSeaGlass("");
    public static final BlockType LIGHT_BLUE_SEA_GLASS = registerSeaGlass("light_blue");
    public static final BlockType RED_SEA_GLASS = registerSeaGlass("red");
    public static final BlockType MONOCHROMATIC_SEA_GLASS = registerSeaGlass("monochromatic");
    public static final BlockType GREEN_SEA_GLASS = registerSeaGlass("green");
    public static final BlockType WHITE_SEA_GLASS = registerSeaGlass("white");
    public static final BlockType CYAN_SEA_GLASS = registerSeaGlass("cyan");
    public static final BlockType MULTICOLOR_SEA_GLASS = registerSeaGlass("multicolor");
    public static final BlockType ORANGE_SEA_GLASS = registerSeaGlass("orange");
    public static final BlockType BLACK_SEA_GLASS = registerSeaGlass("black");
    public static final BlockType GRAY_SEA_GLASS = registerSeaGlass("gray");
    public static final BlockType BLUE_SEA_GLASS = registerSeaGlass("blue");
    public static final BlockType BROWN_SEA_GLASS = registerSeaGlass("brown");
    public static final BlockType LIME_SEA_GLASS = registerSeaGlass("lime");

    public static final Supplier<Block> ANCIENT_METAL_BLOCK = registerBlock(
            "ancient_metal_block",
            () -> new WeatheringMetalFullBlock(
                    WeatheringMetal.WeatherState.UNAFFECTED,
                    BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.METAL)
            )
    );
    public static final Supplier<Block> EXPOSED_ANCIENT_METAL = registerBlock(
            "exposed_ancient_metal",
            () -> new WeatheringMetalFullBlock(
                    WeatheringMetal.WeatherState.EXPOSED, BlockBehaviour.Properties.ofFullCopy(ANCIENT_METAL_BLOCK.get()).mapColor(MapColor.COLOR_GRAY)
            )
    );
    public static final Supplier<Block> WEATHERED_ANCIENT_METAL = registerBlock(
            "weathered_ancient_metal",
            () -> new WeatheringMetalFullBlock(
                    WeatheringMetal.WeatherState.WEATHERED, BlockBehaviour.Properties.ofFullCopy(ANCIENT_METAL_BLOCK.get()).mapColor(MapColor.WARPED_STEM)
            )
    );
    public static final Supplier<Block> OXIDIZED_ANCIENT_METAL = registerBlock(
            "oxidized_ancient_metal",
            () -> new  WeatheringMetalFullBlock(
                    WeatheringMetal.WeatherState.OXIDIZED, BlockBehaviour.Properties.ofFullCopy(ANCIENT_METAL_BLOCK.get()).mapColor(MapColor.WARPED_NYLIUM)
            )
    );

    public static final Supplier<Block> OXIDIZED_CUT_ANCIENT_METAL = registerBlock(
            "oxidized_cut_ancient_metal", () -> new  WeatheringMetalFullBlock(WeatheringMetal.WeatherState.OXIDIZED, BlockBehaviour.Properties.ofFullCopy(OXIDIZED_ANCIENT_METAL.get()))
    );
    public static final Supplier<Block> WEATHERED_CUT_ANCIENT_METAL = registerBlock(
            "weathered_cut_ancient_metal", () -> new  WeatheringMetalFullBlock(WeatheringMetal.WeatherState.WEATHERED, BlockBehaviour.Properties.ofFullCopy(WEATHERED_ANCIENT_METAL.get()))
    );
    public static final Supplier<Block> EXPOSED_CUT_ANCIENT_METAL = registerBlock(
            "exposed_cut_ancient_metal", () -> new  WeatheringMetalFullBlock(WeatheringMetal.WeatherState.EXPOSED, BlockBehaviour.Properties.ofFullCopy(EXPOSED_ANCIENT_METAL.get()))
    );
    public static final Supplier<Block> CUT_ANCIENT_METAL = registerBlock(
            "cut_ancient_metal", () -> new  WeatheringMetalFullBlock(WeatheringMetal.WeatherState.UNAFFECTED, BlockBehaviour.Properties.ofFullCopy(ANCIENT_METAL_BLOCK.get()))
    );
    public static final Supplier<Block> OXIDIZED_CHISELED_ANCIENT_METAL = registerBlock(
            "oxidized_chiseled_ancient_metal",
            () -> new  WeatheringMetalFullBlock(
                    WeatheringMetal.WeatherState.OXIDIZED, BlockBehaviour.Properties.ofFullCopy(OXIDIZED_ANCIENT_METAL.get()).requiredFeatures(FeatureFlags.UPDATE_1_21)
            )
    );
    public static final Supplier<Block> WEATHERED_CHISELED_ANCIENT_METAL = registerBlock(
            "weathered_chiseled_ancient_metal",
            () -> new  WeatheringMetalFullBlock(
                    WeatheringMetal.WeatherState.WEATHERED, BlockBehaviour.Properties.ofFullCopy(WEATHERED_ANCIENT_METAL.get()).requiredFeatures(FeatureFlags.UPDATE_1_21)
            )
    );
    public static final Supplier<Block> EXPOSED_CHISELED_ANCIENT_METAL = registerBlock(
            "exposed_chiseled_ancient_metal",
            () -> new  WeatheringMetalFullBlock(
                    WeatheringMetal.WeatherState.EXPOSED, BlockBehaviour.Properties.ofFullCopy(EXPOSED_ANCIENT_METAL.get()).requiredFeatures(FeatureFlags.UPDATE_1_21)
            )
    );
    public static final Supplier<Block> CHISELED_ANCIENT_METAL = registerBlock(
            "chiseled_ancient_metal",
            () -> new  WeatheringMetalFullBlock(
                    WeatheringMetal.WeatherState.UNAFFECTED, BlockBehaviour.Properties.ofFullCopy(ANCIENT_METAL_BLOCK.get()).requiredFeatures(FeatureFlags.UPDATE_1_21)
            )
    );
    public static final Supplier<Block> WAXED_OXIDIZED_CHISELED_ANCIENT_METAL = registerBlock(
            "waxed_oxidized_chiseled_ancient_metal", () -> new  Block(BlockBehaviour.Properties.ofFullCopy(OXIDIZED_CHISELED_ANCIENT_METAL.get()))
    );
    public static final Supplier<Block> WAXED_WEATHERED_CHISELED_ANCIENT_METAL = registerBlock(
            "waxed_weathered_chiseled_ancient_metal", () -> new  Block(BlockBehaviour.Properties.ofFullCopy(WEATHERED_CHISELED_ANCIENT_METAL.get()))
    );
    public static final Supplier<Block> WAXED_EXPOSED_CHISELED_ANCIENT_METAL = registerBlock(
            "waxed_exposed_chiseled_ancient_metal", () -> new  Block(BlockBehaviour.Properties.ofFullCopy(EXPOSED_CHISELED_ANCIENT_METAL.get()))
    );
    public static final Supplier<Block> WAXED_CHISELED_ANCIENT_METAL = registerBlock("waxed_chiseled_ancient_metal", () -> new  Block(BlockBehaviour.Properties.ofFullCopy(CHISELED_ANCIENT_METAL.get())));
    public static final Supplier<Block> OXIDIZED_CUT_ANCIENT_METAL_STAIRS = registerBlock(
            "oxidized_cut_ancient_metal_stairs",
            () -> new  WeatheringMetalStairBlock(
                    WeatheringMetal.WeatherState.OXIDIZED, OXIDIZED_CUT_ANCIENT_METAL.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(OXIDIZED_CUT_ANCIENT_METAL.get())
            )
    );
    public static final Supplier<Block> WEATHERED_CUT_ANCIENT_METAL_STAIRS = registerBlock(
            "weathered_cut_ancient_metal_stairs",
            () -> new WeatheringMetalStairBlock(
                    WeatheringMetal.WeatherState.WEATHERED, WEATHERED_CUT_ANCIENT_METAL.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(WEATHERED_ANCIENT_METAL.get())
            )
    );
    public static final Supplier<Block> EXPOSED_CUT_ANCIENT_METAL_STAIRS = registerBlock(
            "exposed_cut_ancient_metal_stairs",
            () -> new  WeatheringMetalStairBlock(
                    WeatheringMetal.WeatherState.EXPOSED, EXPOSED_CUT_ANCIENT_METAL.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(EXPOSED_ANCIENT_METAL.get())
            )
    );
    public static final Supplier<Block> CUT_ANCIENT_METAL_STAIRS = registerBlock(
            "cut_ancient_metal_stairs",
            () -> new  WeatheringMetalStairBlock(
                    WeatheringMetal.WeatherState.UNAFFECTED, CUT_ANCIENT_METAL.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(ANCIENT_METAL_BLOCK.get())
            )
    );
    public static final Supplier<Block> OXIDIZED_CUT_ANCIENT_METAL_SLAB = registerBlock(
            "oxidized_cut_ancient_metal_slab",
            () -> new  WeatheringMetalSlabBlock(WeatheringMetal.WeatherState.OXIDIZED, BlockBehaviour.Properties.ofFullCopy(OXIDIZED_CUT_ANCIENT_METAL.get()))
    );
    public static final Supplier<Block> WEATHERED_CUT_ANCIENT_METAL_SLAB = registerBlock(
            "weathered_cut_ancient_metal_slab",
            () -> new  WeatheringMetalSlabBlock(WeatheringMetal.WeatherState.WEATHERED, BlockBehaviour.Properties.ofFullCopy(WEATHERED_CUT_ANCIENT_METAL.get()))
    );
    public static final Supplier<Block> EXPOSED_CUT_ANCIENT_METAL_SLAB = registerBlock(
            "exposed_cut_ancient_metal_slab",
            () -> new WeatheringMetalSlabBlock(WeatheringMetal.WeatherState.EXPOSED, BlockBehaviour.Properties.ofFullCopy(EXPOSED_CUT_ANCIENT_METAL.get()))
    );
    public static final Supplier<Block> CUT_ANCIENT_METAL_SLAB = registerBlock(
            "cut_ancient_metal_slab", () -> new  WeatheringMetalSlabBlock(WeatheringMetal.WeatherState.UNAFFECTED, BlockBehaviour.Properties.ofFullCopy(CUT_ANCIENT_METAL.get()))
    );
    public static final Supplier<Block> WAXED_ANCIENT_METAL_BLOCK = registerBlock("waxed_ancient_metal_block", () -> new  Block(BlockBehaviour.Properties.ofFullCopy(ANCIENT_METAL_BLOCK.get())));
    public static final Supplier<Block> WAXED_WEATHERED_ANCIENT_METAL = registerBlock("waxed_weathered_ancient_metal", () -> new  Block(BlockBehaviour.Properties.ofFullCopy(WEATHERED_ANCIENT_METAL.get())));
    public static final Supplier<Block> WAXED_EXPOSED_ANCIENT_METAL = registerBlock("waxed_exposed_ancient_metal", () -> new  Block(BlockBehaviour.Properties.ofFullCopy(EXPOSED_ANCIENT_METAL.get())));
    public static final Supplier<Block> WAXED_OXIDIZED_ANCIENT_METAL = registerBlock("waxed_oxidized_ancient_metal", () -> new  Block(BlockBehaviour.Properties.ofFullCopy(OXIDIZED_ANCIENT_METAL.get())));
    public static final Supplier<Block> WAXED_OXIDIZED_CUT_ANCIENT_METAL = registerBlock(
            "waxed_oxidized_cut_ancient_metal", () -> new  Block(BlockBehaviour.Properties.ofFullCopy(OXIDIZED_ANCIENT_METAL.get()))
    );
    public static final Supplier<Block> WAXED_WEATHERED_CUT_ANCIENT_METAL = registerBlock(
            "waxed_weathered_cut_ancient_metal", () -> new  Block(BlockBehaviour.Properties.ofFullCopy(WEATHERED_ANCIENT_METAL.get()))
    );
    public static final Supplier<Block> WAXED_EXPOSED_CUT_ANCIENT_METAL = registerBlock("waxed_exposed_cut_ancient_metal", () -> new  Block(BlockBehaviour.Properties.ofFullCopy(EXPOSED_ANCIENT_METAL.get())));
    public static final Supplier<Block> WAXED_CUT_ANCIENT_METAL = registerBlock("waxed_cut_ancient_metal", () -> new  Block(BlockBehaviour.Properties.ofFullCopy(ANCIENT_METAL_BLOCK.get())));
    public static final Supplier<Block> WAXED_OXIDIZED_CUT_ANCIENT_METAL_STAIRS = registerBlock("waxed_oxidized_cut_ancient_metal_stairs", () -> new StairBlock(WAXED_OXIDIZED_CUT_ANCIENT_METAL.get().defaultBlockState(), WAXED_OXIDIZED_CUT_ANCIENT_METAL.get().properties()));
    public static final Supplier<Block> WAXED_WEATHERED_CUT_ANCIENT_METAL_STAIRS = registerBlock("waxed_weathered_cut_ancient_metal_stairs", () -> new StairBlock(WAXED_WEATHERED_CUT_ANCIENT_METAL.get().defaultBlockState(), WAXED_WEATHERED_CUT_ANCIENT_METAL.get().properties()));
    public static final Supplier<Block> WAXED_EXPOSED_CUT_ANCIENT_METAL_STAIRS = registerBlock("waxed_exposed_cut_ancient_metal_stairs", () -> new StairBlock(WAXED_EXPOSED_CUT_ANCIENT_METAL.get().defaultBlockState(), WAXED_EXPOSED_CUT_ANCIENT_METAL.get().properties()));
    public static final Supplier<Block> WAXED_CUT_ANCIENT_METAL_STAIRS = registerBlock("waxed_cut_ancient_metal_stairs", () -> new StairBlock(WAXED_CUT_ANCIENT_METAL.get().defaultBlockState(), WAXED_CUT_ANCIENT_METAL.get().properties()));
    public static final Supplier<Block> WAXED_OXIDIZED_CUT_ANCIENT_METAL_SLAB = registerBlock(
            "waxed_oxidized_cut_ancient_metal_slab", () -> new  SlabBlock(BlockBehaviour.Properties.ofFullCopy(WAXED_OXIDIZED_CUT_ANCIENT_METAL.get()).requiresCorrectToolForDrops())
    );
    public static final Supplier<Block> WAXED_WEATHERED_CUT_ANCIENT_METAL_SLAB = registerBlock(
            "waxed_weathered_cut_ancient_metal_slab", () -> new  SlabBlock(BlockBehaviour.Properties.ofFullCopy(WAXED_WEATHERED_CUT_ANCIENT_METAL.get()).requiresCorrectToolForDrops())
    );
    public static final Supplier<Block> WAXED_EXPOSED_CUT_ANCIENT_METAL_SLAB = registerBlock(
            "waxed_exposed_cut_ancient_metal_slab", () -> new  SlabBlock(BlockBehaviour.Properties.ofFullCopy(WAXED_EXPOSED_CUT_ANCIENT_METAL.get()).requiresCorrectToolForDrops())
    );
    public static final Supplier<Block> WAXED_CUT_ANCIENT_METAL_SLAB = registerBlock(
            "waxed_cut_ancient_metal_slab", () -> new  SlabBlock(BlockBehaviour.Properties.ofFullCopy(WAXED_CUT_ANCIENT_METAL.get()).requiresCorrectToolForDrops())
    );
    public static final Supplier<Block> ANCIENT_METAL_DOOR = registerBlock(
            "ancient_metal_door",
            () -> new WeatheringMetalDoorBlock(
                    BlockSetType.COPPER,
                    WeatheringMetal.WeatherState.UNAFFECTED,
                    BlockBehaviour.Properties.of()
                            .mapColor(ANCIENT_METAL_BLOCK.get().defaultMapColor())
                            .strength(3.0F, 6.0F)
                            .noOcclusion()
                            .requiresCorrectToolForDrops()
                            .pushReaction(PushReaction.DESTROY)
                            .requiredFeatures(FeatureFlags.UPDATE_1_21)
            )
    );
    public static final Supplier<Block> EXPOSED_ANCIENT_METAL_DOOR = registerBlock(
            "exposed_ancient_metal_door",
            () -> new  WeatheringMetalDoorBlock(
                    BlockSetType.COPPER,
                    WeatheringMetal.WeatherState.EXPOSED,
                    BlockBehaviour.Properties.ofFullCopy(ANCIENT_METAL_DOOR.get()).mapColor(EXPOSED_ANCIENT_METAL.get().defaultMapColor())
            )
    );
    public static final Supplier<Block> OXIDIZED_ANCIENT_METAL_DOOR = registerBlock(
            "oxidized_ancient_metal_door",
            () -> new  WeatheringMetalDoorBlock(
                    BlockSetType.COPPER,
                    WeatheringMetal.WeatherState.OXIDIZED,
                    BlockBehaviour.Properties.ofFullCopy(ANCIENT_METAL_DOOR.get()).mapColor(OXIDIZED_ANCIENT_METAL.get().defaultMapColor())
            )
    );
    public static final Supplier<Block> WEATHERED_ANCIENT_METAL_DOOR = registerBlock(
            "weathered_ancient_metal_door",
            () -> new  WeatheringMetalDoorBlock(
                    BlockSetType.COPPER,
                    WeatheringMetal.WeatherState.WEATHERED,
                    BlockBehaviour.Properties.ofFullCopy(ANCIENT_METAL_DOOR.get()).mapColor(WEATHERED_ANCIENT_METAL.get().defaultMapColor())
            )
    );
    public static final Supplier<Block> WAXED_ANCIENT_METAL_DOOR = registerBlock(
            "waxed_ancient_metal_door", () -> new  DoorBlock(BlockSetType.COPPER, BlockBehaviour.Properties.ofFullCopy(ANCIENT_METAL_DOOR.get()))
    );
    public static final Supplier<Block> WAXED_EXPOSED_ANCIENT_METAL_DOOR = registerBlock(
            "waxed_exposed_ancient_metal_door", () -> new  DoorBlock(BlockSetType.COPPER, BlockBehaviour.Properties.ofFullCopy(EXPOSED_ANCIENT_METAL_DOOR.get()))
    );
    public static final Supplier<Block> WAXED_OXIDIZED_ANCIENT_METAL_DOOR = registerBlock(
            "waxed_oxidized_ancient_metal_door", () -> new  DoorBlock(BlockSetType.COPPER, BlockBehaviour.Properties.ofFullCopy(OXIDIZED_ANCIENT_METAL_DOOR.get()))
    );
    public static final Supplier<Block> WAXED_WEATHERED_ANCIENT_METAL_DOOR = registerBlock(
            "waxed_weathered_ancient_metal_door", () -> new  DoorBlock(BlockSetType.COPPER, BlockBehaviour.Properties.ofFullCopy(WEATHERED_ANCIENT_METAL_DOOR.get()))
    );
    public static final Supplier<Block> ANCIENT_METAL_TRAPDOOR = registerBlock(
            "ancient_metal_trapdoor",
            () -> new WeatheringMetalTrapDoorBlock(
                    WeatheringMetal.WeatherState.UNAFFECTED,
                    BlockBehaviour.Properties.of()
                            .mapColor(ANCIENT_METAL_BLOCK.get().defaultMapColor())
                            .strength(3.0F, 6.0F)
                            .requiresCorrectToolForDrops()
                            .noOcclusion()
                            .isValidSpawn((pState, pLevel, pPos, pValue) -> false)
                            .requiredFeatures(FeatureFlags.UPDATE_1_21)
            )
    );
    public static final Supplier<Block> EXPOSED_ANCIENT_METAL_TRAPDOOR = registerBlock(
            "exposed_ancient_metal_trapdoor",
            () -> new  WeatheringMetalTrapDoorBlock(
                    WeatheringMetal.WeatherState.EXPOSED,
                    BlockBehaviour.Properties.ofFullCopy(ANCIENT_METAL_TRAPDOOR.get()).mapColor(EXPOSED_ANCIENT_METAL.get().defaultMapColor())
            )
    );
    public static final Supplier<Block> OXIDIZED_ANCIENT_METAL_TRAPDOOR = registerBlock(
            "oxidized_ancient_metal_trapdoor",
            () -> new  WeatheringMetalTrapDoorBlock(
                    WeatheringMetal.WeatherState.OXIDIZED,
                    BlockBehaviour.Properties.ofFullCopy(ANCIENT_METAL_TRAPDOOR.get()).mapColor(OXIDIZED_ANCIENT_METAL.get().defaultMapColor())
            )
    );
    public static final Supplier<Block> WEATHERED_ANCIENT_METAL_TRAPDOOR = registerBlock(
            "weathered_ancient_metal_trapdoor",
            () -> new  WeatheringMetalTrapDoorBlock(
                    WeatheringMetal.WeatherState.WEATHERED,
                    BlockBehaviour.Properties.ofFullCopy(ANCIENT_METAL_TRAPDOOR.get()).mapColor(WEATHERED_ANCIENT_METAL.get().defaultMapColor())
            )
    );
    public static final Supplier<Block> WAXED_ANCIENT_METAL_TRAPDOOR = registerBlock(
            "waxed_ancient_metal_trapdoor", () -> new  TrapDoorBlock(BlockSetType.COPPER, BlockBehaviour.Properties.ofFullCopy(ANCIENT_METAL_TRAPDOOR.get()))
    );
    public static final Supplier<Block> WAXED_EXPOSED_ANCIENT_METAL_TRAPDOOR = registerBlock(
            "waxed_exposed_ancient_metal_trapdoor", () -> new  TrapDoorBlock(BlockSetType.COPPER, BlockBehaviour.Properties.ofFullCopy(EXPOSED_ANCIENT_METAL_TRAPDOOR.get()))
    );
    public static final Supplier<Block> WAXED_OXIDIZED_ANCIENT_METAL_TRAPDOOR = registerBlock(
            "waxed_oxidized_ancient_metal_trapdoor", () -> new  TrapDoorBlock(BlockSetType.COPPER, BlockBehaviour.Properties.ofFullCopy(OXIDIZED_ANCIENT_METAL_TRAPDOOR.get()))
    );
    public static final Supplier<Block> WAXED_WEATHERED_ANCIENT_METAL_TRAPDOOR = registerBlock(
            "waxed_weathered_ancient_metal_trapdoor", () -> new  TrapDoorBlock(BlockSetType.COPPER, BlockBehaviour.Properties.ofFullCopy(WEATHERED_ANCIENT_METAL_TRAPDOOR.get()))
    );
    public static final Supplier<Block> ANCIENT_METAL_GRATE = registerBlock(
            "ancient_metal_grate",
            () -> new WeatheringMetalGrateBlock(
                    WeatheringMetal.WeatherState.UNAFFECTED,
                    BlockBehaviour.Properties.of()
                            .strength(3.0F, 6.0F)
                            .sound(SoundType.COPPER_GRATE)
                            .mapColor(MapColor.COLOR_ORANGE)
                            .noOcclusion()
                            .requiresCorrectToolForDrops()
                            .isValidSpawn((pState, pLevel, pPos, pValue) -> false)
                            .isRedstoneConductor((pState, pLevel, pPos) -> false)
                            .isSuffocating((pState, pLevel, pPos) -> false)
                            .isViewBlocking((pState, pLevel, pPos) -> false)
                            .requiredFeatures(FeatureFlags.UPDATE_1_21)
            )
    );
    public static final Supplier<Block> EXPOSED_ANCIENT_METAL_GRATE = registerBlock(
            "exposed_ancient_metal_grate",
            () -> new  WeatheringMetalGrateBlock(
                    WeatheringMetal.WeatherState.EXPOSED, BlockBehaviour.Properties.ofFullCopy(ANCIENT_METAL_GRATE.get()).mapColor(MapColor.TERRACOTTA_LIGHT_GRAY)
            )
    );
    public static final Supplier<Block> WEATHERED_ANCIENT_METAL_GRATE = registerBlock(
            "weathered_ancient_metal_grate",
            () -> new  WeatheringMetalGrateBlock(
                    WeatheringMetal.WeatherState.WEATHERED, BlockBehaviour.Properties.ofFullCopy(ANCIENT_METAL_GRATE.get()).mapColor(MapColor.WARPED_STEM)
            )
    );
    public static final Supplier<Block> OXIDIZED_ANCIENT_METAL_GRATE = registerBlock(
            "oxidized_ancient_metal_grate",
            () -> new  WeatheringMetalGrateBlock(
                    WeatheringMetal.WeatherState.OXIDIZED, BlockBehaviour.Properties.ofFullCopy(ANCIENT_METAL_GRATE.get()).mapColor(MapColor.WARPED_NYLIUM)
            )
    );
    public static final Supplier<Block> WAXED_ANCIENT_METAL_GRATE = registerBlock(
            "waxed_ancient_metal_grate", () -> new WaterloggedTransparentBlock(BlockBehaviour.Properties.ofFullCopy(ANCIENT_METAL_GRATE.get()))
    );
    public static final Supplier<Block> WAXED_EXPOSED_ANCIENT_METAL_GRATE = registerBlock(
            "waxed_exposed_ancient_metal_grate", () -> new WaterloggedTransparentBlock(BlockBehaviour.Properties.ofFullCopy(EXPOSED_ANCIENT_METAL_GRATE.get()))
    );
    public static final Supplier<Block> WAXED_WEATHERED_ANCIENT_METAL_GRATE = registerBlock(
            "waxed_weathered_ancient_metal_grate", () -> new  WaterloggedTransparentBlock(BlockBehaviour.Properties.ofFullCopy(WEATHERED_ANCIENT_METAL_GRATE.get()))
    );
    public static final Supplier<Block> WAXED_OXIDIZED_ANCIENT_METAL_GRATE = registerBlock(
            "waxed_oxidized_ancient_metal_grate", () -> new  WaterloggedTransparentBlock(BlockBehaviour.Properties.ofFullCopy(OXIDIZED_ANCIENT_METAL_GRATE.get()))
    );
    public static final Supplier<Block> ANCIENT_METAL_BULB = registerBlock(
            "ancient_metal_bulb",
            () -> new  WeatheringMetalBulbBlock(
                    WeatheringMetal.WeatherState.UNAFFECTED,
                    BlockBehaviour.Properties.of()
                            .mapColor(ANCIENT_METAL_BLOCK.get().defaultMapColor())
                            .strength(3.0F, 6.0F)
                            .sound(SoundType.COPPER_BULB)
                            .requiresCorrectToolForDrops()
                            .isRedstoneConductor((pState, pLevel, pPos) -> false)
                            .lightLevel(value -> 15)
                            .requiredFeatures(FeatureFlags.UPDATE_1_21)
            )
    );
    public static final Supplier<Block> EXPOSED_ANCIENT_METAL_BULB = registerBlock(
            "exposed_ancient_metal_bulb",
            () -> new  WeatheringMetalBulbBlock(
                    WeatheringMetal.WeatherState.EXPOSED,
                    BlockBehaviour.Properties.ofFullCopy(ANCIENT_METAL_BULB.get()).mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).lightLevel(value -> 12)
            )
    );
    public static final Supplier<Block> WEATHERED_ANCIENT_METAL_BULB = registerBlock(
            "weathered_ancient_metal_bulb",
            () -> new  WeatheringMetalBulbBlock(
                    WeatheringMetal.WeatherState.WEATHERED,
                    BlockBehaviour.Properties.ofFullCopy(ANCIENT_METAL_BULB.get()).mapColor(MapColor.WARPED_STEM).lightLevel(value -> 8)
            )
    );
    public static final Supplier<Block> OXIDIZED_ANCIENT_METAL_BULB = registerBlock(
            "oxidized_ancient_metal_bulb",
            () -> new  WeatheringMetalBulbBlock(
                    WeatheringMetal.WeatherState.OXIDIZED,
                    BlockBehaviour.Properties.ofFullCopy(ANCIENT_METAL_BULB.get()).mapColor(MapColor.WARPED_NYLIUM).lightLevel(value -> 4)
            )
    );
    public static final Supplier<Block> WAXED_ANCIENT_METAL_BULB = registerBlock("waxed_ancient_metal_bulb", () -> new  MetalBulbBlock(BlockBehaviour.Properties.ofFullCopy(ANCIENT_METAL_BULB.get())));
    public static final Supplier<Block> WAXED_EXPOSED_ANCIENT_METAL_BULB = registerBlock(
            "waxed_exposed_ancient_metal_bulb", () -> new  MetalBulbBlock(BlockBehaviour.Properties.ofFullCopy(EXPOSED_ANCIENT_METAL_BULB.get()))
    );
    public static final Supplier<Block> WAXED_WEATHERED_ANCIENT_METAL_BULB = registerBlock(
            "waxed_weathered_ancient_metal_bulb", () -> new  MetalBulbBlock(BlockBehaviour.Properties.ofFullCopy(WEATHERED_ANCIENT_METAL_BULB.get()))
    );
    public static final Supplier<Block> WAXED_OXIDIZED_ANCIENT_METAL_BULB = registerBlock(
            "waxed_oxidized_ancient_metal_bulb", () -> new MetalBulbBlock(BlockBehaviour.Properties.ofFullCopy(OXIDIZED_ANCIENT_METAL_BULB.get()))
    );

    public static final Supplier<RotatedPillarBlock> COQUINA = registerMainTabBlock("coquina", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of() .sound(SoundType.BONE_BLOCK)
            .requiresCorrectToolForDrops()
            .strength(3.0F, 7.0F)
    .mapColor(MapColor.TERRACOTTA_ORANGE)), Supplier -> () -> new BlockItem(Supplier.get(), new Item.Properties()));

    private static <B extends Block> Supplier<B> registerBlock(String name, Supplier<B> block) {
        return registerMainTabBlock(name, block, b -> () -> new BlockItem(b.get(), new Item.Properties()));
    }

    public static <B extends Block> Supplier<B> registerLinguisticBlock(String name, Supplier<B> block) {
        return registerGylphTabBlock(name, block, b -> () -> new BlockItem(b.get(), new Item.Properties()));
    }

    public static <B extends Block> Supplier<B> registerOnlyBlock(String name, Supplier<B> block) {
        return BLOCKS.register(name, block);
    }

    public static <L extends LiquidBlock> Supplier<L> registerFluidBlock(String name, Supplier<L> block) {
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> BlockType registerBlockType(String name, Function<BlockBehaviour.Properties, Block> block, BlockBehaviour.Properties properties, boolean genDoors, BlockSetType blockSetType, @Nullable WoodType woodType, int pTicksToStayPressed, boolean pArrowsCanPress) {
        var blockBase = registerMainTabBlock(name, () -> block.apply(properties), tSupplier -> () -> new BlockItem(tSupplier.get(), new Item.Properties()));
        var blockSlab = registerMainTabBlock(name + "_slab", blockBase, block1 -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(block1)), block2 -> new BlockItem(block2, new Item.Properties()));
        var blockWall = woodType == null ? registerMainTabBlock(name + "_wall", blockBase, block1 -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(block1)), block2 -> new BlockItem(block2, new Item.Properties())) : null;
        var blockFence = woodType != null ? registerMainTabBlock(name + "_fence", blockBase, block1 -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(block1)), block2 -> new BlockItem(block2, new Item.Properties())) : null;
        var blockGate = woodType != null ? registerMainTabBlock(name + "_fence_gate", blockBase, block1 -> new FenceGateBlock(woodType, BlockBehaviour.Properties.ofFullCopy(block1)), block2 -> new BlockItem(block2, new Item.Properties())) : null;
        var blockStairs = registerMainTabBlock(name + "_stairs", blockBase, block1 -> new StairBlock(block1.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(block1)), block2 -> new BlockItem(block2, new Item.Properties()));
        var blockDoor = genDoors ? registerMainTabBlock(name + "_door", blockBase, block1 -> new DoorBlock(blockSetType, BlockBehaviour.Properties.ofFullCopy(block1)), block2 -> new BlockItem(block2, new Item.Properties())) : null;
        var blockTrapDoor = genDoors ? registerMainTabBlock(name + "_trap_door", blockBase, block1 -> new TrapDoorBlock(blockSetType, BlockBehaviour.Properties.ofFullCopy(block1)), block2 -> new BlockItem(block2, new Item.Properties())) : null;
        var blockButton = registerMainTabBlock(name + "_button", blockBase, block1 -> new ButtonBlock(blockSetType, pTicksToStayPressed, BlockBehaviour.Properties.ofFullCopy(block1)), block2 -> new BlockItem(block2, new Item.Properties()));
        var pressurePlate = registerMainTabBlock(name + "_pressure_plate", blockBase, block1 -> new PressurePlateBlock(blockSetType, BlockBehaviour.Properties.ofFullCopy(block1)), block2 -> new BlockItem(block2, new Item.Properties()));

        return BlockType.of(blockBase, blockSlab, blockWall, blockFence, blockGate, blockStairs, blockDoor, blockTrapDoor, blockButton, pressurePlate);
    }

    private static BlockType registerSeaGlass(String name) {
        var blockName = "";
        if (name.isEmpty()) {
            blockName = "sea_glass";
        } else {
            blockName = name + "_sea_glass";
        }
        return registerBlockType(blockName, Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).sound(SoundType.GLASS), false, BlockSetType.IRON, null, 40, true);
    }

    private static <B extends Block, I extends BlockItem> Supplier<B> registerMainTabBlock(String name, Supplier<B> block, Function<Supplier<B>, Supplier<I>> item) {
        var reg = BLOCKS.register(name, block);
        AtlantisGroupInit.addToMainTab(ItemInit.ITEMS.register(name, () -> item.apply(reg).get()));
        return reg;
    }

    private static <B extends Block, C extends Block, I extends BlockItem> Supplier<C> registerMainTabBlock(String name, Supplier<B> block, Function<B, C> blockFunction, Function<C, I> item) {
        var reg = BLOCKS.register(name, () -> blockFunction.apply(block.get()));
        AtlantisGroupInit.addToMainTab(ItemInit
                .ITEMS.register(name, () ->
                        item.apply(reg.get())));
        return reg;
    }

    private static <B extends Block, I extends BlockItem> Supplier<B> registerGylphTabBlock(String name, Supplier<B> block, Function<Supplier<B>, Supplier<I>> item) {
        var reg = BLOCKS.register(name, block);
        AtlantisGroupInit.addToGylphTab(ItemInit.ITEMS.register(name, () -> item.apply(reg).get()));
        return reg;
    }

    public static DeferredHolder<Block, Block> getLinguisticBlock(LinguisticGlyph symbol, DyeColor color) {
        if (color != null) {
            if (symbol != null && symbol != LinguisticGlyph.BLANK) {
                return (DeferredHolder<Block, Block>) DYED_LINGUISTICS.get(symbol).get(color);
            } else {
                return (DeferredHolder<Block, Block>) DYED_LINGUISTICS.get(LinguisticGlyph.BLANK).get(color);
            }
        } else {
            if (symbol != null && symbol != LinguisticGlyph.BLANK) {
                return (DeferredHolder<Block, Block>) NON_LINGUISTICS.get(symbol);
            } else {
                return (DeferredHolder<Block, Block>) NON_LINGUISTICS.get(LinguisticGlyph.BLANK);
            }
        }
    }

    public static void init(IEventBus bus) {
        BLOCKS.register(bus);
    }

    static {
        BiFunction<LinguisticGlyph, DyeColor, Supplier<Block>> blockSupplier = (glyph, dyeColor) -> () -> new GlyphBlock(glyph, dyeColor, BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(1.5f, 6.0f
        ));

        for (LinguisticGlyph symbol : LinguisticGlyph.values()) {
            String name = "linguistic_glyph" + symbol.toString();

            for (DyeColor color : DyeColor.values()) {
                DYED_LINGUISTICS.computeIfAbsent(symbol, c -> new HashMap<>()).put(color, registerLinguisticBlock(color.getSerializedName() + "_" + name, blockSupplier.apply(symbol, color)));
            }

            NON_LINGUISTICS.put(symbol, registerLinguisticBlock(name, blockSupplier.apply(symbol, null)));
        }
    }

    static {
        Function<DyeColor, Supplier<Block>> blockSupplier = (dyeColor) -> () -> new ColoredShellBlock(BlockBehaviour.Properties.of());
        for (DyeColor color : DyeColor.values()) {
            COLORED_SHELL_BLOCKS.put(color, registerBlock(color.getSerializedName() + "_colored_shell_block", blockSupplier.apply(color)));
        }
    }

    static {
        Function<DyeColor, Supplier<Block>> blockSupplier = (dyeColor) -> () -> new CrackedShellBlock(BlockBehaviour.Properties.of());
        for (DyeColor color : DyeColor.values()) {
            CRACKED_SHELL_BLOCKS.put(color, registerBlock(color.getSerializedName() + "_colored_shell_cracked", blockSupplier.apply(color)));
        }
    }

    static {
        Function<DyeColor, Supplier<Block>> blockSupplier = (dyeColor) -> () -> new CrackedShellBlock(BlockBehaviour.Properties.of());
        for (DyeColor color : DyeColor.values()) {
            CRACKED_MOSSY_SHELL_BLOCKS.put(color, registerBlock(color.getSerializedName() + "_colored_shell_cracked_mossy", blockSupplier.apply(color)));
        }
    }

    static {
        Function<DyeColor, Supplier<Block>> blockSupplier = (dyeColor) -> () -> new CrackedShellBlock(BlockBehaviour.Properties.of());
        for (DyeColor color : DyeColor.values()) {
            MOSSY_SHELL_BLOCKS.put(color, registerBlock(color.getSerializedName() + "_colored_shell_mossy", blockSupplier.apply(color)));
        }
    }
}
