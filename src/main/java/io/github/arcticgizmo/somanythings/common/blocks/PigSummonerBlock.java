package io.github.arcticgizmo.somanythings.common.blocks;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import io.github.arcticgizmo.somanythings.SoManyThings;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PigSummonerBlock extends HorizontalDirectionalBlock {

  private static final Map<Direction, VoxelShape> SHAPES = new HashMap<>();

  private static final Optional<VoxelShape> SHAPE = Stream.of(
      Block.box(4, 6, 4, 12, 14, 12),
      Block.box(0, 0, 0, 16, 1, 16),
      Block.box(7, 0, 7, 9, 8, 9),
      Block.box(0, 0, 0, 1, 5, 1),
      Block.box(0, 0, 15, 1, 5, 16),
      Block.box(15, 0, 15, 16, 5, 16),
      Block.box(15, 0, 0, 16, 5, 1)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR));

  public PigSummonerBlock(Properties properties) {
    super(properties);
    registerDefaultState(this.defaultBlockState().setValue(FACING, Direction.NORTH));
    this.runCalculation(SHAPE.orElse(Shapes.block()));
  }

  @Override
  public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
    return SHAPES.get(state.getValue(FACING));
  }

  @Override
  protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
    super.createBlockStateDefinition(builder);
    builder.add(FACING);
  }

  @Override
  public BlockState getStateForPlacement(BlockPlaceContext context) {
    return defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
  }

  @Override
  public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player,
      InteractionHand hand, BlockHitResult hit) {
    if (level.isClientSide) {
      return InteractionResult.FAIL;
    }

    boolean isNotCreative = !player.isCreative();

    if (player.experienceLevel <= 10 && isNotCreative) {
      level.playSound(player, pos, SoundEvents.ANVIL_BREAK, SoundSource.PLAYERS, 1.0f, 1.0f);
      return InteractionResult.FAIL;
    }

    if (isNotCreative) {

      player.giveExperienceLevels(-5);
    }

    level.playSound(player, pos, SoundEvents.AMBIENT_UNDERWATER_LOOP, SoundSource.BLOCKS, 1.0f, 1.0f);

    for (int i = 0; i < this.RANDOM.nextInt(10) + 7; i++) {
      Pig pig = EntityType.PIG.create(level);
      pig.setPos(
          pos.getX() + this.RANDOM.nextInt(10) - 5,
          pos.getY(),
          pos.getZ() + this.RANDOM.nextInt(10) - 5);
      level.addFreshEntity(pig);
    }

    return InteractionResult.SUCCESS;
  }

  protected static VoxelShape calculateShapes(Direction to, VoxelShape shape) {
    VoxelShape[] buffer = new VoxelShape[] { shape, Shapes.empty() };

    int times = (to.get2DDataValue() - Direction.NORTH.get2DDataValue() + 4) % 4;
    for (int i = 0; i < times; i++) {
      buffer[0].forAllBoxes((minX, minY, minZ, maxX, maxY,
          maxZ) -> buffer[1] = Shapes.or(buffer[1], Shapes.create(1 - maxZ, minY, minX, 1 - minZ, maxY, maxX)));
      buffer[0] = buffer[1];
      buffer[1] = Shapes.empty();
    }

    return buffer[0];
  }

  protected void runCalculation(VoxelShape shape) {
    for (Direction direction : Direction.values()) {
      SHAPES.put(direction, calculateShapes(direction, shape));
    }
  }

}
