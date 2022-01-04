package tk.dwarventreasures.client.renderer;

import tk.dwarventreasures.client.model.equipment.armor.MithrilArmorModel;
import tk.dwarventreasures.common.DwarvenTreasures;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class MithrilArmorRenderer implements ArmorRenderer {

    public static final EntityModelLayer MITHRIL_ARMOR_MODEL_LAYER = new EntityModelLayer(new Identifier(DwarvenTreasures.MODID, "mithril_armor"), "main");
    private static MithrilArmorModel<LivingEntity> armorModel;
    private final Identifier texture;

    public MithrilArmorRenderer(Identifier texture) {
        this.texture = texture;
    }


    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, ItemStack stack, LivingEntity entity, EquipmentSlot slot, int light, BipedEntityModel<LivingEntity> contextModel) {
        if (armorModel == null) {
            armorModel = new MithrilArmorModel<>(MinecraftClient.getInstance().getEntityModelLoader().getModelPart(MITHRIL_ARMOR_MODEL_LAYER));
        }
        contextModel.setAttributes(armorModel);
        armorModel.setVisible(false);
        armorModel.head.visible = slot == EquipmentSlot.HEAD;
        armorModel.body.visible = slot == EquipmentSlot.CHEST;
        armorModel.leftArm.visible = slot == EquipmentSlot.CHEST;
        armorModel.rightArm.visible = slot == EquipmentSlot.CHEST;
        armorModel.leftLeg.visible = slot == EquipmentSlot.LEGS;
        armorModel.rightLeg.visible = slot == EquipmentSlot.LEGS;
        ArmorRenderer.renderPart(matrices, vertexConsumers, light, stack, armorModel, texture);
    }
}


