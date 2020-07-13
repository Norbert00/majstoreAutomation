package api.http.method;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PutMethod {

    public static Response sendRequest(Object objectToSend, String endPoint) {
        return
                given()
                        .contentType(ContentType.JSON)
                        .body(objectToSend)
                        .put(endPoint);
    }
}
