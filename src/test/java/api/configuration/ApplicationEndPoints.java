package api.configuration;

import gui.configuration.ConfigurationProperties;

public class ApplicationEndPoints {

    public static final String BASE_URI_ONLINE = ConfigurationProperties.getProperties().getProperty("base.uri.online");
    public static final String BASE_PATH_ONLINE = ConfigurationProperties.getProperties().getProperty("base.path.online");
    public static final String BASE_URI_LOCALHOST = ConfigurationProperties.getProperties().getProperty("base.uri.localhost");
    public static final String BASE_PATH_LOCALHOST = ConfigurationProperties.getProperties().getProperty("base.path.localhost");
    public static final String PRODUCT_ENDPOINT = "/products/";


}
