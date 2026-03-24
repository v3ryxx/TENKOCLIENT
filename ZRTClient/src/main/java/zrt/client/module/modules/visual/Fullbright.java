package zrt.client.module.modules.visual;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import zrt.client.ZRTClient;
import zrt.client.event.Events;
import zrt.client.module.Module;
public class Fullbright extends Module {
    public Fullbright() { super("Fullbright","Night vision always active",Category.VISUAL); }
    @Override public void onEnable()  { ZRTClient.eventBus.subscribe(Events.TickEvent.class, e -> { if(mc.player!=null) mc.player.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION,800,0,false,false,false)); }); }
    @Override public void onDisable() { if(mc.player!=null) mc.player.removeStatusEffect(StatusEffects.NIGHT_VISION); }
}
