package api.http.method;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DeleteMethod {

    @Step("Send DELETE request to {endPoint}")
    public static Response sendRequest(String endPoint) {
        return
                given()
                        .queryParam("force", "true")
                        .when()
                        .delete(endPoint);
    }
}
