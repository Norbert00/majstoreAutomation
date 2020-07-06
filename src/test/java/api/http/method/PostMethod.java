package api.http.method;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_CREATED;

public class PostMethod {


    public static void sendPost(Object objectToSend, String expectedEndPoint) {
         given()
                .contentType("application/json")
                .body(objectToSend)
                .when()
                .post(expectedEndPoint)
                .then()
                .assertThat()
                .statusCode(SC_CREATED);


    }


}
