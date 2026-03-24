package zrt.client.module.modules.visual;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import zrt.client.ZRTClient;
import zrt.client.event.Events;
import zrt.client.module.Module;
import zrt.client.util.RenderUtil;
import java.awt.Color;
public class Tracers extends Module {
    public Tracers() { super("Tracers","Lines to nearby entities",Category.VISUAL); }
    @Override public void onEnable() {
        ZRTClient.eventBus.subscribe(Events.RenderWorldEvent.class, e -> {
            if(mc.world==null||mc.player==null) return;
            for(Entity en:mc.world.getEntities()){
                if(en==mc.player||!(en instanceof LivingEntity)) continue;
                Color c=en instanceof PlayerEntity?new Color(255,100,100,200):new Color(100,255,100,200);
                RenderUtil.drawTracer(e.matrices,en,c,e.tickDelta);
            }
        });
    }
}
