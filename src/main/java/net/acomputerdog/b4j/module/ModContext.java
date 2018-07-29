package net.acomputerdog.b4j.module;

import net.acomputerdog.b4j.main.Backend4J;
import net.acomputerdog.b4j.module.api.main.B4J;
import net.acomputerdog.b4j.module.api.main.Module;
import net.acomputerdog.b4j.module.api.main.ModuleContext;
import net.acomputerdog.b4j.module.api.module.ModuleManager;
import net.acomputerdog.b4j.module.api.web.WebServer;

public class ModContext implements ModuleContext {
    private final Backend4J b4j;
    private final Module module;

    public ModContext(Backend4J b4j, Module module) {
        this.b4j = b4j;
        this.module = module;
    }

    public Module getModule() {
        return module;
    }

    @Override
    public B4J getB4J() {
        return b4j;
    }

    @Override
    public WebServer getWebServer() {
        return b4j.getWebServer();
    }

    @Override
    public ModuleManager getModuleManager() {
        return b4j.getModuleManager();
    }
}
