package com.twc.lando.cdvr.resource;

import org.glassfish.jersey.server.ResourceConfig;
import javax.ws.rs.ApplicationPath;

/**
 *
 */
@ApplicationPath("resources")
public class AppConfig extends ResourceConfig {
    public AppConfig() {
        packages("com.twc.lando.cdvr.resource");
    }
}
