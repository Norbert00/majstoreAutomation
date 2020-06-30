package tests;

import gui.pom.CartPage;
import gui.pom.NavigationBar;
import gui.pom.ProductPage;
import gui.pom.ShopPage;
import gui.test.base.TestBase;
import gui.utils.testng.listeners.RetryAnalyzer;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class CutPriceTest extends TestBase {



    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("The goal of this test is to checked after as user applied correct coupon code, the price has changed.")
    public void asUserAppliedCorrectCouponThePriceHasChangedTest() {
        NavigationBar navigationBar = new NavigationBar();
        navigationBar.clickOnChosenLinkInTopNavMenu(navigationBar.getSHOP());
        ShopPage shopPage = new ShopPage();
        shopPage.clickOnChosenProductInShop(shopPage.getListOfAllProductsInShop(), shopPage.getNAME_OF_THE_PRODUCT());
        ProductPage productPage = new ProductPage();
        productPage.userChooseTheSizeOfProductAndClickAddToCartButton(productPage.getSize());
        productPage.assertThatAfterAddingProductToTheCartButtonViewCartIsDisplayedOnProductPage();
        productPage.clickOnViewCartButton(productPage.getViewCartButton());
        CartPage cartPage = new CartPage();
        cartPage.userEnterCouponCodeAndClickApplyButton(cartPage.getCOUPON_CODE() ,cartPage.getCouponCodeInputField(), cartPage.getApplyCouponButton());
        cartPage.assertTheAmountOfProductAfterCutPrice(cartPage.getSubtotalAmount(), cartPage.getPERCENTAGE_OF_CUT_PRICE());

    }

}
