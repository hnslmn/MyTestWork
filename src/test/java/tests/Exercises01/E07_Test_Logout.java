package tests.Exercises01;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationPractice;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class E07_Test_Logout {

    @Test
    public void Test01(){

        // https://automationpractice.pl/index.php adresine git
        Driver.getDriver().get(ConfigReader.getProperty("cptUrl"));
        ReusableMethods.bekle(2);

        // Sağ üstteki "Sign in" butonuna tıkla
        AutomationPractice automationPractice = new AutomationPractice();
        automationPractice.homePageSigninButton.click();

        // ConfigReader'dan email ve şifre bilgilerini al, giriş yap
        String email = ConfigReader.getProperty("cptEmail");
        String password = ConfigReader.getProperty("cptPassword");

        automationPractice.emailAdressFeld.sendKeys(email);
        automationPractice.passwordFeld.sendKeys(password);

        automationPractice.signinButton.click();
        ReusableMethods.bekle(2);

        // Başarılı login olduğunu doğrula ("My account" ya da "Sign out" butonu görünsün)
        Assert.assertTrue(automationPractice.signoutButton.isDisplayed());

        // "Sign out" butonuna tıkla
        automationPractice.signoutButton.click();

        // Tekrar login ekranına döndüğünü doğrula (email-password alanları görünür mü kontrol et)
        Assert.assertTrue(automationPractice.homePageSigninButton.isDisplayed());

        // sayfayi kapat
        // Driver.quitDriver();

    }
}
