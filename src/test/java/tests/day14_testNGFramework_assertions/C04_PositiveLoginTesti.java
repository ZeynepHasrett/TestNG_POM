package tests.day14_testNGFramework_assertions;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_PositiveLoginTesti {
    /*
        Testlerimizi DINAMIK yapmak
        ve test datalarina KOLAY ERISMEK icin
        test datalarini configuration.properties dosyasina yazip
        ihtiyacimiz oldugunda oradan almak istiyoruz

        Java ile o bilgilere ulasmak icin
        once dosya yolunu almamiz
        sonra oradaki bilgileri okumamiz,
        bilgiler icerisinde ihtiyacimiz olan "toUrl", "toGecerliEmail"
        gibi bilgileri diger bilgilerden ayirip
        alip bu test class'ina getirmemiz tek satirla olabilecek bir islem degildir

        Bu uzun islemi bizim adimiza yapip
        verdigimiz "toUrl", "toGecerliEmail" gibi key'lerin
        karsisindaki value'leri alip bize getirecek hazir bir method olusturalim
     */

    @Test(groups = {"smoke", "Regression", "E2E"})
    public void positiveLoginTesti() {
        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get("https://www.testotomasyonu.com/");

        // 2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();

        testotomasyonuPage.accountLinki
                            .click();

        // 3- Kullanici email'i olarak gecerli email girin
        testotomasyonuPage.emailKutusu.sendKeys("wise@gmail.com");

        // 4- Kullanici sifresi olarak gecerli password girin
        testotomasyonuPage.passwordKutusu.sendKeys("12345");

        // 5- Login butonuna basarak login olun
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        testotomasyonuPage.loginButonu
                            .click();

        // 6- Basarili olarak giris yapilabildigini test edin
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Assert.assertTrue(testotomasyonuPage.logoutButonu.isDisplayed());

        // 7- logout olun
        testotomasyonuPage.logoutButonu
                            .click();

        Driver.quitDriver();

    }

    @Test(groups = {"smoke", "Regression"})
    public void dinamikPositiveLoginTesti(){
        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // 2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();

        testotomasyonuPage.accountLinki
                            .click();

        // 3- Kullanici email'i olarak gecerli email girin
        testotomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));

        // 4- Kullanici sifresi olarak gecerli password girin
        testotomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));

        // 5- Login butonuna basarak login olun
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        testotomasyonuPage.loginButonu
                            .click();

        // 6- Basarili olarak giris yapilabildigini test edin
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Assert.assertTrue(testotomasyonuPage.logoutButonu.isDisplayed());

        // 7- logout olun
        testotomasyonuPage.logoutButonu
                            .click();

        Driver.quitDriver();

    }

}
