package io.github.arcticgizmo.somanythings.common.items;

import java.util.List;

import org.lwjgl.glfw.GLFW;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.util.InputMappings;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class SpecialItem extends Item {

  public SpecialItem(Properties properties) {
    super(properties);
  }

  @Override
  @OnlyIn(Dist.CLIENT)
  public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
    super.addInformation(stack, worldIn, tooltip, flagIn);
    if (InputMappings.isKeyDown(Minecraft.getInstance().getMainWindow().getHandle(), GLFW.GLFW_KEY_LEFT_SHIFT)) {
      tooltip.add(new TranslationTextComponent("tooltip.somanythings.special_item.with_shift"));

    } else {
      tooltip.add(new TranslationTextComponent("tooltip.somanythings.special_item.without_shift"));

    }
  }

  @Override
  public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
    if (playerIn.getCooldownTracker().hasCooldown(this)) {
      return ActionResult.resultFail(playerIn.getHeldItem(handIn));
    }

    playerIn.getCooldownTracker().setCooldown(this, 1000);

    playerIn.addPotionEffect(new EffectInstance(Effects.GLOWING, 200, 5));
    ZombieEntity zombie = new ZombieEntity(worldIn);
    zombie.setPosition(playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ());
    worldIn.addEntity(zombie);

    return ActionResult.resultSuccess(playerIn.getHeldItem(handIn));
  }
}