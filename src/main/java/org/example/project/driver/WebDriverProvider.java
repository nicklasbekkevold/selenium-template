package org.example.project.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.project.utils.StepLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public final class WebDriverProvider {

    private static final Duration PAGE_LOAD_TIMEOUT = Duration.of(30, ChronoUnit.SECONDS);
    private static final Duration IMPLICIT_WAIT_TIMEOUT = Duration.of(10, ChronoUnit.SECONDS);
    private final static Browser DEFAULT_BROWSER = Browser.CHROMIUM;

    private WebDriverProvider() {
    }

    public static WebDriver createDriver() {
        return createDriver(DEFAULT_BROWSER, new DesiredCapabilities());
    }

    public static WebDriver createDriver(Browser browser) {
        return createDriver(browser, new DesiredCapabilities());
    }

    public static WebDriver createDriver(Browser browser, DesiredCapabilities capabilities) {
        capabilities.setBrowserName(browser.toString());
        WebDriver driver = null;
        switch (browser) {
            case CHROMIUM -> {
                WebDriverManager.chromiumdriver().setup();
                ChromeOptions options = new ChromeOptions();

                // Add options
                options.addArguments("--headless");
                options.addArguments("--disable-gpu");
                options.addArguments("--window-size=1920,1200");
                options.addArguments("--ignore-certificate-errors");
                options.addArguments("--disable-extensions");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");

                options.merge(capabilities);
                driver = new ChromeDriver(options);
            }
            case CHROME -> {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.merge(capabilities);
                driver = new ChromeDriver(options);
            }
            case FIREFOX -> {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options = new FirefoxOptions();
                options.merge(capabilities);
                driver = new FirefoxDriver(options);
            }
            case EDGE -> {
                System.setProperty("webdriver.edge.driver", "./drivers/msedgedriver_107.0.1418.26.exe");
                EdgeOptions options = new EdgeOptions();
                options.merge(capabilities);
                driver = new EdgeDriver(options);
            }
            default -> {
                StepLogger.info("Browser not recognized, switching to default browser " + DEFAULT_BROWSER);
                createDriver(DEFAULT_BROWSER, capabilities);
            }
        }

        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT);
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIMEOUT);
        driver.manage().window().maximize();

        return driver;
    }

}
