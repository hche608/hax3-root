package me.hax3.selenium.finders;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = FindersConfiguration.class)
@SpringBootTest(webEnvironment = NONE)
public class ITFinders {

    private ChromeDriver driver;
    private Finders finders = new Finders(driver, new InternalFinders(new Bys(), new Selects()));

    @Before
    public void setUp() {
        driver = new ChromeDriver();
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

}
