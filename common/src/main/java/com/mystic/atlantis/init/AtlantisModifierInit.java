package com.mystic.atlantis.init;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.mystic.atlantis.util.Reference;
import dev.architectury.event.events.common.LootEvent;
import dev.architectury.registry.registries.DeferredRegister;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryType;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.functions.LootItemFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class AtlantisModifierInit {
	public static final DeferredRegister<LootPoolEntryType> GLM = DeferredRegister.create(Reference.MODID, Registries.LOOT_POOL_ENTRY_TYPE);

	public static final Supplier<LootPoolEntryType> SEEDS_DROP = GLM.register("seeds_drop", new Supplier<LootPoolEntryType>() {
		@Override
		public LootPoolEntryType get() {
			return new LootPoolEntryType(SeaGrassModifier.CODEC);
		}
	});

	public static void init() {
		LootEvent.MODIFY_LOOT_TABLE.register(new LootEvent.ModifyLootTable() {
			@Override
			public void modifyLootTable(ResourceKey<LootTable> key, LootEvent.LootTableModificationContext context, boolean builtin) {
				if(key.equals(Blocks.SEAGRASS.getLootTable()) || key.equals(Blocks.TALL_SEAGRASS.getLootTable())) context.addPool(LootPool.lootPool().add(SeaGrassModifier.create()));
			}
		});

		GLM.register();
	}

	public static class SeaGrassModifier extends LootPoolSingletonContainer {
		public static final MapCodec<SeaGrassModifier> CODEC = RecordCodecBuilder.mapCodec(inst -> SeaGrassModifier.singletonFields(inst).apply(inst, SeaGrassModifier::new));

		public SeaGrassModifier(int i, int j, List<LootItemCondition> list, List<LootItemFunction> list2) {
			super(i, j, list, list2);
		}

		@Override
		protected void createItemStack(Consumer<ItemStack> consumer, LootContext context) {
			ItemStack ctxTool = context.getParamOrNull(LootContextParams.TOOL);
			RandomSource random = context.getRandom();
			if (ctxTool != null) {
				int silkTouch = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SILK_TOUCH, ctxTool);
				if (silkTouch > 0 || ctxTool.getItem() instanceof ShearsItem) {
//					return generatedLoot;
					return;
				}
			}
			int bonusLevel = ctxTool != null ? EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FORTUNE, ctxTool) : 0;
			int seedRarity = (int) (0.5f - (bonusLevel * 2));
			if (seedRarity < 1 || random.nextInt(seedRarity) == 0) {
				BlockState ctxBlockState = context.getParamOrNull(LootContextParams.BLOCK_STATE);
				if (ctxBlockState == Blocks.SEAGRASS.defaultBlockState() || ctxBlockState == Blocks.TALL_SEAGRASS.defaultBlockState()) {
					consumer.accept(new ItemStack(ItemInit.ATLANTEAN_FIRE_MELON_SEEDS.get()));
				}
			}
		}

		@Override
		public LootPoolEntryType getType() {
			return AtlantisModifierInit.SEEDS_DROP.get();
		}

		public static Builder<?> create() {
			return SeaGrassModifier.simpleBuilder(SeaGrassModifier::new);
		}
	}
}
