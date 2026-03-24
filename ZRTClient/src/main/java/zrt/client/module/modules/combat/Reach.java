package zrt.client.module.modules.combat;
import zrt.client.module.Module;
public class Reach extends Module {
    public final Setting<Double> extra = addSetting("Extra Reach", 1.5, 0.1, 3.0);
    public Reach() { super("Reach","Increases attack/block range",Category.COMBAT); }
}
