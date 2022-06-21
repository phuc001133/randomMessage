package com.example.demotestng.Pages;

import com.example.demotestng.Pages.Components.LeftCategoryMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

//    public WebElement TabDressCategory = this._driver.findElement(By.xpath("//*[@href = '/Dresses-1']"));
    // Page Elements
//    String tabDressCategoryLocator = "//*[@href = '/Dresses-1']";

    // Demo for Page Factory
    @FindBy(how = How.XPATH, using = "//*[@href = '/Dresses-1']")
    public WebElement tabDressCategory;

    public LeftCategoryMenu getMenuLeftCategory() {
        return new LeftCategoryMenu(_driver);
    }

    public LeftCategoryMenu menuLeftCategory;
//    public WebElement getTabDresses(){
//        return this._driver.findElement(By.xpath(tabDressCategoryLocator));
//    }
    // Page Elements

    // Page Actions
    public DressesCategoryPage navigateToDressCategory() throws InterruptedException{
        actionKeyword.click(this.tabDressCategory);
        Thread.sleep(3000);
        return new DressesCategoryPage(this._driver);
    }

    public HomePage KhongLamGiHet(){
        System.out.println("Test Fluence Page Object");
        return this;
    }
    // Page Actions


    public void navigateToDressCategoryByLeftMenu(String category){
        this.getMenuLeftCategory().getCategoryByName(category).click();
    }

}
