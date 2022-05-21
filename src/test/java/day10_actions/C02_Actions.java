package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class C02_Actions extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.amazon.com");


        // 3 adımda bu işi yapacagız.
        // once Actions obje olusutur. Parametresi driver olacak.
        // WebELement olarak locate et
        // sonra action. diyerek aksiyonu tanıma ve perform eklemeyi unutma.
        Actions actions = new Actions(driver);

        WebElement signInAccountMenusu = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));

        actions.moveToElement(signInAccountMenusu).perform();

        driver.findElement(By.xpath("//*[text()='Create a List']")).click();

        Thread.sleep(3000);
    }
}
