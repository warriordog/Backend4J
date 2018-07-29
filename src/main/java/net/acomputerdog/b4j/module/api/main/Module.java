package net.acomputerdog.b4j.module.api.main;


public interface Module {
    void init(ModuleContext context);

    void start();

    void shutdown();
}
