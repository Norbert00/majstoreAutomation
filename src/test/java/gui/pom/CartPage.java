package gui.pom;

import gui.driver.DriverManager;
import gui.wait.WaitForElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.DecimalFormat;

import static org.testng.Assert.assertTrue;

public class CartPage extends BasePage {

    private final double PERCENTAGE_OF_CUT_PRICE = 20.00;
    private final String COUPON_CODE = "2020";

    @FindBy(id = "coupon_code")
    private WebElement couponCodeInputField;

    @FindBy(xpath = "//*[@name='apply_coupon']")
    private WebElement applyCouponButton;

    @FindBy(xpath = "//tr[@class='cart-subtotal']//td//span")
    private WebElement subtotalAmount;

    @FindBy(xpath = "//tr[@class='order-total']//td//span")
    private WebElement totalAmount;

    public String getCOUPON_CODE() {
        return COUPON_CODE;
    }

    public double getPERCENTAGE_OF_CUT_PRICE() {
        return PERCENTAGE_OF_CUT_PRICE;
    }

    public WebElement getCouponCodeInputField() {
        return couponCodeInputField;
    }

    public WebElement getApplyCouponButton() {
        return applyCouponButton;
    }

    public WebElement getTotalAmount() {
        return totalAmount;
    }

    public WebElement getSubtotalAmount() {
        return subtotalAmount;
    }

    private double formatAmount(double amount) {
        return Double.parseDouble(new DecimalFormat("##.##").format(amount));
    }

    private double calculateTotalAmountAfterCutPrice(WebElement subtotalAmount, double levelOfCutPrice) {
        double total = splitAmount(subtotalAmount.getText());
        double amountAfterCutPrice = formatAmount(total - (total * (levelOfCutPrice / 100)));
        return amountAfterCutPrice;
    }

    private double splitAmount(String amountToSplit) {
        double priceAsNumber;
        String[] split = amountToSplit.split(" ");
        String part1 = split[0].replace(",", ".");
        priceAsNumber = Double.parseDouble(part1);
        return priceAsNumber;
    }

    private void userEnterCouponCode(String couponCode, WebElement couponCodeInputField) {
        couponCodeInputField.click();
        couponCodeInputField.sendKeys(couponCode);
    }

    private void clickApplyCouponButton(WebElement applyCouponButton) {
        WaitForElement.waitUntilElementToByClickable(applyCouponButton);
        applyCouponButton.click();
    }

    @Step("User enter coupon code {couponCode} and click on the button apply coupon {applyCouponButton}")
    public void userEnterCouponCodeAndClickApplyButton(String couponCode, WebElement couponCodeInputField, WebElement applyCouponButton) {
        userEnterCouponCode(couponCode, couponCodeInputField);
        clickApplyCouponButton(applyCouponButton);
    }

    @Step("Assert that the coupon code has been applied and the total price has changed")
    public void assertTheAmountOfProductAfterCutPrice(WebElement subtotalAmount, double percentageCutPrice) {
        double amountAfterCutPrice = calculateTotalAmountAfterCutPrice(subtotalAmount, percentageCutPrice);
        WebElement totalAfterApplyingCoupon = DriverManager.getWebDriver().findElement(By.xpath("//tr[@class='order-total']//span"));
        WaitForElement.waitWithStalenessOfException(totalAfterApplyingCoupon);
        WebElement elementNewPage = DriverManager.getWebDriver().findElement(By.xpath("//tr[@class='order-total']//span"));

        double total = splitAmount(elementNewPage.getText());
        boolean flag;
        assertTrue(flag = (amountAfterCutPrice == total) ? true : false);
    }
}
