package tests;

import gui.pom.NavigationBar;
import gui.test.base.TestBase;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CheckingCorrectUrlTest extends TestBase {

    @Test
    public void checkingMajstoreUrtTest() {

        NavigationBar navigationBar = new NavigationBar();
        assertTrue(navigationBar.assertionPageUrl());

    }






}
