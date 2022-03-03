package pageObjects.Calculator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage {

    @FindBy(how = How.NAME, using = "One")
    public WebElement btn_1;

    @FindBy(how = How.NAME, using = "Seven")
    public WebElement btn_7;

    @FindBy(how = How.NAME, using = "Nine")
    public WebElement btn_nine;

    @FindBy(how = How.NAME, using = "Plus")
    public WebElement btn_plus;

    @FindBy(how = How.NAME, using = "Multiply by")
    public WebElement btn_multiply;

    @FindBy(how = How.NAME, using = "Equals")
    public WebElement btn_equals;

    @FindBy(how = How.NAME, using = "Clear")
    public WebElement btn_clear;

    @FindBy(how = How.XPATH, using = "//*[@AutomationId='CalculatorResults']")
    public WebElement filed_result;


}
