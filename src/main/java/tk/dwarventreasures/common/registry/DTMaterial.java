package tk.dwarventreasures.common.registry;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class DTMaterial {

    public static final ArmorMaterial MITHRIL_ARMOR = new ArmorMaterial() {
        @Override
        public int getDurability(EquipmentSlot slot) {
            return ArmorMaterials.NETHERITE.getDurability(slot);
        }

        @Override
        public int getProtectionAmount(EquipmentSlot slot) {
            return ArmorMaterials.NETHERITE.getProtectionAmount(slot);
        }

        @Override
        public int getEnchantability() {
            return ArmorMaterials.NETHERITE.getEnchantability();
        }

        @Override
        public SoundEvent getEquipSound() {
            return SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.ofItems(DTObjects.MITHRIL_INGOT);
        }

        @Override
        public String getName() {
            return "mithril";
        }

        @Override
        public float getToughness() {
            return ArmorMaterials.NETHERITE.getToughness();
        }

        @Override
        public float getKnockbackResistance() {
            return 0;
        }
    };

    public static final ToolMaterial MITHRIL_TOOL = new ToolMaterial() {
        @Override
        public int getDurability() {
            return ToolMaterials.DIAMOND.getDurability();
        }

        @Override
        public float getMiningSpeedMultiplier() {
            return ToolMaterials.DIAMOND.getMiningSpeedMultiplier();
        }

        @Override
        public float getAttackDamage() {
            return ToolMaterials.DIAMOND.getAttackDamage();
        }

        @Override
        public int getMiningLevel() {
            return ToolMaterials.DIAMOND.getMiningLevel();
        }

        @Override
        public int getEnchantability() {
            return ToolMaterials.DIAMOND.getEnchantability();
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.ofItems(DTObjects.MITHRIL_INGOT);
        }
    };
}
