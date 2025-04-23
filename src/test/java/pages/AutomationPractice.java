package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AutomationPractice {

    public AutomationPractice(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id='search_query_top']")
    public WebElement globalSearch;

    @FindBy(className = "ajax_block_product")
    public List<WebElement> productList;

    @FindBy(className = "login")
    public WebElement loginButton;

    @FindBy(xpath = "//*[@id='email']")
    public WebElement emailAdressfeld;

    @FindBy(xpath = "//*[@id='passwd']")
    public WebElement passwordFeld;

    @FindBy(xpath = "//*[@class='icon-lock left']")
    public WebElement signinButton;

    @FindBy(xpath = "//*[@class='shopping_cart']")
    public WebElement shoppingCartButton;

    @FindBy(id = "group_1")
    public WebElement sizeSelect;

    @FindBy(id = "add_to_cart")
    public WebElement addToCart;

    @FindBy(xpath = "//*[@title='Proceed to checkout']")
    public WebElement proceedToCheckout;    // odemeye dogru direk ilerle

    @FindBy(xpath = "//*[@title='Continue shopping']")
    public WebElement continueShopping;     // alısverise don

    @FindBy(xpath = "//*[@class='icon-trash']")
    public List<WebElement> iconTrash;

}
