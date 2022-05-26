package day_11_FakerName_FileExist;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_FileUpload extends TestBase {

//Tests packagenin altina bir class oluşturun : C05_UploadFile
    //https://the-internet.herokuapp.com/upload adresine gidelim
    //chooseFile butonuna basalim
    //Yuklemek istediginiz dosyayi secelim.
    /*
        bu islemi selnium ile yapma imkanimiz yok cunku web tabanli bir uygulama degil
        bu durumda sendKeys() imdadimiza yetisir
        eger chooseFile butonuna var olan bir dosyanin dosya yolunu yollarsaniz
        secme islemi otomatik olarak yapilmis olacaktir.
         */
    // 1.adim cjhoose file butonunu locate edelim
    // 2.adim yuklenecek dosyanin dosya yolunu olusturalim
    //   biz masaustundeki text.txt dosyasini yukleyelim
    // 3. adim sendKeys ile dosya yolunu, secme butonuna yollayalim
    //Upload butonuna basalim.
    //“File Uploaded!” textinin goruntulendigini test edelim.

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/upload");
       WebElement dosyaSecButonu =  driver.findElement(By.id("file-upload"));

       String yuklenecekDosya = "C:\\Users\\OKAN YAMAN\\Downloads\\dummy.txt";

       dosyaSecButonu.sendKeys(yuklenecekDosya);

       driver.findElement(By.id("file-submit")).click();

        WebElement enSonCıkanYaziElementi = driver.findElement(By.tagName("h3"));

        Assert.assertTrue(enSonCıkanYaziElementi.isDisplayed());
       Thread.sleep(3000);

    }

}
