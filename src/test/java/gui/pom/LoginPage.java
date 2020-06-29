package gui.pom;



import gui.generic.assertions.AssertWebElement;
import gui.wait.WaitForElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import static gui.wait.WaitForElement.waitUntilElementIsVisible;

public class LoginPage extends BasePage {

    @FindBy(id = "user_login")
    private WebElement usernameOrEmailAddressInput;

    @FindBy(id = "user_pass")
    private WebElement passwordInput;

    @FindBy(id = "wp-submit")
    private WebElement LoginButton;

    @FindBy(id = "login_error")
    private WebElement errorMessageField;

    private static final String INCORRECTUSERNAME = "adam";
    private static final String INCORRECTPASSWORD = "321Start";
    private static final String ERRORMESSAGE = "Error: Invalid Password.";
    private static final String CORRECTUSERNAME = "Test1";
    private static final String CORRECTPASSWORD = "Test1";



    public static String getINCORRECTUSERNAME() {
        return INCORRECTUSERNAME;
    }
    public static String getINCORRECTPASSWORD() {
        return INCORRECTPASSWORD;
    }
    public static String getErrormessage() {return ERRORMESSAGE;}
    public static String getCorrectusername() {
        return CORRECTUSERNAME;
    }
    public static String getCorrectpassword() {
        return CORRECTPASSWORD;
    }


    @Step("Type into User Name Field {username}")
    private void enterLoginToTheUsernameInput(String username) {
        waitUntilElementIsVisible(usernameOrEmailAddressInput);
        usernameOrEmailAddressInput.sendKeys(username);
    }

    @Step("Type into Password Field {password}")
    private void enterPasswordInPasswordField(String password) {
        waitUntilElementIsVisible(passwordInput);
        passwordInput.sendKeys(password);
    }

    @Step("Click on Login Button")
    private void clickOnLoginButton() {
        LoginButton.click();
    }


    @Step("Assert that warning message {warningMessage}")
    public void assertThatWarningIsDisplayed(String warningMessage) {
        WaitForElement.waitUntilElementIsVisible(errorMessageField);
        AssertWebElement.assertThat(errorMessageField).isDisplayed().hasText(warningMessage);
    }

    public void userEnterIncorrectLoginAndPassword(String username, String password) {
        enterLoginToTheUsernameInput(username);
        enterPasswordInPasswordField(password);
        clickOnLoginButton();
    }
}
