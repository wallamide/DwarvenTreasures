package tk.dwarventreasures.common.registry;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponents;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;
import tk.dwarventreasures.common.DwarvenTreasures;
import tk.dwarventreasures.common.block.CoinPileBlock;
import tk.dwarventreasures.common.block.goblet.copper.CopperGobletHoneyBlock;
import tk.dwarventreasures.common.block.goblet.copper.CopperGobletMilkBlock;
import tk.dwarventreasures.common.block.goblet.copper.CopperGobletWaterBlock;
import tk.dwarventreasures.common.block.goblet.copper.EmptiedCopperGobletBlock;
import tk.dwarventreasures.common.block.goblet.debris.*;
import tk.dwarventreasures.common.block.goblet.gold.EmptiedGoldenGobletBlock;
import tk.dwarventreasures.common.block.goblet.gold.GoldenGobletHoneyBlock;
import tk.dwarventreasures.common.block.goblet.gold.GoldenGobletMilkBlock;
import tk.dwarventreasures.common.block.goblet.gold.GoldenGobletWaterBlock;
import tk.dwarventreasures.common.block.goblet.mithril.EmptiedMithrilGobletBlock;
import tk.dwarventreasures.common.block.goblet.mithril.MithrilGobletHoneyBlock;
import tk.dwarventreasures.common.block.goblet.mithril.MithrilGobletMilkBlock;
import tk.dwarventreasures.common.block.goblet.mithril.MithrilGobletWaterBlock;
import tk.dwarventreasures.common.block.goblet.netherite.*;
import tk.dwarventreasures.common.block.goblet.oceanic.EmptiedOceanicGoldGobletBlock;
import tk.dwarventreasures.common.block.goblet.oceanic.OceanicGoldGobletHoneyBlock;
import tk.dwarventreasures.common.block.goblet.oceanic.OceanicGoldGobletMilkBlock;
import tk.dwarventreasures.common.block.goblet.oceanic.OceanicGoldGobletWaterBlock;
import tk.dwarventreasures.common.block.goblet.silver.EmptiedSilverGobletBlock;
import tk.dwarventreasures.common.block.goblet.silver.SilverGobletHoneyBlock;
import tk.dwarventreasures.common.block.goblet.silver.SilverGobletMilkBlock;
import tk.dwarventreasures.common.block.goblet.silver.SilverGobletWaterBlock;
import tk.dwarventreasures.common.item.MithrilWaistcoatItem;
import tk.dwarventreasures.common.item.RingItem;
import tk.dwarventreasures.common.item.goblet.*;
import tk.dwarventreasures.common.item.tool.mithril.*;
import tk.dwarventreasures.common.util.RegistryUtil;

import java.util.LinkedHashMap;
import java.util.Map;

public class DTObjects {

    private static final Map<String, Block> BLOCKS = new LinkedHashMap<>();
    private static final Map<String, Item> ITEMS = new LinkedHashMap<>();

