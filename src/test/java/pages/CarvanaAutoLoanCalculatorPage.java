package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class AutoLoanCalculatorPage {

    public AutoLoanCalculatorPage() {
        PageFactory.initElements(Driver.getDriver(), this);
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
