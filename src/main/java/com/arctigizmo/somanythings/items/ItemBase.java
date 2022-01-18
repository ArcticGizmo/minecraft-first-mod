package com.arctigizmo.somanythings.items;

import com.arctigizmo.somanythings.SoManyThings;

import net.minecraft.item.Item;

public class ItemBase extends Item {
  public ItemBase() {
    super(new Item.Properties().group(SoManyThings.TAB));
  }
}
