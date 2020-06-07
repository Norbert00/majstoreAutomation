package gui.pom;



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


    public static String getINCORRECTUSERNAME() {
        return INCORRECTUSERNAME;
    }
    public static String getINCORRECTPASSWORD() {
        return INCORRECTPASSWORD;
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

    @Step("Getting warning message from Login Page")
    private String getErrorMessageOut() {
        waitUntilElementIsVisible(errorMessageField);
        System.out.println(errorMessageField.getText());
        return errorMessageField.getText();
    }

    public void userEnterIncorrectLoginAndPassword(String username, String password) {
        enterLoginToTheUsernameInput(username);
        enterPasswordInPasswordField(password);
        clickOnLoginButton();
    }

    @Step("Getting is warning message display")
    public boolean errorMessageIsDisplay() {
        boolean errorMessageDisplay = (getErrorMessageOut().equals(ERRORMESSAGE)) ? true : false;
        return errorMessageDisplay;
    }


}
