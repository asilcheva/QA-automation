import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class newClass {
    private  static WebDriver driver;
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
        driver.findElement(By.id("search_query_top")).sendKeys("Blouse");
        driver.findElement(By.name("submit_search")).click();
        driver.findElement(By.className("icon-th-list"));
        driver.findElement(By.xpath("//*[@title ='Add to cart']")).click();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By
                        .xpath("//*[@title ='Proceed to checkout']"))).click();
}

    @Test
    public void selectValue() {
        WebElement dayDropDown = driver.findElement(By.xpath("(//*[@id='days']"));
        Select value = new Select(dayDropDown);
        value.selectByValue("2");
    }

}
