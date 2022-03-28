package com.oguzhan.test;

import com.oguzhan.driver.BaseTest;
import com.oguzhan.pages.HomePage;
import com.oguzhan.pages.LoginPage;
import com.oguzhan.pages.ProductPage;
import org.junit.Test;

public class ProductTest extends BaseTest {

    @Test
    public void productTest(){
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
    }

    @Test
    public void searchProductTest(){
        HomePage homePage = new HomePage();
        ProductPage productPage = new ProductPage();

        homePage.home();
        productPage.searchProduct();
    }

    @Test
    public void favProductTest(){
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        ProductPage productPage = new ProductPage();

        homePage.home();
        loginPage.login();
        productPage.searchProduct();
        productPage.productFav();
    }

    @Test
    public void puanKatalogTest(){
        HomePage homePage = new HomePage();
        ProductPage productPage = new ProductPage();

        homePage.home();
        productPage.puanKatalogu();
    }

    @Test
    public void selectRandomProductTest(){
        HomePage homePage = new HomePage();
        ProductPage productPage = new ProductPage();

        homePage.home();
        productPage.selectRandomProduct();
    }

    @Test
    public void deleteThirdProductInFavoritesTest(){
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        ProductPage productPage = new ProductPage();

        homePage.home();
        loginPage.login();
        productPage.deleteThirdProductInFavorites();
    }

    @Test
    public void goShoppingCart(){
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        ProductPage productPage = new ProductPage();

        homePage.home();
        loginPage.login();
        productPage.shoppingCart();
        productPage.buyProduct();

        homePage.home();

    }
}
