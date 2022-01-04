package tk.dwarventreasures.common.item.tool.mithril;

import net.fabricmc.fabric.api.tool.attribute.v1.DynamicAttributeTool;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import tk.dwarventreasures.common.item.util.AttunedItemUtil;

import java.util.List;

public class MithrilSwordItem extends SwordItem implements DynamicAttributeTool {

    public MithrilSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        AttunedItemUtil.applySlayerAttunement(stack, target.getName().getString(), (PlayerEntity) attacker, target.isDead());
        if (AttunedItemUtil.containsSlayerTarget(stack) && AttunedItemUtil.isTargetAttunedToSlayer(target.getName().getString(), stack)) {
            target.setHealth(target.getHealth() - 12);
        }
        return super.postHit(stack, target, attacker);
    }


    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        AttunedItemUtil.appendAttunedStackTooltip(stack, tooltip);
    }
}
