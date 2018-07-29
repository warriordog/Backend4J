package net.acomputerdog.b4j.module.api.web;

import net.acomputerdog.b4j.module.api.main.ModuleContext;
import net.acomputerdog.b4j.module.api.web.filter.RequestFilter;
import net.acomputerdog.b4j.module.api.web.req.RequestHandler;

public interface WebServer {
    void registerHandler(ModuleContext module, RequestFilter filter, RequestHandler handler);
}
