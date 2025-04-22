package tests.Calismalar_1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class E01_Test {

    @Test
    public void test01(){

        // https://automationpractice.pl/index.php adresine git

        Driver.getDriver().get("https://automationpractice.pl/index.php");

        // Arama kutusuna dress yazdir

        WebElement aramaKutusu = Driver.driver.findElement(By.xpath("//*[@id='search_query_top']"));

        aramaKutusu.sendKeys("dress");

        // aramayı yap

        aramaKutusu.submit();

        ReusableMethods.bekle(2);

        // Sonuç sayfasında ürün listesinin göründüğünü kontrol et

        List<WebElement> urunlerListesi = Driver.driver.findElements(By.xpath("//*[@class='page-heading  product-listing']"));

        Assert.assertTrue(urunlerListesi.size()>0);

        // ilk urune tikla

        WebElement ilkUrun = Driver.driver.findElement(By.xpath("(//*[@class='product-image-container'])[1]"));

        ilkUrun.click();

        // M beden sec

        WebElement bedenSecme = Driver.driver.findElement(By.id("group_1"));

        Select select = new Select(bedenSecme);

        select.selectByVisibleText("M");

        // pembe rengi sec

        WebElement renkSecimi = Driver.getDriver().findElement(By.xpath("//*[@title='Pink']"));

        ReusableMethods.bekle(1);

        renkSecimi.click();

        // asagiya indirmek gerekiyor

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform();

        // sepete ekle

        WebElement addToCard = Driver.driver.findElement(By.id("add_to_cart"));

        addToCard.click();

        ReusableMethods.bekle(1);

        // sepeti goruntule

        WebElement sepeteGit = Driver.driver.findElement(By.xpath("//*[@class='btn btn-default button button-medium']"));

        sepeteGit.click();

        ReusableMethods.bekle(2);

        // urunu sepetten sil

        WebElement urunuSil = Driver.driver.findElement(By.id("4_44_0_0"));

        urunuSil.click();

        // sepetin bos gorundugunu test edin

        WebElement sepetBos = Driver.driver.findElement(By.xpath("//p[@class='alert alert-warning']"));

        String actualSepet = sepetBos.getText();
        String expectedSepet = "Your shopping cart is empty.";

        Assert.assertEquals(expectedSepet,actualSepet);

        // cikis yap

        Driver.quitDriver();

    }
}
