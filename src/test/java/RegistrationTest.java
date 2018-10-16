
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RegistrationTest {
    private  static  WebDriver driver;
    @BeforeMethod
    public void init()
    {
        System.setProperty("webdriver.chrome.driver","C:\\server\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    private void pressSignInButton()
    {
        WebElement signInButton = driver.findElement(By.xpath("//a[contains(text(), 'Sign in')]"));
        signInButton.click();
    }
    private void typeEmailAccount(String emailAddress)
    {
        WebElement emailAdddressField = driver.findElement(By.id("email_create"));
        emailAdddressField.sendKeys(emailAddress);
    }
    private void submitEmailAccountButton()
    {
        WebElement createAccountButton = driver.findElement(By.id("SubmitCreate"));
        createAccountButton.click();
    }
    private void selectSexTitle(String sexId)
    {
        String inputSexId = "id_gender1";
        if (sexId == "Mrs.")
        {inputSexId = "id_gender2";}
        WebElement sexIdSelected = driver.findElement(By.id(inputSexId));
        sexIdSelected.click();
    }
    private void typeFirstName(String firstName)
    {
        WebElement inputFirstName = driver.findElement(By.id("customer_firstname"));
        inputFirstName.clear();
        inputFirstName.sendKeys(firstName);
    }
    private void typeLastName (String lastName)
    {
        WebElement inputLastName = driver.findElement(By.id("customer_lastname"));
        inputLastName.clear();
        inputLastName.sendKeys(lastName);
    }
    private void typeEmailAddress(String emailAddress)
    {
        WebElement inputEmailAddress = driver.findElement(By.id("email"));
        inputEmailAddress.clear();
        inputEmailAddress.sendKeys(emailAddress);
    }
    private void typePassword(String password)
    {
        WebElement inputPassword = driver.findElement(By.id("passwd"));
        inputPassword.clear();
        inputPassword.sendKeys(password);
    }
    private void selectDay() {
        WebElement dayDropDown = driver.findElement(By.xpath("//*[@id='days']"));
        Select value = new Select(dayDropDown);
        value.selectByValue("15");
    }
    private void selectMonth() {
        WebElement monthDropDown = driver.findElement(By.xpath("//*[@id='months']"));
        Select value = new Select(monthDropDown);
        value.selectByValue("11");
    }
    private void selectYear() {
        WebElement yearDropDown = driver.findElement(By.xpath("//*[@id='years']"));
        Select value = new Select(yearDropDown);
        value.selectByValue("1992");
    }
    private void selectNewslLetterCheckBox()
    {
        WebElement newsLetterCheckBox = driver.findElement(By.id("newsletter"));
        newsLetterCheckBox.click();
    }
    private void typeFirstNameYA(String firstName)
    {
        WebElement inputFirstName = driver.findElement(By.id("customer_firstname"));
        inputFirstName.clear();
        inputFirstName.sendKeys(firstName);
    }
    private void typeLastNameYA (String lastName)
    {
        WebElement inputLastName = driver.findElement(By.id("customer_firstname"));
        inputLastName.clear();
        inputLastName.sendKeys(lastName);
    }
    private void typeCompany(String inputCompany)
    {
        WebElement company = driver.findElement(By.id("company"));
        company.clear();
        company.sendKeys(inputCompany);
    }
    private void typeAddress(String inputAddress)
    {
        WebElement address = driver.findElement(By.id("address1"));
        address.clear();
        address.sendKeys(inputAddress);
    }
    private void typeAddress2(String inputAddress2)
    {
        WebElement address2 = driver.findElement(By.id("address2"));
        address2.clear();;
        address2.sendKeys(inputAddress2);
    }
    private void typeCity(String inputCity)
    {
        WebElement city = driver.findElement(By.id("city"));
        city.clear();;
        city.sendKeys(inputCity);
    }
    private void selectState()
    {
        WebElement stateDropDown = driver.findElement(By.id("id_state"));
        Select value = new Select(stateDropDown);
        value.selectByValue("2");
    }
    private void typePostcode(String inputPostСode)
    {
        WebElement postCode = driver.findElement(By.id("postcode"));
        postCode.clear();
        postCode.sendKeys(inputPostСode);
    }
    private void selectCountry()
    {
        WebElement countryDropDown = driver.findElement(By.id("id_country"));
        Select value = new Select(countryDropDown);
        value.selectByValue("21");
    }
    private void typeMobilePhone(String inputMobilePhone)
    {
        WebElement mobilePhone = driver.findElement(By.id("phone_mobile"));
        mobilePhone.clear();
        mobilePhone.sendKeys(inputMobilePhone);
    }
    private void typeMyAddress(String inputMyAddress)
    {
        WebElement myAddress = driver.findElement(By.id("alias"));
        myAddress.clear();
        myAddress.sendKeys(inputMyAddress);
    }
    private void clickRegisterButton()
    {
        WebElement registerButton = driver.findElement(By.id("submitAccount"));
        registerButton.click();
    }
    private void checkRegistration(String expectedMassage)
    {
        String actualMassage = driver.findElement(By.xpath("//p[@class = 'info-account']")).getText();
        Assert.assertEquals(expectedMassage, actualMassage);
    }

    @Test
    public void testRegistration()
    {
        pressSignInButton();
        typeEmailAccount("annasilcheva@gmail.com");
        submitEmailAccountButton();
        selectSexTitle("Mr.");
        typeFirstName("Anna");
        typeLastName("Anna");
        typeEmailAddress("annasilcheva@gmail.com");
        typePassword("23456");
        selectDay();
        selectMonth();
        selectYear();
        selectNewslLetterCheckBox();
        typeFirstNameYA("A");
        typeLastNameYA("A");
        typeCompany("AA");
        typeAddress("aaa");
        typeAddress2("aaaaa");
        typeCity("city");
        selectState();
        typePostcode("00000");
        selectCountry();
        typeMobilePhone("45909");
        typeMyAddress("aaaasas");
        clickRegisterButton();
        checkRegistration("Welcome to your account. Here you can manage all of your personal information and orders.");
    }
}
