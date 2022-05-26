package day_11_FakerName_FileExist;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import utilities.TestBase;

public class C02_Actions extends TestBase {

    @Test
    public void test01(){

        driver.get("https://html.com/tags/iframe/");



            // calısıyor ama noırmalde calısmazsa actions ile obje olusuturup 3 adımda ısı halletmemziz lazım.
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        // once ıframi locate etmem lazım
        WebElement Iframe = driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(Iframe);
        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']")).click();

        WebElement youTubeYazisi = driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));

        Assert.assertTrue(youTubeYazisi.isDisplayed());
    }
}
