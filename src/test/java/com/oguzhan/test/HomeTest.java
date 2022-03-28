package com.oguzhan.test;

import com.oguzhan.driver.BaseTest;
import com.oguzhan.pages.HomePage;
import org.junit.Test;

public class HomeTest extends BaseTest {

    @Test
    public void homeTest() {
        HomePage homePage = new HomePage();
        homePage.home();
    }
}
