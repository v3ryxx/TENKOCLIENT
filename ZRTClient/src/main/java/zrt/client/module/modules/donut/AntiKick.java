package zrt.client.module.modules.donut;

import zrt.client.ZRTClient;
import zrt.client.event.Events;
import zrt.client.module.Module;

public class AntiKick extends Module {
    private int tick = 0;
    public AntiKick() { super("AntiKick","Prevents AFK kick",Category.DONUT); }
    @Override public void onEnable() {
        ZRTClient.eventBus.subscribe(Events.TickEvent.class, e -> {
            if (mc.player == null || mc.currentScreen != null) return;
            if (++tick < 600) return;
            tick = 0;
            mc.player.setSneaking(true);
            mc.player.setSneaking(false);
        });
    }
}
