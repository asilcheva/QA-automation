package model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class ContactUsPage {
    private WebDriver driver;
    @FindBy(id ="fileUpload")
    private WebElement attachFile;

    public ContactUsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void attachFile(){
        File file = new File("src\\main\\resources\\test.txt");
        attachFile.sendKeys(file.getAbsolutePath());
        attachFile.click();
    }

}
