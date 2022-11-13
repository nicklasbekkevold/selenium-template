package org.example.project.fragments;

import org.example.project.utils.LoadCheck;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class GoogleSearchBar extends LoadableComponent<GoogleSearchBar> {

    private final WebDriver driver;

    private WebElement input;
    private WebElement matches;
    private WebElement selected;

    public GoogleSearchBar(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        LoadCheck
                .waitForWithDriver(5, driver)
                .untilElementVisible(input);
    }

    public void search(final String query) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(input));
        input.clear();
        input.sendKeys(query);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(selected));
        selected.click();
    }
}
