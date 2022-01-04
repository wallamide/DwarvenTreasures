package tk.dwarventreasures.common.registry;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import tk.dwarventreasures.common.DwarvenTreasures;
import tk.dwarventreasures.common.enchantment.RingEnchantment;
import tk.dwarventreasures.common.util.RegistryUtil;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class DTEnchantments {

    private static final Map<String, Enchantment> ENCHANTMENTS = new HashMap<>();

    public static final Enchantment HOLY = create("holy", new RingEnchantment());
    public static final Enchantment FROST = create("frost", new RingEnchantment());
    public static final Enchantment RADIANCE = create("radiance", new RingEnchantment());

    private static <T extends Enchantment> T create(String name, T enchantment) {
        ENCHANTMENTS.put(name, enchantment);
        return enchantment;
    }

    public static void init() {
        for (final String id : ENCHANTMENTS.keySet()) {
            Registry.register(Registry.ENCHANTMENT, RegistryUtil.setRegistryName(id), ENCHANTMENTS.get(id));
        }
    }
}
