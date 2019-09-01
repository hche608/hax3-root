package me.hax3.selenium.finders;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static shiver.me.timbers.matchers.Matchers.hasField;

public class SelectsTest {
    @Test
    public void Can_create_a_select() {

        final WebElement element = mock(WebElement.class);

        // Given
        given(element.getTagName()).willReturn("select");

        // When
        final Select actual = new Selects().create(element);

        // Then
        assertThat(actual, hasField("element", element));
    }
}