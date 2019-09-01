package me.hax3.selenium.finders;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Finders {

    private final WebDriver driver;
    private final InternalFinders internalFinders;

    public Finders(WebDriver driver, InternalFinders internalFinders) {
        this.driver = driver;
        this.internalFinders = internalFinders;
    }

    public WebElement findById(String id) {
        return findById(driver, id);
    }

    public WebElement findById(SearchContext parent, String id) {
        return internalFinders.findById(parent, id);
    }

    public WebElement findByIdThatContains(String text) {
        return findByIdThatContains(driver, text);
    }

    public WebElement findByIdThatContains(SearchContext parent, String text) {
        return internalFinders.findByIdThatContains(parent, text);
    }

    public void clickById(String id) {
        clickById(driver, id);
    }

    public void clickById(SearchContext parent, String id) {
        internalFinders.findById(parent, id).click();
    }

    public void chooseById(String id) {
        chooseById(driver, id);
    }

    public void chooseById(SearchContext parent, String id) {
        internalFinders.choose(internalFinders.findById(parent, id));
    }

    public WebElement findByClassName(String className) {
        return findByClassName(driver, className);
    }

    public WebElement findByClassName(SearchContext parent, String className) {
        return internalFinders.findByClassName(parent, className);
    }

    public String findTextByClassName(String className) {
        return findTextByClassName(driver, className);
    }

    public String findTextByClassName(SearchContext parent, String className) {
        return internalFinders.findByClassName(parent, className).getText();
    }

    public void clickByClassName(String className) {
        clickByClassName(driver, className);
    }

    public void clickByClassName(SearchContext parent, String className) {
        internalFinders.findByClassName(parent, className).click();
    }

    public List<WebElement> findAllByClassName(String className) {
        return findAllByClassName(driver, className);
    }

    public List<WebElement> findAllByClassName(SearchContext parent, String className) {
        return internalFinders.findAllByClassName(parent, className);
    }

    public WebElement findByText(String tag, String text) {
        return findByText(driver, tag, text);
    }

    public WebElement findByText(SearchContext parent, String tag, String text) {
        return internalFinders.findByText(parent, tag, text);
    }

    public void clickByText(String tag, String text) {
        clickByText(driver, tag, text);
    }

    public void clickByText(SearchContext parent, String tag, String text) {
        internalFinders.findByText(parent, tag, text).click();
    }

    public void setTextByLabel(String name, String text) {
        setTextByLabel(driver, name, text);
    }

    public void setTextByLabel(SearchContext parent, String name, String text) {
        internalFinders.setText(internalFinders.findByLabel(parent, name), text);
    }

    public void selectByLabel(String name, String option) {
        selectByLabel(driver, name, option);
    }

    public void selectByLabel(SearchContext parent, String name, String option) {
        internalFinders.select(internalFinders.findByLabel(parent, name), option);
    }

    public void chooseByLabel(String name) {
        chooseByLabel(driver, name);
    }

    public void chooseByLabel(SearchContext parent, String name) {
        internalFinders.choose(internalFinders.findByLabel(parent, name));
    }

    public void clickByValue(String value) {
        clickByValue(driver, value);
    }

    public void clickByValue(SearchContext parent, String value) {
        internalFinders.findByValue(parent, value).click();
    }

    public WebElement findParentByClassName(SearchContext element, String tag, String className) {
        return internalFinders.findParentByClassName(element, tag, className);
    }

    public WebElement findByName(String tag, String name) {
        return findByName(driver, tag, name);
    }

    public WebElement findByName(SearchContext parent, String tag, String name) {
        return internalFinders.findByName(parent, tag, name);
    }

    public void setTextByName(String name, String text) {
        setTextByName(driver, name, text);
    }

    public void setTextByName(SearchContext parent, String name, String text) {
        internalFinders.setText(internalFinders.findByName(parent, "input", name), text);
    }

    public void setTextByClassName(String className, String text) {
        setTextByClassName(driver, className, text);
    }

    public void setTextByClassName(SearchContext parent, String className, String text) {
        internalFinders.setText(internalFinders.findByClassName(parent, className), text);
    }

    public void clickByTagName(String tagName) {
        clickByTagName(driver, tagName);
    }

    public void clickByTagName(SearchContext parent, String tagName) {
        internalFinders.findByTagName(parent, tagName).click();
    }
}
