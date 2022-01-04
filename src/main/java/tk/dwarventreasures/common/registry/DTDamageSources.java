package tk.dwarventreasures.common.registry;

import net.minecraft.entity.damage.DamageSource;

public class DTDamageSources {

    public static final DamageSource DRINKING_LAVA = new DrinkingLavaDamageSource("drinking_lava");

    private static class DrinkingLavaDamageSource extends DamageSource {
        protected DrinkingLavaDamageSource(String name) {
            super(name);
            this.setBypassesArmor();
            this.setFire();
        }
    }


}
