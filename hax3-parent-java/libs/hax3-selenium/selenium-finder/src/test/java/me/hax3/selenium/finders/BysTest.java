package me.hax3.selenium.finders;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static java.lang.String.format;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.openqa.selenium.By.ByClassName;
import static org.openqa.selenium.By.ById;
import static org.openqa.selenium.By.ByTagName;
import static shiver.me.timbers.data.random.RandomStrings.someString;
import static shiver.me.timbers.matchers.Matchers.hasField;

public class BysTest {

    private Bys by;

    @Before
    public void setUp() {
        by = new Bys();
    }

    @Test
    public void Can_create_a_by_id() {

        // Given
        final String id = someString();

        // When
        final By actual = by.id(id);

        // Then
        assertThat(actual, instanceOf(ById.class));
        assertThat(actual, hasField("id", id));
    }

    @Test
    public void Can_create_a_by_attribute() {

        // Given
        final String tag = someString();
        final String name = someString();
        final String value = someString();

        // When
        final By actual = by.attribute(tag, name, value);

        // Then
        assertThat(actual, hasField("xpathExpression", format(".//%s[contains(@%s, \"%s\")]", tag, name, value)));
    }

    @Test
    public void Can_create_a_by_id_that_contains_text() {

        // Given
        final String text = someString();

        // When
        final By actual = by.idThatContains(text);

        // Then
        assertThat(actual, hasField("xpathExpression", format(".//*[contains(@id, \"%s\")]", text)));
    }

    @Test
    public void Can_create_a_by_class_name() {

        // Given
        final String className = someString();

        // When
        final By actual = by.className(className);

        // Then
        assertThat(actual, instanceOf(ByClassName.class));
        assertThat(actual, hasField("className", className));
    }

    @Test
    public void Can_create_a_by_text() {

        // Given
        final String tag = someString();
        final String text = someString();

        // When
        final By actual = by.text(tag, text);

        // Then
        assertThat(actual, hasField("xpathExpression", format(".//%s[text()[contains(., \"%s\")]]", tag, text)));
    }

    @Test
    public void Can_create_a_by_value() {

        // Given
        final String value = someString(5);

        // When
        final By actual = by.value(value);

        // Then
        assertThat(actual, hasField("xpathExpression", format(".//input[contains(@value, \"%s\")]", value)));
    }

    @Test
    public void Can_create_a_by_label() {

        // Given
        final String text = someString();

        // When
        final By actual = by.label(text);

        // Then
        assertThat(actual, hasField("xpathExpression", format(".//label[text()[contains(., \"%s\")]]", text)));
    }

    @Test
    public void Can_create_a_by_parent_class_name() {

        // Given
        final String tag = someString();
        final String className = someString();

        // When
        final By actual = by.parentClassName(tag, className);

        // Then
        assertThat(actual, hasField(
            "xpathExpression", format("./ancestor::%s[contains(@class, \"%s\")][1]", tag, className))
        );
    }

    @Test
    public void Can_create_a_by_name() {

        // Given
        final String tag = someString(5);
        final String name = someString(8);

        // When
        final By actual = by.name(tag, name);

        // Then
        assertThat(actual, hasField("xpathExpression", format(".//%s[contains(@name, \"%s\")]", tag, name)));
    }

    @Test
    public void Can_create_a_by_tag_name() {

        // Given
        final String tagName = someString();

        // When
        final By actual = by.tagName(tagName);

        // Then
        assertThat(actual, instanceOf(ByTagName.class));
        assertThat(actual, hasField("tagName", tagName));
    }

}