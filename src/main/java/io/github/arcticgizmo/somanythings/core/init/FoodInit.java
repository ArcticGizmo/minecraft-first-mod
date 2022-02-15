package io.github.arcticgizmo.somanythings.core.init;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class FoodInit {
  public static final FoodProperties EXAMPLE_FOOD = new FoodProperties.Builder()
      .nutrition(5)
      .saturationMod(0.1f)
      .alwaysEat()
      .fast()
      .effect(() -> new MobEffectInstance(MobEffects.JUMP, 200, 2), 0.5f)
      .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 50, 1), 0.5f)
      .build();

}
