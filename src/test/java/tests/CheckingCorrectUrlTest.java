package tests;

import gui.driver.DriverUtils;
import gui.pom.NavigationBar;
import gui.test.base.TestBase;

import gui.utils.testng.listeners.RetryAnalyzer;
import io.qameta.allure.Description;
import org.testng.annotations.Test;


public class CheckingCorrectUrlTest extends TestBase {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("The goal of this test is to check that when we enter the correct url address we will be redirectly to the " +
            "correct web page")
    public void checkingMajstoreUrtTest() {
        DriverUtils.setInitialConfiguration();
        NavigationBar navigationBar = new NavigationBar();
        navigationBar.assertThatTheUrlIsCorrect(navigationBar.getExpectedUrl());

    }






}
