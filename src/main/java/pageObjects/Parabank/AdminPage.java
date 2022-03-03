package pageObjects.Parabank;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AdminPage {

    @FindBy(how = How.XPATH, using = "//button[@value='INIT']")
    public WebElement btn_initialization;
}
