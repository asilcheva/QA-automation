package Lesson_7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DressesPage {
    @FindBy(className = "icon-th-list")
    private WebElement listView;
    @FindBy(id = "layered_id_attribute_group_3")
    private WebElement sortBySize;
    @FindBy(id = "selectProductSort")
    private WebElement selectProductList;
    @FindBy(xpath = "//*[@data-id-product=\"7\"]")
    private WebElement firstitem;
    @FindBy(xpath = "//*[@data-id-product=\"3\"]")
    private WebElement seconditem;
    @FindBy(xpath = "//*[@title = \"Continue shopping\"]")
    private WebElement continueShopping;
    @FindBy(xpath = "//*[@title = \"Proceed to checkout\"]")
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

    public WebElement getFirstitem() {
        return firstitem;
    }

    public WebElement getSeconditem() {
        return seconditem;
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
