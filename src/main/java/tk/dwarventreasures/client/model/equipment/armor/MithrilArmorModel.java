package tk.dwarventreasures.client.model.equipment.armor;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.entity.LivingEntity;

@Environment(EnvType.CLIENT)
public class MithrilArmorModel <T extends LivingEntity> extends BipedEntityModel<T> {

    public MithrilArmorModel(ModelPart root) {
        super(root);
    }

    public static TexturedModelData getModelData() {
        ModelData data = BipedEntityModel.getModelData(Dilation.NONE, 0);
        ModelPartData head = data.getRoot().getChild(EntityModelPartNames.HEAD);//get the biped's children like so (head, legs, body, arms)
        ModelPartData leftArm = data.getRoot().getChild(EntityModelPartNames.LEFT_ARM);
        ModelPartData rightLeg = data.getRoot().getChild(EntityModelPartNames.RIGHT_LEG);
        ModelPartData body = data.getRoot().getChild(EntityModelPartNames.BODY);
        ModelPartData leftLeg = data.getRoot().getChild(EntityModelPartNames.LEFT_LEG);
        ModelPartData rightArm = data.getRoot().getChild(EntityModelPartNames.RIGHT_ARM);

        ModelPartData armorRightLeg = rightLeg.addChild("armorRightLeg",
                ModelPartBuilder.create(),
                ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        armorRightLeg.addChild("KneePadRight_r1",
                ModelPartBuilder.create()
                        .uv(0, 4).cuboid(0.4F, 15.5F, 2.5F, 3.0F, 3.0F, 1.0F, new Dilation(0.1F, 0.1F, 0.1F))
                        .uv(44, 40).cuboid(0.05F, 12.0F, -2.5F, 4.0F, 9.0F, 5.0F, new Dilation(0.1F, 0.1F, 0.1F)),
                ModelTransform.of(2.0F, -12.0F, 0.0F, 0.0F, 3.1416F, 0.0F));
        ModelPartData armorRightBoot = rightLeg.addChild("armorRightBoot",
                ModelPartBuilder.create(),
                ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        armorRightBoot.addChild("RightBoot_r1",
                ModelPartBuilder.create()
                        .uv(38, 0).cuboid(0.25F, 21.0F, -3.0F, 4.0F, 3.0F, 7.0F, new Dilation(0.1F, 0.1F, 0.1F)),
                ModelTransform.of(2.0F, -12.0F, 0.0F, 0.0F, 3.1416F, 0.0F));
        ModelPartData armorBody = body.addChild("armorBody",
                ModelPartBuilder.create()
                        .uv(46, 54).cuboid(-2.0F, 2.0F, -5.0F, 4.0F, 4.0F, 2.0F),
                ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        armorBody.addChild("ThingOnBackNotCloseToBody4_r1",
                ModelPartBuilder.create()
                        .uv(0, 8).cuboid(-2.0F, 1.0F, -5.0F, 4.0F, 1.0F, 1.0F)
                        .uv(26, 0).cuboid(-2.0F, 6.0F, -5.0F, 4.0F, 1.0F, 1.0F)
                        .uv(26, 2).cuboid(-3.0F, 1.0F, -5.0F, 1.0F, 6.0F, 1.0F)
                        .uv(30, 2).cuboid(2.0F, 1.0F, -5.0F, 1.0F, 6.0F, 1.0F)
                        .uv(30, 51).cuboid(-3.0F, 1.0F, -4.0F, 6.0F, 6.0F, 1.0F)
                        .uv(14, 61).cuboid(-3.0F, 1.0F, 3.0F, 6.0F, 6.0F, 1.0F)
                        .uv(0, 13).cuboid(-4.0F, 0.0F, -3.0F, 8.0F, 12.0F, 6.0F),
                ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));
        ModelPartData armorLeftBoot = leftLeg.addChild("armorLeftBoot",
                ModelPartBuilder.create(),
                ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        armorLeftBoot.addChild("LeftBoot_r1",
                ModelPartBuilder.create()
                        .uv(38, 30).cuboid(-3.9F, 21.0F, -3.0F, 4.0F, 3.0F, 7.0F, new Dilation(0.1F, 0.1F, 0.1F)),
                ModelTransform.of(-2.0F, -12.0F, 0.0F, 0.0F, 3.1416F, 0.0F));
        ModelPartData armorRightArm = rightArm.addChild("armorRightArm",
                ModelPartBuilder.create()
                        .uv(52, 2).cuboid(-3.0F, 0.0F, -4.0F, 2.0F, 2.0F, 8.0F, new Dilation(0.1F, 0.1F, 0.1F)),
                ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        armorRightArm.addChild("BoltRightFar_r1",
                ModelPartBuilder.create()
                        .uv(0, 13).cuboid(1.0F, 2.0F, -0.75F, 1.0F, 2.0F, 2.0F, new Dilation(0.1F, 0.1F, 0.1F))
                        .uv(42, 12).cuboid(-4.0F, -1.0F, -3.0F, 5.0F, 8.0F, 6.0F),
                ModelTransform.of(-4.0F, -2.0F, 0.0F, 0.0F, 3.1416F, 0.0F));
        armorRightArm.addChild("CrystalRightBottom_r1",
                ModelPartBuilder.create()
                        .uv(32, 20).cuboid(1.5F, -3.5F, -2.95F, 1.0F, 3.0F, 6.0F, new Dilation(0.1F, 0.1F, 0.1F)),
                ModelTransform.of(-8.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 1.5708F));
        armorRightArm.addChild("CrystalRightTop_r1",
                ModelPartBuilder.create()
                        .uv(52, 54).cuboid(3.6569F, -2.1569F, -2.95F, 1.0F, 3.0F, 6.0F, new Dilation(0.1F, 0.1F, 0.1F)),
                ModelTransform.of(-8.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));
        ModelPartData armorLeftLeg = leftLeg.addChild("armorLeftLeg",
                ModelPartBuilder.create(),
                ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        armorLeftLeg.addChild("KneePadLeft_r1",
                ModelPartBuilder.create()
                        .cuboid(-3.6F, 15.5F, 2.5F, 3.0F, 3.0F, 1.0F, new Dilation(0.1F, 0.1F, 0.1F))
                        .uv(0, 46).cuboid(-4.05F, 12.0F, -2.5F, 4.0F, 9.0F, 5.0F, new Dilation(0.1F, 0.1F, 0.1F)),
                ModelTransform.of(-2.0F, -12.0F, 0.0F, 0.0F, 3.1416F, 0.0F));
        ModelPartData armorHead = head.addChild("armorHead",
                ModelPartBuilder.create()
                        .uv(0, 60).cuboid(-1.0F, -4.0F, 1.0F, 2.0F, 4.0F, 5.0F),
                ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        armorHead.addChild("HelmetBack_r1",
                ModelPartBuilder.create()
                        .uv(53, 26).cuboid(-4.0F, -6.0F, -5.0F, 8.0F, 5.0F, 1.0F)
                        .uv(0, 0).cuboid(-4.0F, -9.0F, -5.0F, 8.0F, 3.0F, 10.0F)
                        .uv(16, 19).cuboid(-1.0F, -10.0F, -6.0F, 2.0F, 6.0F, 12.0F)
                        .uv(60, 57).cuboid(4.0F, -4.0F, -5.0F, 1.0F, 3.0F, 6.0F)
                        .uv(26, 3).cuboid(4.0F, -9.0F, -5.0F, 1.0F, 5.0F, 10.0F)
                        .uv(60, 48).cuboid(-5.0F, -4.0F, -5.0F, 1.0F, 3.0F, 6.0F)
                        .uv(0, 31).cuboid(-5.0F, -9.0F, -5.0F, 1.0F, 5.0F, 10.0F),
                ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));
        ModelPartData armorLeftArm = leftArm.addChild("armorLeftArm",
                ModelPartBuilder.create()
                        .uv(18, 51).cuboid(1.0F, 0.0F, -4.0F, 2.0F, 2.0F, 8.0F, new Dilation(0.1F, 0.1F, 0.1F)),
                ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        armorLeftArm.addChild("BoltLeftFar_r1",
                ModelPartBuilder.create()
                        .uv(0, 31).cuboid(-10.0F, 2.0F, -0.75F, 1.0F, 2.0F, 2.0F, new Dilation(0.1F, 0.1F, 0.1F))
                        .uv(22, 37).cuboid(-9.0F, -1.0F, -3.0F, 5.0F, 8.0F, 6.0F),
                ModelTransform.of(-4.0F, -2.0F, 0.0F, 0.0F, 3.1416F, 0.0F));
        armorLeftArm.addChild("CrystalLeftBottom_r1",
                ModelPartBuilder.create()
                        .uv(38, 54).cuboid(1.5F, -15.5F, -2.95F, 1.0F, 3.0F, 6.0F, new Dilation(0.1F, 0.1F, 0.1F)),
                ModelTransform.of(-8.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 1.5708F));
        armorLeftArm.addChild("CrysalLeftTop_r1",
                ModelPartBuilder.create()
                        .uv(57, 34).cuboid(6.5F, -13.5F, -2.95F, 1.0F, 3.0F, 6.0F, new Dilation(0.1F, 0.1F, 0.1F)),
                ModelTransform.of(-8.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

        return TexturedModelData.of(data, 128, 128);
    }
}
