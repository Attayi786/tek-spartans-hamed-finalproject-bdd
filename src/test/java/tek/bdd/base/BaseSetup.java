package tek.bdd.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import tek.bdd.browsers.BaseBrowser;
import tek.bdd.browsers.ChromeBrowser;
import tek.bdd.browsers.EdgeBrowser;
import tek.bdd.browsers.FireFoxBrowser;
import tek.bdd.exceptions.ExceptionsHandling;
import tek.bdd.utilities.Constants;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

/**
 * This abstract class sets up and manages a WebDriver instance for browser interactions.
 */
public abstract class BaseSetup {

    // Static WebDriver instance shared across all subclasses
    private static WebDriver driver;

    // Logger instance for logging various actions and events
    private static final Logger LOGGER = LogManager.getLogger(BaseSetup.class);

    // Properties instance to load and manage configuration settings
    private final Properties properties;

    /**
     * Constructor that initializes the Properties object by loading the configuration file.
     */
    public BaseSetup() {
        try {
            // Path to the configuration file
            String configFilePath = System.getProperty("user.dir") + "/src/test/resources/configs/dev-config.properties";
            LOGGER.info("Reading Config file {}", configFilePath);

            // Load the configuration file into the Properties object
            File file = new File(configFilePath);
            FileInputStream fileInputStream = new FileInputStream(file);
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException exception) {
            // Log error and throw custom exception if there's an issue reading the file
            LOGGER.error("Error reading config file", exception);
            throw new ExceptionsHandling("Something wrong with config file");
        }
    }

    /**
     * Opens the browser based on the configuration settings and navigates to the specified URL.
     */
    public void openBrowser() {
        // Retrieve browser type and headless mode from properties
        String browserType = properties.getProperty("ui.browser");
        boolean isHeadless = Boolean.parseBoolean(properties.getProperty("ui.browser.headless"));
        LOGGER.info("Running on browser {}", browserType);
        LOGGER.info("Is Headless ON {}", isHeadless);

        // Create the appropriate browser instance based on the configuration
        BaseBrowser browser;
        if (browserType.equalsIgnoreCase("chrome"))
            browser = new ChromeBrowser();
        else if (browserType.equalsIgnoreCase("edge"))
            browser = new EdgeBrowser();
        else if (browserType.equalsIgnoreCase("firefox"))
            browser = new FireFoxBrowser();
        else
            throw new ExceptionsHandling("Wrong browser type, choose another browser such as chrome, firefox and edge");

        // Open the browser and navigate to the URL
        driver = browser.openBrowser(isHeadless);
        String url = properties.getProperty("ui.url");
        LOGGER.debug("Using URL {}", url);
        driver.get(url);

        // Maximize the browser window and set timeouts
        LOGGER.info("Maximizing the browser");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.WAIT_IN_SECONDS));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.WAIT_IN_SECONDS));
    }
    /**
     * Closes the browser and cleans up the WebDriver instance.
     */
    public void quitBrowser() {
        if (driver != null) {
            LOGGER.info("Quitting the Browser");
            driver.quit();
        }
    }
    /**
     * Returns the current WebDriver instance.
     * @return WebDriver instance
     */
    public WebDriver getDriver() {
        LOGGER.info("Getting the driver");
        return driver;
    }
}