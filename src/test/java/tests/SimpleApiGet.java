package tests;

import api.configuration.ApplicationEndPoints;
import api.test.base.ApiTestBase;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;

public class SimpleApiGet extends ApiTestBase {


    @Test
    public void simpleGetTest() {
        Response response =
                when()
                .get(ApplicationEndPoints.PRODUCT_ENDPOINT +"227");
        Assertions.assertEquals(200, response.statusCode());
    }

}
