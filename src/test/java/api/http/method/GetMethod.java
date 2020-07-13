package api.http.method;

import io.restassured.response.Response;

import static io.restassured.RestAssured.when;

public class GetMethod {

    public static Response sendRequest(String endPoint) {
        return
                when()
                        .get(endPoint)
                        .then().extract().response();
    }

}
