package tk.dwarventreasures.common.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class HolyEnchantment extends Enchantment {

    public HolyEnchantment(EquipmentSlot... slots) {
        super(Rarity.RARE, EnchantmentTarget.WEARABLE, slots);
    }

    @Override
    public int getMinLevel() {
        return 1;
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }


}
