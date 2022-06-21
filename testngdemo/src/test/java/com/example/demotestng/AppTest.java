package com.example.demotestng;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/**
 * Unit test for simple App.
 */
class AppTest {
    /**
     * Quang Test.
     * @throws InterruptedException
     * 
     */

    public WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://ladyfashion.miiduu.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }

    @Test
    public void verifyOrderProductSuccessfully() throws InterruptedException{               
        WebElement tabDresses = driver.findElement(By.xpath("//*[@href = '/Dresses-1']"));
        tabDresses.click();

        Thread.sleep(2000);
        List<WebElement> lstProdDes = driver.findElements(By.cssSelector(".product-description a"));
        lstProdDes.get(0).click();

        Thread.sleep(2000);

        WebElement ddlSize = driver.findElement(By.xpath("//td[text() = 'Size:']/following-sibling::td//select"));
        Select selSize = new Select(ddlSize);
        selSize.selectByVisibleText("L");

        WebElement ddlColor = driver.findElement(By.xpath("//td[text() = 'Color:']/following-sibling::td//select"));
        Select selColor = new Select(ddlColor);
        selColor.selectByVisibleText("red");

        WebElement btnAddToCart = driver.findElement(By.id("add_to_cart"));
        btnAddToCart.click();

        WebElement btnProceedToCheckOut = driver.findElement(By.xpath("//span[text() = 'Proceed to Checkout']"));

        Assert.assertTrue(btnProceedToCheckOut.isDisplayed());
    }

    @Test
    public void verifyContactUsPage() throws InterruptedException {
        
        driver.navigate().to("https://ladyfashion.miiduu.com/About-Us");
        Thread.sleep(3000);
        WebElement tlAboutUs = driver.findElement(By.xpath("//h1[text() = 'About Us']"));
        WebElement lblAboutUs = driver.findElement(By.cssSelector("div.middle div.middle-cont"));
        WebElement btnContinue = driver.findElement(By.xpath("//span[text() = 'Continue']"));

        boolean isDisplayCorrectly = false;
        if(tlAboutUs.isDisplayed() && lblAboutUs.isDisplayed() && btnContinue.isDisplayed()){
            isDisplayCorrectly = true;
        }
        Assert.assertTrue(isDisplayCorrectly);
    }

    @AfterMethod
    public void tearDown(){

        driver.quit();
    }

}
