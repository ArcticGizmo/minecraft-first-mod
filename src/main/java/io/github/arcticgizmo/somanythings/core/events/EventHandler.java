package io.github.arcticgizmo.somanythings.core.events;

import java.util.Random;

import io.github.arcticgizmo.somanythings.SoManyThings;
import io.github.arcticgizmo.somanythings.common.blocks.CustomBlock;
import io.github.arcticgizmo.somanythings.core.init.BlockInit;
import net.minecraft.client.renderer.FaceInfo.Constants;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.AnvilBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = SoManyThings.MOD_ID, bus = Bus.FORGE)
public class EventHandler {

  @SubscribeEvent
  public static void onBlockBreak(final BlockEvent.BreakEvent event) {
    LevelAccessor world = event.getWorld();
    BlockPos pos = event.getPos();
    if (event.getState().getBlock() instanceof AnvilBlock) {
      setBlocks(world, pos, world.getRandom());
      return;
    }

    if (event.getPlayer().hasItemInSlot(EquipmentSlot.HEAD)) {
      // ArmorStand armorStand = new ArmorStand(EntityType.ARMOR_STAND, world);
      // armorStand.setPos(pos.getX(), pos.getY(), pos.getZ());
      // world.addFreshEntity(armorStand);
    }
  }

  private static void setBlocks(LevelAccessor world, BlockPos pos, Random rand) {
    // for (int x = -5; x < 5; x++) {
    // for (int y = -5; y < 5; y++) {
    // for (int z = -5; z < 5; z++) {
    // BlockState block = BlockInit.CUSTOM_BLOCK
    // .get()
    // .with(CustomBlock.HORIZONTAL_FACING, Direction.Plane.HORIZONTAL.random(rand));
    // world.setBlockState(pos.add(x, y, z), block, Constants.BlockFlags.BLOCK_UPDATE);

    // }

    // }
    // }
  }
}
