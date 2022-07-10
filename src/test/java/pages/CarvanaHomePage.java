package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.Hooks;
import utils.Waiter;

import java.util.List;

public class CarvanaHomePage {
    public CarvanaHomePage() {
        PageFactory.initElements(Hooks.driver, this);
    }

//    @FindAll({
//            @FindBy(css = "div[data-qa='header-items'] a"),
//            @FindBy(css = "div[data-cv-test='headerFinanceDropdown']"),
//            @FindBy(css = "a[data-cv-test*='headerFinance']")
//    })
    @FindBy(css = "div[data-qa='header-items'] a")
    public List<WebElement> headerItems;

    public void clickHeaderItem(String itemText) {
        for (WebElement e : headerItems) {
            if (e.getText().equals(itemText)) {
                Waiter.forClickable(e).click();
                break;
            }
        }
    }

    public void hoverHeaderItem(String itemText) {
        for (WebElement e : headerItems) {
            if (e.getText().equals(itemText)) {
                Waiter.isHoverable(e);
                new Actions(Hooks.driver).moveToElement(e).perform();
                break;
            }
        }
    }

//    @FindBy(css = "a[data-cv-test*='headerFinance']")
//    public List<WebElement> financeItems;
//
//    public void clickFinanceItem(String itemText) {
//        for (WebElement e : financeItems) {
//            if (e.getText().equals(itemText)) {
//                e.click();
//                break;
//            }
//        }
//    }
}
