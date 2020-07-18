package api.Utils;

import io.restassured.response.Response;

public class ExtractObject {

    public static String extractObject(Response response, String jsonPath) {
        return response.jsonPath().getJsonObject(jsonPath).toString();
    }
}
