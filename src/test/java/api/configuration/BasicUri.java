package api.configuration;

import gui.configuration.ConfigurationProperties;

public class BasicUri {

    public static String getBasicURI() {
        return ConfigurationProperties.getProperties().getProperty("basic.uri");
    }





}
