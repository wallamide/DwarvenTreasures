package tk.dwarventreasures.common.util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.util.Hand;
import tk.dwarventreasures.common.registry.DTDamageSources;
import tk.dwarventreasures.common.registry.DTObjects;

public class DTUtil {

    /**
     * Useful to easily switch the stack the player is holding
     * with the new stack you specify
     * @param player player you want to switch the stack
     * @param hand player's hand
     * @param toSwitch the stack you want to switch
     * @param newItem the new item which is going to be set on player's hand
     */
    public static void switchStack(PlayerEntity player, Hand hand, ItemStack toSwitch, Item newItem) {
       final ItemStack finalStack = ItemUsage.exchangeStack(toSwitch, player, new ItemStack(newItem));
       player.setStackInHand(hand, finalStack);
    }
    /**
     * Overloaded method
     * Useful to easily switch the stack the player is holding
     * with the new item you specify
     * @param player player you want to switch the stack
     * @param hand player's hand
     * @param toSwitch the stack you want to switch
     * @param newStack the new item which is going to be set on player's hand
     */
    public static void switchStack(PlayerEntity player, Hand hand, ItemStack toSwitch, ItemStack newStack) {
        final ItemStack finalStack = ItemUsage.exchangeStack(toSwitch, player, newStack);
        player.setStackInHand(hand, finalStack);
    }

    /**
     * Called everytime a player tries to drink lava
     * from a debris or netherite goblet
     * @param player who is drinking lava
     */
    public static void onDrinkingLava(PlayerEntity player) {
        player.getHungerManager().add(1, 0);

        if (!player.isFireImmune()) {
            player.setOnFireFor(10);
            player.damage(DTDamageSources.DRINKING_LAVA, 10);
        }
    }
    /**
     * Used on entity mixins
     * @param inputStack empty goblet-
     * @return the matched milk goblet
     */
    //TODO: FIND A BETTER WAY TO RETURN THESE
    public static ItemStack getMilkGobletFromInput(ItemStack inputStack) {
        if (inputStack.isOf(DTObjects.EMPTY_COPPER_GOBLET_ITEM)) {
            return new ItemStack(DTObjects.COPPER_GOBLET_OF_MILK_ITEM);
        } else if (inputStack.isOf(DTObjects.EMPTY_GOLDEN_GOBLET_ITEM)) {
            return new ItemStack(DTObjects.GOLDEN_GOBLET_OF_MILK_ITEM);
        } else if (inputStack.isOf(DTObjects.EMPTY_DEBRIS_GOBLET_ITEM)) {
            return new ItemStack(DTObjects.DEBRIS_GOBLET_OF_MILK_ITEM);
        } else if (inputStack.isOf(DTObjects.EMPTY_NETHERITE_GOBLET_ITEM)) {
            return new ItemStack(DTObjects.NETHERITE_GOBLET_OF_MILK_ITEM);
        } else if (inputStack.isOf(DTObjects.EMPTY_MITHRIL_GOBLET_ITEM)) {
            return new ItemStack(DTObjects.MITHRIL_GOBLET_OF_MILK_ITEM);
        } else if (inputStack.isOf(DTObjects.EMPTY_SILVER_GOBLET_ITEM)) {
            return new ItemStack(DTObjects.SILVER_GOBLET_OF_MILK_ITEM);
        } else if (inputStack.isOf(DTObjects.EMPTY_OCEANIC_GOLD_GOBLET_ITEM)) {
            return new ItemStack(DTObjects.OCEANIC_GOLD_GOBLET_OF_MILK_ITEM);
        } else {
            return ItemStack.EMPTY;
        }
    }




}
