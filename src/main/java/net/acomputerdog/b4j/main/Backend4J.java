package net.acomputerdog.b4j.main;

import net.acomputerdog.b4j.ex.ConfigException;
import net.acomputerdog.b4j.ex.HTTPServerException;
import net.acomputerdog.b4j.ex.ModuleException;
import net.acomputerdog.b4j.http.HTTPServer;
import net.acomputerdog.b4j.log.Logger;
import net.acomputerdog.b4j.module.Modules;
import net.acomputerdog.b4j.module.api.main.B4J;
import net.acomputerdog.b4j.module.api.module.ModuleManager;
import net.acomputerdog.b4j.module.api.web.WebServer;

public class Backend4J implements B4J {
    public static final String VERSION = "Backend4J 0.0.0";

    private final B4JConfig config;

    private HTTPServer httpServer;
    private Modules modules;

    public Backend4J(B4JConfig config) {
        this.config = config;

        this.httpServer = new HTTPServer(this);
        this.modules = new Modules(this);
    }

    public int run() {
        try {
            // init modules (they are already loaded)
            Logger.logInfo(getClass().getName(), "Initializing B4J.");
            modules.sendInit();

            // start HTTP server
            Logger.logInfo(getClass().getName(), "Starting HTTP server.");
            httpServer.start();
            modules.sendStart();
            httpServer.setAcceptingConnections(true);

            // wait for exit
            Logger.logInfo(getClass().getName(), "Server started, joining main thread.");
            httpServer.join();

            // shutdown modules
            Logger.logInfo(getClass().getName(), "B4J shutting down.");
            modules.sendShutdown();

            // if we get here, then we are exiting normally
            return 0;
        } catch (HTTPServerException e) {
            Logger.logFatal(getClass().getName(), "Uncaught exception in HTTP server:");
            Logger.logFatal(getClass().getName(), e);
            return -3;
        }
    }

    public B4JConfig getConfig() {
        return config;
    }

    public static void main(String[] args) {
        System.out.println(VERSION);

        try {
            // read config
            B4JConfig conf = B4JConfig.createFromArgs(args);

            // create instance
            Backend4J b4j = new Backend4J(conf);

            // run and get return code
            int code = b4j.run();

            // exit with code
            System.exit(code);
        } catch (ConfigException e) {
            Logger.logFatal(Backend4J.class.getName(), "Unable to parse arguments: " + e.getMessage());
            System.exit(-2);
        } catch (ModuleException e) {
            Logger.logFatal(Backend4J.class.getName(), "Exception in module " + e.getModule());
            Logger.logFatal(Backend4J.class.getName(), e);
            System.exit(-4);
        } catch (Exception e) {
            Logger.logFatal(Backend4J.class.getName(), "Uncaught exception:");
            Logger.logFatal(Backend4J.class.getName(), e);
            System.exit(-3);
        }

        // if we get here, then something went wrong
        System.exit(-1);
    }

    public Modules getModules() {
        return modules;
    }

    @Override
    public WebServer getWebServer() {
        return httpServer;
    }

    @Override
    public ModuleManager getModuleManager() {
        return modules;
    }
}
