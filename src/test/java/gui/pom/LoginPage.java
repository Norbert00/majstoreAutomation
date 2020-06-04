package gui.pom;



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


    private void enterLoginToTheUsernameInput(String username) {
        waitUntilElementIsVisible(usernameOrEmailAddressInput);
        usernameOrEmailAddressInput.sendKeys(username);
    }

    private void enterPasswordInPasswordField(String password) {
        waitUntilElementIsVisible(passwordInput);
        passwordInput.sendKeys(password);
    }

    private void clickOnLoginButton() {
        LoginButton.click();
    }

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

    public boolean errorMessageIsDisplay() {
        boolean errorMessageDisplay = (getErrorMessageOut().equals(ERRORMESSAGE)) ? true : false;
        return errorMessageDisplay;
    }


}
