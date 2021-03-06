package gui.driver;

import gui.configuration.LocalWebDriverProperties;
import gui.configuration.TestRunProperties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

public class BrowserFactory {

    private static final String MESSAGE_UNKNOWN_BROWSER = "Unknown browser type! Please check your configuration";
    private static final String MESSAGE_PROBLEM_WITH_HEADLESS = "Problem with headless mode, check the configuration";
    private BrowserType browserType;
    private boolean isRemoteRun;
    private boolean isHeadLessModeRun;

    public BrowserFactory(BrowserType browserType, boolean isRemoteRun, boolean isHeadLessModeRun) {
        this.browserType = browserType;
        this.isRemoteRun = isRemoteRun;
        this.isHeadLessModeRun = isHeadLessModeRun;
    }


    public WebDriver getBrowser() {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        LoggingPreferences loggingPreferences = new LoggingPreferences();
        loggingPreferences.enable(LogType.BROWSER, Level.INFO);
        desiredCapabilities.setCapability(CapabilityType.LOGGING_PREFS, loggingPreferences);

        if (isRemoteRun) {
            switch (browserType) {
                case CHROME:
                    ChromeOptions chromeOptions = new ChromeOptions();
                    desiredCapabilities.merge(chromeOptions);
                    return getRemoteWebDriver(desiredCapabilities);
                case FIREFOX:
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    desiredCapabilities.merge(firefoxOptions);
                    return getRemoteWebDriver(desiredCapabilities);
                default:
                    throw new IllegalStateException(MESSAGE_UNKNOWN_BROWSER);
            }
        } else {
            if (isHeadLessModeRun) {
                switch (browserType) {
                    case CHROME:
                        System.setProperty("webdriver.chrome.driver", LocalWebDriverProperties.getChromeWebDriverLocation());

                        ChromeOptions chromeOptions = new ChromeOptions();
                        chromeOptions.setHeadless(true);
                        chromeOptions.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200", "--ignore-certificate-errors");
                        return new ChromeDriver(chromeOptions);
                    case FIREFOX:
                        System.setProperty("webdriver.gecko.driver", LocalWebDriverProperties.getFirefoxWebDriverLocation());
                        FirefoxOptions firefoxOptions = new FirefoxOptions();
                        firefoxOptions.setHeadless(true);
                        firefoxOptions.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200", "--ignore-certificate-errors");
                        return new FirefoxDriver(firefoxOptions);
                    default:
                        throw new IllegalStateException(MESSAGE_PROBLEM_WITH_HEADLESS);
                }
            } else {
                switch (browserType) {
                    case CHROME:
                        ChromeOptions chromeOptions = new ChromeOptions();
                        chromeOptions.merge(desiredCapabilities);
                        return new ChromeDriver(chromeOptions);
                    case FIREFOX:
                        System.setProperty("webdriver.gecko.driver", LocalWebDriverProperties.getFirefoxWebDriverLocation());
                        FirefoxOptions firefoxOptions = new FirefoxOptions();
                        firefoxOptions.merge(desiredCapabilities);
                        return new FirefoxDriver(firefoxOptions);

                    default:
                        throw new IllegalStateException(MESSAGE_UNKNOWN_BROWSER);
                }

            }
        }
    }

    private WebDriver getRemoteWebDriver(DesiredCapabilities desiredCapabilities) {
        RemoteWebDriver remoteWebDriver = null;

        try {
            remoteWebDriver = new RemoteWebDriver(new URL(TestRunProperties.getGridUrl()), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to create RemoteWebDriver due to: " + e.getMessage());
        }
        return remoteWebDriver;

    }


}
