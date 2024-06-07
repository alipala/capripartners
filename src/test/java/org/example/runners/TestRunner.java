package org.example.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.picocontainer.PicoFactory;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"org.example.steps"},
        tags = "@smoke or @regression or @e2e",
        publish = true,
        objectFactory = PicoFactory.class
)
public class TestRunner {

}
