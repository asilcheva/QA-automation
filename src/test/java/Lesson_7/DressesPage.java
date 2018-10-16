package Lesson_7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DressesPage {
    @FindBy(className = "icon-th-list")
    private WebElement listView;
    @FindBy(id = "layered_id_attribute_group_3")
    private WebElement sortBySize;
    @FindBy(id = "selectProductSort")
    private WebElement selectProductList;
    @FindBy(xpath = "//*[contains(@class, 'ajax_add_to_cart_button')]")
    private List<WebElement> items;
    @FindBy(xpath = "//div/div/span[@title = 'Continue shopping' and contains(@class, 'continue')]")
    private WebElement continueShopping;
    @FindBy(xpath = "//*[@id= 'layer_cart']//*[@title = 'Proceed to checkout']")
    private WebElement proceedToCheckout;

    public DressesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public WebElement getListView() {
        return listView;
    }

    public WebElement getSortBySize() {
        return sortBySize;
    }

    public Select getSelectProductList() {
        return new Select(selectProductList);
    }

    public List<WebElement> getItems() {
        return items;
    }

    public WebElement getContinueShopping() {
        return continueShopping;
    }

    public WebElement getProceedToCheckout() {
        return proceedToCheckout;
    }

    public void sortByLowestPrice() {
        getSelectProductList().selectByValue("price:asc");
    }
}
