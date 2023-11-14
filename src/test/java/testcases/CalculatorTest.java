package testcases;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.CalculatorPage;

import java.time.Duration;

public class CalculatorTest extends BaseTest {

    @Test(description = "Checking the cost of a car with customs clearance")
    public void checkingTheValueOfTheCarWithCustomClearance() {
        CalculatorPage.getInstance().open(driver);
        CalculatorPage.getInstance().chooseGas(driver, "1");
        CalculatorPage.getInstance().chooseCountryOfOrigin(driver, "2");
        CalculatorPage.getInstance().chooseAgeOfTheCarSelect(driver, "lt2");
        CalculatorPage.getInstance().fillCostOfTheCarAbroad(driver, "3500");
        CalculatorPage.getInstance().fillVolumeOfTheEngine(driver, "1500");
        CalculatorPage.getInstance().calculate(driver);

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.
                textToBePresentInElementLocated(CalculatorPage.getInstance().getCostOfACarWithCustomClearanceSpan(), "4649"));
    }
}
