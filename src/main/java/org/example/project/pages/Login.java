package org.example.project.pages;

import org.example.project.environment.WebResource;
import org.example.project.utils.Credentials;
import org.example.project.utils.PageLoadHelper;
import org.example.project.utils.StepLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public final class Login extends Page {

    private final WebResource webResource = null; // TODO
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
        driver.get(webResource.getUrl());
    }

    @Override
    protected void isLoaded() throws Error {
        new PageLoadHelper(driver)
                .withDuration(Duration.ofSeconds(10))
                .checkIfVisible(username)
                .checkIfVisible(password);
    }

    public void login() {
        // Generating Login URL and login
        String url = "https://" + Credentials.USERNAME + ":" + Credentials.PASSWORD + "@" + WebResource.GOOGLE.getUrl();
        StepLogger.info("Login into page");
        driver.get(url);
    }

}
