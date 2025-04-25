package tests.Exercises01;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationPractice;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class E05_Test_PositiveLoginWithConfig {

    @Test
    public void test01(){

        // https://automationpractice.pl/index.php adresine git
        Driver.getDriver().get(ConfigReader.getProperty("cptUrl"));

        // Sign in butonuna tıkla
        AutomationPractice automationPractice = new AutomationPractice();
        automationPractice.homePageSigninButton.click();

        // Email ve şifreyi config'den al
        String email = ConfigReader.getProperty("cptEmail");
        String password = ConfigReader.getProperty("cptPassword");

        // Email ve şifreyi gir
        automationPractice.emailAdressfeld.sendKeys(email);
        automationPractice.passwordFeld.sendKeys(password);

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.ARROW_DOWN).perform();

        // Sign in
        automationPractice.signinButton.click();

        ReusableMethods.bekle(2);

        // Başarılı giriş yapıldığını doğrula
        Assert.assertTrue(automationPractice.signoutButton.isDisplayed());

        // Tarayıcıyı kapat
        Driver.quitDriver();

    }
}
