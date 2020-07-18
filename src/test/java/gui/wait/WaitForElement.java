package gui.wait;

import gui.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForElement {

    private static WebDriverWait getWebDriverWait() {
        return new WebDriverWait(DriverManager.getWebDriver(), 10);
    }

    public static void waitUntilElementIsVisible(WebElement element) {
        WebDriverWait webDriverWait = getWebDriverWait();
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitUntilElementToByClickable(WebElement element) {
        WebDriverWait webDriverWait = getWebDriverWait();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitWithStalenessOfException(WebElement element) {
        WebDriverWait webDriverWait = getWebDriverWait();
        webDriverWait.until(ExpectedConditions.stalenessOf(element));
    }

}
