package me.hax3.acceptance.step;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import me.hax3.ITCucumber;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static java.util.Collections.emptyList;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ITCucumber.class)
@SpringBootTest(webEnvironment = DEFINED_PORT)
public class Hooks {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired(required = false)
    private List<GenericHolder> holders = emptyList();

    @Before
    public void setup(Scenario scenario) {
        log.info("Scenario Start.");
        final String x = scenario.getName() + " Status --> " + scenario.getStatus();
        printLine(x.length());
        log.info(x);
        printLine(x.length());
    }

    @After
    public void tearDown(Scenario scenario) {
        log.info("Scenario End.");
        if (scenario.isFailed()) {
            holders.forEach(holder -> log.error(holder.toString()));
        }
    }

    private void printLine(int length) {
        for (int i = 1; i < length; i++) {
            log.info("-");
        }
        log.info("-");
    }
}