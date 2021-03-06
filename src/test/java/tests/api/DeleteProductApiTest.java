package tests.api;

import api.POJOs.Product;
import api.Utils.ExtractObject;
import api.configuration.ApplicationEndPoints;
import api.http.method.DeleteMethod;
import api.http.method.GetMethod;
import api.http.method.PostMethod;
import api.response.assertions.AssertableResponse;
import api.test.base.ApiTestBase;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.apache.http.HttpStatus.*;

public class DeleteProductApiTest extends ApiTestBase {

    @Description("The goal of this test is to check that if we send an invalid product id"
            + "that we should get status code 200 and if we send get method to the specific product we should get status cod 404")
    @Test
    public static void positiveDeleteObjectTest() {
        Product product = new Product(0, "New product for delete ", "new", "666.00");
        AssertableResponse assertableResponse = new AssertableResponse();

        Response response = PostMethod.sendRequest(product, ApplicationEndPoints.PRODUCT_ENDPOINT);
        assertableResponse.hasStatusCode(response,SC_CREATED);

        String idOfCreatedObject = ExtractObject.extractObject(response, "id");

        response = DeleteMethod.sendRequest(ApplicationEndPoints.PRODUCT_ENDPOINT + idOfCreatedObject);
        assertableResponse.hasStatusCode(response,SC_OK);

        response = GetMethod.sendRequest(ApplicationEndPoints.PRODUCT_ENDPOINT + idOfCreatedObject);
        assertableResponse.hasStatusCode(response,SC_NOT_FOUND);


    }

}
