package api.Utils;

import api.configuration.ApplicationEndPoints;
import api.configuration.BasicUri;
import gui.configuration.ConfigurationProperties;
import gui.configuration.PropertiesLoader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import java.util.Properties;

import static api.authentication.Authentication.GET_PWD;
import static api.authentication.Authentication.GET_USR;
import static io.restassured.RestAssured.*;

public class RestUtil {

    private static void setBaseURI(String baseURI) {
        RestAssured.baseURI = baseURI;
    }

    private static void setBasePath (String basePathTerm) {
        RestAssured.basePath = basePathTerm;
    }

    private static void resetBaseURI() {
        RestAssured.baseURI = null;
    }

    private static void resetBasePath() {
        RestAssured.basePath = null;
    }

    private static void setContentType(ContentType type) {
        given().contentType(type);
    }

    private static void authentication() {
        authentication = oauth(GET_USR , GET_PWD, "","");
    }

    public void setup(ContentType contentType){
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        Properties propertiesFromFile = propertiesLoader.getPropertiesFromFile("configuration.properties");
        ConfigurationProperties.setProperties(propertiesFromFile);

        setBaseURI(BasicUri.getBasicURI());
        setBasePath(ApplicationEndPoints.PRODUCT_ENDPOINT);
        RestAssured.port = 80;
        setContentType(contentType);
        authentication();
    }

    public void afterApiTest() {
        resetBaseURI();
        resetBasePath();
    }

}
