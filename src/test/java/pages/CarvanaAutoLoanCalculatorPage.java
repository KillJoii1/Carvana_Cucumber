package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.Hooks;

import java.util.List;

public class CarvanaAutoLoanCalculatorPage {

    public CarvanaAutoLoanCalculatorPage() {
        PageFactory.initElements(Hooks.driver, this);
    }

    @FindBy(css = "div[class='loan-calculator-display-value']")
    public WebElement monthlyPaymentDisplayText;

    @FindAll({
            @FindBy(css = "div[class*='floating-text']:nth-child(1)>span"),
            @FindBy(css = "div[class*='floating-text']:nth-child(1) input")
    })
    public List<WebElement> carCostField;

    @FindAll({
            @FindBy(css = "div[class*='floating-text']:nth-child(2)>span"),
            @FindBy(id = "creditBlock")
    })
    public List<WebElement> creditScoreField;

    @FindAll({
            @FindBy(css = "div[class*='floating-text']:nth-child(3)>span"),
            @FindBy(css = "select[name='loanTerm']")
    })
    public List<WebElement> loanTermField;

    @FindAll({
            @FindBy(css = "div[class*='floating-text']:nth-child(4)>span"),
            @FindBy(css = "div[class*='floating-text']:nth-child(4) input")
    })
    public List<WebElement> downPaymentField;
}
