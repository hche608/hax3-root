package me.hax3.selenium.finders;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Selects {

    public Select create(WebElement element) {
        return new Select(element);
    }
}
