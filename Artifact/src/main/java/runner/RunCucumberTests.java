package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//runapi is for api tests and //runui is for api tests
@CucumberOptions( dryRun = false,
features = {"src/main/java/features"},
glue = {"stepdefs","hooks"},
tags = ("@runapi or @runui"))

public class RunCucumberTests extends AbstractTestNGCucumberTests{

}
