package gui.driver;

import gui.configuration.LocalWebDriverProperties;
import org.openqa.selenium.WebDriver;

import static gui.configuration.TestRunProperties.getBrowserToRun;
import static gui.configuration.TestRunProperties.getIsRemoteRun;
import static gui.driver.BrowserType.FIREFOX;


public class DriverManager {



    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();
    private static ThreadLocal<BrowserType> browserTypeThreadLocal = new ThreadLocal<>();


    private DriverManager() {

    }

    public static void setWebDriver(BrowserType browserType) {
        WebDriver browser = null;

        if (browserType == null) {
            browserType = getBrowserToRun();
            browser = new BrowserFactory(browserType, getIsRemoteRun()).getBrowser();
        } else {
            browser = new BrowserFactory(browserType, getIsRemoteRun()).getBrowser();
        }

        browserTypeThreadLocal.set(browserType);
        webDriverThreadLocal.set(browser);
    }

    public static WebDriver getWebDriver() {
        if(webDriverThreadLocal.get() == null) {
            throw new IllegalStateException("WebDriver Instance was null! Please create instance of WebDriver using setWebDriver!");
        }
        return webDriverThreadLocal.get();
    }



    public static void disposeDriver() {
        webDriverThreadLocal.get().close();
        if (!browserTypeThreadLocal.get().equals(FIREFOX)) {
            webDriverThreadLocal.get().quit();
        }
        webDriverThreadLocal.remove();
        browserTypeThreadLocal.remove();
    }


}
