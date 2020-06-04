package gui.pom;

import gui.driver.DriverManager;

import gui.navigation.ApplicationURLs;
import org.openqa.selenium.support.PageFactory;

import static gui.navigation.ApplicationURLs.APPLICATION_URL;

public class NavigationBar {



    public NavigationBar() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }


    private String getActualPageUrl() {
        String pageUrl;
        pageUrl = DriverManager.getWebDriver().getCurrentUrl();
        return pageUrl;
    }

    private String urlC = getActualPageUrl();

    public boolean assertionPageUrl() {
        String applicationUrl = APPLICATION_URL;
        boolean isCorrectUrl = (applicationUrl.equals(urlC)) ? true : false;
        return isCorrectUrl;
    }





}
