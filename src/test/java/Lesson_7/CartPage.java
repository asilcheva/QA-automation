package Lesson_7;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.math.BigDecimal;

public class CartPage {
    @FindBy(id = "summary_products_quantity")
    private WebElement actualProductItemsQty;
    @FindBy(xpath = "(//*[contains(@class, 'cart_item')]//*[contains(@class, 'cart_total')]//*[contains(@class, 'price')])[1]")
    private WebElement actualPriceOfFirstItem;
    @FindBy(xpath = "(//*[contains(@class, 'cart_item')]//*[contains(@class, 'cart_total')]//*[contains(@class, 'price')])[2]")
    private WebElement actualPriceOfSecondItem;

    public WebElement getFirstPriceWithDiscount() {
        return firstPriceWithDiscount;
    }

    @FindBy(id = "price special-price")
    private WebElement firstPriceWithDiscount;
    @FindBy(id = "total_product")
    private WebElement totalProducts;
    @FindBy(className = "old-price")
    private WebElement oldPrice;
    @FindBy(xpath = "//*[@class='price-percent-reduction small']")
    private WebElement percent;
    @FindBy(className = "button btn btn-default standard-checkout button-medium")
    private WebElement proceedToCheckOut;
    @FindBy(xpath = "//*[@class = 'address_firstname address_lastname']")
    private WebElement actualUserNameOnBillingAddressStep;
    @FindBy(className = "address_address1 address_address2")
    private WebElement actualAddressOnBillingAddressStep;
    @FindBy(className = "address_city address_state_name address_postcode")
    private WebElement actualCityStatePostCodeOnBillingAddressStep;
    @FindBy(className = "address_country_name")
    private WebElement actualCountry;
    @FindBy(className = "address_phone_mobile")
    private WebElement actualMobilePhone;
    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public WebElement getProceedToCheckOut() {
        return proceedToCheckOut;
    }
    public String getActualUserNameOnBillingAddressStep() {
        return actualUserNameOnBillingAddressStep.getText();
    }

    public String getActualAddressOnBillingAddressStep() {
        return actualAddressOnBillingAddressStep.getText();
    }

    public String getActualCityStatePostCodeOnBillingAddressStep() {
        return actualCityStatePostCodeOnBillingAddressStep.getText();
    }

    public String getActualCountry() {
        return actualCountry.getText();
    }

    public String getActualMobilePhone() {
        return actualMobilePhone.getText();
    }

    public WebElement getProductItemsQty() {
        return actualProductItemsQty;
    }

    public BigDecimal getTotalPriceOfItems() {
        BigDecimal priceOfFirstItem = parsePrice(actualPriceOfFirstItem);
        BigDecimal priceOfSecondItem = parsePrice(actualPriceOfSecondItem);
        return priceOfFirstItem.add(priceOfSecondItem);
    }

    public BigDecimal parsePrice(WebElement item) {
        return new BigDecimal(item.getText().substring(1));
    }

    public BigDecimal getTotsProductsPrice() {
        return parsePrice(totalProducts);
    }

    public BigDecimal getExpectedPriceWithDiscount() {
        BigDecimal oldItemPrice = parsePrice(oldPrice);
        BigDecimal discount = new BigDecimal(percent.getText().substring(1, -1));
        return oldItemPrice.multiply(discount).divide(new BigDecimal(100));
    }

}
