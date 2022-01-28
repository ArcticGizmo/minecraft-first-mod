package io.github.arcticgizmo.somanythings.core.init;

import io.github.arcticgizmo.somanythings.SoManyThings;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {

  public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
      SoManyThings.MOD_ID);

  public static final RegistryObject<Block> EXAMPLE_BLOCK = BLOCKS.register("example_block",
      () -> new Block(Block.Properties
          .create(Material.IRON, MaterialColor.BLUE)
          .hardnessAndResistance(15f, 30f)
          .harvestTool(ToolType.PICKAXE)
          .harvestLevel(1)
          .sound(SoundType.METAL)));
}
