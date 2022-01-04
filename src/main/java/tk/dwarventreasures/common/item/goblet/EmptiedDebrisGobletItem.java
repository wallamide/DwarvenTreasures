package tk.dwarventreasures.common.item.goblet;

import tk.dwarventreasures.common.item.util.EmptiedGobletItem;
import tk.dwarventreasures.common.registry.DTObjects;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class EmptiedDebrisGobletItem extends EmptiedGobletItem {

    public EmptiedDebrisGobletItem(Block block, Settings settings) {
        super(block, settings);
    }

    @Override
    protected ItemStack findFilledWaterGoblet(ItemStack inputStack) {
        if (inputStack.isOf(DTObjects.EMPTY_DEBRIS_GOBLET_ITEM)) {
            return new ItemStack(DTObjects.DEBRIS_GOBLET_OF_WATER_ITEM);
        }
        return ItemStack.EMPTY;
    }

}
