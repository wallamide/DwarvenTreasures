package tk.dwarventreasures.mixin.goblet;


import tk.dwarventreasures.common.util.DTUtil;
import net.minecraft.entity.passive.CowEntity;
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

@Mixin(CowEntity.class)
public abstract class CowEntityMixin extends PassiveEntityMixin{

    @Inject(method = "interactMob", at = @At("HEAD"), cancellable = true)
    private void onInteractMob(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResult> cir) {
        final ItemStack gobletStack = player.getStackInHand(hand);
        if (!this.isBaby() && !DTUtil.getMilkGobletFromInput(gobletStack).isEmpty()) {
           final ItemStack milkGobletStack = ItemUsage.exchangeStack(gobletStack, player, DTUtil.getMilkGobletFromInput(gobletStack));
            player.playSound(SoundEvents.ENTITY_COW_MILK, 1.0F, 1.0F);
            player.setStackInHand(hand, milkGobletStack);
            cir.setReturnValue(ActionResult.success(this.getWorld().isClient));
        }
    }
}
