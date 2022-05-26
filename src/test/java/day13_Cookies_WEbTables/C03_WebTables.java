package day_13_Cookies_WEbTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_WebTables extends TestBase {

    @Test
    public void dinamikYazici(){
        // onceki class'daki adrese gidip
        // girisYap(login) method'unu kullanarak sayafaya giris yapin
        // input olarak verilen satir sayisi ve sutun sayisi'na sahip
        // cell'deki text'i yazdirin

        int satir = 4;
        int sutun = 5;

        girisYap();

        WebElement arananCell = driver.findElement(By.xpath("//tbody//tr["+satir+"]//td["+sutun+"]"));

        System.out.println(arananCell.getText());

    }

    public void girisYap() {
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
