package io.github.arcticgizmo.somanythings.common.items;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class SpecialItem extends Item {

  public SpecialItem(Properties properties) {
    super(properties);
  }

  @Override
  @OnlyIn(Dist.CLIENT)
  public InteractionResult useOn(UseOnContext context) {
    Player player = context.getPlayer();
    Level level = context.getLevel();

    if (player.getCooldowns().isOnCooldown(this)) {
      return InteractionResult.FAIL;
    }

    player.getCooldowns().addCooldown(this, 1000);

    player.addEffect(new MobEffectInstance(MobEffects.GLOWING, 200));

    Zombie zombie = new Zombie(level);
    zombie.setPos(player.getX(), player.getY(), player.getZ());

    level.addFreshEntity(zombie);

    return InteractionResult.CONSUME;
  }

  // @Override
  // @OnlyIn(Dist.CLIENT)
  // public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
  // super.addInformation(stack, worldIn, tooltip, flagIn);
  // if (InputMappings.isKeyDown(Minecraft.getInstance().getMainWindow().getHandle(), GLFW.GLFW_KEY_LEFT_SHIFT)) {
  // tooltip.add(new TranslationTextComponent("tooltip.somanythings.special_item.with_shift"));

  // } else {
  // tooltip.add(new TranslationTextComponent("tooltip.somanythings.special_item.without_shift"));

  // }
  // }

}
