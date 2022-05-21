package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C06_KeyboardActions extends TestBase {

    @Test
    public void test01(){
        driver.get("https://www.facebook.com/");
        driver.findElement(By.xpath("//*[text()='Yeni Hesap Oluştur']")).click();

        WebElement isimKutusu = driver.findElement(By.xpath("//input[@class='inputtext _58mg _5dba _2ph-']"));

        Actions actions = new Actions(driver);

        actions.click(isimKutusu).
                sendKeys("gokhan").
                sendKeys(Keys.TAB).
                sendKeys("yaman").
                sendKeys(Keys.TAB).
                sendKeys("xyz@gmail.com").
                sendKeys(Keys.TAB).
                sendKeys("xyz@gmail.com").
                sendKeys(Keys.TAB).
                sendKeys("123456789").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys("10").
                sendKeys(Keys.TAB).sendKeys("05").
                sendKeys(Keys.TAB).sendKeys("1995").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ARROW_DOWN).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                perform();




    }
}
