package com.mystic.atlantis.config;

import com.mystic.atlantis.util.Reference;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.ConfigHolder;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = Reference.MODID)
public class AtlantisConfig implements ConfigData {

    private static final ConfigHolder<AtlantisConfig> HOLDER = AutoConfig.register(AtlantisConfig.class, Toml4jConfigSerializer::new);

    public static AtlantisConfig getConfig() {
        return HOLDER.get();
    }

    @Comment("Should Islands Generate?")
    public boolean islandsOn = true;
    @Comment("Should Volcanoes Generate?")
    public boolean volcanoesOn = true;
    @Comment("Should Glowstone Crysts Generate?")
    public boolean glowstoneCrystsOn = true;
    @Comment("Minimum Crab Spawn Height")
    @ConfigEntry.BoundedDiscrete(min = -64, max = 320)
    public int minCrabSpawnHeight = 100;
    @Comment("Maximum Crab Spawn Height")
    @ConfigEntry.BoundedDiscrete(min = -64, max = 320)
    public int maxCrabSpawnHeight = 125;
    @Comment("Rate at which Magma Accelerates you")
    @ConfigEntry.BoundedDiscrete(min = 0, max = 100)
    public double magmaAcceleration = 0.1d;
    @Comment("Max Distance that the Push Bubble Columns from Bubble Magma Blocks can go")
    @ConfigEntry.BoundedDiscrete(min = 0, max = 30)
    public int maxDistanceOfPushBubbleColumn = 15;
    @Comment("Max Magma Velocity")
    @ConfigEntry.BoundedDiscrete(min = 0, max = 100)
    public double magmaThreshold = 1.8d;
    @Comment("Start In Atlantis?")
    public boolean startInAtlantis = false;
    @Comment("Should Dimension Wide Water Breathing Be On?")
    public boolean turnOnDimensionalWaterBreathing = true;
    @Comment("Should Dimension Wide Haste Be On?")
    public boolean turnOnDimensionalHaste = true;
    @Comment("How far is visibility in Water?")
    @ConfigEntry.BoundedDiscrete(min = 1, max = 200)
    public double waterVisibility = 120d;
    @Comment("Can Atlantean Cities generate? (Cities are disable for now without config - this does nothing!)")
    public boolean shouldCitiesGenerate = false;
    @Comment("Should Per Biome Lighting for Atlantis be on? (Currently doesn't work!!!)")
    public boolean shouldHavePerBiomeLighting = false;
}