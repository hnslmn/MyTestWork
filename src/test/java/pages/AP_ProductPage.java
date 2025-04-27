package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AP_ProductPage {

    public AP_ProductPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@class='product_img_link']")
    public List<WebElement> productList;

    @FindBy(id = "group_1")
    public WebElement sizeSelect;   // beden secme

    @FindBy(xpath = "//*[@id='add_to_cart']")
    public WebElement addToCart;

    @FindBy(xpath = "//*[@title='Continue shopping']")
    public WebElement continueShopping;

    @FindBy(xpath = "//*[@title='Proceed to checkout']")
    public WebElement proceedToCheckout;

    @FindBy(xpath = "//*[contains(@class, 'cart_quantity_up')]")
    public List<WebElement> quantityUpButtons;   // Herhangi bir elementin class attribute'u içinde "cart_quantity_up" kelimesi geçiyor mu diye bak.

    @FindBy(xpath = "//*[contains(@class, 'cart_quantity_down')]")
    public List<WebElement> quantityDownButtons;

    @FindBy(xpath = "//*[@id='total_price']")
    public WebElement totalPrice;

}
