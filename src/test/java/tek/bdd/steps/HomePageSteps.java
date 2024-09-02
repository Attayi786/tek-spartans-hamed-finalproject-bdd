package tek.bdd.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import tek.bdd.pages.HomePageObject;
import tek.bdd.utilities.SeleniumUtility;

public class HomePageSteps extends SeleniumUtility {

    @Given("open browser and navigate to retail app") // Cucumber step definition for opening the browser and navigating to the retail app
    public void openBrowserAndNavigateToRetail_app() {
        openBrowser(); // Calls the method to open the browser (defined in SeleniumUtility)
    }

    @Then("validate TEK Insurance UI is exist") // Cucumber step definition for validating the presence of the TEK Insurance UI
    public void validateTekInsuranceUiIsExist() {
        String tekInsuranceText = getElementText(HomePageObject.TEK_INSURANCE_UI_TEXT); // Retrieves the text from the TEK Insurance UI element
        Assert.assertEquals("TEK Insurance App", tekInsuranceText); // Asserts that the retrieved text matches the expected "TEK Insurance App"
        System.out.println(tekInsuranceText); // Prints the retrieved text to the console
    }

    @Then("validate Create Primary Account is exist") // Cucumber step definition for validating the presence of the Create Primary Account button
    public void validateCreatePrimaryAccountIsExist() {
        String createPrimaryAccountText = getElementText(HomePageObject.CREATE_PRIMARY_ACCOUNT_BUTTON); // Retrieves the text from the Create Primary Account button element
        Assert.assertEquals("Create Primary Account", createPrimaryAccountText); // Asserts that the retrieved text matches the expected "Create Primary Account"
        System.out.println(createPrimaryAccountText); // Prints the retrieved text to the console
    }

    @Then("validate Login button is enabled") // Cucumber step definition for validating that the Login button is enabled
    public void validateLoginButtonIsEnabled() {
        boolean loginBtnText = isElementIsEnabled(HomePageObject.LOGIN_BUTTON); // Checks if the Login button is enabled
        Assert.assertTrue("Login button should be enabled", loginBtnText); // Asserts that the Login button is indeed enabled
    }

    @Then("validate color mode button is displayed") // Cucumber step definition for validating the presence of the color mode button
    public void validateColorModeButtonIsDisplayed() {
        boolean colorModeOption = isElementIsDisplayed(HomePageObject.COLOR_MOOD_BUTTON); // Checks if the color mode button is displayed
        Assert.assertTrue("Dark mode color button must be displayed", colorModeOption); // Asserts that the color mode button is indeed displayed
    }
}
