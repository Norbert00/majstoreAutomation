package gui.pom;


import gui.generic.assertions.AssertWebElement;
import gui.wait.WaitForElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductPage extends BasePage {

    private final String SIZE = "Medium";

    @FindBy(id = "size")
    private WebElement sizeOptionList;

    @FindBy(xpath = "//*[@type='submit']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//*[@class='button wc-forward']")
    private WebElement viewCartButton;

    public String getSize() {
        return SIZE;
    }

    public WebElement getSizeOptionList() {
        return sizeOptionList;
    }

    public WebElement getAddToCartButton() {
        return addToCartButton;
    }

    public WebElement getViewCartButton() {
        return viewCartButton;
    }


    private void choseTheSizeOfProduct(WebElement listOfSizes, String chosenSize) {
        Select sizeSelect = new Select(listOfSizes);
        sizeSelect.selectByValue(chosenSize);
    }

    private void clickOnAddToCartButton() {
        getAddToCartButton().click();
    }


    private void isDisplayViewCartButton(WebElement button) {
        AssertWebElement assertWebElement = new AssertWebElement(button);
        assertWebElement.isDisplayed();
    }

    @Step("User clicked on View cart button ")
    public void clickOnViewCartButton(WebElement button) {
        WaitForElement.waitUntilElementToByClickable(button);
        button.click();
    }

    @Step("User chooses the size {sizeOfProduct} of the product and click on add to cart button")
    public void userChooseTheSizeOfProductAndClickAddToCartButton(String sizeOfProduct) {
        choseTheSizeOfProduct(getSizeOptionList(), sizeOfProduct);
        clickOnAddToCartButton();
    }

    @Step("User should see view the cart button")
    public void assertThatAfterAddingProductToTheCartButtonViewCartIsDisplayedOnProductPage() {
        isDisplayViewCartButton(getViewCartButton());
    }


}
