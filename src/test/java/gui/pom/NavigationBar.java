package gui.pom;

import gui.driver.DriverManager;
import gui.logger.OwnLogger;
import io.qameta.allure.Step;

import static gui.navigation.ApplicationURLs.APPLICATION_URL;
import static org.testng.Assert.*;

public class NavigationBar {

    private final String expectedUrl = APPLICATION_URL;

    public String getExpectedUrl() {
        return expectedUrl;
    }

    @Step("Checking the web page url")
    private String getActualPageUrl() {
        String pageUrl;
        pageUrl = DriverManager.getWebDriver().getCurrentUrl();
        return pageUrl;
    }

    private String urlC = getActualPageUrl();

    @Step("Comparing entered url with the correct {url}")
    public void assertThatTheUrlIsCorrect(String url) {
        OwnLogger logger = new OwnLogger();
        if (urlC != null) {
            assertEquals(url, urlC);
            logger.setLoggerInfo("Checked url is " + urlC);
        } else {
            logger.setLoggerInfo("Actual url is " + urlC);
            fail();
        }
    }





}
