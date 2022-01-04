package tk.dwarventreasures.mixin.goblet;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(Entity.class)
public abstract class EntityMixin {

    @Shadow public World world;
    @Shadow public abstract boolean equals(Object o);

    @Shadow public boolean wasInPowderSnow;

    @Accessor("world")
    public abstract World getWorld();

}
