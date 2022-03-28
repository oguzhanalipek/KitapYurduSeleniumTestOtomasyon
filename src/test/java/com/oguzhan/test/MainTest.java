package com.oguzhan.test;

import com.oguzhan.driver.BaseTest;
import com.oguzhan.pages.HomePage;
import com.oguzhan.pages.LoginPage;
import com.oguzhan.pages.ProductPage;
import org.junit.Test;

public class MainTest extends BaseTest {

    @Test
    public void mainTest() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        ProductPage productPage = new ProductPage();

        homePage.home();
        loginPage.login();
        productPage.searchProduct();
        productPage.productFav();
        productPage.puanKatalogu();
        productPage.selectRandomProduct();
        productPage.deleteThirdProductInFavorites();
        productPage.shoppingCart();
        productPage.buyProduct();
        homePage.home();
        loginPage.logout();

    }
}
