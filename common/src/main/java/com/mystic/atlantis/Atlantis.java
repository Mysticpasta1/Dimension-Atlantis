package com.mystic.atlantis;

import com.google.common.collect.BiMap;
import com.mystic.atlantis.blocks.ancient_metal.WeatheringMetal;
import com.mystic.atlantis.init.*;
import com.mystic.atlantis.items.armor.BasicArmorMaterial;
import com.mystic.atlantis.util.Strippable;
import dev.architectury.event.EventResult;
import dev.architectury.event.events.common.InteractionEvent;
import dev.architectury.event.events.common.LifecycleEvent;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoneycombItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class Atlantis {
    public static void init() {
        onInitialize();

        LifecycleEvent.SETUP.register(new Runnable() {
            @Override
            public void run() {
                Strippable.add(BlockInit.ATLANTEAN_LOGS, BlockInit.STRIPPED_ATLANTEAN_LOG);
            }
        });

        AtlantisModifierInit.init();

        InteractionEvent.RIGHT_CLICK_BLOCK.register(new InteractionEvent.RightClickBlock() {
            @Override
            public EventResult click(Player player, InteractionHand interactionHand, BlockPos blockPos, Direction direction) {
                if(player.level().isClientSide) return EventResult.pass();

                var state = player.level().getBlockState(blockPos);
                var level = player.level();
                var itemStack = player.getItemInHand(interactionHand);

                if(itemStack.getItem() instanceof AxeItem axe && state.getBlock() instanceof WeatheringMetal metal) {
                    Optional<BlockState> optional = evaluateNewBlockState(player.level(), blockPos, player, state);
                    if (optional.isEmpty()) {
                        return EventResult.pass();
                    } else {
                        if (player instanceof ServerPlayer) {
                            CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer)player, blockPos, itemStack);
                        }

                        level.setBlock(blockPos, (BlockState)optional.get(), 11);
                        level.gameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Context.of(player, (BlockState)optional.get()));
                        if (player != null) {
                            itemStack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(interactionHand));
                        }

                        return EventResult.interruptTrue();
                    }
                }

                return EventResult.pass();
            }
        });
    }

    private static Optional<BlockState> evaluateNewBlockState(Level level, BlockPos blockPos, @Nullable Player player, BlockState blockState) {
        Optional<BlockState> optional2 = WeatheringMetal.getPrevious(blockState);
            if (optional2.isPresent()) {
                level.playSound(player, blockPos, SoundEvents.AXE_SCRAPE, SoundSource.BLOCKS, 1.0F, 1.0F);
                level.levelEvent(player, 3005, blockPos, 0);
                return optional2;
            } else {
                Optional<BlockState> optional3 = Optional.ofNullable((Block)((BiMap) HoneycombItem.WAX_OFF_BY_BLOCK.get()).get(blockState.getBlock())).map((block) -> {
                    return block.withPropertiesOf(blockState);
                });
                if (optional3.isPresent()) {
                    level.playSound(player, blockPos, SoundEvents.AXE_WAX_OFF, SoundSource.BLOCKS, 1.0F, 1.0F);
                    level.levelEvent(player, 3004, blockPos, 0);
                    return optional3;
                } else {
                    return Optional.empty();
                }
            }
        }

    public static void onInitialize() {
        BlockInit.init();
        BasicArmorMaterial.init();
        ItemInit.init();
        PaintingVariantsInit.init();
        TileEntityInit.init();
        FluidTypesInit.init();
        AtlantisGroupInit.init();
        FluidInit.init();
        AtlantisEntityInit.init();
        AtlantisSoundEventInit.init();
        EffectsInit.init();
//        EnchantmentInit.init();
        MenuTypeInit.init();
        RecipesInit.init();
        POITypesInit.init();
        DimensionAtlantis.init(bus);
        ModParticleTypes.init(bus);
        FeaturesInit.init(bus);
        AtlantisStructures.init(bus);
    }

    public static ResourceLocation id(String id) {
        return ResourceLocation.fromNamespaceAndPath("atlantis", id);
    }

    //Don't remove needed for legacy portal block!
    public static ResourceKey<Level> getOverworldKey() {
        ResourceLocation OVERWORLD_ID = LevelStem.OVERWORLD.location();
        return ResourceKey.create(Registries.DIMENSION, OVERWORLD_ID);
    }
}
