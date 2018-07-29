package net.acomputerdog.b4j.log;

public enum LogLevel {
    TRACE("TRACE"),
    DEBUG("DEBUG"),
    INFO("INFO"),
    WARN("WARN"),
    ERROR("ERROR"),
    FATAL("FATAL"),
    RAW("");

    private final String label;

    LogLevel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
