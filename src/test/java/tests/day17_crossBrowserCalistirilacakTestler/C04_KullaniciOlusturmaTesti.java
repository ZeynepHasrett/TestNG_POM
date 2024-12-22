package tests.day17_crossBrowserCalistirilacakTestler;

import com.github.javafaker.Faker;
import org.apache.logging.log4j.message.ReusableMessage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.ReusableMethods;
import utilities.TestBaseCross;

public class C04_KullaniciOlusturmaTesti extends TestBaseCross {

    @Test
    public void KullaniciOlusturmaTesti() {

        // testotomasyonu anasayfaya gidin
        driver.get(ConfigReader.getProperty("toUrl"));

        // account butonuna basin
        driver.findElement(By.xpath("(//span[.='Account'])[1]"))
                .click();

        // signUp butonuna basin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        driver.findElement(By.xpath("//*[@class='sign-up ']"))
                .click();

        // formdaki bilgileri fake degerlerle doldurun
        Faker faker = new Faker();

        WebElement firstNameKutusu = driver.findElement(By.id("firstName"));

        String fakeEmail = faker.internet().emailAddress();
        String fakePassword = faker.internet().password();

        actions.click(firstNameKutusu)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(fakeEmail)
                .sendKeys(Keys.TAB)
                .sendKeys(fakePassword)
                .sendKeys(Keys.TAB)
                .sendKeys(fakePassword).perform();

        // SignUp butonuna basin
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        driver.findElement(By.id("btn-submit-form"))
                .click();

        // Kayit olusturuldugunu test edin
        // kayit olusturulunca bizi login sayfasina yonlendiriyor
        // kayit olustugunu test etmek icin
        // kullandigimiz fake email ve fake sifre ile giris yapip
        // giris yapabildigimizi test edelim
        ReusableMethods.bekle(2);
        WebElement emailKutusu = driver.findElement(By.id("email"));
        emailKutusu.sendKeys(fakeEmail);

        WebElement passwordKutusu = driver.findElement(By.id("password"));
        passwordKutusu.sendKeys(fakePassword);

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        driver.findElement(By.id("submitlogin"))
                .click();

        // 6- Basarili olarak giris yapilabildigini test edin
        WebElement logoutButonu = driver.findElement(By.xpath("//span[.='Logout']"));
        Assert.assertTrue(logoutButonu.isDisplayed());

    }

}
