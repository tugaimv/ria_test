package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CalculatorPage {

    private static CalculatorPage calculatorPage;

    private final By fuelTypeSelect = By.cssSelector("#leftFilterFuel");
    private final By countryOfOriginSelect = By.cssSelector("#leftFilterOrigin");
    private final By ageOfTheCarSelect = By.cssSelector("#leftFilterAge");
    private final By costOfTheCarAbroadInput = By.cssSelector("[name='price']");
    private final By volumeOfTheEngineInput = By.cssSelector("[name='engine']");
    private final By calculateBtn = By.cssSelector("#catalogsCustomCalculator button");
    private final By costOfACarWithCustomClearanceSpan = By.cssSelector(".calc-table li:nth-child(5) .casual");

    private CalculatorPage(){}

    public static CalculatorPage getInstance(){
        if(calculatorPage == null){
            calculatorPage = new CalculatorPage();
        }
        return calculatorPage;
    }

    private void initializeAndSelectOption(WebDriver driver, By selectLocator, String selectValue){
        WebElement selectElement = driver.findElement(selectLocator);
        Select select = new Select(selectElement);
        select.selectByValue(selectValue);
    }

    public By getCostOfACarWithCustomClearanceSpan() {
        return costOfACarWithCustomClearanceSpan;
    }

    @Step("Open page")
    public void open(WebDriver driver){
        driver.get("https://auto.ria.com/uk/rastamozhka-avto/calculator/");
    }
    @Step("Choosing gas type")
    public void chooseGas(WebDriver driver, String selectValue){
        initializeAndSelectOption(driver, fuelTypeSelect, selectValue);
    }
    @Step("Choosing country of origin")
    public void chooseCountryOfOrigin(WebDriver driver, String selectValue){
        initializeAndSelectOption(driver, countryOfOriginSelect, selectValue);
    }
    @Step("Choosing age of the car")
    public void chooseAgeOfTheCarSelect(WebDriver driver, String selectValue){
        initializeAndSelectOption(driver, ageOfTheCarSelect, selectValue);
    }
    @Step("Filling cost of the car")
    public void fillCostOfTheCarAbroad(WebDriver driver, String price){
        driver.findElement(costOfTheCarAbroadInput).sendKeys(price);
    }
    @Step("Filling volume of the engine")
    public void fillVolumeOfTheEngine(WebDriver driver, String volume){
        driver.findElement(volumeOfTheEngineInput).sendKeys(volume);
    }
    @Step("Click on the calculate btn")
    public void calculate(WebDriver driver){
        driver.findElement(calculateBtn).click();
    }

}
