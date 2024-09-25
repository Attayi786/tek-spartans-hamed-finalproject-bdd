package tek.bdd.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * TestRunner class to configure and run Cucumber tests with JUnit.
 * This class uses CucumberOptions to specify the configuration for running Cucumber tests.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        // Specifies the path to the feature files.
        // 'classpath:features' means that feature files are located in the 'features' directory under the classpath.
        features = "classpath:features",

        // Specifies the package where the step definition classes are located.
        // 'tek.bdd.steps' is the package where you define the methods that map to Gherkin steps.
        glue = "tek.bdd.steps",

        // Filters scenarios to only run those tagged with '@Smoke'.
        // Tags help you organize and run specific subsets of tests.
        tags = "@Smoke",

        // When set to 'true', Cucumber will only check if step definitions are present, without running the tests.
        // Setting this to 'false' means that tests will be executed.
        dryRun = false,

        // When 'monochrome' is set to 'true', the console output will be plain text without color codes.
        // This makes the output easier to read, especially in environments where color is not supported.
        monochrome = true,

        // Specifies the naming convention for generated step definition methods.
        // 'CAMELCASE' will generate method names in camel case (e.g., 'thisIsAStep').
        snippets = CucumberOptions.SnippetType.CAMELCASE,

        // Configures the format and location of the test reports.
        // 'html:target/cucumber-report/report.html' generates an HTML report at the specified path.
        // 'Pretty' outputs the test results in a readable format to the console.
        plugin = {
                "html:target/cucumber-report/report.html",
                "json:target/jsonReport/report.json", // jason plugin, cucumber report
                "pretty"
        }
)
public class TestRunner {
        // The class is empty because it only serves as an entry point for running the tests.
        // The actual configuration is handled by the @CucumberOptions annotation.
}