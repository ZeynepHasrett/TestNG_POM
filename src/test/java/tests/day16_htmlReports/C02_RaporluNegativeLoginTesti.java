package tests.day16_htmlReports;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.TestotomasyonuPage;

import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C02_RaporluNegativeLoginTesti extends TestBaseRapor {

    static TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();

    @Test
    public void gecersizPasswordTesti() {
        extentTest = extentReports.createTest("Gecersiz Password Testi",
                "Kullanici gecerli email ve gecersiz password ile giris yapamamali");

        testotomasyonuPage = new TestotomasyonuPage();

        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici test otomasyonu anasayfasina gider");

        // 2- account linkine basin
        testotomasyonuPage.accountLinki
                .click();
        extentTest.info("Account linkine basar");

        // 3- 3 farkli test method’u olusturun
        //  - gecerli email, gecersiz password
        testotomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));
        extentTest.info("Email kutusuna gecerli email girer");

        testotomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));
        extentTest.info("Password kutusuna gecersiz password girer");

        // 4- Login butonuna basarak login olmayi deneyin
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        testotomasyonuPage.loginButonu
                .click();
        extentTest.info("Login butonuna basarak login olmayi dener");

        // 5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.emailKutusu.isDisplayed());
        extentTest.pass("Basarili olarak giris yapilamadigini test eder");

        extentTest.info("Sayfayi kapatir");

    }

    @Test
    public void gecersizEmailTesti() {
        extentTest = extentReports.createTest("Gecersiz Email Testi",
                    "Kullanici gecersiz email ve gecerli password ile giris yapamamali");

        testotomasyonuPage = new TestotomasyonuPage();

        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici test otomasyonu anasayfasina gider");

        // 2- account linkine basin
        testotomasyonuPage.accountLinki
                .click();
        extentTest.info("Account linkine basar");

        // 3- 3 farkli test method’u olusturun
        //  - gecersiz email, gecerli password
        testotomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        extentTest.info("Email kutusuna gecersiz email girer");

        testotomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));
        extentTest.info("Password kutusuna gecerli password girer");

        // 4- Login butonuna basarak login olmayi deneyin
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        testotomasyonuPage.loginButonu
                .click();
        extentTest.info("Login butonuna basarak login olmayi dener");

        // 5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.emailKutusu.isDisplayed());
        extentTest.pass("Basarili olarak giris yapilamadigini test eder");

        extentTest.info("Sayfayi kapatir");

    }

    @Test
    public void gecersizEmailVePasswordTesti() {
        extentTest = extentReports.createTest("Gecersiz Email ve Password Testi",
                    "Kullanici gecersiz email ve gecersiz password ile giris yapamamali");

        testotomasyonuPage = new TestotomasyonuPage();

        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici test otomasyonu anasayfasina gider");

        // 2- account linkine basin
        testotomasyonuPage.accountLinki
                .click();
        extentTest.info("Account linkine basar");

        // 3- 3 farkli test method’u olusturun
        //  - gecersiz email, gecersiz password
        testotomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        extentTest.info("Email kutusuna gecersiz email girer");

        testotomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));
        extentTest.info("Password kutusuna gecersiz password girer");

        // 4- Login butonuna basarak login olmayi deneyin
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        testotomasyonuPage.loginButonu
                .click();
        extentTest.info("Login butonuna basarak login olmayi dener");

        // 5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.emailKutusu.isDisplayed());
        extentTest.pass("Basarili olarak giris yapilamadigini test eder");

        extentTest.info("Sayfayi kapatir");

    }

}
