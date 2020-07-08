package api.test.base;

import api.Utils.RestUtil;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class ApiTestBase {

    RestUtil restUtil = new RestUtil();

    @BeforeClass
    public void beforeClass() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        restUtil.setupApiTest();
    }

    @AfterClass
    public void afterTest() {
        restUtil.afterApiTest();
    }

}
