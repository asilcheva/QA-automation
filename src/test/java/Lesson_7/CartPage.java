package Lesson_7;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    @FindBy(id = "summary_products_quantity")
    private WebElement actualProductItemsQty;
    @FindBy(id = "product_price_7_34_0")
    private WebElement actualPriceOfFirstItem;
    @FindBy(id = "product_price_3_13_0")
    private WebElement actualPriceOfSecondItem;
    @FindBy(id = "total_price")
    private WebElement totalPrice;
    @FindBy(className = "old-price")
    private WebElement oldPrice;
    @FindBy(className = "price-percent-reduction small")
    private WebElement percent;
    @FindBy(className = "button btn btn-default standard-checkout button-medium")
    private WebElement proceedToCheckOut;

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getProductItemsQty() {
        return actualProductItemsQty.getText();
    }

    public double getTotalPriceOfItems() {
        double priceOfFirstItem = parsePrice(actualPriceOfFirstItem);
        double priceOfSecondItem = parsePrice(actualPriceOfSecondItem);
        return priceOfFirstItem + priceOfSecondItem;
    }

    private double parsePrice(WebElement item) {
        return Double.parseDouble(item.getText().substring(1));
    }

    public double getTotsProductsPrice() {
        return parsePrice(totalPrice);
    }

    public double getExpectedPriceWithDiscount() {
        double oldItemPrice = parsePrice(oldPrice);
        double discount = Double.parseDouble(percent.getText().substring(1, -1));
        return oldItemPrice * discount / 100;
    }

    public void moveToSignIn() {
        proceedToCheckOut.click();
    }
}
