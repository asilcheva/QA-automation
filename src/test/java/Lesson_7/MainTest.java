package Lesson_7;

import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Iterator;

public class MainTest {
    private static Logger LOG = LogManager.getLogger(MainTest.class);
    String userGender = "Mr.";
    String userFirstname = "galyna";
    String userLastName = "garanets";
    String userEmail = Math.random()+"222222222222@gmail.ua";
    String userPassword = "password";
    String userBDDay = "2";
    String userBDMonth = "2";
    String userBDYear = "2000";
    String userCompany = "QACompany";
    String userAddress = "Addr 1, ap.111";
    String userCity = "Kyiv";
    String userState = "3";
    String userPostcode = "11111";
    String userCountry = "21";
    String userMobilePhone= "0981111111";
    String userMyAddress = "Address";
    String expectedAlert = "Welcome to your account. Here you can manage all of your personal information and orders.";
    String expectedUser = userFirstname + " " + userLastName;
    String expectedProductItemsQty = "2 Products";


    private WebDriver driver;
    private NavigationPage navigationPage;
    private RegistrationPage registrationPage;
    private CreateAnAccounPage createAnAccounPage;
    private DressesPage dressesPage;

    public WebElement waitVisibility(WebElement webElement, long timeOutInSeconds){
        return new WebDriverWait(driver, timeOutInSeconds)
                .until(ExpectedConditions.visibilityOf(webElement));
    }
    public WebElement waitClickability(WebElement webElement, long timeOutInSeconds){
        return new WebDriverWait(driver, timeOutInSeconds)
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }
@Step
@Test
    public void mainTestMethodA() throws InterruptedException {
        navigationPage = new NavigationPage(driver);
        LOG.info("Opening signIn Page");
        navigationPage.openSignPage();
        createAnAccounPage = new CreateAnAccounPage(driver);
        createAnAccounPage.getEmailAddress().sendKeys(userEmail);
        createAnAccounPage.getCreateanAccountButton().click();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        waitVisibility(registrationPage.getGender1(), 20);
        registrationPage.selectGender(userGender);
        RegistrationPage.clearAndClick(registrationPage.getFirstname(), userFirstname);
        RegistrationPage.clearAndClick(registrationPage.getLastname(), userLastName);
        RegistrationPage.clearAndClick(registrationPage.getEmail(), userEmail);
        RegistrationPage.clearAndClick(registrationPage.getPassword(), userPassword);
        RegistrationPage.selectItemFromDropDown(registrationPage.getDayDropDown(), userBDDay);
        RegistrationPage.selectItemFromDropDown(registrationPage.getMonthDropDown(), userBDMonth);
        RegistrationPage.selectItemFromDropDown(registrationPage.getYearDropDown(), userBDYear);
        registrationPage.getNewsLetterCheckBox().click();
        RegistrationPage.clearAndClick(registrationPage.getFirstnameYA(), userFirstname);
        RegistrationPage.clearAndClick(registrationPage.getLastnameYA(), userLastName);
        RegistrationPage.clearAndClick(registrationPage.getCompany(), userCompany);
        RegistrationPage.clearAndClick(registrationPage.getAddress1(), userAddress);
        RegistrationPage.clearAndClick(registrationPage.getAddress2(), userAddress);
        RegistrationPage.clearAndClick(registrationPage.getCity(), userCity);
        RegistrationPage.selectItemFromDropDown(registrationPage.getId_state(), userState);
        RegistrationPage.clearAndClick(registrationPage.getPostcode(), userPostcode);
        RegistrationPage.selectItemFromDropDown(registrationPage.getIdCountry(), userCountry);
        RegistrationPage.clearAndClick(registrationPage.getMobilePhone(), userMobilePhone);
        RegistrationPage.clearAndClick(registrationPage.getMyAddress(), userMyAddress);
        registrationPage.getRegisterButton().click();
        String actualMassage = waitVisibility(registrationPage.getActualMassage(), 10).getText();
        Assert.assertEquals(expectedAlert, actualMassage);
        waitVisibility(registrationPage.getDresses(), 10).click();
        dressesPage = new DressesPage(driver);
        waitVisibility(dressesPage.getListView(), 20).click();
        dressesPage.getSortBySize().click();
        dressesPage.sortByLowestPrice();
        Thread.sleep(5000);
        Iterator<WebElement> it = dressesPage.getItems().iterator();
        WebElement item = it.next();
        item.click();
        waitClickability(dressesPage.getContinueShopping(), 20).click();
        item = it.next();
        waitClickability(item, 20).click();
        waitVisibility(dressesPage.getProceedToCheckout(), 20).click();
        CartPage cartPage = new CartPage(driver);
        String actualProductItemsQty = waitVisibility(cartPage.getProductItemsQty(), 20).getText();
        Assert.assertEquals(actualProductItemsQty, expectedProductItemsQty);
        BigDecimal actualPriceOfTotalItem = cartPage.getTotalPriceOfItems();
        BigDecimal expectedTotalPrice = cartPage.getTotsProductsPrice();
        Assert.assertTrue(actualPriceOfTotalItem.equals(expectedTotalPrice));
        BigDecimal expectedPriceWithDiscount = cartPage.getExpectedPriceWithDiscount();
        BigDecimal actualPriceWithDiscount = cartPage.parsePrice(cartPage.getFirstPriceWithDiscount());
        Assert.assertTrue(actualPriceWithDiscount.equals(expectedPriceWithDiscount));
        //cartPage.getProceedToCheckOut().click();
    }
    public void getScreenShots() throws IOException{
        File screenshot = ((TakesScreenshot)driver).
                getScreenshotAs(OutputType.FILE);
        String path = "./target/screenshots/"+screenshot.getName();
        FileUtils.copyFile(screenshot, new File(path));
    }
    @AfterMethod(alwaysRun = true)
    public void closeDown(ITestResult testResult) throws IOException{
        driver.manage().deleteAllCookies();
        if (testResult.getStatus() == ITestResult.FAILURE)
        {getScreenShots();}
        driver.close();
    }
}
