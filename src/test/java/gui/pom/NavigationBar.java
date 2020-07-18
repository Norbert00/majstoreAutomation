package gui.pom;

import gui.driver.DriverManager;
import gui.logger.OwnLogger;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;

import static gui.navigation.ApplicationURLs.APPLICATION_URL;
import static org.testng.Assert.*;

public class NavigationBar extends BasePage {

    private final String expectedUrl = APPLICATION_URL;
    private final String SHOP = "Shop";

    @FindBy(xpath = "//*[@id='top-menu']/li/a")
    private List<WebElement> topNavigationMenu;

    public String getSHOP() {
        return SHOP;
    }

    public List<WebElement> getTopNavigationMenu() {
        return topNavigationMenu;
    }

    private void clickOnElementInNavTopMenu(List<WebElement> listOfElements, String nameOfChosenElement) {
        String chosenElement = nameOfChosenElement.toLowerCase();
        for (WebElement selectedElement : listOfElements) {
            if (chosenElement.equals(selectedElement.getText().toLowerCase())) {
                selectedElement.click();
                break;
            } else {
                System.out.println("Check the clickOnElementInNavTopMenu method in NavigationBar class.");
            }
        }
    }

    public void clickOnChosenLinkInTopNavMenu(String nameOfTheElementInMenu) {
        clickOnElementInNavTopMenu(getTopNavigationMenu(), nameOfTheElementInMenu);
    }

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
