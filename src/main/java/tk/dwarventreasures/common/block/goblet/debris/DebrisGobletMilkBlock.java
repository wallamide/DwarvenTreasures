package tk.dwarventreasures.common.block.goblet.debris;

import tk.dwarventreasures.common.block.goblet.FilledGobletBlock;
import tk.dwarventreasures.common.registry.DTObjects;
import tk.dwarventreasures.common.util.DTUtil;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;

public class DebrisGobletMilkBlock extends FilledGobletBlock {

    public DebrisGobletMilkBlock(Settings settings) {
        super(settings, DTObjects.EMPTY_DEBRIS_GOBLET, Type.MILK);
    }

    @Override
    protected void getFilledGobletStack(PlayerEntity player, Hand hand, ItemStack toSwitch) {
        if (toSwitch.isOf(DTObjects.EMPTY_DEBRIS_GOBLET_ITEM)) {
            DTUtil.switchStack(player, hand, toSwitch, DTObjects.DEBRIS_GOBLET_OF_MILK_ITEM);
        }

    }
}
