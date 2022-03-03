package pageObjects.Parabank;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class OpenNewAccountPage {

    @FindBy(how = How.ID, using = "type")
    public WebElement DD_accountType;

    @FindBy(how = How.ID, using = "fromAccountId")
    public WebElement DD_fromAccount;

    @FindBy(how = How.XPATH, using = "//input[@class='button']")
    public WebElement btn_openAccount;

    @FindBy(how = How.XPATH, using = "//div[@id='rightPanel']/div/div/p[1]")
    public WebElement accountIsOpened;

}
