package tests.day14_testNGFramework_assertions;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C06_SingletonPattern {

    /*
        Page Object Model (POM)'i dizayn edenler
        Driver class'indan getDriver() yerine farkli kullanimlarin onune gecmek icin

        bir class'dan obje olusturulabilmesini ENGELLEMEK icin
        kullanilabilecek farkli yontemler var
        POM'i hazirlayanlar bu alternatifler icerisinde
        Singleton Pattern'i tercih etmisler

        Singleton Pattern
        obje olusturmayi engellemek icin
        Constructor'i gorunur yapip
        kimsenin erisememesi icin private isaretliyoruz
     */

    @Test
    public void test01() {

        // testotomasyon anasayfaya gidin
        // Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        //Driver driver = new Driver();
        //driver.driver.get(ConfigReader.getProperty("toUrl"));

        //Driver.driver.get(ConfigReader.getProperty("toUrl"));

        Driver.quitDriver();

    }

}
