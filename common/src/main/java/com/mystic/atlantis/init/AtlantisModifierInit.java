package com.mystic.atlantis.init;

import dev.architectury.event.events.common.LootEvent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;

public class AtlantisModifierInit {


	public static void init() {
		LootEvent.MODIFY_LOOT_TABLE.register(new LootEvent.ModifyLootTable() {
			@Override
			public void modifyLootTable(ResourceKey<LootTable> resourceKey, LootEvent.LootTableModificationContext context, boolean b) {
				if(resourceKey.location().equals(ResourceLocation.fromNamespaceAndPath("minecraft", "blocks/seagrass")) || (resourceKey.location().equals(ResourceLocation.fromNamespaceAndPath("minecraft", "blocks/tall_seagrass")))) {
					//TODO: Implement FireMelon dropping from seagrass
				}
			}
		});
	}

//	public static class SeaGrassModifier extends LootModifier {
//		public static final Supplier<MapCodec<SeaGrassModifier>> CODEC = Suppliers.memoize(() -> RecordCodecBuilder.mapCodec(inst -> codecStart(inst)
//				.apply(inst, SeaGrassModifier::new)
//				));
//
//		public SeaGrassModifier(LootItemCondition[] conditionsIn) {
//			super(conditionsIn);
//		}
//
//		@Override
//		public ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
//
//			ItemStack ctxTool = context.getParamOrNull(LootContextParams.TOOL);
//			RandomSource random = context.getRandom();
//			if (ctxTool != null) {
//				int silkTouch = EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.getEnchantmentHolder(context.getLevel(), Enchantments.SILK_TOUCH), ctxTool);
//				if (silkTouch > 0 || ctxTool.getItem() instanceof ShearsItem) {
//					return generatedLoot;
//				}
//			}
//			int bonusLevel = ctxTool != null ? EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.getEnchantmentHolder(context.getLevel(), Enchantments.FORTUNE), ctxTool) : 0;
//			int seedRarity = (int) (0.5f - (bonusLevel * 2));
//			if (seedRarity < 1 || random.nextInt(seedRarity) == 0) {
//				BlockState ctxBlockState = context.getParamOrNull(LootContextParams.BLOCK_STATE);
//				if (ctxBlockState == Blocks.SEAGRASS.defaultBlockState() || ctxBlockState == Blocks.TALL_SEAGRASS.defaultBlockState()) {
//					generatedLoot.add(new ItemStack(ItemInit.ATLANTEAN_FIRE_MELON_SEEDS.get()));
//				}
//			}
//			return generatedLoot;
//		}
//
//		@Override
//		public MapCodec<? extends IGlobalLootModifier> codec() {
//			return CODEC.get();
//		}
//	}
}
