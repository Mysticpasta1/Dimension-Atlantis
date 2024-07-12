package com.mystic.atlantis.datagen;

import com.mystic.atlantis.blocks.BlockType;
import com.mystic.atlantis.blocks.SeaGlass;
import com.mystic.atlantis.blocks.base.LinguisticGlyph;
import com.mystic.atlantis.blocks.ancient_metal.TrailsGroup;
import com.mystic.atlantis.init.*;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.RegistryObject;
import org.apache.commons.lang3.text.WordUtils;

//TODO Convert lang to pure data gen in the future. This will complain about duplicates if run without removing the existing en_us.json first
public class AtlantisEnglishLanguageProvider extends LanguageProvider {
    public AtlantisEnglishLanguageProvider(PackOutput generator) {
        super(generator, "atlantis", "en_us");
    }


    /* TODO: NEXT TIME YOU TOUCH THIS READ THIS WATERPICKER!!!
        make all of the translations equal to the ones in the current lang files of en_us.json
        add all of the translations for the items, blocks, etc
        make lang files for other languages that we include at the current moment!
        after this is done then and only then remove lang files from the normal resources folder
    */

    @Override
    protected void addTranslations() {
        this.addBlock(BlockInit.WATERFALL_BLOCK, "Waterfall Block");
        this.addBlock(BlockInit.WAVE_BLOCK);
        this.addBlock(BlockInit.CRYSTAL_TRANSFERENCE, "Crystal Transference");
        this.addBlock(BlockInit.ATLANTEAN_PORTAL_FRAME, "Atlantean Portal Frame");
        this.addBlock(BlockInit.ATLANTIS_CLEAR_PORTAL, "Atlantis Clear Portal");
        this.addBlock(BlockInit.JETSTREAM_WATER_BLOCK, "Jetstream Water Block");
        this.addBlock(BlockInit.SALTY_SEA_WATER_BLOCK, "Salty Sea Water Block");
        this.addBlock(BlockInit.POTTERY_BLOCK_1, "Pottery Block Tuben");
        this.addBlock(BlockInit.POTTERY_BLOCK_2, "Pottery Block Belen");
        this.addBlock(BlockInit.POTTERY_BLOCK_3, "Pottery Block Toper");
        this.addBlock(BlockInit.POTTERY_BLOCK_4, "Pottery Block Snown");
        this.addBlock(BlockInit.POTTERY_BLOCK_5, "Pottery Block Horpen");
        this.addBlock(BlockInit.POTTERY_BLOCK_6, "Pottery Block Celen");
        this.addBlock(BlockInit.POTTERY_BLOCK_7, "Pottery Block Obemo");
        this.addBlock(BlockInit.COCONUT_SLICE, "Coconut Slice");
        this.addBlock(BlockInit.COCONUT, "Coconut");
        this.addBlock(BlockInit.CARVED_COCONUT, "Carved Coconut");
        this.addBlock(BlockInit.SATIRE_LANTERN, "Satire Lantern");
        this.addBlock(BlockInit.PALM_LOG, "Palm Log");
        this.addBlock(BlockInit.STRIPPED_PALM_LOG, "Stripped Palm Log");
        this.addBlock(BlockInit.PALM_PLANKS, "Palm Planks");
        this.addBlock(BlockInit.PALM_BUTTON, "Palm Button");
        this.addBlock(BlockInit.PALM_DOOR, "Palm Door");
        this.addBlock(BlockInit.PALM_FENCE, "Palm Fence");
        this.addBlock(BlockInit.PALM_FENCE_GATE, "Palm Fence Gate");
        this.addBlock(BlockInit.PALM_PRESSURE_PLATE, "Palm Pressure Plate");
        this.addBlock(BlockInit.PALM_SLAB, "Palm Slab");
        this.addBlock(BlockInit.PALM_STAIRS, "Palm Stairs");
        this.addBlock(BlockInit.PALM_TRAPDOOR, "Palm Trapdoor");
 //       this.addBlock(BlockInit.PALM_SIGN, "Palm Sign");

        this.addBlock(BlockInit.PALM_WALL_SIGN, "Palm Wall Sign");
        this.addBlock(BlockInit.STRIPPED_ATLANTEAN_LOG, "Stripped Atlantean Log");
        this.addBlock(BlockInit.ATLANTEAN_BUTTON, "Atlantean Button");
        this.addBlock(BlockInit.ATLANTEAN_DOOR, "Atlantean Door");
        this.addBlock(BlockInit.ATLANTEAN_FENCE, "Atlantean Fence");
        this.addBlock(BlockInit.ATLANTEAN_FENCE_GATE, "Atlantean Fence Gate");
        this.addBlock(BlockInit.ATLANTEAN_PLANKS, "Atlantean Planks");
        this.addBlock(BlockInit.ATLANTEAN_PRESSURE_PLATE, "Atlantean Pressure Plate");
        this.addBlock(BlockInit.ATLANTEAN_SLAB, "Atlantean Slab");
        this.addBlock(BlockInit.ATLANTEAN_STAIRS, "Atlantean Stairs");
        this.addBlock(BlockInit.ATLANTEAN_TRAPDOOR, "Atlantean Trapdoor");
   //     this.addBlock(BlockInit.ATLANTEAN_WALL_SIGN, "Atlantean Wall Sign");
   //     this.addBlock(BlockInit.ATLANTEAN_SIGN, "Atlantean Sign");

        this.addBlock(BlockInit.UNDERWATER_SHROOM_BLOCK, "Underwater Shroom Block");
        this.addBlock(BlockInit.TUBER_UP_BLOCK, "Tuber Up Block");
        this.addBlock(BlockInit.BLUE_LILY_BLOCK, "Blue Lily Block");
        this.addBlock(BlockInit.BURNT_DEEP_BLOCK, "Burnt Deep Block");
        this.addBlock(BlockInit.ANEMONE_BLOCK, "Anemone Block");
        this.addBlock(BlockInit.ANCIENT_DARK_OAK_WOOD_MOSS_TRAPDOOR, "Ancient Dark Oak Wood Moss Trapdoor");
        this.addBlock(BlockInit.ANCIENT_BIRCH_WOOD_MOSS_TRAPDOOR, "Ancient Birch Wood Moss Trapdoor");
        this.addBlock(BlockInit.ANCIENT_SPRUCE_WOOD_MOSS_TRAPDOOR, "Ancient Spruce Wood Moss Trapdoor");
        this.addBlock(BlockInit.ANCIENT_JUNGLE_WOOD_MOSS_TRAPDOOR, "Ancient Jungle Wood Moss Trapdoor");
        this.addBlock(BlockInit.ANCIENT_OAK_WOOD_MOSS_TRAPDOOR, "Ancient Oak Wood Moss Trapdoor");
        this.addBlock(BlockInit.ANCIENT_ACACIA_WOOD_MOSS_TRAPDOOR, "Ancient Acacia Wood Moss Trapdoor");
        this.addBlock(BlockInit.ANCIENT_DARK_OAK_WOOD_MOSS_STAIRS, "Ancient Dark Oak Wood Moss Stairs");
        this.addBlock(BlockInit.ANCIENT_BIRCH_WOOD_MOSS_STAIRS, "Ancient Birch Wood Moss Stairs");
        this.addBlock(BlockInit.ANCIENT_SPRUCE_WOOD_MOSS_STAIRS, "Ancient Spruce Wood Moss Stairs");
        this.addBlock(BlockInit.ANCIENT_JUNGLE_WOOD_MOSS_STAIRS, "Ancient Jungle Wood Moss Stairs");
        this.addBlock(BlockInit.ANCIENT_OAK_WOOD_MOSS_STAIRS, "Ancient Oak Wood Moss Stairs");
        this.addBlock(BlockInit.ANCIENT_ACACIA_WOOD_MOSS_STAIRS, "Ancient Acacia Wood Moss Stairs");
        this.addBlock(BlockInit.ANCIENT_DARK_OAK_WOOD_MOSS_FENCE, "Ancient Dark Oak Wood Moss Fence");
        this.addBlock(BlockInit.ANCIENT_BIRCH_WOOD_MOSS_FENCE, "Ancient Birch Wood Moss Fence");
        this.addBlock(BlockInit.ANCIENT_SPRUCE_WOOD_MOSS_FENCE, "Ancient Spruce Wood Moss Fence");
        this.addBlock(BlockInit.ANCIENT_JUNGLE_WOOD_MOSS_FENCE, "Ancient Jungle Wood Moss Fence");
        this.addBlock(BlockInit.ANCIENT_OAK_WOOD_MOSS_FENCE, "Ancient Oak Wood Moss Fence");
        this.addBlock(BlockInit.ANCIENT_ACACIA_WOOD_MOSS_FENCE, "Ancient Acacia Wood Moss Fence");
        this.addBlock(BlockInit.ANCIENT_DARK_OAK_WOOD_MOSS_DOOR, "Ancient Dark Oak Wood Moss Door");
        this.addBlock(BlockInit.ANCIENT_BIRCH_WOOD_MOSS_DOOR, "Ancient Birch Wood Moss Door");
        this.addBlock(BlockInit.ANCIENT_SPRUCE_WOOD_MOSS_DOOR, "Ancient Spruce Wood Moss Door");
        this.addBlock(BlockInit.ANCIENT_JUNGLE_WOOD_MOSS_DOOR, "Ancient Jungle Wood Moss Door");
        this.addBlock(BlockInit.ANCIENT_OAK_WOOD_MOSS_DOOR, "Ancient Oak Wood Moss Door");
        this.addBlock(BlockInit.ANCIENT_ACACIA_WOOD_MOSS_DOOR, "Ancient Acacia Wood Moss Door");
        this.addBlock(BlockInit.OYSTER_SHELL_BLOCK, "Oyster Shell Block");
        this.addBlock(BlockInit.NAUTILUS_SHELL_BLOCK, "Nautilus Shell Block");
        this.addBlock(BlockInit.OYSTER_SHELL_CRACKED, "Oyster Shell Cracked");
        this.addBlock(BlockInit.NAUTILUS_SHELL_CRACKED, "Nautilus Shell Cracked");
        this.addBlock(BlockInit.OYSTER_SHELL_CRACKED_MOSSY, "Oyster Shell Cracked Mossy");
        this.addBlock(BlockInit.NAUTILUS_SHELL_CRACKED_MOSSY, "Nautilus Shell Cracked Mossy");
        this.addBlock(BlockInit.OYSTER_SHELL_MOSSY, "Oyster Shell Mossy");
        this.addBlock(BlockInit.NAUTILUS_SHELL_MOSSY, "Nautilus Shell Mossy");
        this.addBlock(BlockInit.SODIUM_BOMB, "Sodium Bomb");
        this.addBlock(BlockInit.SEA_SALT_CHUNK, "Sea Salt Chunk");
        this.addBlock(BlockInit.SUNKEN_GRAVEL, "Sunken Gravel");
        this.addBlock(BlockInit.CRACKED_GLOWSTONE, "Cracked Glowstone");
        this.addBlock(BlockInit.DEAD_GLOWSTONE, "Dead Glowstone");
        this.addBlock(BlockInit.ALGAE_DETRITUS_STONE, "Algae Detritus Stone");
        this.addBlock(BlockInit.DETRITUS_SANDSTONE, "Detritus Sandstone");
        this.addBlock(BlockInit.ATLANTEAN_PRISMARINE, "Atlantean Prismarine");
        this.addBlock(BlockInit.BUBBLE_MAGMA, "Bubble Magma");
        this.addBlock(BlockInit.PALM_LEAVES, "Palm Leaves");
        this.addBlock(BlockInit.ATLANTEAN_LEAVES, "Atlantean Leaves");
        this.addBlock(BlockInit.ATLANTEAN_LOGS, "Atlantean Logs");
        this.addBlock(BlockInit.ANCIENT_ACACIA_WOOD_MOSS, "Ancient Acacia Wood Moss");
        this.addBlock(BlockInit.ANCIENT_OAK_WOOD_MOSS, "Ancient Oak Wood Moss");
        this.addBlock(BlockInit.ANCIENT_JUNGLE_WOOD_MOSS, "Ancient Jungle Wood Moss");
        this.addBlock(BlockInit.ANCIENT_SPRUCE_WOOD_MOSS, "Ancient Spruce Wood Moss");
        this.addBlock(BlockInit.ANCIENT_BIRCH_WOOD_MOSS, "Ancient Birch Wood Moss");
        this.addBlock(BlockInit.ANCIENT_DARK_OAK_WOOD_MOSS, "Ancient Dark Oak Wood Moss");
        this.addBlock(BlockInit.AQUAMARINE_ORE, "Aquamarine Ore");
        this.addBlock(BlockInit.AQUAMARINE_DEEPSLATE_ORE, "Aquamarine Deepslate Ore");
        this.addBlock(BlockInit.SEABED, "Seabed");
        this.addBlock(BlockInit.OCEAN_LANTERN, "Ocean Lantern");
        this.addBlock(BlockInit.ATLANTEAN_SEA_LANTERN, "Atlantean Sea Lantern");
        this.addBlock(BlockInit.ATLANTEAN_CORE, "Atlantean Core");
        this.addBlock(BlockInit.BLOCK_OF_AQUAMARINE, "Block Of Aquamarine");
        this.addBlock(BlockInit.CHISELED_GOLDEN_BLOCK, "Chiseled Golden Block");
        this.addBlock(BlockInit.CHISELED_GOLDEN_AQUAMARINE, "Chiseled Golden Aquamarine");
        this.addBlock(BlockInit.BLACK_PEARL_BLOCK, "Black Pearl Block");
        this.addBlock(BlockInit.BLUE_PEARL_BLOCK, "Blue Pearl Block");
        this.addBlock(BlockInit.BROWN_PEARL_BLOCK, "Brown Pearl Block");
        this.addBlock(BlockInit.CYAN_PEARL_BLOCK, "Cyan Pearl Block");
        this.addBlock(BlockInit.GRAY_PEARL_BLOCK, "Gray Pearl Block");
        this.addBlock(BlockInit.GREEN_PEARL_BLOCK, "Green Pearl Block");
        this.addBlock(BlockInit.LIGHT_BLUE_PEARL_BLOCK, "Light Blue Pearl Block");
        this.addBlock(BlockInit.LIGHT_GRAY_PEARL_BLOCK, "Light Gray Pearl Block");
        this.addBlock(BlockInit.LIME_PEARL_BLOCK, "Lime Pearl Block");
        this.addBlock(BlockInit.MAGENTA_PEARL_BLOCK, "Magenta Pearl Block");
        this.addBlock(BlockInit.ORANGE_PEARL_BLOCK, "Orange Pearl Block");
        this.addBlock(BlockInit.PINK_PEARL_BLOCK, "Pink Pearl Block");
        this.addBlock(BlockInit.PURPLE_PEARL_BLOCK, "Purple Pearl Block");
        this.addBlock(BlockInit.RED_PEARL_BLOCK, "Red Pearl Block");
        this.addBlock(BlockInit.WHITE_PEARL_BLOCK, "White Pearl Block");
        this.addBlock(BlockInit.YELLOW_PEARL_BLOCK, "Yellow Pearl Block");
        this.addBlock(BlockInit.ATLANTIS_PORTAL, "Atlantis Portal");
        this.addBlock(BlockInit.UNDERWATER_FLOWER, "Underwater Flower");
        this.addBlock(BlockInit.RED_UNDERWATER_FLOWER, "Red Underwater Flower");
        this.addBlock(BlockInit.PURPLE_GLOWING_MUSHROOM, "Purple Glowing Mushroom");
        this.addBlock(BlockInit.YELLOW_GLOWING_MUSHROOM, "Yellow Glowing Mushroom");
        this.addBlock(BlockInit.YELLOW_UNDERWATER_FLOWER, "Yellow Underwater Flower");
        this.addBlock(BlockInit.ALGAE, "Algae");
        this.addBlock(BlockInit.ATLANTEAN_POWER_STONE, "Atlantean Power Stone");
        this.addBlock(BlockInit.ATLANTEAN_POWER_LAMP, "Atlantean Power Lamp");
        this.addBlock(BlockInit.ATLANTEAN_POWER_TORCH, "Atlantean Power Torch");
        this.addBlock(BlockInit.WALL_ATLANTEAN_POWER_TORCH, "Wall Atlantean Power Torch");
        this.addBlock(BlockInit.ATLANTEAN_POWER_DUST_WIRE, "Atlantean Power Dust Wire");
        this.addBlock(BlockInit.ATLANTEAN_POWER_REPEATER, "Atlantean Power Repeater");
        this.addBlock(BlockInit.ATLANTEAN_TRIPWIRE_HOOK, "Atlantean Tripwire Hook");
        this.addBlock(BlockInit.ATLANTEAN_TRIPWIRE, "Atlantean Tripwire");
        this.addBlock(BlockInit.ATLANTEAN_POWER_LEVER, "Atlantean Power Lever");
        this.addBlock(BlockInit.ATLANTEAN_POWER_COMPARATOR, "Atlantean Power Comparator");
        this.addBlock(BlockInit.CALCITE_BLOCK, "Calcite Block");
        this.addBlock(BlockInit.PUSH_BUBBLE_COLUMN, "Push Bubble Column");
        this.addBlock(BlockInit.ANCIENT_ACACIA_WOOD_MOSS_SLAB, "Ancient Acacia Wood Moss Slab");
        this.addBlock(BlockInit.ANCIENT_OAK_WOOD_MOSS_SLAB, "Ancient Oak Wood Moss Slab");
        this.addBlock(BlockInit.ANCIENT_JUNGLE_WOOD_MOSS_SLAB, "Ancient Jungle Wood Moss Slab");
        this.addBlock(BlockInit.ANCIENT_SPRUCE_WOOD_MOSS_SLAB, "Ancient Spruce Wood Moss Slab");
        this.addBlock(BlockInit.ANCIENT_BIRCH_WOOD_MOSS_SLAB, "Ancient Birch Wood Moss Slab");
        this.addBlock(BlockInit.ANCIENT_DARK_OAK_WOOD_MOSS_SLAB, "Ancient Dark Oak Wood Moss Slab");
        this.addBlock(BlockInit.ALGAE_BLOCK, "Algae Block");
        this.addBlock(BlockInit.CHISELED_AQUAMARINE, "Chiseled Aquamarine");
        this.addBlock(BlockInit.ORICHALCUM_BLOCK, "Orichalcum Block");
        this.addBlock(BlockInit.LINGUISTIC_BLOCK, "Linguistic Block");
        this.addBlock(BlockInit.WRITING_BLOCK, "Writing Block");
        this.addBlock(BlockInit.ATLANTEAN_SAPLING, "Atlantean Sapling");
        this.addBlock(BlockInit.ATLANTEAN_PALM_SAPLING, "Atlantean Palm Sapling");
        this.addBlock(BlockInit.ATLANTEAN_FIRE_MELON_FRUIT_SPIKED, "Atlantean Fire Melon Fruit Spiked");
        this.addBlock(BlockInit.ATLANTEAN_FIRE_MELON_FRUIT, "Atlantean Fire Melon Fruit");
        this.addBlock(BlockInit.ATLANTEAN_FIRE_MELON_STEM, "Atlantean Fire Melon Stem");
        this.addBlock(BlockInit.ATLANTEAN_FIRE_MELON_TOP, "Atlantean Fire Melon Top");

        this.addBlocksFromType(BlockInit.SEA_GLASS, "Sea Glass");
        this.addBlocksFromType(BlockInit.BLUE_SEA_GLASS, "Blue Sea Glass");
        this.addBlocksFromType(BlockInit.RED_SEA_GLASS, "Red Sea Glass");
        this.addBlocksFromType(BlockInit.ORANGE_SEA_GLASS, "Orange Sea Glass");
        this.addBlocksFromType(BlockInit.YELLOW_SEA_GLASS, "Yellow Sea Glass");
        this.addBlocksFromType(BlockInit.GREEN_SEA_GLASS, "Green Sea Glass");
        this.addBlocksFromType(BlockInit.LIME_SEA_GLASS, "Lime Sea Glass");
        this.addBlocksFromType(BlockInit.LIGHT_BLUE_SEA_GLASS, "Light Blue Sea Glass");
        this.addBlocksFromType(BlockInit.LIGHT_GRAY_SEA_GLASS, "Light Gray Sea Glass");
        this.addBlocksFromType(BlockInit.MAGENTA_SEA_GLASS, "Magenta Sea Glass");
        this.addBlocksFromType(BlockInit.PURPLE_SEA_GLASS, "Purple Sea Glass");
        this.addBlocksFromType(BlockInit.PINK_SEA_GLASS, "Pink Sea Glass");
        this.addBlocksFromType(BlockInit.BLACK_SEA_GLASS, "Black Sea Glass");
        this.addBlocksFromType(BlockInit.GRAY_SEA_GLASS, "Gray Sea Glass");
        this.addBlocksFromType(BlockInit.WHITE_SEA_GLASS, "White Sea Glass");
        this.addBlocksFromType(BlockInit.BROWN_SEA_GLASS, "Brown Sea Glass");
        this.addBlocksFromType(BlockInit.CYAN_SEA_GLASS, "Cyan Sea Glass");
        this.addBlocksFromType(BlockInit.MONOCHROMATIC_SEA_GLASS, "Monochromatic Sea Glass");
        this.addBlocksFromType(BlockInit.MULTICOLOR_SEA_GLASS, "Multicolor Sea Glass");
        this.addBlock(BlockInit.COQUINA);

        this.add(ItemInit.ATLANTEAN_AMULET.get(), "Atlantean Amulet");
        this.add(ItemInit.ATLANTEAN_SPEAR.get(), "Atlantean Spear");
        this.add(ItemInit.PALM_BOAT.get(), "Palm Boat");
        this.add(ItemInit.ATLANTEAN_BOAT.get(), "Atlantean Boat");
        this.add(ItemInit.ATLANTEAN_CRAB_EGG.get(), "Atlantean Crab Egg");
        this.add(ItemInit.ATLANTEAN_JELLYFISH_EGG.get(), "Atlantean Jellyfish Egg");
        this.add(ItemInit.ATLANTEAN_SHRIMP_EGG.get(), "Atlantean Shrimp Egg");
        this.add(ItemInit.LEVIATHAN_EGG.get(), "Leviathan Egg");
        this.add(ItemInit.ATLANTEAN_SEAHORSE_EGG.get(), "Atlantean Seahorse Egg");
        this.add(ItemInit.COCONUT_CRAB_EGG.get(), "Coconut Crab Egg");
        this.add(ItemInit.STARFISH_EGG.get(), "Starfish Egg");
        this.add(ItemInit.STARFISH_ZOM_EGG.get(), "Starfish Zom Egg");
        this.addRecord(ItemInit.PANBEE, " LudoCrypt - Panbee");
        this.add(ItemInit.COLUMN_CAVITATION.get(), "Column Cavitation");
        this.add(ItemInit.BROKEN_SHELLS.get(), "Broken Shells");
        this.add(ItemInit.SODIUM_NUGGET.get(), "Sodium Nugget");
        this.add(ItemInit.SEA_SALT.get(), "Sea Salt");
        this.add(ItemInit.FIRE_MELON_JELLY_BOTTLE.get(), "Fire Melon Jelly Bottle");
        this.add(ItemInit.JELLY_BOTTLE.get(), "Jelly Bottle");
        this.add(ItemInit.AQUAMARINE_GEM.get(), "Aquamarine Gem");
        this.add(ItemInit.ORICHALCUM_INGOT.get(), "Orichalcum Ingot");
        this.add(ItemInit.ORICHALCUM_BLEND.get(), "Orichalcum Blend");
        this.add(ItemInit.ORB_OF_ATLANTIS.get(), "Orb Of Atlantis");
        this.add(ItemInit.ATLANTEAN_CRYSTAL.get(), "Atlantean Crystal");
        this.add(ItemInit.OCEAN_STONE.get(), "Ocean Stone");
        this.add(ItemInit.DROP_OF_ATLANTIS.get(), "Drop Of Atlantis");
        this.add(ItemInit.BROWN_WROUGHT_PATCHES.get(), "Brown Wrought Patches");
        this.add(ItemInit.CRAB_LEGS.get(), "Crab Legs");
        this.add(ItemInit.SHRIMP.get(), "Shrimp");
        this.add(ItemInit.COOKED_SHRIMP.get(), "Cooked Shrimp");
        this.add(ItemInit.ATLANTEAN_POWER_DUST.get(), "Atlantean Power Dust");
        this.add(ItemInit.ATLANTEAN_STRING.get(), "Atlantean String");
        this.add(ItemInit.SUBMARINE.get(), "Submarine");
        this.add(ItemInit.WATER_PILL.get(), "Water Pill");
        for(TrailsGroup group : BlockInit.ANCIENT_METALS.values()) {
            this.add(group.block().get(), WordUtils.capitalize(group.block().get().getDescriptionId().replace("block.atlantis.", "").replace("_", " ")));
            this.add(group.chiseled().get(), WordUtils.capitalize(group.chiseled().get().getDescriptionId().replace("block.atlantis.", "").replace("_", " ")));
            this.add(group.cut().get(), WordUtils.capitalize(group.cut().get().getDescriptionId().replace("block.atlantis.", "").replace("_", " ")));
            this.add(group.cutSlab().get(), WordUtils.capitalize(group.cutSlab().get().getDescriptionId().replace("block.atlantis.", "").replace("_", " ")));
            this.add(group.cutStairs().get(), WordUtils.capitalize(group.cutStairs().get().getDescriptionId().replace("block.atlantis.", "").replace("_", " ")));
            this.add(group.trapdoor().get(), WordUtils.capitalize(group.trapdoor().get().getDescriptionId().replace("block.atlantis.", "").replace("_", " ")));
            this.add(group.door().get(), WordUtils.capitalize(group.door().get().getDescriptionId().replace("block.atlantis.", "").replace("_", " ")));
            this.add(group.grate().get(), WordUtils.capitalize(group.grate().get().getDescriptionId().replace("block.atlantis.", "").replace("_", " ")));
            this.add(group.bulb().get(), WordUtils.capitalize(group.bulb().get().getDescriptionId().replace("block.atlantis.", "").replace("_", " ")));
        }

        add("block.atlantis.atlantean_sign", "Atlantean Sign");
        add("block.atlantis.atlantean_wall_sign", "Atlantean Wall Sign");
        add("block.atlantis.palm_wall_sign", "Palm Wall Sign");


        this.add(ItemInit.ATLANTEAN_FIRE_MELON_FRUIT.get(), "Atlantean Fire Melon Fruit");
        this.add(ItemInit.ATLANTEAN_FIRE_MELON_FRUIT_SPIKED.get(), "Atlantean Fire Melon Fruit Spiked");
        this.add(ItemInit.ATLANTEAN_FIRE_MELON_SEEDS.get(), "Atlantean Fire Melon Seeds");
        this.add(ItemInit.ATLANTEAN_FIRE_MELON_SPIKE.get(), "Atlantean Fire Melon Spike");
        this.add(ItemInit.LINGUISTIC_GLYPH_SCROLL.get(), "Linguistic Glyph Scroll");
        this.add(ItemInit.LINGUISTIC_GLYPH_SCROLL_A.get(), "Linguistic Glyph Scroll A");
        this.add(ItemInit.LINGUISTIC_GLYPH_SCROLL_B.get(), "Linguistic Glyph Scroll B");
        this.add(ItemInit.LINGUISTIC_GLYPH_SCROLL_C.get(), "Linguistic Glyph Scroll C");
        this.add(ItemInit.LINGUISTIC_GLYPH_SCROLL_D.get(), "Linguistic Glyph Scroll D");
        this.add(ItemInit.LINGUISTIC_GLYPH_SCROLL_E.get(), "Linguistic Glyph Scroll E");
        this.add(ItemInit.LINGUISTIC_GLYPH_SCROLL_F.get(), "Linguistic Glyph Scroll F");
        this.add(ItemInit.LINGUISTIC_GLYPH_SCROLL_G.get(), "Linguistic Glyph Scroll G");
        this.add(ItemInit.LINGUISTIC_GLYPH_SCROLL_H.get(), "Linguistic Glyph Scroll H");
        this.add(ItemInit.LINGUISTIC_GLYPH_SCROLL_I.get(), "Linguistic Glyph Scroll I");
        this.add(ItemInit.LINGUISTIC_GLYPH_SCROLL_J.get(), "Linguistic Glyph Scroll J");
        this.add(ItemInit.LINGUISTIC_GLYPH_SCROLL_K.get(), "Linguistic Glyph Scroll K");
        this.add(ItemInit.LINGUISTIC_GLYPH_SCROLL_L.get(), "Linguistic Glyph Scroll L");
        this.add(ItemInit.LINGUISTIC_GLYPH_SCROLL_M.get(), "Linguistic Glyph Scroll M");
        this.add(ItemInit.LINGUISTIC_GLYPH_SCROLL_N.get(), "Linguistic Glyph Scroll N");
        this.add(ItemInit.LINGUISTIC_GLYPH_SCROLL_O.get(), "Linguistic Glyph Scroll O");
        this.add(ItemInit.LINGUISTIC_GLYPH_SCROLL_P.get(), "Linguistic Glyph Scroll P");
        this.add(ItemInit.LINGUISTIC_GLYPH_SCROLL_Q.get(), "Linguistic Glyph Scroll Q");
        this.add(ItemInit.LINGUISTIC_GLYPH_SCROLL_R.get(), "Linguistic Glyph Scroll R");
        this.add(ItemInit.LINGUISTIC_GLYPH_SCROLL_S.get(), "Linguistic Glyph Scroll S");
        this.add(ItemInit.LINGUISTIC_GLYPH_SCROLL_T.get(), "Linguistic Glyph Scroll T");
        this.add(ItemInit.LINGUISTIC_GLYPH_SCROLL_U.get(), "Linguistic Glyph Scroll U");
        this.add(ItemInit.LINGUISTIC_GLYPH_SCROLL_V.get(), "Linguistic Glyph Scroll V");
        this.add(ItemInit.LINGUISTIC_GLYPH_SCROLL_W.get(), "Linguistic Glyph Scroll W");
        this.add(ItemInit.LINGUISTIC_GLYPH_SCROLL_X.get(), "Linguistic Glyph Scroll X");
        this.add(ItemInit.LINGUISTIC_GLYPH_SCROLL_Y.get(), "Linguistic Glyph Scroll Y");
        this.add(ItemInit.LINGUISTIC_GLYPH_SCROLL_Z.get(), "Linguistic Glyph Scroll Z");
        this.add(ItemInit.LINGUISTIC_GLYPH_SCROLL_0.get(), "Linguistic Glyph Scroll 0");
        this.add(ItemInit.LINGUISTIC_GLYPH_SCROLL_1.get(), "Linguistic Glyph Scroll 1");
        this.add(ItemInit.LINGUISTIC_GLYPH_SCROLL_2.get(), "Linguistic Glyph Scroll 2");
        this.add(ItemInit.LINGUISTIC_GLYPH_SCROLL_3.get(), "Linguistic Glyph Scroll 3");
        this.add(ItemInit.LINGUISTIC_GLYPH_SCROLL_4.get(), "Linguistic Glyph Scroll 4");
        this.add(ItemInit.LINGUISTIC_GLYPH_SCROLL_5.get(), "Linguistic Glyph Scroll 5");
        this.add(ItemInit.LINGUISTIC_GLYPH_SCROLL_6.get(), "Linguistic Glyph Scroll 6");
        this.add(ItemInit.LINGUISTIC_GLYPH_SCROLL_7.get(), "Linguistic Glyph Scroll 7");
        this.add(ItemInit.LINGUISTIC_GLYPH_SCROLL_8.get(), "Linguistic Glyph Scroll 8");
        this.add(ItemInit.LINGUISTIC_GLYPH_SCROLL_9.get(), "Linguistic Glyph Scroll 9");
        this.add(ItemInit.JETSTREAM_WATER_BUCKET.get(), "Jetstream Water Bucket");
        this.add(ItemInit.SALTY_SEA_WATER_BUCKET.get(), "Salty Sea Water Bucket");
        this.add(ItemInit.CRAB_BUCKET.get(), "Crab Bucket");
        this.add(ItemInit.JELLYFISH_BUCKET.get(), "Jellyfish Bucket");
        this.add(ItemInit.SHRIMP_BUCKET.get(), "Shrimp Bucket");
        this.add(ItemInit.SEAHORSE_BUCKET.get(), "Seahorse Bucket");
        this.add(ItemInit.AXE_AQUAMARINE.get(), "Aquamarine Axe");
        this.add(ItemInit.PICKAXE_AQUAMARINE.get(), "Aquamarine Pickaxe");
        this.add(ItemInit.SHOVEL_AQUAMARINE.get(), "Aquamarine Shovel");
        this.add(ItemInit.HOE_AQUAMARINE.get(), "Aquamarine Hoe");
        this.add(ItemInit.SWORD_AQUAMARINE.get(), "Aquamarine Sword");
        this.add(ItemInit.ORICHALCUM_AXE.get(), "Orichalcum Axe");
        this.add(ItemInit.ORICHALCUM_PICKAXE.get(), "Orichalcum Pickaxe");
        this.add(ItemInit.ORICHALCUM_SHOVEL.get(), "Orichalcum Shovel");
        this.add(ItemInit.ORICHALCUM_HOE.get(), "Orichalcum Hoe");
        this.add(ItemInit.ORICHALCUM_SWORD.get(), "Orichalcum Sword");
        this.add(ItemInit.AQUAMARINE_HELMET.get(), "Aquamarine Helmet");
        this.add(ItemInit.AQUAMARINE_CHESTPLATE.get(), "Aquamarine Chestplate");
        this.add(ItemInit.AQUAMARINE_LEGGINGS.get(), "Aquamarine Leggings");
        this.add(ItemInit.AQUAMARINE_BOOTS.get(), "Aquamarine Boots");
        this.add(ItemInit.BROWN_WROUGHT_HELMET.get(), "Brown Wrought Helmet");
        this.add(ItemInit.BROWN_WROUGHT_CHESTPLATE.get(), "Brown Wrought Chestplate");
        this.add(ItemInit.BROWN_WROUGHT_LEGGINGS.get(), "Brown Wrought Leggings");
        this.add(ItemInit.BROWN_WROUGHT_BOOTS.get(), "Brown Wrought Boots");
        this.add(ItemInit.ORICHALCUM_UPGRADE_SMITHING_TEMPLATE.get(), "Orichalcum Upgrade Smithing Template");
        this.add(ItemInit.ORICHALCUM_HELMET.get(), "Orichalcum Helmet");
        this.add(ItemInit.ORICHALCUM_CHESTPLATE.get(), "Orichalcum Chestplate");
        this.add(ItemInit.ORICHALCUM_LEGGINGS.get(), "Orichalcum Leggings");
        this.add(ItemInit.ORICHALCUM_BOOTS.get(), "Orichalcum Boots");

        this.add(AtlantisEntityInit.PALM_BOAT.get(), "Palm_boat");
        this.add(AtlantisEntityInit.ATLANTEAN_BOAT.get(), "Atlantean_boat");
        this.add(AtlantisEntityInit.CRAB.get(), "Crab");
        this.add(AtlantisEntityInit.COCONUT_CRAB.get(), "Coconut_crab");
        this.add(AtlantisEntityInit.JELLYFISH.get(), "Jellyfish");
        this.add(AtlantisEntityInit.SHRIMP.get(), "Shrimp");
        this.add(AtlantisEntityInit.LEVIATHAN.get(), "Leviathan");
        this.add(AtlantisEntityInit.SEAHORSE.get(), "Seahorse");
        this.add(AtlantisEntityInit.STARFISH.get(), "Starfish");
        this.add(AtlantisEntityInit.ATLANTEAN_ZOMBIE_STARFISH.get(), "Atlantean Zombie Starfish");
        this.add(AtlantisEntityInit.BOMB.get(), "Bomb");
        this.add(AtlantisEntityInit.SUBMARINE.get(), "Submarine");

        this.add("biome.atlantis.atlantean_garden", "Atlantean Garden");
        this.add("biome.atlantis.atlantean_islands_biome", "Atlantean Islands Biome");
        this.add("biome.atlantis.atlantis_biome", "Atlantis Biome");
        this.add("biome.atlantis.coconut_isles", "Coconut Isles");
        this.add("biome.atlantis.goo_lagoons", "Goo Lagoons");
        this.add("biome.atlantis.jellyfish_fields", "Jellyfish Fields");
        this.add("biome.atlantis.volcanic_darksea", "Volcanic Darksea");
        this.add("structure.atlantis.atlantean_village", "Atlantean Village");
        this.add("dimension.atlantis.atlantis", "Atlantis");
        this.add("structure.atlantis.configured_atlantean_city", "Atlantean City");
        this.add("structure.atlantis.configured_atlantean_fountain", "Atlantean Fountain");
        this.add("structure.atlantis.configured_atlantean_house_1", "Atlantean House Variant 1");
        this.add("structure.atlantis.configured_atlantean_house_3", "Atlantean House Variant 3");
        this.add("structure.atlantis.configured_atlantean_spire", "Atlantean Spire");
        this.add("structure.atlantis.configured_atlantean_temple", "Atlantean Temple");
        this.add("structure.atlantis.configured_atlantean_tower", "Atlantean Tower");
        this.add("structure.atlantis.configured_oyster_structure", "Giant Oyster");

        this.add("itemGroup.atlantis.general", "Atlantis");
        this.add("itemGroup.atlantis.glyph", "Atlantean Glyphs");
        this.add("text.autoconfig.atlantis.option.calciteAcceleration", "Calcite Acceleration");
        this.add("text.autoconfig.atlantis.option.calciteThreshold", "Calcite Threshold");
        this.add("text.autoconfig.atlantis.option.general.calciteAcceleration", "Calcite Acceleration");
        this.add("text.autoconfig.atlantis.option.general.calciteAcceleration.@Tooltip", "How fast you start to speed up at. Must reload world for it to work!");
        this.add("text.autoconfig.atlantis.option.general.calciteThreshold", "Calcite Threshold");
        this.add("text.autoconfig.atlantis.option.general.calciteThreshold.@Tooltip", "The maximum speed you can be at. Must reload world for it to work!");
        this.add("text.autoconfig.atlantis.option.islandsOn", "Are islands on?");
        this.add("text.autoconfig.atlantis.option.maxCrabSpawnHeight", "Maximum Crab Spawn Height");
        this.add("text.autoconfig.atlantis.option.maxCrabSpawnHeight.@Tooltip", "The Maximum Height The Atlantean Crab Will Spawn At");
        this.add("text.autoconfig.atlantis.option.minCrabSpawnHeight", "Minimum Crab Spawn Height");
        this.add("text.autoconfig.atlantis.option.minCrabSpawnHeight.@Tooltip", "The Minimum Height The Atlantean Crab Will Spawn At");
        this.add("text.autoconfig.atlantis.option.volcanoesOn", "Are volcanoes on?");
        this.add("text.autoconfig.atlantis.title", "Atlantean Config");
    }

