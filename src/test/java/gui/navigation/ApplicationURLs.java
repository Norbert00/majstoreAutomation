package gui.navigation;

import gui.configuration.AppProperties;

public class ApplicationURLs {

    public static final String APPLICATION_URL = AppProperties.getAllUrl();
    public static final String LOGIN_URL = APPLICATION_URL + "wp-login.php";
    public static final String MYACCOUNT_PAGE = APPLICATION_URL + "my-account/";

}
