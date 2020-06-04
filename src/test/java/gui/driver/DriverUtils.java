package gui.driver;


//to fix maximize the windows in DriverUtils


public class DriverUtils {


    public static void setInitialConfiguration() {
        DriverManager.getWebDriver().manage().window().maximize();
    }

    public static void navigateToPage(String url) {
        DriverManager.getWebDriver().navigate().to(url);
    }


}
