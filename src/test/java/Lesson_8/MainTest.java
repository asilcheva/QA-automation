package Lesson_8;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.sql.DriverManager;

public class MainTest {
    private WebDriver driver;
    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser){
        if (browser.equals("chrome")){
            ChromeDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if (browser.equals("firefox")) {
            ChromeDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            }
            }
   @Test
    public void test(){


    }

}
