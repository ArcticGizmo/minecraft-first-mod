package io.github.arcticgizmo.somanythings.common;

import io.github.arcticgizmo.somanythings.core.init.ItemInit;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class Tab extends ItemGroup {

  public Tab() {
    super("somanythings.tab");
  }

  @Override
  public ItemStack createIcon() {
    return ItemInit.EXAMPLE_ITEM.get().getDefaultInstance();
  }
}
