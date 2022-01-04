package tk.dwarventreasures.common.block.goblet.mithril;

import tk.dwarventreasures.common.block.goblet.FilledGobletBlock;
import tk.dwarventreasures.common.registry.DTObjects;
import tk.dwarventreasures.common.util.DTUtil;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;

public class MithrilGobletWaterBlock extends FilledGobletBlock {

    public MithrilGobletWaterBlock(Settings settings) {
        super(settings, DTObjects.EMPTY_MITHRIL_GOBLET, Type.WATER);
    }

    @Override
    protected void getFilledGobletStack(PlayerEntity player, Hand hand, ItemStack toSwitch) {
        if (toSwitch.isOf(DTObjects.EMPTY_MITHRIL_GOBLET_ITEM)) {
            DTUtil.switchStack(player, hand, toSwitch, DTObjects.MITHRIL_GOBLET_OF_WATER_ITEM);
        }
    }
}
