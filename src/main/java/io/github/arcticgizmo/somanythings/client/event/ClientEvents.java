package io.github.arcticgizmo.somanythings.client.event;

import io.github.arcticgizmo.somanythings.SoManyThings;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = SoManyThings.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {

}
