package zrt.client.module.modules.misc;

import net.minecraft.text.Text;
import zrt.client.ZRTClient;
import zrt.client.event.Events;
import zrt.client.module.Module;
import java.awt.Color;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HUD extends Module {
    public HUD() { super("HUD","Client HUD overlay",Category.MISC); }

    @Override public void onEnable() {
        ZRTClient.eventBus.subscribe(Events.RenderHudEvent.class, e -> {
            if (mc.player == null) return;
            var ctx = e.context;
            var tr  = mc.textRenderer;
            // Watermark
            ctx.drawTextWithShadow(tr, Text.literal("§bZRT §fClient §7v1.0"), 4, 4, 0xFFFFFF);
            ctx.drawTextWithShadow(tr, Text.literal("§7FPS: §f" + mc.getCurrentFps()), 4, 14, 0xFFFFFF);
            // Module list right side
            List<Module> active = ZRTClient.moduleManager.getModules().stream()
                .filter(m -> m.isEnabled() && !(m instanceof HUD))
                .sorted(Comparator.comparingInt(m -> -tr.getWidth(m.getName())))
                .collect(Collectors.toList());
            int sw = mc.getWindow().getScaledWidth(), y = 4;
            for (Module m : active) {
                int w = tr.getWidth(m.getName()), x = sw - w - 5;
                Color col = catColor(m.getCategory());
                ctx.fill(x-2, y-1, sw-2, y+9, new Color(0,0,0,100).getRGB());
                ctx.fill(x-2, y-1, x-1, y+9, col.getRGB());
                ctx.drawTextWithShadow(tr, Text.literal(m.getName()), x, y, 0xFFFFFF);
                y += 11;
            }
        });
    }

    private Color catColor(Category c) {
        return switch(c) {
            case COMBAT   -> new Color(255, 80,  80);
            case MOVEMENT -> new Color(80,  255, 80);
            case VISUAL   -> new Color(80,  180, 255);
            case DONUT    -> new Color(255, 160, 60);
            case MISC     -> new Color(200, 200, 200);
        };
    }
}
