package tk.dwarventreasures.common.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class FrostEnchantment extends Enchantment {
    public FrostEnchantment(EquipmentSlot... slotTypes) {
        super(Rarity.RARE, EnchantmentTarget.WEARABLE, slotTypes);
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
