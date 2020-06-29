package tests;


import gui.pom.NavigationBar;
import gui.pom.ProductPage;
import gui.pom.ShopPage;
import gui.test.base.TestBase;
import gui.utils.testng.listeners.RetryAnalyzer;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class AddProductToCartTest extends TestBase {


    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("The goal of this test is to check that the user is able to add the chosen product to the cart, " +
            "after adding the product, the view cart button should be displayed.")
    public static void asUserTryToAddProductToCart() {
        NavigationBar navigationBar = new NavigationBar();
        navigationBar.clickOnChosenLinkInTopNavMenu("Shop");
        ShopPage shopPage = new ShopPage();
        shopPage.clickOnChosenProductInShop(shopPage.getListOfAllProductsInShop(), "Shirt 2");
        ProductPage productPage = new ProductPage();
        productPage.userChooseTheSizeOfProductAndClickAddToCartButton("Medium");
        productPage.assertThatAfterAddingProductToTheCartButtonViewCartIsDisplayedOnProductPage();


    }

}
