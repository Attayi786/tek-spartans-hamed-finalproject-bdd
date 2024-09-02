package tek.bdd.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import tek.bdd.pages.AccountsPageObject;
import tek.bdd.utilities.SeleniumUtility;
import java.util.List; // Importing List class to handle collections of elements

public class AccountsSteps extends SeleniumUtility {

    @Then("click on Accounts button") // Cucumber step definition for clicking the 'Accounts' button
    public void clickOnAccountsButton() {
        clickOnElement(AccountsPageObject.ACCOUNTS_BUTTON); // Click on the specified Accounts button element
    }

    @Then("validate Primary Accounts title is exist") // Cucumber step definition for validating the 'Primary Accounts' title
    public void validatePrimaryAccountsTitleIsExist() {
        String actualPrimaryAccountsTitle = getElementText(AccountsPageObject.PRIMARY_ACCOUNT_TITLE); // Get the text of the primary accounts title element
        Assert.assertEquals("Primary Accounts", actualPrimaryAccountsTitle); // Assert that the title text matches the expected value
    }

    @Then("validate table row count to be {int}") // Cucumber step definition for validating the number of rows in a table
    public void validateTableRowCountToBe(int expectedRows) {
        List<WebElement> tableRow = getElements(AccountsPageObject.TABLE_ROW_ELEMENT); // Retrieve all table row elements
        Assert.assertEquals("validate table rows", tableRow.size(), expectedRows); // Assert that the number of rows matches the expected count
    }

    @When("change item per page to {string}") // Cucumber step definition for changing the number of items displayed per page
    public void changeItemPerPageTo(String itemPerPage) {
        selectFromDropDown(AccountsPageObject.ITEM_PER_PAGE_SELECT, "Show " + itemPerPage); // Select the option from the dropdown to change items per page
    }
}
