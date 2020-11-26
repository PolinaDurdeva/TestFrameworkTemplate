package org.example.configuration;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;
import org.aeonbits.owner.Config.Sources;


@LoadPolicy(LoadType.MERGE)
@Sources({"system:properties",
        "classpath:testConfig.properties"})
public interface TestConfiguration extends Config {

    @DefaultValue("true")
    Boolean useLocalDriver();

    @DefaultValue("false")
    Boolean enableVNC();

    @DefaultValue("false")
    Boolean enableVideo();

    @DefaultValue("chrome")
    String browser();

    String baseUrl();

    String apiUrl();

    String remoteHost();

    @DefaultValue("30000")
    int pageLoadTimeout();

    @DefaultValue("5000")
    int timeout();

    @DefaultValue("target/reports")
    String reportFolder();
}

