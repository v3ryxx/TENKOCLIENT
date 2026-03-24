package zrt.client.module.modules.movement;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import org.lwjgl.glfw.GLFW;
import zrt.client.ZRTClient;
import zrt.client.event.Events;
import zrt.client.module.Module;

public class Fly extends Module {
    public final Setting<Double> speed = addSetting("Speed", 0.15, 0.05, 2.0);
    public Fly() { super("Fly","Fly in survival",Category.MOVEMENT,GLFW.GLFW_KEY_F); }
    @Override public void onEnable()  { if(mc.player!=null){mc.player.getAbilities().allowFlying=true;mc.player.getAbilities().flying=true;} }
    @Override public void onDisable() { if(mc.player!=null){mc.player.getAbilities().allowFlying=mc.player.isCreative();mc.player.getAbilities().flying=false;} }
}
