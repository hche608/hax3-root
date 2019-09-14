package me.hax3.selenium.finders;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

import static java.lang.String.format;

@Component
public class Bys {

    public By id(String id) {
        return By.id(id);
    }

    public By attribute(String tag, String name, String value) {
        return By.xpath(format(".//%s[contains(@%s, \"%s\")]", tag, name, value));
    }

    public By idThatContains(String text) {
        return attribute("*", "id", text);
    }

    public By text(String tag, String text) {
        return By.xpath(format(".//%s[text()[contains(., \"%s\")]]", tag, text));
    }

    public By label(String name) {
        return text("label", name);
    }

    public By value(String value) {
        return attribute("input", "value", value);
    }

    public By className(String className) {
        return By.className(className);
    }

    public By parentClassName(String tag, String className) {
        return By.xpath(format("./ancestor::%s[contains(@class, \"%s\")][1]", tag, className));
    }

    public By name(String tag, String name) {
        return attribute(tag, "name", name);
    }

    public By tagName(String tagName) {
        return By.tagName(tagName);
    }
}
