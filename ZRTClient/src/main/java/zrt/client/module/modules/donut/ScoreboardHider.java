package zrt.client.module.modules.donut;

import net.minecraft.scoreboard.ScoreboardDisplaySlot;
import zrt.client.ZRTClient;
import zrt.client.event.Events;
import zrt.client.module.Module;

public class ScoreboardHider extends Module {
    public ScoreboardHider() { super("ScoreboardHider","Hides the server scoreboard",Category.DONUT); }
    @Override public void onEnable() {
        ZRTClient.eventBus.subscribe(Events.TickEvent.class, e -> {
            if (mc.world == null) return;
            var sb = mc.world.getScoreboard();
            if (sb != null && sb.getObjectiveForSlot(ScoreboardDisplaySlot.SIDEBAR) != null)
                sb.setObjectiveSlot(ScoreboardDisplaySlot.SIDEBAR, null);
        });
    }
}
