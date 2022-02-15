package io.github.arcticgizmo.somanythings.common;

import io.github.arcticgizmo.somanythings.core.init.ItemInit;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class Tab extends CreativeModeTab {

  public Tab() {
    super("somanythings.tab");
  }

  @Override
  public ItemStack makeIcon() {
    return ItemInit.EXAMPLE_ITEM.get().getDefaultInstance();
  }

}
