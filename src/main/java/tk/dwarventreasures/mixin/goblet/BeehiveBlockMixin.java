package tk.dwarventreasures.mixin.goblet;

import tk.dwarventreasures.common.registry.DTObjects;
import tk.dwarventreasures.common.registry.ModTags;
import tk.dwarventreasures.common.util.DTUtil;
import net.minecraft.block.BeehiveBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.CampfireBlock;
import net.minecraft.block.entity.BeehiveBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BeehiveBlock.class)
public abstract class BeehiveBlockMixin {

    @Shadow protected abstract boolean hasBees(World world, BlockPos pos);

    @Shadow protected abstract void angerNearbyBees(World world, BlockPos pos);

    @Shadow public abstract void takeHoney(World world, BlockState state, BlockPos pos, @Nullable PlayerEntity player, BeehiveBlockEntity.BeeState beeState);

    @Shadow public abstract void takeHoney(World world, BlockState state, BlockPos pos);

    @Inject(method = "onUse", at = @At("HEAD"), cancellable = true)
    private void onRightClick(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit, CallbackInfoReturnable<ActionResult> callback) {
        int age = state.get(BeehiveBlock.HONEY_LEVEL);
        boolean dirty = false;
        if (age >= 5) {
            final ItemStack stackInHand = player.getStackInHand(hand);
            if (ModTags.VALID_TO_EMPTY_GOBLET.contains(stackInHand.getItem()) && this.findHoneyGoblet(stackInHand) != null) {
                world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.NEUTRAL, 1.0F, 1.0F);
                DTUtil.switchStack(player, hand, stackInHand, this.findHoneyGoblet(stackInHand));
                dirty = true;
                world.emitGameEvent(player, GameEvent.FLUID_PICKUP, pos);
            }
        }
        if (dirty) {
            if (!CampfireBlock.isLitCampfireInRange(world, pos)) {
                if (this.hasBees(world, pos)) {
                    this.angerNearbyBees(world, pos);
                }
                this.takeHoney(world, state, pos, player, BeehiveBlockEntity.BeeState.EMERGENCY);
            } else {
                this.takeHoney(world, state, pos);
            }
            callback.setReturnValue(ActionResult.success(world.isClient));
        } else {
            callback.setReturnValue(ActionResult.PASS);
        }
    }
    //TODO: find a better way to return these
    private Item findHoneyGoblet(ItemStack inputStack) {
        if (inputStack.isOf(DTObjects.EMPTY_COPPER_GOBLET_ITEM)) {
            return DTObjects.COPPER_GOBLET_OF_HONEY_ITEM;
        } else if (inputStack.isOf(DTObjects.EMPTY_GOLDEN_GOBLET_ITEM)) {
            return DTObjects.GOLDEN_GOBLET_OF_HONEY_ITEM;
        } else if (inputStack.isOf(DTObjects.EMPTY_DEBRIS_GOBLET_ITEM)) {
            return DTObjects.DEBRIS_GOBLET_OF_HONEY_ITEM;
        } else if (inputStack.isOf(DTObjects.EMPTY_NETHERITE_GOBLET_ITEM)) {
            return DTObjects.NETHERITE_GOBLET_OF_HONEY_ITEM;
        } else if (inputStack.isOf(DTObjects.EMPTY_MITHRIL_GOBLET_ITEM)) {
            return DTObjects.MITHRIL_GOBLET_OF_HONEY_ITEM;
        } else if (inputStack.isOf(DTObjects.EMPTY_SILVER_GOBLET_ITEM)) {
            return DTObjects.SILVER_GOBLET_OF_HONEY_ITEM;
        } else if (inputStack.isOf(DTObjects.EMPTY_OCEANIC_GOLD_GOBLET_ITEM)) {
            return DTObjects.OCEANIC_GOLD_GOBLET_OF_HONEY_ITEM;
        } else {
            return null;
        }
    }

}
