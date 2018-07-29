package net.acomputerdog.b4j.main;

import net.acomputerdog.b4j.ex.ConfigException;

public class B4JConfig {
    private int port = 80;

    public B4JConfig() {

    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public static B4JConfig createFromArgs(String[] args) {
        B4JConfig cfg = new B4JConfig();

        for (String arg : args) {
            String key = arg;
            String value = null;

            // split arg into key and value
            int split = arg.indexOf('=');
            if (split > 0 && split < arg.length() - 1) {
                key = arg.substring(0, split);
                value = arg.substring(split + 1);
            }

            try {
                switch (key.toLowerCase()) {
                    case ("-p"):
                        cfg.port = Integer.parseInt(value);
                        break;
                    default:
                        throw new ConfigException("Unknown switch: " + key);
                }
            } catch (NumberFormatException e) {
                throw new ConfigException("Wrong argument format for " + key + ": " + arg);
            } catch (NullPointerException e) {
                throw new ConfigException("Switch requires an argument: " + key);
            }
        }

        return cfg;
    }
}
