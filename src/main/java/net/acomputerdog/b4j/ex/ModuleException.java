package net.acomputerdog.b4j.ex;

import net.acomputerdog.b4j.module.ModContext;

public class ModuleException extends B4JException {
    private final ModContext mod;

    public ModuleException(ModContext mod) {
        super();
        this.mod = mod;
    }

    public ModuleException(String message, ModContext mod) {
        super(message);
        this.mod = mod;
    }

    public ModuleException(String message, Throwable cause, ModContext mod) {
        super(message, cause);
        this.mod = mod;
    }

    public ModuleException(Throwable cause, ModContext mod) {
        super(cause);
        this.mod = mod;
    }

    public ModContext getModule() {
        return mod;
    }
}
