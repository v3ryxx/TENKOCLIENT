package zrt.client.module.modules.donut;

import net.minecraft.entity.player.PlayerEntity;
import zrt.client.module.Module;

public class AntiBot extends Module {
    public AntiBot() { super("AntiBot","Ignores bot players in modules",Category.DONUT); }

    public boolean isBot(PlayerEntity p) {
        if (p == null) return false;
        if (p.getGameProfile().getId().version() != 4) return true;
        if (p.getPlayerListEntry() == null) return true;
        return false;
    }
}
