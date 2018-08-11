package me.hax3.acceptance.step;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScenarioSteps {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Given("^a scenario has been written$")
    public void aScenarioHasBeenWritten() {
        log.info("Run: a scenario has been written");
    }

    @When("^I run the scenario$")
    public void iRunTheScenario() {
        log.info("Run: I run the scenario");
    }

    @Then("^the scenario should run$")
    public void theScenarioShouldRun() {
        log.info("Run: the scenario should run");
    }
}