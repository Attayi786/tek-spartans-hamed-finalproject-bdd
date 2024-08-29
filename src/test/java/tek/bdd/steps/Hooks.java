package tek.bdd.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tek.bdd.utilities.SeleniumUtility;

public class Hooks extends SeleniumUtility {
    private static final Logger LOGGER = LogManager.getLogger(Hooks.class); // Initialize the Logger to log information

    @Before // Cucumber annotation for code to be executed before each scenario
    public void beforeEachScenario(){
        LOGGER.info("Open browser and navigate to retail app"); // Log the action of opening the browser
        openBrowser(); // Call method to open the browser and navigate to the application
    }

    @After // Cucumber annotation for code to be executed after each scenario
    public void afterEachScenario(Scenario scenario){
        LOGGER.info("Close the browser after executing the program"); // Log the action of closing the browser
        if (scenario.isFailed()){ // Check if the scenario has failed
            LOGGER.info("Take screenshot after scenario failed"); // Log the action of taking a screenshot
            byte[] screenShot = takeScreenShot(); // Capture a screenshot of the browser
            scenario.attach(screenShot, "image/png", "failed_scenario"); // Attach the screenshot to the scenario report
        }
        quitBrowser(); // Call method to close and quit the browser
    }
}