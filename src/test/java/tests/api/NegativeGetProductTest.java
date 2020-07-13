package tests.api;

import api.configuration.ApplicationEndPoints;
import api.data.providers.DataForTests;
import api.http.method.GetMethod;
import api.response.assertions.AssertableResponse;
import api.test.base.ApiTestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.apache.http.HttpStatus.SC_NOT_FOUND;

public class NegativeGetProductTest extends ApiTestBase {


    @Test(dataProvider = "incorrectIds", dataProviderClass = DataForTests.class)
    public void simpleGetTest(String productId, String fieldInJson, String expectedMessage) {
        Response response = GetMethod.sendRequest(ApplicationEndPoints.PRODUCT_ENDPOINT + productId);

        AssertableResponse assertableResponse = new AssertableResponse();
        assertableResponse.hasStatusCode(response,SC_NOT_FOUND);
        assertableResponse.fieldInJson(response,fieldInJson,expectedMessage);
    }


}
