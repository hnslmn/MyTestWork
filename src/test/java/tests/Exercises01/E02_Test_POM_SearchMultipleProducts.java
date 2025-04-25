package tests.Exercises01;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.AutomationPractice;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

@Test
public class E02_Test_POM_SearchMultipleProducts {

    public void test01(){

        // https://automationpractice.pl/index.php adresine git

        Driver.getDriver().get(ConfigReader.getProperty("cptUrl"));

        ReusableMethods.bekle(2);

        // Arama kutusuna dress yazdir ve tiklar

        AutomationPractice automationPractice = new AutomationPractice();
        automationPractice.globalSearch.sendKeys("dress" + Keys.ENTER);

        ReusableMethods.bekle(2);

        // ikinci urune tikla

        automationPractice.productList.get(1).click();

        // L beden sec

        Select select = new Select(automationPractice.sizeSelect);

        select.selectByVisibleText("L");

        // mavi rengi sec

        WebElement colorSelect = Driver.getDriver().findElement(By.xpath("//*[@title='Blue']"));

        ReusableMethods.bekle(1);

        colorSelect.click();

        // asagiya indirmek gerekiyor

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform();

        // sepete ekle

        automationPractice.addToCart.click();

        // alisverise devam et

        automationPractice.continueShopping.click();

        ReusableMethods.bekle(2);

        // geri gel

        Driver.driver.navigate().back();
        Driver.driver.navigate().back();
        Driver.driver.navigate().back();

        ReusableMethods.bekle(2);

        // 2.ürüne tikla

        ReusableMethods.bekle(2);

        automationPractice.productList.get(1).click();

        ReusableMethods.bekle(2);

        //M beden seç

        Select select1 = new Select(automationPractice.sizeSelect);
        select1.selectByVisibleText("M");

        // sarı renk seç

        WebElement colorSelectYellow = Driver.getDriver().findElement(By.xpath("//*[@title='Yellow']"));

        ReusableMethods.bekle(1);

        colorSelectYellow.click();

        // asagiya indirmek gerekiyor

        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform();

        // Sepete ekle

        automationPractice.addToCart.click();

        // odeme icin sepeti goruntule

        automationPractice.proceedToCheckout.click();

        // ilk urunu sepetten sil

        automationPractice.iconTrash.get(0).click();

        // cikis yap

        Driver.quitDriver();

    }
}
