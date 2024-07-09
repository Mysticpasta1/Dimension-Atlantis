package com.mystic.atlantis.init;

import com.mystic.atlantis.blocks.base.LinguisticGlyph;
import com.mystic.atlantis.items.*;
import com.mystic.atlantis.items.armor.BasicArmorMaterial;
import com.mystic.atlantis.items.armor.ItemArmorAtlantis;
import com.mystic.atlantis.items.armor.ItemArmorOrichalcum;
import com.mystic.atlantis.items.armor.ItemArmorWrought;
import com.mystic.atlantis.items.tools.*;
import com.mystic.atlantis.util.Reference;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, Reference.MODID);
    private static final Map<LinguisticGlyph, DeferredHolder<Item, Item>> scrolls = new HashMap<>();

    private static final Item.Properties ATLANTIS_SETTINGS = new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON).stacksTo(1);

    public static final DeferredHolder<Item, Item> ATLANTEAN_AMULET = register("atlantean_amulet", AtlanteanAmuletItem::new);
    public static final DeferredHolder<Item, Item> ATLANTEAN_SPEAR = register("atlantean_spear", properties -> new AtlanteanSpearItem(ToolInit.AQUAMARINE, properties));

    //BOATS
    public static final DeferredHolder<Item, Item> PALM_BOAT = register("palm_boat", properties -> new PalmBoatItem(properties.stacksTo(1)));
    public static final DeferredHolder<Item, Item> ATLANTEAN_BOAT = register("atlantean_boat", properties -> new AtlanteanBoatItem(properties.stacksTo(1)));

    //SPAWN EGGS
    public static final DeferredHolder<Item, Item> ATLANTEAN_CRAB_EGG = register("atlantean_crab_egg",properties -> new SpawnEggItem(AtlantisEntityInit.CRAB.get(), 0x800002, 0xff0f45, properties));
    public static final DeferredHolder<Item, Item> ATLANTEAN_JELLYFISH_EGG = register("atlantean_jellyfish_egg", properties -> new SpawnEggItem(AtlantisEntityInit.JELLYFISH.get(), 0x00458a, 0x0582ff, properties));
    public static final DeferredHolder<Item, Item> ATLANTEAN_SHRIMP_EGG = register("atlantean_shrimp_egg", properties -> new SpawnEggItem(AtlantisEntityInit.SHRIMP.get(), 0xff0000, 0xff8000, properties));
    public static final DeferredHolder<Item, Item> LEVIATHAN_EGG = register("leviathan_egg", properties -> new SpawnEggItem(AtlantisEntityInit.LEVIATHAN.get(), 0x01ddddd, 0xaddedb, properties));

    public static final DeferredHolder<Item, Item> ATLANTEAN_SEAHORSE_EGG = register("atlantean_seahorse_egg", properties -> new SpawnEggItem(AtlantisEntityInit.SEAHORSE.get(), 0xf6eb3e, 0xcfc85b, properties));

    public static final DeferredHolder<Item, Item> COCONUT_CRAB_EGG = register("coconut_crab_egg", properties -> new SpawnEggItem(AtlantisEntityInit.COCONUT_CRAB.get(), 0x800002, 0xff0f45, properties));
    public static final DeferredHolder<Item, Item> STARFISH_EGG = register("atlantean_starfish_egg", properties -> new SpawnEggItem(AtlantisEntityInit.STARFISH.get(), 0xFFA41D, 0xF6E25F, properties));
    public static final DeferredHolder<Item, Item> STARFISH_ZOM_EGG = register("atlantean_starzomfish_egg", properties -> new SpawnEggItem(AtlantisEntityInit.ATLANTEAN_ZOMBIE_STARFISH.get(), 0xFE00F6, 0x00A170, properties));
    //MUSIC DISC
    public static final DeferredHolder<Item, Item> PANBEE = register("panbee", properties -> new Item(ATLANTIS_SETTINGS.jukeboxPlayable(ResourceKey.create(Registries.JUKEBOX_SONG, ResourceLocation.fromNamespaceAndPath(Reference.MODID, "panbee")))));
    public static final DeferredHolder<Item, Item> COLUMN_CAVITATION = register("column_cavitation", properties -> new Item(ATLANTIS_SETTINGS.jukeboxPlayable(ResourceKey.create(Registries.JUKEBOX_SONG, ResourceLocation.fromNamespaceAndPath(Reference.MODID, "column_cavitation")))));

    //ITEMS
    public static final DeferredHolder<Item, Item> PALM_SIGN = register("palm_sign", properties -> new SignItem(properties, BlockInit.PALM_SIGN.get(), BlockInit.PALM_WALL_SIGN.get()));
    public static final DeferredHolder<Item, Item> BROKEN_SHELLS = register("broken_shells", DefaultItem::new);
    public static final DeferredHolder<Item, Item> SODIUM_NUGGET = register("sodium_nugget", SodiumItem::new);
    public static final DeferredHolder<Item, Item> SEA_SALT = register("sea_salt", Item::new);
    public static final DeferredHolder<Item, Item> FIRE_MELON_JELLY_BOTTLE = register("fire_melon_jelly_bottle", FireMelonJellyBottle::new);
    public static final DeferredHolder<Item, Item> JELLY_BOTTLE = register("jellyfish_jelly_bottle", JellyfishJellyBottle::new);
    public static final DeferredHolder<Item, Item> AQUAMARINE_GEM = register("aquamarine_gem", Item::new);
    public static final DeferredHolder<Item, Item> ORICHALCUM_INGOT = register("orichalcum_ingot", Item::new);
    public static final DeferredHolder<Item, Item> ORICHALCUM_BLEND = register("orichalcum_blend", Item::new);
    public static final DeferredHolder<Item, OrbOfAtlantis> ORB_OF_ATLANTIS = register("orb_of_atlantis", OrbOfAtlantis::new);
    public static final DeferredHolder<Item, Item> ATLANTEAN_CRYSTAL = register("atlantean_crystal", AtlanteanCrystal::new);
    public static final DeferredHolder<Item, Item> OCEAN_STONE = register("ocean_stone", DefaultItem::new);
    public static final DeferredHolder<Item, Item> DROP_OF_ATLANTIS = register("drop_of_atlantis", Item::new);
    public static final DeferredHolder<Item, Item> BROWN_WROUGHT_PATCHES = register("brown_wrought_patches", Item::new);
    public static final DeferredHolder<Item, Item> CRAB_LEGS = register("crab_legs", CrabLegsItem::new);
    public static final DeferredHolder<Item, Item> SHRIMP = register("shrimp", properties -> new Item(properties.food(new FoodProperties.Builder().nutrition(5).saturationModifier(0.2f).effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 100), 0.05f).build())));
    public static final DeferredHolder<Item, Item> COOKED_SHRIMP = register("cooked_shrimp", properties -> new Item(properties.food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.4f).build())));
    public static final DeferredHolder<Item, Item> ATLANTEAN_POWER_TORCH = register("atlantean_power_torch", properties -> new StandingAndWallBlockItem(BlockInit.ATLANTEAN_POWER_TORCH.get(), BlockInit.WALL_ATLANTEAN_POWER_TORCH.get(), properties, Direction.DOWN));
    public static final DeferredHolder<Item, Item> ATLANTEAN_POWER_DUST = register("atlantean_power_dust",  properties -> new ItemNameBlockItem(BlockInit.ATLANTEAN_POWER_DUST_WIRE.get(), properties));
    public static final DeferredHolder<Item, Item> ATLANTEAN_STRING = register("atlantean_string",  properties -> new ItemNameBlockItem(BlockInit.ATLANTEAN_TRIPWIRE.get(), properties));
    public static final DeferredHolder<Item, Item> SUBMARINE = register("submarine", properties -> new SubmarineItem(new Item.Properties()));
    public static final DeferredHolder<Item, Item> WATER_PILL = register("water_pill", WaterPill::new);
    public static final DeferredHolder<Item, Item> ATLANTEAN_SIGN = register("atlantean_sign", properties -> new SignItem(properties, BlockInit.ATLANTEAN_SIGN.get(), BlockInit.ATLANTEAN_WALL_SIGN.get()));

    public static final DeferredHolder<Item, Item> ATLANTEAN_FIRE_MELON_FRUIT = register("atlantean_fire_melon_fruit", properties -> new Item(properties.food(new FoodProperties.Builder().nutrition(1).saturationModifier(1).build())));
    public static final DeferredHolder<Item, Item> ATLANTEAN_FIRE_MELON_FRUIT_SPIKED = register("atlantean_fire_melon_fruit_spiked", properties -> new Item(properties.food(new FoodProperties.Builder().nutrition(1).saturationModifier(1).effect(() -> new MobEffectInstance(MobEffects.HARM, 60), 1.0f).build())));

    public static final DeferredHolder<Item, Item> ATLANTEAN_FIRE_MELON_SEEDS = register("atlantean_fire_melon_fruit_seeds",  properties -> new ItemNameBlockItem(BlockInit.ATLANTEAN_FIRE_MELON_TOP.get(), properties));
    public static final DeferredHolder<Item, Item> ATLANTEAN_FIRE_MELON_SPIKE = register("atlantean_fire_melon_spike", Item::new);

    public static final DeferredHolder<Item, Item> LINGUISTIC_GLYPH_SCROLL = registerGlyph(LinguisticGlyph.BLANK);
    public static final DeferredHolder<Item, Item> LINGUISTIC_GLYPH_SCROLL_A = registerGlyph(LinguisticGlyph.A);
    public static final DeferredHolder<Item, Item> LINGUISTIC_GLYPH_SCROLL_B = registerGlyph(LinguisticGlyph.B);
    public static final DeferredHolder<Item, Item> LINGUISTIC_GLYPH_SCROLL_C = registerGlyph(LinguisticGlyph.C);
    public static final DeferredHolder<Item, Item> LINGUISTIC_GLYPH_SCROLL_D = registerGlyph(LinguisticGlyph.D);
    public static final DeferredHolder<Item, Item> LINGUISTIC_GLYPH_SCROLL_E = registerGlyph(LinguisticGlyph.E);
    public static final DeferredHolder<Item, Item> LINGUISTIC_GLYPH_SCROLL_F = registerGlyph(LinguisticGlyph.F);
    public static final DeferredHolder<Item, Item> LINGUISTIC_GLYPH_SCROLL_G = registerGlyph(LinguisticGlyph.G);
    public static final DeferredHolder<Item, Item> LINGUISTIC_GLYPH_SCROLL_H = registerGlyph(LinguisticGlyph.H);
    public static final DeferredHolder<Item, Item> LINGUISTIC_GLYPH_SCROLL_I = registerGlyph(LinguisticGlyph.I);
    public static final DeferredHolder<Item, Item> LINGUISTIC_GLYPH_SCROLL_J = registerGlyph(LinguisticGlyph.J);
    public static final DeferredHolder<Item, Item> LINGUISTIC_GLYPH_SCROLL_K = registerGlyph(LinguisticGlyph.K);
    public static final DeferredHolder<Item, Item> LINGUISTIC_GLYPH_SCROLL_L = registerGlyph(LinguisticGlyph.L);
    public static final DeferredHolder<Item, Item> LINGUISTIC_GLYPH_SCROLL_M = registerGlyph(LinguisticGlyph.M);
    public static final DeferredHolder<Item, Item> LINGUISTIC_GLYPH_SCROLL_N = registerGlyph(LinguisticGlyph.N);
    public static final DeferredHolder<Item, Item> LINGUISTIC_GLYPH_SCROLL_O = registerGlyph(LinguisticGlyph.O);
    public static final DeferredHolder<Item, Item> LINGUISTIC_GLYPH_SCROLL_P = registerGlyph(LinguisticGlyph.P);
    public static final DeferredHolder<Item, Item> LINGUISTIC_GLYPH_SCROLL_Q = registerGlyph(LinguisticGlyph.Q);
    public static final DeferredHolder<Item, Item> LINGUISTIC_GLYPH_SCROLL_R = registerGlyph(LinguisticGlyph.R);
    public static final DeferredHolder<Item, Item> LINGUISTIC_GLYPH_SCROLL_S = registerGlyph(LinguisticGlyph.S);
    public static final DeferredHolder<Item, Item> LINGUISTIC_GLYPH_SCROLL_T = registerGlyph(LinguisticGlyph.T);
    public static final DeferredHolder<Item, Item> LINGUISTIC_GLYPH_SCROLL_U = registerGlyph(LinguisticGlyph.U);
    public static final DeferredHolder<Item, Item> LINGUISTIC_GLYPH_SCROLL_V = registerGlyph(LinguisticGlyph.V);
    public static final DeferredHolder<Item, Item> LINGUISTIC_GLYPH_SCROLL_W = registerGlyph(LinguisticGlyph.W);
    public static final DeferredHolder<Item, Item> LINGUISTIC_GLYPH_SCROLL_X = registerGlyph(LinguisticGlyph.X);
    public static final DeferredHolder<Item, Item> LINGUISTIC_GLYPH_SCROLL_Y = registerGlyph(LinguisticGlyph.Y);
    public static final DeferredHolder<Item, Item> LINGUISTIC_GLYPH_SCROLL_Z = registerGlyph(LinguisticGlyph.Z);
    public static final DeferredHolder<Item, Item> LINGUISTIC_GLYPH_SCROLL_0 = registerGlyph(LinguisticGlyph.ZERO);
    public static final DeferredHolder<Item, Item> LINGUISTIC_GLYPH_SCROLL_1 = registerGlyph(LinguisticGlyph.ONE);
    public static final DeferredHolder<Item, Item> LINGUISTIC_GLYPH_SCROLL_2 = registerGlyph(LinguisticGlyph.TWO);
    public static final DeferredHolder<Item, Item> LINGUISTIC_GLYPH_SCROLL_3 = registerGlyph(LinguisticGlyph.THREE);
    public static final DeferredHolder<Item, Item> LINGUISTIC_GLYPH_SCROLL_4 = registerGlyph(LinguisticGlyph.FOUR);
    public static final DeferredHolder<Item, Item> LINGUISTIC_GLYPH_SCROLL_5 = registerGlyph(LinguisticGlyph.FIVE);
    public static final DeferredHolder<Item, Item> LINGUISTIC_GLYPH_SCROLL_6 = registerGlyph(LinguisticGlyph.SIX);
    public static final DeferredHolder<Item, Item> LINGUISTIC_GLYPH_SCROLL_7 = registerGlyph(LinguisticGlyph.SEVEN);
    public static final DeferredHolder<Item, Item> LINGUISTIC_GLYPH_SCROLL_8 = registerGlyph(LinguisticGlyph.EIGHT);
    public static final DeferredHolder<Item, Item> LINGUISTIC_GLYPH_SCROLL_9 = registerGlyph(LinguisticGlyph.NINE);

    //Fluid Buckets
    public static final DeferredHolder<Item, BucketItem> JETSTREAM_WATER_BUCKET = ITEMS.register("jetstream_water_bucket", () -> new BucketItem(FluidInit.JETSTREAM_WATER.get(),
                    new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final DeferredHolder<Item, BucketItem> SALTY_SEA_WATER_BUCKET = ITEMS.register("salty_sea_water_bucket",
            () -> new BucketItem(FluidInit.SALTY_SEA_WATER.get(),
                    new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    //public static final Supplier<Item> COCONUT_MILK_BUCKET = ITEMS.register("coconut_milk_bucket",
    //        () -> new BucketItem(FluidInit.COCONUT_MILK,
    //                new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    //Entity Buckets
    public static final DeferredHolder<Item, Item> CRAB_BUCKET = register("crab_bucket", properties -> new CrabEntityBucketItem(AtlantisEntityInit.CRAB, ()->Fluids.WATER, ()->SoundEvents.BUCKET_EMPTY_FISH, properties.stacksTo(1)));
    public static final DeferredHolder<Item, Item> JELLYFISH_BUCKET = register("jellyfish_bucket", properties -> new AtlanteanEntityBucketItem(AtlantisEntityInit.JELLYFISH, ()->Fluids.WATER, ()->SoundEvents.BUCKET_EMPTY_FISH, properties.stacksTo(1)));
    public static final DeferredHolder<Item, Item> SHRIMP_BUCKET = register("shrimp_bucket", properties -> new AtlanteanEntityBucketItem(AtlantisEntityInit.SHRIMP, ()->Fluids.WATER, ()->SoundEvents.BUCKET_EMPTY_FISH, properties.stacksTo(1)));
    public static final DeferredHolder<Item, Item> SEAHORSE_BUCKET = register("seahorse_bucket", properties -> new AtlanteanEntityBucketItem(AtlantisEntityInit.SEAHORSE, ()->Fluids.WATER, ()-> SoundEvents.BUCKET_EMPTY_FISH, properties.stacksTo(1)));

    //TOOLS
    public static final DeferredHolder<Item, Item> AXE_AQUAMARINE = register("axe_aquamarine", properties -> new AquamarineAxe(ToolInit.AQUAMARINE, properties));
    public static final DeferredHolder<Item, Item> PICKAXE_AQUAMARINE = register("pickaxe_aquamarine", properties -> new AquamarinePickaxe(ToolInit.AQUAMARINE, properties));
    public static final DeferredHolder<Item, Item> SHOVEL_AQUAMARINE = register("shovel_aquamarine", properties -> new AquamarineShovel(ToolInit.AQUAMARINE, properties));
    public static final DeferredHolder<Item, Item> HOE_AQUAMARINE = register("hoe_aquamarine", properties -> new AquamarineHoe(ToolInit.AQUAMARINE, properties));
    public static final DeferredHolder<Item, Item> SWORD_AQUAMARINE = register("sword_aquamarine", properties -> new AquamarineSword(ToolInit.AQUAMARINE, properties));
    public static final DeferredHolder<Item, Item> ORICHALCUM_AXE = register("orichalcum_axe", properties -> new AquamarineAxe(ToolInit.ORICHAClUM, properties));
    public static final DeferredHolder<Item, Item> ORICHALCUM_PICKAXE = register("orichalcum_pickaxe", properties -> new AquamarinePickaxe(ToolInit.ORICHAClUM, properties));
    public static final DeferredHolder<Item, Item> ORICHALCUM_SHOVEL = register("orichalcum_shovel", properties -> new AquamarineShovel(ToolInit.ORICHAClUM, properties));
    public static final DeferredHolder<Item, Item> ORICHALCUM_HOE = register("orichalcum_hoe", properties -> new AquamarineHoe(ToolInit.ORICHAClUM, properties));
    public static final DeferredHolder<Item, Item> ORICHALCUM_SWORD = register("orichalcum_sword", properties -> new AquamarineSword(ToolInit.ORICHAClUM, properties));

    //ARMOR
    public static final DeferredHolder<Item, ItemArmorAtlantis> AQUAMARINE_HELMET = register("aquamarine_helmet", properties -> new ItemArmorAtlantis(BasicArmorMaterial.ARMOR_AQUAMARINE, ArmorItem.Type.HELMET, properties));
    public static final DeferredHolder<Item, ItemArmorAtlantis> AQUAMARINE_CHESTPLATE = register("aquamarine_chestplate", properties -> new ItemArmorAtlantis(BasicArmorMaterial.ARMOR_AQUAMARINE, ArmorItem.Type.CHESTPLATE, properties));
    public static final DeferredHolder<Item, ItemArmorAtlantis> AQUAMARINE_LEGGINGS= register("aquamarine_leggings", properties -> new ItemArmorAtlantis(BasicArmorMaterial.ARMOR_AQUAMARINE, ArmorItem.Type.LEGGINGS, properties));
    public static final DeferredHolder<Item, ItemArmorAtlantis> AQUAMARINE_BOOTS = register("aquamarine_boots", properties -> new ItemArmorAtlantis(BasicArmorMaterial.ARMOR_AQUAMARINE, ArmorItem.Type.BOOTS, properties));
    public static final DeferredHolder<Item, ItemArmorWrought> BROWN_WROUGHT_HELMET = register("brown_wrought_helmet", properties -> new ItemArmorWrought(BasicArmorMaterial.ARMOR_BROWN_WROUGHT, ArmorItem.Type.HELMET, properties));
    public static final DeferredHolder<Item, ItemArmorWrought> BROWN_WROUGHT_CHESTPLATE = register("brown_wrought_chestplate", properties -> new ItemArmorWrought(BasicArmorMaterial.ARMOR_BROWN_WROUGHT, ArmorItem.Type.CHESTPLATE, properties));
    public static final DeferredHolder<Item, ItemArmorWrought> BROWN_WROUGHT_LEGGINGS= register("brown_wrought_leggings", properties -> new ItemArmorWrought(BasicArmorMaterial.ARMOR_BROWN_WROUGHT, ArmorItem.Type.LEGGINGS, properties));
    public static final DeferredHolder<Item, ItemArmorWrought> BROWN_WROUGHT_BOOTS = register("brown_wrought_boots", properties -> new ItemArmorWrought(BasicArmorMaterial.ARMOR_BROWN_WROUGHT, ArmorItem.Type.BOOTS, properties));
    public static final DeferredHolder<Item, OrichalcumSmithingTemplateItem> ORICHALCUM_UPGRADE_SMITHING_TEMPLATE = register("orichalcum_upgrade_smithing_template", OrichalcumSmithingTemplateItem::new);

    public static final DeferredHolder<Item, ItemArmorOrichalcum> ORICHALCUM_HELMET = register("orichalcum_helmet", properties -> new ItemArmorOrichalcum(BasicArmorMaterial.ARMOR_ORICHALCUM, ArmorItem.Type.HELMET, properties));
    public static final DeferredHolder<Item, ItemArmorOrichalcum> ORICHALCUM_CHESTPLATE = register("orichalcum_chestplate", properties -> new ItemArmorOrichalcum(BasicArmorMaterial.ARMOR_ORICHALCUM, ArmorItem.Type.CHESTPLATE, properties));
    public static final DeferredHolder<Item, ItemArmorOrichalcum> ORICHALCUM_LEGGINGS= register("orichalcum_leggings", properties -> new ItemArmorOrichalcum(BasicArmorMaterial.ARMOR_ORICHALCUM, ArmorItem.Type.LEGGINGS, properties));
    public static final DeferredHolder<Item, ItemArmorOrichalcum> ORICHALCUM_BOOTS = register("orichalcum_boots", properties -> new ItemArmorOrichalcum(BasicArmorMaterial.ARMOR_ORICHALCUM, ArmorItem.Type.BOOTS, properties));

    public static <T extends Item> DeferredHolder<Item, T> register(String name, Function<Item.Properties, T> item) {
        var register = ITEMS.register(name, () -> item.apply(new Item.Properties()));
        AtlantisGroupInit.addToMainTabItems(register);
        return register;
    }

    public static <T extends Item> DeferredHolder<Item, T> registerToGlyph(String name, Supplier<T> item) {
        var register = ITEMS.register(name, item);
        AtlantisGroupInit.addToGylphTabItems(register);
        return register;
    }

    //S and N are used in shader stuff so do them in a special way
    static DeferredHolder<Item, Item> registerGlyph(LinguisticGlyph symbol) {
        if(symbol == LinguisticGlyph.S || symbol == LinguisticGlyph.N) {
            DeferredHolder<Item, Item> holder = registerToGlyph("linguistic_glyph" + symbol.toString() +"_scroll", () -> new LinguisticGlyphScrollItem(symbol));
            scrolls.put(symbol, holder);
            return holder;
        }

        DeferredHolder<Item, Item> holder = registerToGlyph("linguistic_glyph_scroll" + symbol.toString(), () -> new LinguisticGlyphScrollItem(symbol));
        scrolls.put(symbol, holder);
        return holder;
    }
    
    public static Supplier<Item> getScroll(LinguisticGlyph a) {
        return scrolls.get(a);
    }

    public static List<Item> getScrolls() {
        return scrolls.values().stream().map(Supplier::get).toList();
    }
    
    public static void init(IEventBus bus) {
        ITEMS.register(bus);
    }
}
