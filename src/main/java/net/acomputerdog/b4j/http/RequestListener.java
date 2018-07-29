package net.acomputerdog.b4j.http;

import net.acomputerdog.b4j.module.api.web.filter.RequestFilter;
import net.acomputerdog.b4j.module.api.web.req.RequestHandler;

import java.util.Objects;

public class RequestListener {
    private final RequestFilter filter;
    private final RequestHandler handler;

    public RequestListener(RequestFilter filter, RequestHandler handler) {
        this.filter = filter;
        this.handler = handler;
    }

    public RequestFilter getFilter() {
        return filter;
    }

    public RequestHandler getHandler() {
        return handler;
    }

    public boolean tryHandleRequest(HTTPRequest req, HTTPResponse response) {
        if (filter.matches(req)) {
            handler.handleRequest(req, response);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestListener that = (RequestListener) o;
        return Objects.equals(filter, that.filter) &&
                Objects.equals(handler, that.handler);
    }

    @Override
    public int hashCode() {

        return Objects.hash(filter, handler);
    }
}
