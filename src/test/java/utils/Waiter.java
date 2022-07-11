package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiter {
    /**
     *   Hard pauses meant for debugging only.
     *   Check usages if there exist any use cases that can be removed.
     */
    public static void pause(double seconds){
        try {
            Thread.sleep((long) (seconds * 1000L));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void forTextVisibility(WebDriver driver, WebElement element){
        new WebDriverWait(driver, Long.parseLong(ConfigReader.getProperty("explicitWait")))
                .until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Used as an alternative to the method above that uses wait times from the 'config.properties'. This method is for
     * situations where driver is loaded landing page but has element visibility blocked momentarily.
     * Ex. Second scenario in 'carvana.feature' navigates webdriver to 'VIN landing page' that animates loading of page,
     * obstructing the full page loaded elements, causing NoSuchElementExceptions.
     */
    public static void forTextVisibility(WebDriver driver, WebElement element, long seconds){
        new WebDriverWait(driver, seconds)
                .until(ExpectedConditions.visibilityOf(element));
    }

    public static void forClickable(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Long.parseLong(ConfigReader.getProperty("explicitWait")))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void forUrl(WebDriver driver, String url) {
        new WebDriverWait(driver, Long.parseLong(ConfigReader.getProperty("explicitWait")))
                .until(ExpectedConditions.urlToBe(url));
    }
}
