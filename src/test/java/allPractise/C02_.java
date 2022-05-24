package allPractise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_ extends TestBase {

    //    go to url :http://demo.automationtesting.in/Alerts.html
//    click  "Alert with OK" and click 'click the button to display an alert box:'
//    accept Alert(I am an alert box!) and print alert on console
//    click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
//    cancel Alert  (Press a Button !)
//    click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
//    and then sendKeys 'TechProEducation' (Please enter your name)
//    finally print on console this message "Hello TechproEducation How are you today"
    @Test
    public void test01() throws InterruptedException {
        driver.get("http://demo.automationtesting.in/Alerts.html");
        driver.findElement(By.xpath("//a[normalize-space()='Alert with OK']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'click the button to display an')]")).click();

        System.out.println( "alertin üzerindeki yazi : "  + driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        driver.findElement(By.xpath("//a[contains(text(),'Alert with OK & Cancel')]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'click the button to display a confirm box')]")).click();
        driver.switchTo().alert().dismiss();

        driver.findElement(By.xpath("//a[contains(text(),'Alert with Textbox')]")).click();
        WebElement textBoxColumn = driver.findElement(By.xpath("//button[contains(text(),'click the button to demonstrate the prompt box')]"));
        textBoxColumn.click();

        driver.switchTo().alert().sendKeys("gokhan");

        Thread.sleep(3000);

        driver.switchTo().alert().accept();

        String expectedMessage = "Hello gokhan How are you today";
        String actualMessage = driver.findElement(By.xpath("//p[@id='demo1']")).getText();

        Assert.assertEquals(expectedMessage, actualMessage);




    }
}
