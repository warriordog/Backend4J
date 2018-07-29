package net.acomputerdog.b4j.module.api.main;

import net.acomputerdog.b4j.module.api.module.ModuleManager;
import net.acomputerdog.b4j.module.api.web.WebServer;

public interface ModuleContext {
    B4J getB4J();
    WebServer getWebServer();
    ModuleManager getModuleManager();
}
