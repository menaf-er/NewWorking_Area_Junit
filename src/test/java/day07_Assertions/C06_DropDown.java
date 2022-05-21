package day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C06_DropDown {
    // ● https://the-internet.herokuapp.com/dropdown adresine gidin.
    //  1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    //  2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    //  3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    //  4.Tüm dropdown options'i yazdırın
    //  5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True ,
    //  degilse False yazdırın.
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void test01(){
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement option1 = driver.findElement(By.xpath("//select[@id='dropdown']"));

        Select select = new Select(option1);

        select.selectByValue("1");

        System.out.println("select 01 :" + select.getFirstSelectedOption().getText());
////---------------------------------------------------------------\\\\
        select.selectByValue("2");

        System.out.println("select 02 :" + select.getFirstSelectedOption().getText());

////---------------------------------------------------------------\\\\

        select.selectByVisibleText("Option 1");

        System.out.println("get visible text ile : " + select.getFirstSelectedOption().getText());

////---------------------------------------------------------------\\\\

        List<WebElement> tumOpsiyonlar = select.getOptions();

        for (WebElement each :tumOpsiyonlar
             ) {
            System.out.println(each.getText());
        }

        int dropDown = tumOpsiyonlar.size();

        if (dropDown==4){
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }


}
