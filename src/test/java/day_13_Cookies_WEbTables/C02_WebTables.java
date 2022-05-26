package day_13_Cookies_WEbTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.awt.*;
import java.util.List;

public class C02_WebTables extends TestBase {
    @Test
    public void test01(){
        //● login( ) metodun oluşturun ve oturum açın.
        //● https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
        //          ○ Username : manager
        //          ○ Password : Manager1!

         login();
        //● table( ) metodu oluşturun
        //          ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        List<WebElement> sutunBaslıklarıSayisi = driver.findElements(By.xpath("//thead//tr[1]//th"));
        System.out.println("Sutun sayisi " + sutunBaslıklarıSayisi.size());

        //          ○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        WebElement tumBody = driver.findElement(By.xpath("//tbody"));
        System.out.println(tumBody.getText());

        // Tum body'i bir String olarak yazdirmak isterseniz
        // body webElementini locate edip, getText() method'u ile yazdirabilirsiniz


        //● printRows( ) metodu oluşturun //tr
        //          ○ table body’sinde bulunan toplam satir(row) sayısını bulun.

       List<WebElement> tumBodyList = (List<WebElement>) driver.findElements(By.xpath("//tbody//tr"));

        System.out.println("tum body list sayisi : " + tumBodyList.size());
        for (WebElement each:tumBodyList
        ) {
            System.out.println(each.getText());
        }

        //          ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.

                   List<WebElement> cellListesi = driver.findElements(By.xpath("//tbody//td"));

        for (WebElement each:cellListesi) {
            System.out.println(each.getText());
        }
//          ○ 4.satirdaki(row) elementleri konsolda yazdırın.

        List<WebElement> dorduncuSatirElemenleri = driver.findElements(By.xpath("//tbody//tr[4]//td"));

        for (WebElement each:dorduncuSatirElemenleri) {
            System.out.println("4. satırdaki elementler listesi : " + each.getText());
        }

        //          Email basligindaki tum elementleri(sutun) konsolda yazdırın.
        // once email basliginin kacinci sutunda oldugunu bulalim

            List<WebElement> baslıklar = driver.findElements(By.xpath("//thead//tr[1]//th"));
        int emailSutunNo=0;
        for (int i = 0; i < baslıklar.size() ; i++) {
            if (baslıklar.get(i).getText().equals("Email")){
                emailSutunNo = i;
            }

        }
            List<WebElement> emailTümElementleri = driver.findElements(By.xpath("//tbody//td["+(emailSutunNo+ 1) +"]"));

        for (WebElement each :emailTümElementleri) {
            System.out.println(each.getText());
        }


    }

    public void login() {
        driver.get("https://www.hotelmycamp.com/");

        driver.findElement(By.linkText("Log in")).click();

        WebElement username = driver.findElement(By.xpath("//input[@id='UserName']"));
        username.click();
        username.sendKeys("manager");

        WebElement password = driver.findElement(By.xpath("//input[@name=\"Password\"]"));
        password.click();
        password.sendKeys("Manager1!");

        driver.findElement(By.id("btnSubmit")).click();





    }
}
