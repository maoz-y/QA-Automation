package pageObjects.Parabank;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LeftPanelPage {

    @FindBy(how = How.LINK_TEXT, using = "Open New Account")
    public WebElement btn_newAccount;

    @FindBy(how = How.LINK_TEXT, using = "Transfer Funds")
    public WebElement btn_transferFounds;

    @FindBy(how = How.LINK_TEXT, using = "Request Loan")
    public WebElement btn_requestLoan;
}
