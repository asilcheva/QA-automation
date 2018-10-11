


import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.event.WindowEvent;

public class SeleniumExample {
    private WebDriver driver;
    @FindBy(xpath = "(//*[@class = 'ui-slider-handle ui-state-default ui-corner-all'])[1]")
    private WebElement rigthPoint;
    @FindBy(xpath = "//div[@class='layered_slider ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all']/a[2]")
    private WebElement leftPoint;
    @FindBy(xpath = "//*[@class = 'layered_slider ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all']")
    private WebElement slider;
    public SeleniumExample(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void calculation(int rigthPrice, int leftPrice){
    int sliderWidth = slider.getSize().getWidth();
    int widthPerOneDollar = (int)(sliderWidth/(53-16));
    int rigthOffset = (rigthPrice-16)*widthPerOneDollar;
    int leftOffset = (53-leftPrice)*widthPerOneDollar;
    Actions action = new Actions(driver);
    new WebDriverWait(driver, 10).until(ExpectedConditions. visibilityOf(rigthPoint));
    new WebDriverWait(driver, 10).until(ExpectedConditions. visibilityOf(leftPoint));
    action.dragAndDropBy(rigthPoint, rigthOffset, 0).build().perform();
    action.dragAndDropBy(leftPoint, - leftOffset, 0).build().perform();
    }

}
