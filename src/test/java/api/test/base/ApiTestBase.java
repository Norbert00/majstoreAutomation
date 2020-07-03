package api.test.base;

import api.Utils.RestUtil;
import io.restassured.http.ContentType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class ApiTestBase {

    RestUtil restUtil = new RestUtil();

    @BeforeClass
    public void beforeClass() {
        restUtil.setup(ContentType.JSON);
    }

    @AfterMethod
    public void afterTest() {
        restUtil.afterApiTest();
    }

}
