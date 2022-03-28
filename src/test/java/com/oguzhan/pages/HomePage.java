package com.oguzhan.pages;

import com.oguzhan.methods.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

public class HomePage {

    Methods methods;
    Logger logger = LogManager.getLogger(ProductPage.class);


    public HomePage(){
        methods = new Methods();
    }

    public void home(){

        methods.goKitapYurduHomePage();

        try{
            Assert.assertTrue(methods.isElementVisible(By.className("logo-text")));
            logger.info("Kitap Yurdu AnaSayfası açıldı");
        }catch (Exception e){
            logger.info("Sayfa açılamadı");
        }

        //Loglamayı düzelt + Try-catch ekle
        //Assert.assertTrue(methods.isElementVisible(By.className("logo-text")));

    }
}
