package com.arctigizmo.somanythings.util;

import com.arctigizmo.somanythings.SoManyThings;
import com.arctigizmo.somanythings.items.ItemBase;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {

  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
      SoManyThings.MOD_ID);

  public static void init() {
    ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
  }

  public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", ItemBase::new);
}