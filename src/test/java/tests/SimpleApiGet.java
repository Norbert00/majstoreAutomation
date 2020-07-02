package tests;

import api.authentication.Authentication;
import api.buildOfResponse.BuildGiven;
import gui.configuration.ConfigurationProperties;
import gui.configuration.PropertiesLoader;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Properties;

import static api.configuration.ApplicationEndPoints.PRODUCT_ENDPOINT;

public class SimpleApiGet {


    @BeforeClass
    public void beforeClass() {
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        Properties propertiesFromFile = propertiesLoader.getPropertiesFromFile("configuration.properties");
        ConfigurationProperties.setProperties(propertiesFromFile);
    }

    @Test
    public void simpleGetTest() {
        Authentication authentication = new Authentication();
        BuildGiven buildGiven = new BuildGiven();
        Response response = buildGiven.getResponse(PRODUCT_ENDPOINT, authentication.getUsername(),authentication.getPassword());
        Assert.assertEquals(200, response.getStatusCode());
    }

}
