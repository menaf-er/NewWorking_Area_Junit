package Day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C05_DropDownOptions {
    /*
    Amazon anasayfaya gidip dropdown menuden books u secelim
    sectigimiz optioni yazdıralım
    Dropdown daki opsiyonlarının toplam sayısının 28 oldugunu test edin.
     */
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
   @After
    public void tearDOwn(){
        driver.close();
   }

   @Test
    public void test01(){
        driver.get("https://www.amazon.com");

       WebElement dropDownMenu = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

       Select select = new Select(dropDownMenu);

       select.selectByVisibleText("Books");

       select.getFirstSelectedOption(); // bir dropdown ile calısıyorken son optiona ulasmak ıstersek bu methodu kullan.
                                        // bu method WEbelement dondurur.

       System.out.println("getFirst sonuc : " + select.getFirstSelectedOption().getText());

       System.out.println("get options sonuc : " + select.getOptions());

       System.out.println("get all selections sonuc :  " + select.getAllSelectedOptions());

       System.out.println("get wrapped sonuc :  " + select.getWrappedElement());

       List<WebElement> optionList = select.getOptions();
       int actualOptionSayisi = optionList.size();
       int expectedOptionSayisi =28;

       Assert.assertEquals(expectedOptionSayisi, actualOptionSayisi);

   }
}

