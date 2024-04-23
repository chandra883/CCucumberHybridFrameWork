package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = { "stepdefinitions", "hooks" }, plugin = { "pretty",
		"html:target/CucumberReports/CucumberReport.html" }, publish = true)
public class TestRunner {

}

// refer youtube video =https://www.youtube.com/watch?v=RlfkOIwhOVg;
