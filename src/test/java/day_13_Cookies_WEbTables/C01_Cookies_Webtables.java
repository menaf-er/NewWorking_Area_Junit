package day_13_Cookies_WEbTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C01_Cookies_Webtables extends TestBase {

    @Test
    public void test01() {
        // 1- Amazon anasayfaya gidin


        //6- eklediginiz cookie’nin sayfaya eklendigini test edin
        //7- ismi skin olan cookie’yi silin ve silindigini test edin
        //8- tum cookie’leri silin ve silindigini test edin

        driver.get("https://www.amazon.com.");
        //2- tum cookie’leri listeleyin
        Set<Cookie> cookiesSet = driver.manage().getCookies();
        System.out.println(cookiesSet);

        int sayac = 1;
        for (Cookie each : cookiesSet
        ) {
            System.out.println(sayac + "inci cookie : " + each);
            System.out.println("cookie name : " + each.getName());
            System.out.println("cookie value : " + each.getValue());
            sayac++;
        }

        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int cookiesSayisi = cookiesSet.size();
        Assert.assertTrue(cookiesSayisi < 5);  // Cookies sayisi 5 den kucuk o yüzden testi kosturunca hata verir.

//4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin

        for (Cookie each : cookiesSet
        ) {
            if (each.getName().equals("i18n-prefs")) {
                Assert.assertEquals("USD", each.getValue());
            }

        }

        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan

        Cookie cookie = new Cookie("en sevdigim cookie ", "cikolatali");

        driver.manage().addCookie(cookie);
        sayac = 1;

        cookiesSet = driver.manage().getCookies();

        for (Cookie each : cookiesSet
        ) {
            System.out.println(sayac + "inci cookie : " + each);

            sayac++;

        }
    }
}