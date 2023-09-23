package framework.com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
        publish = true,
        features = "src/test/resources/feature",
        glue = "framework/com/stepDefinition")
public class TestRunner {
}
