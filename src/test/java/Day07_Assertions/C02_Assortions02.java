package Day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Assortions02 {
    // 2) https://www.bestbuy.com/ Adresine gidin
    //    farkli test method’lari olusturarak asagidaki testleri yapin
    //      ○ Sayfa URL’inin https://www.bestbuy.com/‘a esit oldugunu test edin
    //      ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    //      ○ logoTest => BestBuy logosunun görüntülendigini test edin
    //      ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

    static WebDriver driver;

    @BeforeClass
    public static void setUo(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.bestbuy.com/");

    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public void test01(){
        String arananURL = "https://www.bestbuy.com/";
        String actualURL= driver.getCurrentUrl();

        Assert.assertEquals(arananURL,actualURL);
    }

    @Test
    public void test02(){
        String pageTitle = " Rest";
        String actualTitle = driver.getTitle();

        Assert.assertFalse(actualTitle.contains(pageTitle));
    }

    @Test
    public void test03(){
        WebElement logoElementi = driver.findElement(By.xpath("(//img[@class='logo'])[1]"));

        Assert.assertTrue(logoElementi.isDisplayed());

    }
    @Test
    public void test04(){
        WebElement francaisElement = driver.findElement(By.xpath("//*[text()='Français']"));

        Assert.assertTrue(francaisElement.isDisplayed());

    }
}
