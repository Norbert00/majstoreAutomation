package api.http.method;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;

import static io.restassured.RestAssured.when;

public class GetMethod {

    public static Response createResponse(String endpoint) {
        RestAssured.defaultParser = Parser.JSON;

        return
                when().get(endpoint)
                        .then().extract().response();
    }
}
