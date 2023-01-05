package org.example.project.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class PageLoadHelper {

    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(5);

    private final WebDriver driver;
    private Duration timeout;

    public PageLoadHelper(WebDriver driver) {
        this.driver = driver;
        timeout = DEFAULT_TIMEOUT;
    }

    public PageLoadHelper withDuration(final Duration duration) {
        this.timeout = duration;
        return this;
    }

    public PageLoadHelper checkIfVisible(final WebElement element) throws WebDriverException {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
        return this;
    }

    public PageLoadHelper checkIfClickable(final WebElement element) throws WebDriverException {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
        return this;
    }
}
