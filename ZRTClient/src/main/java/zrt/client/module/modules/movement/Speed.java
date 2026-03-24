package zrt.client.module.modules.movement;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import zrt.client.ZRTClient;
import zrt.client.event.Events;
import zrt.client.module.Module;
public class Speed extends Module {
    public final Setting<Double> amplifier = addSetting("Amplifier", 4.0, 0.0, 10.0);
    public Speed() { super("Speed","Move faster",Category.MOVEMENT); }
    @Override public void onEnable()  { ZRTClient.eventBus.subscribe(Events.TickEvent.class, e -> { if(mc.player!=null) mc.player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED,40,amplifier.get().intValue(),false,false,false)); }); }
    @Override public void onDisable() { if(mc.player!=null) mc.player.removeStatusEffect(StatusEffects.SPEED); }
}
