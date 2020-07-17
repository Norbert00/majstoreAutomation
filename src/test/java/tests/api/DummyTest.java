package tests.api;

import api.configuration.ApplicationEndPoints;
import api.test.base.ApiTestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DummyTest extends ApiTestBase {

    @Test
    public static void checkTheConnect() {

        Response respons =
                given()
                        .param("consumer_key","ck_2207e2f752afc6f44caa7db2054b211b085cad73")
                        .param("consumer_secret","cs_ee64f2f162c55911cc4daee3edb8b41723843039")
                 .contentType("application/json")
                .when()
                .get("https://majfejkstore.club/wp-json/wc/v3/products/83");
        System.out.println(respons.statusCode());


    }



    @Test
    public static void someTest() {


        Response response =
                given()
                .spec(ApiTestBase.getSpec())
                .get(ApplicationEndPoints.PRODUCT_ENDPOINT + "83");
        System.out.println(response.statusCode());
    }

}
