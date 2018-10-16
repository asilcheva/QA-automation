import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SeleniumExample {
    WebDriver driver;
    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver","C:\\server\\chromedriver.exe");
    driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
}
    @org.testng.annotations.Test(groups = "smoke")
    public void verifyProductPriceDisplayedInDemoSection()
    {
        String expectedPrice = "$27.00";
        InputIntoSearchField("Blowse");
        clickSubmit();
        switchToListView(By.className("icon-th-list"));
        switchToListView(By.xpath("//*[@title = 'View']"));
        String ActualPrice = getProductPrice("our_price_display").getText();
        Assert.assertEquals(expectedPrice, ActualPrice);
    }

    private WebElement getProductPrice(String our_price_display) {
        return driver.findElement(By.id(our_price_display));
    }

    private void switchToListView(By by) {
        driver.findElement(by).click();
    }

    private void clickSubmit() {
        WebElement submitButton = driver.findElement(By.name("submit_search"));
        submitButton.click();
    }

    private void InputIntoSearchField(String name) {
        WebElement searchForm = driver.findElement(By.id("search_query_top"));
        searchForm.sendKeys(name);
    }

    @Test
    public void verifyOrder()
    {
        driver.findElement(By.xpath("//b[text() = 'Cart']")).click();
        WebElement summary = driver.findElement(By.xpath("//*[text() = ' Summary']"));
        Assert.assertEquals("01. Summary", summary.getText());
        WebElement signin = driver.findElement(By.xpath("//*[text() = ' Sign in']"));
        Assert.assertEquals("02. Sign in", signin.getText());
        WebElement address = driver.findElement(By.xpath("//*[text() = ' Address']"));
        Assert.assertEquals("03. Address", address.getText());
        WebElement shipping = driver.findElement(By.xpath("//*[text() = ' Shipping']"));
        Assert.assertEquals("04. Shipping", shipping.getText());
        WebElement payments = driver.findElement(By.xpath("//*[text() = ' Payment']"));
        Assert.assertEquals("05. Payment", payments.getText());
        WebElement text = driver.findElement(By.xpath("//p[@class = 'alert alert-warning']"));
        Assert.assertEquals("Your shopping cart is empty.", text.getText());
        WebElement orderstep = driver.findElement(By.id("order_step"));
        List<WebElement> orderSteps = driver.findElements(By.xpath("//ul[@id = 'order_step']"));
        List<String> actualOrders = new ArrayList<String>();
        for (WebElement orderStep : orderSteps)
        {
            actualOrders.add(orderStep.getText());

        }
        List <String> expectedOrders = Arrays.asList("01. Summary", "02. Sign in", "03. Address", "04. Shipping", "05. Payment");
        Assert.assertTrue(expectedOrders.equals(actualOrders));

    }
    @After
    public void Close()
    {
        driver.close();
    }

}
