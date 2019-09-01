package me.hax3.selenium.finders;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntry;

import java.time.ZoneId;
import java.util.List;
import java.util.stream.StreamSupport;

import static java.lang.String.format;
import static java.time.Instant.ofEpochMilli;
import static java.time.ZonedDateTime.ofInstant;
import static java.util.stream.Collectors.toList;
import static org.openqa.selenium.OutputType.BYTES;
import static org.openqa.selenium.logging.LogType.BROWSER;

public class Browser {

    private final WebDriver driver;

    public Browser(WebDriver driver) {
        this.driver = driver;
    }

    public void setWindowSize(int width, int height) {
        driver.manage().window().setSize(new Dimension(width, height));
    }

    public void scrollToBottom() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public List<String> getLogs() {
        return StreamSupport.stream(driver.manage().logs().get(BROWSER).spliterator(), false)
            .map(this::toLogString).collect(toList());
    }

    private String toLogString(LogEntry entry) {
        return format(
            "%s %s: %s",
            ofInstant(ofEpochMilli(entry.getTimestamp()), ZoneId.systemDefault()),
            entry.getLevel().getName(),
            entry.getMessage()
        );
    }

    public byte[] takeScreenShot() {
        return ((TakesScreenshot) driver).getScreenshotAs(BYTES);
    }

    public void deleteAllCookies() {
        driver.manage().deleteAllCookies();
    }
}
