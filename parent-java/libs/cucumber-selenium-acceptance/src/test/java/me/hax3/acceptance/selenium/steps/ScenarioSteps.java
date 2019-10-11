package me.hax3.acceptance.selenium.steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScenarioSteps {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private final WebDriver webDriver;

    public ScenarioSteps(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Given("^a scenario has been written$")
    public void aScenarioHasBeenWritten() {
        log.info("Run: a scenario has been written");
    }

    @When("I run the scenario with selenium")
    public void iRunTheScenarioWithSelenium() {
        log.info("Run: I run the scenario");
        webDriver.get("https://www.google.com");
        webDriver.findElement(By.xpath("//div[contains(text(), \"Google offered in:\")]"));
    }

    @Then("^the scenario should run$")
    public void theScenarioShouldRun() {
        log.info("Run: the scenario should run");
    }


}