package me.hax3.selenium.spring;

import me.hax3.selenium.finders.Finders;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import shiver.me.timbers.waiting.WaiterAspect;

import static java.lang.String.format;

@Configuration
@ComponentScan
public class SeleniumConfiguration {

    private static ChromeOptions headlessChromeOptions() {
        final ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-agent=Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.113 Safari/537.36");
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--user-data-dir=/tmp/user-data");
        options.addArguments("--disable-gpu");
        options.addArguments("--data-path=/tmp/data-path");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--homedir=/tmp");
        options.addArguments("--disk-cache-dir=/tmp/cache-dir");
        return options;
    }

    @Bean(destroyMethod = "quit")
    public WebDriver webDriver(@Value("${web.driver:chrome-headless}") String webDriver) {

        if ("chrome".equals(webDriver)) {
            return new ChromeDriver();
        }

        if ("chrome-headless".equals(webDriver)) {
            final ChromeOptions options = headlessChromeOptions();
            return new ChromeDriver(options);
        }

        if ("chrome-docker".equals(webDriver)) {
            final ChromeOptions options = headlessChromeOptions();
            options.addArguments("--disable-gpu");
            return new ChromeDriver(options);
        }

        if ("firefox".equals(webDriver)) {
            return new FirefoxDriver();
        }

        if ("ie".equals(webDriver)) {
            return new InternetExplorerDriver();
        }

        if ("safari".equals(webDriver)) {
            return new SafariDriver();
        }

        if ("opera".equals(webDriver)) {
            return new OperaDriver();
        }

        throw new IllegalArgumentException(format("Web driver %s not supported.", webDriver));
    }

    @Bean
    public Finders finders(WebDriver webDriver) {
        return new Finders(webDriver);
    }

    @Bean
    public WaiterAspect waiterAspect() {
        return new WaiterAspect();
    }

}
