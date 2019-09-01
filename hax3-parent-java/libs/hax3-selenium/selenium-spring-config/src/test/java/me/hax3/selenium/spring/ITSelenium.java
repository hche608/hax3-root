package me.hax3.selenium.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SeleniumConfiguration.class)
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
