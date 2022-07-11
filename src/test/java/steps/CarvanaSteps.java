package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NotFoundException;
import utils.DropDownHandler;
import utils.Waiter;

import static steps.Hooks.carvanaCarFinderPage;
import static steps.Hooks.carvanaHomePage;
import static steps.Hooks.carvanaSellTradePage;
import static steps.Hooks.carvanaAutoLoanCalculatorPage;

public class CarvanaSteps {

    @When("user clicks on {string} menu item")
    public void userClicksOnMenuItem(String menuText) {
        switch (menuText) {
            case "SEARCH CARS":
            case "CAR FINDER":
            case "SELL/TRADE":
            case "FINANCING":
            case "WHY FINANCE WITH CARVANA":
            case "GET PREQUALIFIED":
            case "AUTO LOAN CALCULATOR":
                carvanaHomePage.clickHeaderItem(menuText);
                break;
            default: throw new NotFoundException("Feature file text was invalid!!");
        }
    }

    @And("user should see {string} text")
    public void userShouldSeeText(String text) {
        switch (text) {
            case "WHAT CAR SHOULD I GET?":
                Assert.assertEquals(text, carvanaCarFinderPage.heading1.getText());
                break;
            case "Car Finder can help! Answer a few quick questions to find the right car for you.":
                Assert.assertEquals(text, carvanaCarFinderPage.heading3.getText());
                break;
            case "WHAT IS MOST IMPORTANT TO YOU IN YOUR NEXT CAR?":
                Assert.assertEquals(text, carvanaCarFinderPage.headline.getText());
                break;
            case "Select up to 4 in order of importance":
                Assert.assertEquals(text, carvanaCarFinderPage.subHeadline.getText());
                break;
            case "GET A REAL OFFER IN 2 MINUTES":
                Assert.assertEquals(text, carvanaCarFinderPage.offerHeader.getText());
                break;
            case "We pick up your car. You get paid on the spot.":
                Assert.assertEquals(text, carvanaCarFinderPage.offerSubHeader.getText());
                break;
            case "We couldn’t find that VIN. Please check your entry and try again.":
                Waiter.forTextVisibility(Hooks.driver, carvanaSellTradePage.invalidVinText, 10);
                Assert.assertEquals(text, carvanaSellTradePage.invalidVinText.getText());
                break;
            default: throw new NotFoundException("Feature file text was invalid!!");
        }
    }

    @And("user should see {string} link")
    public void userShouldSeeLink(String linkText) {
        switch (linkText) {
            case "TRY CAR FINDER":
                Waiter.forTextVisibility(Hooks.driver, carvanaCarFinderPage.tryCarFinderLink);
                Assert.assertEquals(linkText, carvanaCarFinderPage.tryCarFinderLink.getText());
                break;
            default: throw new NotFoundException("Feature file link text was invalid!!");
        }
    }

    @When("user clicks on {string} link")
    public void userClicksOnLink(String link) {
        switch (link) {
            case "TRY CAR FINDER":
                Waiter.forClickable(Hooks.driver, carvanaCarFinderPage.tryCarFinderLink);
                carvanaCarFinderPage.tryCarFinderLink.click();
                break;
            default: throw new NotFoundException("Feature file link text was invalid!!");
        }
    }

    @When("user clicks on {string} button")
    public void userClicksOnButton(String buttonText) {
        switch (buttonText) {
            case "VIN":
                Waiter.forClickable(Hooks.driver, carvanaSellTradePage.vinButton);
                carvanaSellTradePage.vinButton.click();
                break;
            case "GET MY OFFER":
                Waiter.forClickable(Hooks.driver, carvanaSellTradePage.getOfferButton);
                carvanaSellTradePage.getOfferButton.click();
                break;
            default: throw new NotFoundException("Feature file button text was invalid!!");
        }
    }

    @And("user enters vin number as {string}")
    public void userEntersVinNumberAs(String number) {
        Assert.assertTrue(carvanaSellTradePage.vinInput.isEnabled());
        carvanaSellTradePage.vinInput.sendKeys(number);
    }

    @When("user hovers over on {string} menu item")
    public void userHoversOverOnMenuItem(String itemText) {
        switch (itemText) {
            case "FINANCING":
                carvanaHomePage.hoverHeaderItem(itemText);
                break;
            default: throw new NotFoundException("Feature file menu text was invalid!!");
        }
    }

    @And("user selects {string} for {string}")
    public void userSelectsFor(String value, String dropdownText) {
        switch  (dropdownText) {
            case "What's Your Credit Score?":
                Assert.assertEquals(dropdownText, carvanaAutoLoanCalculatorPage.creditScoreLabel.getText());
                DropDownHandler.selectOptionByText(carvanaAutoLoanCalculatorPage.creditScoreInput, value);
                break;
            case "Choose Your Loan Term":
                Assert.assertEquals(dropdownText, carvanaAutoLoanCalculatorPage.loanTermLabel.getText());
                DropDownHandler.selectOptionByText(carvanaAutoLoanCalculatorPage.loanTermInput, value);
                break;
            default: throw new NotFoundException("Feature file field or text was invalid!!");
        }
    }

    @And("user enters {string} for {string}")
    public void userEntersFor(String value, String fieldText) {
        switch  (fieldText) {
            case "Cost of Car I want":
                Assert.assertEquals(fieldText, carvanaAutoLoanCalculatorPage.carCostLabel.getText());
                carvanaAutoLoanCalculatorPage.carCostInput.sendKeys(value);
                break;
            case "What is Your Down Payment?":
                Assert.assertEquals(fieldText, carvanaAutoLoanCalculatorPage.downPaymentLabel.getText());
                carvanaAutoLoanCalculatorPage.downPaymentInput.sendKeys(value);
                break;
            default: throw new NotFoundException("Feature file field text was invalid!!");
        }
    }

    @Then("user should see the monthly payment as {string}")
    public void userShouldSeeTheMonthlyPaymentAs(String total) {
        Assert.assertEquals(total, carvanaAutoLoanCalculatorPage.monthlyPaymentDisplayText.getText());
    }
}
    