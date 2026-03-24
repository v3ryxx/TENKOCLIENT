package zrt.client.module.modules.movement;
import zrt.client.ZRTClient;
import zrt.client.event.Events;
import zrt.client.module.Module;
public class Sprint extends Module {
    public Sprint() { super("Sprint","Always sprint",Category.MOVEMENT); }
    @Override public void onEnable() { ZRTClient.eventBus.subscribe(Events.TickEvent.class, e -> { if(mc.player!=null&&mc.player.forwardSpeed>0) mc.player.setSprinting(true); }); }
}
