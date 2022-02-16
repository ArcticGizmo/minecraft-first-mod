package io.github.arcticgizmo.somanythings.core.events;

import io.github.arcticgizmo.somanythings.SoManyThings;
import io.github.arcticgizmo.somanythings.common.entity.ExampleEntity;
import io.github.arcticgizmo.somanythings.core.init.EntityInit;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = SoManyThings.MOD_ID, bus = Bus.MOD)
public class CommonModEvents {

  @SubscribeEvent
  public static void registerAttributes(EntityAttributeCreationEvent event) {
    event.put(EntityInit.EXAMPLE_ENTITY.get(), ExampleEntity.createAttributes().build());
  }
}
