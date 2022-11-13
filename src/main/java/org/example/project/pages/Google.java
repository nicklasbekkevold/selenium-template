package org.example.project.pages;

import org.example.project.fragments.GoogleSearchBar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public final class Google extends BasePage {

    private final Page page = Page.GOOGLE;
    private final WebDriver driver;

    private GoogleSearchBar searchBar;

    public Google(WebDriver driver) {
        super(driver);
        this.driver = driver;
        searchBar = new GoogleSearchBar(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    protected void load() {
        driver.get(page.getUrl());
    }

    @Override
    protected void isLoaded() throws Error {
        searchBar.get();
    }
}
