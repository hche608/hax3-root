package me.hax3.selenium.acceptance;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import me.hax3.selenium.finders.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

public class Hooks {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private final Browser browser;
    private final int width;
    private final int height;

    public Hooks(Browser browser, @Value("${screen.width}") int width, @Value("${screen.width}") int height) {
        this.browser = browser;
        this.width = width;
        this.height = height;
    }

    @Before
    public void setup() {
        browser.setWindowSize(width, height);
    }

    @After
    public void tearDown(Scenario scenario) {
        log.info("Scenario End.");
        if (scenario.isFailed()) {
            browser.getLogs().forEach(log::error);
            scenario.embed(browser.takeScreenShot(), "image/png");
            browser.deleteAllCookies();
        }
    }
}
