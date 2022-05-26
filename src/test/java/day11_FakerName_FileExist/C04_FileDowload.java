package day_11_FakerName_FileExist;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDowload extends TestBase {

    //Tests packagenin altina bir class oluşturun : C05_UploadFile
    //https://the-internet.herokuapp.com/upload adresine gidelim
    //chooseFile butonuna basalim
    //Yuklemek istediginiz dosyayi secelim.

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");
        WebElement dummyLinki= driver.findElement(By.linkText("dummy.txt"));
        dummyLinki.click();
        Thread.sleep(3000);


        String indirilenYer = "C:\\Users\\OKAN YAMAN\\Downloads";

        Assert.assertTrue(Files.exists(Paths.get(indirilenYer)));



    }

}
