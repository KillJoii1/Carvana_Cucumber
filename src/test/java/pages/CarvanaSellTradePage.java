package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.Hooks;

public class CarvanaSellTradePage {

    public CarvanaSellTradePage() {
        PageFactory.initElements(Hooks.driver, this);
    }

    @FindBy(css = "button[data-cv-test='VINToggle']")
    public WebElement vinButton;

    @FindBy(css = "input[class]")
    public WebElement vinInput;

    @FindBy(css = "button[data-cv-test='heroGetMyOfferButton']")
    public WebElement getOfferButton;

    @FindBy(css = "div[class*='kjoUgV']")
    public WebElement invalidVinText;
}
