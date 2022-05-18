package Day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C04_DropDowmMenu {

    /*
    amazona gidip
    dropdowndan books secenegını secıp Java ile aratalım.
    Arama sonuclarının Java icerdiğini test edelim
     */
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
    public void test01() throws InterruptedException {
        driver.get("https://www.amazon.com");

        //1.adım

        WebElement dropDownMenu = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        //2. adım

        Select select = new Select(dropDownMenu); // parametre olarak bir önceki adımda locate ettiğimiz ddm ' yi girelim

        //3. adım

        select.selectByVisibleText("Books");
        //select.selectByVisibleText(); 3 tane opsiyon ile secim yapacagız.
        // select.selectByIndex();
       // select.selectByValue();

        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));

        aramaKutusu.sendKeys("Java" + Keys.ENTER);

        WebElement sonucYazisiElementi = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String sonucYazisi = sonucYazisiElementi.getText();
        String aranaKelime="Java";

        Assert.assertTrue(sonucYazisi.contains(aranaKelime));

        Thread.sleep(3000);


    }

}
