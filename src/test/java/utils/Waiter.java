package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.Hooks;

public class Waiter {
    private static WebDriverWait waiter;

    private Waiter() {}

    public static WebDriverWait getWaiter() {
        if (waiter == null) {
            waiter = new WebDriverWait(Hooks.driver, Long.parseLong(ConfigReader.getProperty("explicitWait")));
        }
        return waiter;
    }

    public static void quitWaiter() {
        waiter = null;
    }
    /**
     * For debugging purposes only!
     */
    public static void pause(double seconds){
        try {
            Thread.sleep((long) (seconds * 1000L));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static WebElement forTextVisibility(WebElement element){
        waiter.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public static WebElement forClickable(WebElement element) {
        waiter.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    public static void isHoverable(WebElement element) {
        waiter.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void forUrl(String url) {
        waiter.until(ExpectedConditions.urlToBe(url));
    }
}
