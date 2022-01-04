package tk.dwarventreasures.common.block.goblet.gold;

import tk.dwarventreasures.common.block.goblet.FilledGobletBlock;
import tk.dwarventreasures.common.registry.DTObjects;
import tk.dwarventreasures.common.util.DTUtil;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;

public class GoldenGobletMilkBlock extends FilledGobletBlock {

    public GoldenGobletMilkBlock(Settings settings) {
        super(settings, DTObjects.EMPTY_GOLDEN_GOBLET, Type.MILK);
    }

    @Override
    protected void getFilledGobletStack(PlayerEntity player, Hand hand, ItemStack toSwitch) {
        if (toSwitch.isOf(DTObjects.EMPTY_GOLDEN_GOBLET_ITEM)) {
            DTUtil.switchStack(player, hand, toSwitch, DTObjects.GOLDEN_GOBLET_OF_MILK_ITEM);
        }
    }
}
