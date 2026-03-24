package zrt.client.module.modules.donut;

import net.minecraft.screen.slot.SlotActionType;
import zrt.client.ZRTClient;
import zrt.client.event.Events;
import zrt.client.module.Module;

public class ChestStealer extends Module {
    public final Setting<Double> delay = addSetting("Delay (ticks)", 2.0, 1.0, 20.0);
    private int tick = 0;

    public ChestStealer() { super("ChestStealer","Auto-loots opened chests",Category.DONUT); }
    @Override public void onEnable() {
        ZRTClient.eventBus.subscribe(Events.TickEvent.class, e -> {
            if (mc.player == null || mc.interactionManager == null) return;
            var sh = mc.player.currentScreenHandler;
            if (sh == null || sh == mc.player.playerScreenHandler) return;
            if (++tick < delay.get().intValue()) return;
            tick = 0;
            for (int i = 0; i < sh.slots.size(); i++) {
                var slot = sh.slots.get(i);
                if (slot.inventory == mc.player.getInventory()) continue;
                if (!slot.getStack().isEmpty()) {
                    mc.interactionManager.clickSlot(sh.syncId, i, 0, SlotActionType.QUICK_MOVE, mc.player);
                    break;
                }
            }
        });
    }
}
