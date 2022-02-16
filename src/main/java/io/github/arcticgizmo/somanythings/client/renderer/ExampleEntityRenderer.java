package io.github.arcticgizmo.somanythings.client.renderer;

import io.github.arcticgizmo.somanythings.SoManyThings;
import io.github.arcticgizmo.somanythings.client.renderer.model.ExampleEntityModel;
import io.github.arcticgizmo.somanythings.common.entity.ExampleEntity;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;

public class ExampleEntityRenderer<Type extends ExampleEntity> extends MobRenderer<Type, ExampleEntityModel<Type>> {

  private static final ResourceLocation TEXTURE = new ResourceLocation(SoManyThings.MOD_ID,
      "textures/entities/example_entity.png");

  public ExampleEntityRenderer(Context context) {
    super(context, new ExampleEntityModel<>(context.bakeLayer(ExampleEntityModel.LAYER_LOCATION)), 0.5f);
  }

  @Override
  public ResourceLocation getTextureLocation(Type p_114482_) {
    return TEXTURE;
  }

}
