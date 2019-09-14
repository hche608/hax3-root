package me.hax3.selenium.finders;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ITFinders.class)
@ComponentScan(basePackages = "me.hax3.selenium.finders")
@SpringBootTest(webEnvironment = NONE)
public class ITFinders {

    @Autowired
    private WebDriver driver;

    private Finders finders;

    @Before
    public void setUp() {
        finders = new Finders(driver, new InternalFinders(new Bys(), new Selects()));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void Can_inject_finders() {

        // Then
        assertThat(finders, not(nullValue()));
    }

//    @Test
//    public void Can_inject_finders_again() {
//
//        // Then
//        assertThat(new Finders(driver), not(nullValue()));
//    }

}
