package tests;

import gui.driver.DriverUtils;
import gui.pom.LoginPage;
import org.testng.annotations.Test;

import static gui.navigation.ApplicationURLs.LOGIN_URL;
import static org.testng.Assert.assertTrue;

public class FailedLoginTest {

    @Test
    public void asUserTryToLoginWithIncorrectLoginAndPassword() {

        DriverUtils.setInitialConfiguration();
        DriverUtils.navigateToPage(LOGIN_URL);

        LoginPage loginPage = new LoginPage();
        loginPage.userEnterIncorrectLoginAndPassword(LoginPage.getINCORRECTUSERNAME(),LoginPage.getINCORRECTPASSWORD());
        assertTrue(loginPage.errorMessageIsDisplay());


    }

}
