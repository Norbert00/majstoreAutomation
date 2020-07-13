package tests.api;

import api.POJOs.Product;
import api.Utils.ExtractObject;
import api.configuration.ApplicationEndPoints;
import api.http.method.GetMethod;
import api.http.method.PostMethod;
import api.response.assertions.AssertableResponse;
import api.test.base.ApiTestBase;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.apache.http.HttpStatus.SC_CREATED;

public class NewProductApiTest extends ApiTestBase {

    @Description("The goal of this test is to check that if we send an valid object to valid endpoint"
            + "that we should get status code 201 and and valid id of the object.")
    @Test
    public void createProductTest() {
        Product product = new Product(0,"gsonExtracted ","new","666.00");
        AssertableResponse assertableResponse = new AssertableResponse();

        Response response = PostMethod.sendRequest(product,ApplicationEndPoints.PRODUCT_ENDPOINT);
        assertableResponse.hasStatusCode(response,SC_CREATED);

        String id = ExtractObject.extractObject(response,"id");

        response = GetMethod.sendRequest(ApplicationEndPoints.PRODUCT_ENDPOINT + id);

        String createdId = ExtractObject.extractObject(response,"id");

        Assert.assertEquals(id,createdId);


    }
}
