package tk.dwarventreasures.common.item.goblet;

import tk.dwarventreasures.common.registry.DTObjects;
import tk.dwarventreasures.common.registry.ModTags;
import tk.dwarventreasures.common.util.DTUtil;
import net.minecraft.block.Block;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class FilledGobletItem extends BlockItem {

    private final Item emptyGoblet;
    private final boolean honey;

    public FilledGobletItem(Block block, Settings settings, Item emptyGoblet, boolean honey) {
        super(block, settings);
        this.emptyGoblet = emptyGoblet;
        this.honey = honey;
    }

    public FilledGobletItem(Block block, Settings settings, Item emptyGoblet) {
        this(block, settings, emptyGoblet, false);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        final Item item = stack.getItem();

        if (this.honey) {
            super.finishUsing(stack, world, user);
            if (ModTags.HONEY_GOBLETS.contains(item)) {
                user.removeStatusEffect(StatusEffects.POISON);
            }
        }
        if (ModTags.MILK_GOBLETS.contains(item)) {
            user.clearStatusEffects();
        }
        if (item == DTObjects.DEBRIS_GOBLET_OF_LAVA_ITEM || item == DTObjects.NETHERITE_GOBLET_OF_LAVA_ITEM) {
            DTUtil.onDrinkingLava((PlayerEntity) user);
        }
        final PlayerEntity playerEntity = user instanceof PlayerEntity ? (PlayerEntity) user : null;
        return emptyGoblet(playerEntity, user, stack, world);
    }


    private ItemStack emptyGoblet(PlayerEntity playerEntity, LivingEntity user, ItemStack filledGoblet, World world) {
        if (playerEntity != null) {
            if (!playerEntity.getAbilities().creativeMode) {
                filledGoblet.decrement(1);
            }
        }
        if (playerEntity == null || !playerEntity.getAbilities().creativeMode) {
            if (filledGoblet.isEmpty()) {
                return getEmptyGoblet();
            }
            if (playerEntity != null) {
                playerEntity.getInventory().insertStack(getEmptyGoblet());
            }
        }
        world.emitGameEvent(user, GameEvent.DRINKING_FINISH, user.getCameraBlockPos());
        return filledGoblet;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        return Items.POTION.use(world, user, hand);
    }

    @Override
    public SoundEvent getDrinkSound() {
        if (this.honey) {
            return Items.HONEY_BOTTLE.getDrinkSound();
        }
        return super.getDrinkSound();
    }

    @Override
    public SoundEvent getEatSound() {
        if (this.honey) {
            return Items.HONEY_BOTTLE.getEatSound();
        }
        return super.getEatSound();
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return Items.POTION.getUseAction(stack);
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        if (this.honey) {
            return Items.HONEY_BOTTLE.getMaxUseTime(stack);
        }
        return Items.POTION.getMaxUseTime(stack);
    }

    public ItemStack getEmptyGoblet() {
        return new ItemStack(this.emptyGoblet);
    }

}
