package org.example.project.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.LoadableComponent;

import java.util.List;

public abstract class Page extends LoadableComponent<Page> {

    private final WebDriver driver;
    private final JavascriptExecutor executor;

    public Page(WebDriver driver) {
        this.driver = driver;
        executor = (JavascriptExecutor) driver;
    }

    public List<WebElement> find(final By locator) {
        return driver.findElements(locator);
    }

    public void click(final WebElement element) {
        element.click();
    }

    public void clearAndType(final WebElement input, final String text) {
        input.clear();
        input.sendKeys(text);
    }

    public boolean doesElementHaveCssPropertyWithValue(final WebElement element, final String propertyName, final String expectedValue) {
        return element.getCssValue(propertyName).equals(expectedValue);
    }

    public boolean isElementDisplayed(final WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isEnabled(final WebElement element) {
        boolean enabled = element.isEnabled();
        boolean classDisabled = element.getAttribute("class").contains("disabled");
        boolean classAriaDisabled = element.getAttribute("aria-disabled").contains("true");
        return enabled && !classDisabled && !classAriaDisabled;
    }

    public void hoverOverElement(WebElement element) {
        executor.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
    }

}
