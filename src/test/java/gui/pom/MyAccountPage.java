package gui.pom;

import gui.driver.DriverManager;
import gui.generic.assertions.AssertWebElement;
import gui.logger.OwnLogger;
import gui.wait.WaitForElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import static gui.navigation.ApplicationURLs.MYACCOUNT_PAGE;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class MyAccountPage extends BasePage {


    private static final String correctUrl = MYACCOUNT_PAGE;

    public static String getCorrectUrl() {
        return correctUrl;
    }

    @FindBy(xpath = "//h1[@class='entry-title main_title']")
    private WebElement myAccountText;

    @FindBy(xpath = "//ul[@id='top-menu']//a[contains(text(),'Log Out')]")
    private WebElement logOutButton;


    @Step("Checking the correct Url")
    private String getActualPageUrl() {
        String pageUrl;
        pageUrl = DriverManager.getWebDriver().getCurrentUrl();
        return pageUrl;
    }



    @Step("Comparing entered url with the correct {url}")
    public void assertThatTheUrlIsCorrect(String url) {
        String actualPageUrl = getActualPageUrl();
        OwnLogger logger = new OwnLogger();
        if (actualPageUrl != null) {
            assertEquals(actualPageUrl, url);
            logger.setLoggerInfo("Checked url is " + actualPageUrl);
        } else {
            logger.setLoggerInfo("Checked url is " + actualPageUrl);
            fail();
        }
    }

    @Step("Assert that the My Account text and Logout button are display")
    public void assertThatMyAccountAndLogoutAreDisplay(){
        WaitForElement.waitUntilElementIsVisible(myAccountText);
        WaitForElement.waitUntilElementIsVisible(logOutButton);
        AssertWebElement.assertThat(myAccountText).isDisplayed();
        AssertWebElement.assertThat(logOutButton).isDisplayed();
    }

}
