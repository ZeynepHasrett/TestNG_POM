package tests.day13_testNGFramework;

public class C05_DependsOnMethods {

    // 3 farkli test method'u olusturup asagidaki gorevleri yapin
    //  1- testotomasyonu ana sayfaya gidip url'in testotomasyonu icerdigini test edin
    //  2- phone icin arama yapip urun bulunabildigini test edin
    //  3- ilk urunu tiklayip urun isminde case sensitive olmadan phone bulundugunu test edin

        /*
            dependsOnMethods = "anasayfaTesti"

            1- siralama icin degil, method'lari birbirine baglamak icin kullanilir
               eger anasayfa testi calisip PASSED olmazsa
               phoneAramaTestini calistirmanin hicbir anlami olmayacaksa
               dependsOnMethods = "anasayfaTesti" yazabiliriz

            2- her test method'u bagimsiz olarak calistirilabilir
               ancak dependsOnMethods ile calismasi baska class'in calismasina baglanan bir method
               bagimsiz olarak calistirilmak istendiginde
               ONCE bagli oldugu method'u calistirir,
               O method calisip PASSED olursa, kendisi de calisir

               ANCAAAKKK bu sadece 2 method icin gecerlidir
               eger 3 method bu ornekte oldugu gibi birbirine bagli ise
               3.method'u bagimsiz calistirmak istedigimizde tum method'lar calismaz
               No tests were found ==> calistirilacak Test bulunamadi der

            3- Her ne kadar siralama icin kullanilmasa da
               dependsOnmethod kullanmis olan bir method'a sira geldiginde
               once bagli oldugu method'un calismasini saglayacagi icin
               otomatik olarak bir siralama da yapmis olur
         */

}
