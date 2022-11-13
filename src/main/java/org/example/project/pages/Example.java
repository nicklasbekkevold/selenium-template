package org.example.project.pages;

import org.example.project.utils.LoadCheck;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class Example extends BasePage {

    private final Page page = Page.EXAMPLE;
    private final WebDriver driver;

    private WebElement button_element;
    private WebElement message;
    private WebElement image_element;
    private WebElement radio3_element;

    public Example(WebDriver driver) {
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
                .untilElementVisible(image_element)
                .untilElementClickable(button_element);
    }

    public String getInteractionMessage() {
        return message.getText();
    }

    public void clickOnFormButton() {
        new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.elementToBeClickable(button_element));
        click(button_element);
    }

    public void clickOnImage() {
        click(image_element);
    }

    public void clickOnRadioButtonThree() {
        click(radio3_element);
    }

}
