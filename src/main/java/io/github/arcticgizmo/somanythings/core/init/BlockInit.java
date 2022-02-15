package io.github.arcticgizmo.somanythings.core.init;

import io.github.arcticgizmo.somanythings.SoManyThings;
import io.github.arcticgizmo.somanythings.common.blocks.CustomBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
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
          .strength(15f, 30f)
          // .harvestTool(ToolType.PICKAXE)
          // .harvestLevel(1)
          .sound(SoundType.METAL)
          .requiresCorrectToolForDrops()));

  // public static final RegistryObject<CustomBlock> CUSTOM_BLOCK = BLOCKS.register("custom_block",
  //     () -> new CustomBlock(BlockBehaviour.Properties
  //         .of(Material.WOOD)
  //         // .harvestTool(ToolType.AXE)
  //         // .harvestLevel(1)
  //         .sound(SoundType.WOOD)
  //         .requiresCorrectToolForDrops()));

  // public static final RegistryObject<Block> EXAMPLE_ORE = BLOCKS.register("example_ore",
  //     () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)));
}
