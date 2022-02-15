package io.github.arcticgizmo.somanythings.common.blocks;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BaseHorizonalBlock extends Block {

  
  public static final DirectionProperty HORIZONTAL_FACING = BlockStateProperties.HORIZONTAL_FACING;
  public static final Map<Direction, VoxelShape> SHAPES = new HashMap<Direction, VoxelShape>();

  public BaseHorizonalBlock(Properties properties) {
    super(properties);
    // this.setDefaultState(this.stateContainer.getBaseState().with(HORIZONTAL_FACING, Direction.NORTH));
  }

  // @Override
  // public BlockState mirror(BlockState state, Mirror mirrorIn) {
  //   // TODO Auto-generated method stub
  //   return state.rotate(mirrorIn.toRotation(state.get(HORIZONTAL_FACING)));
  // }

  // @Override
  // public BlockState rotate(BlockState state, LevelAccessor world, BlockPos pos, Rotation direction) {
  //   return state.with(HORIZONTAL_FACING, direction.rotate(state.get(HORIZONTAL_FACING)));
  // }

  // @Override
  // public BlockState getStateForPlacement(BlockPlaceContext context) {
  //   return this.getDefaultState().with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing().getOpposite());
  // }


  // // @Override
  // // protected void fillStateContainer(Builder<Block, BlockState> builder) {

  // //   super.fillStateContainer(builder);
  // //   builder.add(HORIZONTAL_FACING);
  // // }

  // protected static void calculateShapes(Direction to, VoxelShape shape) {
  //   VoxelShape[] buffer = new VoxelShape[] { shape, VoxelShapes.empty() };

  //   int times = (to.getHorizontalIndex() - Direction.NORTH.getHorizontalIndex() + 4) % 4;
  //   for (int i = 0; i < times; i++) {
  //     buffer[0].forEachBox((minX, minY, minZ, maxX, maxY, maxZ) -> buffer[1] = VoxelShapes.or(buffer[1],
  //         VoxelShapes.create(1 - maxZ, minY, minX, 1 - minZ, maxY, maxX)));
  //     buffer[0] = buffer[1];
  //     buffer[1] = VoxelShapes.empty();
  //   }

  //   SHAPES.put(to, buffer[0]);
  // }

  // protected void runCalculation(VoxelShape shape) {
  //   for (Direction direction : Direction.values()) {
  //     calculateShapes(direction, shape);
  //   }
  // }
}
