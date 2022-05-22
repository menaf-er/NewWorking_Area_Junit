package day_12_Senkronizasyon;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C03_ extends TestBase {
    // 1. Bir class olusturun : EnableTest
    //2. Bir metod olusturun : isEnabled()
    //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    @Test
    public void test01() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");


        //4. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement enableKutusu = driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse(enableKutusu.isDisplayed());
        //5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin

        driver.findElement(By.xpath("//*[text()='Enable']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(enableKutusu));
        //6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebElement isEnableYaziElementi = driver.findElement(By.xpath("//*[text()=\"It's enabled!\"]"));
        Assert.assertTrue(isEnableYaziElementi.isDisplayed());
        //7. Textbox’in etkin oldugunu(enabled) dogrulayın.
       Assert.assertTrue(enableKutusu.isEnabled());
    }
}