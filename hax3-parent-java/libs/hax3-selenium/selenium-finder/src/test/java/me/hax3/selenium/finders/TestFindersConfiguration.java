package me.hax3.selenium.finders;

import org.openqa.selenium.WebDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.mockito.Mockito.mock;

@Configuration
public class TestFindersConfiguration {

    @Bean
    public WebDriver driver() {
        return mock(WebDriver.class);
    }
}
