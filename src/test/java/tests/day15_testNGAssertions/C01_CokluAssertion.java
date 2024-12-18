package tests.day15_testNGAssertions;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_CokluAssertion {

    @Test
    public void ilkUrunIsimTesti() {
        // testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // url'in testotomasyonu icerdigini test edin
        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));

        // phone icin arama yapin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();

        testotomasyonuPage.aramaKutusu
                            .sendKeys(ConfigReader.getProperty("toAranacakKelime") + Keys.ENTER);

        // urun bulunabildigini test edin
        String unexpectedSonuc = ConfigReader.getProperty("toUnexpectedSonuc");
        String actualSonuc = testotomasyonuPage.aramaSonucuElementi.getText();

        Assert.assertNotEquals(actualSonuc, unexpectedSonuc);

        // ilk urunu tiklayip
        testotomasyonuPage.ilkUrunElementi
                .click();

        // urun isminde case sensitive olmadan "phone" bulundugunu test edin
        String expectedIsimIcerik= ConfigReader.getProperty("toAranacakKelime");
        String actualUrunIsmi = testotomasyonuPage.ilkUrunSayfasindakiIsimElementi
                                                    .getText()
                                                    .toLowerCase();

        Assert.assertTrue(actualUrunIsmi.contains(expectedIsimIcerik));

        Driver.quitDriver();

    }

}
