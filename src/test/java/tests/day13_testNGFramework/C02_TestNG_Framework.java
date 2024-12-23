package tests.day13_testNGFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;

public class C02_TestNG_Framework {

    /*
        TestNG POM (Page Object Model) framework ile
        temel hedefimiz test class'inda surekli kullandigimiz
            1- WebDriver objesi
            2- Locate'ler
            3- Test data'lari (kullanici adi, sifre ...)

            gibi verileri tek bir yere yazip
            test class'larinda dinamik kod kullanarak
            yapilan guncellemelerde kolay bir sekilde yeni degeri tanimlamayi mumkun kilmak
     */

    /*
        TestNG WebDriver objesi olan driver'i TestBase class'da uretip
        her Test Class'ini extends yapmaya mecbur etmek yerine

        WebDriver objesini Driver class'indaki
        static bir method ile olusturmayi tercih etmistir
     */

    @Test
    public void driverClassIlkTest(){

        Driver.getDriver().get("https://www.testotomasyonu.com");

        // arama kutusunu locate edip
        WebElement aramaKutusu = Driver.driver.findElement(By.id("global-search"));

        // phone icin arama yapin
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        Driver.quitDriver();

    }

}
