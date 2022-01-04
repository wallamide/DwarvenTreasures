package tk.dwarventreasures.common.registry;

import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;
import tk.dwarventreasures.common.DwarvenTreasures;

public class ModTags {

    public static final Tag<Item> VALID_TO_EMPTY_GOBLET = TagRegistry.item(new Identifier(DwarvenTreasures.MODID, "valid_to_empty_goblet"));
    public static final Tag<Item> FILLED_ITEMS = TagRegistry.item(new Identifier(DwarvenTreasures.MODID, "filled_items"));
    public static final Tag<Item> MILK_GOBLETS = TagRegistry.item(new Identifier(DwarvenTreasures.MODID, "milk_goblets"));
    public static final Tag<Item> HONEY_GOBLETS = TagRegistry.item(new Identifier(DwarvenTreasures.MODID, "honey_goblets"));
    public static final Tag<Item> TAKES_LAVA = TagRegistry.item(new Identifier(DwarvenTreasures.MODID, "takes_lava"));
    public static final Tag<Item> RINGS = TagRegistry.item(new Identifier(DwarvenTreasures.MODID, "rings"));

}
