package io.github.arcticgizmo.somanythings.client.event;

import io.github.arcticgizmo.somanythings.SoManyThings;
import io.github.arcticgizmo.somanythings.client.renderer.ExampleEntityRenderer;
import io.github.arcticgizmo.somanythings.client.renderer.model.ExampleEntityModel;
import io.github.arcticgizmo.somanythings.core.init.EntityInit;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = SoManyThings.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {

  private ClientModEvents() {

  }

  @SubscribeEvent
  public static void clientSetup(EntityRenderersEvent.RegisterLayerDefinitions event) {
    event.registerLayerDefinition(ExampleEntityModel.LAYER_LOCATION, ExampleEntityModel::createBodyLayer);
  }

  @SubscribeEvent
  public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
    event.registerEntityRenderer(EntityInit.EXAMPLE_ENTITY.get(), ExampleEntityRenderer::new);
  }
}
