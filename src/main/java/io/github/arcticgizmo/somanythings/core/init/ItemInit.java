package io.github.arcticgizmo.somanythings.core.init;

import io.github.arcticgizmo.somanythings.SoManyThings;
import io.github.arcticgizmo.somanythings.common.items.SpecialItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
      SoManyThings.MOD_ID);

  public static final RegistryObject<Item> EXAMPLE_ITEM = ITEMS.register("example_item",
      () -> new Item(new Item.Properties().group(SoManyThings.TAB)));

  public static final RegistryObject<SpecialItem> SPECIAL_ITEM = ITEMS.register("special_item",
      () -> new SpecialItem(new Item.Properties().group(SoManyThings.TAB)));

  // Block Items
  public static final RegistryObject<BlockItem> EXAMPLE_BLOCK = ITEMS.register("example_block",
      () -> new BlockItem(BlockInit.EXAMPLE_BLOCK.get(), new Item.Properties().group(SoManyThings.TAB)));

  public static final RegistryObject<BlockItem> CUSTOM_BLOCK = ITEMS.register("custom_block",
      () -> new BlockItem(BlockInit.CUSTOM_BLOCK.get(), new Item.Properties().group(SoManyThings.TAB)));
}
