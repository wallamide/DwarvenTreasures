package tk.dwarventreasures.common.block.goblet.silver;

import tk.dwarventreasures.common.block.goblet.FilledGobletBlock;
import tk.dwarventreasures.common.registry.DTObjects;
import tk.dwarventreasures.common.util.DTUtil;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;

public class SilverGobletHoneyBlock extends FilledGobletBlock {
    public SilverGobletHoneyBlock(Settings settings) {
        super(settings, DTObjects.EMPTY_SILVER_GOBLET, Type.HONEY);
    }

    @Override
    protected void getFilledGobletStack(PlayerEntity player, Hand hand, ItemStack toSwitch) {
        if (toSwitch.isOf(DTObjects.EMPTY_SILVER_GOBLET_ITEM)) {
            DTUtil.switchStack(player, hand, toSwitch, DTObjects.SILVER_GOBLET_OF_HONEY_ITEM);
        }
    }
}

