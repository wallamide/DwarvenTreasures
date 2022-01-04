package tk.dwarventreasures.common.block.goblet;

import tk.dwarventreasures.common.registry.DTObjects;
import tk.dwarventreasures.common.registry.ModTags;
import tk.dwarventreasures.common.util.DTUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public abstract class FilledGobletBlock extends GobletBlock {

    private final Block emptyGobletBlock;
    private final Type type;

    public FilledGobletBlock(Settings settings, Block emptyGobletBlock, Type type) {
        super(settings);
        this.emptyGobletBlock = emptyGobletBlock;
        this.type = type;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (this.type.equals(Type.WATER) || this.type.equals(Type.HONEY)) {
            if (player.getMainHandStack().isOf(Items.BUCKET)) { //You can't take water or honey back with bucket
                return ActionResult.PASS;
            }
        }
        if (this.type.equals(Type.MILK) || this.type.equals(Type.LAVA)) {
            if (player.getMainHandStack().isOf(Items.GLASS_BOTTLE)) {//You can't take lava or milk with bottle glass
                return ActionResult.PASS;
            }
        }

        final ItemStack stackInHand = player.getStackInHand(hand);

        if (ModTags.FILLED_ITEMS.contains(stackInHand.getItem())) {
            return ActionResult.PASS;//filled goblets are not valid to the empty goblets
        }
        final boolean isGoingToDrink = stackInHand.isEmpty();

        if (ModTags.VALID_TO_EMPTY_GOBLET.contains(stackInHand.getItem()) || isGoingToDrink) {
            world.setBlockState(pos, getEmptyGobletBlock().getDefaultState(), 3);
            if (!switchNonGoblets(stackInHand, player, hand)) {
                this.getFilledGobletStack(player, hand, player.getStackInHand(hand));
            }
            if (isGoingToDrink) {
                if (this.type.equals(Type.LAVA)) {
                   DTUtil.onDrinkingLava(player);
                } else {
                    tryToClearStatusEffects(world, player);
                }
                player.playSound(SoundEvents.ENTITY_GENERIC_DRINK, 1.0F, 1.0F);
            } else {
                this.playEmptyingGobletSound(player);
            }
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }

    private boolean switchNonGoblets(ItemStack toSwitch, PlayerEntity player, Hand hand) {
        if (this.type.equals(Type.HONEY)) {
            if (toSwitch.isOf(Items.GLASS_BOTTLE)) {
                DTUtil.switchStack(player, hand, toSwitch, Items.HONEY_BOTTLE);
                return true;
            }
        }
        if (this.type.equals(Type.LAVA)) {
            if (toSwitch.isOf(Items.BUCKET)) {
                DTUtil.switchStack(player, hand, toSwitch, Items.LAVA_BUCKET);
                return true;
            }
        }
        if (toSwitch.isOf(Items.GLASS_BOTTLE)) {
            DTUtil.switchStack(player, hand, toSwitch, Items.POTION.getDefaultStack());
            return true;
        }
        if (toSwitch.isOf(Items.BUCKET)) {
            DTUtil.switchStack(player, hand, toSwitch, Items.MILK_BUCKET);
            return true;
        }
        return false;
    }

    private void tryToClearStatusEffects(World world, PlayerEntity player) {
        if (ModTags.MILK_GOBLETS.contains(this.asItem())) {
            player.clearStatusEffects();
        }
        if (ModTags.HONEY_GOBLETS.contains(this.asItem())) {
            player.removeStatusEffect(StatusEffects.POISON);
            player.eatFood(world, new ItemStack(DTObjects.COPPER_GOBLET_OF_HONEY));
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        switch (this.type) {
            case WATER -> tooltip.add(new TranslatableText("dwarventreasures.tooltip_water").formatted(Formatting.BLUE));
            case MILK -> tooltip.add(new TranslatableText("dwarventreasures.tooltip_milk"));
            case HONEY -> tooltip.add(new TranslatableText("dwarventreasures.tooltip_honey").formatted(Formatting.GOLD));
            case LAVA -> tooltip.add(new TranslatableText("dwarventreasures.tooltip_lava").formatted(Formatting.RED));
        }
    }

    protected void playEmptyingGobletSound(PlayerEntity player) {
        player.playSound(SoundEvents.ITEM_BOTTLE_FILL, 1.0F, 1.0F);
    }

    /**
     * Switches the stack when the player
     * empties a goblet block
     *
     */
    protected abstract void getFilledGobletStack(PlayerEntity player, Hand hand, ItemStack toSwitch);

    public Block getEmptyGobletBlock() {
        return emptyGobletBlock;
    }

    public enum Type {
        WATER, MILK, HONEY, LAVA
    }
}
