package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import utils.Waiter;

public class BaseSteps {

    @Given("user is on {string}")
    public void userIsOn(String url) {
        Hooks.driver.get(url);
    }

    @Then("user should be navigated to {string}")
    public void userShouldBeNavigatedTo(String url) {
        Waiter.forUrl(Hooks.driver, url);
        Assert.assertEquals(url, Hooks.driver.getCurrentUrl());
    }
}
