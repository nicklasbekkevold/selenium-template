package org.example.project.pages;

import org.example.project.utils.Credentials;
import org.example.project.utils.LoadCheck;
import org.example.project.utils.StepLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public final class Login extends BasePage {

    private final Page page = null; // TODO
    private final WebDriver driver;

    private WebElement username;
    private WebElement password;

    public Login(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Override
    protected void load() {
        driver.get(page.getUrl());
    }

    @Override
    protected void isLoaded() throws Error {
        LoadCheck
                .waitForWithDriver(10, driver)
                .untilElementVisible(username)
                .untilElementVisible(password);
    }

    public void login() {
        // Generating Login URL and login
        String url = "https://" + Credentials.USERNAME + ":" + Credentials.PASSWORD + "@" + Page.GOOGLE.getUrl();
        StepLogger.info("Login into page");
        driver.get(url);
    }

}
