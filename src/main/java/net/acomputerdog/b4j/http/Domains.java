package net.acomputerdog.b4j.http;

import net.acomputerdog.b4j.ex.ConfigException;
import net.acomputerdog.b4j.module.ModContext;

import java.util.HashMap;
import java.util.Map;

public class Domains {
    private final Map<String, Domain> domainNameMap;
    private final Map<ModContext, Domain> domainModMap;

    public Domains() {
        domainNameMap = new HashMap<>();
        domainModMap = new HashMap<>();
    }

    public void addDomain(Domain dom) {
        if (domainNameMap.containsKey(dom.getPrefix())) {
            throw new ConfigException("Duplicate domain: " + dom.getPrefix());
        }
        if (domainModMap.containsKey(dom.getModule())) {
            throw new ConfigException("Module has multiple domains: " + dom.getPrefix());
        }

        domainNameMap.put(dom.getPrefix(), dom);
        domainModMap.put(dom.getModule(), dom);
    }

    public void removeDomain(Domain dom) {
        domainNameMap.remove(dom.getPrefix());
        domainModMap.remove(dom.getModule());
    }

    public Domain getDomainForRequest(HTTPRequest req) {
        /*
        int split = reg.getPath().lastIndexOf('/');
        if (split < 0) {
            throw new HTTPServerException("Request path contains no domains: " + req.getPath());
        }
        if (split >= req.getPath().length() - 1) {

        }
        */
        return domainNameMap.get(req.getDomain());
    }

    public Domain getDomainForModule(ModContext mod) {
        return domainModMap.get(mod);
    }
}
