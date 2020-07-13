package api.http.method;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DeleteMethod {


    public static Response sendRequest(String endPoint) {
        return
                given()
                        .queryParam("force", "true")
                        .when()
                        .delete(endPoint);
    }
}
