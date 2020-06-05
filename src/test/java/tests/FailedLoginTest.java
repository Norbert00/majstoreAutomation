package tests;

import gui.driver.DriverUtils;
import gui.pom.LoginPage;
import gui.test.base.TestBase;
import org.testng.annotations.Test;

import static gui.navigation.ApplicationURLs.LOGIN_URL;
import static org.testng.Assert.assertTrue;

public class FailedLoginTest extends TestBase {

    @Test
    public void asUserTryToLoginWithIncorrectLoginAndPassword() {

        DriverUtils.navigateToPage(LOGIN_URL);

        LoginPage loginPage = new LoginPage();
        loginPage.userEnterIncorrectLoginAndPassword(LoginPage.getINCORRECTUSERNAME(),LoginPage.getINCORRECTPASSWORD());
        assertTrue(loginPage.errorMessageIsDisplay());


    }

}
