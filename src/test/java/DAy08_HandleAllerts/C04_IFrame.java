package DAy08_HandleAllerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_IFrame {
    //  ● Bir class olusturun: IframeTest
    //   ● https://the-internet.herokuapp.com/iframe adresine gidin.

    //   ● Bir metod olusturun: iframeTest
    //      ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin
    //      ve  konsolda    yazdirin.

    //      ○ Text Box’a “Merhaba Dunya!” yazin.
    // textbox'i dogru olarak locate etmemize ragmen driver bulamadi
    // bunun uzerine HTML kodlari inceleyince
    // textbox'in aslinda bir IFrame icerisinde oldugunu gorduk
    // bu durumda once iframe'i locate edip
    // switchTo() ile o iFrame'e gecmeliyiz

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @After
    public void teardown() {
        driver.close();
    }

    @Test
    public void test01(){
        driver.get("https://the-internet.herokuapp.com/iframe");

        WebElement baslıkElementi = driver.findElement(By.xpath("//h3"));

        Assert.assertTrue(baslıkElementi.isEnabled()); // baslıgın erişilebilir oldugunu test ettik

        System.out.println(baslıkElementi.getText());
        //texboxun iframe ıcınde oldugunu gorduk
        // bu durumda once iframe i locate edip
        //switch to ile o iframe e gecmeliyiz.

        WebElement İFrameElementi = driver.findElement(By.id("mce_0_ifr"));

        driver.switchTo().frame(İFrameElementi);

        WebElement texKutusu = driver.findElement(By.xpath("//body[@id='tinymce']"));

        texKutusu.clear();

        texKutusu.sendKeys("merhaba dünya");

        // link yazi elementin dogru yazmamıza ragmen yazdırmadı bulamadı.
        // yukarıda switch to yaparak Iframe in içine gırmıtık
        // sımdı de dısarı cıkmamız gerek

        driver.switchTo().defaultContent();// İframe den dısarı cıktık
        WebElement linkYazisiElementi = driver.findElement(By.linkText("Elemental Selenium"));

        Assert.assertTrue(linkYazisiElementi.isDisplayed());

    }




}
