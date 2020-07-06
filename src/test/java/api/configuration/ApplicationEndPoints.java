package api.configuration;

import gui.configuration.ConfigurationProperties;

public class ApplicationEndPoints {

    public static final String BASE_URI = ConfigurationProperties.getProperties().getProperty("base.uri");
    public static final String BASE_PATH = ConfigurationProperties.getProperties().getProperty("base.path");
    public static final String PRODUCT_ENDPOINT = "/products/";


}