    private void addRecord(RegistryObject<Item> record, String s) {
        addItem(record, "Music Disc");
        add("item." + record.getId().getNamespace() + "." + record.getId().getPath() + ".desc", s);
    }

    private void addBlocksFromType(BlockType type, String base) {
        addBlock(type.block(), base);
        if(type.door() != null) addBlock(type.door(), base + " Door");
        if(type.button() != null) addBlock(type.button(), base + " Button");
        if(type.slab() != null) addBlock(type.slab(), base + " Slab");
        if(type.fence() != null) addBlock(type.fence(), base + " Fence");
        if(type.fenceGate() != null) addBlock(type.fenceGate(), base + "Fence Gate");
        if(type.pressurePlate() != null) addBlock(type.pressurePlate(), base + "Pressure Plate");
        if(type.trapDoor() != null) addBlock(type.trapDoor(), base + " Trapdoor");
        if(type.wall() != null) addBlock(type.wall(), base + " Wall");
    }

    private void addItem(RegistryObject<Item> registryObject) {
        addItem(registryObject, WordUtils.capitalizeFully(registryObject.getId().getPath().replace("_", " ")));
    }

    private void addBlock(RegistryObject<Block> registryObject) {
        addBlock(registryObject, WordUtils.capitalizeFully(registryObject.getId().getPath().replace("_", " ")));
    }


    private void add(RegistryObject<CreativeModeTab> tab, String entry) {
        this.add("itemGroup." + tab.getId().toLanguageKey(), entry);
    }
}
