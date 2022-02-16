package io.github.arcticgizmo.somanythings.client.renderer.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import io.github.arcticgizmo.somanythings.SoManyThings;
import io.github.arcticgizmo.somanythings.common.entity.ExampleEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class ExampleEntityModel<Type extends ExampleEntity> extends EntityModel<Type> {

  public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
      new ResourceLocation(SoManyThings.MOD_ID, "example_entity"), "main");
  private final ModelPart body;

  public ExampleEntityModel(ModelPart root) {
    this.body = root.getChild("body");
  }

  public static LayerDefinition createBodyLayer() {
    MeshDefinition meshdefinition = new MeshDefinition();
    PartDefinition partdefinition = meshdefinition.getRoot();

    PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder
        .create()
        .texOffs(0, 0)
        .addBox(-5.0F, -5.0F, -4.0F, 10.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)),
        PartPose.offset(0.0F, 24.0F, 0.0F));

    body.addOrReplaceChild("legs",
        CubeListBuilder
            .create()
            .texOffs(13, 21)
            .addBox(5.0F, -3.0F, -3.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
            .texOffs(20, 19)
            .addBox(-6.0F, -3.0F, 4.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
            .texOffs(15, 15)
            .addBox(-6.0F, -3.0F, -3.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
            .texOffs(0, 5)
            .addBox(5.0F, -3.0F, 4.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
        PartPose.offset(0.0F, 0.0F, 0.0F));

    body.addOrReplaceChild("head",
        CubeListBuilder
            .create()
            .texOffs(0, 15)
            .addBox(-2.0F, -6.0F, -7.0F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-1.0F, -7.0F, -7.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
        PartPose.offset(0.0F, 0.0F, 0.0F));

    return LayerDefinition.create(meshdefinition, 64, 64);
  }

  @Override
  public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red,
      float green, float blue, float alpha) {
    this.body.render(poseStack, buffer, packedLight, packedOverlay);
  }

  @Override
  public void setupAnim(Type entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
      float headPitch) {
    // TODO Auto-generated method stub

  }

}