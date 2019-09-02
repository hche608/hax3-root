package me.hax3.acceptance.selenium.step;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import me.hax3.selenium.finders.Finders;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = AcceptanceSeleniumConfiguration.class)
public class ScenarioSteps {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private final WebDriver webDriver;
    private final Finders finders;

    public ScenarioSteps(WebDriver webDriver, Finders finders) {
        this.webDriver = webDriver;
        this.finders = finders;
    }

    @Given("^a scenario has been written$")
    public void aScenarioHasBeenWritten() {
        log.info("Run: a scenario has been written");
    }

    @When("I run the scenario with selenium")
    public void iRunTheScenarioWithSelenium() {
        log.info("Run: I run the scenario");
        webDriver.get("https://www.google.com");
        finders.findByText("div", "Google offered in:  ");
    }

    @Then("^the scenario should run$")
    public void theScenarioShouldRun() {
        log.info("Run: the scenario should run");
    }


}