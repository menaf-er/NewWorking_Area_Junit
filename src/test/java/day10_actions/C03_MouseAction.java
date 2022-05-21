package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C03_MouseAction extends TestBase {
    // 1- Yeni bir class olusturalim: MouseActions1
    //2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
    //3- Cizili alan uzerinde sag click yapalim
    //4- Alert’te cikan yazinin “You selected a context menu” oldugunu
    //    test edelim.
    //5- Tamam diyerek alert’i kapatalim
    //6- Elemental Selenium linkine tiklayalim
    //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

    @Test
    public void test01(){
        driver.get("https://the-internet.herokuapp.com/context_menu");
        String ilksayfaWındowHandle = driver.getWindowHandle();

        Actions actions = new Actions(driver);
        WebElement cızgılıAlan = driver.findElement(By.id("hot-spot"));
        actions.contextClick(cızgılıAlan).perform();

        String expectedYazi = "You selected a context menu";
        String actualYazi = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedYazi,actualYazi);

        driver.switchTo().alert().accept();

        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();

        Set<String> tumWındowHandles = driver.getWindowHandles();
        String IkıncısayfaWındowHandle = "";
        for (String each :tumWındowHandles
             ) {
            if (!each.equals(ilksayfaWındowHandle)){
                IkıncısayfaWındowHandle = each;
            }

        }

        driver.switchTo().window(IkıncısayfaWındowHandle);

        String expectedNewPageYazi = "Elemental Selenium";
        WebElement actualNewPageTagı = driver.findElement(By.xpath("//h1"));
        String actualNewPageYazisi = actualNewPageTagı.getText();

        Assert.assertEquals(expectedNewPageYazi,actualNewPageYazisi);

    }
}
