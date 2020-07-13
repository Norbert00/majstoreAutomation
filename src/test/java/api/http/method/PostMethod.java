package api.http.method;

import com.google.gson.Gson;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostMethod {
    @Step("Send POST request to {endPoint}")
    public static Response sendRequest(Object objectToSend, String endPoint) {
        Gson gson = new Gson();
        String json = gson.toJson(objectToSend);
        return
                given()
                        .contentType(ContentType.JSON)
                        .body(json)
                        .when()
                        .post(endPoint);
    }
}
