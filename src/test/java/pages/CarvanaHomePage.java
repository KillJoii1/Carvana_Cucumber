package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.Hooks;
import utils.ConfigReader;
import utils.Waiter;

import java.util.List;

public class CarvanaHomePage {
    public CarvanaHomePage() {
        PageFactory.initElements(Hooks.driver, this);
    }
    private final int defaultStaleCheckCounter = Integer.parseInt(ConfigReader.getProperty("staleCheckCounter"));
    public int staleCheckCounter = defaultStaleCheckCounter;

    @FindBy(css = "div[data-qa='header-items'] a")
    public List<WebElement> headerItems;

    public void clickHeaderItem(String itemText) {
        if (staleCheckCounter == 0) throw new RuntimeException("Stale check failed!");
        for (WebElement element : headerItems) {
            try {
                if (element.getText().equals(itemText)) {
                    Waiter.forClickable(Hooks.driver, element);
                    element.click();
                    staleCheckCounter = defaultStaleCheckCounter;
                    break;
                }
            } catch (StaleElementReferenceException e) {
                resolveListStale();
                staleCheckCounter--;
                clickHeaderItem(itemText);
            }
        }
    }

    public void hoverHeaderItem(String itemText) {
        if (staleCheckCounter == 0) throw new RuntimeException("Stale check failed!");
        for (WebElement element : headerItems) {
            try {
                if (element.getText().equals(itemText)) {
                    Waiter.forClickable(Hooks.driver, element);
                    new Actions(Hooks.driver).moveToElement(element).perform();
                    staleCheckCounter = defaultStaleCheckCounter;
                    break;
                }
            } catch (StaleElementReferenceException e) {
                resolveListStale();
                staleCheckCounter--;
                hoverHeaderItem(itemText);
            }
        }
    }

    /**
     *  A hardcoded solution to getting the list of headerItems to refresh when we catch StaleElementReferenceException
     */
    public void resolveListStale() {
        new WebDriverWait(Hooks.driver, Long.parseLong(ConfigReader.getProperty("explicitWait")))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div[data-qa='header-items'] a")));
    }
}
