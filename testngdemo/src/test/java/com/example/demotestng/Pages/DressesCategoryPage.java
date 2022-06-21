package com.example.demotestng.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DressesCategoryPage extends BasePage {

    public DressesCategoryPage(WebDriver driver) {
        super(driver);

    }

    String lstProductsLocator = ".product-description a";

    public List<WebElement> getLstProdDes(){
        return this._driver.findElements(By.cssSelector(lstProductsLocator));
    }

    public WebElement getProductByIndexFromLstProdDes(int index){
        return this.getLstProdDes().get(index);
    }

    public ProductDetailsPage selectFirstProduct(){
        this.getProductByIndexFromLstProdDes(0).click();
        return new ProductDetailsPage(_driver);
    }

    public ProductDetailsPage selectProductByDescription(String productDescription){
        actionKeyword.findElement(By.xpath(String.format("//a[text() = '%s']", productDescription))).click();
        return new ProductDetailsPage(_driver);
    }

}
