package api.response.assertions;

import api.Utils.ExtractObject;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.testng.Assert;



public class AssertableResponse {

    @Step("Assert response status code {statusCode}")
    public AssertableResponse hasStatusCode(Response response, int statusCode) {
        Assert.assertEquals(response.statusCode(), statusCode);
        return this;
    }
    @Step("Assert response field from JSON {fieldFromJson} and expected value is {expectedValue}")
    public AssertableResponse fieldInJson(Response response, String fieldFromJson, String expectedValue) {
        Assert.assertEquals(ExtractObject.extractObject(response,fieldFromJson), expectedValue);
        return this;
    }

}
