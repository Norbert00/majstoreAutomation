package gui.configuration;

import gui.driver.BrowserType;

public class TestRunProperties {

    public static String getGridUrl() {
        return ConfigurationProperties.getProperties().getProperty("grid.url");
    }

    public static BrowserType getBrowserToRun() {
        return BrowserType.valueOf(ConfigurationProperties.getProperties().getProperty("browser"));
    }

    public static boolean getIsRemoteRun() {
        return Boolean.parseBoolean(ConfigurationProperties.getProperties().getProperty("is.remote.run"));
    }

    public static boolean getIsHeadLessModeRun() {
        return Boolean.parseBoolean(ConfigurationProperties.getProperties().getProperty("headless.mode"));
    }

}
