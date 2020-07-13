package tests.api;

import api.POJOs.Product;
import api.Utils.ExtractObject;
import api.configuration.ApplicationEndPoints;
import api.http.method.GetMethod;
import api.http.method.PostMethod;
import api.test.base.ApiTestBase;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.apache.http.HttpStatus.SC_CREATED;

public class NewProductApiTest extends ApiTestBase {

    @Test
    public void createProductTest() {
        Product product = new Product(0,"gsonExtracted ","new","666.00");

        Response response = PostMethod.sendPost(product,ApplicationEndPoints.PRODUCT_ENDPOINT);

        Assert.assertEquals(response.statusCode(),SC_CREATED);

        String id = ExtractObject.extractObject(response,"id");
        response = GetMethod.createResponse(ApplicationEndPoints.PRODUCT_ENDPOINT + id);

        String createdId = ExtractObject.extractObject(response,"id");

        Assert.assertEquals(id,createdId);


    }
}
