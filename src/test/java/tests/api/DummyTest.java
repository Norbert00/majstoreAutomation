package tests.api;

import api.configuration.ApplicationEndPoints;
import api.test.base.ApiTestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DummyTest extends ApiTestBase {

    @Test
    public static void someTest() {


        Response response =
                given()
                .spec(ApiTestBase.getSpec())
                .get(ApplicationEndPoints.PRODUCT_ENDPOINT + "83");
        System.out.println(response.statusCode());
    }

}
