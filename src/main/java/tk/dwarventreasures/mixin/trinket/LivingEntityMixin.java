package tk.dwarventreasures.mixin.trinket;

import net.minecraft.entity.LivingEntity;
import net.minecraft.fluid.Fluid;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import tk.dwarventreasures.mixin.goblet.EntityMixin;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends EntityMixin {

    @Shadow public abstract boolean canWalkOnFluid(Fluid fluid);
}
