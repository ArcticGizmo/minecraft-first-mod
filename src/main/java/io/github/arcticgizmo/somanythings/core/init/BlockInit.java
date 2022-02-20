package io.github.arcticgizmo.somanythings.core.init;

import io.github.arcticgizmo.somanythings.SoManyThings;
import io.github.arcticgizmo.somanythings.common.blocks.PigSummonerBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {

  public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
      SoManyThings.MOD_ID);

  public static final RegistryObject<Block> EXAMPLE_BLOCK = BLOCKS.register("example_block",
      () -> new Block(BlockBehaviour.Properties
          .of(Material.METAL, MaterialColor.COLOR_BLUE)
          .strength(2f, 30f)
          .sound(SoundType.METAL)
          .requiresCorrectToolForDrops()));

  public static final RegistryObject<PigSummonerBlock> PIG_SUMMONER_BLOCK = BLOCKS
      .register("pig_summoner_block", () -> new PigSummonerBlock(BlockBehaviour.Properties
          .of(Material.METAL, MaterialColor.TERRACOTTA_ORANGE)
          .strength(28f, 30f)
          .sound(SoundType.METAL)
          .requiresCorrectToolForDrops()));
}
