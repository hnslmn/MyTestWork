package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ZeroPage {

    public ZeroPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id='signin_button']")
    public WebElement anaSayfaSigninButonu;

    @FindBy(xpath = "//*[@id='user_login']")
    public WebElement loginKutusu;

    @FindBy(xpath = "//*[@id='user_password']")
    public WebElement passwordKutusu;

    @FindBy(name = "submit")
    public WebElement SignInButton;

    @FindBy(xpath = "(//*[@class='dropdown-toggle'])[1]")
    public WebElement settingsMenu;

    @FindBy(id = "onlineBankingMenu")
    public WebElement onlineBankingMenu;

    @FindBy(xpath = "//span[@id='pay_bills_link']")
    public WebElement payBills;

    @FindBy(xpath = "//a[.='Purchase Foreign Currency']")
    public WebElement purchaseForeignCurrency;

    @FindBy(xpath = "//*[@id='pc_currency']")
    public WebElement currencyDdm;

}
