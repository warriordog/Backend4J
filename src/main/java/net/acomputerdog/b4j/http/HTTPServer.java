package net.acomputerdog.b4j.http;

import net.acomputerdog.b4j.ex.ModuleException;
import net.acomputerdog.b4j.main.Backend4J;
import net.acomputerdog.b4j.module.ModContext;
import net.acomputerdog.b4j.module.api.main.ModuleContext;
import net.acomputerdog.b4j.module.api.web.WebServer;
import net.acomputerdog.b4j.module.api.web.filter.RequestFilter;
import net.acomputerdog.b4j.module.api.web.req.RequestHandler;

public class HTTPServer implements WebServer {
    private final Backend4J b4j;

    private ServerState serverState = ServerState.NOT_STARTED;
    private boolean acceptingConnections = false;

    private Domains domains;

    public HTTPServer(Backend4J b4j) {
        this.b4j = b4j;
        this.domains = new Domains();
    }

    public void start() {

    }

    public void stop() {

    }

    /**
     * Joins the server thread until server shuts down
     */
    public void join() {

    }

    public ServerState getServerState() {
        return serverState;
    }

    public boolean isAcceptingConnections() {
        return acceptingConnections;
    }

    public void setAcceptingConnections(boolean acceptingConnections) {
        this.acceptingConnections = acceptingConnections;
    }

    /**
     * Performs shutdown logic
     */
    private void shutdown() {

    }

    @Override
    public void registerHandler(ModuleContext module, RequestFilter filter, RequestHandler handler) {
        ModContext mod = (ModContext)module;

        Domain dom = domains.getDomainForModule(mod);
        if (dom != null) {
            dom.addListener(new RequestListener(filter, handler));
        } else {
            throw new ModuleException("Module did not register a domain: " + mod, mod);
        }
    }

    public enum ServerState {
        NOT_STARTED,
        STARTING,
        STARTED,
        STOPPING,
        STOPPED
    }
}
