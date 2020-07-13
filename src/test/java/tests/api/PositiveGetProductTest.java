package tests.api;

import api.configuration.ApplicationEndPoints;
import api.data.providers.DataForTests;
import api.http.method.GetMethod;
import api.response.assertions.AssertableResponse;
import api.test.base.ApiTestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.apache.http.HttpStatus.SC_OK;

public class PositiveGetProductTest extends ApiTestBase {

    @Test(dataProvider = "correctID", dataProviderClass = DataForTests.class)
    public void simpleGetProductTest(String productId, String name, String expectedProductName) {

        Response response = GetMethod.sendRequest(ApplicationEndPoints.PRODUCT_ENDPOINT + productId);

        AssertableResponse assertableResponse = new AssertableResponse();
        assertableResponse.hasStatusCode(response,SC_OK);
        assertableResponse.fieldInJson(response,name,expectedProductName);
    }

}
