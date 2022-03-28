package com.oguzhan.test;

import com.oguzhan.driver.BaseTest;
import com.oguzhan.pages.HomePage;
import com.oguzhan.pages.LoginPage;
import org.junit.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();

        homePage.home();
        loginPage.login();
    }

    @Test
    public void logoutTest() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();

        homePage.home();
        loginPage.login();
        loginPage.logout();
    }
}
