package me.hax3.acceptance.selenium.steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class ScenarioSteps {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private final WebDriver webDriver;
    private final WebDriverWait webDriverWait;

    public ScenarioSteps(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, 10);
    }

    @Given("^a scenario has been written$")
    public void aScenarioHasBeenWritten() {
        log.info("Run: a scenario has been written");
    }

    @When("I run the scenario with selenium")
    public void iRunTheScenarioWithSelenium() {
        log.info("Run: I run the scenario");
        webDriver.get("https://www.google.co.nz");
        log.info(webDriver.getTitle());
        final By xpath = By.xpath("//div[contains(text(), \"Google offered in:\")]");
        webDriverWait.until(visibilityOfElementLocated(xpath));
        webDriver.findElement(xpath);
    }

    @Then("^the scenario should run$")
    public void theScenarioShouldRun() {
        log.info("Run: the scenario should run");
    }


}