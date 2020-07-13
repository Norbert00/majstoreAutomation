package tests.gui;

import gui.driver.DriverUtils;
import gui.pom.LoginPage;
import gui.pom.MyAccountPage;
import gui.test.base.TestBase;
import gui.utils.testng.listeners.RetryAnalyzer;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static gui.navigation.ApplicationURLs.LOGIN_URL;

public class PositiveLoginTest extends TestBase {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("The goal of this test is to log in using the correct login and password" +
            " and check that the user will be redirected to the MyAccount page.")
    public void asUserTryToLoginWithCorrectLoginAndPassword() {
        DriverUtils.setInitialConfiguration();
        DriverUtils.navigateToPage(LOGIN_URL);

        LoginPage loginPage = new LoginPage();
        loginPage.userEnterIncorrectLoginAndPassword(LoginPage.getCorrectusername(), LoginPage.getCorrectpassword());
        MyAccountPage myAccountPage = new MyAccountPage();
        myAccountPage.assertThatTheUrlIsCorrect(MyAccountPage.getCorrectUrl());
        myAccountPage.assertThatMyAccountAndLogoutAreDisplay();

    }
}
