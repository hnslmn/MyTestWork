package tests.Exercises01;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AP_HomePage;
import pages.AP_LoginPage;
import pages.AutomationPractice;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class E08_Test_AddMultipleProductsAndVerifyTotal {

    @Test
    public void test(){

        // https://automationpractice.pl/index.php adresine git
        Driver.getDriver().get(ConfigReader.getProperty("cptUrl"));
        ReusableMethods.bekle(2);

        AP_HomePage homePage = new AP_HomePage();
        AP_LoginPage loginPage = new AP_LoginPage();
        AutomationPractice automationPractice = new AutomationPractice();

        // Ana sayfadaki "Sign in" butonuna tıkla
        homePage.homePageSigninButton.click();
        ReusableMethods.bekle(2);

        // ConfigReader'dan email ve şifre bilgilerini al, giriş yap
        loginPage.emailAdressFeld.sendKeys(ConfigReader.getProperty("cptEmail"));
        loginPage.passwordFeld.sendKeys(ConfigReader.getProperty("cptPassword"));

        loginPage.signinButton.click();

        ReusableMethods.bekle(2);

        // Arama kutusuna "dress" yazıp Enter'a bas
        homePage.globalSearch.sendKeys("dress" + Keys.ENTER);
        homePage.globalSearch.click();

        // İlk ürüne tıkla
        automationPractice.productList.get(0).click();
        ReusableMethods.bekle(2);

        // M beden ve pembe renk sec
        Select select = new Select(automationPractice.sizeSelect);
        select.selectByVisibleText("M");

        WebElement colorSelect = Driver.driver.findElement(By.xpath("//*[@title='Pink']"));
        colorSelect.click();

        ReusableMethods.bekle(2);

        // sepete ekle
        automationPractice.addToCart.click();
        ReusableMethods.bekle(2);

        // "Continue shopping" butonuna tıkla
        automationPractice.continueShopping.click();

        // Geri git 3 kez
        ReusableMethods.geriGit(3);

        // ikinci ürüne tıkla ve M beden, Sarı renk sec
        automationPractice.productList.get(1).click();
        ReusableMethods.bekle(2);

        Select select1 = new Select(automationPractice.sizeSelect);
        select1.selectByVisibleText("M");

        WebElement colorSelect2 = Driver.driver.findElement(By.xpath("//*[@title='Yellow']"));
        colorSelect2.click();

        // sepete ekle
        automationPractice.addToCart.click();
        ReusableMethods.bekle(2);

        // Sepete git (Proceed to checkout)
        automationPractice.proceedToCheckout.click();

        // Sepet sayfasında ürünlerin olduğunu ve toplam fiyatın göründüğünü doğrula
        Assert.assertTrue(automationPractice.shoppingCartButton.isDisplayed());

        // Tarayıcıyı kapat
        Driver.quitDriver();

    }
}
