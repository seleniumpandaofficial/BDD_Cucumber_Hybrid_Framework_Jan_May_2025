package com.tutorialsninja.runner_files;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src\\test\\resources\\com\\tutorialsninja\\featurefiles", 
        glue = {"com.tutorialsninja.step_definitions","com.tutorialsninja.Hooks"},
        tags = "@IncorrectConfirmPassword",
        plugin = {"pretty", "html:target\\site\\cucumber-html", "json:target\\cucumber1.json"},
        publish = true
       )

public class Runner_TestNG extends AbstractTestNGCucumberTests {

}
