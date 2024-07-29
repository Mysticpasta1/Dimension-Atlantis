package com.mystic.atlantis.datagen;

import com.mystic.atlantis.Atlantis;
import com.mystic.atlantis.blocks.ancient_metal.TrailsGroup;
import com.mystic.atlantis.init.BlockInit;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class AtlantisBlockModelProvider extends BlockModelProvider {

    public AtlantisBlockModelProvider(PackOutput generator, ExistingFileHelper existingFileHelper) {
        super(generator, "atlantis", existingFileHelper);
    }

    @Override
    protected void registerModels() {
        this.cubeAll(BlockInit.ORICHALCUM_BLOCK);
        this.cube("writing_block",
                Atlantis.id("block/writing_table_top"),
                Atlantis.id("block/linguistic_table_bottom"),
                Atlantis.id("block/writing_table_side"),
                Atlantis.id("block/writing_table_side_1"),
                Atlantis.id("block/writing_table_side_0"),
                Atlantis.id("block/writing_table_side_2"));

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

    private <T extends Block> void cubeAll(RegistryObject<T> block) {
        this.cubeAll(block.getId().getPath(), blockTexture(block.getId()));
    }

    private <T extends Block> void cubeAll(RegistryObject<T> block, String name) {
        var texture = block.getId().withSuffix(name);
        this.cubeAll(texture.getPath(), blockTexture(texture));
    }

    private ResourceLocation blockTexture(ResourceLocation loc) {
        if (loc.getPath().contains("waxed")) {
            return new ResourceLocation(loc.getNamespace(), "block/" + loc.getPath().replace("waxed_", ""));
        }
        return new ResourceLocation(loc.getNamespace(), "block/" + loc.getPath());
    }
}
