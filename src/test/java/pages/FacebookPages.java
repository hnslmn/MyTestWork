package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPages {

    public FacebookPages(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//span[.='Tüm çerezlere izin ver'])[3]")
    public WebElement cookiesKabulButonu;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement loginSayfasiEmailKutusu;

    @FindBy(xpath = "//input[@id='pass']")
    public WebElement loginSayfasiPasswordKutusu;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginSayfasiLoginButonu;

}
