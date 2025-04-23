package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TestOtomasyonuPage {


    public TestOtomasyonuPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(id = "global-search")
    public WebElement aramakutusu;

    @FindBy(xpath = "//*[@*='prod-img']")
    public List<WebElement> bulunanUrunElementleriList;

    @FindBy(xpath = "//div[@class=' heading-sm mb-4']")
    public WebElement ilkUrunSayfasindakiIsimElementi;

    @FindBy(xpath = "(//span[.='Account'])[1]")
    public WebElement accountLinki;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement loginSayfasiEmailKutusu;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement loginSayfasiPasswordButonu;

    @FindBy(xpath = "//button[@id='submitlogin']")
    public WebElement loginSayfasiSubmitButonu;

    @FindBy(xpath = "//span[.='Logout']")
    public WebElement logoutButonu;

    @FindBy(xpath = "//*[@class='add-to-cart']")
    public WebElement addToCardButonu;

    @FindBy(xpath = "(//span[.='Your Cart'])[1]")
    public WebElement yourCardButonu;

    @FindBy(xpath = "//*[@*='product-title text-center']")
    public WebElement sepettekiUrunIsimElementi;

    @FindBy(xpath = "//*[@*='product-count-text']")
    public WebElement aramaSonucElementi;

}
