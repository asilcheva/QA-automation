package Lesson_7;


import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.Config;

import java.util.Properties;

public class BaseTest {
    public WebDriver driver;
    private final Properties config = Config.loadProperties("config.properties");
    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser) {
        //System.setProperty("webdriver.chrome.driver", "C:\\server\\chromedriver.exe");
        if (browser.equals("chrome")) {
            ChromeDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            ChromeDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();}
        //driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");

    }
}
