package tests.day13_testNGFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class Q01_YoutubeAssertions {

    // 1) https://www.youtube.com adresine gidin
    // 2) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
    //      ○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
    //      ○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    //      ○ searchBoxTest => Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    //      ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin

    @Test(priority = 1)
    public void titleTest() {
        // https://www.youtube.com adresine gidin
        Driver.getDriver().get("https://www.youtube.com");

        // ○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
        String expectedTitle = "YouTube";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test(priority = 2)
    public void imageTest() {
        // ○ imageTest => YouTube resminin görüntülendiğini test edin (isDisplayed())
        WebElement youtubeResimElementi = Driver.driver.findElement(By.xpath("(//a[@id='logo'])[1]"));

        Assert.assertTrue(youtubeResimElementi.isDisplayed());
    }

    @Test(priority = 3)
    public void searchBoxTest() {
        // ○ searchBoxTest => Search Box'in erisilebilir oldugunu test edin (isEnabled())
        WebElement aramaButonu = Driver.getDriver().findElement(By.xpath("//*[@role='combobox']"));

        Assert.assertTrue(aramaButonu.isEnabled());
    }

    @Test(priority = 4)
    public void wrongTitleTest(){
        // ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        String unexpectedTitle = "youtube";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertNotEquals(actualTitle, unexpectedTitle);

        Driver.quitDriver();
    }

}
