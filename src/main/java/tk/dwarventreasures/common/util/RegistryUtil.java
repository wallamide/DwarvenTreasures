package tk.dwarventreasures.common.util;

import net.minecraft.util.Identifier;
import tk.dwarventreasures.common.DwarvenTreasures;

public class RegistryUtil {

    public static <T extends String> Identifier setRegistryName(final T name) {
        return new Identifier(DwarvenTreasures.MODID, name);
    }
}
