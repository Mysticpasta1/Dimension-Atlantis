//package com.mystic.atlantis.items.tools;
//
//import net.minecraft.network.chat.Component;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.Tier;
//import net.minecraft.world.item.TooltipFlag;
//
//import java.util.List;
//
//public class OrichalcumHammer extends AtlanteanHammerItem{
//    public OrichalcumHammer(Tier pTier, int radius) {
//        super(pTier, radius);
//    }
//
//    @Override
//    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> list, TooltipFlag tooltipFlag) {
//        super.appendHoverText(itemStack, tooltipContext, list, tooltipFlag);
//        list.add(Component.translatable("orichalcum_hammer.description"));
//        list.add(Component.translatable("orichalcum_hammer.tooltip"));
//    }
//}
