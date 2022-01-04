package tk.dwarventreasures.common.item.util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AttunedItemUtil {

    /**
     * Map containing all the targets
     * to attune mithril tools.
     */
    private static final Map<String, Integer> TARGET = new HashMap<>();

    private static final int REQUIRED_TARGETS = 64;

    public static boolean containsSlayerTarget(ItemStack test) {
        return test.getOrCreateNbt().contains("slayerTarget");
    }

    public static boolean containsMinerTarget(ItemStack test) {
        return test.getOrCreateNbt().contains("minerTarget");
    }

    public static boolean isTargetAttunedToSlayer(String target, ItemStack test) {
        if (!containsSlayerTarget(test)) {
            return false;
        }
        return test.getOrCreateNbt().getString("slayerTarget").equals(target);
    }

    public static boolean isBlockAttunedToMiner(String target, ItemStack test) {
        if (!containsMinerTarget(test)) {
            return false;
        }
        return test.getOrCreateNbt().getString("minerTarget").equals(target);
    }

    public static void sendAttunementMessage(PlayerEntity player, Formatting color) {
        player.sendMessage(new TranslatableText("dwarventreasures.tooltip.attune").formatted(color), true);
    }

    public static void setSlayerNbt(ItemStack stack, String value) {
        stack.getOrCreateNbt().putString("slayerTarget", value);
    }

    public static void setMinerTarget(ItemStack stack, String value) {
        stack.getOrCreateNbt().putString("minerTarget", value);
    }

    public static void applySlayerAttunement(final ItemStack stack, final String targetKey, PlayerEntity player, boolean isTargetDied) {
        final NbtCompound stackNbt = stack.getOrCreateNbt();
        if (!stack.isEmpty() && !stackNbt.contains("slayerTarget")) {
            if (!stackNbt.contains("killsCounter")) {
                TARGET.put(targetKey, 0);//resets the key, so targets are not shared between stacks
            }
            stack.getOrCreateNbt().putInt("killsCounter", 0);

            if (isTargetDied) {
                stackNbt.putInt("killsCounter", TARGET.getOrDefault(targetKey, 0) + 1);
                TARGET.put(targetKey, stackNbt.getInt("killsCounter"));
                updateAttunementMessage(stackNbt.getInt("killsCounter"), stackNbt, player);
                if (stackNbt.getInt("killsCounter") == REQUIRED_TARGETS) {
                    stackNbt.remove("killsCounter");
                    setSlayerNbt(stack, targetKey);
                    sendAttunementMessage(player, Formatting.AQUA);
                }
            }
        }
    }

    public static void applyMinerAttunement(final ItemStack stack, final String targetKey, PlayerEntity player, boolean wasMined) {
        final NbtCompound stackNbt = stack.getOrCreateNbt();
        if (!stack.isEmpty() && !stackNbt.contains("minerTarget")) {
            if (!stackNbt.contains("blocksCounter")) {
                TARGET.put(targetKey, 0);//resets the key, so targets are not shared between stacks
            }
            stack.getOrCreateNbt().putInt("blocksCounter", 0);

            if (wasMined) {
                stackNbt.putInt("blocksCounter", TARGET.getOrDefault(targetKey, 0) + 1);
                TARGET.put(targetKey, stackNbt.getInt("blocksCounter"));
                System.out.println(stackNbt.getInt("blocksCounter"));
                updateAttunementMessage(stackNbt.getInt("blocksCounter"), stackNbt, player);
                if (stackNbt.getInt("blocksCounter") == REQUIRED_TARGETS) {
                    stackNbt.remove("blocksCounter");
                    setMinerTarget(stack, targetKey);
                    sendAttunementMessage(player, Formatting.AQUA);
                }
            }
        }
    }

    public static void updateAttunementMessage(int i, NbtCompound stackNbt, PlayerEntity player) {
        if (i == 16 || i == 32 || i ==  48) {
            int targetsLeft = REQUIRED_TARGETS - i;
            if (stackNbt.contains("killsCounter")) {
                player.sendMessage(new TranslatableText("dwarventreasures.tooltip.kills_left").append(Integer.toString(targetsLeft)).formatted(Formatting.RED), true);
            }
            if (stackNbt.contains("blocksCounter")) {
                player.sendMessage(new TranslatableText("dwarventreasures.tooltip.kills_left").append(Integer.toString(targetsLeft)).formatted(Formatting.RED), true);
            }
        }
    }

    public static void appendAttunedStackTooltip(ItemStack stack, List<Text> tooltip) {
        if (AttunedItemUtil.containsSlayerTarget(stack)) {
            final String target = stack.getOrCreateNbt().getString("slayerTarget");
            if (stack.getItem() instanceof SwordItem) {
                tooltip.add(new LiteralText(target).append(new TranslatableText("dwarventreasures.tooltip.slayer")).formatted(Formatting.DARK_PURPLE));
                tooltip.add(new TranslatableText("dwarventreasures.tooltip.attunement_damage", target).formatted(Formatting.GOLD));
            }
            if (stack.getItem() instanceof AxeItem) {
                tooltip.add(new LiteralText(target).append(new TranslatableText("dwarventreasures.tooltip.splitter")).formatted(Formatting.DARK_PURPLE));
                tooltip.add(new TranslatableText("dwarventreasures.tooltip.attunement_damage", target).formatted(Formatting.GOLD));
            }
        }

        if (AttunedItemUtil.containsMinerTarget(stack)) {
            if (stack.getItem() instanceof PickaxeItem) {
                tooltip.add(new TranslatableText(stack.getOrCreateNbt().getString("minerTarget")).append(new TranslatableText("dwarventreasures.tooltip.shatterer")).formatted(Formatting.DARK_PURPLE));
                tooltip.add(new TranslatableText("dwarventreasures.tooltip.boosted_efficiency", new TranslatableText(stack.getOrCreateNbt().getString("minerTarget")).formatted(Formatting.GOLD)).formatted(Formatting.GOLD));
            }
            if (stack.getItem() instanceof AxeItem) {
                tooltip.add(new TranslatableText(stack.getOrCreateNbt().getString("minerTarget")).append(new TranslatableText("dwarventreasures.tooltip.splitter")).formatted(Formatting.DARK_PURPLE));
                tooltip.add(new TranslatableText("dwarventreasures.tooltip.boosted_efficiency", new TranslatableText(stack.getOrCreateNbt().getString("minerTarget")).formatted(Formatting.GOLD)).formatted(Formatting.GOLD));
            }
            if (stack.getItem() instanceof ShovelItem) {
                tooltip.add(new TranslatableText(stack.getOrCreateNbt().getString("minerTarget")).append(new TranslatableText("dwarventreasures.tooltip.shifter")).formatted(Formatting.DARK_PURPLE));
                tooltip.add(new TranslatableText("dwarventreasures.tooltip.boosted_efficiency", new TranslatableText(stack.getOrCreateNbt().getString("minerTarget")).formatted(Formatting.GOLD)).formatted(Formatting.GOLD));
            }
            if (stack.getItem() instanceof HoeItem) {
                tooltip.add(new TranslatableText(stack.getOrCreateNbt().getString("minerTarget")).append(new TranslatableText("dwarventreasures.tooltip.forager")).formatted(Formatting.DARK_PURPLE));
                tooltip.add(new TranslatableText("dwarventreasures.tooltip.boosted_efficiency", new TranslatableText(stack.getOrCreateNbt().getString("minerTarget")).formatted(Formatting.GOLD)).formatted(Formatting.GOLD));
            }
        }
    }
}
