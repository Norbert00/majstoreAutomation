package tests;

import api.Utils.ExtractObject;
import api.configuration.ApplicationEndPoints;
import api.data.providers.DataForTests;
import api.http.method.GetMethod;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.apache.http.HttpStatus.SC_OK;

public class PositiveGetProductTest {

    @Test(dataProvider = "correctID", dataProviderClass = DataForTests.class)
    public void simpleGetProductTest(String productId, String name, String expectedProductName) {
        Response response = GetMethod.createResponse(ApplicationEndPoints.PRODUCT_ENDPOINT + productId);
        String productName = ExtractObject.extractObject(response, "name");

        Assert.assertEquals(response.statusCode(), SC_OK);
        Assert.assertEquals(productName, expectedProductName);

    }

}
