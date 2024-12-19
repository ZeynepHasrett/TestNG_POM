package tests.day13_testNGFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.Driver;

public class C06_PageClassKullanimi {

    // 3 farkli test method'u olusturup asagidaki gorevleri yapin
    //      1- testotomasyonu ana sayfaya gidip url'in testotomasyonu icerdigini test edin
    //      2- phone icin arama yapip urun bulunabildigini test edin
    //      3- ilk urunu tiklayip urun isminde case sensitive olmadan phone bulundugunu test edin

    TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();

    @Test(groups = "smoke")
    public void anasayfaTesti() {
        // testotomasyonu ana sayfaya gidip
        Driver.getDriver().get("https://www.testotomasyonu.com");

        // url'in testotomasyonu icerdigini test edin
        String expectedUrlIcerik = "testotomasyonu";
        String actualUrlIcerik = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrlIcerik.contains(expectedUrlIcerik));

    }

    @Test(dependsOnMethods = "anasayfaTesti", groups = {"smoke", "regression"})
    public void phoneAramaTesti() {
        // phone icin arama yapip
        testotomasyonuPage.aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // urun bulunabildigini test edin
        String unexpectedAramaSonucu = "0 Products Found";
        String actualAramaSonucu = testotomasyonuPage.aramaSonucuElementi.getText();

        Assert.assertNotEquals(actualAramaSonucu, unexpectedAramaSonucu);

    }

    @Test(dependsOnMethods = "phoneAramaTesti", groups = {"smoke", "E2E"})
    public void ilkUrunIsimTesti() {
        // ilk urunu tiklayip
        testotomasyonuPage.ilkUrunElementi
                .click();

        // urun isminde case sensitive olmadan phone bulundugunu test edin
        String expectedIsimIcerik = "phone";
        String actualUrunIsmi = testotomasyonuPage.ilkUrunSayfasindakiIsimElementi
                                                  .getText()
                                                  .toLowerCase();

        Assert.assertTrue(actualUrunIsmi.contains(expectedIsimIcerik));

        Driver.quitDriver();

    }

}
