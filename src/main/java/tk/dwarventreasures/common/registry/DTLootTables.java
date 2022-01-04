package tk.dwarventreasures.common.registry;

import tk.dwarventreasures.common.DwarvenTreasures;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.entry.LootTableEntry;
import net.minecraft.util.Identifier;

public class DTLootTables {

    public static void init() {

        LootTableLoadingCallback.EVENT.register(((resourceManager, manager, id, supplier, setter) -> {

            if (LootTables.SIMPLE_DUNGEON_CHEST.equals(id)) {
                supplier.withPool(LootPool.builder().with(LootTableEntry.builder(new Identifier(DwarvenTreasures.MODID, "chest/dungeon")).weight(1)).build());
            }
            if (LootTables.ABANDONED_MINESHAFT_CHEST.equals(id)) {
                supplier.withPool(LootPool.builder().with(LootTableEntry.builder(new Identifier(DwarvenTreasures.MODID, "chest/mineshaft")).weight(1)).build());
            }
            if (LootTables.STRONGHOLD_CORRIDOR_CHEST.equals(id) || LootTables.STRONGHOLD_CROSSING_CHEST.equals(id)) {
                supplier.withPool(LootPool.builder().with(LootTableEntry.builder(new Identifier(DwarvenTreasures.MODID, "chest/stronghold")).weight(1)).build());
            }
            if (LootTables.UNDERWATER_RUIN_SMALL_CHEST.equals(id) || LootTables.UNDERWATER_RUIN_BIG_CHEST.equals(id)) {
                supplier.withPool(LootPool.builder().with(LootTableEntry.builder(new Identifier(DwarvenTreasures.MODID, "chest/underwater_ruin")).weight(1)).build());
            }
            if (LootTables.RUINED_PORTAL_CHEST.equals(id)) {
                supplier.withPool(LootPool.builder().with(LootTableEntry.builder(new Identifier(DwarvenTreasures.MODID, "chest/ruined_portal")).weight(1)).build());
            }
            if (LootTables.BURIED_TREASURE_CHEST.equals(id)) {
                supplier.withPool(LootPool.builder().with(LootTableEntry.builder(new Identifier(DwarvenTreasures.MODID, "chest/buried_treasure")).weight(1)).build());
            }
            if (LootTables.NETHER_BRIDGE_CHEST.equals(id)) {
                supplier.withPool(LootPool.builder().with(LootTableEntry.builder(new Identifier(DwarvenTreasures.MODID, "chest/nether_fortress")).weight(1)).build());
            }
        }));
    }
}
