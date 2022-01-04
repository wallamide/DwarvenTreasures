package tk.dwarventreasures.common;

import tk.dwarventreasures.common.registry.DTEnchantments;
import tk.dwarventreasures.common.registry.DTLootTables;
import tk.dwarventreasures.common.registry.DTObjects;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import tk.dwarventreasures.common.util.DTUtil;
import tk.dwarventreasures.common.util.RegistryUtil;

public class DwarvenTreasures implements ModInitializer {

    public static final String MODID = "dwarventreasures";
    public static final ItemGroup DWARVEN_TREASURES_GROUP = FabricItemGroupBuilder.build(RegistryUtil.setRegistryName(MODID), () -> new ItemStack(DTObjects.EMPTY_MITHRIL_GOBLET_ITEM));

    @Override
    public void onInitialize() {
        DTObjects.init();
        DTEnchantments.init();
        DTLootTables.init();
    }
}
