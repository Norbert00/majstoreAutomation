package api.test.base;

import api.Utils.RestUtil;
import api.au.Au;
import api.configuration.ApplicationEndPoints;
import gui.configuration.ConfigurationProperties;
import gui.configuration.PropertiesLoader;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.Properties;

public class ApiTestBase {

    RestUtil restUtil = new RestUtil();


    //Fix the authentication for localhost -> sending params by HTTP doesn't work like that

    public static RequestSpecBuilder getBuild() {
        return build;
    }

    public static RequestSpecification getSpec() {
        return spec;
    }

    private static RequestSpecBuilder build;
    private static RequestSpecification spec;

    @BeforeClass
    public void beforeClass() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        //restUtil.setupApiTest();
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        Properties propertiesFromFile = propertiesLoader.getPropertiesFromFile("configuration.properties");
        ConfigurationProperties.setProperties(propertiesFromFile);

        boolean onlineLocalhostFlag = Boolean.parseBoolean(ConfigurationProperties.getProperties().getProperty("online.switcher"));

        if (onlineLocalhostFlag == true) {
            build = new RequestSpecBuilder();
            build.setBaseUri(ApplicationEndPoints.BASE_URI_ONLINE);
            build.setBasePath(ApplicationEndPoints.BASE_PATH_ONLINE);
            build.addParam(Au.PARAMS_KEY, Au.GET_USR_ONLINE);
            build.addParam(Au.PARAMS_SECRET, Au.GET_PWD_ONLINE);
            spec = build.build();
        } else {
            build = new RequestSpecBuilder();
            build.setBaseUri(ApplicationEndPoints.BASE_URI_LOCALHOST);
            build.setBasePath(ApplicationEndPoints.BASE_PATH_LOCALHOST);
            build.setPort(80);
            build.addParam(Au.PARAMS_KEY, Au.GET_USR_LOCALHOST);
            build.addParam(Au.PARAMS_SECRET, Au.GET_PWD_LOCALHOST);
            spec = build.build();
        }
    }

    @AfterClass
    public void afterTest() {
        restUtil.afterApiTest();
    }


}


//    @BeforeClass
//    public void requestSpecBuilder() {
//        PropertiesLoader propertiesLoader = new PropertiesLoader();
//        Properties propertiesFromFile = propertiesLoader.getPropertiesFromFile("configuration.properties");
//        ConfigurationProperties.setProperties(propertiesFromFile);
//
//        build = new RequestSpecBuilder();
//        build.setBaseUri(ApplicationEndPoints.BASE_URI);
//        build.setBasePath(ApplicationEndPoints.BASE_PATH);
//        build.addParam(Authentication.PARAMS_KEY,Authentication.GET_USR_ONLINE);
//        build.addParam(Authentication.PARAMS_SECRET,Authentication.GET_PWD_ONLINE);
//        //build.addParam("consumer_key","ck_2207e2f752afc6f44caa7db2054b211b085cad73");
//        //build.addParam("consumer_secret","cs_ee64f2f162c55911cc4daee3edb8b41723843039");
//        spec = build.build();
//    }