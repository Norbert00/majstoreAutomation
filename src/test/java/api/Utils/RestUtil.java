package api.Utils;

import io.restassured.RestAssured;

import static api.au.Au.*;
import static io.restassured.RestAssured.given;

public class RestUtil {

//    private static void setBaseURI() {
//        RestAssured.baseURI = ApplicationEndPoints.BASE_URI;
//    }
//
//    private static void setBasePath () {
//        RestAssured.basePath = ApplicationEndPoints.BASE_PATH;
//    }
//
//    private static void setContentType(ContentType type) {
//        given().contentType(type);
//    }
//
//    private static void setBasePort() {
//        RestAssured.port = 80;
//    }

    private static void resetBaseURI() {
        RestAssured.baseURI = null;
    }

    private static void resetBasePath() {
        RestAssured.basePath = null;
    }



    private static void authentication() {
        given()

                .param(PARAMS_KEY,GET_USR_ONLINE)
                .param(PARAMS_SECRET,GET_PWD_ONLINE);
    }

//    public void setupApiTest(){
//        PropertiesLoader propertiesLoader = new PropertiesLoader();
//        Properties propertiesFromFile = propertiesLoader.getPropertiesFromFile("configuration.properties");
//        ConfigurationProperties.setProperties(propertiesFromFile);
//        setBaseURI();
//        setBasePath();




//        setBaseURI();
//        setBasePath();
//        //port is required only on localhost
//        setBasePort();
//        setContentType(ContentType.JSON);
//        authentication();
//    }

    public void afterApiTest() {
        resetBaseURI();
        resetBasePath();
    }

}
