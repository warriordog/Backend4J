package net.acomputerdog.b4j.http;

import net.acomputerdog.b4j.main.Backend4J;

public class HTTPServer {
    private final Backend4J b4j;

    private ServerState serverState = ServerState.NOT_STARTED;
    private boolean acceptingConnections = false;

    public HTTPServer(Backend4J b4j) {
        this.b4j = b4j;
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

    public enum ServerState {
        NOT_STARTED,
        STARTING,
        STARTED,
        STOPPING,
        STOPPED
    }
}
