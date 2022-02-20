package io.github.arcticgizmo.somanythings.core.init;

import io.github.arcticgizmo.somanythings.SoManyThings;
import io.github.arcticgizmo.somanythings.common.items.SpecialItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {

  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
      SoManyThings.MOD_ID);

  public static final RegistryObject<Item> EXAMPLE_ITEM = ITEMS.register("example_item",
      () -> new Item(new Item.Properties().tab(SoManyThings.TAB)));

  public static final RegistryObject<SpecialItem> SPECIAL_ITEM = ITEMS.register("special_item",
      () -> new SpecialItem(new Item.Properties().tab(SoManyThings.TAB)));

  public static final RegistryObject<Item> EXAMPLE_FOOD = ITEMS.register("example_food",
      () -> new Item(new Item.Properties()
          .tab(SoManyThings.TAB)
          .food(FoodInit.EXAMPLE_FOOD)));

  public static final RegistryObject<ForgeSpawnEggItem> EXAMPLE_ENTITY_SPAWN_EGG = ITEMS
      .register("example_entity_spawn_egg", () -> new ForgeSpawnEggItem(EntityInit.EXAMPLE_ENTITY, 0x1E51ED, 0x34BD27,
          new Item.Properties()
              .tab(SoManyThings.TAB)
              .stacksTo(16)));

  // Block Items
  public static final RegistryObject<BlockItem> EXAMPLE_BLOCK = ITEMS.register("example_block",
      () -> new BlockItem(BlockInit.EXAMPLE_BLOCK.get(), new Item.Properties().tab(SoManyThings.TAB)));

  public static final RegistryObject<BlockItem> PIG_SUMMONER_BLOCK = ITEMS.register("pig_summoner_block",
      () -> new BlockItem(BlockInit.PIG_SUMMONER_BLOCK.get(), new Item.Properties().tab(SoManyThings.TAB)));

}
