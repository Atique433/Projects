package cucumberrunner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features = "src/test/resources/Selenium",
glue ="com.stepdefs",
plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
tags = "@FirstTest ,  @SecondTest"
)
public class runner extends AbstractTestNGCucumberTests {

}
