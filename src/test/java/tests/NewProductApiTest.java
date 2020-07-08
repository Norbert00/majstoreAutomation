package tests;

import api.POJOs.Product;
import api.configuration.ApplicationEndPoints;
import api.test.base.ApiTestBase;
import com.google.gson.Gson;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class NewProductApiTest extends ApiTestBase {

    @Test
    public void createProductTest() {
        Product product = new Product(0,"gsonExtracted ","new","666.00");
        Gson gson = new Gson();
        String json = gson.toJson(product);
        Response response =
        given()
               .body(json)
               .when()
               .post(ApplicationEndPoints.PRODUCT_ENDPOINT);





    }
}
