package net.acomputerdog.b4j.http;

import net.acomputerdog.b4j.module.ModContext;

import java.util.HashSet;
import java.util.Set;

public class Domain {
    private final String prefix;
    private final ModContext module;

    private final Set<RequestListener> listeners;

    public Domain(String prefix, ModContext module) {
        this.prefix = prefix;
        this.module = module;

        this.listeners = new HashSet<>();
    }

    public String getPrefix() {
        return prefix;
    }

    public ModContext getModule() {
        return module;
    }

    public void addListener(RequestListener listener) {
        listeners.add(listener);
    }

    public void removeListener(RequestListener listener) {
        listeners.remove(listener);
    }
}
