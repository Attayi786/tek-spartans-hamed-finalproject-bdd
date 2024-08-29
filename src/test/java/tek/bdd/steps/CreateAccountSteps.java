package tek.bdd.steps;

import io.cucumber.java.en.Then; // Importing Cucumber annotation for 'Then' steps
import io.cucumber.java.en.When; // Importing Cucumber annotation for 'When' steps
import org.junit.Assert; // Importing JUnit assertion methods
import tek.bdd.pages.CreateAccountPageObject; // Importing page object class for Create Account page
import tek.bdd.utilities.RandomGenerator; // Importing utility class for generating random data
import tek.bdd.utilities.SeleniumUtility; // Importing utility class for common Selenium WebDriver methods

public class CreateAccountSteps extends SeleniumUtility {

    @When("click on Crate Primary Account link") // Cucumber step definition for clicking the 'Create Primary Account' link
    public void clickOnLink() {
        clickOnElement(CreateAccountPageObject.CREATE_PRIMARY_ACCOUNT_LINK); // Click on the specified link element
    }

    @Then("validate section title to be Create Primary Account Holder") // Cucumber step definition for validating the section title
    public void validateSectionTitleToBe() {
        String createAccountHolderTitle = getElementText(CreateAccountPageObject.CREATE_PRIMARY_ACCOUNT_HOLDER_TILE); // Get the text of the section title element
        Assert.assertEquals("Create Primary Account Holder", createAccountHolderTitle); // Assert that the section title is as expected
    }

    @Then("fill up create account form") // Cucumber step definition for filling out the create account form
    public void fillUpCreateAccountForm() {
        String prefix = "Hamed"; // Prefix for generating a random email
        String randomEmail = RandomGenerator.randomEmail(prefix); // Generate a random email address using the prefix
        sendText(CreateAccountPageObject.EMAIL_INPUT, randomEmail); // Enter the generated email address into the email input field
        selectFromDropDown(CreateAccountPageObject.PREFIX_SELECT, "Mr."); // Select "Mr." from the prefix dropdown
        sendText(CreateAccountPageObject.FIRST_NAME_INPUT, "Hamed"); // Enter first name
        sendText(CreateAccountPageObject.LAST_NAME_INPUT, "A"); // Enter last name
        selectFromDropDown(CreateAccountPageObject.GENDER_SELECT, "Male"); // Select "Male" from the gender dropdown
        selectFromDropDown(CreateAccountPageObject.MARITAL_STATUS_SELECT, "Single"); // Select "Married" from the marital status dropdown
        sendText(CreateAccountPageObject.EMPLOYMENT_STATUS, "Test Engineer"); // Enter employment status
        sendText(CreateAccountPageObject.DATE_OF_BIRTH, "07/19/1992"); // Enter date of birth
    }

    @Then("click on Create Account button") // Cucumber step definition for clicking the 'Create Account' button
    public void clickOnCreateAccountButton() {
        clickOnElement(CreateAccountPageObject.CREATE_ACCOUNT_BUTTON); // Click on the specified button element
    }

    @Then("validate Sign up your account title is exist") // Cucumber step definition for validating the "Sign up your account" title
    public void validateSignUpYourAccountTitleIsExist() {
        String actualSignUpTitle = getElementText(CreateAccountPageObject.SIGN_UP_YOUR_ACCOUNT_TITLE); // Get the text of the sign-up title element
        Assert.assertEquals("Sign up your account", actualSignUpTitle); // Assert that the sign-up title matches the expected value
    }

    @Then("validate user full name is displayed") // Cucumber step definition for checking if the user's full name is displayed
    public void validateUserFullNameIsDisplayed() {
        boolean userActualFullName = isElementIsDisplayed(CreateAccountPageObject.USER_FULL_NAME); // Check if the user's full name element is displayed
        Assert.assertTrue("User full name should be displayed", userActualFullName); // Assert that the user's full name is displayed
    }

    @Then("validate email address shows as expected") // Cucumber step definition for checking if the email address is displayed as expected
    public void validateEmailAddressShowsAsExpected() {
        boolean userActualEmailAddress = isElementIsDisplayed(CreateAccountPageObject.USER_EMAIL_ADDRESS_TITLE); // Check if the email address element is displayed
        Assert.assertTrue("Email address must be displayed as expected", userActualEmailAddress); // Assert that the email address is displayed as expected
    }

    @When("when the user fill up sign up form") // Cucumber step definition for filling out the sign-up form
    public void whenTheUserFillUpSignUpForm() {
        sendText(CreateAccountPageObject.USERNAME_INPUT, "Hamed"); // Enter username
        sendText(CreateAccountPageObject.PASSWORD_INPUT, "Qwerty@1992"); // Enter password
        sendText(CreateAccountPageObject.CONFIRM_PASSWORD_INPUT, "Qwerty@1992"); // Enter password confirmation
    }

    @Then("click on submit button") // Cucumber step definition for clicking the 'Submit' button
    public void clickOnSubmitButton() {
        clickOnElement(CreateAccountPageObject.SUBMIT_BUTTON); // Click on the specified submit button element
    }

    @Then("fill up create account form page") // Cucumber step definition for filling out the create account form on a page
    public void fillUpCreateAccountFormPage() {
        sendText(CreateAccountPageObject.EMAIL_INPUT, "Hamed.Attayi@tekschool.us"); // Enter a specific email address into the email input field
        selectFromDropDown(CreateAccountPageObject.PREFIX_SELECT, "Mr."); // Select "Mr." from the prefix dropdown
        sendText(CreateAccountPageObject.FIRST_NAME_INPUT, "Hamed"); // Enter first name
        sendText(CreateAccountPageObject.LAST_NAME_INPUT, "A"); // Enter last name
        selectFromDropDown(CreateAccountPageObject.GENDER_SELECT, "Male"); // Select "Male" from the gender dropdown
        selectFromDropDown(CreateAccountPageObject.MARITAL_STATUS_SELECT, "Single"); // Select "Married" from the marital status dropdown
        sendText(CreateAccountPageObject.EMPLOYMENT_STATUS, "Test Engineer"); // Enter employment status
        sendText(CreateAccountPageObject.DATE_OF_BIRTH, "07/19/1992"); // Enter date of birth
    }

    @When("validate account error message") // Cucumber step definition for validating the account error message
    public void validateAccountErrorMessage() {
        String errorMessage = getElementText(CreateAccountPageObject.ERROR_MESSAGE); // Get the text of the error message element
        Assert.assertEquals("ERROR", errorMessage); // Assert that the error message matches the expected value
        System.out.println(errorMessage); // Print the error message to the console for debugging
    }
}