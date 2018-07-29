package net.acomputerdog.b4j.module.api.web.filter;

import net.acomputerdog.b4j.module.api.web.req.Request;

@FunctionalInterface
public interface RequestFilter {
    boolean matches(Request request);
}
