package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src\\main\\resources\\Feature",
        glue = "StepDefinition",
        plugin = {"pretty",
            "html:target/cucumber.html",
            "json:target/cucumber.json",
            "junit:target/cukes.xml",
            "rerun:target/rerun.txt"},
        dryRun = false,
        tags = "@smoke"
)

public class TestRunner extends AbstractTestNGCucumberTests {



}
