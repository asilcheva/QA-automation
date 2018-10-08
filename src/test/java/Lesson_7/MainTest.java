package Lesson_7;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainTest {
    String userEmail = "test11@gb.ua";
    String userName = "galyna";
    String userSurname = "garanets";
    String userCompany = "QACompany";
    String userPass = "password";
    String userBDDay = "2";
    int userBDMonth = 2;
    String userBDYear = "2000";
    String userAddr = "Addr 1, ap.111";
    String userCity = "Kyiv";
    int userState = 3;
    String userStateName = "Arizona";
    String userPost = "11111";
    String userMobile = "0981111111";
    String expectedUser = userName + " " + userSurname;
    String expectedProductItemsQty = "2 Products";

    private WebDriver driver;
    private NavigationPage navigationPage;
    private RegistrationPage registrationPage;
    private CreateAnAccounPage createAnAccounPage;
    private DressesPage dressesPage;

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "C:\\server\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void mainTestMethod() {
        navigationPage = new NavigationPage(driver);
        navigationPage.openSignPage();
        createAnAccounPage = new CreateAnAccounPage(driver);
        createAnAccounPage.typeEmailAddress(userEmail);
        createAnAccounPage.submitCreateanAccountButton();
        navigationPage.openDresses();
        dressesPage = new DressesPage(driver);
        dressesPage.getListView().click();
        dressesPage.getSortBySize().click();
        dressesPage.sortByLowestPrice();
        dressesPage.getFirstitem().click();
        dressesPage.getContinueShopping().click();
        dressesPage.getSeconditem().click();
        dressesPage.getProceedToCheckout().click();
        CartPage cartPage = new CartPage(driver);
        String actualProductItemsQty = cartPage.getProductItemsQty();
        Assert.assertEquals(actualProductItemsQty, expectedProductItemsQty);
        double actualPriceOfFirstItem = cartPage.getTotalPriceOfItems();
        double expectedTotalPrice = cartPage.getTotsProductsPrice();
        Assert.assertTrue(actualPriceOfFirstItem == expectedTotalPrice);
        double expectedPriceWithDiscount = cartPage.getExpectedPriceWithDiscount();
        Assert.assertTrue(actualPriceOfFirstItem == expectedPriceWithDiscount);
        cartPage.moveToSignIn();
    }
}
