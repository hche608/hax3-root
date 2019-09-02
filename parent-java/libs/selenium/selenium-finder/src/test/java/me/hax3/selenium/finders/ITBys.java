package me.hax3.selenium.finders;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ITBys.class)
@SpringBootTest(webEnvironment = NONE)
public class ITBys {

    private Bys by = new Bys();

    @Test
    public void Can_inject_bys() {

        // Then
        assertThat(by, not(nullValue()));
    }
}
