package tk.dwarventreasures.common.item.goblet;

import tk.dwarventreasures.common.item.util.EmptiedGobletItem;
import tk.dwarventreasures.common.registry.DTObjects;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class EmptiedMithrilGobletItem extends EmptiedGobletItem {
    public EmptiedMithrilGobletItem(Block block, Settings settings) {
        super(block, settings);
    }

    @Override
    protected ItemStack findFilledWaterGoblet(ItemStack inputStack) {
        if (inputStack.isOf(DTObjects.EMPTY_MITHRIL_GOBLET_ITEM)) {
            return new ItemStack(DTObjects.MITHRIL_GOBLET_OF_WATER_ITEM);
        }
        return ItemStack.EMPTY;
    }
}
