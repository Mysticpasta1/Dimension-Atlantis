package com.mystic.atlantis.items;

import com.mystic.atlantis.Atlantis;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.SmithingTemplateItem;

import java.util.List;

public class OrichalcumSmithingTemplateItem extends SmithingTemplateItem {
    private static final Component ORICHALCUM_UPGRADE = Component.translatable(Util.makeDescriptionId("upgrade", Atlantis.id("orichalcum_upgrade"))).withStyle(ChatFormatting.GRAY);
    private static final Component ORICHALCUM_UPGRADE_APPLIES_TO = Component.translatable(Util.makeDescriptionId("item", Atlantis.id("smithing_template.orichalcum_upgrade.applies_to"))).withStyle(ChatFormatting.BLUE);
    private static final Component ORICHALCUM_UPGRADE_INGREDIENTS = Component.translatable(Util.makeDescriptionId("item", Atlantis.id("smithing_template.orichalcum_upgrade.ingredients"))).withStyle(ChatFormatting.BLUE);
    private static final Component ORICHALCUM_UPGRADE_BASE_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", Atlantis.id("smithing_template.orichalcum_upgrade.base_slot_description")));
    private static final Component ORICHALCUM_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", Atlantis.id("smithing_template.orichalcum_upgrade.additions_slot_description")));

    private static final ResourceLocation EMPTY_SLOT_HELMET = ResourceLocation.parse("item/empty_armor_slot_helmet");
    private static final ResourceLocation EMPTY_SLOT_CHESTPLATE = ResourceLocation.parse("item/empty_armor_slot_chestplate");
    private static final ResourceLocation EMPTY_SLOT_LEGGINGS = ResourceLocation.parse("item/empty_armor_slot_leggings");
    private static final ResourceLocation EMPTY_SLOT_BOOTS = ResourceLocation.parse("item/empty_armor_slot_boots");
    private static final ResourceLocation EMPTY_SLOT_HOE = ResourceLocation.parse("item/empty_slot_hoe");
    private static final ResourceLocation EMPTY_SLOT_AXE = ResourceLocation.parse("item/empty_slot_axe");
    private static final ResourceLocation EMPTY_SLOT_SWORD = ResourceLocation.parse("item/empty_slot_sword");
    private static final ResourceLocation EMPTY_SLOT_SHOVEL = ResourceLocation.parse("item/empty_slot_shovel");
    private static final ResourceLocation EMPTY_SLOT_PICKAXE = ResourceLocation.parse("item/empty_slot_pickaxe");
    private static final ResourceLocation EMPTY_SLOT_INGOT = ResourceLocation.parse("item/empty_slot_ingot");
    private static final ResourceLocation EMPTY_SLOT_REDSTONE_DUST = ResourceLocation.parse("item/empty_slot_redstone_dust");
    private static final ResourceLocation EMPTY_SLOT_QUARTZ = ResourceLocation.parse("item/empty_slot_quartz");
    private static final ResourceLocation EMPTY_SLOT_EMERALD = ResourceLocation.parse("item/empty_slot_emerald");
    private static final ResourceLocation EMPTY_SLOT_DIAMOND = ResourceLocation.parse("item/empty_slot_diamond");
    private static final ResourceLocation EMPTY_SLOT_LAPIS_LAZULI = ResourceLocation.parse("item/empty_slot_lapis_lazuli");
    private static final ResourceLocation EMPTY_SLOT_AMETHYST_SHARD = ResourceLocation.parse("item/empty_slot_amethyst_shard");

    public OrichalcumSmithingTemplateItem() {
        super(ORICHALCUM_UPGRADE_APPLIES_TO, ORICHALCUM_UPGRADE_INGREDIENTS, ORICHALCUM_UPGRADE, ORICHALCUM_UPGRADE_BASE_SLOT_DESCRIPTION, ORICHALCUM_UPGRADE_ADDITIONS_SLOT_DESCRIPTION, createOrichalcumUpgradeIconList(), createOrichalcumUpgradeMaterialList());
    }

    private static List<ResourceLocation> createOrichalcumUpgradeIconList() {
        return List.of(EMPTY_SLOT_HELMET, EMPTY_SLOT_SWORD, EMPTY_SLOT_CHESTPLATE, EMPTY_SLOT_PICKAXE, EMPTY_SLOT_LEGGINGS, EMPTY_SLOT_AXE, EMPTY_SLOT_BOOTS, EMPTY_SLOT_HOE, EMPTY_SLOT_SHOVEL);
    }

    private static List<ResourceLocation> createOrichalcumUpgradeMaterialList() {
        return List.of(EMPTY_SLOT_INGOT);
    }
}
