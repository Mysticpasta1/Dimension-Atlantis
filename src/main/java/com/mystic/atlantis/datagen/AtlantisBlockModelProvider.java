package com.mystic.atlantis.datagen;

import com.mystic.atlantis.Atlantis;
import com.mystic.atlantis.blocks.ancient_metal.TrailsGroup;
import com.mystic.atlantis.blocks.ancient_metal.WeatheringMetalBulbBlock;
import com.mystic.atlantis.init.BlockInit;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.function.Consumer;

public class AtlantisBlockModelProvider extends BlockModelProvider {

    public AtlantisBlockModelProvider(PackOutput generator, ExistingFileHelper existingFileHelper) {
        super(generator, "atlantis", existingFileHelper);
    }

    @Override
    protected void registerModels() {
        this.cubeAll(BlockInit.ORICHALCUM_BLOCK);
        this.cubeBottomTop("writing_block", Atlantis.id("block/writing_table_side"), Atlantis.id("block/atlantean_planks"), Atlantis.id("block/writing_table_top"));

        BlockInit.ANCIENT_METALS.values().stream().map(TrailsGroup::bulb).forEach(holder -> {
            cubeAll(holder, "_unlit");
            cubeAll(holder, "_lit");
            cubeAll(holder, "_lit_powered");
            cubeAll(holder, "_unlit_powered");
        });

        BlockInit.ANCIENT_METALS.values().stream().map(TrailsGroup::waxed_bulb).forEach(holder -> {
            cubeAll(holder, "_unlit");
            cubeAll(holder, "_lit");
            cubeAll(holder, "_lit_powered");
            cubeAll(holder, "_unlit_powered");
        });
    }

    private <T extends Block> void cubeAll(DeferredHolder<Block, T> block) {
        this.cubeAll(block.getId().getPath(), blockTexture(block.getId()));
    }

    private <T extends Block> void cubeAll(DeferredHolder<Block, T> block, String name) {
        var texture = block.getId().withSuffix(name);
        this.cubeAll(texture.getPath(), blockTexture(texture));
    }

    private ResourceLocation blockTexture(ResourceLocation loc) {
        if (loc.getPath().contains("waxed")) {
            return ResourceLocation.fromNamespaceAndPath(loc.getNamespace(), "block/" + loc.getPath().replace("waxed_", ""));
        }
        return ResourceLocation.fromNamespaceAndPath(loc.getNamespace(), "block/" + loc.getPath());
    }
}
