package com.mystic.atlantis.mixin;

import com.mystic.atlantis.items.SodiumItem;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {
    @Shadow public abstract Item getItem();

    @Inject(method = "canBeHurtBy", at = @At("RETURN"), cancellable = true)
    public void canBeHurtByLighting(DamageSource arg, CallbackInfoReturnable<Boolean> cir) {
        if (getItem() instanceof SodiumItem) {
            cir.setReturnValue(!(arg.is(DamageTypes.LIGHTNING_BOLT)) || cir.getReturnValue());
        }
    }
}
