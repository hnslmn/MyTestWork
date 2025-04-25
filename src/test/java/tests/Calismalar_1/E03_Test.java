package tests.Calismalar_1;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationPractice;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;


public class E03_Test {

    @Test
    public void test01(){

        // https://automationpractice.pl/index.php adresine git

        Driver.getDriver().get(ConfigReader.getProperty("cptUrl"));


        // Sağ üstteki "Sign in" butonuna tıkla

        AutomationPractice automationPractice = new AutomationPractice();
        automationPractice.homePageSigninButton.click();


        // Faker ile sahte e-posta ve şifre üret

        Faker faker = new Faker();
        String fakeEmail = faker.internet().emailAddress();
        String fakePassword = faker.internet().password();


        // E-posta ve şifre alanlarına bu bilgileri yaz

        automationPractice.emailAdressfeld.sendKeys(fakeEmail);
        automationPractice.passwordFeld.sendKeys(fakePassword);


        // "Sign in" butonuna tıkla

        automationPractice.signinButton.click();

        ReusableMethods.bekle(2);

        // "Authentication failed." hata mesajının göründüğünü doğrula

        WebElement hataMesaji = Driver.getDriver().findElement(By.xpath("(//div[@class='alert alert-danger'])[1]"));
        Assert.assertTrue(hataMesaji.isDisplayed());

        // Sayfayı kapat
        Driver.quitDriver();

    }
}
