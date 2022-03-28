package com.oguzhan.pages;

import com.oguzhan.methods.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class ProductPage {

    Methods methods;
    Logger logger = LogManager.getLogger(ProductPage.class);
    String uniqueAttribute = "product-532576";

    public ProductPage() {
        methods = new Methods();

    }

    public void searchProduct() {
        //Arama kısmında Oyuncak ürünü aratılır.
        methods.sendKeys(By.id("search-input"), "Oyuncak");
        //Arama butonuna tıklanır.
        methods.click(By.cssSelector(".common-sprite.button-search"));
    }

    public void productFav() {

        //Arama sonuçlarında 7.ürüne scroll yapılır
        methods.scrollWithAction(methods.scrollSearch(7));
        //4 ürün favorilere eklenir
        methods.chooseAndFavProduct(4);
        methods.chooseAndFavProduct(5);
        methods.chooseAndFavProduct(6);
        methods.chooseAndFavProduct(7);
        methods.waitBySecond(1);

    }


    public void puanKatalogu() {
        methods.click(By.cssSelector(".lvl1catalog>a.common-sprite"));
        methods.scrollWithAction(By.cssSelector("div[class='heading-links']"));
        methods.click(By.cssSelector("div.landing-block>a>img[title='Puan Kataloğundaki Türk Klasikleri']"));
        methods.selectByText(By.cssSelector("div[class='sort']>select"), "Yüksek Oylama");
        methods.waitBySecond(1);
    }


    public void selectRandomProduct() {
        methods.click(By.xpath("//ul[@class='js-ajaxCt js-bookCt']/li[3]"));
        if (methods.isElementVisible(By.cssSelector("div[class='open-menu-ct bookAllCategories']>div>ul>li>a[href='kategori/kitap-hobi/1_212.html']"))) {
            methods.click(By.cssSelector("div[class='open-menu-ct bookAllCategories']>div>ul>li>a[href='kategori/kitap-hobi/1_212.html']"));
            methods.waitBySecond(1);  //wait
        } else {
            System.out.println("Element not Visible");
        }

        methods.chooseRandomProduct();

        methods.scrollWithAction(By.cssSelector("div[class='pr_details__box pr_details__price']>div>a"));

        methods.click(By.cssSelector("div[class='pr_details__box pr_details__price']>div>a"));
        methods.waitBySecond(2);

    }

    public void deleteThirdProductInFavorites() {

        methods.click(By.xpath("//div[@class='menu top my-list']//a[@class='common-sprite']"));

        if (methods.isElementVisible(By.xpath("//div[@class='menu top my-list']//div//ul"))) {
            methods.click(By.xpath("//div[@class='menu top my-list']//div//ul//li[1]"));
        } else {
            logger.info("Element is not visible!");
        }

        try{
            methods.selectByText(By.cssSelector("div[class='sort']>select"), "Eklenme Tarihi (Eski - Yeni)");

            methods.waitBySecond(1);
            methods.scrollWithAction(By.xpath("//ul[@class='sectioned']/li[9]"));
            methods.deleteThirdProductInFavList();
        }catch (Exception e){
            logger.info("Favori silme işlemi başarısız!");
        }

        methods.waitBySecond(2);
    }

    public void shoppingCart() {
        methods.waitBySecond(1);
        methods.click(By.xpath("//div[@id='cart']"));
        if (methods.isElementVisible(By.xpath("//div[@id='cart-content']//a[@class='button']"))) {
            methods.click(By.cssSelector("div[id='cart-content']>div>div>a[class='button']"));
            String value = methods.getValue(By.cssSelector("input[name='quantity']"));
            int quantity = Integer.parseInt(value);
            quantity++;
            value = Integer.toString(quantity);
            methods.clearQuantity(By.cssSelector("input[name='quantity']"), value);
            methods.click(By.cssSelector("i[class='fa fa-refresh green-icon']"));
            methods.waitBySecond(2);
        } else {
            System.out.println("Sepette ürün yok!");
        }
    }

    public void buyProduct() {
        methods.scrollWithAction(By.xpath("//*[@id='cart_module']/div[4]/div[1]/a"));
        methods.click(By.xpath("//*[@id='cart_module']/div[4]/div[1]/a"));
        methods.click(By.xpath("//*[@id='shipping-tabs']/a[2]"));

        methods.scrollWithAction(By.cssSelector("textarea[name='address']"));
        methods.sendKeys(By.cssSelector("input[name='firstname_companyname']"), "Ali");
        methods.sendKeys(By.cssSelector("input[name='lastname_title']"), "Yılmaz");
        methods.sendKeys(By.cssSelector("select[name='zone_id']"), "İstanbul");
        methods.click(By.cssSelector("select[name='county_id']>option[value='462']"));
        methods.sendKeys(By.cssSelector("input[name='district']"), "SOĞANLIK YENİ MAH");
        methods.sendKeys(By.cssSelector("textarea[name='address']"), "Yeni Adres Yeni Adres Yeni Adres");
        methods.sendKeys(By.cssSelector("input[name='postcode']"), "34483");
        methods.sendKeys(By.cssSelector("input[name='telephone']"), "2161111111");
        methods.sendKeys(By.cssSelector("input[name='mobile_telephone']"), "5301111111");
        methods.scrollWithAction(By.cssSelector("button[id='button-checkout-continue']"));
        methods.click(By.cssSelector("button[id='button-checkout-continue']"));

        if (methods.isElementVisible(By.cssSelector("div[id='tab-shipping-companies-non']"))) {
            methods.click(By.cssSelector("button[class='button']"));
        } else {
            System.out.println("Kargo metodu bölümü yüklenemedi");
        }
        if (methods.isElementVisible(By.cssSelector("div[class='checkMasterpass']"))) {
            methods.click(By.cssSelector("button[class='button']"));
        } else {
            System.out.println("Ödeme metodu bölümü yüklenemedi");
        }
        methods.waitBySecond(2);
    }

}
