package tek.bdd.steps;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import tek.bdd.pages.UserProfilePageObject;
import tek.bdd.utilities.SeleniumUtility;

public class UserProfileSteps extends SeleniumUtility {

    @Then("click on profile button") // Cucumber step definition for clicking the profile button
    public void clickCnProfileButton() throws InterruptedException {
        clickOnElement(UserProfilePageObject.ACCOUNT_PROFILE); // Clicks on the profile button element defined in UserProfilePageObject
        Thread.sleep(5000); // Pauses execution for 5 seconds to ensure the profile side drawer has time to open (not ideal for production use)
    }

    @Then("validate information in Profile Side Drawer is correct") // Cucumber step definition for validating profile information
    public void validateInformationInProfileSideDrawerIsCorrect() {
        String actualProfile = getElementText(UserProfilePageObject.PROFILE_INFORMATION); // Retrieves the text of the profile information element
        Assert.assertEquals("Profile", actualProfile); // Asserts that the profile information text matches the expected value "Profile"
    }

    @Then("click on logout button") // Cucumber step definition for clicking the logout button
    public void clickCnLogoutButton() {
        getElementText(UserProfilePageObject.LOGOUT_BUTTON); // Retrieves the text of the logout button element (this appears to be a mistake, should be clicking the button instead)

    }
}

