package api.Utils;

import api.configuration.ApplicationEndPoints;
import gui.configuration.ConfigurationProperties;
import gui.configuration.PropertiesLoader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import java.util.Properties;

import static api.authentication.Authentication.GET_PWD;
import static api.authentication.Authentication.GET_USR;
import static io.restassured.RestAssured.*;

public class RestUtil {

    private static void setBaseURI() {
        RestAssured.baseURI = ApplicationEndPoints.BASE_URI;
    }

    private static void setBasePath () {
        RestAssured.basePath = ApplicationEndPoints.BASE_PATH;
    }

    private static void setContentType(ContentType type) {
        given().contentType(type);
    }

    private static void setBasePort() {
        RestAssured.port = 80;
    }

    private static void resetBaseURI() {
        RestAssured.baseURI = null;
    }

    private static void resetBasePath() {
        RestAssured.basePath = null;
    }



    private static void authentication() {
        authentication = oauth(GET_USR , GET_PWD, "","");
    }

    public void setupApiTest(){
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        Properties propertiesFromFile = propertiesLoader.getPropertiesFromFile("configuration.properties");
        ConfigurationProperties.setProperties(propertiesFromFile);
        setBaseURI();
        setBasePath();
        setBasePort();
        setContentType(ContentType.JSON);
        authentication();
    }

    public void afterApiTest() {
        resetBaseURI();
        resetBasePath();
    }

}
