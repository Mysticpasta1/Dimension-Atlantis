package com.mystic.atlantis.datagen;

import com.mystic.atlantis.Atlantis;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;

public class TemplatePoolInit {

    public static final ResourceKey<StructureTemplatePool> ATLANTEAN_VILLAGE_DECOS = key("atlantean_village/decos");
    public static final ResourceKey<StructureTemplatePool> ATLANTEAN_VILLAGE_HOUSE = key("atlantean_village/house");
    public static final ResourceKey<StructureTemplatePool> ATLANTEAN_VILLAGE_ROADS = key("atlantean_village/roads");
    public static final ResourceKey<StructureTemplatePool> ATLANTEAN_VILLAGE_START = key("atlantean_village/start");
    public static final ResourceKey<StructureTemplatePool> ATLANTEAN_VILLAGE_TERMINATOR = key("atlantean_village/terminator");
    public static final ResourceKey<StructureTemplatePool> ATLANTEAN_FOUNTAIN = key("atlantean_fountain");
    public static final ResourceKey<StructureTemplatePool> ATLANTEAN_SPIRE = key("atlantean_spire");
    public static final ResourceKey<StructureTemplatePool> ATLANTEAN_TEMPLE = key("atlantean_temple");
    public static final ResourceKey<StructureTemplatePool> ATLANTIS_HOUSE_1 = key("atlantis_house_1");
    public static final ResourceKey<StructureTemplatePool> ATLANTIS_HOUSE_3 = key("atlantis_house_3");
    public static final ResourceKey<StructureTemplatePool> ATLANTIS_TOWER = key("atlantis_tower");
    public static final ResourceKey<StructureTemplatePool> OYSTER_STRUCTURE = key("oyster_structure");

    public static ResourceKey<StructureTemplatePool> key(String name) {
        return ResourceKey.create(Registries.TEMPLATE_POOL, Atlantis.id(name));
    }
    public static void bootstrap(BootstrapContext<StructureTemplatePool> context) {
    }
}