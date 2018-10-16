package Lesson_8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WomanCategoryPage {
    private WebDriver driver;

    public void init(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@title = 'Women']")
    private WebElement womanCategory;
    @FindBy(xpath = "(//*[@class = 'ui-slider-handle ui-state-default ui-corner-all'])[1]")
    private WebElement rightPoint;
    @FindBy(xpath = "(//*[@class = 'ui-slider-handle ui-state-default ui-corner-all'])[2]")
    private WebElement leftPoint;
    @FindBy(xpath = "(//*[@class = 'product-container']//a[@class = 'product-name' and contains(@title, 'Dress')])[1]")
    private WebElement itemWithNameDress;
    @FindBy(xpath = "(//span[text() = 'Reduced price!']/following::a[@class = 'button ajax_add_to_cart_button btn btn-default'])[1]")
    private WebElement itemWithDiscount;
    public void dragAndDrop() {
        Actions action = new Actions(driver);
        action.dragAndDropBy(rightPoint, 10,0).build().perform();
    }
    //Actions builder = new Actions(driver);
    // builder.dragAndDrop().build().perform();

}
