package net.acomputerdog.b4j.module.api.web.req;

@FunctionalInterface
public interface RequestHandler {
    /**
     * Handles a raw request
     * @param request The request data
     * @param response The response data, should be set by handler
     */
    void handleRequest(Request request, Response response);
}
