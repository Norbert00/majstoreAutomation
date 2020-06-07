package gui.driver;


//to fix maximize the windows in DriverUtils


import io.qameta.allure.Step;

public class DriverUtils {

    @Step("Maximizing browser window")
    public static void setInitialConfiguration() {
        DriverManager.getWebDriver().manage().window().maximize();
    }

    @Step("Navigating to URL: {url}")
    public static void navigateToPage(String url) {
        DriverManager.getWebDriver().navigate().to(url);
    }


}
