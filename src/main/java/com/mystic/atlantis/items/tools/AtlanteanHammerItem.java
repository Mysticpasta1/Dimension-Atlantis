package com.mystic.atlantis.items.tools;

//import com.mystic.atlantis.datagen.EnchantmentInit;
//import net.minecraft.core.BlockPos;
//import net.minecraft.world.entity.LivingEntity;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.Tier;
//import net.minecraft.world.item.enchantment.EnchantmentHelper;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.block.state.BlockState;
//import org.jetbrains.annotations.NotNull;
//import pro.mikey.justhammers.HammerItem;
//
//public class AtlanteanHammerItem extends HammerItem {
//	public static int depth;
//	public AtlanteanHammerItem(Tier pTier, int radius) {
//		super(pTier, radius, depth, 0);
//	}
//
//	public void depthEnchant(Level level, Player player) {
//        if (EnchantmentHelper.getEnchantmentLevel(EnchantmentInit.getEnchantmentHolder(level, EnchantmentInit.DEEPER_DEPTH), player) == 0) {
//			depth = getRadius();
//		} else {
//			depth = 0;
//		}
//	}
//
//	@Override
//	public boolean mineBlock(@NotNull ItemStack stack, @NotNull Level level, @NotNull BlockState state, @NotNull BlockPos pos, @NotNull LivingEntity miningEntity) {
//		if(miningEntity instanceof Player player) {
//			depthEnchant(level, player);
//		}
//		return super.mineBlock(stack, level, state, pos, miningEntity);
//	}
//
//	@Override
//	public void onCraftedBy(@NotNull ItemStack stack, @NotNull Level level, @NotNull Player player) {
//		super.onCraftedBy(stack, level, player);
//		depthEnchant(level, player);
//	}
//
//	@Override
//	public void onUseTick(@NotNull Level level, @NotNull LivingEntity user, @NotNull ItemStack stack, int remainingUseTicks) {
//		super.onUseTick(level, user, stack, remainingUseTicks);
//		if (user instanceof Player player) {
//			depthEnchant(level, player);
//		}
//    }
//}
//