package tests.api;

import api.POJOs.Product;
import api.Utils.ExtractObject;
import api.configuration.ApplicationEndPoints;
import api.http.method.DeleteMethod;
import api.http.method.GetMethod;
import api.http.method.PostMethod;
import api.test.base.ApiTestBase;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.apache.http.HttpStatus.*;

public class DeleteObjectApiTest extends ApiTestBase {

    @Test
    public static void positiveDeleteObjectTest() {
        Product product = new Product(0,"New product for delete ","new","666.00");

        Response response = PostMethod.sendPost(product, ApplicationEndPoints.PRODUCT_ENDPOINT);

        Assert.assertEquals(response.statusCode(),SC_CREATED);
        String idOfCreatedObject = ExtractObject.extractObject(response,"id");

        response = DeleteMethod.sendDelete(ApplicationEndPoints.PRODUCT_ENDPOINT + idOfCreatedObject);

        Assert.assertEquals(response.statusCode(),SC_OK);

        response = GetMethod.createResponse(ApplicationEndPoints.PRODUCT_ENDPOINT + idOfCreatedObject);
        Assert.assertEquals(response.statusCode(), SC_NOT_FOUND);


    }

}
