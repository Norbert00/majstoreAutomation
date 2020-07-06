package api.test.base;

import api.Utils.RestUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class ApiTestBase {

    RestUtil restUtil = new RestUtil();

    @BeforeClass
    public void beforeClass() {
        restUtil.setupApiTest();
    }

    @AfterMethod
    public void afterTest() {
        restUtil.afterApiTest();
    }

}
