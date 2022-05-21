package day08_HandleAllerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Alerts {
    //● Bir metod olusturun: acceptAlert
    //      ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
    //      “You successfully clicked an alert” oldugunu test edin.


    static WebDriver driver;

    @BeforeClass
    public static void setUP(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }
@AfterClass
    public static void tearDown(){
        driver.close();


}
@Test
    public void accepAlert(){
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();

        driver.switchTo().alert().accept();

        String exceptedResultWriting = "You successfully clicked an alert";
        WebElement actualResultWritingElement = driver.findElement(By.xpath("//*[text()='You successfully clicked an alert']"));

        String uzerindekiYaziyiBulma = actualResultWritingElement.getText();

        Assert.assertEquals(exceptedResultWriting, uzerindekiYaziyiBulma);

}
    //● Bir metod olusturun: dismissAlert
    //      ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    //      “successfuly” icermedigini test edin.

@Test
    public void dismissAlert(){
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        driver.switchTo().alert().dismiss();

        String expectedResult = "successfuly ";

                WebElement ExceptedYazisiElementi = driver.findElement(By.xpath("//*[text()='You clicked: Cancel']"));

                String actualResul = ExceptedYazisiElementi.getText();

                Assert.assertFalse(actualResul.contains(expectedResult));

    //● Bir metod olusturun: sendKeysAlert
    //      ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin,
    //      OK butonuna tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.


}
@Test
    public void sendKeysAlert(){

        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys("gokhan");
        driver.switchTo().alert().accept();

        WebElement sonucYazisiElementi = driver.findElement(By.xpath("//p[@id='result']"));

        String beklenenYazi = sonucYazisiElementi.getText();

        String girilenİsim = "gokhan";

        Assert.assertTrue(beklenenYazi.contains(girilenİsim));

}
}
