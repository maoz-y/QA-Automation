package pageObjects.Parabank;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RequestLoanPage {

    @FindBy(how = How.ID, using = "amount")
    public WebElement txt_amount;

    @FindBy(how = How.ID, using = "downPayment")
    public WebElement txt_downPayment;

    @FindBy(how = How.ID, using = "fromAccountId")
    public WebElement DD_fromAccount;

    @FindBy(how = How.CSS, using = "input[value='Apply Now']")
    public WebElement btn_apply;

    @FindBy(how = How.XPATH, using = "//div[@id='rightPanel']/div/div/div/p[1]")
    public WebElement txt_aprroveloan;
}
