package com.example.demotestng.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage extends BasePage {

    public ShoppingCartPage(WebDriver driver) {
        super(driver);

    }

    private String btnProceedToCheckout = "//span[text() = 'Proceed to Checkout']";

    public WebElement getBtnProceedToCheckout(){
        return actionKeyword.findElement(By.xpath(btnProceedToCheckout));
    }

    // Page Actions
    // Page Actions

    // Page Validation
    public boolean isBtnProceedToCheckoutDisplay(){
        return this.getBtnProceedToCheckout().isDisplayed();
    }
    // Page Validation
}
