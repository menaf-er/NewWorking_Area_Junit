package day_11_FakerName_FileExist;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Faker extends TestBase {

    @Test
    public void test01(){
        driver.get("https://www.facebook.com/");
        driver.findElement(By.xpath("//*[text()='Yeni Hesap Oluştur']")).click();

        WebElement isimKutusu = driver.findElement(By.xpath("//input[@class='inputtext _58mg _5dba _2ph-']"));

        Actions actions = new Actions(driver);
        Faker faker = new Faker();

        String fakeMail = faker.internet().emailAddress();// asagıda kayıt olurken 2 defa aynı mail istiyor o yuzden biz de her defasında değişmeyen standart bir mail olusturduk.
        actions.click(isimKutusu).
                sendKeys(faker.name().firstName()).
                sendKeys(Keys.TAB).
                sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).
                sendKeys(fakeMail).
                sendKeys(Keys.TAB).
                sendKeys(fakeMail).
                sendKeys(Keys.TAB).
                sendKeys(faker.internet().password()).
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
