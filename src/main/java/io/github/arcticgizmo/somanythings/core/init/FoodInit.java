package io.github.arcticgizmo.somanythings.core.init;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class FoodInit {
  public static final Food EXAMPLE_FOOD = new Food.Builder()
      .effect(() -> new EffectInstance(Effects.SPEED, 200, 2), 0.5f)
      .effect(() -> new EffectInstance(Effects.POISON, 50, 1), 0.5f)
      .fastToEat()
      .hunger(2)
      .saturation(0.1f)
      .setAlwaysEdible()
      .build();
}
