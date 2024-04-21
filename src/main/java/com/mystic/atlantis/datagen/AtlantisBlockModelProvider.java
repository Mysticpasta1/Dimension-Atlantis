package com.mystic.atlantis.datagen;

import com.mystic.atlantis.Atlantis;
import com.mystic.atlantis.init.BlockInit;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;

public class AtlantisBlockModelProvider extends BlockModelProvider {

    public AtlantisBlockModelProvider(PackOutput generator, ExistingFileHelper existingFileHelper) {
        super(generator, "atlantis", existingFileHelper);
    }

    @Override
    protected void registerModels() {
        this.cubeAll((DeferredHolder<Block, Block>) BlockInit.ORICHALCUM_BLOCK);
        this.cubeBottomTop("writing_block", Atlantis.id("block/writing_table_side"), Atlantis.id("block/atlantean_planks"), Atlantis.id("block/writing_table_top"));
    }

    private void cubeAll(DeferredHolder<Block, Block> block) {
        this.cubeAll(block.getId().getPath(), blockTexture(block.getId()));
    }

    private ResourceLocation blockTexture(ResourceLocation loc) {
        return new ResourceLocation(loc.getNamespace(), "block/" + loc.getPath());
    }
}
