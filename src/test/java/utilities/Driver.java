package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {

    private Driver(){
        // Singleton pattern ile bu class'dan obje olusturulmasini engellemek icin
        // Constructor'i gorunur yapip kimsenin erisememesi icin private isaretliyoruz
    }

    public static WebDriver driver;

    public static WebDriver getDriver(){

        /*
            Bu method'u her kullandigimizda nem ChromeDriver(); calisinca
            yeni bir browser aciliyor

            Biz sadece ilk defa bu method'u kullandigimizda
            nem ChromeDriver(); calissin
            sonraki kullanimlarda calismasin istiyoruz
         */

        /*
            Driver'in her seferinde chrome olmasi yerine
            configuration.properties'de browser key'inin degeri ne ise
            browser'in dinamik olarak o deger olmasini istiyoruz

            browser'in dinamik olmasi icin
            once configuration.properties'deki browser degerini alalim
            ve bir switch ile hangi browser istenmis ise
            ona ait bir WebDriver olusturalim
         */

        if (driver == null) {
            driver = new ChromeDriver();

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        return driver;
    }

    public static void quitDriver(){
        driver.quit(); // acik olan browser'lari kapatir
        driver = null; // bu class'daki driver objesine null degeri atayarak
                       // yeni browser acilmasina imkan tanir
    }

}
