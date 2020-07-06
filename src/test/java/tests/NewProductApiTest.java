package tests;

import api.POJOs.Product;
import api.configuration.ApplicationEndPoints;
import api.http.method.PostMethod;
import api.test.base.ApiTestBase;
import org.testng.annotations.Test;

public class NewProductApiTest extends ApiTestBase {

    @Test
    public void createProductTest() {
        Product product = new Product(0,"newApiObject","new api object","666.00");
        PostMethod.sendPost(product, ApplicationEndPoints.PRODUCT_ENDPOINT);



    }
}
