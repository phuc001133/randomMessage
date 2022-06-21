package com.example.demotestng.Pages;

import com.example.demotestng.core.configuration.Configuration;
import com.example.demotestng.core.keyword.ActionKeyword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;
import java.io.IOException;

public class BasePage {

    public WebDriver _driver;
    public ActionKeyword actionKeyword;
    public Configuration configuration;
    public BasePage(WebDriver driver){
        this._driver = driver;
        PageFactory.initElements(this._driver, this);
        this.actionKeyword = new ActionKeyword(_driver);
        configuration = new Configuration("");
    }

    public ProductDetailsPage navigateToProductByUrl(String productUrl) throws IOException {
        _driver.navigate().to(configuration.getRunningURL() + productUrl);
        return new ProductDetailsPage(_driver);
    }

    public void OanhDaODay(){

    }
}
