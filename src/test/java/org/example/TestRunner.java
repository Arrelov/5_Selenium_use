package org.example;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@CucumberOptions(
        features = "src/test/resources/WikiTest.feature",
        glue = "org/example/steps",
        plugin = "pretty"
)

@RunWith(Cucumber.class)
public class TestRunner {
}