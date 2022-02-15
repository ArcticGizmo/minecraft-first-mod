package io.github.arcticgizmo.somanythings.common.blocks;

public class CustomBlock extends BaseHorizonalBlock {

  // private static final VoxelShape SHAPE = Stream.of(
  // Block.makeCuboidShape(1, 0, 1, 15, 1, 15),
  // Block.makeCuboidShape(3, 1, 3, 13, 2, 13),
  // Block.makeCuboidShape(5, 2, 5, 11, 3, 11),
  // Block.makeCuboidShape(7, 3, 7, 9, 10, 9),
  // Block.makeCuboidShape(7, 8, 2, 9, 10, 7))
  // .reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

  public CustomBlock(Properties properties) {
    super(properties);
    // runCalculation(SHAPE);
  }

  // @Override
  // public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
  // return SHAPES.get(state.get(HORIZONTAL_FACING));
  // }

}
