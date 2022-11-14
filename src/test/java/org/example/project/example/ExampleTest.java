package org.example.project.example;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Issue;
import io.qameta.allure.Step;
import org.example.project.SeleniumTest;
import org.example.project.driver.WebDriverProvider;
import org.example.project.pages.Example;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Issue("1")
@Epic("Example tests")
public final class ExampleTest implements SeleniumTest {

    private WebDriver driver;
    private Example example;

    @Override
    public WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void setup() {
        driver = WebDriverProvider.createDriver();
        example = new Example(driver);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test(description = "Verify button interaction")
    @Description("Verify that a the correct message is shown when the form button is clicked")
    public void testButton() {
        openExamplePage();
        clickOnFormButton();
        verifyInteractionMessage("Button Clicked");
    }

    @Test(description = "Verify Java image interaction")
    @Description("Verify that a the correct message is shown when the image is clicked")
    public void testImage() {
        openExamplePage();
        clickOnImage();
        verifyInteractionMessage("Image Clicked");
    }

    @Test(description = "Verify radio button interaction")
    @Description("Verify that a the correct message is shown when the radio buttons change")
    public void testRadioButton() {
        openExamplePage();
        clickOnRadioButtonThree();
        verifyInteractionMessage("Radio Button Changed");
    }

    @Test(description = "Verify check box interaction")
    @Description("Verify that a the correct message is shown when the check boxes change")
    public void testCheckbox() {
        openExamplePage();
        clickOnCheckboxTwo();
        verifyInteractionMessage("Checkbox Changed");
    }

    @Test(description = "Failed test example")
    void testShouldFail() {
        assertTrue(false);
    }

    @Step("Open example page")
    private void openExamplePage() {
        example.get();
    }

    @Step("Click on form button")
    private void clickOnFormButton() {
        example.clickOnFormButton();
    }

    @Step("Click on image")
    private void clickOnImage() {
        example.clickOnImage();
    }

    @Step("Click on radio button 3")
    private void clickOnRadioButtonThree() {
        example.clickOnRadioButtonThree();
    }

    @Step("Click on check box 2")
    private void clickOnCheckboxTwo() {
        example.clickOnCheckboxTwo();
    }

    @Step("Verify that the interaction message is: \"{0}\"")
    private void verifyInteractionMessage(String expectedInteractionMessage) {
        assertEquals(example.getInteractionMessage(), expectedInteractionMessage);
    }

}
