package com.example.demotestng.Pages;

import com.example.demotestng.core.keyword.ActionKeyword;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ProductDetailsPage extends BasePage{

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
        //TODO Auto-generated constructor stub
    }

    private String ddlSize = "//td[text() = 'Size:']/following-sibling::td//select";
    private String ddlColor = "//td[text() = 'Color:']/following-sibling::td//select";
    private String btnAddToCart = "add_to_cart";

    public WebElement getDdlSize(){
        return actionKeyword.findElement(By.xpath(ddlSize));
    }

    public WebElement getDdlColor(){
        return actionKeyword.findElement(By.xpath(ddlColor));
    }

    public WebElement getBtnAddToCart(){
        return actionKeyword.findElement(By.id(btnAddToCart));
    }

    public ProductDetailsPage selectProductOption(String size, String color) throws Exception {

        if(!size.isEmpty() && size != null){
//            Select selSize = new Select(this.getDdlSize());
//            selSize.selectByVisibleText(size);
            actionKeyword.select(this.getDdlSize(), ActionKeyword.SelectType.SELECT_BY_TEXT, size);
        }

        if(!color.isEmpty() && color != null){
//            Select selColor = new Select(this.getDdlColor());
//            selColor.selectByVisibleText(color);
            actionKeyword.select(this.getDdlColor(), ActionKeyword.SelectType.SELECT_BY_TEXT, color);
        }
        return this;
    }

    public ShoppingCartPage addProductToCart(){
        actionKeyword.click(this.getBtnAddToCart());
        return new ShoppingCartPage(_driver);
    }


}

