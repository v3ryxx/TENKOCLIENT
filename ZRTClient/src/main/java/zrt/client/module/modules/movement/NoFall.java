package zrt.client.module.modules.movement;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import zrt.client.ZRTClient;
import zrt.client.event.Events;
import zrt.client.module.Module;
public class NoFall extends Module {
    public NoFall() { super("NoFall","Prevents fall damage",Category.MOVEMENT); }
    @Override public void onEnable() { ZRTClient.eventBus.subscribe(Events.TickEvent.class, e -> { if(mc.player!=null&&mc.player.fallDistance>2f) mc.player.networkHandler.sendPacket(new PlayerMoveC2SPacket.PositionAndOnGround(mc.player.getX(),mc.player.getY(),mc.player.getZ(),true)); }); }
}
