package tk.dwarventreasures.mixin.goblet;

import net.minecraft.entity.passive.PassiveEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@SuppressWarnings("BooleanMethodIsAlwaysInverted")
@Mixin(PassiveEntity.class)
public abstract class PassiveEntityMixin extends EntityMixin {

    /**
     * Shadowed method for determining whether the entity is a baby.
     * @return {@code true} if the entity is a baby, otherwise {@code false}
     *
     */
    @Shadow
    public abstract boolean isBaby();
}
