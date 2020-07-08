package tests;

import api.Utils.ExtractObject;
import api.configuration.ApplicationEndPoints;
import api.data.providers.DataForTests;
import api.http.method.GetMethod;
import api.test.base.ApiTestBase;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.apache.http.HttpStatus.*;

public class NegativeGetProductTest extends ApiTestBase {



    @Test(dataProvider = "incorrectIds", dataProviderClass = DataForTests.class)
    public void simpleGetTest(String productId, String expectedMessage) {

        Response response = GetMethod.createResponse(ApplicationEndPoints.PRODUCT_ENDPOINT+ productId);

        String message = ExtractObject.extractObject(response,"message");

        Assert.assertEquals(response.statusCode(),SC_NOT_FOUND);
        Assert.assertEquals(message, expectedMessage);
    }






}
