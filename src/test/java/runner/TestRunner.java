package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/feature",
		glue= {"steps"},
		plugin = {"pretty","html:target/cucumber-reports/Cucumber.html"},
		monochrome = true		
		)

public class TestRunner {

}
