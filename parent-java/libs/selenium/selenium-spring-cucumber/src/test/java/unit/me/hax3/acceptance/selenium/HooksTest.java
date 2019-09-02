package unit.me.hax3.acceptance.selenium;

import io.cucumber.core.api.Scenario;
import me.hax3.acceptance.selenium.Hooks;
import me.hax3.selenium.finders.Browser;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyZeroInteractions;
import static shiver.me.timbers.data.random.RandomBytes.someBytes;
import static shiver.me.timbers.data.random.RandomIntegers.someInteger;

public class HooksTest {

    private Browser browser;
    private int width;
    private int height;
    private Hooks hooks;

    @Before
    public void setUp() {
        browser = mock(Browser.class);
        width = someInteger();
        height = someInteger();
        hooks = new Hooks(browser, width, height);
    }

    @Test
    public void Will_set_the_window_size_before_every_scenario() {

        // When
        hooks.setup();

        // Then
        then(browser).should().setWindowSize(width, height);
    }

    @Test
    public void Will_log_browser_logs_on_scenario_failure() {

        final Scenario scenario = mock(Scenario.class);

        // Given
        given(scenario.isFailed()).willReturn(true);

        // When
        hooks.tearDown(scenario);

        // Then
        then(browser).should().getLogs();
    }

    @Test
    public void Will_take_a_screen_shot_on_scenario_failure() {

        final Scenario scenario = mock(Scenario.class);
        final byte[] bytes = someBytes();


        // Given
        given(scenario.isFailed()).willReturn(true);
        given(browser.takeScreenShot()).willReturn(bytes);

        // When
        hooks.tearDown(scenario);

        // Then
        then(scenario).should().embed(bytes, "image/png");
    }

    @Test
    public void Will_delete_cookie_on_scenario_failure() {

        final Scenario scenario = mock(Scenario.class);
        final byte[] bytes = someBytes();

        // Given
        given(scenario.isFailed()).willReturn(true);

        // When
        hooks.tearDown(scenario);

        // Then
        then(browser).should().deleteAllCookies();
    }

    @Test
    public void Will_not_log_browser_logs_on_scenario_success() {

        final Scenario scenario = mock(Scenario.class);

        // Given
        given(scenario.isFailed()).willReturn(false);

        // When
        hooks.tearDown(scenario);

        // Then
        verifyZeroInteractions(browser);
    }

}