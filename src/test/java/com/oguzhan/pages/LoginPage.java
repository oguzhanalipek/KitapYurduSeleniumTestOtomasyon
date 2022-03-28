package com.oguzhan.pages;

import com.oguzhan.methods.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginPage {

    Methods methods;
    Logger logger = LogManager.getLogger(LoginPage.class);

    public LoginPage() {
        methods = new Methods();
    }

    public void closePopUp() {
        methods.click(By.cssSelector(".popupContainer.show>div[class='popupCloseIcon']"));
    }

    public void login() {

        //Kitapyurdu anasayfasında Login Butonuna Tıkla
        methods.click(By.cssSelector(".menu-top-button.login>a"));

        //Giriş ekranında Email alanına değer gönder
        methods.sendKeys(By.id("login-email"), "oguzhan.alipek@testinium.com");
        closePopUp(); // PopUp kapat
        //Giriş ekranında Password alanına değer gönder
        methods.sendKeys(By.id("login-password"), "1q2w3e4r5t");
        //Giriş butonuna tıkla
        methods.click(By.cssSelector(".ky-form-buttons>button"));
        //Login işlemini giriş yaptıktan sonra gelen bir elementin gözüküp gözükmediği ile kontrol et
        Assert.assertTrue(methods.isElementVisible(By.cssSelector(".highlight-link[href='https://www.kitapyurdu.com/index.php?route=account/edit']")));
        logger.info("Login işlemi başarılı");

    }

    public void logout() {
        methods.click(By.cssSelector("div[class='menu top login']>ul>li>a[class='common-sprite']"));

        try{
            methods.scrollWithAction(By.xpath("//div[@class='menu top login']/ul/li/a[@class='common-sprite']"));
            methods.click(By.xpath("//div[@class='menu top login']/ul/li/div/ul/li[4]"));
            logger.info("Kullanıcı oturumu kapatıldı");
        }catch (Exception e){
            logger.info("Kullanıcı oturumu kapatılamadı!");
        }
    }
}
