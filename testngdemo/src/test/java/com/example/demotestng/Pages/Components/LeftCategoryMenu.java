package com.example.demotestng.Pages.Components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// Demo components
public class LeftCategoryMenu {
    public WebDriver _driver;
    public LeftCategoryMenu(WebDriver driver){
        this._driver = driver;
    }

    public WebElement mnuCategory;
    public WebElement lnkAccessories;

    public WebElement getLnkAccessories() {
        return this.getMnuCategory().findElement(By.xpath("//a[text() = 'Accessories' ]"));
    }

    public WebElement getMnuCategory() {
        return _driver.findElement(By.id("category"));
    }

    public WebElement getCategoryByName(String name){
        return this.getMnuCategory().findElement(By.xpath(String.format("//a[text() = '%s' ]", name)));
    }






}
