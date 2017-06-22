package com.protasov.ii.steps;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        /*glue = "src/test/com/protasov/ii/steps",*/
        plugin = {"pretty", "html:target/cucumber"})
public class Runner {

}
