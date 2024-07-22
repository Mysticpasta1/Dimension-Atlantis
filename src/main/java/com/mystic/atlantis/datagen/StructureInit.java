package com.mystic.atlantis.datagen;

import com.mystic.atlantis.Atlantis;
import com.mystic.atlantis.TagsInit;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.Structure;

public class StructureInit {
    public static final ResourceKey<Structure> ATLANTEAN_VILLAGE = key("atlantean_village");
    public static final ResourceKey<Structure> CONFIGURED_ATLANTEAN_FOUNTAIN = key("configured_atlantean_fountain");
    public static final ResourceKey<Structure> CONFIGURED_ATLANTEAN_HOUSE_1 = key("configured_atlantean_house_1");
    public static final ResourceKey<Structure> CONFIGURED_ATLANTEAN_HOUSE_3 = key("configured_atlantean_house_3");
    public static final ResourceKey<Structure> CONFIGURED_ATLANTEAN_SPIRE = key("configured_atlantean_spire");
    public static final ResourceKey<Structure> CONFIGURED_ATLANTEAN_TEMPLE = key("configured_atlantean_temple");
    public static final ResourceKey<Structure> CONFIGURED_ATLANTEAN_TOWER = key("configured_atlantean_tower");
    public static final ResourceKey<Structure> CONFIGURED_OYSTER_STRUCTURE = key("configured_oyster_structure");

    private static ResourceKey<Structure> key(String name) {
        return ResourceKey.create(Registries.STRUCTURE, Atlantis.id(name));
    }

    public StructureInit(BootstrapContext<Structure> context) {
        TagsInit.init();
        context.register(ATLANTEAN_VILLAGE)
    }
}
