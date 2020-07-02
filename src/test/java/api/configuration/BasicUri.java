package api.configuration;

import gui.configuration.ConfigurationProperties;

public class BasicUri {

    public static String getBasicUri() {
        return ConfigurationProperties.getProperties().getProperty("basic.uri");
    }





}
