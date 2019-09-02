package me.hax3.acceptance.step;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shiver.me.timbers.waiting.Wait;

public class ScenarioSteps {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private int count = 0;

    @Given("^a scenario has been written$")
    public void aScenarioHasBeenWritten() {
        log.info("Run: a scenario has been written");
    }

    @Wait
    @When("^I run the scenario$")
    public void iRunTheScenario() {
        log.info("Run: I run the scenario");
        if (count == 0) {
            log.info("Can fail once.");
            count++;
            throw new AssertionError("Fails once.");
        }
    }

    @Then("^the scenario should run$")
    public void theScenarioShouldRun() {
        log.info("Run: the scenario should run");
    }
}