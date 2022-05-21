package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_KeyboardActions extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.amazon.com");

        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));

        Actions actions = new Actions(driver);

        actions.click(aramaKutusu).perform();
        actions.keyDown(Keys.SHIFT).perform(); // Shift e bastık
        actions.sendKeys("n").perform();// Shifte basılı halde iken "n" ye bastık
        Thread.sleep(3000);
        actions.keyUp(Keys.SHIFT).sendKeys("u").
                sendKeys("t").
                sendKeys("e").
                sendKeys("l").
                sendKeys("l").
                sendKeys("a").
                sendKeys(Keys.ENTER).perform();


    }
}

