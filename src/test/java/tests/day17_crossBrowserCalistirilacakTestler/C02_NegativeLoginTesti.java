package tests.day17_crossBrowserCalistirilacakTestler;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseCross;

public class C02_NegativeLoginTesti extends TestBaseCross {

    @Test
    public void gecersizPasswordTesti() {

        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        driver.get(ConfigReader.getProperty("toUrl"));

        // 2- account linkine basin
        driver.findElement(By.xpath("(//span[.='Account'])[1]"))
                .click();

        // 3- 3 farkli test method’u olusturun
        //  - gecerli email, gecersiz password
        WebElement emailKutusu = driver.findElement(By.id("email"));
        emailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));

        WebElement passwordKutusu = driver.findElement(By.id("password"));
        passwordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));

        // 4- Login butonuna basarak login olmayi deneyin
        Actions actions = new Actions(driver);
        ReusableMethods.bekle(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        driver.findElement(By.id("submitlogin"))
                .click();

        // 5- Basarili olarak giris yapilamadigini test edin
        emailKutusu = driver.findElement(By.id("email"));
        Assert.assertTrue(emailKutusu.isDisplayed());

    }

    @Test
    public void gecersizEmailTesti() {

        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        driver.get(ConfigReader.getProperty("toUrl"));

        // 2- account linkine basin
        driver.findElement(By.xpath("(//span[.='Account'])[1]"))
                .click();

        // 3- 3 farkli test method’u olusturun
        //  - gecersiz email, gecerli password
        WebElement emailKutusu = driver.findElement(By.id("email"));
        emailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));

        WebElement passwordKutusu = driver.findElement(By.id("password"));
        passwordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));

        // 4- Login butonuna basarak login olmayi deneyin
        Actions actions = new Actions(driver);
        ReusableMethods.bekle(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        driver.findElement(By.id("submitlogin"))
                .click();

        // 5- Basarili olarak giris yapilamadigini test edin
        emailKutusu = driver.findElement(By.id("email"));
        Assert.assertTrue(emailKutusu.isDisplayed());

    }

    @Test
    public void gecersizEmailVePasswordTesti() {

        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        driver.get(ConfigReader.getProperty("toUrl"));

        // 2- account linkine basin
        driver.findElement(By.xpath("(//span[.='Account'])[1]"))
                .click();

        // 3- 3 farkli test method’u olusturun
        //  - gecersiz email, gecersiz password
        WebElement emailKutusu = driver.findElement(By.id("email"));
        emailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));

        WebElement passwordKutusu = driver.findElement(By.id("password"));
        passwordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));

        // 4- Login butonuna basarak login olmayi deneyin
        Actions actions = new Actions(driver);
        ReusableMethods.bekle(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        driver.findElement(By.id("submitlogin"))
                .click();

        // 5- Basarili olarak giris yapilamadigini test edin
        emailKutusu = driver.findElement(By.id("email"));
        Assert.assertTrue(emailKutusu.isDisplayed());

    }

}
