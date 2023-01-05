package org.example.project.fragments;

import org.example.project.utils.PageLoadHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public final class GoogleResults extends LoadableComponent<GoogleResults> {

    private final WebDriver driver;
    private WebElement results;

    @FindBy(className = "result")
    private List<WebElement> search_results;

    public GoogleResults(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        new PageLoadHelper(driver)
                .checkIfVisible(results);
    }

    public void getResult(int index) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(results));
        search_results.get(index);
    }
}
