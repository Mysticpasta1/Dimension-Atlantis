package com.mystic.atlantis.items.tools;

import com.mystic.atlantis.util.ToolHarvestLogic;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class AtlanteanHammerItem extends PickaxeItem {

	private final int size;
	private final ResourceKey<Enchantment> enchantment;

	public AtlanteanHammerItem(Tier pTier, int attack, int size, ResourceKey<Enchantment> enchantment) {
		super(pTier, new Properties().attributes(createAttributes(pTier, attack, -3.2f)).durability(pTier.getUses()).stacksTo(1));
		this.size = size;
		this.enchantment = enchantment;
	}

	@Override
	public boolean canAttackBlock(BlockState state, Level level, BlockPos pos, Player player) {
		var stack = player.getMainHandItem();
		return stack.getCount() > 1 || ToolHarvestLogic.handleBlockBreak(stack, state, level, pos, player);
	}

	public int size() {
		return size;
	}

	public ResourceKey<Enchantment> enchantment() {
		return enchantment;
	}
}
