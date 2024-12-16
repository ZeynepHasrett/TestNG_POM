package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestotomasyonuPage {
    /*
        Page class2larinda locate yapabilmesi icin
        WeDriver objemizi bu class'a tanitmamiz gerekiyor

        Bu tanitma islemini yapmak icin constructor ici tercih edilmistir
        bu islemin sebebi,
        Test class'larindan page class'ina ulasmak icin
        obje olustruma yontemini kullanmamizdir
        Test class'inda page class'indan obje olusturmak icin
        constructor calistiginda constructor icine koydugumuz
        initElements() calisir ve page class'ina Webdriver objemizi tanitir

        Bir page class'i olusturdugumuzda
        ILK YAPILMASI GEREKEN ISLEM
        constructor'i gorunur hale getirip
        icersinde initElements() method'u ile WebDriver'i tanitmak olacaktir
     */

    @FindBy(id = "global-search")
    public WebElement aramaKutusu;

    @FindBy(className = "product-count-text")
    public WebElement aramaSonucuElementi;

    @FindBy(xpath = "(//*[@class='prod-img'])[1]")
    public WebElement ilkUrunElementi;

    @FindBy(xpath = "//div[@class=' heading-sm mb-4']")
    public WebElement ilkUrunSayfasindakiIsimElementi;

}
