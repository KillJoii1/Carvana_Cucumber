package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.Hooks;

public class CarvanaCarFinderPage {

    public CarvanaCarFinderPage() {
        PageFactory.initElements(Hooks.driver, this);
    }

    @FindBy(css = ".leftSide>h1")
    public WebElement heading1;

    @FindBy(css = ".leftSide>h3")
    public WebElement heading3;

    @FindBy(css = "a[data-qa='router-link']")
    public WebElement tryCarFinderLink;

    @FindBy(css = "div[data-qa='headline']")
    public WebElement headline;

    @FindBy(css = "div[data-qa='sub-heading']")
    public WebElement subHeadline;

    @FindBy(css = "div[class*='kjhwtS']")
    public WebElement offerHeader;

    @FindBy(css = "div[class*='lnhlkr']")
    public WebElement offerSubHeader;
}
