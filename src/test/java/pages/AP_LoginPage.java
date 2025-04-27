package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AP_LoginPage {

    public AP_LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id='email']")
    public WebElement emailAdressFeld; // Email input

    @FindBy(xpath = "//*[@id='passwd']")
    public WebElement passwordFeld; // Password input

    @FindBy(xpath = "//*[@class='icon-lock left']")
    public WebElement signinButton; // Sign in butonu

    @FindBy(xpath = "//*[@class='logout']")
    public WebElement signoutButton; // Logout butonu
}
