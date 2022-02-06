package io.github.arcticgizmo.somanythings;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.github.arcticgizmo.somanythings.common.Tab;
import io.github.arcticgizmo.somanythings.core.init.BlockInit;
import io.github.arcticgizmo.somanythings.core.init.ItemInit;
import io.github.arcticgizmo.somanythings.world.OreGen;

@Mod(SoManyThings.MOD_ID)
public class SoManyThings {
  // Directly reference a log4j logger.
  public static final Logger LOGGER = LogManager.getLogger();
  public static final String MOD_ID = "somanythings";
  public static final ItemGroup TAB = new Tab();

  public SoManyThings() {
    IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
    bus.addListener(this::setup);

    ItemInit.ITEMS.register(bus);
    BlockInit.BLOCKS.register(bus);

    MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, OreGen::generateOres);

    MinecraftForge.EVENT_BUS.register(this);
  }

  private void setup(final FMLCommonSetupEvent event) {

  }

}
