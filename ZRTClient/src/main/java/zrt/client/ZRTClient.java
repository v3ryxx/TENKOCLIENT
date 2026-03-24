package zrt.client;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zrt.client.event.EventBus;
import zrt.client.gui.ClickGUI;
import zrt.client.module.ModuleManager;

public class ZRTClient implements ClientModInitializer {
    public static final String NAME    = "ZRT Client";
    public static final String VERSION = "1.0.0";
    public static final Logger LOGGER  = LoggerFactory.getLogger("ZRTClient");
    public static ZRTClient     INSTANCE;
    public static EventBus      eventBus;
    public static ModuleManager moduleManager;
    public static ClickGUI      clickGUI;

    @Override
    public void onInitializeClient() {
        INSTANCE      = this;
        eventBus      = new EventBus();
        moduleManager = new ModuleManager();
        clickGUI      = new ClickGUI();
        LOGGER.info("[ZRT Client] {} modules loaded.", moduleManager.getModules().size());
    }
}
