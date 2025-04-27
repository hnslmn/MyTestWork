package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AP_HomePage {

    public AP_HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@class='login']")
    public WebElement homePageSigninButton; // Ana sayfadaki Sign in butonu

    @FindBy(xpath = "//*[@id='search_query_top']")
    public WebElement globalSearch; // Ana sayfadaki arama kutusu

    @FindBy(xpath = "//*[@class='shopping_cart']")
    public WebElement shoppingCartButton; // Ana sayfadaki sepet butonu
}
