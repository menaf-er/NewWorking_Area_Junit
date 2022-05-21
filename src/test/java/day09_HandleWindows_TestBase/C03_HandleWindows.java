package day09_HandleWindows_TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_HandleWindows {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    // amazon ana sayfaya git
    // url in amazon ıcerdıgını test et
    // yeni bir pencere acıp bestbuy anasayfaya git
    //title in Best Buy ıcerdıgını test edin
    //ilk sayfaya donup sayfada java aratalım
    // arama sonuclarının java icerdıgını test edelim
    // yeniden bestbuy ın acık oldugu sayfaya gıdelim
    //logonun gorundugunu test edelim

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.amazon.com");
        String IlkSayfaWindowHandleDegeri = driver.getWindowHandle();
        String actualURL = driver.getCurrentUrl();
        String expectedWord = "amazon";
        Assert.assertTrue(actualURL.contains(expectedWord));

        driver.switchTo().newWindow(WindowType.TAB); // yeni window gectık
        driver.get("https://www.bestbuy.com");
        String IkinciSayfaWindowHandleDegeri = driver.getWindowHandle();
        Thread.sleep(3000);
        String actualTitle = driver.getTitle();
        String expectedTİtle = " Best Buy";
        Assert.assertTrue(actualTitle.contains(expectedTİtle));

        driver.switchTo().window(IlkSayfaWindowHandleDegeri);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java" + Keys.ENTER);
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String sonucYazisi = sonucYaziElementi.getText();
        String arananKelime = "Java";
        Assert.assertTrue(sonucYazisi.contains(arananKelime));

        driver.switchTo().window(IkinciSayfaWindowHandleDegeri);
        WebElement logoElementi = driver.findElement(By.xpath("//div[@lang='en']//img[@alt='Best Buy Logo']"));
        Assert.assertTrue(logoElementi.isDisplayed());

    }

}