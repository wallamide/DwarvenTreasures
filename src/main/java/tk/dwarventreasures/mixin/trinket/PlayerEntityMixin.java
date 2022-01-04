package tk.dwarventreasures.mixin.trinket;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Pair;
import net.minecraft.util.math.Box;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import tk.dwarventreasures.client.network.packet.SpawnSnowParticlesPacket;
import tk.dwarventreasures.common.item.MithrilWaistcoatItem;
import tk.dwarventreasures.common.registry.DTEnchantments;
import tk.dwarventreasures.common.registry.ModTags;

import java.util.List;
import java.util.Optional;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntityMixin {

    private boolean walkOnFluid = false;

    @Shadow
    public abstract boolean isPlayer();

    @Inject(method = "tick", at = @At("TAIL"))
    public void checkRings(CallbackInfo callbackInfo) {
        final Optional<TrinketComponent> trinketComponent = TrinketsApi.getTrinketComponent((PlayerEntity) (Object) this);
        if ((Object) this instanceof PlayerEntity player && trinketComponent.isPresent()) {
            final TrinketComponent component = trinketComponent.get();
            Item item = null;
            for (int i = 0; i < ModTags.RINGS.values().size(); i++) {
                if (component.isEquipped(ModTags.RINGS.values().get(i))) {
                    item = ModTags.RINGS.values().get(i);
                }
            }
            if (item != null && component.isEquipped(item)) {
                final int slot = component.getAllEquipped().get(0).getRight().getItem() instanceof MithrilWaistcoatItem ? 1 : 0;
                final List<Pair<SlotReference, ItemStack>> trinketInventory = component.getAllEquipped();
                if (EnchantmentHelper.getLevel(DTEnchantments.HOLY, trinketInventory.get(slot).getRight()) == 1 && player.isTouchingWater()) {
                    if (player.isSubmergedInWater()) {
                        player.jump();
                    } else {
                        this.walkOnFluid = true;
                    }
                } else if (EnchantmentHelper.getLevel(DTEnchantments.FROST, trinketInventory.get(slot).getRight()) == 1) {
                    if (this.getWorld().getBlockState(player.getBlockPos()).getBlock() == Blocks.FARMLAND) {
                        this.getWorld().setBlockState(player.getBlockPos(), Blocks.COARSE_DIRT.getDefaultState());
                    }
                    final Entity entity = player.getAttacker();
                    if (entity != null) {
                        if (!entity.isInvulnerable() && !entity.isInvulnerableTo(DamageSource.FREEZE)) {
                            entity.setFrozenTicks(3000 / 50);//3 seconds
                            entity.damage(DamageSource.FREEZE, 1.0F);
                            entity.setInPowderSnow(true);
                            SpawnSnowParticlesPacket.send(player, entity);
                        }
                    }
                } else if (EnchantmentHelper.getLevel(DTEnchantments.RADIANCE, trinketInventory.get(slot).getRight()) == 1) {
                    final Box box = (new Box(player.getBlockPos())).expand(5).stretch(0.0D, world.getHeight(), 0.0D);
                    final List<Entity> entityList = world.getNonSpectatingEntities(Entity.class, box);
                    for (Entity entity: entityList) {
                       if (entity instanceof HostileEntity) {
                           entity.setFireTicks(3000 / 50);
                       }
                    }

                }
            } else {
                this.walkOnFluid = false;
            }
        }
    }
    @Override
    public boolean canWalkOnFluid(Fluid fluid) {
        return this.walkOnFluid;
    }



}