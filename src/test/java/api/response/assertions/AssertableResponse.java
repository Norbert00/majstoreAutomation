package api.response.assertions;

import api.Utils.ExtractObject;
import io.restassured.response.Response;
import org.testng.Assert;



public class AssertableResponse {

    public AssertableResponse hasStatusCode(Response response, int statusCode) {
        Assert.assertEquals(response.statusCode(), statusCode);
        return this;
    }

    public AssertableResponse fieldInJson(Response response, String fieldFromJson, String expectedValue) {
        Assert.assertEquals(ExtractObject.extractObject(response,fieldFromJson), expectedValue);
        return this;
    }

}
