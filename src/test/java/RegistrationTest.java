import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RegistrationTest {
    WebDriver driver;
    @Before
    public void init()
    {
        System.setProperty("webdriver.chrome.driver","C:\\server\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void verifyValidationForm()
    {
            driver.findElement(By.xpath("//a[contains(text(), 'Sign in')]")).click();
            emailGenerate();
            driver.findElement(By.id("SubmitCreate")).click();
            driver.findElement(By.id("customer_firstname")).sendKeys("Anna");
            driver.findElement(By.id("customer_lastname")).sendKeys("Silcheva");
            driver.findElement(By.id("customer_lastname")).sendKeys("passwd");
            driver.findElement(By.id("address1")).sendKeys("address");
            driver.findElement(By.id("city")).sendKeys("city");
            driver.findElement(By.id("postcode")).sendKeys("123");
            driver.findElement(By.id("phone_mobile")).sendKeys("12345");
            driver.findElement(By.id("submitAccount")).click();
        String expected = new String("There are 3 errors");
        WebElement actual = driver.findElement(By.xpath("//div[@class = \"alert alert-danger\"]/p[text()]"));
        Assert.assertEquals(expected, actual.getText());
    }

    private void emailGenerate() {
        WebElement emailCreate = driver.findElement(By.id("email_create"));
        emailCreate.sendKeys("silcheva.anna@gmail.com");
    }
}
