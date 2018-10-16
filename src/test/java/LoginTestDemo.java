import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginTestDemo {
    WebDriver driver;
    public void init() {
        System.setProperty("webdriver.chrome.driver","C:\\server\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
    }
    @Test
  public void actionDemo() {
      WebElement productItem = driver.findElement(By.xpath("//*[@titleFaded Short Sleeve T-shirts]"));
      Actions actions = new Actions(driver);
      actions.moveToElement(productItem).build().perform();
      WebElement addToCartButton = driver.findElement(By.xpath(""));
      addToCartButton.click();

  }


}
