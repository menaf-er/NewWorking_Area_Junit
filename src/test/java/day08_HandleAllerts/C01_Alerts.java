package day08_HandleAllerts;

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

public class C01_Alerts {
    WebDriver driver;

@Before
    public void setUp(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

}
@After
    public void teardown(){
    driver.close();
}

@Test
    public void test01(){

    //herhangi bir web sitesine gidince veya bir websitesinde herhang
     // bir islem yaptıgımızda ortaya cıkan uyarılara alert diyoruz.
    // eger bir alert inpect yapılabiliyorsa, o alert otomasyon ile kullanılabilir,
    // bu tur alertlere HTML alert denir bunlar için extra bir islem yapmaya gerek yoktur.
    //tum webelementler gibi locate edip istediğimiz islemleri yapabiliriz.

    //js alert ler locate edilemez.
    // Selenium da JS alertler için ozel bir yontem gelistirilmistir.
    driver.get("https://the-internet.herokuapp.com/javascript_alerts");

    driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
    driver.switchTo().alert().accept();

    // result kısmında you succecc... yazısı cıktıgını gor.

    String expectedWriting = "You successfully clicked an alert";

    WebElement actualWriting = driver.findElement(By.xpath("//p[@id='result']"));

    String actualResultWriting = actualWriting.getText();

    Assert.assertEquals(expectedWriting,actualResultWriting);

}
}
