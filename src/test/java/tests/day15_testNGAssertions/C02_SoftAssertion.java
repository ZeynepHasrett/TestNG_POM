package tests.day15_testNGAssertions;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_SoftAssertion {

    @Test
    public void softAssertionTesti(){
        // testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // url'in testotomasyonu icerdigini test edin
        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(actualUrl.contains(expectedUrlIcerik), "url istenen kelimeyi icermiyor");

        // phone icin arama yapin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();

        testotomasyonuPage.aramaKutusu
                            .sendKeys(ConfigReader.getProperty("toAranacakKelime") + Keys.ENTER);

        // urun bulunabildigini test edin
        String unexpectedSonuc = ConfigReader.getProperty("toUnexpectedSonuc");
        String actualSonuc = testotomasyonuPage.aramaSonucuElementi.getText();

        softAssert.assertNotEquals(actualSonuc, unexpectedSonuc, "urun bulunamadi");

        // ilk urunu tiklayip
        testotomasyonuPage.ilkUrunElementi
                            .click();

        // urun isminde case sensitive olmadan "phone" bulundugunu test edin
        String expectedUrunIsimIcerik = ConfigReader.getProperty("toAranacakKelime");
        String actualUrunIsmi = testotomasyonuPage.ilkUrunSayfasindakiIsimElementi
                                                    .getText()
                                                    .toLowerCase();

        softAssert.assertTrue(actualUrunIsmi.contains(expectedUrunIsimIcerik));

        softAssert.assertAll(); // bu satir yazilmazsa, softAssert durumu raporlamaz
                                // testler PASSED olarak kabul edilir

        Driver.quitDriver();

    }

}
