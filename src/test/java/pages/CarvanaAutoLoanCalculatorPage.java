package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.Hooks;

public class CarvanaAutoLoanCalculatorPage {

    public CarvanaAutoLoanCalculatorPage() {
        PageFactory.initElements(Hooks.driver, this);
    }

    @FindBy(css = "div[class='loan-calculator-display-value']")
    public WebElement monthlyPaymentDisplayText;

    @FindBy(css = "div[class*='floating-text']:nth-child(1)>span")
    public WebElement carCostLabel;

    @FindBy(css = "div[class*='floating-text']:nth-child(1) input")
    public WebElement carCostInput;

    @FindBy(css = "div[class*='floating-text']:nth-child(2)>span")
    public WebElement creditScoreLabel;

    @FindBy(id = "creditBlock")
    public WebElement creditScoreInput;

    @FindBy(css = "div[class*='floating-text']:nth-child(3)>span")
    public WebElement loanTermLabel;

    @FindBy(css = "select[name='loanTerm']")
    public WebElement loanTermInput;

    @FindBy(css = "div[class*='floating-text']:nth-child(4)>span")
    public WebElement downPaymentLabel;

    @FindBy(css = "div[class*='floating-text']:nth-child(4) input")
    public WebElement downPaymentInput;
}
