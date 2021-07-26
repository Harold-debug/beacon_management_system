package org.sid.web;

import io.javabrains.beaconmanagementgdc.BeaconManagementGdcApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class WebInitializer  extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(BeaconManagementGdcApplication.class);
    }
}

