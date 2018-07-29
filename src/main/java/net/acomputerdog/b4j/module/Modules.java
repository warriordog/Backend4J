package net.acomputerdog.b4j.module;

import net.acomputerdog.b4j.main.Backend4J;
import net.acomputerdog.b4j.module.api.main.Module;
import net.acomputerdog.b4j.module.api.module.ModuleManager;

public class Modules implements ModuleManager {
    private final Backend4J b4j;

    public Modules(Backend4J b4j) {
        this.b4j = b4j;

        //TODO load modules
    }

    // Initializes all modules
    public void sendInit() {

    }

    // Informs all modules that server has started
    public void sendStart() {

    }

    // Informs all modules that server is shutting down
    public void sendShutdown() {

    }

    @Override
    public void disableModule(Module mod) {

    }
}
