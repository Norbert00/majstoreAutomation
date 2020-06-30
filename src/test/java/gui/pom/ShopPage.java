package gui.pom;


import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShopPage extends BasePage {

    private final String NAME_OF_THE_PRODUCT = "Shirt 2";

    @FindBy(xpath = "//*[@class='woocommerce-loop-product__title']")
    private List<WebElement> listOfAllProductsInShop;

    public List<WebElement> getListOfAllProductsInShop() {
        return listOfAllProductsInShop;
    }

    public String getNAME_OF_THE_PRODUCT() {
        return NAME_OF_THE_PRODUCT;
    }


    @Step("User choose the product {nameOfProduct}")
    public void clickOnChosenProductInShop(List<WebElement> listOfProducts, String nameOfProduct) {
        for (WebElement product : listOfProducts) {
            if (product.getText().equals(nameOfProduct)) {
                product.click();
                break;
            }
            System.out.println("Checked the method clickOnChosenProductInShop in ShopPage class");
        }
    }


}
