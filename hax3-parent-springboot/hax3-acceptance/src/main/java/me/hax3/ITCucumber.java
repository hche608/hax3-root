package me.hax3;

import cucumber.api.CucumberOptions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@ExtendWith(SpringExtension.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-html-report", "json:target/cucumber-json-report.json"},
        format = {"pretty", "html:target/cucumber-html-report", "json:target/cucumber-json-report.json"},
        monochrome = true,
        features = "Features",
        tags = {"~@wip"}
)
public class ITCucumber {
}