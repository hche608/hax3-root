package me.hax3.selenium.finders;

import me.hax3.selenium.finders.autoconfigure.FindersConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = FindersConfiguration.class)
@ComponentScan(basePackages = "me.hax3.selenium.finders")
@SpringBootTest(webEnvironment = NONE)
public class ITSelenium {

    @Autowired
    private WebDriver driver;

    @Test
    public void Can_inject_a_web_driver() {

        // Then
        assertThat(driver, not(nullValue()));
    }

}
