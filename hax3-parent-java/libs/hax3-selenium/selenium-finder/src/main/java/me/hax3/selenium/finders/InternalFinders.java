package me.hax3.selenium.finders;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import shiver.me.timbers.waiting.Options;
import shiver.me.timbers.waiting.Waiter;

import java.util.List;

public class InternalFinders {

    private final Bys by;
    private final Selects selects;

    InternalFinders(Bys by, Selects selects) {
        this.by = by;
        this.selects = selects;
    }

    WebElement findById(SearchContext parent, String id) {
        return parent.findElement(by.id(id));
    }

    WebElement findByIdThatContains(SearchContext parent, String text) {
        return parent.findElement(by.idThatContains(text));
    }

    WebElement findByClassName(SearchContext parent, String className) {
        return parent.findElement(by.className(className));
    }

    List<WebElement> findAllByClassName(SearchContext parent, String className) {
        return parent.findElements(by.className(className));
    }

    WebElement findByText(SearchContext parent, String tag, String text) {
        return parent.findElement(by.text(tag, text));
    }

    WebElement findParentByClassName(SearchContext element, String tag, String className) {
        return element.findElement(by.parentClassName(tag, className));
    }

    WebElement findByName(SearchContext parent, String tag, String name) {
        return parent.findElement(by.name(tag, name));
    }

    WebElement findByLabel(SearchContext parent, String name) {
        return parent.findElement(by.id(parent.findElement(by.label(name)).getAttribute("for")));
    }

    WebElement findByValue(SearchContext parent, String value) {
        return parent.findElement(by.value(value));
    }

    void choose(WebElement element) {
        new Waiter(new Options().willWaitForTrue(true)).wait(() -> {
            element.click();
            return element.isSelected();
        });
    }

    void setText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text == null ? "" : text);
    }

    void select(WebElement element, String option) {
        final Select select = selects.create(element);
        select.selectByVisibleText(option);
    }

    WebElement findByTagName(SearchContext parent, String tagName) {
        return parent.findElement(by.tagName(tagName));
    }
}
