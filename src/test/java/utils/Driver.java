package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    private Driver(){}

    private static WebDriver driver;

    /**
     *          THESE CHROME OPTIONS ARE ATTEMPTS TO HIDE AUTOMATION DETECTION ON CARVANA
     *
     *       ChromeOptions options = new ChromeOptions();
     *       options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
     *       options.addArguments("--disable-blink-features=AutomationControlled");
     *       options.addArguments("--disable-web-security"); // don't enforce the same-origin policy
     *       options.addArguments("disable-site-isolation-trials");
     *       options.addArguments("headless");
     */

    public static WebDriver getDriver(){
        if (driver == null) {
            String browser = ConfigReader.getProperty("browser");
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().version("102").setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "safari":
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driver = new SafariDriver();
                    break;
                case "headless":
                    driver = new HtmlUnitDriver();
                    break;
                default:
                    throw new NotFoundException("Browser driver failed to setup! Check config or 'getDriver()'!!");
            }
            if (!browser.equals("headless")) {
                setDriverWindow(ConfigReader.getProperty("window"));
                setTimeouts();
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
            driver = null;
        }
    }

    public static void setDriverWindow(String key) {
        if (key.contains("max")) driver.manage().window().maximize();
        else if (key.contains("full")) driver.manage().window().fullscreen();
        else driver.manage().window().setSize(new Dimension(960, 540)); // tablet window size
    }

    /**
     * Mixing implicit waits with the added explicitWaits from Waiter utility class can produce inconsistent wait times.
     *      - PageLoadTimeout handles page loading well enough to avoid StaleElementException sync issues but Javascript
     *          nodes or any animation changes will after page is loaded can still produce these sync errors.
     *      - ImplicitWait is meant to find elements the first time, but any changes in a DOM once its been loaded, does
     *          not call the AJAX POM factory to find the elements again, throwing a StaleElementException.
     *      - ImplicitWait struggles with finding elements not meant to be there anymore, for the same reason above.
     *
     *      - ExplicitWaits from custom Waiter utility class as well as step classes are meant to test different
     *          StaleElementException workarounds for the reasons listed above.
     */

    public static void setTimeouts() {
        driver.manage().timeouts().pageLoadTimeout(Long.parseLong(ConfigReader.getProperty("pageWait")), TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Long.parseLong(ConfigReader.getProperty("implicitWait")), TimeUnit.SECONDS);
    }
}
