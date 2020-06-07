package gui.pom;

import gui.driver.DriverManager;
import io.qameta.allure.Step;

import static gui.navigation.ApplicationURLs.APPLICATION_URL;

public class NavigationBar {





    @Step("Checking the web page url")
    private String getActualPageUrl() {
        String pageUrl;
        pageUrl = DriverManager.getWebDriver().getCurrentUrl();
        return pageUrl;
    }

    private String urlC = getActualPageUrl();

    @Step("Comparing entered url with the correct {APPLICATION_URL}")
    public boolean assertionPageUrl() {
        String applicationUrl = APPLICATION_URL;
        boolean isCorrectUrl = (applicationUrl.equals(urlC)) ? true : false;
        return isCorrectUrl;
    }





}
