package com.mystic.atlantis.datagen;

import com.mystic.atlantis.Atlantis;
import com.mystic.atlantis.blocks.BlockType;
import com.mystic.atlantis.blocks.ancient_metal.TrailsGroup;
import com.mystic.atlantis.blocks.ancient_metal.WeatheringMetalBulbBlock;
import com.mystic.atlantis.init.BlockInit;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.PackOutput;
import net.minecraft.data.models.model.ModelLocationUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.ModelFile;

public class AtlantisBlockStateProvider extends AtlantisMainProvider.Proxied {
    public AtlantisBlockStateProvider(AtlantisMainProvider provider) {
        super(provider);
    }

    @Override
    public void registerStatesAndModels() {
        BlockType.getAllFamilies().filter(BlockFamily::shouldGenerateModel).forEach(this::registerBlockFamily);
        BlockInit.ANCIENT_METALS.values().forEach(this::registerTrialGroup);
        this.horizontalBlock(BlockInit.WRITING_BLOCK.get(), new ModelFile.ExistingModelFile(Atlantis.id("block/writing_block"), itemModels().existingFileHelper));
        this.simpleBlock(BlockInit.ORICHALCUM_BLOCK.get());

//        this.simpleBlock(BlockInit.BLACK_PEARL_BLOCK.get());
//        this.simpleBlock(BlockInit.BLUE_PEARL_BLOCK.get());
//        this.simpleBlock(BlockInit.BROWN_PEARL_BLOCK.get());
//        this.simpleBlock(BlockInit.CYAN_PEARL_BLOCK.get());
//        this.simpleBlock(BlockInit.GRAY_PEARL_BLOCK.get());
//        this.simpleBlock(BlockInit.GREEN_PEARL_BLOCK.get());
//        this.simpleBlock(BlockInit.LIGHT_BLUE_PEARL_BLOCK.get());
//        this.simpleBlock(BlockInit.LIGHT_GRAY_PEARL_BLOCK.get());
//        this.simpleBlock(BlockInit.LIME_PEARL_BLOCK.get());
//        this.simpleBlock(BlockInit.MAGENTA_PEARL_BLOCK.get());
//        this.simpleBlock(BlockInit.ORANGE_PEARL_BLOCK.get());
//        this.simpleBlock(BlockInit.PINK_PEARL_BLOCK.get());
//        this.simpleBlock(BlockInit.PURPLE_PEARL_BLOCK.get());
//        this.simpleBlock(BlockInit.RED_PEARL_BLOCK.get());
//        this.simpleBlock(BlockInit.WHITE_PEARL_BLOCK.get());
//        this.simpleBlock(BlockInit.YELLOW_PEARL_BLOCK.get());


    }

    private void registerTrialGroup(TrailsGroup group) {
        registerBlockItem(group.block().get());
        registerBlockItem(group.chiseled().get());
        registerBlockItem(group.cut().get());
        registerSlab(group.cutSlab().get(), group.cut().get());
        registerStairs(group.cutStairs().get(), group.cut().get());
        registerTrapDoor(group.trapdoor().get());
        registerDoor(group.door().get());
        registerBlockItem(group.grate().get());

        registerBulb(group.bulb().get());
    }

    private void registerBulb(WeatheringMetalBulbBlock bulb) {
        var unlit = this.blockTexture(bulb).withSuffix("_unlit");
        var lit = this.blockTexture(bulb).withSuffix("_lit");
        var unlit_powered = this.blockTexture(bulb).withSuffix("_unlit_powered");
        var lit_powered = this.blockTexture(bulb).withSuffix("_lit_powered");


        this.getVariantBuilder(bulb)
                .partialState().with(WeatheringMetalBulbBlock.LIT, false).with(WeatheringMetalBulbBlock.POWERED, false).addModels(new ConfiguredModel(new ModelFile.UncheckedModelFile(unlit)))
                .partialState().with(WeatheringMetalBulbBlock.LIT, false).with(WeatheringMetalBulbBlock.POWERED, true).addModels(new ConfiguredModel(new ModelFile.UncheckedModelFile(unlit_powered)))
                .partialState().with(WeatheringMetalBulbBlock.LIT, true).with(WeatheringMetalBulbBlock.POWERED, false).addModels(new ConfiguredModel(new ModelFile.UncheckedModelFile(lit)))
                .partialState().with(WeatheringMetalBulbBlock.LIT, true).with(WeatheringMetalBulbBlock.POWERED, true).addModels(new ConfiguredModel(new ModelFile.UncheckedModelFile(lit_powered)));
        simpleBlockItem(bulb, new ModelFile.UncheckedModelFile(unlit));
    }

    private void registerBlockFamily(BlockFamily family) {
        registerBlockItem(family.getBaseBlock());
        family.getVariants().keySet().forEach(variant -> processVariant(variant, family));
    }

    private void registerBlockItem(Block block) {
        simpleBlockWithItem(block, cubeAll(block));
    }

