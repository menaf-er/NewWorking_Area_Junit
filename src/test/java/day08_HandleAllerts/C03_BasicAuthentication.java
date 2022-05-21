package day08_HandleAllerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static day08_HandleAllerts.C02_Alerts.driver;

public class C03_BasicAuthentication {

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @After
    public void teardown(){
        //driver.close();


    }

    @Test
    public void test01(){
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

    }
}

