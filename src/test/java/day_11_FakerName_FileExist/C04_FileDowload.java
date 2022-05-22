package day_11_FakerName_FileExist;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C04_FileDowload extends TestBase {

    //Tests packagenin altina bir class oluşturun : C05_UploadFile
    //https://the-internet.herokuapp.com/upload adresine gidelim
    //chooseFile butonuna basalim
    //Yuklemek istediginiz dosyayi secelim.

    @Test
    public void test01(){
        driver.get("https://the-internet.herokuapp.com/upload");
        driver.findElement(By.id("file-upload")).click();

    }

}
