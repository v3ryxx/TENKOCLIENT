package zrt.client.module.modules.donut;

import zrt.client.module.Module;

public class NameProtect extends Module {
    public final Setting<String> fakeName = addSetting("Fake Name", "Steve");
    public NameProtect() { super("NameProtect","Hides your name in chat",Category.DONUT); }

    public String protect(String text) {
        if (!isEnabled() || mc.player == null) return text;
        return text.replace(mc.player.getName().getString(), fakeName.get());
    }
}
