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

public class C01_Assertions {
    /*
    amazon ana sayfaya gidin
    3 farklı test methodu olusturarak asagısaki görevleri yapın
    1- URL in amazon içerdiğini test edin
    2- Title in facebook içermediğini test edin
    3- sol üst kösede amazonun logosunun görundugunu test edin.
     */
    static WebDriver driver;
    @BeforeClass

    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.amazon.com"); // buraya koyarak tüm test caselerde calıstırmıs olduk

    }

    @AfterClass
    public static void teardown(){
        driver.close();
    }

    @Test
    public void test01(){

        String arananKelime = "amazon";
        String actualURL = driver.getCurrentUrl();

        Assert.assertTrue(actualURL.contains(arananKelime));

    }

    @Test
    public void test02(){
        String istenmeyenKelime = "facebook";
        String actualTitle = driver.getTitle();

        Assert.assertFalse(actualTitle.contains(istenmeyenKelime));
    }
    @Test
    public void test03(){
        WebElement logo = driver.findElement(By.xpath("//a[@id='nav-logo-sprites']"));

        Assert.assertTrue(logo.isDisplayed());

    }
}
