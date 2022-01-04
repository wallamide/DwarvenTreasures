package tk.dwarventreasures.common.block.goblet.copper;

import tk.dwarventreasures.common.block.goblet.FilledGobletBlock;
import tk.dwarventreasures.common.registry.DTObjects;
import tk.dwarventreasures.common.util.DTUtil;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;

public class CopperGobletMilkBlock extends FilledGobletBlock {

    public CopperGobletMilkBlock(Settings settings) {
        super(settings, DTObjects.EMPTY_COPPER_GOBLET, Type.MILK);
    }

    @Override
    protected void getFilledGobletStack(PlayerEntity player, Hand hand, ItemStack toSwitch) {
        if (toSwitch.isOf(DTObjects.EMPTY_COPPER_GOBLET_ITEM)) {
            DTUtil.switchStack(player, hand, toSwitch, DTObjects.COPPER_GOBLET_OF_MILK_ITEM);
        }

    }
}
