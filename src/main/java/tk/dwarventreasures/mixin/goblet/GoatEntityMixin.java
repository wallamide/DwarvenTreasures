package tk.dwarventreasures.mixin.goblet;

import tk.dwarventreasures.common.util.DTUtil;
import net.minecraft.entity.passive.GoatEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GoatEntity.class)
public abstract class GoatEntityMixin extends PassiveEntityMixin {

    @Inject(method = "interactMob", at = @At("HEAD"), cancellable = true)
    private void onGoatInteract(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResult> callback){
        final ItemStack gobletStack = player.getStackInHand(hand);
        if (!this.isBaby() && !DTUtil.getMilkGobletFromInput(gobletStack).isEmpty()) {
            final ItemStack milkGobletStack = ItemUsage.exchangeStack(gobletStack, player, DTUtil.getMilkGobletFromInput(gobletStack));
            player.playSound(SoundEvents.ENTITY_GOAT_MILK, 1.0F, 1.0F);
            player.setStackInHand(hand, milkGobletStack);
            callback.setReturnValue(ActionResult.success(this.getWorld().isClient));
        }
    }
}
