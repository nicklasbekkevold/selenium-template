package org.example.project.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class LoadCheck {

    private final int waitForSeconds;
    private final WebDriver driver;

    private LoadCheck(int waitForSeconds, final WebDriver driver) {
        this.waitForSeconds = waitForSeconds;
        this.driver = driver;
    }

    public static LoadCheck waitForWithDriver(int seconds, final WebDriver driver) {
        return new LoadCheck(seconds, driver);
    }

    public LoadCheck untilElementVisible(final WebElement element) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(waitForSeconds)).until(ExpectedConditions.visibilityOf(element));
            return this;
        } catch (WebDriverException e) {
            throw new Error("Element is not visible");
        }
    }

    public LoadCheck untilElementClickable(final WebElement element) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(waitForSeconds)).until(ExpectedConditions.elementToBeClickable(element));
            return this;
        } catch (WebDriverException e) {
            throw new Error("Element is not visible");
        }
    }
}
