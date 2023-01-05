package org.example.project.pages;

import org.example.project.environment.WebResource;
import org.example.project.utils.PageLoadHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class Example extends Page {

    private final WebResource webResource = WebResource.EXAMPLE;
    private final WebDriver driver;

    private WebElement button_element;
    private WebElement message;
    private WebElement image_element;
    private WebElement radio3_element;
    private WebElement checkbox2_element;

    public Example(WebDriver driver) {
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
                .checkIfClickable(button_element)
                .checkIfVisible(image_element);
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

    public void clickOnCheckboxTwo() {
        click(checkbox2_element);
    }

}
