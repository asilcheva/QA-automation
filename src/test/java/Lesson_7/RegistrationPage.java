package Lesson_7;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class RegistrationPage {
    private static Logger LOG = LogManager.getLogger(RegistrationPage.class);
    private WebDriver driver;
    @FindBy(id = "id_gender1")
    private WebElement gender1;
    @FindBy(id = "id_gender2")
    private WebElement gender2;
    @FindBy(id = "customer_firstname")
    private  WebElement firstname;
    @FindBy(id = "customer_lastname")
    private WebElement lastname;
    @FindBy(id ="email")
    private WebElement email;
    @FindBy(id = "passwd")
    private WebElement password;
    @FindBy(xpath = "//*[@id='days']")
    private WebElement dayDropDown;
    @FindBy(xpath = "//*[@id='months']")
    private WebElement monthDropDown;
    @FindBy(xpath = "//*[@id='years']")
    private WebElement yearDropDown;
    @FindBy(id = "newsletter")
    private WebElement newsLetterCheckBox;
    @FindBy(id = "firstname")
    private WebElement firstnameYA;
    @FindBy(id = "lastname")
    private WebElement lastnameYA;
    @FindBy(id = "company")
    private WebElement company;
    @FindBy(id = "address1")
    private WebElement address1;
    @FindBy(id = "address2")
    private WebElement address2;
    @FindBy(id = "city")
    private WebElement city;
    @FindBy(id = "id_state")
    private WebElement id_state;
    @FindBy(id = "postcode")
    private WebElement postcode;
    @FindBy(id = "id_country")
    private WebElement idCountry;
    @FindBy(id = "phone_mobile")
    private WebElement mobilePhone;
    @FindBy(id = "alias")
    private WebElement myAddress;
    @FindBy(id = "submitAccount")
    private WebElement registerButton;
    @FindBy(xpath = "//p[@class = 'info-account']")
    private WebElement actualMassage;
    @FindBy(xpath = "//div/ul/li/a[@title = 'Dresses' and contains(text(), 'Dresses')]")
    private WebElement dresses;

    public WebElement getDresses() {
        return dresses;
    }
   public RegistrationPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public WebElement getGender1() {
        return gender1;
    }
    public WebElement getGender2() {
        return gender2;
    }

    public WebElement getFirstname() {
        return firstname;
    }

    public WebElement getLastname() {
        return lastname;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getDayDropDown() {
        return dayDropDown;
    }

    public WebElement getMonthDropDown() {
        return monthDropDown;
    }

    public WebElement getYearDropDown() {
        return yearDropDown;
    }

    public WebElement getNewsLetterCheckBox() {
        return newsLetterCheckBox;
    }

    public WebElement getFirstnameYA() {
        return firstnameYA;
    }

    public WebElement getLastnameYA() {
        return lastnameYA;
    }

    public WebElement getCompany() {
        return company;
    }

    public WebElement getAddress1() {
        return address1;
    }

    public WebElement getAddress2() {
        return address2;
    }

    public WebElement getCity() {
        return city;
    }

    public WebElement getId_state() {
        return id_state;
    }

    public WebElement getPostcode() {
        return postcode;
    }

    public WebElement getIdCountry() {
        return idCountry;
    }

    public WebElement getMobilePhone() {
        return mobilePhone;
    }

    public WebElement getMyAddress() {
        return myAddress;
    }

    public WebElement getRegisterButton() {
        return registerButton;
    }

    public WebElement getActualMassage() {
        return actualMassage;
    }
    public void selectGender(String selectedGender) {
        if (selectedGender == getGender1().getText()) {
            getGender1().click();
        } else if (selectedGender == getGender2().getText()) {
            getGender2().click();
        }
    }
    public static void clearAndClick(WebElement webElement, String inputData) {
        LOG.info("click");
        webElement.clear();
        webElement.sendKeys(inputData);
    }
    public static void selectItemFromDropDown(WebElement webElement, String inputValue){
        Select value = new Select(webElement);
        value.selectByValue(inputValue);
    }

    /*

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
        WebElement inputFirstName = driver.findElement(By.id("firstname"));
        inputFirstName.clear();
        inputFirstName.sendKeys(firstName);
    }
    private void typeLastNameYA (String lastName)
    {
        WebElement inputLastName = driver.findElement(By.id("lastname"));
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
    */


}
