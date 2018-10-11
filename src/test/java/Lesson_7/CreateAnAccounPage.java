package Lesson_7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAnAccounPage {
    @FindBy(id = "email_create")
    private WebElement emailAddress;
    @FindBy(id = "SubmitCreate")
    private WebElement createanAccountButton;
    public WebElement getEmailAddress() {
        return emailAddress;
    }

    public WebElement getCreateanAccountButton() {
        return createanAccountButton;
    }
    public CreateAnAccounPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
