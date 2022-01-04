package tk.dwarventreasures.common.block.goblet.netherite;

import tk.dwarventreasures.common.block.goblet.FilledGobletBlock;
import tk.dwarventreasures.common.registry.DTObjects;
import tk.dwarventreasures.common.util.DTUtil;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;

public class NetheriteGobletMilkBlock extends FilledGobletBlock {

    public NetheriteGobletMilkBlock(Settings settings) {
        super(settings, DTObjects.EMPTY_NETHERITE_GOBLET, Type.MILK);
    }

    @Override
    protected void getFilledGobletStack(PlayerEntity player, Hand hand, ItemStack toSwitch) {
        if (toSwitch.isOf(DTObjects.EMPTY_NETHERITE_GOBLET_ITEM)) {
            DTUtil.switchStack(player, hand, toSwitch, DTObjects.NETHERITE_GOBLET_OF_MILK_ITEM);
        }

    }
}
