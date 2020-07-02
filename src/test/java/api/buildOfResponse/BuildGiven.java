package api.buildOfResponse;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BuildGiven {

    private Response response;

    public BuildGiven() {
    }

    public Response getResponse(String basicUri, String authUser, String authPass) {

        Response response = given()
                .port(80)
                .auth()
                .oauth(authUser, authPass, "","")

                .when()
                .get(basicUri);


        return response;
    }

}