    private void processVariant(BlockFamily.Variant variant, BlockFamily family) {
        Block original = family.getBaseBlock();
        Block variantTarget = family.getVariants().get(variant);
        switch (variant) {
            case BUTTON -> registerButton(variantTarget, original);
            case CHISELED, CRACKED, CUT -> simpleBlockWithItem(variantTarget, cubeAll(variantTarget));
            case DOOR -> registerDoor((DoorBlock) variantTarget);
            case FENCE -> registerFence((FenceBlock) variantTarget, original);
            case FENCE_GATE -> registerGate((FenceGateBlock) variantTarget, (FenceBlock) family.get(BlockFamily.Variant.FENCE), original);
            case SIGN -> registerSign((StandingSignBlock) variantTarget, (WallSignBlock) family.get(BlockFamily.Variant.WALL_SIGN), original);
            case SLAB -> registerSlab((SlabBlock) variantTarget, original);
            case STAIRS -> registerStairs((StairBlock) variantTarget, original);
            case PRESSURE_PLATE -> registerPressurePlate((PressurePlateBlock) variantTarget, original);
            case TRAPDOOR -> registerTrapDoor((TrapDoorBlock) variantTarget, original);
            case WALL -> registerWall((WallBlock) variantTarget, original);
        }
    }

    private void registerStairs(StairBlock stairs, Block texturedBlock) {
        ResourceLocation texture = ModelLocationUtils.getModelLocation(texturedBlock);
        stairsBlock(stairs, texture);
        simpleBlockItem(stairs, itemModels().stairs("block/" + key(stairs).getPath(), texture, texture, texture));
    }

    private void registerSlab(SlabBlock slab, Block texturedBlock) {
        ResourceLocation texture = ModelLocationUtils.getModelLocation(texturedBlock);
        slabBlock(slab, texture, texture);
        simpleBlockItem(slab, itemModels().slab("block/" + key(slab).getPath(), texture, texture, texture));
    }

    private void registerWall(WallBlock wall, Block texturedBlock) {
        ResourceLocation texture = ModelLocationUtils.getModelLocation(texturedBlock);
        wallBlock(wall, texture);
        simpleBlockItem(wall, itemModels().wallInventory("block/" + key(wall).getPath(), texture));
    }

    private void registerFence(FenceBlock fence, Block block) {
        ResourceLocation texture;
        if (block == null) texture = ModelLocationUtils.getModelLocation(fence);
        else texture = ModelLocationUtils.getModelLocation(block);

        fenceBlock(fence, texture);
        simpleBlockItem(fence, itemModels().fenceInventory("block/" + key(fence).getPath(), texture));
    }

    private void registerGate(FenceGateBlock gate, FenceBlock fence, Block block) {
        ResourceLocation texture;
        if (block == null)
        {
            ResourceLocation fenceId = key(fence);
            texture = ModelLocationUtils.getModelLocation(fence);
            simpleBlockItem(gate, itemModels().fenceGate("block/" + fenceId.getPath(), texture));
        }
        else
        {
            ResourceLocation gateId = key(gate);
            texture = ModelLocationUtils.getModelLocation(block);
            simpleBlockItem(gate, itemModels().fenceGate("block/" + gateId.getPath(), texture));
        }

        fenceGateBlock(gate, texture);
    }

    private void registerDoor(DoorBlock door) {
        ResourceLocation blockId = key(door);
        doorBlockWithRenderType(door, ResourceLocation.fromNamespaceAndPath(blockId.getNamespace(), "block/" + blockId.getPath() + "_bottom"), ResourceLocation.fromNamespaceAndPath(blockId.getNamespace(), "block/" + blockId.getPath() + "_top"), "cutout");
    }

    private void registerPressurePlate(PressurePlateBlock pressurePlate, Block texturedBlock) {
        ResourceLocation texture = ModelLocationUtils.getModelLocation(texturedBlock);
        pressurePlateBlock(pressurePlate, texture);
        itemModels().pressurePlate(key(pressurePlate).getPath(), texture);
    }

    private void registerButton(Block button, Block texturedBlock) {
        ResourceLocation buttonId = key(button);
        ResourceLocation textureBlockId = key(texturedBlock);

        ResourceLocation texture = new ResourceLocation(textureBlockId.getNamespace(), "block/" + textureBlockId.getPath());
        buttonBlock((ButtonBlock) button, texture);
        itemModels().buttonInventory(buttonId.getPath(), texture);
    }

    private void registerTrapDoor(TrapDoorBlock trapDoor, Block texturedBlock){
        ResourceLocation texture = ModelLocationUtils.getModelLocation(texturedBlock);
        ResourceLocation trapDoorId = key(trapDoor);
        trapdoorBlockWithRenderType(trapDoor, texture,true, "cutout");
        itemModels().trapdoorBottom(trapDoorId.getPath(), texture);
    }

    private void registerTrapDoor(TrapDoorBlock trapDoor) {
         registerTrapDoor(trapDoor, trapDoor);
    }

    private void registerSign(StandingSignBlock sign, WallSignBlock wallsign, Block plank){signBlock(sign, wallsign, blockTexture(plank));}

}
