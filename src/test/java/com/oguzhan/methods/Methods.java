package com.oguzhan.methods;

import com.oguzhan.driver.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Methods {

    WebDriver driver;
    FluentWait<WebDriver> wait;
    JavascriptExecutor jsDriver;
    Logger logger = LogManager.getLogger(Methods.class);

    public Methods() {
        driver = BaseTest.getDriver();
        wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class);
        jsDriver = (JavascriptExecutor) driver;
    }

    public void goKitapYurduHomePage() {
        driver.get("https://www.kitapyurdu.com/");

        if (driver.getCurrentUrl().contains("https://www.kitapyurdu.com/")) {
            System.out.println("Kitap Yurdu sayfasina gidildi");
        } else {
            throw new WebDriverException("ilgili sayfaya acilamadi");
        }

    }

    public WebElement findElement(By element) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public void click(By element) {
        findElement(element).click();
    }

    public void waitBySecond(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendKeys(By element, String text) {
        findElement(element).sendKeys(text);
        logger.info("SendKeys işlemi gerçekleşti");
    }

    public void clearQuantity(By element, String value) {
        WebElement webElement = driver.findElement(element);
        webElement.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE, value);
    }

    public boolean isElementVisible(By element) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            logger.info("True");
            return true;
        } catch (Exception e) {
            logger.info("False" + e.getMessage());
            return false;
        }
    }

    public void scrollWithAction(By element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(element)).build().perform();
    }

    public Select getSelect(By element) {
        return new Select(findElement(element));
    }

    public void selectByText(By element, String text) {
        getSelect(element).selectByVisibleText(text);
    }

    public String getAttribute(By element, String attributeName) {
        return findElement(element).getAttribute(attributeName);
    }

    public String getText(By element) {
        return findElement(element).getText();
    }

    public String getValue(By element) {
        return jsDriver.executeScript("return arguments[0].value;", findElement(element)).toString();
    }

    public By scrollSearch(int index) {
        List<WebElement> productElements = driver.findElements(By.xpath("//div[@class='product-list']/div"));

        return (By.xpath("//div[@class='product-list']/div[" + index + "]"));

    }

    public void chooseRandomProduct() {

        int randomProductIndex = new Random().nextInt(16);

        WebElement productElement = driver.findElement(By.xpath("//ul[@class='product-grid jcarousel-skin-opencart']/li[" + randomProductIndex + "]"));
        scrollWithAction(By.xpath("//ul[@class='product-grid jcarousel-skin-opencart']/li[" + randomProductIndex + "]"));
        productElement.findElement(By.xpath("//ul[@class='product-grid jcarousel-skin-opencart']/li[" + randomProductIndex + "]")).click();

    }

    public void chooseAndFavProduct(int index) {

        List<WebElement> productElement = driver.findElements(By.xpath("//div[@class='product-list']/div"));

        click(By.xpath("//div[@class='product-list']/div[" + index + "]/div[@class='grid_2 alpha omega relative']/div[@class='hover-menu']/a[@class='add-to-favorites']"));

    }

    public void deleteThirdProductInFavList() {
        List<WebElement> favElement = driver.findElements(By.xpath("//div[@class='favorites']/div/div"));

        click(By.xpath("//div[@class='favorites']/div/div[3]/div[@class='grid_2 alpha omega relative']/div[@class='hover-menu']/a[@data-title='Favorilerimden Sil']"));

    }

}

