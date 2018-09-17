import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumExample {
    @Test
    public void initBrowser()
    {
        System.setProperty("webdriver.chrome.driver","C:\\server\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com.ua/");
        driver.close();
    }
}
