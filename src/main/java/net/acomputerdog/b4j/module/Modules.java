package net.acomputerdog.b4j.module;

import net.acomputerdog.b4j.main.Backend4J;

public class Modules {
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
}
