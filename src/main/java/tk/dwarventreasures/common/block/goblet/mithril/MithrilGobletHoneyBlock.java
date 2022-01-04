package tk.dwarventreasures.common.block.goblet.mithril;

import tk.dwarventreasures.common.block.goblet.FilledGobletBlock;
import tk.dwarventreasures.common.registry.DTObjects;
import tk.dwarventreasures.common.util.DTUtil;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;

public class MithrilGobletHoneyBlock extends FilledGobletBlock {

    public MithrilGobletHoneyBlock(Settings settings) {
        super(settings, DTObjects.EMPTY_MITHRIL_GOBLET, Type.HONEY);
    }

    @Override
    protected void getFilledGobletStack(PlayerEntity player, Hand hand, ItemStack toSwitch) {
        if (toSwitch.isOf(DTObjects.EMPTY_MITHRIL_GOBLET_ITEM)) {
            DTUtil.switchStack(player, hand, toSwitch, DTObjects.MITHRIL_GOBLET_OF_HONEY_ITEM);
        }
    }
}