    //copper
    public static final Block EMPTY_COPPER_GOBLET = add("copper_goblet", new EmptiedCopperGobletBlock(gobletBlock()), false);
    public static final Item EMPTY_COPPER_GOBLET_ITEM = add("copper_goblet", new EmptiedCopperGobletItem(EMPTY_COPPER_GOBLET, group().maxCount(16)));
    public static final Block COPPER_GOBLET_OF_WATER = add("copper_goblet_of_water", new CopperGobletWaterBlock(gobletBlock()), false);
    public static final Item COPPER_GOBLET_OF_WATER_ITEM = add("copper_goblet_of_water", new FilledGobletItem(COPPER_GOBLET_OF_WATER, group().maxCount(1), EMPTY_COPPER_GOBLET_ITEM));
    public static final Block COPPER_GOBLET_OF_MILK = add("copper_goblet_of_milk", new CopperGobletMilkBlock(gobletBlock()), false);
    public static final Item COPPER_GOBLET_OF_MILK_ITEM = add("copper_goblet_of_milk", new FilledGobletItem(COPPER_GOBLET_OF_MILK, group().maxCount(1), EMPTY_COPPER_GOBLET_ITEM));
    public static final Block COPPER_GOBLET_OF_HONEY = add("copper_goblet_of_honey", new CopperGobletHoneyBlock(gobletBlock()), false);
    public static final Item COPPER_GOBLET_OF_HONEY_ITEM = add("copper_goblet_of_honey", new FilledGobletItem(COPPER_GOBLET_OF_HONEY, group().maxCount(1).food(FoodComponents.HONEY_BOTTLE), EMPTY_COPPER_GOBLET_ITEM, true));
    public static final Item COPPER_COIN = add("copper_coin", new Item(group()));
    public static final Block COPPER_COIN_PILE = add("copper_coin_pile", new CoinPileBlock(coinPileBlock()), true);
    public static final Item COPPER_RING = add("copper_ring", new RingItem(group().maxCount(1)));
    //golden
    public static final Block EMPTY_GOLDEN_GOBLET = add("golden_goblet", new EmptiedGoldenGobletBlock(gobletBlock()), false);
    public static final Item EMPTY_GOLDEN_GOBLET_ITEM = add("golden_goblet", new EmptiedGoldenGobletItem(EMPTY_GOLDEN_GOBLET, group().maxCount(16)));
    public static final Block GOLDEN_GOBLET_OF_WATER = add("golden_goblet_of_water", new GoldenGobletWaterBlock(gobletBlock()), false);
    public static final Item GOLDEN_GOBLET_OF_WATER_ITEM = add("golden_goblet_of_water", new FilledGobletItem(GOLDEN_GOBLET_OF_WATER, group().maxCount(1), EMPTY_GOLDEN_GOBLET_ITEM));
    public static final Block GOLDEN_GOBLET_OF_MILK = add("golden_goblet_of_milk", new GoldenGobletMilkBlock(gobletBlock()), false);
    public static final Item GOLDEN_GOBLET_OF_MILK_ITEM = add("golden_goblet_of_milk", new FilledGobletItem(GOLDEN_GOBLET_OF_MILK, group().maxCount(1), EMPTY_GOLDEN_GOBLET_ITEM));
    public static final Block GOLDEN_GOBLET_OF_HONEY = add("golden_goblet_of_honey", new GoldenGobletHoneyBlock(gobletBlock()), false);
    public static final Item GOLDEN_GOBLET_OF_HONEY_ITEM = add("golden_goblet_of_honey", new FilledGobletItem(GOLDEN_GOBLET_OF_HONEY, group().maxCount(1).food(FoodComponents.HONEY_BOTTLE), EMPTY_GOLDEN_GOBLET_ITEM, true));
    public static final Item GOLD_COIN = add("gold_coin", new Item(group()));
    public static final Block GOLD_COIN_PILE = add("gold_coin_pile", new CoinPileBlock(coinPileBlock()), true);
    public static final Item GOLD_RING = add("gold_ring", new RingItem(group().maxCount(1)));
    //debris
    public static final Block EMPTY_DEBRIS_GOBLET = add("debris_goblet", new EmptiedDebrisGobletBlock(gobletBlock()), false);
    public static final Item EMPTY_DEBRIS_GOBLET_ITEM = add("debris_goblet", new EmptiedDebrisGobletItem(EMPTY_DEBRIS_GOBLET, group().maxCount(16).fireproof()));
    public static final Block DEBRIS_GOBLET_OF_WATER = add("debris_goblet_of_water", new DebrisGobletWaterBlock(gobletBlock()), false);
    public static final Item DEBRIS_GOBLET_OF_WATER_ITEM = add("debris_goblet_of_water", new FilledGobletItem(DEBRIS_GOBLET_OF_WATER, group().maxCount(1).fireproof(), EMPTY_DEBRIS_GOBLET_ITEM));
    public static final Block DEBRIS_GOBLET_OF_MILK = add("debris_goblet_of_milk", new DebrisGobletMilkBlock(gobletBlock()), false);
    public static final Item DEBRIS_GOBLET_OF_MILK_ITEM = add("debris_goblet_of_milk", new FilledGobletItem(DEBRIS_GOBLET_OF_MILK, group().maxCount(1).fireproof(), EMPTY_DEBRIS_GOBLET_ITEM));
    public static final Block DEBRIS_GOBLET_OF_HONEY = add("debris_goblet_of_honey", new DebrisGobletHoneyBlock(gobletBlock()), false);
    public static final Item DEBRIS_GOBLET_OF_HONEY_ITEM = add("debris_goblet_of_honey", new FilledGobletItem(DEBRIS_GOBLET_OF_HONEY, group().maxCount(1).fireproof().food(FoodComponents.HONEY_BOTTLE), EMPTY_DEBRIS_GOBLET_ITEM));
    public static final Block DEBRIS_GOBLET_OF_LAVA = add("debris_goblet_of_lava", new DebrisGobletLavaBlock(gobletBlock().luminance(value -> 15)), false);
    public static final Item DEBRIS_GOBLET_OF_LAVA_ITEM = add("debris_goblet_of_lava", new FilledGobletItem(DEBRIS_GOBLET_OF_LAVA, group().maxCount(1).fireproof(), EMPTY_DEBRIS_GOBLET_ITEM, true));
    public static final Item DEBRIS_COIN = add("debris_coin", new Item(group()));
    public static final Block DEBRIS_COIN_PILE = add("debris_coin_pile", new CoinPileBlock(coinPileBlock()), true);
    public static final Item DEBRIS_RING = add("debris_ring", new RingItem(group().maxCount(1)));
    //netherite
    public static final Block EMPTY_NETHERITE_GOBLET = add("netherite_goblet", new EmptiedNetheriteGobletBlock(gobletBlock()), false);
    public static final Item EMPTY_NETHERITE_GOBLET_ITEM = add("netherite_goblet", new EmptiedNetheriteGobletItem(EMPTY_NETHERITE_GOBLET, group().maxCount(16).fireproof()));
    public static final Block NETHERITE_GOBLET_OF_WATER = add("netherite_goblet_of_water", new NetheriteGobletWaterBlock(gobletBlock()), false);
    public static final Item NETHERITE_GOBLET_OF_WATER_ITEM = add("netherite_goblet_of_water", new FilledGobletItem(NETHERITE_GOBLET_OF_WATER, group().maxCount(1).fireproof(), EMPTY_NETHERITE_GOBLET_ITEM));
    public static final Block NETHERITE_GOBLET_OF_MILK = add("netherite_goblet_of_milk", new NetheriteGobletMilkBlock(gobletBlock()), false);
    public static final Item NETHERITE_GOBLET_OF_MILK_ITEM = add("netherite_goblet_of_milk", new FilledGobletItem(NETHERITE_GOBLET_OF_MILK, group().maxCount(1).fireproof(), EMPTY_NETHERITE_GOBLET_ITEM));
    public static final Block NETHERITE_GOBLET_OF_HONEY = add("netherite_goblet_of_honey", new NetheriteGobletHoneyBlock(gobletBlock()), false);
    public static final Item NETHERITE_GOBLET_OF_HONEY_ITEM = add("netherite_goblet_of_honey", new FilledGobletItem(NETHERITE_GOBLET_OF_HONEY, group().maxCount(1).fireproof().food(FoodComponents.HONEY_BOTTLE), EMPTY_NETHERITE_GOBLET_ITEM));
    public static final Block NETHERITE_GOBLET_OF_LAVA = add("netherite_goblet_of_lava", new NetheriteGobletLavaBlock(gobletBlock().luminance(value -> 15)), false);
    public static final Item NETHERITE_GOBLET_OF_LAVA_ITEM = add("netherite_goblet_of_lava", new FilledGobletItem(NETHERITE_GOBLET_OF_LAVA, group().maxCount(1).fireproof(), EMPTY_NETHERITE_GOBLET_ITEM, true));
    public static final Item NETHERITE_COIN = add("netherite_coin", new Item(group()));
    public static final Block NETHERITE_COIN_PILE = add("netherite_coin_pile", new CoinPileBlock(coinPileBlock()), true);
    public static final Item NETHERITE_RING = add("netherite_ring", new RingItem(group().maxCount(1)));
    //mithril
    public static final Block EMPTY_MITHRIL_GOBLET = add("mithril_goblet", new EmptiedMithrilGobletBlock(gobletBlock()), false);
    public static final Item EMPTY_MITHRIL_GOBLET_ITEM = add("mithril_goblet", new EmptiedMithrilGobletItem(EMPTY_MITHRIL_GOBLET, group().maxCount(16)));
    public static final Block MITHRIL_GOBLET_OF_WATER = add("mithril_goblet_of_water", new MithrilGobletWaterBlock(gobletBlock()), false);
    public static final Item MITHRIL_GOBLET_OF_WATER_ITEM = add("mithril_goblet_of_water", new FilledGobletItem(MITHRIL_GOBLET_OF_WATER, group().maxCount(1), EMPTY_MITHRIL_GOBLET_ITEM));
    public static final Block MITHRIL_GOBLET_OF_MILK = add("mithril_goblet_of_milk", new MithrilGobletMilkBlock(gobletBlock()), false);
    public static final Item MITHRIL_GOBLET_OF_MILK_ITEM = add("mithril_goblet_of_milk", new FilledGobletItem(MITHRIL_GOBLET_OF_MILK, group().maxCount(1), EMPTY_MITHRIL_GOBLET_ITEM));
    public static final Block MITHRIL_GOBLET_OF_HONEY = add("mithril_goblet_of_honey", new MithrilGobletHoneyBlock(gobletBlock()), false);
    public static final Item MITHRIL_GOBLET_OF_HONEY_ITEM = add("mithril_goblet_of_honey", new FilledGobletItem(MITHRIL_GOBLET_OF_HONEY, group().maxCount(1).food(FoodComponents.HONEY_BOTTLE), EMPTY_MITHRIL_GOBLET_ITEM, true));
    public static final Item MITHRIL_INGOT = add("mithril_ingot", new Item(group()));
    public static final Item MITHRIL_COIN = add("mithril_coin", new Item(group()));
    public static final Block MITHRIL_COIN_PILE = add("mithril_coin_pile", new CoinPileBlock(coinPileBlock()), true);
    public static final Block MITHRIL_BLOCK = add("mithril_block", new Block(AbstractBlock.Settings.copy(Blocks.NETHERITE_BLOCK)), true);
    public static final Block CHISELED_MITHRIL = add("chiseled_mithril", new Block(AbstractBlock.Settings.copy(Blocks.NETHERITE_BLOCK)), true);
    public static final Block POLISHED_MITHRIL = add("polished_mithril", new Block(AbstractBlock.Settings.copy(Blocks.NETHERITE_BLOCK)), true);
    public static final Block MITHRIL_PLATE = add("mithril_plate", new Block(AbstractBlock.Settings.copy(Blocks.NETHERITE_BLOCK)), true);
    public static final Block MITHRIL_TILE = add("mithril_tile", new Block(AbstractBlock.Settings.copy(Blocks.NETHERITE_BLOCK)), true);
    public static final Block INVERTED_MITHRIL_TILE = add("inverted_mithril_tile", new Block(AbstractBlock.Settings.copy(Blocks.NETHERITE_BLOCK)), true);
    public static final Item MITHRIL_RING = add("mithril_ring", new RingItem(group().maxCount(1)));
    //silver
    public static final Block EMPTY_SILVER_GOBLET = add("silver_goblet", new EmptiedSilverGobletBlock(gobletBlock()), false);
    public static final Item EMPTY_SILVER_GOBLET_ITEM = add("silver_goblet", new EmptiedSilverGobletItem(EMPTY_SILVER_GOBLET, group().maxCount(16)));
    public static final Block SILVER_GOBLET_OF_WATER = add("silver_goblet_of_water", new SilverGobletWaterBlock(gobletBlock()), false);
    public static final Item SILVER_GOBLET_OF_WATER_ITEM = add("silver_goblet_of_water", new FilledGobletItem(SILVER_GOBLET_OF_WATER, group().maxCount(1), EMPTY_SILVER_GOBLET_ITEM));
    public static final Block SILVER_GOBLET_OF_MILK = add("silver_goblet_of_milk", new SilverGobletMilkBlock(gobletBlock()), false);
    public static final Item SILVER_GOBLET_OF_MILK_ITEM = add("silver_goblet_of_milk", new FilledGobletItem(SILVER_GOBLET_OF_MILK, group().maxCount(1), EMPTY_SILVER_GOBLET_ITEM));
    public static final Block SILVER_GOBLET_OF_HONEY = add("silver_goblet_of_honey", new SilverGobletHoneyBlock(gobletBlock()), false);
    public static final Item SILVER_GOBLET_OF_HONEY_ITEM = add("silver_goblet_of_honey", new FilledGobletItem(SILVER_GOBLET_OF_HONEY, group().maxCount(1).food(FoodComponents.HONEY_BOTTLE), EMPTY_SILVER_GOBLET_ITEM, true));
    public static final Item SILVER_COIN = add("silver_coin", new Item(group()));
    public static final Block SILVER_COIN_PILE = add("silver_coin_pile", new CoinPileBlock(coinPileBlock()), true);
    public static final Item SILVER_RING = add("silver_ring", new RingItem(group().maxCount(1)));
    //oceanic gold
    public static final Block EMPTY_OCEANIC_GOLD_GOBLET = add("oceanic_gold_goblet", new EmptiedOceanicGoldGobletBlock(gobletBlock()), false);
    public static final Item EMPTY_OCEANIC_GOLD_GOBLET_ITEM = add("oceanic_gold_goblet", new EmptiedOceanicGoldGobletItem(EMPTY_OCEANIC_GOLD_GOBLET, group().maxCount(16)));
    public static final Block OCEANIC_GOLD_GOBLET_OF_WATER = add("oceanic_gold_goblet_of_water", new OceanicGoldGobletWaterBlock(gobletBlock()), false);
    public static final Item OCEANIC_GOLD_GOBLET_OF_WATER_ITEM = add("oceanic_gold_goblet_of_water", new FilledGobletItem(OCEANIC_GOLD_GOBLET_OF_WATER, group().maxCount(1), EMPTY_OCEANIC_GOLD_GOBLET_ITEM));
    public static final Block OCEANIC_GOLD_GOBLET_OF_MILK = add("oceanic_gold_goblet_of_milk", new OceanicGoldGobletMilkBlock(gobletBlock()), false);
    public static final Item OCEANIC_GOLD_GOBLET_OF_MILK_ITEM = add("oceanic_gold_goblet_of_milk", new FilledGobletItem(OCEANIC_GOLD_GOBLET_OF_MILK, group().maxCount(1), EMPTY_OCEANIC_GOLD_GOBLET_ITEM));
    public static final Block OCEANIC_GOLD_GOBLET_OF_HONEY = add("oceanic_gold_goblet_of_honey", new OceanicGoldGobletHoneyBlock(gobletBlock()), false);
    public static final Item OCEANIC_GOLD_GOBLET_OF_HONEY_ITEM = add("oceanic_gold_goblet_of_honey", new FilledGobletItem(OCEANIC_GOLD_GOBLET_OF_HONEY, group().maxCount(1).food(FoodComponents.HONEY_BOTTLE), EMPTY_OCEANIC_GOLD_GOBLET_ITEM, true));
    public static final Item OCEANIC_GOLD_COIN = add("oceanic_gold_coin", new Item(group()));
    public static final Block OCEANIC_GOLD_COIN_PILE = add("oceanic_gold_coin_pile", new CoinPileBlock(coinPileBlock()), true);
    public static final Item OCEANIC_GOLD_RING = add("oceanic_gold_ring", new RingItem(group().maxCount(1)));
    //tools and equipment
    public static final Item MITHRIL_SWORD = add("mithril_sword", new MithrilSwordItem(DTMaterial.MITHRIL_TOOL, 3, -2.4F, group()));
    public static final Item MITHRIL_PICKAXE = add("mithril_pickaxe", new MithrilPickaxeItem(DTMaterial.MITHRIL_TOOL, 1, -2.8F, group()));
    public static final Item MITHRIL_AXE = add("mithril_axe", new MithrilAxeItem(DTMaterial.MITHRIL_TOOL, 5.0F, -3.0F, group()));
    public static final Item MITHRIL_SHOVEL = add("mithril_shovel", new MithrilShovelItem(DTMaterial.MITHRIL_TOOL, 1.5F, -3.0F, group()));
    public static final Item MITHRIL_HOE = add("mithril_hoe", new MithrilHoeItem(DTMaterial.MITHRIL_TOOL, -3, 0.0F, group()));
    public static final Item MITHRIL_HELMET = add("mithril_helmet", new ArmorItem(DTMaterial.MITHRIL_ARMOR, EquipmentSlot.HEAD, group()));
    public static final Item MITHRIL_CHESTPLATE = add("mithril_chestplate", new ArmorItem(DTMaterial.MITHRIL_ARMOR, EquipmentSlot.CHEST, group()));
    public static final Item MITHRIL_WAISTCOAT = add("mithril_waistcoat", new MithrilWaistcoatItem(group().maxCount(1)));
    public static final Item MITHRIL_LEGGINGS = add("mithril_leggings", new ArmorItem(DTMaterial.MITHRIL_ARMOR, EquipmentSlot.LEGS, group()));
    public static final Item MITHRIL_BOOTS = add("mithril_boots", new ArmorItem(DTMaterial.MITHRIL_ARMOR, EquipmentSlot.FEET, group()));

    private static <T extends Item> T add(String name, T item) {
        ITEMS.put(name, item);
        return item;
    }

    private static <T extends Block> T add(String name, T block, boolean addItem) {
        BLOCKS.put(name, block);
        if (addItem) {
            ITEMS.put(name, new BlockItem(block, group()));
        }
        return block;
    }

    private static Item.Settings group() {
        return new Item.Settings().group(DwarvenTreasures.DWARVEN_TREASURES_GROUP);
    }

    private static AbstractBlock.Settings gobletBlock() {
        return AbstractBlock.Settings.of(Material.METAL).strength(0.3F, 1.0F).nonOpaque();
    }
    private static AbstractBlock.Settings coinPileBlock() {
        return AbstractBlock.Settings.of(Material.DECORATION).ticksRandomly().strength(0.5F).requiresTool();
    }

    public static void init() {
        for (final String id : BLOCKS.keySet()) {
            Registry.register(Registry.BLOCK, RegistryUtil.setRegistryName(id), BLOCKS.get(id));
        }
        for (final String id : ITEMS.keySet()) {
            Registry.register(Registry.ITEM, RegistryUtil.setRegistryName(id), ITEMS.get(id));
        }
    }
}
