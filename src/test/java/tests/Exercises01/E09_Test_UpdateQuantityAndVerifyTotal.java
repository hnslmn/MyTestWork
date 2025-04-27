package tests.Exercises01;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AP_HomePage;
import pages.AP_LoginPage;
import pages.AP_ProductPage;
import pages.AutomationPractice;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.security.Key;

public class E09_Test_UpdateQuantityAndVerifyTotal {

    @Test
    public void test01(){

        // https://automationpractice.pl/index.php adresine git
        Driver.getDriver().get(ConfigReader.getProperty("cptUrl"));

        AP_HomePage homePage = new AP_HomePage();
        AP_LoginPage loginPage = new AP_LoginPage();
        AP_ProductPage productPage = new AP_ProductPage();

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

        // İlk ürüne tikla M beden, Pembe renk sec
        productPage.productList.get(0).click();

        ReusableMethods.bekle(2);

        Select select = new Select(productPage.sizeSelect);
        select.selectByVisibleText("M");

        WebElement colorSelect = Driver.driver.findElement(By.xpath("//*[@title='Pink']"));
        colorSelect.click();

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform();

        // sepete ekle
        productPage.addToCart.click();

        // "Continue shopping" butonuna tıkla
        productPage.continueShopping.click();
        ReusableMethods.bekle(2);

        // geri gel 2.urune tikla
        ReusableMethods.geriGit(3);
        ReusableMethods.bekle(3);

        productPage.productList.get(1).click();
        ReusableMethods.bekle(2);

        Select select1 = new Select(productPage.sizeSelect);
        select1.selectByVisibleText("M");

        WebElement colorSelect1 = Driver.driver.findElement(By.xpath("//*[@title='Yellow']"));
        colorSelect1.click();

        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform();

        // sepete ekle
        productPage.addToCart.click();

        // Sepete git (Proceed to checkout)
        productPage.proceedToCheckout.click();
        ReusableMethods.bekle(2);

        // Sepette ilk ürün adedini 2'ye çıkar
        productPage.quantityUpButtons.get(0).click();
        ReusableMethods.bekle(2);

        // Toplam fiyatı kaydet
        String totalPrice1 = productPage.totalPrice.getText();

        // Ürün adedini tekrar 1'e düşür
        productPage.quantityDownButtons.get(0).click();
        ReusableMethods.bekle(2);

        // Yeni toplam fiyatı kaydet
        String totalPrice2 = productPage.totalPrice.getText();

        // Fiyat değişimini kontrol et
        Assert.assertNotEquals(totalPrice1,totalPrice2);

        // Tarayıcıyı kapat
        Driver.quitDriver();

    }
}
