package api.http.method;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_CREATED;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PostMethod {

    private Response response;

    public void sendPost(Object objectToSend, String expectedEndPoint) {
         given()
                .contentType("application/json")
                .body(objectToSend)
                .when()
                .post(expectedEndPoint)
                .then().log().all().statusCode(SC_CREATED);

    }


}
