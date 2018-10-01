package PACKAGE_NAME;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CartTest {
    WebDriver driver;
    @Before
    public void mainPageLoad()
    {
        System.setProperty("webdriver.chrome.driver","D:\\Autotest\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void testrun()
    {
        typeSearch("Blouse");
        clicksearch();
        switchToListView();
        addToCart();
        clickProceedToCheckout();
        plusItemToCart();
        checkTotalProduct("$54.00");
        checkTotalShipping("$2.00");
        checkTotal("$56.00");
        checkTax("$0.00");
        checkTotalPrice("$56.00");
        deleteitemFromcart();
        checkEmptyCart("Your shopping cart is empty.");
    }

    private void typeSearch(String searchInput)
    {
        WebElement serachField = driver.findElement(By.id("search_query_top"));
        serachField.sendKeys(searchInput);
    }
    private void clicksearch()
    {
        WebElement searchButton = driver.findElement(By.xpath("//button[@name ='submit_search']"));
        searchButton.click();
    }
    private void switchToListView()
    {
        WebElement listView= driver.findElement(By.className("icon-th-list"));
        listView.click();
    }
    private void addToCart()
    {
        WebElement addToCartButton = driver.findElement(By.xpath("//a[contains(@title, 'Add to cart')]"));
        addToCartButton.click();
    }
    private void waitForelement()
    {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        new WebDriverWait(.
                until(ExpectedConditions.presenceOfElementLocated()));
    }
    private void clickProceedToCheckout()
    {
        WebElement proceedToCheckoutButton = driver.findElement(By.xpath("//a[contains(@title, 'Proceed to checkout')]"));
        proceedToCheckoutButton.click();
    }
    private void plusItemToCart() {
        WebElement plusItem = driver.findElement(By.xpath("//i[contains(@class, 'icon-plus')]"));
        plusItem.click();
    }
    private void checkTotalProduct(String expectedTotalProduct)
    {
        String actualTotalProduct = driver.findElement(By.id("total_product")).getText();
        Assert.assertEquals(expectedTotalProduct, actualTotalProduct);
    }
    private void checkTotalShipping(String expectedTotalShipping)
    {
        String actualTotalShipping = driver.findElement(By.id("total_shipping")).getText();
        Assert.assertEquals(expectedTotalShipping, actualTotalShipping);
    }
    private void checkTotal(String expectedTotal)
    {
        String actualTotal = driver.findElement(By.id("total_price_without_tax")).getText();
        Assert.assertEquals(expectedTotal, actualTotal);
    }
    private void checkTax(String expectedTotalTax)
    {
        String actualTotalTax = driver.findElement(By.id("total_tax")).getText();
        Assert.assertEquals(expectedTotalTax, actualTotalTax);
    }
    private void checkTotalPrice(String expectedTotalPrice)
    {
        String actualTotalPrice = driver.findElement(By.id("total_price")).getText();
        Assert.assertEquals(expectedTotalPrice, actualTotalPrice);
    }
    private void deleteitemFromcart()
    {
        WebElement deleteItemButton = driver.findElement(By.id("2_7_0_0"));
        deleteItemButton.click();
    }
    private void checkEmptyCart(String expectedAlert)
    {
        String actualAlert = driver.findElement(By.className("alert alert-warning")).getText();
        Assert.assertEquals(expectedAlert, actualAlert);
    }
}
