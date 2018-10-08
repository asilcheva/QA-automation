package Lesson_7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RegistrationPage {
    private WebDriver driver;
    public RegistrationPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "inputSexId")
    private WebElement sexId;


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


}
