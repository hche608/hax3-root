package me.hax3.selenium.finders.autoconfigure;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PreDestroy;

@Configuration
@ComponentScan(basePackages = "me.hax3.selenium.finders")
public class FindersShutdownConfiguration {

    @Autowired
    private WebDriver webDriver;

    @PreDestroy
    public void quitWebDriver() {
        webDriver.quit();
    }
}
