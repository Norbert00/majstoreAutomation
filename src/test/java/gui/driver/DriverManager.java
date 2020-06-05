package gui.driver;

import gui.configuration.LocalWebDriverProperties;
import org.openqa.selenium.WebDriver;

import static gui.configuration.TestRunProperties.getBrowserToRun;
import static gui.configuration.TestRunProperties.getIsRemoteRun;
import static gui.driver.BrowserType.FIREFOX;


public class DriverManager {


    private static WebDriver driver;

    private DriverManager() {

    }

    public static WebDriver getWebDriver() {
        if(driver == null) {
            driver = new BrowserFactory(getBrowserToRun(), getIsRemoteRun()).getBrowser();
        }
        return driver;
    }



    public static void disposeDriver() {
        driver.close();
        if (!getBrowserToRun().equals(FIREFOX)) {
            driver.quit();
        }
        driver = null;
    }


}
