package tk.dwarventreasures.common.block.goblet;


import tk.dwarventreasures.common.registry.ModTags;
import tk.dwarventreasures.common.util.DTUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class EmptiedGobletBlock extends GobletBlock {

    public EmptiedGobletBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        final ItemStack toSwitch = player.getStackInHand(hand);
        if (this.getFilledBlock(player, toSwitch) != null) {
            world.setBlockState(pos, getFilledBlock(player, toSwitch).getDefaultState(), 3);
            if (!switchNonGoblets(toSwitch, player, hand)) {
                this.getEmptyStack(player, hand, toSwitch);
            }
            playEmptyingGobletSound(player);
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }

    private boolean switchNonGoblets(ItemStack toSwitch, PlayerEntity player, Hand hand) {
        if (toSwitch.isOf(Items.LAVA_BUCKET)) {
            DTUtil.switchStack(player, hand, toSwitch, Items.BUCKET);
            return true;
        }
        if (toSwitch.isOf(Items.WATER_BUCKET)) {
            DTUtil.switchStack(player, hand, toSwitch, Items.BUCKET);
            return true;
        }
        if (PotionUtil.getPotion(toSwitch) == Potions.WATER) {
            DTUtil.switchStack(player, hand, toSwitch, Items.GLASS_BOTTLE);
            return true;
        }
        if (toSwitch.isOf(Items.MILK_BUCKET)) {
            DTUtil.switchStack(player, hand, toSwitch, Items.BUCKET);
            return true;
        }
        if (toSwitch.isOf(Items.HONEY_BOTTLE)) {
            DTUtil.switchStack(player, hand, toSwitch, Items.GLASS_BOTTLE);
        }
        return false;
    }

    protected abstract Block getFilledBlock(PlayerEntity player, ItemStack inputStack);

    protected abstract void getEmptyStack(PlayerEntity player, Hand hand, ItemStack toSwitch);

    protected void playEmptyingGobletSound(PlayerEntity player) {
        if (player.getMainHandStack().isIn(ModTags.HONEY_GOBLETS) || player.getMainHandStack().isOf(Items.HONEY_BOTTLE)) {
            player.playSound(SoundEvents.ITEM_HONEY_BOTTLE_DRINK, 1.0F, 1.0F);
        } else {
            player.playSound(SoundEvents.ITEM_BUCKET_EMPTY, 1.0F, 1.0F);
        }
    }
}
