package io.github.arcticgizmo.somanythings.world;

import io.github.arcticgizmo.somanythings.core.init.BlockInit;

import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class OreGen {
  // public static void generateOres(final BiomeLoadingEvent event) {
  // if (isOverworld(event)) {
  // generateOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
  // BlockInit.EXAMPLE_ORE.get().getDefaultState(), 5, 15, 30, 10);
  // }
  // // event.getCategory to determine the biome if you only want it to spawn there

  // }

  // private static boolean isOverworld(final BiomeLoadingEvent event) {
  // boolean isNether = event.getCategory().equals(Biome.Category.NETHER);
  // boolean isEnd = event.getCategory().equals(Biome.Category.THEEND);
  // return !(isNether || isEnd);
  // }

  // private static void generateOre(BiomeGenerationSettingsBuilder settings, RuleTest fillerType, BlockState state,
  // int veinSize,
  // int minHeight, int maxHeight, int quantity) {
  // settings.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
  // Feature.ORE.withConfiguration(new OreFeatureConfig(fillerType, state, veinSize))
  // .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(minHeight, 0, maxHeight))).square()
  // .func_242731_b(quantity));
  // }
}
