package tests.Exercises01;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationPractice;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.security.Key;

public class E06_Test_ContactUsForm {

    @Test
    public void test01(){

    // https://automationpractice.pl/index.php adresine git
        Driver.getDriver().get(ConfigReader.getProperty("cptUrl"));

    // Sayfandaki "Contact us" linkine tıkla
        AutomationPractice automationPractice = new AutomationPractice();

        automationPractice.contactUs.click();

        ReusableMethods.bekle(2);

    // Subject Heading dropdown'undan "Customer service" seç
        Select select = new Select(automationPractice.konuBasligiDropdown);
        select.selectByVisibleText("Customer service");

        ReusableMethods.bekle(2);

    // Faker ile sahte bir e-posta oluştur, yaz
        Faker faker = new Faker();
        automationPractice.contactEmail.sendKeys(faker.internet().emailAddress());

    // Order reference alanına sahte bir referans gir
        automationPractice.orderReference.sendKeys("ORD" + faker.number().digits(5));

    // Message kutusuna mesaj yaz
        automationPractice.messageBox.sendKeys("hallo,whats up, how are you? this is Test");

        ReusableMethods.bekle(2);

    // Dosya yükle (örnek bir .txt dosyası olabilir)
        String dosyaYolu = System.getProperty("user.dir") + "/src/test/java/resources/sample.txt";
        automationPractice.fileUbload.sendKeys(dosyaYolu);

    // "Send" butonuna tıkla
        automationPractice.submitMessage.click();

    // "Your message has been successfully sent to our team." mesajını doğrula
        Assert.assertTrue(automationPractice.successMessage.isDisplayed());

    // sayfayi kapat
        Driver.quitDriver();

    }
}
