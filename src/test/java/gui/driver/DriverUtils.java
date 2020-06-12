package gui.driver;


//to fix maximize the windows in DriverUtils


import io.qameta.allure.Step;

import static gui.configuration.TestRunProperties.getIsHeadLessModeRun;

public class DriverUtils {


    @Step("Maximizing browser window")
    public static void setInitialConfiguration() {

        if (getIsHeadLessModeRun()) {
            DriverManager.getWebDriver();
        } else {
            DriverManager.getWebDriver().manage().window().maximize();
        }


    }

    @Step("Navigating to URL: {url}")
    public static void navigateToPage(String url) {
        DriverManager.getWebDriver().navigate().to(url);
    }


}
