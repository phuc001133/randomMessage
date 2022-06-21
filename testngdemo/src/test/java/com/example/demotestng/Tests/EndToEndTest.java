package com.example.demotestng.Tests;

import com.example.demotestng.Pages.DressesCategoryPage;
import com.example.demotestng.Pages.HomePage;
import com.example.demotestng.Pages.ProductDetailsPage;
import com.example.demotestng.Pages.ShoppingCartPage;


import com.example.demotestng.TestData.LadyFashionData;
import com.example.demotestng.core.configuration.Configuration;
import com.example.demotestng.core.driver.DriverFactory;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class EndToEndTest extends BaseTest{


    @BeforeMethod
    public void setUp() throws InterruptedException, IOException {
        Configuration config = new Configuration("src/test/resources/app.properties");
        driver = DriverFactory.getDriver(config.getProperty("browser"));
        driver.get(config.getProperty("url"));
    }

    @Test(dataProvider = "ProductData", dataProviderClass = LadyFashionData.class)
    public void verifyOrderProductSuccessfullyWithFluencePageObject(String prdDesc, String size, String url) throws Exception {
        HomePage homePage = new HomePage(driver);
        ShoppingCartPage shoppingCartPage = homePage.navigateToDressCategory()
                                                        .selectProductByDescription(prdDesc)
                                                        .selectProductOption(size, color)
                                                        .addProductToCart();
        homePage.navigateToProductByUrl(productUrl);
        Assert.assertTrue(shoppingCartPage.isBtnProceedToCheckoutDisplay());
    }

    @Test(dataProvider = "ProductDataFromExcel", dataProviderClass = LadyFashionData.class)
    public void TestData(String a, String b, String c){
        System.out.println(String.format("%s %s %s %s", a, b, c));
    }

    @Test()
    public void TestFirefox() throws InterruptedException {
        Thread.sleep(50000);
    }

    @AfterMethod
    public void tearDown(){

        driver.quit();
    }
}
