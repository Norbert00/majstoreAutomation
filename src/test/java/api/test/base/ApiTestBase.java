package api.test.base;

import api.au.Au;
import api.configuration.ApplicationEndPoints;
import gui.configuration.ConfigurationProperties;
import gui.configuration.PropertiesLoader;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.Properties;

import static io.restassured.RestAssured.oauth;

public class ApiTestBase {

    private static void resetBaseURI() {
        RestAssured.baseURI = null;
    }
    private static void resetBasePath() {
        RestAssured.basePath = null;
    }
    private static void setUriAndPath(boolean isOnline) {
        if (isOnline) {
            RestAssured.baseURI = ApplicationEndPoints.BASE_URI_ONLINE;
            RestAssured.basePath = ApplicationEndPoints.BASE_PATH_ONLINE;
        } else {
            RestAssured.baseURI = ApplicationEndPoints.BASE_URI_LOCALHOST;
            RestAssured.basePath = ApplicationEndPoints.BASE_PATH_LOCALHOST;
        }
    }

    @BeforeClass
    public void beforeClass() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        Properties propertiesFromFile = propertiesLoader.getPropertiesFromFile("configuration.properties");
        ConfigurationProperties.setProperties(propertiesFromFile);

        boolean onlineLocalhostFlag = Boolean.parseBoolean(ConfigurationProperties.getProperties().getProperty("online.switcher"));

        if (onlineLocalhostFlag) {
            setUriAndPath(true);
            RestAssured.requestSpecification = new RequestSpecBuilder()
                    .setContentType(ContentType.JSON)
                    .addParam(Au.PARAMS_KEY, Au.GET_USR_ONLINE)
                    .addParam(Au.PARAMS_SECRET, Au.GET_PWD_ONLINE).build();
        } else {
            setUriAndPath(false);
            RestAssured.authentication = oauth(Au.GET_USR_LOCALHOST, Au.GET_PWD_LOCALHOST, "", "");
            RestAssured.requestSpecification = new RequestSpecBuilder()
                    .setPort(80)
                    .setContentType(ContentType.JSON).build();
        }
    }

    @AfterClass
    public void afterTest() {
        resetBaseURI();
        resetBasePath();
    }
}
