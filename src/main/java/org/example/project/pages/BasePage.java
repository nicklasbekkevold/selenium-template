package org.example.project.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.LoadableComponent;

import java.util.List;

public abstract class BasePage extends LoadableComponent<BasePage> {

    private static final int HALF_A_SECOND = 500; // ms
    private static final int ONE_SECOND = 1000; // ms
    private static final int TEN_SECONDS = 10000; // ms

    private final WebDriver driver;
    private final JavascriptExecutor executor;

    public BasePage(WebDriver driver) {
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
        Actions action = new Actions(driver);
        executor.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
    }

}
