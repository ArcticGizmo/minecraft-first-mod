package io.github.arcticgizmo.somanythings.core.events;

import java.util.Random;

import io.github.arcticgizmo.somanythings.SoManyThings;
import io.github.arcticgizmo.somanythings.common.blocks.CustomBlock;
import io.github.arcticgizmo.somanythings.core.init.BlockInit;
import net.minecraft.block.AnvilBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.ArmorStandEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = SoManyThings.MOD_ID, bus = Bus.FORGE)
public class EventHandler {
  @SubscribeEvent
  public static void onBlockBreak(final BlockEvent.BreakEvent event) {
    IWorld world = event.getWorld();
    BlockPos pos = event.getPos();
    if (event.getState().getBlock() instanceof AnvilBlock) {
      setBlocks(world, pos, world.getRandom());
      return;
    }

    if (event.getPlayer().hasItemInSlot(EquipmentSlotType.HEAD) && world instanceof World) {
      ArmorStandEntity armorStand = new ArmorStandEntity(EntityType.ARMOR_STAND, (World) world);
      armorStand.setPosition(pos.getX(), pos.getY(), pos.getZ());
      world.addEntity(armorStand);
    }
  }

  private static void setBlocks(IWorld world, BlockPos pos, Random rand) {
    for (int x = -5; x < 5; x++) {
      for (int y = -5; y < 5; y++) {
        for (int z = -5; z < 5; z++) {
          BlockState block = BlockInit.CUSTOM_BLOCK
              .get()
              .getDefaultState()
              .with(CustomBlock.HORIZONTAL_FACING, Direction.Plane.HORIZONTAL.random(rand));
          world.setBlockState(pos.add(x, y, z), block, Constants.BlockFlags.BLOCK_UPDATE);

        }

      }
    }
  }
}
