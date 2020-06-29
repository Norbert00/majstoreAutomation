package gui.pom;


import gui.generic.assertions.AssertWebElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductPage extends BasePage {

    @FindBy(id = "size")
    private WebElement sizeOptionList;
    @FindBy(xpath = "//*[@type='submit']")
    private WebElement addToCartButton;
    @FindBy(xpath = "//*[@class='button wc-forward']")
    private WebElement viewCartButton;


    public WebElement getSizeOptionList(){
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

    @Step("User click choose the size {sizeOfProduct} of the product and click on add to cart button")
    public void userChooseTheSizeOfProductAndClickAddToCartButton(String sizeOfProduct) {
        choseTheSizeOfProduct(getSizeOptionList(),sizeOfProduct);
        clickOnAddToCartButton();
    }

    @Step("User should see view the cart button")
    public void assertThatAfterAddingProductToTheCartButtonViewCartIsDisplayedOnProductPage() {
        isDisplayViewCartButton(getViewCartButton());
    }




}
