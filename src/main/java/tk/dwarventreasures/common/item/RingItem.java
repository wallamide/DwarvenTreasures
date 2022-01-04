package tk.dwarventreasures.common.item;

import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.item.ItemStack;

public class RingItem extends TrinketItem {

    public RingItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public int getEnchantability() {
        return 25;
    }
}
