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
    public WebElement sizeSelect;   // beden secme

    @FindBy(id = "add_to_cart")
    public WebElement addToCart;    // sepete ekleme

    @FindBy(xpath = "//*[@title='Proceed to checkout']")
    public WebElement proceedToCheckout;    // odemeye dogru direk ilerle

    @FindBy(xpath = "//*[@title='Continue shopping']")
    public WebElement continueShopping;     // alısverise don

    @FindBy(xpath = "//*[@class='icon-trash']")
    public List<WebElement> iconTrash;

    @FindBy(xpath = "//div[@class='header_user_info']")
    public WebElement homePageSigninButton;

    @FindBy(xpath = "//*[@id='email_create']")
    public WebElement createAccountEmail;   // kayıt bolumu email kutusu

    @FindBy(xpath = "//*[@class='icon-user left']")
    public WebElement createAnAccount;  // kayıt ol

    @FindBy(xpath = "//*[@id='id_gender1']")
    public WebElement genderMaleRadio;      // erkek butonu

    @FindBy(xpath = "//*[@id='id_gender2']")
    public WebElement genderFemaleRadio;      // erkek butonu

    @FindBy(xpath = "//*[@id='customer_firstname']")
    public WebElement firstName;

    @FindBy(xpath = "//*[@id='customer_lastname']")
    public WebElement lastName;

    @FindBy(xpath = "//*[@id='passwd']")
    public WebElement password;

    @FindBy(xpath = "//*[@id='days']")
    public WebElement dayDropdown;

    @FindBy(xpath = "//*[@id='months']")
    public WebElement monthDropdown;

    @FindBy(xpath = "//*[@id='years']")
    public WebElement yearDropdown;

    @FindBy(id = "submitAccount")
    public WebElement registerButton;    // register kayıt ol butonu

    @FindBy(id = "alert alert-success")
    public WebElement registrationCompleted;       // kayıt tamamlandı mesajı

    @FindBy(xpath = "(//div[@class='header_user_info'])[1]")
    public WebElement myAccountHeader;  // Hesap basligi

    @FindBy(xpath = "//*[@class='logout']")
    public WebElement signoutButton;

}
