package tek.bdd.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import tek.bdd.pages.LoginPageObject;
import tek.bdd.utilities.SeleniumUtility;

public class LoginPageSteps extends SeleniumUtility {

    @When("click on login button") // Cucumber step definition for clicking the 'login' button
    public void clickOnLoginButton() {
        clickOnElement(LoginPageObject.LOGIN_BUTTON); // Clicks on the login button element defined in LoginPageObject
    }

    @Then("validate Sign in to your Account text is exist") // Cucumber step definition for validating the presence of the sign-in text
    public void validateSignInToYourAccountTextIsExist() {
        String loginPageText = getElementText(LoginPageObject.SIGN_IN_TO_YOUR_ACCOUNT_TEXT); // Retrieves the text of the sign-in header element
        Assert.assertEquals("Sign in to your Account", loginPageText); // Asserts that the text matches the expected value
    }

    @Then("enter username {string} and password {string}") // Cucumber step definition for entering username and password
    public void enterUsernameAndPassword(String username, String password) {
        sendText(LoginPageObject.USERNAME_INPUT, username); // Enters the provided username into the username input field
        sendText(LoginPageObject.PASSWORD_INPUT, password); // Enters the provided password into the password input field
    }

    @Then("click on sign in button") // Cucumber step definition for clicking the 'sign in' button
    public void clickOnSignIButton() throws InterruptedException {
        clickOnElement(LoginPageObject.SIGN_IN_BUTTON); // Clicks on the sign-in button element defined in LoginPageObject
        Thread.sleep(5000); // Pauses execution for 5 seconds to allow for any login processing (not recommended for production code)
    }

    @Then("validate user navigate to Customer Service Portal") // Cucumber step definition for validating navigation to the Customer Service Portal
    public void validateUserNavigateToCustomerServicePortal() {
        String actualCustomerServicesPortal = getElementText(LoginPageObject.VALIDATE_CUSTOMER_SERVICES_PORTAL); // Retrieves the text of the customer service portal element
        Assert.assertEquals("Customer Service Portal", actualCustomerServicesPortal); // Asserts that the text matches the expected value
    }

    @Then("validate error message {string}") // Cucumber step definition for validating an error message
    public void validateErrorMessage(String expectedErrorMessage) {
        String actualErrorMessage = getElementText(LoginPageObject.ERROR_MESSAGE); // Retrieves the text of the error message element
        Assert.assertEquals("ERROR", actualErrorMessage, expectedErrorMessage); // Asserts that the error message matches the expected value
    }

    @Then("close browser") // Cucumber step definition for closing the browser
    public void closeBrowser() {
        quitBrowser(); // Calls the method to close and quit the browser
    }
}
