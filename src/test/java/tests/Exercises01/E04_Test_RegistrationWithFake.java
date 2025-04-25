package tests.Exercises01;

import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationPractice;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;


public class E04_Test_RegistrationWithFake {

    @Test
    public void test01(){

        // https://automationpractice.pl/index.php adresine git
        Driver.getDriver().get(ConfigReader.getProperty("cptUrl"));

        // Sağ üstteki "Sign in" butonuna tıkla
        AutomationPractice automationPractice = new AutomationPractice();
        automationPractice.homePageSigninButton.click();

        // Faker ile sahte bir e-posta üret

        Faker faker = new Faker();
        String fakeEmail = faker.internet().emailAddress();
        String fakePassword = faker.internet().password();

        // "Create an account" alanına bu e-postayı gir ve "Create an account" butonuna tıkla

        automationPractice.createAccountEmail.sendKeys(fakeEmail);
        System.out.println(fakeEmail);
        System.out.println(fakePassword);

        automationPractice.createAnAccount.click();

        ReusableMethods.bekle(3);


        // Gelen formda gerekli alanları doldur: (cinsiyet, isim, soyisim, şifre, dogum tarihi)

        // cinsiyet
        automationPractice.genderFemaleRadio.click();

        // isim, soyisim
        String  fakeName = faker.name().firstName();
        String  fakelastName = faker.name().lastName();

        automationPractice.firstName.sendKeys(fakeName);
        automationPractice.lastName.sendKeys(fakelastName);

        // şifre
        automationPractice.password.sendKeys(fakePassword);

        // dogum tarihi

        Select select1 = new Select(automationPractice.dayDropdown);
        select1.selectByValue("27");

        Select select2 = new Select(automationPractice.monthDropdown);
        select2.selectByValue("4");

        Select select3 = new Select(automationPractice.yearDropdown);
        select3.selectByValue("2019");

        // "Register" butonuna tıkla

        automationPractice.registerButton.click();

        // Kayıt işleminin başarılı olduğunu "My account" başlığıyla doğrula

        Assert.assertTrue(automationPractice.myAccountHeader.isDisplayed());

        // sayfayi kapat

        Driver.quitDriver();

    }
}
