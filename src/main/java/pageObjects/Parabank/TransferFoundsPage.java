package pageObjects.Parabank;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TransferFoundsPage {

    @FindBy(how = How.ID, using = "amount")
    public WebElement txt_amount;

    @FindBy(how = How.ID, using = "fromAccountId")
    public WebElement DD_fromAccount;

    @FindBy(how = How.ID, using = "toAccountId")
    public WebElement DD_toAccount;

    @FindBy(how = How.XPATH, using = "//input[@value='Transfer']")
    public WebElement btn_transfer;

    @FindBy(how = How.XPATH, using = "//div[@class='ng-scope']/div/h1")
    public WebElement transferIsDone;

}
