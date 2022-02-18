package io.github.arcticgizmo.somanythings.core.init;

import io.github.arcticgizmo.somanythings.SoManyThings;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SoundInit {
  public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS,
      SoManyThings.MOD_ID);

  public static final RegistryObject<SoundEvent> EXAMPLE_ENTITY_AMBIENT = SOUNDS.register(
      "entity.example_entity.sound.ambient",
      () -> new SoundEvent(new ResourceLocation(SoManyThings.MOD_ID, "entity.example_entity.sound.ambient")));

  public static final RegistryObject<SoundEvent> EXAMPLE_ENTITY_HURT = SOUNDS.register(
      "entity.example_entity.sound.hurt",
      () -> new SoundEvent(new ResourceLocation(SoManyThings.MOD_ID, "entity.example_entity.sound.hurt")));

  public static final RegistryObject<SoundEvent> EXAMPLE_ENTITY_DEATH = SOUNDS.register(
      "entity.example_entity.sound.death",
      () -> new SoundEvent(new ResourceLocation(SoManyThings.MOD_ID, "entity.example_entity.sound.death")));
}
