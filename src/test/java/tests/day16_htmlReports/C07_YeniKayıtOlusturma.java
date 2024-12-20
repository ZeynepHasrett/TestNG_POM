package tests.day16_htmlReports;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.EditorPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C07_YeniKayıtOlusturma {

    // Farkli datalarla tabloya 5 kayit ekleyip, asagidaki testi yapin.
    // kullanici https://editor.datatables.net/ adresine gider
    // new butonuna basar
    // tum bilgileri girer
    // Create tusuna basar
    // kullanici ilk isim ile arama yapar
    // isim bolumunde isminin oldugunu dogrular

    // First name:
    // Last name:
    // Position:
    // Office:
    // Extension
    // Start date:
    // Salary:

    @DataProvider
    public static Object[][] kisiBilgileriProvider() {

        String[][] kisiBilgileriArr = { {"Hamza","Kavas","Qa","Istanbul","junior","2025-05-12","50000"},
                                        {"Cansu","Altinsoy","Qa","Istanbul","junior","2025-06-12","20000"},
                                        {"Anil","Ozden","Qa","Izmir","Medior","2025-05-12","40000"},
                                        {"Ceren","Kilic","Qa","Ankara","Medior","2025-05-12","25000"}
                                      };

        return kisiBilgileriArr;
    }

    @Test(dataProvider = "kisiBilgileriProvider")
    public void kayitTesti(String firstName, String lastName, String position,
                           String office, String extension, String startDate, String salary) {

        // kullanici https://editor.datatables.net/ adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("editorUrl"));

        // new butonuna basar
        EditorPage editorPage = new EditorPage();

        editorPage.newButonu
                    .click();

        // tum bilgileri girer
        Actions actions = new Actions(Driver.getDriver());
        ReusableMethods.bekle(1);

        actions.sendKeys(firstName)
                .sendKeys(Keys.TAB)
                .sendKeys(lastName)
                .sendKeys(Keys.TAB)
                .sendKeys(position)
                .sendKeys(Keys.TAB)
                .sendKeys(office)
                .sendKeys(Keys.TAB)
                .sendKeys(extension)
                .sendKeys(Keys.TAB)
                .sendKeys(startDate)
                .sendKeys(Keys.TAB)
                .sendKeys(salary).perform();

        // Create tusuna basar
        editorPage.createButonu
                .click();

        // kullanici ilk isim ile arama yapar
        editorPage.searchKutusu.sendKeys(firstName);

        // isim bolumunde isminin oldugunu dogrular
        String expectedIsim = firstName + " " + lastName;
        String actualIlkIsimYazisi = editorPage.ilkIsimElementi.getText();

        Assert.assertEquals(actualIlkIsimYazisi, expectedIsim);

        Driver.quitDriver();

    }

}
