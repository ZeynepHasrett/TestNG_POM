package tests.day13_testNGFramework;

import org.testng.annotations.Test;

public class C04_Priority {

    // uc farkli test method'u olusturun
    // testotomasyonu, wisequarter ve bestbuy sitelerine gidip
    // url'in bu kelimeleri icerdigini test edin
    // ve window'lari kapatin

    /*
        TestNG biz bir sey soylemedi isek
        test method'larini alfabetik(dogal) siraya uygun olarak calistirir

            1- biz test method'larina priority tanimlarsak
               priority degerlerini kucukten buyuge dogru calistirir

            2- bazi method'lar priority atayip, bazilarina atama yapmazsak
           atama yapilmayan method'larin priority degeri
           default deger olan 0 olur ve buna uygun sirada calisir

            3- ayni priority degerine sahip birden fazla method olursa
           esit priority degeri olanlar, kendi iclerinde alfabetik siraya uyarlar
     */

    @Test(priority = 1)
    public void testotomasyonuTest(){

    }

}
