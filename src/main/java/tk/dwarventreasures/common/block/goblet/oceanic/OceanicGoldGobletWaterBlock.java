package tk.dwarventreasures.common.block.goblet.oceanic;

import tk.dwarventreasures.common.block.goblet.FilledGobletBlock;
import tk.dwarventreasures.common.registry.DTObjects;
import tk.dwarventreasures.common.util.DTUtil;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;

public class OceanicGoldGobletWaterBlock extends FilledGobletBlock {
    public OceanicGoldGobletWaterBlock(Settings settings) {
        super(settings, DTObjects.EMPTY_OCEANIC_GOLD_GOBLET, Type.WATER);
    }

    @Override
    protected void getFilledGobletStack(PlayerEntity player, Hand hand, ItemStack toSwitch) {
        if (toSwitch.isOf(DTObjects.EMPTY_OCEANIC_GOLD_GOBLET_ITEM)) {
            DTUtil.switchStack(player, hand, toSwitch, DTObjects.OCEANIC_GOLD_GOBLET_OF_WATER_ITEM);
        }
    }
}
