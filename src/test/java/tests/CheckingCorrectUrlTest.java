package tests;

import gui.pom.NavigationBar;
import gui.test.base.TestBase;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CheckingCorrectUrlTest extends TestBase {

    @Test
    @Description("The goal of this test is to check that when we enter the correct url address we will be redirectly to the " +
            "correct web page")
    public void checkingMajstoreUrtTest() {

        NavigationBar navigationBar = new NavigationBar();
        assertTrue(navigationBar.assertionPageUrl());

    }






}
