package gui.driver;

import org.openqa.selenium.WebDriver;


public class DriverManager {

    private static final BrowserType BROWSER_TYPE = BrowserType.FIREFOX;
    private static WebDriver driver;

    private DriverManager() {

    }

    public static WebDriver getWebDriver() {
        if(driver == null) {
            driver = BrowserFactory.getBrowser(BROWSER_TYPE);
        }
        return driver;
    }


    //to fix closing the browser after the test

    public static void disposeDriver() {
        if (BROWSER_TYPE.equals(BrowserType.FIREFOX)) {
            driver.quit();
        }
        driver.close();
        driver = null;
    }


}
