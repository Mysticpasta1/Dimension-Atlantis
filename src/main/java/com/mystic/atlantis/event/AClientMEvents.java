package com.mystic.atlantis.event;

import com.mystic.atlantis.util.Reference;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Reference.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AClientMEvents {}
