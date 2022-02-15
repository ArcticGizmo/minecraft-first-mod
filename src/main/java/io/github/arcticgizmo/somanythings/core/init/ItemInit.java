package io.github.arcticgizmo.somanythings.core.init;

import io.github.arcticgizmo.somanythings.SoManyThings;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {

  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
      SoManyThings.MOD_ID);

  public static final RegistryObject<Item> EXAMPLE_ITEM = ITEMS.register("example_item",
      () -> new Item(new Item.Properties().tab(SoManyThings.TAB)));

  // public static final RegistryObject<SpecialItem> SPECIAL_ITEM = ITEMS.register("special_item",
  // () -> new SpecialItem(new Item.Properties().tab(SoManyThings.TAB)));

  // public static final RegistryObject<Item> EXAMPLE_FOOD = ITEMS.register("example_food",
  // () -> new Item(new Item.Properties()
  // .tab(SoManyThings.TAB)
  // .food(FoodInit.EXAMPLE_FOOD)));

  // Block Items
  public static final RegistryObject<BlockItem> EXAMPLE_BLOCK = ITEMS.register("example_block",
      () -> new BlockItem(BlockInit.EXAMPLE_BLOCK.get(), new Item.Properties().tab(SoManyThings.TAB)));

  // public static final RegistryObject<BlockItem> CUSTOM_BLOCK = ITEMS.register("custom_block",
  //     () -> new BlockItem(BlockInit.CUSTOM_BLOCK.get(), new Item.Properties().tab(SoManyThings.TAB)));

  // public static final RegistryObject<BlockItem> EXAMPLE_ORE = ITEMS.register("example_ore",
  //     () -> new BlockItem(BlockInit.EXAMPLE_ORE.get(), new Item.Properties().tab(SoManyThings.TAB)));
}
