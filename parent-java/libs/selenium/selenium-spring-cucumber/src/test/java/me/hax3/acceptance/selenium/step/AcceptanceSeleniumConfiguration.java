package me.hax3.acceptance.selenium.step;

import me.hax3.selenium.finders.Finders;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AcceptanceSeleniumConfiguration {


    @Bean(destroyMethod = "quit")
    public WebDriver webDriver() {
        return new ChromeDriver();
    }

    @Bean
    public Finders finders(WebDriver webDriver) {
        return new Finders(webDriver);
    }

}
