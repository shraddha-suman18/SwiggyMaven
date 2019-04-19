import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;


@RunWith(Cucumber.class)
    @CucumberOptions(
            features = "src/test/resources/features", tags={"@test"},
            glue = "StepDefs", strict = true, plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}
    )

    public class TestRunner {
        @AfterClass
        public static void teardown() {
            Reporter.loadXMLConfig(new File("target/extent-config.xml"));
            Reporter.setSystemInfo("user", System.getProperty("user.name"));
            Reporter.setSystemInfo("os", "Mac OSX");
            Reporter.setTestRunnerOutput("Sample test runner output message");
        }

    }


