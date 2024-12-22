package tests.day17_crossBrowserCalistirilacakTestler;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseCross;

import java.time.Duration;

public class C03_UrunAramaTesti extends TestBaseCross {

    @Test
    public void test01() {

        // https://www.testotomasyonu.com sayfasina gidin
        driver.get("https://www.testotomasyonu.com");

        // phone icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // arama sonucunda urun bulunabildigini test edin
        WebElement aramaSonucElementi = driver.findElement(By.className("product-count-text"));

        String unexpectedSonuc = "0 Product Found";
        String actualSonuc = aramaSonucElementi.getText();

        Assert.assertNotEquals(actualSonuc, unexpectedSonuc);

    }

}
