package runnerFiles;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/featureFiles",
glue = "stepDefinitions",
plugin= {"pretty","html:target/site/cucumber-pretty","json:target/cucumber.json"})
public class RunTestNGTest extends AbstractTestNGCucumberTests{

	
}
