package Day09_HandleWindows_TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_ {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown(){
        //driver.quit();
    }
    @Test
    public void test01(){

        // amazon anasayfaya git
        // nutella ıcın arama yaptır.
        // ilk urunun resmını farklı bır tab olarak acın
        // farklı bır tabda acılan urunun title yazdırın

        driver.get("https://www.amazon.com");
        System.out.println("sayfanın window habdle degeri : " + driver.getWindowHandle());

       // CDwindow-C40165B48DFB9CD28EB2E877C45D5FB0
        // bu kod acılan sayfanın unıque has kodu degeridir.
        //Selenıum sayflar arası gecıslerde bu wındow hash degerini kullanır.

        // driver.switchTo().window("CDwindow-C40165B48DFB9CD28EB2E877C45D5FB0"); bu sekilde sayfalar arasına gecıs yapabiliriz.
        String ilkSayfaHandleDegeri = driver.getWindowHandle();

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nutella" + Keys.ENTER);
        WebElement ilkUrunResmi = driver.findElement(By.xpath("//img[@alt='Nutella Chocolate Hazelnut Spread, Perfect Topping for Easter Treats, 26.5 oz (Packaging May Vary)']"));
        // ilkUrunResmi.click(); boylw yaparsak aynı sayfada acar.

        driver.switchTo().newWindow(WindowType.TAB); // bu komutu olutusturudugumzda driver otomatık olarak new TAB a gecer.
                                                    // yenı tab da görevi gerceklesirmek ıcın adımları bastan yapmamız gerek.
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nutella" + Keys.ENTER);
        WebElement ilkUrunResmiNewDriver = driver.findElement(By.xpath("//img[@alt='Nutella Chocolate Hazelnut Spread, Perfect Topping for Easter Treats, 26.5 oz (Packaging May Vary)']"));
        // System.out.println("driver in URL : " +driver.getCurrentUrl());
        ilkUrunResmiNewDriver.click();

        WebElement uruntitleELementi = driver.findElement(By.xpath("//span[@class='a-size-large product-title-word-break']"));
        System.out.println(uruntitleELementi.getText());

        //ilk sayfaya gecip URL i yazdır.

        driver.switchTo().window(ilkSayfaHandleDegeri);
        System.out.println("driverin guncel URL si : " + driver.getCurrentUrl());
    }
}
