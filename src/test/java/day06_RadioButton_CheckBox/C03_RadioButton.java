package day06_RadioButton_CheckBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_RadioButton {
    WebDriver driver;

    /*
    1. Bir class oluşturun : RadioButtonTest
2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
-https://www.facebook.com adresine gidin
-Cookies’i kabul edin
-“Create an Account” button’una basin
-“radio buttons” elementlerini locate edin
-Secili degilse cinsiyet butonundan size uygun olani secin
     */

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @After
    public void teardown() {
        driver.close();

    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.facebook.com");

        //driver.findElement(By.xpath("//*[text()='Yeni Hesap Oluştur']")).click();
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        WebElement femaleButton = driver.findElement(By.xpath("//*[text()='Kadın']"));
        WebElement maleButton = driver.findElement(By.xpath("//*[text()='Erkek']"));
        WebElement customButton = driver.findElement(By.xpath("//*[text()='Özel']"));

        if (!maleButton.isSelected()) {
            maleButton.click();
            Thread.sleep(3000);

        }
        femaleButton.click();
        Thread.sleep(3000);

        customButton.click();
        Thread.sleep(3000);
    }


}

