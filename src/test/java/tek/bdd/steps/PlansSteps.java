package tek.bdd.steps;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import tek.bdd.pages.PlansPageObject;
import tek.bdd.utilities.SeleniumUtility;

public class PlansSteps extends SeleniumUtility {

    @Then("click on plans button") // Cucumber step definition for clicking the 'plans' button
    public void clickOnPlansButton() {
        clickOnElement(PlansPageObject.PLANS_ICON); // Clicks on the plans icon element defined in PlansPageObject
    }

    @Then("validate {int} row of the data is present") // Cucumber step definition for validating the data in a specific row
    public void validate4RowOfTheDataIsPresent(Integer row) {
        String planType = getElementText(PlansPageObject.PLAN_TYPE); // Retrieves the text of the plan type element
        Assert.assertEquals("PLAN TYPE", planType); // Asserts that the plan type text matches the expected value

        String planBasePrice = getElementText(PlansPageObject.PLAN_BASE_PRICE); // Retrieves the text of the plan base price element
        Assert.assertEquals("PLAN BASE PRICE", planBasePrice); // Asserts that the plan base price text matches the expected value

        String dateCreated = getElementText(PlansPageObject.DATE_CREATED); // Retrieves the text of the date created element
        Assert.assertEquals("DATE CREATED", dateCreated); // Asserts that the date created text matches the expected value

        String dateExpire = getElementText(PlansPageObject.DATE_EXPIRE); // Retrieves the text of the date expire element
        Assert.assertEquals("DATE EXPIRE", dateExpire); // Asserts that the date expire text matches the expected value
    }

    @Then("validate Create Date is today's date in EST Time zone") // Cucumber step definition for validating the create date
    public void validateCreateDate() {
        String currentDate = getElementText(PlansPageObject.CREATE_DATE_IS_TODAY_DATE); // Retrieves the text of the create date element
        Assert.assertEquals("August 21, 2024", currentDate); // Asserts that the create date matches the expected value
    }

    @Then("validate Date Expire is a day after EST Time Zone") // Cucumber step definition for validating the expire date
    public void validateDateExpire() {
        String expireDate = getElementText(PlansPageObject.EXPIRE_DATE_IS_AFTER_TODAY_DATE); // Retrieves the text of the expire date element
        Assert.assertEquals("August 22, 2024", expireDate); // Asserts that the expire date matches the expected value
    }
}