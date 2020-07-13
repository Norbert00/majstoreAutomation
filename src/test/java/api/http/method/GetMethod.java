package api.http.method;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.when;

public class GetMethod {

    @Step("Send GET request to {endPoint}")
    public static Response sendRequest(String endPoint) {
        return
                when()
                        .get(endPoint)
                        .then().extract().response();
    }

}
