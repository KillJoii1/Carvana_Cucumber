package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CarvanaAutoLoanCalculatorPage;
import pages.CarvanaCarFinderPage;
import pages.CarvanaHomePage;
import pages.CarvanaSellTradePage;
import utils.ConfigReader;
import utils.Driver;
import utils.Waiter;

public class Hooks {
    public static WebDriver driver;
    public static CarvanaHomePage carvanaHomePage;
    public static CarvanaSellTradePage carvanaSellTradePage;
    public static CarvanaCarFinderPage carvanaCarFinderPage;
    public static CarvanaAutoLoanCalculatorPage carvanaAutoLoanCalculatorPage;

    @Before
    public void setup() {
        driver = Driver.getDriver();
        carvanaHomePage = new CarvanaHomePage();
        carvanaSellTradePage = new CarvanaSellTradePage();
        carvanaCarFinderPage = new CarvanaCarFinderPage();
        carvanaAutoLoanCalculatorPage = new CarvanaAutoLoanCalculatorPage();
    }

    @After
    public void teardown(Scenario scenario){
        try{
            if(scenario.isFailed()){
                byte[] screenshot = ((TakesScreenshot) Driver.getDriver())
                        .getScreenshotAs(OutputType.BYTES);

                scenario.embed(screenshot, "image/png");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Driver.quitDriver();
        }
    }
}
