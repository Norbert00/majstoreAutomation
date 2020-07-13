package api.http.method;

import com.google.gson.Gson;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class PostMethod {

    private Response response;

    public static Response sendPost(Object objectToSend, String expectedEndPoint) {

        Gson gson = new Gson();
        String json = gson.toJson(objectToSend);
        return given()
                .contentType("application/json")
                .body(json)
                .when()
                .post(expectedEndPoint);

    }


}
