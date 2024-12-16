package tests.day14_testNGFramework_assertions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C05_DinamicNegativeLoginTesti {

    // 1- https://www.testotomasyonu.com/ anasayfasina gidin
    // 2- account linkine basin
    // 3-  3 farkli test method’u olusturun.
    //	    - gecerli email, gecersiz password
    //	    - gecersiz email, gecerli password
    //	    - gecersiz email, gecersiz password.
    // 4- Login butonuna basarak login olmayi deneyin
    // 5- Basarili olarak giris yapilamadigini test edin

    static TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();

    @Test
    public void gecersizPasswordTesti() {

        testotomasyonuPage = new TestotomasyonuPage();

        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // 2- account linkine basin
        testotomasyonuPage.accountLinki
                .click();

        // 3- 3 farkli test method’u olusturun
        //  - gecerli email, gecersiz password
        testotomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));
        testotomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));

        // 4- Login butonuna basarak login olmayi deneyin
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        testotomasyonuPage.loginButonu
                            .click();

        // 5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.emailKutusu.isDisplayed());

        Driver.quitDriver();

    }

    @Test
    public void gecersizEmailTesti() {

        testotomasyonuPage = new TestotomasyonuPage();

        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // 2- account linkine basin
        testotomasyonuPage.accountLinki
                            .click();

        // 3- 3 farkli test method’u olusturun
        //  - gecersiz email, gecerli password
        testotomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        testotomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));

        // 4- Login butonuna basarak login olmayi deneyin
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        testotomasyonuPage.loginButonu
                            .click();

        // 5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.emailKutusu.isDisplayed());

        Driver.quitDriver();

    }

    @Test
    public void gecersizEmailVePasswordTesti() {

        testotomasyonuPage = new TestotomasyonuPage();

        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // 2- account linkine basin
        testotomasyonuPage.accountLinki
                            .click();

        // 3- 3 farkli test method’u olusturun
        //  - gecersiz email, gecersiz password
        testotomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        testotomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));

        // 4- Login butonuna basarak login olmayi deneyin
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        testotomasyonuPage.loginButonu
                            .click();

        // 5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.emailKutusu.isDisplayed());

        Driver.quitDriver();

    }

}
