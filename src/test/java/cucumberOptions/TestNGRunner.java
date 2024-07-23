package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features", glue="stepDefinitions", monochrome=true, tags="@challenge", plugin= {"pretty", "html:target/cucumber.html"} )
public class TestNGRunner  extends AbstractTestNGCucumberTests{

}
