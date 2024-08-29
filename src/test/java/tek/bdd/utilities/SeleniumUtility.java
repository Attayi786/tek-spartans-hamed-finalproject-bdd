package tek.bdd.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import tek.bdd.base.BaseSetup;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;

public class SeleniumUtility extends BaseSetup {
    private static final Logger LOGGER = LogManager.getLogger(SeleniumUtility.class); // Logger instance for logging actions and events

    private WebDriverWait getWait() {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(Constants.WAIT_IN_SECONDS)); // Returns a WebDriverWait instance with a specified timeout
    }

    private WebElement waitForVisibilityOf(By locator) {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator)); // Waits until the element located by the locator is visible
    }

    public void clickOnElement(By locator) {
        getWait().until(ExpectedConditions.elementToBeClickable(locator)).click(); // Waits until the element is clickable and then clicks it
        LOGGER.info("Clicking on Element {}", locator); // Logs the action of clicking the element
    }

    public void sendText(By locator, String value) {
        LOGGER.info("Clearing And Sending text {} to locator {}", value, locator); // Logs the action of sending text to an element
        waitForVisibilityOf(locator).sendKeys(value); // Waits for the element to be visible and sends text to it
    }

    public String getElementText(By locator) {
        LOGGER.info("Get Element text {}", locator); // Logs the action of getting text from an element
        return waitForVisibilityOf(locator).getText(); // Waits for the element to be visible and returns its text
    }

    public boolean isElementIsEnabled(By locator) {
        LOGGER.info("Checking element is Enabled {}", locator); // Logs the action of checking if an element is enabled
        return waitForVisibilityOf(locator).isEnabled(); // Waits for the element to be visible and checks if it is enabled
    }

    public boolean isElementIsDisplayed(By locator) {
        LOGGER.info("Checking element is Displayed {}", locator); // Logs the action of checking if an element is displayed
        return waitForVisibilityOf(locator).isDisplayed(); // Waits for the element to be visible and checks if it is displayed
    }

    public void selectFromDropDown(By locator, String visibleText) {
        WebElement element = waitForVisibilityOf(locator); // Waits for the drop-down element to be visible
        Select select = new Select(element); // Creates a Select instance to interact with drop-downs
        select.selectByVisibleText(visibleText); // Selects an option from the drop-down by visible text
    }

    public static String getCurrentDate() {
        LocalDate localDate = Instant.now().atZone(ZoneId.of("America/New_York")).toLocalDate(); // Gets the current date in the EST time zone
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG); // Creates a formatter for the long date format
        return formatter.format(localDate); // Formats and returns the current date as a string
    }

    public static String getExpireDate() {
        LocalDate localDate = Instant.now().atZone(ZoneId.of("America/New_York")).plusDays(1).toLocalDate(); // Gets the date one day after today in the EST time zone
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG); // Creates a formatter for the long date format
        return formatter.format(localDate); // Formats and returns the expiration date as a string
    }

    public List<WebElement> getElements(By locator) {
        return getWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator)); // Waits for all elements located by the locator to be visible and returns them
    }

    public byte[] takeScreenShot() {
        TakesScreenshot takesScreenshot = (TakesScreenshot) getDriver(); // Casts the WebDriver instance to TakesScreenshot
        return takesScreenshot.getScreenshotAs(OutputType.BYTES); // Takes a screenshot and returns it as a byte array
    }
}