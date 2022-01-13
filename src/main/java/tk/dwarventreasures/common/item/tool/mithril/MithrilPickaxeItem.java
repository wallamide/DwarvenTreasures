package tk.dwarventreasures.common.item.tool.mithril;

import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.tag.BlockTags;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import tk.dwarventreasures.common.item.util.AttunedItemUtil;

import java.util.List;


public class MithrilPickaxeItem extends PickaxeItem {

    private static final float ATTUNED_BOOST = 12.0F;

    public MithrilPickaxeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {

        if (BlockTags.PICKAXE_MINEABLE.contains(state.getBlock())) {
            if (AttunedItemUtil.isBlockAttunedToMiner(state.getBlock().getTranslationKey(), stack)) {
                return this.miningSpeed + ATTUNED_BOOST;
            } else {
                return super.getMiningSpeedMultiplier(stack, state);
            }
        } else {
            return 1.0F;
        }
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        AttunedItemUtil.applyMinerAttunement(stack, state.getBlock().getTranslationKey(), (PlayerEntity) miner, BlockTags.PICKAXE_MINEABLE.contains(state.getBlock()));
        return super.postMine(stack, world, state, pos, miner);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        AttunedItemUtil.appendAttunedStackTooltip(stack, tooltip);
    }
}
